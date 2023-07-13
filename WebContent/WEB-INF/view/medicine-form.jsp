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
.card-body .form-group {
        display: flex;
        align-items: center;
    }
  
    .card-body .form-group span {
        color: black;
    }

</style>

</head>
<body>
	<section class="vh-100 bg-image">
		<div class="banner">
			<%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
			<div class="mask d-flex align-items-center h-100 gradient-custom-3">
				<div class="container h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="content">
					       <h1>ADD MEDICINE </h1>
							<div class="card" style="border-radius: 25px; margin-top: 65px; background: #808080;">
								<div class="card-body p-5">
									<f:form action="saveMedicine" modelAttribute="medicines"
										method="post" class="well form-horizontal" id="contact_form">
										<f:hidden path="medicineId" />
										<div class="form-group row">
											<span style="color: black;">MEDICINE NAME :</span>
											<div class="col-md-8">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<f:input path="medicineName" placeholder="med name"
														class="form-control" type="text" style="border: 1px solid black; margin-left: 0px;" required="true" />
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
														id="companySelect" style="border: 1px solid black;  margin-left: 0px;" required="true">
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
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<f:input path="quantity" placeholder="med name"
														class="form-control" type="text" style="border: 1px solid black;  margin-left: 50px;" required="true" />
												</div>
											</div>
										</div>
										<div class="form-group row">
											<span style="color: black;">PRICE :</span>
											<div class="col-md-8">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<f:input path="price" placeholder="med name" class="form-control" type="text" style="border: 1px solid black; margin-left: 80px;" required="true" />

												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-8 offset-md-4">
												<button type="submit" class="btn btn-primary" onclick="validateForm(event)">Save</button>

											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-8 offset-md-4">
												<%-- <p class="my-p">
													<a href="${pageContext.request.contextPath}/medicine/list">Back
														to List</a>
												</p> --%>
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
		
	</section>

	<script>
		function validateForm(event) {
			// Prevent the form from submitting
			event.preventDefault();

			// Get the form input values
			var medicineName = document
					.querySelector('input[name="medicineName"]').value;
			var quantity = document.querySelector('input[name="quantity"]').value;
			var price = document.querySelector('input[name="price"]').value;
			var companySelect = document.getElementById('companySelect');

			// Perform validation checks
			var isValid = true;
			var errorMessage = "";

			var namePattern=/^[a-zA-z0-9]+$/;

			if (medicineName.trim() === "") {
				errorMessage += "Medicine name is required.\n";
				isValid = false;
			}else if (!namePattern.test(medicineName)) {
			      errorMessage += "Enter Correct Medicine.\n";
			      isValid = false;
			    }

			if (companySelect.value === "") {
		        errorMessage += "Company name is required.\n";
		        isValid = false;
		    }

			if (quantity.trim() === "") {
				errorMessage += "Quantity is required.\n";
				isValid = false;
			}else if (isNaN(quantity) || quantity < 1 || quantity > 1000) {
			      errorMessage += "Enter Correct Quantity .\n";
			      isValid = false;
			}

			if (price.trim() === "") {
			    errorMessage += "Price is required.\n";
			    isValid = false;
			} else if (isNaN(price) || price < 1 || price > 1000000) {
			    errorMessage += "Enter correct price.\n";
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
</body>

</html>