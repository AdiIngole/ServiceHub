<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- decalaring spring valriable for static resources -->
<spring:url var="css" value="/css"></spring:url>
<spring:url var="image" value="/image"></spring:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${css}/Home.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="Header.jsp"%>
<title>Insert title here</title>
<script>
function showHidePassword() {
	  var x = document.getElementById("password");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
}
</script>
</head>
<body>

	<%
	response.setHeader("Cache-Control", " no-cache,no-store,must-revalidate");//HTTP 1.0
	response.setHeader("Pragma", "no-cache");//HTTP 1.0
	response.setHeader("Expires", "0");//proxy server  

	if (session.getAttribute("uu_otp") == null) {
		response.sendRedirect("UserGetOtpFpass.jsp");
	}
	%>



	<!-- nav bar -->
	<%@ include file="navbar.jsp"%>
	<%-- <nav class="navbar navbar-expand-lg sticky-top"> <a
		class="navbar-brand" href="#"> <img src="${image}/logo.png"
		class="logo">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<i class="fa fa-bars nav-icon" aria-hidden="true"></i>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav justify-content-ends">
			<li class="nav-item active"><a class="nav-link" href="Home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="About.jsp">About
					Us</a></li>

			<li class="nav-item"><a class="nav-link" href="Contact.jsp">Contact</a>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">login/Register </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="AdminLogin.jsp">Admin</a> <a
						class="dropdown-item" href="UserLogin.jsp">User</a> <a
						class="dropdown-item" href="ServiceProviderLogin.jsp">Service
						Provider</a>
				</div></li>


		</ul>
	</div>
	</nav>
 --%>

	<!-- --------------------------------------------------- -->

	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">

			<div class="container"
				style="margin-top: 150px; color: white; background-color: #ef8172; padding: 50px; border-radius: 25px;">


				<form action="UpdateUserPassword" method="post">
					<div class="form-group">
						<label for="pass">Enter User Name:</label> <input autocomplete="off" type="text"
							class="form-control" id="email" placeholder="Enter user name"
							name="uname" required>
					</div>

					<div class="form-group">
						<label for="pass">Enter New Password:</label> <input autocomplete="off" type="password"
							class="form-control" id="password" placeholder="Enter new password"
							name="pass" required>
							<input autocomplete="off" type="checkbox"
							onclick="showHidePassword();"> <b>Show/ Hide Password</b>
					</div>

					<div class="form-group">
						<input autocomplete="off" type="submit" class="btn btn-success" value="SUBMIT">
					</div>
					${msg}
				</form>

			</div>

		</div>
		<div class="col-lg-4"></div>
	</div>



</body>
</html>