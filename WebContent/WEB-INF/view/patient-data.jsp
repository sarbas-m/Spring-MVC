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
	width: 120%; /* Adjust the width as per your requirement */
	margin: 10 auto;
	background-color: #DCDCDC;
}

.banner {
	width: 100%;
	height: 100vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.45),
		rgba(0, 0, 0, 0.45)),
		url('<spring:url value="/resources/images/dddd.jpg" />');
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
<body>
	<section class="vh-100 bg-image">
		<div class="banner">
			<%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
				<div class="container h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-12 col-md-9 col-lg-7 col-xl-6">
							<div class="content">
								<h2 style="color: white;">PATIENT DETAILS</h2>
								<br>
								<!-- add our html table -->
								<table class="table table-hover" id="myTable">
									<thead class="thead-dark">
										<tr>
											<th>Patient Reg.No</th>
											<th>Patient Name</th>
											<th>Gender</th>
											<th>Blood Group</th>
											<th>Patient Reg.Date</th>
										</tr>
									</thead>
									<tr>
										<td>${patientDetails.patient.registrationNumber}</td>
										<td>${patientDetails.patient.patientName}</td>
										<td>${patientDetails.patient.patientGender}</td>
										<td>${patientDetails.patient.patientBloodGroup}</td>
										<td>${patientDetails.patient.patientCreatedOn}</td>
									</tr>
									<c:url var="consultLink" value="/doctorSarbas/diagnos">
										<c:param name="appointmentId"
											value="${patientDetails.appointmentId}"></c:param>
										<c:param name="patientId"
											value="${patientDetails.patient.patientId}"></c:param>
										<c:param name="userId" value="${userId}"></c:param>
									</c:url>
								</table>
								<div class="btn-container">
									<a href="${consultLink}" class="btn btn-info">View
										Patient History</a>
								</div>
							</div>
						</div>
						</div>
						</div>
						</div>
						</div>
						</section>
						
</body>
</html>