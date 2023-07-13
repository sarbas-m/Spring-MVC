<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<script src="path/to/script.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
#myTable {
	width: 70%; /* Adjust the width as per your requirement */
	margin: 0 auto;
	background-color: #DCDCDC;
}

.banner {
	width: 100%;
	height: 100vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.75),
		rgba(0, 0, 0, 0.75)),
		url('<spring:url value="/resources/images/medicine.jpg" />');
	background-size: cover;
	background-position: center;
	animation: scrollBackground 90s linear infinite;
}

@
keyframes scrollBackground { 0% {
	background-position: 0% 0%;
}
100%
{
background-position


:

 

0%
100%;
}
}
</style>

<body class="banner">

<table class="table table-hover" style="margin-top: 50px;" id="myTable">
	<thead class="thead-dark" >
		<tr>
			<th style="padding: 0 15px 0 15px;">PatientRegNumber</th>
			<th style="padding: 0 15px 0 15px;">PatientName</th>
			<th style="padding: 0 15px 0 15px;">PrescribedDoctor</th>
			<th style="padding: 0 15px 0 15px;">Action</th>
		</tr>
	<thead class="thead-dark">
		<c:forEach var="testpatientanddoctor" items="${medpres}">
			<c:url var="viewpatientdetails" value="testdetailsofeach">
				<c:param name="appoinmentId"
					value="${testpatientanddoctor.appointment.appointmentId}"></c:param>
			</c:url>

			<tr>
				<td style="padding: 0 15px 0 15px;">${testpatientanddoctor.patient.registrationNumber}</td>
				<td style="padding: 0 15px 0 15px;">${testpatientanddoctor.patient.patientName}</td>
				<td style="padding: 0 15px 0 15px;">${testpatientanddoctor.doctor.doctorName}</td>

				<td><button class="btn btn-primary" onclick="window.location.href='${viewpatientdetails}'">VIEW Details</button>

			</tr>


		</c:forEach>
</table>
</body>
</html>