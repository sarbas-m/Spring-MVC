<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<script src="path/to/script.js"></script>

<head>
<meta charset="ISO-8859-1">
<title>Save Form</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
body {
	width: 100%;
	height: 100vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.45),
		rgba(0, 0, 0, 0.45)),
		url('<spring:url value="/resources/images/dddd.jpg" />');
	background-size: cover;
	background-position: center;
}

.bordered-table {
	border-collapse: separate;
	border-spacing: 10px; /* Adjust the spacing value as needed */
}

form {
	margin-bottom: 20px;
}

form table {
	width: 100%;
}

form table td {
	padding: 10px;
}

form label {
	font-weight: bold;
}

form input[type="text"], form select {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
}

form .save {
	padding: 8px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

form .save:hover {
	background-color: #45a049;
}

/* Additional Data Styles */
#additionalDataTodayDia table, #additionalDataTodayMed table,
	#additionalDataTodayTest table, #additionalDataTodayNote table {
	width: 100%;
	border-collapse: collapse;
}

#additionalDataTodayDia table td, #additionalDataTodayMed table td,
	#additionalDataTodayTest table td, #additionalDataTodayNote table td {
	padding: 8px;
	border: 1px solid #ddd;
}
</style>

</head>

<body>
	<section class="vh-100 bg-image">
		<%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">

			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 25px; margin-top: 20px; background-color: #DCDCDC;">
							<div class="card-body p-5">
							<h4 style="margin-left: 120px;">TODAY DIAGNOS</h4>
								<f:form action="saveDiagnos" modelAttribute="diagnos"
									method="post" onsubmit="return validateDiagnosForm()">
									<!-- instance variable name -->
									<f:hidden path="appointment.appointmentId"
										value="${appointmentId}" />
									<f:hidden path="appointment.patient.patientId"
										value="${patientId}" />
									<table>
										<tr>
											<td><label><strong>Diagnos :</strong></label></td>
											<td><f:input path="diagnos" id="diagnosField"
													style="margin-right: 50px"
													pattern="[A-Za-z,][A-Za-z, ]{4,}"
													onchange="this.value = this.value.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});"
													title="Only alphabetic characters and spaces are allowed (minimum length: 5)" />
											</td>
										</tr>
										<tr>
											<td></td>
											<td><button class="btn btn-info" type="submit"
													class="save"
													style="height: 40px; width: 130px; margin-left: 22px; margin-top: 10px;">Save
													Diagnosis</button></td>
										</tr>
									</table>
								</f:form>
							</div>

							<button class="btn btn-info"
								onclick="showAdditionalDataTodayDia()"
								style="height: 40px; width: 130px; margin-left: 192px; margin-bottom: 30px;">view..
								</button>

							<div id="additionalDataTodayDia" style="display: none;">
								<div id="container">
									<table>
										<c:forEach var="tempcuurentDiagnos" items="${cuurentDiagnos}">
											<tr>
												<td>${tempcuurentDiagnos.diagnos}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<br> <br>
							<div id="container">
								<f:form action="saveMedicine"
									modelAttribute="medicinePrescription" method="post"
									onsubmit="return validateForm1()">
									<!-- instance variable name -->
									<f:hidden path="appointment.appointmentId"
										value="${appointmentId}" />
									<f:hidden path="appointment.patient.patientId"
										value="${patientId}" />
									<table>
										<tr>
											<td><f:select path="medicine.medicineId"
													name="dropdownList1" id="dropdownList1">
													<option value="">Medicine</option>
													<c:forEach items="${medicineList}" var="med">
														<option value="${med.medicineId}">${med.medicineName}</option>
													</c:forEach>
												</f:select> <span id="testError1" style="color: red; display: none;">Please
													select a med.</span> <f:select path="dosage.dosageId"
													name="dropdownList2" id="dropdownList2">
													<option value="">Dosage</option>
													<option value="1">1-1-1</option>
													<option value="2">1-0-1</option>
													<option value="3">1-0-0</option>
													<option value="4">0-1-1</option>
													<option value="5">0-0-1</option>
													<option value="6">0-1-0</option>
													<option value="7">1-1-0</option>
												</f:select> <span id="testError2" style="color: red; display: none;">Please
													select a dosage.</span></td>
											<td><label>Days :</label>
											<f:input path="days" pattern="^(?:[1-9]|[1-8][0-9]|90)$" /></td>
										</tr>
										<tr>
											<td><button class="btn btn-info" type="submit"
													class="save"
													style="height: 40px; width: 120px; margin-left: 185px;">Add
													Medicine</button></td>
										</tr>
									</table>
								</f:form>
							</div>

							<button class="btn btn-info"
								onclick="showAdditionalDataTodayMed()"
								style="height: 40px; width: 120px; margin-left: 193px;">view..
								</button>
							<div id="additionalDataTodayMed" style="display: none;">
								<div id="container">
									<table class="bordered-table">
										<c:forEach var="tempcuurentMedicineList" items="${currentMed}">
											<tr>
												<td>${tempcuurentMedicineList.medicine.medicineName}</td>
												<td>${tempcuurentMedicineList.dosage.dosagePattern}</td>
												<td>${tempcuurentMedicineList.days}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>

							<div id="container">
								<f:form action="saveTest" modelAttribute="testPrescription"
									method="post" onsubmit="return validateForm()">
									<!-- instance variable name -->
									<f:hidden path="appointment.appointmentId"
										value="${appointmentId}" />
									<table>
										<tr>
											<td><f:select path="test.testId" name="dropdownList"
													id="dropdownList">
													<option value="" disabled selected>Test</option>
													<c:forEach items="${testList}" var="test">
														<option value="${test.testId}">${test.testName}</option>
													</c:forEach>
												</f:select> <span id="testError" style="color: red; display: none;">Please
													select a test.</span></td>
										</tr>
										<tr>
											<td><button class="btn btn-info" type="submit"
													class="save"
													style="height: 40px; width: 120px; margin-left: 185px;">Add
													Test</button></td>

										</tr>
									</table>
								</f:form>
							</div>

							<button class="btn btn-info"
								onclick="showAdditionalDataTodayTest()"
								style="height: 40px; width: 120px; margin-left: 192px;">view..
								</button>
							<div id="additionalDataTodayTest" style="display: none;">
								<div id="container">
									<table>
										<c:forEach var="tempcuurentTestList"
											items="${cuurentTestList}">
											<tr>
												<td>${tempcuurentTestList.test.testName}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>

							<br> <br>

							<div id="container">
								<f:form action="saveDoctorNote" modelAttribute="doctorNote"
									method="post" onsubmit="return validateDiagnosForm1()">
									<!-- instance variable name -->
									<f:hidden path="appointment.appointmentId"
										value="${appointmentId}" />
									<table>
										<tr>
											<td><label>Note :</label></td>
											<td><f:input path="note" pattern="[A-Za-z][A-Za-z ]{4,}"
													style="margin-right: 85px;" id="diagnosField1"
													onchange="this.value = this.value.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});"
													title="Only alphabetic characters and spaces are allowed (minimum length: 5)" />
											</td>
										</tr>
										<tr>
											<td><label></label></td>
											<td><button class="btn btn-info" type="submit"
													class="save"
													style="height: 40px; width: 120px; margin-left: 88px;">Save
													Note</button></td>
										</tr>
									</table>
								</f:form>
							</div>

							<button class="btn btn-info"
								onclick="showAdditionalDataTodayNote()"
								style="height: 40px; width: 120px; margin-left: 192px;">view..
								</button>
							<div id="additionalDataTodayNote" style="display: none;">
								<div id="container">
									<table>
										<c:forEach var="tempcurrentDocNote" items="${currentDocNote}">
											<tr>
												<td>${tempcurrentDocNote.note}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>

							<c:url var="disable" value="/doctorSarbas/disableApp">
								<c:param name="appointmentId" value="${appointmentId}"></c:param>
								<c:param name="userId" value="${userId}"></c:param>
							</c:url>

							<div>
								<br> <br>
								<button class="btn btn-primary"
									style="color: white; text-decoration: none; margin-left: 170px;">
									<a onclick="showPopup()" href="${disable}"
										style="color: inherit; text-decoration: none;" >Consult
										Next Patient</a>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<script>
		function refreshPage() {
			location.reload();
		}
	</script>


	<script>
		function showAdditionalDataTodayDia() {
			var additionalData = document
					.getElementById("additionalDataTodayDia");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showAdditionalDataTodayMed() {
			var additionalData = document
					.getElementById("additionalDataTodayMed");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showAdditionalDataTodayTest() {
			var additionalData = document
					.getElementById("additionalDataTodayTest");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showAdditionalDataTodayNote() {
			var additionalData = document
					.getElementById("additionalDataTodayNote");

			// Toggle the display style of the additionalData div
			if (additionalData.style.display === "none") {
				additionalData.style.display = "block";
			} else {
				additionalData.style.display = "none";
			}
		}
	</script>
	<script>
		function showPopup() {
			alert("Consultation Completed");
		}
	</script>
	<script>
		function validateForm() {
			var testDropdown = document.getElementById("dropdownList");
			var testError = document.getElementById("testError");

			if (testDropdown.value === "") {
				testError.style.display = "block";
				return false;
			} else {
				testError.style.display = "none";
				return true;
			}
		}
	</script>
	<script>
		function validateForm1() {
			var testDropdown1 = document.getElementById("dropdownList1");
			var testDropdown2 = document.getElementById("dropdownList2");
			var testError1 = document.getElementById("testError1");
			var testError2 = document.getElementById("testError2");

			if (testDropdown1.value === "") {
				testError1.style.display = "block";
				return false;
			} else {
				if (testDropdown2.value === "") {
					testError2.style.display = "block";
					return false;
				} else {
					testError2.style.display = "none";
					return true;
				}
				testError1.style.display = "none";
				return true;
			}

		}
	</script>
	<script>
		function validateDiagnosForm() {
			var diagnosField = document.getElementById("diagnosField");
			if (diagnosField.value.trim() === "") {
				alert("Please enter a diagnos.");
				diagnosField.focus();
				return false;
			}
			return true;
		}
	</script>
	<script>
		function validateDiagnosForm1() {
			var diagnosField = document.getElementById("diagnosField1");
			if (diagnosField.value.trim() === "") {
				alert("Please enter a note.");
				diagnosField.focus();
				return false;
			}
			return true;
		}
	</script>

</body>
</html>