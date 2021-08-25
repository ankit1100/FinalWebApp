<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">



</head>
<body class="mt-5 bg-warning">
	<div class="container">
		<div class="row" style="margin-top: 50px;">
			<div class="col-md-4"></div>
			<div class="col-md-4 alert alert-success">
				<div class="h2 text-center">
					<a href="userData"> Update Password</a>
					<hr>
				</div>
				<form action="saveUser" Class="form-border" method="post">

					<div class="form-group">
						<label for="pwd">New Password:</label> <input type="npassword"
							class="form-control" name="password" />
					</div>
					<div class="form-group">
						<label for="pwd">Confirm Password:</label> <input type="cpassword"
							class="form-control" name="password" />
					</div>


					<div class="text-center">
						<button type="submit" class="btn btn-primary">Update Password</button>
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>