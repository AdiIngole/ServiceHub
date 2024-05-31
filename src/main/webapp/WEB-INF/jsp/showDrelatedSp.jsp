<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
     <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/css" ></spring:url>
   <spring:url var="image" value="/image"></spring:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>User Services</title>

	<!-- CSS only -->
	<link rel="stylesheet" type="text/css" href="${css}/UserServicesDetail.css">
	<%@include file="Header.jsp" %>
	  </head>

<body>
<!-- ------------------cheking session -->
 <% 

response.setHeader("Cache-Control"," no-cache,no-store,must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server  

if(session.getAttribute("cuname")==null)
	{
	response.sendRedirect("UserLogin.jsp");
	}
	%>
<!-- nav bar -->
<%@ include file="UserNav.jsp" %>

<!-- ---------------------------------------------- -->
<jstl:if test="${not empty list }">

 <jstl:forEach items="${list}" var="list">
 <div class="fixed" >
  
		<div class="panel panel-info " style="margin-left: 350px;margin-right: 350px;margin-top:50px ;border-width: 5px;">
			<div class="panel-heading">
			
				<div id="text" style="display: left;"><b>Name :</b>  ${list.fname}   ${list.lname}
				
					<img class="img img-thumbnail" src='getDrelatedImg?id=${list.sp_id}' width="100px" height="150px" align="right" >
		          
				</div>
			
		</div>
			<div class="panel-body">
			<b>Designation :</b> ${list.designation}</div>
			<div class="panel-body"><b>Experience :</b>${list.experiance}</div>
			<div class="panel-body "><b>Specialization :</b> ${list.specialization }</div>
			<div class="panel-body"><b>Mobile No :</b>${list.mobNumber }</div>
			<div class="panel-body"><b>Email :</b> ${list.email }</div>
			<div class="panel-body ">
			<b>Office Address :</b> ${list.officeAddress }</div>
		  <div class="panel-body" >  <a href="getAppointmentDrsp?cuname=${cuname}&spuname=${list.userName}&spemail=${list.email}"  class="btn btn-info">Appointment</a></div>  
		</div>

	</div>
</jstl:forEach>  
 </jstl:if>
 
 <!-- --------------------------------------------------------------- -->
<jstl:if test="${!not empty list}">

<h2>Sorry This service is not available</h2>
</jstl:if>

</body>
</html>