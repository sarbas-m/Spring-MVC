<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of User Doctors</title>
</head>
<body>
    <h1>List of User Doctors</h1>
    <table>
        <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>Doctor ID</th>
                <th>Doctor Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userDoctors}" var="userDoctor">
                <tr>
                    <td>${userDoctor.user.userId}</td>
                    <td>${userDoctor.user.userName}</td>
                    <td>${userDoctor.doctor.doctorId}</td>
                    <td>${userDoctor.doctor.doctorName}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
