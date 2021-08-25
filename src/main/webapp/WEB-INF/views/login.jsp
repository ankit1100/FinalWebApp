<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style type="text/css">
.error{
	color:red;
}
.myform{
	position:relative;
	left: 260px;
}
</style>
</head>
<body>
	<div class="container text-center">
		<h1 class="login display-3 text-center">Login</h1>
		<h3 class="display-10 text-center">${message}</h3>
		<s:form class="myform form-horizontal" action="verifyUser" method="post" modelAttribute="validate">
			<div class="row text-center">
				<div class="col-md-6 text-center">
					<div class="form-group">
				    	<div class="col-sm-10">
				    		<input type="hidden" name="message" class="form-control text-center" />
				    	</div>
				  	</div>
					<div class="form-group">
				    	<s:label class="control-label col-sm-2 text-center" path="email">Email:</s:label>
				    	<div class="col-sm-10">
				    		<s:errors cssClass="error" path="email"></s:errors>
				    		<s:input type="text" path="email" class="form-control text-center" placeholder="Enter email" />
				    	</div>
				  	</div>
					<div class="form-group">
				    	<s:label class="control-label col-sm-2 text-center" path="password">Password:</s:label>
				    	<div class="col-sm-10">
				    		<s:errors cssClass="error" path="password"></s:errors>
				      		<s:input path="password" type="password" class="form-control text-center" placeholder="Enter password" />
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<div class="col-sm-offset-2 col-sm-10 text-center">
				      		<div class="checkbox text-center">
				        		<label for="remember-me"><input name="remember-me" type="checkbox" /> Remember me</label>
				      		</div>	
				    	</div>
				    </div><div>
				    
				    <a href="forgotpassword"> forgotpassword</a>
				    </div>
				    
				  	<div class="form-group">
				    	<div class="col-sm-offset-2 col-sm-10 text-center">
				      		<input type="submit" value="Login" class="btn btn-success text-center" /><br/>
				      		<h1>If you haven't registered yet then <a href="moveToRegister">Click Here</a></h1>
				    	</div>
				  	</div>
				</div>	  
			</div>
		</s:form>
	</div>
</body>
</html>