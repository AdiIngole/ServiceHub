<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- decalaring spring valriable for static resources -->
<spring:url var="css" value="/css"></spring:url>
<spring:url var="image" value="/image"></spring:url>

<link rel="stylesheet" type="text/css" href="${css}/Home.css">
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<%@include file="Header.jsp"%>
<title>share Home</title>

</head>

<body>
	
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
	<div class="footer bg-dark">
		<!-- Footer -->
		<footer class="page-footer"> <!-- Footer Elements -->
		<!-- <div class="container">
			<div class="effect egeon">
				<div class="buttons">
					<ul class="list-unstyled list-inline text-center">
						<li class="list-inline-item"><a
							class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
							href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
								class="fa fa-facebook" aria-hidden="true"></i> </a></li>
								
								<li class="list-inline-item"><a
							class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
							href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
								class="fa fa-facebook" aria-hidden="true"></i> </a></li>
								
								<li class="list-inline-item"><a
							class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
							href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
								class="fa fa-facebook" aria-hidden="true"></i> </a></li>
								
								<li class="list-inline-item"><a
							class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
							href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
								class="fa fa-facebook" aria-hidden="true"></i> </a></li>
								
								<li class="list-inline-item"><a
							class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
							href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
								class="fa fa-facebook" aria-hidden="true"></i> </a></li>
					</ul> -->
					<!-- <a href="#" class="fb" title="Join us on Facebook"><i
						class="fa fa-facebook" aria-hidden="true">f</i></a> <a href="#"
						class="tw" title="Join us on Twitter"><i class="fa fa-twitter"
						aria-hidden="true"></i></a> <a href="#" class="g-plus"
						title="Join us on Google+"><i class="fa fa-google-plus"
						aria-hidden="true"></i></a> <a href="#" class="dribbble"
						title="Join us on Dribbble"><i class="fa fa-dribbble"
						aria-hidden="true"></i></a> <a href="#" class="vimeo"
						title="Join us on Vimeo"><i class="fa fa-vimeo"
						aria-hidden="true"></i></a> <a href="#" class="pinterest"
						title="Join us on Pinterest"><i class="fa fa-pinterest-p"
						aria-hidden="true"></i></a> <a href="#" class="insta"
						title="Join us on Instagram"><i class="fa fa-instagram"
						aria-hidden="true"></i></a> <a href="#" class="in"
						title="Join us on Linked In"><i class="fa fa-linkedin"
						aria-hidden="true"></i></a> -->
				<!-- </div>
			</div>
		</div> -->
		<!-- Footer Elements --> <!-- Copyright -->
		<!-- <div class="footer-copyright text-center py-3">© 2021
			Copyright:Service Hub</div> -->
		<!-- Copyright --> 
		
		<%@ include file="socialmedia.jsp"%>
		</footer>
		<!-- Footer -->
	</div>
</body>

<script src="http://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<!-- <script type="text/javascript" src="js/register.js"></script> -->


</body>
</html>