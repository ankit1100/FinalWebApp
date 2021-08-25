<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Tracking</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<h1 class="text-center" style="color: blue;">Expense Tracking</h1><br/><br/>
	<h4 class="text-center" style="color: skyblue;">Welcome to the place where you can track your expenses as a whole...</h4>
	<div class="row">
		<div class="col-md-8">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col" class="text-center">Expense ID:</th>
			      <th class="text-center">Expense Description:</th>
			      <th class="text-center">Expense Amount:</th>
			      <th class="text-center">Expense Date:</th>
			      <th class="text-center">Status:</th>
			      <th class="text-center">Account Name:</th>
			      <th class="text-center">Payment Mode:</th>
			      <th class="text-center">Category Name:</th>
			      <th class="text-center">Sub-Category Name:</th>
			      <th class="text-center">Payee Name:</th>
			      <th class="text-center">Label Name:</th>
			      <th colspan="2" class="text-center" style="position:relative;left:50px;">Action:</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${getAllProperties[0]}" var="property">
				    <tr>
				      <th scope="row">${property.expenseId}</th>
				      <td>${property.description}</td>
				      <th>${property.amount}</th>
				      <td>${property.ExpDateTime}</td>
				      <th>${property.status}</th>
				      <td>${property.accName}</td>
				      <th>${property.paymentMethod}</th>
				      <td>${property.input_subCategory}</td>
				      <td>${property.categoryName}</td>
				      <td>${property.payeeName}</td>
				      <td>${property.labelName}</td>
				      <td><a class="glyphicon glyphicon-edit" data-target="#myModal" data-toggle="modal" href="editExpense/${property.expenseId}"></a></td>
				      <td><a class="glyphicon glyphicon-trash" href="deleteExpense/${property.expenseId}"></a></td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
			<h3 class="display-10"><a href="userHome">Go to Home Page</a></h3>
		</div>
	</div>
</div>
</body>
</html>