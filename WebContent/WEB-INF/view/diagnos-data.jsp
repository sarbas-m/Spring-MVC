<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="path/to/script.js"></script>
<head>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f2f2f2;
}

h3 {
	margin-top: 20px;
	color: #333333;
}

button {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: #ffffff;
	border: none;
	border-radius: 4px;
	margin-bottom: 10px;
	cursor: pointer;
}

.container {
	width: 100%;
	max-width: 1200px;
	/* Adjust the max-width value as per your requirement */
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	overflow-x: auto; /* Enable horizontal scrolling for the container */
}

table {
	width: 100%;
	table-layout: fixed;
	/* Prevent table from expanding beyond the container width */
}

th, td {
	text-align: left;
	padding: 8px;
	word-break: break-all;
	/* Break long words to prevent table cell congestion */
}

th {
	background-color: #f2f2f2;
}

.search-input {
	margin-bottom: 10px;
	padding: 5px;
	border-radius: 4px;
	border: 1px solid #ddd;
	width: 100%;
}

.table-container {
	overflow-x: auto;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<div class="container">
		<h3>DIAGNOS HISTORY</h3>
		<button onclick="showAdditionalData()">Click More</button>
		<div id="additionalData" style="display: none;">
			<c:choose>
				<c:when test="${empty dignosHistory}">
					<p>No diagnos history found</p>
				</c:when>
				<c:otherwise>
					<div class="container">
						<input type="text" id="searchInputDia" class="search-input"
							placeholder="Search..">
						<table class="table table-hover" id="myTable">
							<tr>
								<th>Diagnos</th>
								<th>Doctor name</th>
								<th>Department</th>
								<th>Date</th>
							</tr>
							<!-- loop over and print our customers -->
							<c:forEach var="tempappoinments" items="${dignosHistory}">
								<tr>
									<td>${tempappoinments.diagnos.diagnos}</td>
									<td>${tempappoinments.doctor.doctorName}</td>
									<td>${tempappoinments.doctor.doctorSpecialization}</td>
									<td>${tempappoinments.diagnos.diagnosCreatedOn}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<br> <br>

		<h3>DOCTOR NOTE HISTORY</h3>
		<button onclick="showAdditionalDataNote()">Click More</button>
		<div id="additionalDataNote" style="display: none;">
			<c:choose>
				<c:when test="${empty noteHistory}">
					<p>No note history found</p>
				</c:when>
				<c:otherwise>
					<div class="container">
						<input type="text" id="searchInputNote" class="search-input"
							placeholder="Search..">
						<table class="table table-hover" id="myTable1">
							<tr>
								<th>Doctor Note</th>
								<th>Doctor name</th>
								<th>Department</th>
								<th>Date</th>
							</tr>
							<!-- loop over and print our customers -->
							<c:forEach var="tempappoinments" items="${noteHistory}">
								<tr>
									<td>${tempappoinments.doctorNote.note}</td>
									<td>${tempappoinments.doctor.doctorName}</td>
									<td>${tempappoinments.doctor.doctorSpecialization}</td>
									<td>${tempappoinments.doctorNote.doctorNoteCreatedOn}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<br> <br>
		<h3>MEDICINE PRESCRIPTION HISTORY</h3>
		<button onclick="showAdditionalDataMed()">Click More</button>
		<div id="additionalDataMed" style="display: none;">
			<c:choose>
				<c:when test="${empty medhistory}">
					<p>No medicine prescription found</p>
				</c:when>
				<c:otherwise>
					<div class="container">
						<input type="text" id="searchInputMed" class="search-input"
							placeholder="Search..">
						<table class="table table-hover" id="myTable2">
							<tr>
								<th>Medicine name</th>
								<th>Dosage</th>
								<th>Days</th>
								<th>Doctor</th>
								<th>Department</th>
								<th>Date</th>
							</tr>
							<!-- loop over and print our customers -->
							<c:forEach var="tempappoinments" items="${medhistory}">
								<tr>
									<td>${tempappoinments.medicinePrescription.medicine.medicineName}</td>
									<td>${tempappoinments.medicinePrescription.dosage.dosagePattern}</td>
									<td>${tempappoinments.medicinePrescription.days}</td>
									<td>${tempappoinments.doctor.doctorName}</td>
									<td>${tempappoinments.doctor.doctorSpecialization}</td>
									<td>${tempappoinments.medicinePrescription.medPresCreatedOn}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<br> <br>
		<h3>TEST PRESCRIPTION HISTORY</h3>
		<button onclick="showAdditionalDataTest()">Click More</button>
		<div id="additionalDataTest" style="display: none;">
			<c:choose>
				<c:when test="${empty testHistory}">
					<p>No test prescription found</p>
				</c:when>
				<c:otherwise>
					<div class="table-container">
						<input type="text" id="searchInputTest" class="search-input"
							placeholder="Search..">
						<table class="table table-hover" id="myTable3">
							<tr>
								<th>Test name</th>
								<th>Doctor</th>
								<th>Department</th>
								<th>Date</th>
							</tr>
							<!-- loop over and print our customers -->
							<c:forEach var="tempappoinments" items="${testHistory}">
								<tr>
									<td>${tempappoinments.testPrescription.test.testName}</td>
									<td>${tempappoinments.doctor.doctorName}</td>
									<td>${tempappoinments.doctor.doctorSpecialization}</td>
									<td>${tempappoinments.testPrescription.testPresCreatedOn}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<br> <br>
		<h3>TEST REPORT HISTORY</h3>
		<button onclick="showAdditionalDataTestReport()">Click More</button>
		<div id="additionalDataTestReport" style="display: none;">
			<c:choose>
				<c:when test="${empty testReportHistory}">
					<p>No test report found</p>
				</c:when>
				<c:otherwise>
					<div class="container">
						<input type="text" id="searchInputRep" class="search-input"
							placeholder="Search..">
						<table class="table table-hover" id="myTable4">
							<tr>
								<th>Test name</th>
								<th>Low Range</th>
								<th>High Range</th>
								<th>Actual Value</th>
								<th>Unit</th>
								<th>Doctor</th>
								<th>Department</th>
								<th>Date</th>
							</tr>
							<!-- loop over and print our customers -->
							<c:forEach var="tempappoinments" items="${testReportHistory}">
								<tr>
									<td>${tempappoinments.testReport.testPrescription.test.testName}</td>
									<td>${tempappoinments.testReport.testPrescription.test.lowRange}</td>
									<td>${tempappoinments.testReport.testPrescription.test.highRange}</td>
									<td>${tempappoinments.testReport.testActualValue}</td>
									<td>${tempappoinments.testReport.testPrescription.test.unit}</td>
									<td>${tempappoinments.doctor.doctorName}</td>
									<td>${tempappoinments.doctor.doctorSpecialization}</td>
									<td>${tempappoinments.testReport.reportCreatedOn}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<c:url var="diagnos" value="/doctorSarbas/startDiagnos">
			<c:param name="appointmentId" value="${appointmentId}"></c:param>
			<c:param name="patientId" value="${patientId}"></c:param>
			<c:param name="userId" value="${userId}"></c:param>
		</c:url>
		<br> <br> <br> <a href="${diagnos}"
			class="btn btn-outline-dark btn-sm">Start Diagnosis</a>
	</div>

	<script>
		function showAdditionalData() {
			var additionalData = document.getElementById("additionalData");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showAdditionalDataNote() {
			var additionalData = document.getElementById("additionalDataNote");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>

	<script>
		function showAdditionalDataMed() {
			var additionalData = document.getElementById("additionalDataMed");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showAdditionalDataTest() {
			var additionalData = document.getElementById("additionalDataTest");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showAdditionalDataTestReport() {
			var additionalData = document
					.getElementById("additionalDataTestReport");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function searchTable() {
			var input = document.getElementById("searchInputDia").value
					.toLowerCase();
			var table = document.getElementById("myTable");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 1; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {

					var cellValue = rowData[j].textContent
							|| rowData[j].innerText;
					if (cellValue.toLowerCase().indexOf(input) > -1) {
						rowVisible = true;
						break;
					}

				}

				rows[i].style.display = rowVisible ? "" : "none";
			}
		}

		var searchInput = document.getElementById("searchInputDia");
		searchInput.addEventListener("keyup", searchTable);
	</script>
	<script>
		function searchTable() {
			var input = document.getElementById("searchInputNote").value
					.toLowerCase();
			var table = document.getElementById("myTable1");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 1; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {

					var cellValue = rowData[j].textContent
							|| rowData[j].innerText;
					if (cellValue.toLowerCase().indexOf(input) > -1) {
						rowVisible = true;
						break;
					}

				}

				rows[i].style.display = rowVisible ? "" : "none";
			}
		}

		var searchInput = document.getElementById("searchInputNote");
		searchInput.addEventListener("keyup", searchTable);
	</script>
	<script>
		function searchTable() {
			var input = document.getElementById("searchInputMed").value
					.toLowerCase();
			var table = document.getElementById("myTable2");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 1; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {

					var cellValue = rowData[j].textContent
							|| rowData[j].innerText;
					if (cellValue.toLowerCase().indexOf(input) > -1) {
						rowVisible = true;
						break;
					}

				}

				rows[i].style.display = rowVisible ? "" : "none";
			}
		}

		var searchInput = document.getElementById("searchInputMed");
		searchInput.addEventListener("keyup", searchTable);
	</script>
	<script>
		function searchTable() {
			var input = document.getElementById("searchInputTest").value
					.toLowerCase();
			var table = document.getElementById("myTable3");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 1; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {

					var cellValue = rowData[j].textContent
							|| rowData[j].innerText;
					if (cellValue.toLowerCase().indexOf(input) > -1) {
						rowVisible = true;
						break;
					}

				}

				rows[i].style.display = rowVisible ? "" : "none";
			}
		}

		var searchInput = document.getElementById("searchInputTest");
		searchInput.addEventListener("keyup", searchTable);
	</script>
	<script>
		function searchTable() {
			var input = document.getElementById("searchInputRep").value
					.toLowerCase();
			var table = document.getElementById("myTable4");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 1; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {

					var cellValue = rowData[j].textContent
							|| rowData[j].innerText;
					if (cellValue.toLowerCase().indexOf(input) > -1) {
						rowVisible = true;
						break;
					}

				}

				rows[i].style.display = rowVisible ? "" : "none";
			}
		}

		var searchInput = document.getElementById("searchInputRep");
		searchInput.addEventListener("keyup", searchTable);
	</script>


</body>
</html>