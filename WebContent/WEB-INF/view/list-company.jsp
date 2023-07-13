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
</head>
<body class="banner">
	<div id="container">
		<button onclick="window.location.href='showFormCom';"
			class="btn btn-primary" style="margin-left: 200px; margin-top: 20px;">Add
			Company</button>
		<button class="btn btn-primary" style="margin-top: 16px;">
			<span></span><a href="home">Home</a>
		</button>
		<input
			style="margin-left: 500px; margin-top: 25px; width: 300px; height: 45px; padding-left: 40px; background-image: url('search-logo.png'); background-repeat: no-repeat; background-position: left center;"
			type="text" id="searchInput" placeholder="Search By ComNo./Name">

		<!-- Add our html table -->
		<table class="table table-hover" id="myTable"
			style="margin-top: 30px;">
			<thead class="thead-dark">
				<tr>
					<th>Company Number</th>
					<th>Company name</th>
					<th>Company Created Date</th>

				</tr>
			<thead class="thead-dark">



				<c:forEach var="tempCompany" items="${companys}">


					<c:url var="updateLink" value="/medicine/showFormUpdate">
						<c:param name="companyId" value="${tempCompany.companyId}" />
					</c:url>



					<tr>
						<td>${tempCompany.companyNumber}</td>
						<td>${tempCompany.companyName}</td>
						<td>${tempCompany.companyCreatedOn}</td>



						<%-- <a href="${disablelink}">Disable</a> --%>
						</td>

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
								if (j == 1 || j == 2) {
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

	</div>


</body>
</html>