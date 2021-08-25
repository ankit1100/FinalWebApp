<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/style.css"/>">


</head>
<body>
	<div class="main">
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="resource/images/otppic.png" alt="sing up image">
						</figure>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Enter OTP</h2>
						<form class="register-form" id="login-form"
							action="newPassword">
							<div class="form-group">
								<label for="your_name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="otp" id="your_name"
									placeholder="Enter OTP" />
							</div>
						<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Submit" />
							</div>
						
						</form>
						
					</div>
				</div>
			</div>
		</section>
    
    
	</div>
	<script src="resource/vendor/jquery/jquery.min.js"></script>
	<script src="resource/js/main.js"></script>
</body>
</html>