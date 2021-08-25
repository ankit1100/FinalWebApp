<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<%-- <link href="<c:url value="/resource/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resource/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resource/js/main.js" />"></script> --%>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<a class="navbar-brand active" href="adminHome">Expense Tracker</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
		<span clas="navbar-toggle-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active">
				<a class="nav-link" href="adminHome" activated>Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Profile</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">About</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Contact</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="adminLogout">Sign Out</a>
			</li>
		</ul>
	</div>
</nav>

<div class="container-fluid">
	    <div class="row">
	        <div class="col-2 collapse show d-md-flex bg-light pt-2 pl-0 min-vh-800" id="sidebar">
	            <ul class="nav flex-column flex-nowrap overflow-hidden">
	                <li class="nav-item">
	                    <a class="nav-link text-truncate" href="#manageAccTypes" data-toggle="collapse" data-target="#manageAccTypes" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Manage Account Types</span></a>
	                    <div class="collapse" id="manageAccTypes" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item"><a class="nav-link py-0" href="#" data-target="#myModal5" data-toggle="modal" href="#"><span>Insert</span></a></li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="#"><span>Modify</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-truncate" href="#manageCategories" data-toggle="collapse" data-target="#manageCategories" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Manage Categories</span></a>
	                    <div class="collapse" id="manageCategories" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item"><a class="nav-link py-0" href="#" data-target="#myModal1" data-toggle="modal" href="#"><span>Insert</span></a></li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="manageCategories"><span>Modify</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-truncate" href="#manageLabels" data-toggle="collapse" data-target="#manageLabels" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Manage Labels</span></a>
	                    <div class="collapse" id="manageLabels" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item"><a class="nav-link py-0" href="#" data-target="#myModal2" data-toggle="modal" href="#"><span>Insert</span></a></li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="manageLabels"><span>Modify</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-truncate" href="#managePayees" data-toggle="collapse" data-target="#managePayees" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Manage Payees</span></a>
	                    <div class="collapse" id="managePayees" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item"><a class="nav-link py-0" href="#" data-target="#myModal3" data-toggle="modal" href="#"><span>Insert</span></a></li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="manageLabels"><span>Modify</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-truncate" href="#manageAccounts" data-toggle="collapse" data-target="#manageAccounts" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Manage Accounts</span></a>
	                    <div class="collapse" id="manageAccounts" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item"><a class="nav-link py-0" href="#" data-target="#myModal4" data-toggle="modal" href="#"><span>Insert Accounts</span></a></li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="manageAccounts"><span>Modify Accounts</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-truncate" href="#manageExpenses" data-toggle="collapse" data-target="#manageExpenses" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Manage Expenses</span></a>
	                    <div class="collapse" id="manageExpenses" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item"><a class="nav-link py-0" href="checkAccStatus"><span>Insert</span></a></li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="manageExpenses"><span>Modify</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link collapsed text-truncate" href="#submenu1" data-toggle="collapse" data-target="#submenu1"><i class="fa fa-table"></i> <span class="d-none d-sm-inline">Charts</span></a>
	                    <div class="collapse" id="submenu1" aria-expanded="false">
	                        <ul class="flex-column pl-2 nav">
	                            <li class="nav-item">
	                            	<a class="nav-link py-0" href="#"><span>Expense</span></a>
	                            </li>
	                            <li class="nav-item">
	                                <a class="nav-link text-truncate py-1" href="#"><span>Income</span></a>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
	            </ul>
	        </div>
	        <div class="col pt-2">
	            <h2 class="text-center" style="position:relative;top:">Welcome to our site... </h2><br/>
	                <h3 class="text-center">${message}</h3><br/>
	            <h6 class="hidden-sm-down">This is a user-friendly site where any user can manage their daily expenses which is officially called as your <u>Expense Tracker</u></h6>
	            <p class="text-center">
					Here we present this Web app where users can do multiple things from their end. Before using the Expense
					Tracker, they need to do some essential things. Firstly, they have to create an account on our application
					 otherwise this paradigm will not work properly. Nextly they need to add atleast one category, sub-category,
					  label, payee in our system manually. When they have created an account, they can then proceed further.
					  We enforce a privilege to make multiple accounts e.g, UPI, SBI, RBI and many more.
	            </p>
	        </div>
	    </div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12"><br/>
				<div class="modal fade" id="myModal1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h3>Add What you want!!!</h3>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<s:form action="categoryInsertion" modelAttribute="validate6"
										method="post">
										<s:label path="categoryName">Category Name:</s:label>
										<s:input path="categoryName" class="form-control" type="text"
											placeholder="Enter the category name..." />
										<s:errors path="categoryName" class="error"></s:errors>
										<label for="subCatName">Sub Category Name:</label>
										<input name="subCatName" class="form-control" type="text"
											placeholder="Enter the sub category name..." />
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" style="width: 200px;" value="Insert"
									class="btn btn-success" />
								</s:form>
								<input class="btn btn-primary" data-dismiss="modal"
									value="Close" />
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="myModal2">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h3>Add What you want!!!</h3>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<s:form action="labelInsertion" modelAttribute="validate9"
										method="post">
										<s:label path="labelName">Label Name:</s:label>
										<s:input path="labelName" class="form-control" type="text"
											placeholder="Enter the label name..." />
										<s:errors path="labelName" class="error"></s:errors>
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" style="width: 200px;" value="Proceed"
									class="btn btn-success" />
								</s:form>
								<input class="btn btn-primary" data-dismiss="modal"
									value="Close" />
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="myModal3">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h3>Add What you want!!!</h3>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<s:form action="payeeInsertion" modelAttribute="validate10"
										method="post">
										<s:label path="payeeName">Payee Name:</s:label>
										<s:input path="payeeName" class="form-control" type="text"
											placeholder="Enter the payee name..." />
										<s:errors path="payeeName" class="error"></s:errors>
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" style="width: 200px;" value="Add"
									class="btn btn-success" />
								</s:form>
								<input class="btn btn-primary" data-dismiss="modal"
									value="Close" />
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="myModal4">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h3>Add What you want!!!</h3>
							</div>
							<div class="modal-body">
								<s:form action="insertAccounts" modelAttribute="validate5" method="post">
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
										<s:input path="accountName" class="form-control" type="text" placeholder="Enter the Account name..." />
										<s:errors path="accountName" class="error"></s:errors>
									</div>
									<div class="form-group">
										<s:label path="accountBalance">Balance:</s:label>
										<s:input path="accountBalance" type="number" class="form-control" id="accountBalance" placeholder="Enter the balance..." />
										<s:errors path="accountBalance" class="error"></s:errors>
									</div>
							</div>
							<div class="modal-footer">
								<input type="submit" style="width: 200px;" value="Add Account"
									class="btn btn-success" />
								</s:form>
								<input class="btn btn-primary" data-dismiss="modal"
									value="Close" />
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="myModal5">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h3>Add What you want!!!</h3>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<s:form action="insertAccType" modelAttribute="validate12"
										method="post">
										<s:label path="accTypeName">Account Type Name:</s:label>
										<s:input path="accTypeName" class="form-control" type="text"
											placeholder="Enter the account type..." />
										<s:errors path="accTypeName" class="error"></s:errors>
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" style="width: 200px;" value="Save"
									class="btn btn-success" />
								</s:form>
								<input class="btn btn-primary" data-dismiss="modal"
									value="Close" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>