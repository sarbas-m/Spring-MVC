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
 a {
    color: white;
    text-decoration: none;
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





		<!-- Add our html table -->
						<button class="btn btn-primary" style="margin-left: 230px;">
					<span></span><a href="home">Home</a>
				</button>
		<input type="text" id="searchInput" placeholder="SearchJS">
		<table class="table table-hover" id="myTable">
		<thead class="thead-dark">
			<tr>
				<th>Medicine Name</th>
				<th>Company Name</th>
				<th>Quantity</th>
				
			</tr>
          <thead class="thead-dark">


			<c:forEach var="tempOrder" items="${orders}">


				


				<tr>
					
					<td>${tempOrder.medicine.medicineName}</td>
					<td>${tempOrder.medicineCompany.companyName}</td>
					<td>${tempOrder.orderQty}</td>
					<%-- <td><a href="${updateLink}">Update</a> <a
						href="${disablelink}">Disable</a></td>
 --%>
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
						var rowData = rows[i].getElementsByTagName("td");
						var rowVisible = false;

						for (var j = 0; j < rowData.length; j++) {
							if (j == 0 || j == 1) {
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



		</table>

	


</body>
</html>