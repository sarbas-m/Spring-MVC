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
    
  }
  
  .details{
  margin-left:15%;
  
  }
  .billbutton{
  
    margin-left:75%;
  
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

<h1 style="margin-left: 550px; margin-top:3%; color:#ffffff;">Test Report</h1><br>

<div class="details">
<p style="color:#ffffff;">Name : ${pname}</p>
<p style="color:#ffffff;">Age : ${page}</p>
<p style="color:#ffffff;">BloodGroup: ${pblood}</p>
<p style="color:#ffffff;">Prescribed Doctor:${doctor}</p>
</div>


<br>



<div>
<table class="table table-hover" id="myTable">
<thead class="thead-dark">
<tr>


<th>Test</th>
<th>LowRange</th>
<th>HighRange</th>
<th>ActualValue</th>
<th>Unit</th>
<th>Date</th>

</tr>
</thead>
<br>

<c:forEach var="generatinglist" items="${listbeforegeneratingreport }">

<c:url var="removeprescription" value="disablePrescription">
<c:param name="appointedId" value="${generatinglist.appointment.appointmentId }"></c:param>
</c:url>
<c:url var="billname" value="bill">
<c:param name="appointedId" value="${generatinglist.appointment.appointmentId }"></c:param>
</c:url>
<tr>


<td>${generatinglist.test.testName }</td>
<td>${generatinglist.test.lowRange }</td>
<td>${generatinglist.test.highRange }</td>
<td>${generatinglist.testreport.testActualValue }</td>
<td>${generatinglist.test.unit }</td>
<td>${generatinglist.testreport.reportCreatedOn }</td>

</tr>
<br>

</c:forEach>

</table>
</div><br>
<script>
		function showPopup() {
			alert("Bill Generating..");
		}
	</script>

<a onclick="showPopup()" href="${billname}" class="btn btn-info" style="margin-left:75%;">GENERATE BILL</a>

</body>
</html>