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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
.card-body .form-group {
	display: flex;
	align-items: center;
}

.card-body .form-group span {
	color: black;
}
</style>
</head>
<body class="banner">
	<section class="vh-100 bg-image">
		<%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="content">
							<div class="card" style="border-radius: 25px; margin-top: 65px;">
								<div class="card-body p-5">
									<div class="fa fa-hospital-o"
										style="font-size: 48px; margin-bottom: 25px;">
										<h4>MED STAR HOSPITAL</h4>
										<h5>Thiruvananthapuram,</h5>
										<h5>Kerala</h5>
									</div>
									<div style="margin-top: 40px;">
										<h6 style="margin-right: 300px;">PATIENT NAME: ${namep}</h6>
										<h6 style="margin-right: 300px;">PATIENT REG.NO : ${regp}</h6>




										<div style="margin-top: -25px;">
											</h6>
											<h6 style="margin-left: 300px; margin-bottom: 20px;">DATE
												:</h6>

										</div>
									</div>



									<table class="table table-hover" id="myTable">
										<thead class="thead-dark">
											<tr>
												<th>Medicine Name</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Total</th>
											</tr>
										<thead class="thead-dark">
											<c:forEach var="tempbilllistmed" items="${billl}"
												varStatus="status">
												<tr>
													<td>${tempbilllistmed.medicine.medicineName}</td>
													<td>${tempbilllistmed.medicine.price}</td>
													<td>${quant[status.index]}</td>
													<td>${qtys1[status.index]}</td>
												</tr>
											</c:forEach>
											<tr>
												<td></td>
												<td></td>
												<td>Total Amount</td>
												<td>${totalprice}</td>
											</tr>
									</table>

									<button class="btn btn-primary">
										<a href="home" style="text-decoration: none; color: white;">print bill</a>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
