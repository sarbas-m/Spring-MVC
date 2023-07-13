
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
    width: 100%; /* Adjust the width as per your requirement */
    margin: 0 auto;
    margin-top:-0.5%;
    background-color: #DCDCDC;
  }
  .headChange{
  
    margin-top:-1%;
  }
  body{
  
  height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.25), rgba(0, 0, 0, 0.25)),
        url('<c:url value="/resources/image/hospitalrep.jpg" />');
        background-size: cover;
        background-position: center;
        
  }
  
  
  
</style>

<script src="path/to/script.js"></script>
<meta charset="ISO-8859-1">
<title>APPOINTMENT LIST</title>
</head>
<body>
	<div>
		<h1 style="margin-left:40%;">APPOINTMENT LIST</h1>
				<button class="btn btn-primary">
			<a href="/home" style="text-decoration: none; color: white;">Home</a>
		</button>
			<input style="margin-left:15%; height:20%; width:20%;" type="text" id="searchInput"  placeholder="SearchByRegNo/Name">
		<!-- Add our html table -->
		<table class="table table-hover"
		style="margin-top:2%;" id="myTable">
			<thead class="thead-dark">
				<tr>
					<!--<th>appointmentId</th>-->
					<th>RegistrationNumber</th>
					<th>Token Number</th>
					<th>patientName</th>
					<th>Gender</th>
					<th>docterName</th>
					<th>Department</th>
					<th>appCreatedOn</th>
					<th>appValidityDate</th>
					<th>Action</th>

				</tr>
				<!-- Loop over and print our patient -->
				<c:forEach var="tempAppointment" items="${appointment}">

					<c:url var="disablelink" value="/appointment/disableappointment">
						<c:param name="appointmentId"
							value="${tempAppointment.appointmentId}"></c:param>
					</c:url>
					<c:url var="viewbill" value="/bill/viewbill">
						<c:param name="appointmentId"
							value="${tempAppointment.appointmentId}"></c:param>
						<c:param name="patientId"
							value="${tempAppointment.patient.patientId}"></c:param>
					</c:url>

					<tr>
						<!--<td>${tempAppointment.appointmentId}</td>-->
						<td>${tempAppointment.patient.registrationNumber}</td>
						<td>${tempAppointment.tokenNo}</td>
						<td>${tempAppointment.patient.patientName}</td>
						<td>${tempAppointment.patient.patientGender}</td>
						<td>${tempAppointment.doctor.doctorName}</td>
						<td>${tempAppointment.doctor.doctorSpecialization}</td>
						<td>${tempAppointment.appCreatedOn}</td>
						<td>${tempAppointment.appValidityDate}</td>

						<td><a href="${disablelink}"
							class="btn btn-primary">Disable</a>
							&nbsp;<a
							href="${viewbill}" class="btn btn-primary">view
								bill</a></td>
					</tr>
				</c:forEach>
		</table>

	</div>

	<script>
		function searchTable() {
			// Get the input value and convert it to lowercase
			var input = document.getElementById("searchInput").value
					.toLowerCase();

			// Get the table and rows
			var table = document.getElementById("myTable");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 1; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {
					if (j == 0 || j == 2) {
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