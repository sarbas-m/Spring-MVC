<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<script>
	function validateForm(event) {
		// Prevent the form from submitting
		event.preventDefault();
		var department = document.getElementById('department');
		var department = document.getElementById('doctor');

		// Perform validation checks
		var isValid = true;
		var errorMessage = "";

		if (department.value === "") {
			errorMessage += "Department name is required.\n";
			isValid = false;
		}

		if (doctor.value === "") {
			errorMessage += "Doctor name is required.\n";
			isValid = false;
		}
		// Display validation messages
		if (!isValid) {
			alert(errorMessage);
		} else {
			// Submit the form
			event.target.closest('form').submit();
		}
	}
</script>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
        body {
            height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.25), rgba(0, 0, 0, 0.25)),
        url('<c:url value="/resources/image/hospitalrep.jpg" />');
        background-size: cover;
        background-position: center;       
            }
        
         
    </style>
<meta charset="ISO-8859-1">
<title>Save Appointment</title>
</head>
<body>
	<section class="vh-100 bg-image">
		<%--  <img src="<spring:url value="/resources/image/background4.jpg" />" alt="Image"> --%>
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 25px; margin-top: 100px;">
							<div class="card-body p-5">

								<div id="container">
									<h1 style="margin-top: -5%;">BOOK APPOINTMENT</h1>
									<!-- JSTL tag library --Form -->
									<f:form class="btn btn-outline-dark btn-sm"
										action="addappointment" modelAttribute="appointment"
										method="post">
										<!-- need to associate this data with id -->
										<f:hidden path="appointmentId" />
										<f:hidden path="appValidityDate" />
										<f:hidden path="patient.patientId" value="${patientId}" />
										<table>
											<tbody>
												<td><label>Select Department:</label></td>
												<td><f:select path="department" id="department"
														required="true">
														<option value="">Select Department</option>
														<c:forEach items="${listDoctor}" var="doc">
															<option value="${doc.doctorSpecialization}">${doc.doctorSpecialization}</option>
														</c:forEach>
													</f:select></td>
												<tr>
												<tr>
													<td><label>Select Doctor:</label></td>
													<td><f:select path="doctor.doctorId"
															required="required">
															<option value="">Select Doctor</option>
															<c:forEach items="${listDoctor}" var="doc">
																<option value="${doc.doctorId}">${doc.doctorName}</option>
															</c:forEach>
														</f:select></td>
												</tr>
												<td><label>Appointment Date:</label></td>
												<td><f:input type="datetime-local" id="datetime"
														path="appCreatedOn" min="2023-06-12T00:00"
														max="2023-06-22T23:59" required="true" /></td>
												</div>


												</tr>
												<td><input class="btn btn-outline-dark btn-sm"
													type="submit" value="save" class="save" /></td>

											</tbody>
										</table>
									</f:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		    
	</section>
	<p>
		<a
			href="${pageContext.request.contextPath}/appointment/listappointment">Back</a>
	</p>

	</div>

</body>
</html>