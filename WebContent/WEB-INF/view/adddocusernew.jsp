<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add User</title>
    <style>
    h1 {
            text-align: center;
        }
        #userForm {
            width: 50%;
            margin: 0 auto;
            text-align: center;
            background-color: #f2f2f2;
            padding: 20px;
        }

        #userForm table {
            margin-top: 20px;
            width: 100%;
        }

        #userForm label {
            width: 180px;
            text-align: right;
            padding-right: 10px;
        }

        #userForm input[type="text"],
        #userForm input[type="password"],
        #userForm select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            box-sizing: border-box;
            background-color: #ffffff;
        }

        #userForm input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        #userForm input[type="submit"]:hover {
            background-color: #45a049;
        }

        #userForm a {
            text-decoration: none;
            color: #333333;
        }

        #userForm a:hover {
            color: #000000;
        }
        body{
 
  height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/dddd.jpg" />');
        background-size: cover;
        background-position: center;
        }
    </style>
</head>
<body>
    <h1 style="color:#ffffff;">Create User for Doctor</h1>
    <f:form action="saves" modelAttribute="user" method="post" id="userForm">

        <f:hidden path="userId" />
        <table>
            <tbody>
                <tr>
                    <td><label for="userName">Username:</label></td>
                    <td><f:input id="userName" path="userName" style="width: 100%; padding: 8px; margin: 8px 0; border: none; border-radius: 4px; box-sizing: border-box; background-color: #ffffff;" /></td>
                </tr>
                <tr>
                    <td><label for="passWord">Password:</label></td>
                    <td><f:password id="passWord" path="passWord" style="width: 100%; padding: 8px; margin: 8px 0; border: none; border-radius: 4px; box-sizing: border-box; background-color: #ffffff;" /></td>
                </tr>
                <tr>
                    <td><label for="roleId">Role:</label></td>
                    <td>
                        <f:select id="roleId" path="role.roleId" style="width: 100%; padding: 8px; margin: 8px 0; border: none; border-radius: 4px; box-sizing: border-box; background-color: #ffffff;">
                            <f:option value="0">Select Role</f:option>
                            <f:option value="3">Doctor</f:option>
                        </f:select>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Save" class="save" style="background-color: #4caf50; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;" />
    </f:form>

    <script>
    
        const userName = document.getElementById('userName');
        const password = document.getElementById('passWord');
        const roleId = document.getElementById('roleId');

        roleId.addEventListener('change', function(e) {
            if (this.value == 0) {
                alert('Please select a valid role.');
            }
        });

        document.getElementById('userForm').addEventListener('submit', function(e) {
            const userNameValue = userName.value;
            const passwordValue = password.value;

            if (roleId.value == 0) {
                alert('Please select a valid role.');
                e.preventDefault();
            }

            if (userNameValue.length < 4 || !(/[a-zA-Z]/.test(userNameValue)) || !(/\d/.test(userNameValue))) {
            	  alert('Username must be at least 4 characters and contain a mix of letters and numbers.');
            	  e.preventDefault();
            	}
            if (passwordValue.length < 4 || !(/[a-zA-Z]/.test(passwordValue)) || !(/\d/.test(passwordValue))) {
          	  alert('Username must be at least 4 characters and contain a mix of letters and numbers.');
          	  e.preventDefault();
          	}

        });
    </script>
</body>
</html>
