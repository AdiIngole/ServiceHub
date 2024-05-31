<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- decalaring spring valriable for static resources -->
<spring:url var="css" value="/css"></spring:url>
<spring:url var="image" value="/image"></spring:url>
<spring:url var="js" value="/js"></spring:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${css}/ServiceProviderForAdmin.css">
<%@ include file="Header.jsp"%>
<title>service provider view</title>
</head>
<style>
.wrapper {
	width: 80%;
	height: 100%;
	margin: 0 auto;
	background: #CCC
}

.h_iframe {
	position: relative;
}

.h_iframe .ratio {
	display: block;
	width: 100%;
	height: auto;
}

.h_iframe iframe {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>

<body class="body">
	<%
	response.setHeader("Cache-Control", " no-cache,no-store,must-revalidate");//HTTP 1.0
	response.setHeader("Pragma", "no-cache");//HTTP 1.0
	response.setHeader("Expires", "0");//proxy server

	if (session.getAttribute("auname") == null) {
		response.sendRedirect("AdminLogin.jsp");
	}
	%>



	<%@include file="AdminNav.jsp"%>

	<jstl:if test="${not empty list}">
		<jstl:forEach var="list" items="${list}">
			<div class="fixed">
				<div class="card"
					style="margin-left: 100px; margin-right: 100px; margin-top: 50px; border-width: 5px;">
					<div class="card-body">
						<div class="card-title font">
							<b>SPID :</b>${list.sp_id}<br /> <b>Name :</b> ${list.fname}
							${list.lname}
						</div>

						<div class="card-text">
							<table class="table" style="text-align: left;">
								<tr>
									<td colspan="3" width="300px"><b>Designation :</b>${list.designation}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>Experience
											:</b>
										${list.experiance}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<td><b>Specialization :</b>${list.specialization}</td>
								</tr>
								<tr>
									<td colspan="2" width="50%"><b>Qualification :</b>${list.highQualification}</h45>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>University :</b> ${list.universityName } <!--</div>--></td>
								</tr>

								<tr>
									<td colspan="3"><b>Mobile No :</b> ${list.mobNumber }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>Email :</b> ${list.email }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>Adhar :</b> ${list.aadharNumber }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<td colspan="2"><b>DOB :</b> ${list.dateofbirth }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>Gender :</b> ${list.gender}&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2"><b>Office Address :</b>${list.officeAddress }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

									</td>
								</tr>
								<tr class="a">
									<td colspan="4"><b>City :</b>${list.city }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

										<b>Tahsil :</b>${list.tahsil }</h45>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>District :</b> ${list.district}</h45>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>State :</b> ${list.state }</h45></td>
								</tr>
								<tr>
									<td colspan="4"><b>Image :</b>&nbsp;<img
										src='getSPimgae?id=${list.sp_id}' width="150px" height="100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

										<b>QC :</b>&nbsp;
											<span class="imagespdf">
											<iframe id="spQF" name='spQF'
											src='getSpQualificationImg?id=${list.sp_id}' width="20%"
											height="20%" frameborder="0" allowfullscreen></iframe>
											</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>Aadhar:</b>&nbsp;
										<span class="imagespdf">
											<iframe id="spAddhar" name='spAddhar'
											src='getSpAdharImage?id=${list.sp_id}' width="20%"
											height="20%" frameborder="0" allowfullscreen></iframe>
											</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<b>Licence :</b>&nbsp;
										<span class="imagespdf">
											<iframe id="spLicense" name='spLicense'
											src='getSplicence?id=${list.sp_id}' width="20%" height="20%"
											frameborder="0" allowfullscreen></iframe>
											</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center;"><a
										href="deleteSp?id=${list.sp_id}" class="btn btn-danger">DELETE</a>

									</td>

								</tr>
							</table>
						</div>
					</div>

				</div>
			</div>
		</jstl:forEach>
	</jstl:if>

	<jstl:if test="${!not empty list}">
		<br>
		<br>
		<h3>Sorry service provider does't available</h3>
	</jstl:if>
</body>
</html>