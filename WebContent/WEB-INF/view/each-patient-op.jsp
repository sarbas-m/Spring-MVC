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


<body class="banner" >
	<section class="vh-100 bg-image">
			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
				<div class="container h-100">
					<div class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-12 col-md-9 col-lg-7 col-xl-6">
							<div class="content">
								<div class="card"
									style="border-radius: 25px; margin-top: 65px; background: #808080;">
									<div class="card-body p-5">
							<h1>PATIENT</h1>
							<br>
							<p>RegisterNum: ${patientReg}</p>
							<p>Name: ${patientName}</p>
							<p>Age: ${patientAge}</p>

							<table>
								<tr>
									<th style="padding: 0 15px 0 15px;">Medicine</th>
									<th style="padding: 0 15px 0 15px;">Dosages</th>
									<th style="padding: 0 15px 0 15px;">Dos Qty</th>
									<th style="padding: 0 15px 0 15px;">Days</th>
								</tr>
								<br>
								<c:forEach var="listeach" items="${listEachPatient}">
									<c:url var="resultadds" value="resultaddform">
										<c:param name="prescriptionId"
											value="${listeach.medicineprescription.medicinePrescriptionId}"></c:param>
									</c:url>
									<c:url var="resultadd" value="bills">
										<c:param name="appointmentId"
											value="${listeach.appointment.appointmentId}"></c:param>
									</c:url>

									<tr>
										<td style="padding: 0 15px 0 15px;">${listeach.medicine.medicineName}</td>
										<td style="padding: 0 15px 0 15px;">${listeach.dosage.dosagePattern}</td>
										<td style="padding: 0 15px 0 15px;">${listeach.dosage.dosageQty}</td>
										<td style="padding: 0 15px 0 15px;">${listeach.medicineprescription.days}</td>
									</tr>
								</c:forEach>
							</table>
							<button class="btn btn-primary" style="margin-left: 150px; margin-top: 20px">
								<a href="${resultadd}"
									style="color: inherit; text-decoration: none;">Bill
									Generate</a>
							</button>

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
