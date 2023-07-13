<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Form</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
* {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}

.banner {
	width: 100%;
	height: 100vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.75),
		rgba(0, 0, 0, 0.75)),
		url('<spring:url value="/resources/images/medicine.jpg" />');
	background-size: cover;
	background-position: center;
}

.content {
	width: 100%;
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	text-align: center;
	color: #fff;
}

.content p {
	font-size: small;
}

.card {
	color: #808080;
}
</style>
</head>
<body>
	<section class="vh-100 bg-image">
		<div class="banner">
			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
				<div class="container h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-12 col-md-9 col-lg-7 col-xl-6">
							<div class="content">
								<h1>REORDER STOCK</h1>
								<div class="card" style="border-radius: 25px; margin-top: 65px; background: #808080;">
									<div class="card-body p-5">
										<f:form action="orderMedicine" modelAttribute="orders"
											method="post">
											<f:hidden path="orderId" />

											<div class="form-group row">
												<span style="color: black;">MEDICINE NAME :</span>
												<div class="col-md-8">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="glyphicon glyphicon-user"></i></span>
														<f:select path="medicine.medicineId" id="Select" style="border: 1px solid black;" 
															required="true">
															<option value="">Select a type</option>
															<c:forEach items="${medicines}" var="mediciness">
																<option value="${mediciness.medicineId}">${mediciness.medicineName}</option>
															</c:forEach>
														</f:select>
													</div>
												</div>
											</div>

											<div class="form-group row">
												<span style="color: black;">COMPANY NAME :</span>
												<div class="col-md-8">
													<div class="input-group">
														<span class="input-group-addon"><i
															class="glyphicon glyphicon-user"></i></span>
														<f:select path="medicineCompany.companyId"
															id="companySelect" style="border: 1px solid black;"  required="true">
															<option value="">Select a type</option>
															<c:forEach items="${companies}" var="company">
																<option value="${company.companyId}">${company.companyName}</option>
															</c:forEach>
														</f:select>
													</div>
												</div>
											</div>

											<div class="form-group row">
												<span style="color: black;">QUANTITY :</span>
												<div class="col-md-8">
													<f:input path="orderQty" id="quantityInput"  style="border: 1px solid black; margin-right: 10px;" required="true" />
												</div>
											</div>

											<div class="form-group row">
												<div class="col-md-8 offset-md-4">
													<p id="quantityError" style="color: red; display: none;">Check
														Quantity.</p>
													<button type="submit" class="btn btn-primary" style="margin-right: 150px;" onclick="validateForm(event)">Save</button>

												</div>
											</div>
										</f:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
		function validateForm(event) {
			event.preventDefault();
			var quantityInput = document.getElementById('quantityInput');
			var quantityValue = parseInt(quantityInput.value.trim());
			var Select = document.getElementById('Select');
			var companySelect = document.getElementById('companySelect');

			if (Select.value === "") {
		        errorMessage += "Company name is required.\n";
		        isValid = false;
		    }
			if (companySelect.value === "") {
		        errorMessage += "Company name is required.\n";
		        isValid = false;
		    }
			

			if (isNaN(quantityValue) || quantityValue < 50 || quantityValue > 500) {
				document.getElementById('quantityError').style.display = 'block';
				return;
			}

			event.target.closest('form').submit();
		}
	</script>
		<%-- <p>
		<a href="${pageContext.request.contextPath}/medicine/list">Back to List</a>
	</p> --%>
</body>
</html>
