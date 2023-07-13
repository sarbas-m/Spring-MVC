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
    margin-top:-0.5%;
    background-color: #DCDCDC;
  }
  .headChange{
  
    margin-top:-1%;
  }
  body{
  
  height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/labback.jpg" />');
        background-size: cover;
        background-position: center;
        
  }
  
  #butthome{
  
  margin-left:60%;
  margin-top:4%;
  }
  
</style>

<script src="path/to/script.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="margin-top:2%;">
<h1 style="margin-left: 600px; color:#ffffff">TEST LIST</h1><br>
</div>




<a style="margin-left:75%;" href="showFormTest" class="btn btn-info" >ADD TEST</a><br><br>

<div style="margin-top:-1%;">
<input style="margin-left:15%; height:19%; width:20%;" type="text" id="searchInput"  placeholder="SearchByTestName">
<a href="frontpagebuttons" class="btn btn-info">HOME</a>
</div>

<table  class="table table-hover" id="myTable">
<div class="headChange">
<thead class="thead-dark">
<tr>
<th >TestNumber</th>
<th >TestName</th>
<th >LowRange</th>
<th >HighRange</th>
<th >Unit</th>
<th >TestPrice</th>
<th >AddedDate</th>
<th >Action</th>
</tr>
</thead>
</div>
<br>


<c:forEach var="listedtests" items="${testLists}">

<c:url var="updateLink" value="showTestUpdateForm">
<c:param name="testId" value="${listedtests.testId}"></c:param>
</c:url>

<c:url var="deleteLink" value="delete">
<c:param name="testId" value="${listedtests.testId}"></c:param>
</c:url>

<tr>
<td >${listedtests.testNumber}</td>
<td >${listedtests.testName}</td>
<td >${listedtests.lowRange}</td>
<td >${listedtests.highRange}</td>
<td >${listedtests.unit}</td>
<td >${listedtests.testPrice}</td>
<td >${listedtests.testCreatedOn}</td>

<td ><a href="${updateLink}" class="btn btn-info">UPDATE</a> <a href="${deleteLink}" class="btn btn-info">DELETE</a></td>
</tr>

</c:forEach>


</table>

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
	</script><br>

   

</body>
</html>