<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Media</title>
</head>
<body>
	<style type="text/css">
@import url("https://use.fontawesome.com/releases/v5.13.0/css/all.css");

.container {
	margin: 60px auto 0px auto;
	text-align: center;
}

.container h1 {
	font-family: 'Roboto', sans-serif;
	font-weight: 900;
	font-size: 30px;
	text-transform: uppercase;
	color: #212121;
	letter-spacing: 3px;
}

.container h1 span {
	display: inline-block;
}

.container h1 span:before, .container h1 span:after {
	content: "";
	display: block;
	/* width: 34px;
	height: 2px;
	background-color: #212121; */
	margin: 0px 0px 0px 2px;
}

.effect {
	width: 100%;
	padding: 50px 0px 70px 0px;
	/* background-color: #212121; */
}

.effect h2 {
	color: #fff;
	font-family: 'Playfair Display', serif;
	font-weight: 400;
	font-size: 25px;
	letter-spacing: 3px;
}

.effect:nth-child(2) {
	margin-top: 50px;
}

.effect:nth-child(2n+1) {
	/* background-color: #fff; */
	
}

.effect:nth-child(2n+1) h2 {
	color: #212121;
}

.effect .buttons {
	margin-top: 50px;
	display: flex;
	justify-content: center;
}

.effect a:last-child {
	margin-right: 0px;
}
/*common link styles !!!YOU NEED THEM*/
.effect {
	/*display: flex;
	 !!!uncomment this line !!!*/
	
}

.effect a {
	text-decoration: none;
	color: #fff;
	width: 60px;
	height: 60px;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: 10px;
	margin-right: 20px;
	font-size: 25px;
	overflow: hidden;
	position: relative;
}

.effect a i {
	position: relative;
	z-index: 3;
}

.effect a.fb {
	background-color: #3b5998;
}

.effect a.tw {
	background-color: #00aced;
}

.effect a.g-plus {
	background-color: #dd4b39;
}

.effect a.dribbble {
	background-color: #ea4c89;
}

.effect a.pinterest {
	background-color: #cb2027;
}

.effect a.insta {
	background-color: #bc2a8d;
}

.effect a.in {
	background-color: #007bb6;
}

.effect a.vimeo {
	background-color: #1ab7ea;
}
/* egeon effect */
.effect.egeon a {
	transition: transform 0.2s linear 0s, border-radius 0.2s linear 0.2s;
}

.effect.egeon a i {
	transition: transform 0.2s linear 0s;
}

.effect.egeon a:hover {
	transform: rotate(-90deg);
	border-top-left-radius: 50%;
	border-top-right-radius: 50%;
	border-bottom-left-radius: 50%;
}

.effect.egeon a:hover i {
	transform: rotate(90deg);
	color: white;
}
</style>

	<!-- <div class="container">
		<div class="effect egeon">
			<div class="buttons">
				<ul class="list-unstyled list-inline text-center">
					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
						href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
							class="fa fa-facebook" aria-hidden="true">f</i> </a></li>

					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
						href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
							class="fa fa-facebook" aria-hidden="true"></i> </a></li>

					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
						href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
							class="fa fa-facebook" aria-hidden="true"></i> </a></li>

					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-fb mx-1 fb" title="Join us on Facebook"
						href="https://www.facebook.com/FergussonCollegePuneOfficial"><i
							class="fa fa-facebook" aria-hidden="true"></i> </a></li>

					<li class="list-inline-item"><a target="_blank"
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
				<div class="container">

				<!-- Social buttons -->
				<ul class="list-unstyled list-inline text-center">
					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-fb mx-1"
						href="https://www.facebook.com/FergussonCollegePuneOfficial"> <i
							class="fab fa-facebook-f"> </i>
					</a></li>
					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-tw mx-1"
						href="https://twitter.com/FergussonPune"> <i class="fab fa-twitter">
						</i>
					</a></li>
					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-gplus mx-1"
						href="mailto:servicehub612@gmail.com"> <i
							class="fab fa-google-plus-g"> </i>
					</a></li>
					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-li mx-1"
							href="https://www.linkedin.com/school/fergusson-college/">  <i 
							class="fab fa-linkedin-in"> </i>
					</a></li>
					<li class="list-inline-item"><a target="_blank"
						class="btn-floating btn-dribbble mx-1"
						href="https://www.instagram.com/fc_university_/"> <i
							class="fab fa-instagram"> </i>
					</a></li>
				</ul>
				<!-- Social buttons -->

			</div>
			<!-- Copyright -->
			<div class="footer-copyright text-center py-3" style="color:white;">© ${currentYear} Copyright
				:Service Hub</div>
			<!-- Copyright -->

</body>
</html>