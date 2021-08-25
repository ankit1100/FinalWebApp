<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	
<style type="text/css">
.error{
	color: red;
}
</style>
</head>

<body>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<h3 class="display-10 text-center">${message}</h3>
			<s:form action="saveUser" name="myForm" method="post" modelAttribute="validate3">
				<div class="form-group">
					<s:label path="firstName">First Name:</s:label>
					<s:input type="text" class="form-control" path="firstName" id="firstName"
						 placeholder="Enter your first name" />
					<s:errors path="firstName" class="error"></s:errors>
				</div>
				<div class="form-group">
					<s:label path="phone">Contact Number</s:label>
					<s:input type="number" path="phone" name="phone" class="form-control" id="phone"
						 placeholder="Enter your phone" />
					<s:errors path="phone" class="error"></s:errors>
					<span id="viewError1" style="color:red;"></span>
				</div>
				<div class="form-group">
					<s:label path="gender">Gender</s:label>
					<s:radiobutton path="gender" class="form-control" id="gender" value="Male" />Male
					<s:radiobutton path="gender" class="form-control" id="gender" value="Female" />Female
					<s:errors path="gender" class="error"></s:errors>
				</div>
				<div class="form-group">
					<s:label path="email">Email address</s:label>
					<s:input type="email" path="email" class="form-control" name="email" id="email" placeholder="Enter your email id" />
					<s:errors path="email" class="error"></s:errors>
					<span id="viewError2" style="color:red;"></span>
				</div>
				<div class="form-group">
					<s:label path="password">Password</s:label>
					<s:input path="password" type="password" class="form-control" id="password"
						placeholder="Enter your Password" />
					<s:errors path="password" class="error"></s:errors>
				</div>
				<input type="submit" class="btn btn-primary" value="Submit" />
			</s:form>
		</div>
	</div>
</div>
<script type="text/javascript">
function emailCheck(){
	let email = document.myForm.email.value;
	console.log(email);
	
	$.get("checkemail/"+email,function(data){
		console.log(data);
		if(data){
			$("#viewError2").text("Email Is Already Exist!");
		}else{
			$("#viewError2").text("");
		}
	}).fail(function(err){
		console.log("Error: "+err);
	});
	
}
function phoneCheck(){
	let phone = document.myForm.phone.value;
	console.log(phone);
	
	$.get("checkphone/"+phone,function(data){
		console.log(data);
		if(data){
			$("#viewError1").text("contact number has created duplication!");
		}else{
			$("#viewError1").text("");
		}
	}).fail(function(err){
		console.log("Error: "+err);
	});
}

$(document).ready(function(){
	$("#email").blur(function(){
		emailCheck();
	})
	$("#phone").blur(function(){
		phoneCheck();
	})
});

</script>
</body>
</html>
