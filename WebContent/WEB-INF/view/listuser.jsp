<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.role.roleName}</td>
                    <td><a href="<c:url value='/user/edit?id=${user.userId}'/>">Edit</a></td>
                    <td><a href="<c:url value='/user/delete?id=${user.userId}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value='/user/add'/>">Add User</a>
</body>
</html>
