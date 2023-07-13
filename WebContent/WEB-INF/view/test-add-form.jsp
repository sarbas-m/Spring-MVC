<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Save Form</title>

    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <style>
        body {
            height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/labback.jpg" />');
        background-size: cover;
        background-position: center;       
            }
        
         
    </style>
</head>
<body>
   <div>
   <h1 style="margin-left: 650px; margin-top:6%; color:#ffffff;" >ADD TEST</h1>
   </div>
    <section class="vh-100 bg-image">
        <%--  <img src="<spring:url value="/resources/images/background4.jpg" />" alt="Image"> --%>
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 25px; margin-top: 65px;">
                            <div class="card-body p-5">
                                <f:form action="saveTestForm" modelAttribute="testing" method="get">
    <f:hidden path="testId" />
    <f:hidden path="testNumber"/>
<div>
    <table>
      <tr>
        <c:if test="${testing.testName == null}">
          <td><label>Test Name:</label></td>
          <td><f:input path="testName" pattern="^(?! )[\w\s]+$" title="Name with alphabets and numbers only" required="true" /></td>
        </c:if>
        <c:if test="${not empty testing.testName}">
        <f:hidden path="testName"/>
          <td><label>Test Name:</label></td>
          <td><f:input path="testName" disabled="true" /></td>
        </c:if>
      </tr>
      <tr>
        <c:if test="${testing.lowRange == 0}">
          <td><label>Low Range:</label></td>
          <td><f:input path="lowRange" pattern="\d*" title="Digits only allowed" required="true" /></td>
        </c:if>
        <c:if test="${testing.lowRange > 0}">
        <f:hidden path="lowRange"/>
          <td><label>Low Range:</label></td>
          <td><f:input path="lowRange" disabled="true" /></td>
        </c:if>
      </tr>
      <tr>
        <c:if test="${testing.highRange == 0}">
          <td><label>High Range:</label></td>
          <td><f:input path="highRange" pattern="[1-9][0-9]{0,6}" title="Digits only allowed, zero not allowed" required="true" /></td>
        </c:if>
        <c:if test="${testing.highRange > 0}">
        <f:hidden path="highRange"/>
          <td><label>High Range:</label></td>
          <td><f:input path="highRange" disabled="true" /></td>
        </c:if>
      </tr>
      <tr>
        <c:if test="${testing.unit == null}">
          <td><label>Unit:</label></td>
          <td><f:input path="unit" pattern="[A-Za-z]+" title="Only alphabets allowed" required="true" /></td>
        </c:if>
        <c:if test="${not empty testing.unit}">
        <f:hidden path="unit"/>
          <td><label>Unit:</label></td>
          <td><f:input path="unit" disabled="true" /></td>
        </c:if>
      </tr>
      <tr>
        <td>
        <div>
          <label>Enter the Test Price:</label>
          </div>
          <div style="margin-left:100%; margin-top:-16%;">
          <f:input path="testPrice" pattern="[1-9][0-9]{0,6}" title="Digits only allowed, minimum value: 30" required="true" />
          </div>
        </td>
      </tr>
    </table>
</div>
                                    <div style="margin-top:8%; margin-left:40%;">
                                    <input type="submit" value="Save">
                                    </div>
                                </f:form>
                                     <div>
                                    <a href="listTest" class="button">BACK TO LIST</a>
                                     </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>