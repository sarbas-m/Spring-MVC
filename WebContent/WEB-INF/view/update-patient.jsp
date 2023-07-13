<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h3>Save Patient</h3>
		<!-- JSTL tag library --Form -->
		<f:form action="updatePatient" modelAttribute="patient" method="post">
			<!--  need to associate this data with patient id -->
			<f:hidden path="patientId" />
			<table>
				<tbody>
					
					<tr>
						<td><label>patientAddress:</label></td>
						<td><f:input path="patientAddress" /></td>
					</tr>
					
					
					<tr>
						<td><label>patientPhoneNumber:</label></td>
						<td><f:input path="patientPhoneNumber" /></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</f:form>
		<p>
			<a href="${pageContext.request.contextPath}/patient/list">Back</a>
		</p>

	</div>
</body>
</html>