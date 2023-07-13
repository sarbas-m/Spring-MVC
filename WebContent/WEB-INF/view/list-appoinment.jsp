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

<body class="banner"><!-- <br>
	<br>
	<br> -->
<c:choose>
	<c:when test="${empty appoinments}">
		<p style="color:#ffffff;">No appointments for today</p>
	</c:when>
	<c:otherwise>
		<h2 style="color: white; margin-left: 250px;">
			TODAY'S APPOINTMENT
			<%
			out.print("(" + new java.util.Date() + ")");
		%>
		</h2>

		<div id="container">
			<input type="text" id="searchInput"   style="margin-left: 850px; margin-top: 50px; width: 300px; height: 45px; padding-left: 40px; background-image: url('search-logo.png'); background-repeat: no-repeat; background-position: left center;" margin-top: 50px; width: 300px; height: 45px; padding-left: 40px; background-image: url('search-logo.png'); background-repeat: no-repeat; background-position: left center;"
				placeholder="SearchByToken/Name/Reg.NO">

			<table class="table table-hover" style="margin-top: 20px;"  id="myTable">
				<thead class="thead-dark">
					<tr>
						<th>Token No</th>
						<th>Patient Reg.No</th>
						<th>Patient Name</th>
						<th>Gender</th>
						<th>Blood Group</th>
						<th>Mobile</th>
						<th>Action</th>
					</tr>
				</thead>

				<!-- loop over and print our customers -->
				<c:forEach var="tempappoinments" items="${appoinments}">
					<!-- Construct a delete link with customer id -->
					<c:url var="consultLink" value="/doctorSarbas/patient">
						<c:param name="appointmentId"
							value="${tempappoinments.appointmentId}"></c:param>
						<c:param name="patientId"
							value="${tempappoinments.patient.patientId}"></c:param>
						<c:param name="tokenNo" value="${tempappoinments.tokenNo}"></c:param>
						<c:param name="userId" value="${userId}"></c:param>
					</c:url>
					
					<c:url var="homes" value="/doctorSarbas/home">

						<c:param name="userId" value="${userId}"></c:param>
					</c:url>

					<tr>
						<td>${tempappoinments.tokenNo}</td>
						<td>${tempappoinments.patient.registrationNumber}</td>
						<td>${tempappoinments.patient.patientName}</td>
						<td>${tempappoinments.patient.patientGender}</td>
						<td>${tempappoinments.patient.patientBloodGroup}</td>
						<td>${tempappoinments.patient.patientPhoneNumber}</td>
						<td><a href="${consultLink}"
							 class="btn btn-info">Consult</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:otherwise>
</c:choose>
<br><br>
<a href="${homes}" class="btn btn-primary" style="margin-left: 210px;">Home</a>


<script>
	function searchTable() {
		// Get the input value and convert it to lowercase
		var input = document.getElementById("searchInput").value.toLowerCase();

		// Get the table and rows
		var table = document.getElementById("myTable");
		var rows = table.getElementsByTagName("tr");

		// Loop through each row and hide/show based on search input
		for (var i = 1; i < rows.length; i++) {
			var rowData = rows[i].getElementsByTagName("td");
			var rowVisible = false;

			for (var j = 0; j < rowData.length; j++) {
				if (j == 0 || j == 1 || j == 2) {
					var cellValue = rowData[j].textContent
							|| rowData[j].innerText;
					if (cellValue.toLowerCase().indexOf(input) > -1) {
						rowVisible = true;
						break;
					}
				}
			}

			rows[i].style.display = rowVisible ? "" : "none";
		}
	}

	var searchInput = document.getElementById("searchInput");
	searchInput.addEventListener("keyup", searchTable);
</script>
</body>
</html>