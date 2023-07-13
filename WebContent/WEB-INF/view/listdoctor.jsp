<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="path/to/script.js"></script>

<!-- Add Bootstrap stylesheet link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<html>
<head>
    <title>List of Doctors</title>
    
    <style>
        .table th, .table td {
            text-align: center;
            text-transform: uppercase;
            white-space: nowrap; /* This ensures the titles stay in one line */
        }
        .table-container {
            padding-left: 3px; /* Reduced padding to 3px */
        }
        /* Keep left alignment for specific columns */
        .table .left-align {
            text-align: left;
        }
        body{
 
  height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/dddd.jpg" />');
        background-size: cover;
        background-position: center;
        }
         #myTable{
        background-color:#dcdcdc;
        
        }
    </style>
</head>
<body>
    <div class="container-fluid"> <!-- Changed to container-fluid to utilize maximum width -->
        <div class="row">
            <div class="col-12 table-container"> 
                <h1 class="text-center" style="color:#ffffff;">DOCTOR LIST</h1>
            
                <input style="width:15%;" class="form-control mb-4" type="text" id="searchInput" placeholder="Search Regno/Name">
                <a style="margin-left:17%; margin-top:-4.5%;" class="btn btn-info" href="${pageContext.request.contextPath}/doctor/home">HOME</a>
                <table class="table table-hover" id="myTable" style="width:100%;">
                    <thead class="thead-dark">
                        <tr>
                            <th>RegNo</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>DOB</th>
                            <th>Blood Group</th>
                            <th>Phone No</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Qualification</th>
                            <th>Specialization</th>
                            <th>Fee</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="doctor" items="${doctorList}">
                            <c:url var="editLink" value="/doctor/edit">
                                <c:param name="doctorId" value="${doctor.doctorId}" /> 
                            </c:url>
                            <c:url var="disableLink" value="/doctor/disable">
                                <c:param name="doctorId" value="${doctor.doctorId}" /> 
                            </c:url>
                            <tr>
                                <td>${doctor.doctorRegNo}</td>
                                <td>${doctor.doctorName}</td>
                                <td>${doctor.doctorGender}</td>
                                <td>${doctor.doctorDateOfBirth}</td>
                                <td>${doctor.doctorBloodGroup}</td>
                                <td>${doctor.doctorPhoneNo}</td>
                                <td>${doctor.doctorAddress}</td>
                                <td>${doctor.doctorEmail}</td>
                                <td>${doctor.doctorQualification}</td>
                                <td>${doctor.doctorSpecialization}</td>
                                <td>${doctor.doctorConsultationFee}</td>
                                <td><a class="btn btn-info" href="${editLink}">Edit</a> <a class="btn btn-info" href="${disableLink}">Disable</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
                <script>
                    function searchTable() {
                        var input = document.getElementById("searchInput").value.toLowerCase();
                        var table = document.getElementById("myTable");
                        var rows = table.getElementsByTagName("tr");
                        for (var i = 1; i < rows.length; i++) {
                            var rowData = rows[i].getElementsByTagName("td");
                            var rowVisible = false;
                            for (var j = 0; j < rowData.length; j++) {
                                if (j == 0 || j == 1) {
                                    var cellValue = rowData[j].textContent || rowData[j].innerText;
                                    if (cellValue.toLowerCase().indexOf(input) > -1) {
                                        rowVisible = true;
                                        break;
                                    }
                                }
                            }
                            rows[i].style.display = rowVisible ? "" : "none";
                        }
                    }
                    var searchInput = document.getElementById("searchInput");
                    searchInput.addEventListener("keyup", searchTable);
                </script>

            </div>
        </div>
    </div>
</body>
</html>
