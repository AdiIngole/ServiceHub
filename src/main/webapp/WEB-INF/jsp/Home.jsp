<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<!-- decalaring spring valriable for static resources -->
<spring:url var="css" value="/css"></spring:url>
<spring:url var="image" value="/image"></spring:url>

<link rel="stylesheet" type="text/css" href="${css}/Home.css">
<link rel="shortcut icon" href="${image}/logo.ico" />
<!-- CSS only -->
<%@ include file="Header.jsp"%>
<title>Home</title>

</head>


<body>

	<div>
		<!-- navbar -->
		<%@ include file="navbar.jsp"%>
		<!---title-->
		<!-- carousel -->
		<div id="carouselExampleInterval" class="carousel slide carousel-fade"
			data-ride="carousel">
			<div class="carousel-inner division">
				<div class="carousel-item active" data-interval="10000">
					<img src="image/carsoule0.jfif" class="d-block w-100" alt="..."
						height="400px">
					<div class="carousel-caption mx-auto text-center">
						<h5 class="text-animate mb-3">Service Hub</h5>
					</div>
				</div>
				<div class="carousel-item" data-interval="2000">
					<img src="${image}/carsoule1.jpg" class="d-block w-100" alt="..."
						height="400px">
				</div>
				<div class="carousel-item">
					<img src="${image}/carsoule2.jpg" class="d-block w-100" alt="..."
						height="400px">
				</div>
				<div class="carousel-item">
					<img src="${image}/carsoule3.jpg" class="d-block w-100" alt="..."
						height="400px">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleInterval"
				role="button" data-slide="prev"> <span
				class="fa fa-chevron-left fa-lg" style="color: red;"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleInterval"
				role="button" data-slide="next"> <span
				class="fa fa-chevron-right fa-lg" style="color: red;"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
		<!-- <hr class="line mx-auto"> -->
		<!-- what we do -->
		<div class="division wwd mb-3">
			<h1 class="mx-auto text-center mb-3 wwd-heading">
				<u>What We Do</u>
			</h1>
			<p class="text-justify wwd-info">We work for establishment of
				communication between different service provider and user/ client.We
				bring multiple service provider at one place for user
				convinience.Find Thousand Services If You are Ready To Get.We have
				280,000+ live clients adverts on our site, helping you to find any
				type of services</p>
		</div>
		<!-- footer -->
		<div class="footer bg-dark text-light">
			<!-- Footer -->
			<footer class="page-footer"> <!-- Footer Elements -->
			<!-- <div class="container">

				Social buttons
				<ul class="list-unstyled list-inline text-center">
					<li class="list-inline-item"><a
						class="btn-floating btn-fb mx-1" style="background-color: #3b5998;" role="button"
						href="https://www.facebook.com/FergussonCollegePuneOfficial">
							<i class="fab fa-facebook-f"> </i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn-floating btn-tw mx-1"
						href="https://twitter.com/FergussonPune"> <i
							class="fab fa-twitter"> </i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn-floating btn-gplus mx-1"
						href="mailto:servicehub612@gmail.com"> <i
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
			<!-- <div class="footer-copyright text-center py-3">© 2021
				Copyright :Service Hub</div> -->
			<!-- Copyright --> </footer>
			<!-- Footer -->
		</div>
	</div>
</body>

<script src="http://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<!-- <script type="text/javascript" src="js/register.js"></script> -->

</html>