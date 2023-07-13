<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script src="path/to/script.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>CMS</title>
<style>


* {
margin: 0;
padding: 0;
font-family: sans-serif;
}

 body {
        height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.35)),
        url('<c:url value="/resources/images/login.jpg" />');
        background-size: cover;
        background-position: center;
    }
</style>
</head>
<body class="banner">

<div class="row m-auto d-flex justify-content-center">
<input type="hidden" id="errorMessage" value="${errorMessage}">
<h1 class=" p-4 mt-4 d-flex justify-content-center" style="color: white;">MED STAR HOSPITAL</h1>

</div>

<div class="container bg-dark bg-gradient rounded w-50 pb-5 mt-5" id="loginContainer">
    <div class="row">
        <h3 class="text-center text-light p-4">Login</h3>
    </div>
    <div class="container rounded w-50">
        <f:form action="login/mapUser" modelAttribute="user" method="post">
            <div class="row bg-light rounded">
                <div class="col-3">
                    <label class="form-label mt-1">Username</label>
                </div>
                <div class="col">
                    <f:input path="userName" type="text" placeholder="Enter Username" class="form-control" required="true"/> 
                    
                </div>
            </div>
            
            <div class="row bg-light mt-3 rounded">
                <div class="col-3">
                    <label class="form-label mt-1">Password</label>
                </div>
                <div class="col">
                    <f:input path="passWord" type="password" placeholder="Enter Password" class="form-control" required="true" /> 
                    
                </div>

            </div>

            <!-- Submit -->
            <div class="row mt-4">
                <button class="btn btn-secondary" type="submit" ><b>Login</b></button>
            </div>
        </f:form>
    </div>
</div>

<script>
    var errorMessage = document.getElementById("errorMessage").value;
    if (errorMessage) {
        alert(errorMessage);
    }
</script>


</body>
</html>