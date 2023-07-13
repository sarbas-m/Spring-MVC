<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/labback.jpg" />');
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
margin-top:4%;
}

.card-body .form-group span {
color: black;
}
</style>

</head>

<body>
<body class="banner" >
<h1 style="margin-left: 600px; margin-top:3%; color:#ffffff;">Test Bill</h1><br>

<section class="vh-100 bg-image">
<%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
<div class="mask d-flex align-items-center h-100 gradient-custom-3">
<div class="container h-100">
<div
class="row d-flex justify-content-center align-items-center h-100">
<div class="col-12 col-md-9 col-lg-7 col-xl-6">
<div class="content">
<div class="card"
style="border-radius: 25px; margin-top: 65px;">
<div class="card-body p-5">
<div class="fa fa-hospital-o" style="font-size:48px; margin-bottom: 25px;">
<h4>Med Star Hospital</h4>


</div>
<div style="margin-top: 40px;">
<h6 style="margin-right: 300px;">Patient Name:${name}</h6>
<h6 style="margin-right: 300px;">Patient Reg.NO:${reg}</h6>
<h6 style="margin-right: 300px;">Billnumber:${bilnums}</h6>
<h6 style="margin-right: 300px;">Date:${bilingdate}</h6>



</div>
</div>



<table class="table table-hover" id="myTable">
<thead class="thead-dark">
<tr>
<th>Test Name</th>
<th>Price</th>

</tr>
<thead class="thead-dark">
<c:forEach var="tempbilllist" items="${billlist }" varStatus="status">

<c:url var="removeprescription" value="disablePrescription">
<c:param name="appointedId" value="${generatinglist.appointment.appointmentId }"></c:param>
</c:url>
<c:url var="billname" value="bill">
<c:param name="appointedId" value="${generatinglist.appointment.appointmentId }"></c:param>
</c:url>
<tr>
<td>${tempbilllist.test.testName}</td>
<td>${tempbilllist.test.testPrice}</td>

</tr>
</c:forEach>
<tr>


<td><strong>Total Amount</strong> </td>
  <td><strong>${bill}</strong></td>
</tr>
<tr>

<td></td>
<td><a href="${pageContext.request.contextPath}/test/frontpagebuttons" class="printButton" onclick="showPopup()"  >PRINT BILL</a>
</td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</section>





  

</table><br>
<script>
		function showPopup() {
			alert("Bill Printing..");
		}
	</script>



</body>
</html>