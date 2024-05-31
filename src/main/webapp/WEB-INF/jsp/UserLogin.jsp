<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:url var="css" value="/css"></spring:url>
<spring:url var="image" value="/image"></spring:url>
<spring:url var="js" value="/js"></spring:url>


<html>
<head>
<link rel="stylesheet" type="text/css" href="${css}/Home.css">
<link rel="stylesheet" type="text/css"
	href="${css}/UserRegistration.css">
<script src="${js}/UserRegistration.js"></script>
<%@include file="Header.jsp"%>
<title>User Login</title>
</head>
<script>
	function showHidePassword() {
		var x = document.getElementById("password1");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
</script>
<body>
	<!-- nav bar -->
	<%@ include file="navbar.jsp"%>
	<div class="main container-fluid" id="main">
		<form class="form-group" action="userLoginValidation" method="get">
			<!-- heading -->
			<h1 class="heading">Sign In for User</h1>
			<div class="control">
				<div class="row">
					<div class="col-lg-12">
						<!-- first name -->
						<label for="First name">User Name</label> <input
							autocomplete="off" type="text" name="uname" id="username1"
							placeholder="enter first name" class="form-control" required="">
						<i class="fa fa-check-circle" id="userSuccess1"></i> <i
							class="fa fa-exclamation-circle" id="userError1"></i> <span
							id="u1msg" class="errormsg">**invalid user name**</span>
					</div>
				</div>
			</div>

			<div class="control">
				<div class="row">
					<!-- password-->
					<div class="col-lg-12">
						<label for="password1">Password</label> <input autocomplete="off"
							type="password" name="pwd" id="password1" placeholder="password"
							class="form-control" required=""> <i
							class="fa fa-check-circle" id="passSuccess1"></i> <i
							class="fa fa-exclamation-circle" id="passError1"></i> <span
							id="p1msg" class="errormsg">**invalid password id**</span>
					</div>

				</div>
				<div class="row">
					<div class="col-3">
						<input autocomplete="off" type="checkbox"
							onclick="showHidePassword();"> <b>Show/ Hide Password</b>
					</div>
				</div>
			</div>
			${msg}<br> ${rmsg}<br> <br> <br>

			<p class="text-center create">
				<button class="btn btn-success" type="submit"
					onclick="loginValidation();">Login</button>
				<a href="userGetOtpFpass" class="btn btn-info">Forget User
					password</a> <a href="userRegistration" class="btn btn-info">Create
					User account</a>
			</p>

		</form>
	</div>
</body>

</html>