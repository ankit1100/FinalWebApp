<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Your Expense</title>
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
<style type="text/css">
.error{
	color:red;
}
.container .row{
	position:absolute;
	left: 500px;
	top:30px;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<s:form action="ExpenceTracking" style="border:1px solid #ccc" modelAttribute="validate8" method="post">
			  <div class="container">
			    <h1>Expense Tracking</h1>
			    <h3>${EMessage}</h3>
			    <p>Please Enter your expense by filling relevant fields</p>
			    <hr>
				<div class="form-group">
			    	<s:label path="amount">Amount:</s:label>
			    	<p><b>(Enter the amount in order to track how much expense has spent...)</b></p>
			    	<s:input class="form-control" style="width:40%;" type="text" placeholder="Enter your amount" path="amount" />
			    	<s:errors path="amount" class="error"></s:errors>
			    </div>
			    <div class="form-group">
			    	<s:label path="ExpDateTime">Date & Time Picker:</s:label>
			    	<p><b>(Choose the valid date and time when this expense has spent...)</b></p>
			    	<s:input class="form-control" style="width:40%;" type="date" path="ExpDateTime" />
			    	<s:errors path="ExpDateTime" class="error"></s:errors>
				</div>
				<div class="form-group">
					<label for="categoryName">Category:</label>
					<p><b>(Select your respective category name...)</b></p>
					<select style="width:40%;" name="categoryName" class="form-control" required>
						<option value="Select Category">Select Category</option>
						<c:forEach items="${getAllCategories}" var="getCat">
							<option value="${getCat.categoryName}">${getCat.categoryName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<s:label path="input_subCategory">Sub-Category:</s:label>
					<p><b>(Select your respective sub-category name...)</b></p>
					<s:input path="input_subCategory" type="text" class="form-control" style="width:40%;" placeholder="Enter the valid sub-category..." />
					<s:errors path="input_subCategory" class="error"></s:errors>
				</div>
				<div class="form-group">
			    	<label for="payeeName">Payee Name:</label>
			    	<p><b>(Select the valid payee name as per the expense where it spent...)</b></p>
			    	<select style="width:40%;" name="payeeName" class="form-control" required>
						<option value="Select payee name">Payees</option>
						<c:forEach items="${getAllPayees}" var="payee">
							<option value="${payee.payeeName}">${payee.payeeName}</option>
						</c:forEach>
					</select>
			    </div>
			    <div class="form-group">
			    	<label for="labelName">Label Name:</label>
			    	<p><b>(Select the valid label name as per the expense where it spent...)</b></p>
			    	<select style="width:40%;" name="labelName" class="form-control" required>
						<option value="Select label name">Labels</option>
						<c:forEach items="${getAllLabels}" var="label">
							<option value="${label.labelName}">${label.labelName}</option>
						</c:forEach>
					</select>
			    </div>
			    <div class="form-group">
					<label for="accName">Select Your Account:</label>
					<p><b>(Select your respective account name ...)</b></p>
					<select style="width:40%;" name="accName" class="form-control" required>
						<option value="Select Account">Select Account</option>
						<c:forEach items="${getAccounts}" var="account">
							<option value="${account.accountName}">${account.accountName}</option>
						</c:forEach>
					</select>
				</div>
			    <div class="form-group">
					<label for="paymentMethod">Payment Methods:</label>
					<p><b>(Select your respective payment method...)</b></p>
					<select style="width:40%;" name="paymentMethod" class="form-control" required>
						<option value="Select Account Type">Payment Methods</option>
						<c:forEach items="${getAccTypes}" var="accType">
							<option value="${accType.accTypeName}">${accType.accTypeName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<s:label path="status">Status:</s:label>
					<p><b>(Select your respective status...)</b></p>
					<s:select style="width:40%;" path="status" class="form-control">
						<option value="Status Types" selected>Status</option>
						<s:option value="Cleared">Cleared</s:option>
						<s:option value="Uncleared">Uncleared</s:option>
						<s:option value="Void">Void</s:option>
						<s:option value="Reconciled">Reconciled</s:option>
					</s:select>
					<s:errors path="status" class="error"></s:errors>
				</div>	
				<div class="form-group">
					<s:label path="description">Description</s:label>
					<p><b>(Please provide the valid description upon your respective expense...)</b></p>
					<s:input style="width:40%;" class="form-control" path="description" type="text" placeholder="please enter the valid description..." />
					<s:errors path="description" class="error"></s:errors>
				</div>
				<!-- <div class="form-group">
			    	<label for="psw-repeat"><b>Repeat Password</b></label>
			    	<input class="form-control" type="password" placeholder="Repeat Password" name="psw-repeat" />
				</div> -->
				<div class="form-group">
				    <div class="clearfix">
				      <input type="submit" style="width:40%;height:30%" class="btn btn-success" value="Save" />
				    </div>
				</div>
			  </div>
			</s:form>
		</div>
	</div>
</div>

<h1><a href="userHome">Back To Home Page</a></h1>
</body>
</html>