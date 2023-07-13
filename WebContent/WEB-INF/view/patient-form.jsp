<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<script>
	function validateForm() {
		var dropdown = document.getElementById("dropdownList");
		var dropdowns = document.getElementById("dropdownLists");

		var selectedValue = dropdown.value;
		var selectedValues = dropdowns.value;

		if (selectedValues === "") {
			alert("Please select a Gender from the dropdown.");
			return false; // Prevent form submission
		}
		if (selectedValue === "") {
			alert("Please select a BloodGroup from the dropdown.");
			return false; // Prevent form submission
		}

		return true; // Allow form submission
	}
</script>

<head>
 <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
     <style>
       body {
	background-image:
		url('<spring:url value="/resources/image/hospitalrep.jpg" />');
	background-repeat: no-repeat;
	background-size: cover;
}

table:hover {
	filter: brightness(90%);
}
    </style>
<meta charset="ISO-8859-1">
<title>ADD NEW PATIENT</title>
</head>
<body> 
<section class="vh-100 bg-image">
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
<div class="card" style="border-radius: 5px; margin-top: 90px; margin-right: 100px; background-color: #f2f2f2; box-shadow: 0 7px 4px rgba(0, 0, 0, 0.1); width: 500px;">
                            <div class="card-body p-6">

  </div>
	<div id="container" style="display: flex; justify-content: center; align-items: center;">
</div>

		<h1 style="margin-left:10%;">ADD NEW PATIENT</h1>
		<!-- JSTL tag library --Form -->
		<f:form action="savePatient" modelAttribute="patient" method="post"
			onsubmit="return validateForm()">
			<!--  need to associate this data with patient id -->
			<f:hidden path="patientId" />
			<f:hidden path="registrationNumber" />
			<table>
				<tbody>
					<tr>
						<c:if test="${patient.patientName == null}">
							<td><label>patientName:</label></td>
							<td><f:input path="patientName"
									pattern="[A-Za-z][A-Za-z\s]{1,30}[A-Za-z]$"
									title="Only letters with range of (3-30)are allowed"
									required="true" /></td>
						</c:if>
						<c:if test="${not empty patient.patientName}">
							<td><label>patientName:</label></td>
							<f:hidden path="patientName" />

							<td><f:input path="patientName" disabled="true" /></td>
						</c:if>
					</tr>
					<tr>
						<td><label>patientAddress:</label></td>
						<td><f:input path="patientAddress"
								pattern="^(?=\S*\s)(?=[^a-zA-Z]*[a-zA-Z])(?=\D*\d)[a-zA-Z\d\s',.#/-]*$"
								required="true" /></td>
					</tr>
					<tr>
						<c:if test="${patient.patientAge == 0}">
							<td><label>Age:<f:input path="patientAge"
										type="number" title="Only age from(0-99) are allowed" min="1"
										max="99" required="true" /></label></td>
						</c:if>

						<c:if test="${patient.patientAge>0}">
							<f:hidden path="patientAge" />

							<td><label>Age :<f:input path="patientAge"
										disabled="true" /></label></td>
						</c:if>
					</tr>
					<tr>
						<td><c:if test="${patient.patientBloodGroup == null}">
								<label>Blood Group :</label>
								<f:select path="patientBloodGroup" name="dropdownList"
									id="dropdownList">
									<f:option value="">-- Select an option --</f:option>
									<f:option value="O+">O+</f:option>
									<f:option value="O-">O-</f:option>
									<f:option value="A+">A+</f:option>
									<f:option value="A-">A-</f:option>
									<f:option value="B+">B+</f:option>
									<f:option value="B-">B-</f:option>
									<f:option value="AB+">AB+</f:option>
									<f:option value="AB-">AB-</f:option>
								</f:select>
							</c:if> <c:if test="${not empty patient.patientBloodGroup}">
								<f:hidden path="patientBloodGroup" />
								<label>Blood Group :</label>
								<f:input path="patientBloodGroup" disabled="true" />
							</c:if>
					</tr>
					<tr>
						<td><c:if test="${patient.patientGender == null}">
								<label>Patient Gender :</label>
								<f:select path="patientGender" name="dropdownLists"
									id="dropdownLists">
									<f:option value="">-- Select an option --</f:option>
									<f:option value="Male">Male</f:option>
									<f:option value="Female">Female</f:option>
									<f:option value="Other">Other</f:option>

								</f:select>
							</c:if> <c:if test="${not empty patient.patientGender}">
								<f:hidden path="patientGender" />

								<label>Patient Gender :</label>
								<f:input path="patientGender" disabled="true" />
							</c:if>
					</tr>

					<tr>
						<td><label>patientPhoneNumber:</label></td>
						<td><f:input path="patientPhoneNumber"
								pattern="(0/91)?[7-9][0-9]{9}$"
								title="Only 10 numbers are required" required="true" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</f:form>
		<p>
			<a href="${pageContext.request.contextPath}/patient/list">Back</a>
		</p>
  </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	</div>
</body>
</html>