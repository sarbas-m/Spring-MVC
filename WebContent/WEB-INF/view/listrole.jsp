
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>List of Roles</title>
</head>
<body>
    <h1>List of Roles</h1>
    <table>
        <thead>
            <tr>
                <th>Role ID</th>
                <th>Role Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.roleId}</td>
                    <td>${role.roleName}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

