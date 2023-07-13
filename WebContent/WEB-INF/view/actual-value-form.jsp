<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        
    
<!DOCTYPE html>
<html>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<style>

  #myTable {
    width: 50%; /* Adjust the width as per your requirement */
    margin: 0 auto;
  }
</style>
<style>
  /* Override Bootstrap styles for the form */
  #myTable {
    width: 50%;
    margin: 0 auto;
  }

  /* Style the form label */
  label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
  }

  /* Style the form input field */
  input[type="text"], input[type="submit"] {
    width: 15%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  /* Style the submit button */
  input[type="submit"] {
    background-color: #0041c2;
    color: white;
    cursor: pointer;
    width:8%;
  }

  /* Add some spacing below the form */
  #myForm {
    margin-bottom: 20px;
  }
  .tableChange{
      
      margin-top:4%;
            
      
  }
  .myForm{
  
      margin-left:25%;
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

<h1 style="margin-left: 600px; margin-top:3%; color:#ffffff;">Result Adding Form</h1>
<div class="tableChange">
<table class="table table-hover" id="myTable" style="background-color: #DCDCDC;">
<thead class="thead-dark">

<tr>
<th  style="padding:0 15px 0 15px;">TestName</th>
<th  style="padding:0 15px 0 15px;">LowValue</th>
<th  style="padding:0 15px 0 15px;">HighValue</th>
<th  style="padding:0 15px 0 15px;">Unit</th>

</tr>
</thead>

<c:forEach var="patientTestWithPres" items="${patientTestDisplayWithPres}">
<tr>
<td  style="padding:0 15px 0 15px;">${patientTestWithPres.test.testName}</td>
<td  style="padding:0 15px 0 15px;">${patientTestWithPres.test.lowRange}</td>
<td  style="padding:0 15px 0 15px;">${patientTestWithPres.test.highRange}</td>
<td  style="padding:0 15px 0 15px;">${patientTestWithPres.test.unit}</td>


</tr>

</c:forEach>


</table>
</div>
<br><br>
<div class="myForm">
<f:form action="addTheActualValue" modelAttribute="actualvalueadd" method="get">
<f:hidden path="testReportId"/>
<f:hidden path="testPrescription.testPrescriptionId" value="${prescribedId}" />
<label style="color:#ffffff;">Enter The Result</label>
<f:input path="testActualValue" pattern="[1-9][0-9]*" title="digits only allowed zero not allowed"/>
<input type="submit" value="ADD">

</f:form>
</div>

</body>
</html>