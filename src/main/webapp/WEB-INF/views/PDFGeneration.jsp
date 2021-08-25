<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="https://raw.githack.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

</head>
<body>
	<!-- <div id="pdf">
        <table>
            <tr>
                <td>Hello</td>
                <td>Oracle Certified</td>
            </tr>
        </table>
    </div>
    <button onclick="generatePDF()"> Click Me</button> -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<button type="submit" class="btn btn-danger"
				style="position: relative; left: 900px;" onclick="generatePDF();">Generate
				Report</button>
				<%-- <ul class="nav flex-column flex-nowrap overflow-hidden">
	                <li class="nav-item">
	                   	<a class="nav-link text-truncate" href="#reportGeneration" data-toggle="collapse" data-target="#reportGeneration" ><i class="fa fa-home"></i><span class="d-none d-sm-inline">Do you want to generate report?</span></a>
	                    <div class="collapse" id="reportGeneration" aria-expanded="false">
	                       	<ul class="flex-column pl-2 nav">
	                           	<li class="nav-item">
	                           		<a class="nav-link py-0" id="getByYear"  href="#"><span>Get All Expenses By Year</span></a>
	                           	</li>
	                           	<li class="nav-item">
	                               	<a class="nav-link text-truncate py-1" id="getByMonth"  href="#"><span>Get All Expenses By Month</span></a>
	                            </li>
	                       	</ul>
	                    </div>
	                </li>
	             </ul> --%>
				<table class="table thumbnail table-striped text-center">
					<thead>
						<tr>
							<th>User ID:</th>
							<th>User Good Name:</th>
							<th>User Email ID:</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${uBean.userId}</td>
							<td>${uBean.firstName}</td>
							<td>${uBean.email}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<br />
			<br />
			<div class="col-md-8 text-center" style="position:relative;left:200px;" id="pdf">

				<table class="table thumbnail table-striped text-center" id="table1">
					<thead>
						<tr>
							<th>Years:</th>
							<th>Expense Amount:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${getExpensesByYear}" var="expenseByYear">
							<tr row="scope">
								<td col="scope">${expenseByYear.years}</td>
								<td col="scope">${expenseByYear.amount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="table thumbnail table-striped text-center" id="table2">
					<thead>
						<tr>
							<th>Months:</th>
							<th>Expense Amount:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${getExpensesByMonth}" var="expenseByMonth">
							<tr row="scope">
								<td col="scope">${expenseByMonth.months}</td>
								<td col="scope">${expenseByMonth.amount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<button type="submit" class="btn btn-warning">
				<a href="userHome">Go Back</a>
			</button>
	</div>
</body>
<script>
	function generatePDF() {
		const pdf = document.getElementById('pdf');
		html2pdf().from(pdf).save();
	}
	/* function getByMonth(){
		$("#table1").css("display:block");
	}
	function getByYear(){
		$("#table2").css("display:block");
	} */
	/* $(document).ready(function(){
		$("getByMonth")[0].click(function(event){
			event.preventDefault();
			getByMonth();
		)};
		$("getByYear")[0].click(function(event){
			event.preventDefault();
			getByYear();
		)};
		$("#PDFAction").click(){
			generatePDF();
		};
	}); */
</script>
</html>