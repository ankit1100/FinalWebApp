<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Create Your Account</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style type="text/css">
.error{
	color:red;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<h3 class="alert alert-default">${msg2}</h3>
			<s:form action="createAcc" method="post" modelAttribute="validate5">
				<div class="form-group">
					<label for="accTypeName">Account Type:</label>
					<select name="accTypeName" class="form-control">
						<option value="Select Account Type">Select Account Type</option>
						<c:forEach items="${getAccTypes}" var="accType">
							<option value="${accType.accTypeName}">${accType.accTypeName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<s:label path="accountName">Account Name:</s:label>
					<s:input path="accountName" type="text" class="form-control" id="accountName" placeholder="Enter the account Name..." />
					<s:errors path="accountName" class="error"></s:errors>
				</div>
				
				<div class="form-group">
					<s:label path="accountBalance">Balance:</s:label>
					<s:input path="accountBalance" type="number" class="form-control" id="accountBalance" placeholder="Enter the balance..." />
					<s:errors path="accountBalance" class="error"></s:errors>
				</div>
				<input type="submit" class="btn btn-primary" value="Create" />
			</s:form>
			<h3>Go back to your <a href="userHome">Home Page</a></h3>
		</div>
	</div>
</div>
</body>
</html>