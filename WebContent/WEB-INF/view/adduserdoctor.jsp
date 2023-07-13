<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add User</title>
    <style></style>
</head>
<body>
    <h1>Add User</h1>
    <f:form action="save" modelAttribute="userdoctor" method="post">

        <f:hidden path="user.userId" />
        <table>
            <tbody>
                <tr>
                    <td><label for="userName">Username:</label></td>
                    <td><form:input path="userName" /></td>
                </tr>
                <tr>
                    <td><label for="passWord">Password:</label></td>
                    <td><form:input path="passWord" /></td>
                </tr>
                <tr>
                    <td><label for="roleId">Role:</label></td>
                    <td>
                        <form:select path="role.roleId">
                            <form:option value="1">Doctor</form:option>
                            <
                           
                        </form:select>
                    </td>
                </tr>
                <!-- Add more input fields for other user properties if needed -->
            </tbody>
        </table>
        <input type="submit" value="Save" class="save" />
    </f:form>

     <p>
        <a href="${pageContext.request.contextPath}/userdoctor/list">Back to List</a>
    </p>  
</body>
</html>
