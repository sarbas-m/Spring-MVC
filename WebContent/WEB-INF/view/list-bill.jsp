
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BILL</title>
</head>
<body>
	<div>

		<input type="button" value="Back to Appointment"
			onclick="window.location.href='listappointment';return false;" />
		<!-- Add our html table -->
		<table>
			<tr>
				<th>patientBillId</th>
				<th>patientName</th>
				<th>age</th>
				<th>patientbillCreatedOn</th>
				<th>patientBillAmount</th>


			</tr>
			<!-- Loop over and print our patient -->
			<c:forEach var="tempBill" items="${patienBill}">

				<tr>
					<td>${tempBill.patientBillId}</td>
					<td>${tempAppointment.patient.patientName}</td>
					<td>${tempAppointment.patient.age}</td>
					<td>${tempAppointment.billCreatedOn}</td>
					<td>${tempAppointment.patientBillAmount}</td>
					
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>