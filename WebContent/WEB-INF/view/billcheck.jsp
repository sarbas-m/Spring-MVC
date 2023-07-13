<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
<!DOCTYPE html>
<html>
<head>
<style>

* {
margin: 0;
padding: 0;
font-family: sans-serif;
}

.banner {
height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/labback.jpg" />');
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


.card-body .form-group {
display: flex;
align-items: center;
margin-top:4%;
}

.card-body .form-group span {
color: black;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body class="banner" >

<h1  style="margin-left: 600px; margin-top:3%; color:#ffffff;">PATIENT BILL</h1><br>
<section class="vh-100 bg-image">
<%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
<div class="mask d-flex align-items-center h-100 gradient-custom-3">
<div class="container h-100">
<div
class="row d-flex justify-content-center align-items-center h-100">
<div class="col-12 col-md-9 col-lg-7 col-xl-6">
<div class="content">
<div class="card"
style="border-radius: 25px; margin-top: 65px;">
<div class="card-body p-5">
<div class="fa fa-hospital-o" style="font-size:48px; margin-bottom: 25px;">
<h4>MED STAR HOSPITAL</h4>
<h5>KERALA</h5>
</div>
<div style="margin-top: 40px;">
<h6 style="margin-right: 200px;"><strong>Patient Name:</strong> ${patientName}</h6>
<h6 style="margin-right: 200px;"><strong>Patient RegistrationNumber:</strong> ${registrationNumber}</h6>
<h6 style="margin-right: 200px;"><strong>Patient Registration Fee:</strong> ${registrfee}</h6>
<h6 style="margin-right: 200px;"><strong>Doctor Consultation Fee:</strong> ${consulfee}</h6>
<h6 style="margin-right: 200px;"><strong>Sum:</strong> ${sum}</h6>
<h6 style="margin-right: 200px;"><strong>Date:</strong> <%
			out.print("(" + new java.util.Date() + ")");
		%></h6>


<table class="table table-hover" id="myTable">
<thead class="thead-dark">
<c:forEach var="tempbill" items="${bill}">

<c:url var="billname" value="bill">
<c:param name="appointedId" value="${generatinglist.appointment.appointmentId }"></c:param>
</c:url>

<tr>
<th>PatientName</th>
<th>Registration Fee</th>
<th>Consultion fee</th>
<th>Bill Amount</th>

</tr>
<thead class="thead-dark">



<tr>

<td>${tempbill.patient.patientName}</td>
<td>${tempbill.patient.consultancyfee}</td>
<td>${tempbill.doctor.doctorConsultationFee}</td>
<td>${tempbill.patientBill.patientBillAmount}</td>

</c:forEach>

<td><strong>Total Amount</strong> </td>
  <td><strong>${sum}</strong></td>
</tr>
<tr>

</table><br>
<script>
		function showPopup() {
			alert("Bill Printing..");
		}
	</script>
<td><a href="${pageContext.request.contextPath}/bill/home"" class="printButton" onclick="showPopup()" >PRINT BILL</a>

</body>
</html>