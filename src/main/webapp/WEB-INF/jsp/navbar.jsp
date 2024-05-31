<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<!-- navbar -->
	<nav class="navbar navbar-expand-lg sticky-top">
		<a class="navbar-brand" href="#"> <img
			src="../../../image/logo.png" class="logo">
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
				<li class="nav-item"><a class="nav-link" href="about">About
						Us</a></li>

				<li class="nav-item"><a class="nav-link" href="contact">Contact</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Login/Register </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/adminlogin">Admin</a> <a
							class="dropdown-item" href="/userlogin">User</a> <a
							class="dropdown-item" href="/serviceProviderLogin">Service
							Provider</a>
					</div></li>
			</ul>
		</div>
	</nav>
</body>
</html>