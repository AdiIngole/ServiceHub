<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- decalaring spring valriable for static resources -->
<spring:url var="css" value="/css"></spring:url>
<spring:url var="image" value="/image"></spring:url>


<html>
<head>
<link rel="stylesheet" type="text/css" href="${css}/Home.css">
<%@ include file="Header.jsp"%>
<title>Contact</title>
</head>


<body>
	<!---------------------------------------------------------------------navbar----------------------------------------->
	<!-- nav-bar -->
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
			<li class="nav-item active"><a class="nav-link" href="/">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/about">About
					Us</a></li>

			<li class="nav-item"><a class="nav-link" href="/about">Contact</a>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">login/Register </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="/adminlogin">Admin</a> <a
						class="dropdown-item" href="/userlogin">User</a> <a
						class="dropdown-item" href="/serviceProviderLogin">Service
						Provider</a>
				</div></li>


		</ul>
	</div>
	</nav>
 --%>
	<div class="division contact" id="contact">
		<div class="row">
			<div class="col-lg-6">
				<div class="map-responsive" style="margin-top: 50px;">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3783.134568227861!2d73.8367231148928!3d18.522820087407663!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc2bf80982203c7%3A0xba2ba195e24b828a!2sFergusson%20College%20(Autonomous)!5e0!3m2!1sen!2sin!4v1641301251586!5m2!1sen!2sin"
						width="600" height="450" style="border: 0;" allowfullscreen=""
						loading="lazy"></iframe>

				</div>
			</div>
			<div class="col-sm-6">
				<form class="text-center" action="insertFeedback" method="post">
					<h1 class="heading1">
						<u>Get In Touch</u>
					</h1>
					<input autocomplete="off" type="text" name="name" class="form-control mb-3"
						placeholder="user name/Company name" required> <input autocomplete="off"
						type="number" name="mob" class="form-control mb-3"
						placeholder="Enter mobile number" required> <input autocomplete="off"
						type="email" name="mail" class="form-control mb-3"
						placeholder="user email id" required> <select
						class="form-control mb-3" name="position" required>
						<option value="user">User</option>
						<option value="service provider">Service Provider</option>
					</select>
					<textarea class="form-control mb-3"
						placeholder="Enter Your Message" cols="10" rows="8"
						name="feedback" required></textarea>
					<button class="btn btn-success btn-lg btn-floating btn-block">Submit</button>
					<h3>${fmsg}</h3>
				</form>

			</div>

		</div>
		<div class="row text-center">
			<div class="col-md-4 mb-5">
				<i class="fa fa-home"></i>
				<h1 class="heading1">Address</h1>
				<p>
					Fergusson College Shivajinagar,<br> Pune, Maharashtra 411005
				</p>
			</div>
			<div class="col-md-4 mb-5">
				<i class="fa fa-envelope"></i>
				<h1 class="heading1">Email Id</h1>
				<p>
					<a href="mailto:servicehub612@gmail.com">servicehub612@gmail.com</a>
				</p>
			</div>
			<div class="col-md-4 mb-5">
				<i class="fa fa-phone"></i>
				<h1 class="heading1">Phone No</h1>
				<p>7841087481</p>
			</div>

		</div>

	</div>
	<!-- footer -->
	<div class="footer bg-dark text-light">
		<!-- Footer -->
		<footer class="page-footer"> <!-- Footer Elements -->
		<!-- <div class="container">

			Social buttons
			<ul class="list-unstyled list-inline text-center">
				<li class="list-inline-item"><a
					class="btn-floating btn-fb mx-1"
					href="https://www.facebook.com/FergussonCollegePuneOfficial"> <i
						class="fab fa-facebook-f"> </i>
				</a></li>
				<li class="list-inline-item"><a
					class="btn-floating btn-tw mx-1"
					href="https://twitter.com/FergussonPune"> <i
						class="fab fa-twitter"> </i>
				</a></li>
				<li class="list-inline-item"><a
					class="btn-floating btn-gplus mx-1"
					href="mailto:servicehub78410@gmail.com"> <i
						class="fab fa-google-plus-g"> </i>
				</a></li>
				<li class="list-inline-item"><a
					class="btn-floating btn-li mx-1"
					href="https://www.linkedin.com/in/adinath-ingole-0061a7209/ "><i
						class="fab fa-linkedin-in"> </i> </a></li>
				<li class="list-inline-item"><a
					class="btn-floating btn-dribbble mx-1"
					href="https://www.instagram.com/_bhushan_patil07_/"> <i
						class="fab fa-instagram"> </i>
				</a></li>
			</ul>
			Social buttons

		</div> -->
		<%@ include file="socialmedia.jsp"%>
		<!-- Footer Elements --> <!-- Copyright -->
		<!-- <div class="footer-copyright text-center py-3">© 2021 Copyright
			:Service Hub</div> -->
		<!-- Copyright --> </footer>
		<!-- Footer -->
	</div>
</body>
</html>