<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<style>

  #myTable {
    width: 70%; /* Adjust the width as per your requirement */
    margin: 0 auto;
            background-color: #DCDCDC;
            margin-top:-5.8%;
    
  }
  .repTable{
  
  margin-top:6%
  }
  body{
   height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/labback.jpg" />');
        background-size: cover;
        background-position: center;
  }
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="margin-left: 550px; margin-top:3%;color:#ffffff;"> Report Management</h1>
<input style="margin-left:15%; height:5%; width:20%;margin-top:5%;" type="text" id="searchInput"  placeholder="SearchByPatientName/Regnum">
<div class="repTable">
<table class="table table-hover" id="myTable">
<thead class="thead-dark">
<tr>
<th>PatientRegNum</th>
<th>PatientName</th>
<th></th>
</tr>
</thead>
<c:forEach var="frontpageappoint" items="${reportfrontlist}">
<c:url var="repowithappoint" value="allreportfront">
<c:param name="appointingId" value="${frontpageappoint.appointment.appointmentId }" >

</c:param>
</c:url>

<tr>
<td>${frontpageappoint.patient.registrationNumber }</td>
<td>${frontpageappoint.patient.patientName }</td>
<td><a onclick="showPopup()" href="${repowithappoint}" class="btn btn-info">GENERATE REPORT</a></td>

</tr>


</c:forEach>
</table>
</div>
<script>
		function showPopup() {
			alert("Report Generating..");
		}
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
</body>
</html>