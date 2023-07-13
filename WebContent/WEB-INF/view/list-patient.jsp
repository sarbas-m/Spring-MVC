
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
	width: 90%; /* Adjust the width as per your requirement */
	margin: 0 auto;
	margin-top: 1.5%;
	background-color: #DCDCDC;
}

.headChange {
	margin-top: -1%;
}

body {
	height: 100vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.25),
		rgba(0, 0, 0, 0.25)),
		url('<c:url value="/resources/image/hospitalrep.jpg" />');
	background-size: cover;
	background-position: center;
}
</style>
<script src="path/to/script.js"></script>
<meta charset="ISO-8859-1">
<title>PATIENT LIST</title>
</head>

<body>
	<div>
		<h1 style="margin-left: 40%;">PATIENT LIST</h1>
		<input type="button" style="margin-left: 5%;" class="btn btn-primary"
			value="Add Patient"
			onclick="window.location.href='showFormAdd';return false;" /> <input
			style="margin-left: 5%;"
			"margin-bottom:10%;"height:30%; width:20%;" type="text"
			id="searchInput" placeholder="SearchByRegNo/PhoneNo">
		<button class="btn btn-primary">
			<a href="home" style="text-decoration: none; color: white;">Home</a>
		</button>
		<!-- Add our html table -->
		<table class="table table-hover" id="myTable">
			<thead class="thead-dark">
				<tr>
					<!--<th>patientId</th>-->
					<th>RegistrationNumber</th>
					<th>Name</th>
					<th>Age</th>
					<th>BloodGroup</th>
					<th>Gender</th>
					<th>PhoneNumber</th>
					<th>Address</th>
					<th>CreatedOn</th>
					<th>ValidityDate</th>
					<th>Action</th>


				</tr>
				<!-- Loop over and print our patient -->
				<c:forEach var="tempPatient" items="${patient}">
					<c:url var="updatelink" value="/patient/showFormForUpdate">
						<c:param name="patientId" value="${tempPatient.patientId}"></c:param>
					</c:url>
					<c:url var="disablelink" value="/patient/disable">
						<c:param name="patientId" value="${tempPatient.patientId}"></c:param>
						<c:param name="patient" value="${tempPatient}"></c:param>
					</c:url>
					<c:url var="booklink" value="/patient/book">
						<c:param name="patientId" value="${tempPatient.patientId}"></c:param>
						<c:param name="patient" value="${tempPatient}"></c:param>
					</c:url>
					<tr>
						<!--<td>${tempPatient.patientId}</td>-->
						<td>${tempPatient.registrationNumber}</td>
						<td>${tempPatient.patientName}</td>
						<td>${tempPatient.patientAge}</td>
						<td>${tempPatient.patientBloodGroup}</td>
						<td>${tempPatient.patientGender}</td>
						<td>${tempPatient.patientPhoneNumber}</td>
						<td>${tempPatient.patientAddress}</td>
						<td>${tempPatient.patientCreatedOn}</td>
						<td>${tempPatient.validityDate}</td>
						<!--<td>${tempPatient.patientIsActive}</td>-->

						<td><a href="${updatelink}" class="btn btn-primary">Update</a>&nbsp;<a
							href="${disablelink}" class="btn btn-primary">Disable</a>&nbsp;<a
							href="${booklink}" class="btn btn-primary">Book</a></td>
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
					if (j == 0 || j == 5) {
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