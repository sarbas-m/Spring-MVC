<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<script src="path/to/script.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
#myTable {
	width: 70%; /* Adjust the width as per your requirement */
	margin: 0 auto;
	background-color: #DCDCDC;
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
</style>
<body class="banner">

	<div>

		<div id="container">
			<button type="button" class="btn btn-primary"
				style="margin-left: 200px;"
				onclick="window.location.href='showFormAdd';">Add Medicine</button>

			<button class="btn btn-primary">
				<a href="home" style="text-decoration: none; color: white;">Home</a>
			</button>
			<!-- Add our html table -->
			<input
				style="margin-left: 500px; margin-top: 50px; width: 300px; height: 45px; padding-left: 40px; background-image: url('search-logo.png'); background-repeat: no-repeat; background-position: left center;"
				type="text" id="searchInput"
				placeholder="Search By Medicine No./Name">




			<table class="table table-hover" id="myTable"
				style="margin-top: 30px;">
				<thead class="thead-dark">

					<tr>
						<th scope="col">Medicine Number</th>
						<th scope="col">Medicine Name</th>
						<th scope="col">Company Name</th>
						<th scope="col">Stock</th>
						<th scope="col">Price</th>
						<th scope="col">Available</th>
						<th scope="col">Action</th>
					</tr>




					<c:forEach var="tempMedicine" items="${medicines}">


						<c:url var="updateLink" value="/medicine/showFormUpdate">
							<c:param name="medicineId" value="${tempMedicine.medicineId}" />
						</c:url>
						<c:url var="deleteLink" value="/medicine/showFormDelete">
							<c:param name="medicineId" value="${tempMedicine.medicineId}" />
						</c:url>

						<c:url var="disablelink" value="/medicine/disable">
							<c:param name="medicineId" value="${tempMedicine.medicineId}" />
						</c:url>


						<tr>
							<td scope="row">${tempMedicine.medicineNumber}</td>
							<td scope="row">${tempMedicine.medicineName}</td>
							<td>${tempMedicine.medicineCompany.companyName}</td>
							<td>${tempMedicine.quantity}</td>
							<td>${tempMedicine.price}</td>
							<td>${tempMedicine.medicineIsActive}</td>
							<td><a href="${updateLink}">Update</a> <a
								href="${disablelink}">Disable</a></td>

						</tr>

					</c:forEach>





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
								var rowData = rows[i]
										.getElementsByTagName("td");
								var rowVisible = false;

								for (var j = 0; j < rowData.length; j++) {
									if (j == 0 || j == 1) {
										var cellValue = rowData[j].textContent
												|| rowData[j].innerText;
										if (cellValue.toLowerCase().indexOf(
												input) > -1) {
											rowVisible = true;
											break;
										}
									}
								}

								rows[i].style.display = rowVisible ? ""
										: "none";
							}
						}

						var searchInput = document
								.getElementById("searchInput");
						searchInput.addEventListener("keyup", searchTable);
					</script>


				</thead>
			</table>
		</div>
	</div>
</body>
</html>