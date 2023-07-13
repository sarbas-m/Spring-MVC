<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>First Page</title>
<style>


* {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}

.banner {
	width: 100%;
	height: 100vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.45),
		rgba(0, 0, 0, 0.45)),
		url('<spring:url value="/resources/images/dddd.jpg" />');
	background-size: cover;
	background-position: center;
}

.navbar {
	width: 85%;
	margin: auto;
	padding: 35px 55px;
	display: flex;
	justify-content: center; /* Align buttons horizontally in the center */
	align-items: center; /* Align buttons vertically in the center */
	color: #fff;
}

.navbar ul {
	list-style: none;
	display: flex;
	justify-content: center;
	margin-bottom: 10px;
}

.navbar ul li {
	margin: 0 20px;
}

.navbar ul li a {
	text-decoration: none;
	color: white;
	text-transform: uppercase;
}

.navbar ul li::after {
	content: '';
	height: 3px;
	width: 0;
	background: #009688;
	position: absolute;
	left: 0;
	bottom: -10px;
	transition: 0.5s;
}

.navbar ul li:hover::after {
	width: 100%;
}

.content {
	width: 100%;
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	text-align: center;
	color: #fff;
}

.content p {
	font-size: small;
}

button {
	width: 200px;
	padding: 15px 0;
	text-align: center;
	margin: 20px 10px;
	border-radius: 25px;
	font-weight: bold;
	border: 2px solid #009688;
	background: transparent;
	color: #fff;
	cursor: pointer;
	position: relative;
	overflow: hidden;
}

span {
	background: #009688;
	height: 100%;
	width: 0;
	border-radius: 25px;
	position: absolute;
	left: 0;
	bottom: 0;
	z-index: -1;
	transition: 0.5s;
}

button:hover span {
	width: 100%;
}

button:hover {
	border: none;
}

a {
	text-decoration: none;
	color: white;
}

a:hover {
	text-decoration: none;
	color: white;
}
</style>
</head>
<body>
	<div class="banner">
	<button  class="btn btn-primary" id="logoutButtons">
					<a href="<%=request.getContextPath()%>/login/logout">LogOut</a>
				</button>
		<div class="navbar">
			<ul>
			
				<li><a href="#"> </a></li>
				<li><a href="#"> </a></li>
				<li><a href="#"> </a></li>
				<li><a href="#"> </a></li>
				<li><a href="#"> </a></li>
			</ul>
		</div>
		<div class="content">
			<h1>WELCOME ADMIN </h1>
			<p>We"ll Always Make Time For You</p>
			<div>
        
        <button><span></span>    <a href="${pageContext.request.contextPath}/user/add">Add Staff</a></button>
         <button> <span></span>   <a href="${pageContext.request.contextPath}/user/adddoc">Add Doctor</a></button>
        <button> <span></span>    <a href="${pageContext.request.contextPath}/staff/list">List Staff</a></button>
        <button> <span></span>    <a href="${pageContext.request.contextPath}/doctor/list">List Doctors</a></button>
       
    </div>
    </div>
    </div>
    
   <script>
  document.getElementById('logoutButtons').addEventListener('click', function() {
    // Perform logout actions here
    // For example, you can make an AJAX request to a logout endpoint or clear session cookies
    
    // Clear browser cache
    window.location.reload(true);
  });
</script>
</body>
</html>
