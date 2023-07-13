<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<style>

  #myTable {
    width: 70%; /* Adjust the width as per your requirement */
    margin: 0 auto;
        background-color: #DCDCDC;
    
  }
  body{
   height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/labback.jpg" />');
        background-size: cover;
        background-position: center;
  }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="margin-left: 550px; margin-top:3%; color:#ffffff;">TEST OF EACH PATIENT</h1><br>

<table class="table table-hover" id="myTable">
<thead class="thead-dark">

<tr>
<th >PatientName</th>
<th >Age</th>
<th >BloodGroup</th>
<th >PrescribedDoctor</th>
<th >Test</th>
<th></th>
<th></th>

</tr>
</thead>
<br>

<c:forEach var="listeach" items="${listEachPatientTest}">
<c:url var="resultadd" value="resultaddform">
<c:param name="prescriptionId" value="${listeach.testprescription.testPrescriptionId}"></c:param>
</c:url>

<c:url var="editResult" value="resultEditForm">
<c:param name="preId" value="${listeach.testprescription.testPrescriptionId}"></c:param>
</c:url>

<tr>
<td >${listeach.patient.patientName}</td>
<td >${listeach.patient.patientAge}</td>
<td >${listeach.patient.patientBloodGroup}</td>
<td >${listeach.doctor.doctorName}</td>
<td >${listeach.test.testName}</td>
<td><a href="${resultadd}" class="btn btn-outline-dark btn-sm">ADD RESULT</a></td>
<td><a href="${editResult}" class="btn btn-outline-dark btn-sm">EDIT RESULT</a></td>



</tr>

</c:forEach>

</table>

</body>
</html>