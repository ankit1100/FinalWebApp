<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.*" %>
<%@ page import="com.bean.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role Addition</title>

<!-- -------------Link all external css or javascript files------------- -->
<%-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script> --%>
<!-- ------------------------------------------------------------------------- -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
	<body>
		<section class="vh-100" style="background-color: #eee;">
		  <div class="container h-100">
		    <div class="row d-flex justify-content-center align-items-center h-100">
		      <div class="col-lg-12 col-xl-11">
		        <div class="card text-black" style="border-radius: 25px;">
		          <div class="card-body p-md-5">
		            <div class="row justify-content-center">
		              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
		
		                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Create a role</p>
		
		                <s:form action="insertRole" method="post" class="mx-1 mx-md-4" modelAttribute="validate1">
		                <input type="hidden" name="message" />
		
		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                    <s:label class="form-label" path="roleName">Role Name</s:label>
		                      <s:input type="text" path="roleName" id="roleName" class="form-control" />
		                    </div>
		                  </div>
		                  
		                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
		                    <input type="submit" value="Add" class="btn btn-primary btn-lg" />
		                  </div>
		                </s:form>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>
		<h1><a href="roles" class="display-4">View Roles</a></h1>
	</body>
</html>