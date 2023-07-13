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
.content{
    width: 100%;
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    text-align: center;
    color: #fff;
   

}
.content p{
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
					<h1>ADD COMPANY </h1>
						<div class="card" style="border-radius: 25px; margin-top: 65px; background: #808080;">
							<div class="card-body p-4" >
							
								<f:form action="saveCompany" modelAttribute="companys"
									method="post">
									<f:hidden path="companyId" />
									<div>
										<span style="color: black;">COMPANY NAME :</span>
										<f:input path="companyName" id="companyNameInput" style="border: 1px solid black;" />
										<p id="companyNameError" style="color: red; display: none;">Enter
											a valid company name.</p>
									</div>
									<div>
										<button type="submit"  class="btn btn-primary" style="margin-left: 130px; margin-top: 10px" onclick="validateForm(event)">Save</button>

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
			event.preventDefault();
			var companyNameInput = document.getElementById('companyNameInput');
			var companyNameValue = companyNameInput.value.trim();

			var isValidFormat = /^[a-zA-Z]+$/.test(companyNameValue);
			if (!isValidFormat) {
				document.getElementById('companyNameError').style.display = 'block';
				return;
			}

			event.target.closest('form').submit();
		}
	</script>
</body>
</html>
