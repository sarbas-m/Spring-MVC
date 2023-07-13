<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>

<!-- Add jQuery and jQuery UI CDN links -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
    #container {
        width: 70%;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        background-color: #f7f7f7;
    }
    
    table {
        width: 100%;
    }
    
    .form-table {
        width: 100%;
        border-collapse: collapse;
    }
    
    .form-table th {
        padding: 10px;
        background-color: #343a40;
        color: #fff;
        text-align: left;
        font-weight: bold;
    }
    
    .form-table td {
        padding: 10px;
        
    }
   
    
    label {
        display: inline-block;
        width: 150px;
        text-align: right;
        margin-right: 10px;
        font-weight: bold;
    }
    
    input[type="text"],
    input[type="email"],
    input[type="tel"],
    select {
        width: 200px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-left: 160px;
    }
    
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    
    a {
        text-decoration: none;
    }
    
    .form-row {
        margin-bottom: 10px;
    }
    
    .form-heading {
        background-color: #4CAF50;
        color: white;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        padding: 10px;
    }
     body{
 
  height: 100vh;
        background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)),
        url('<c:url value="/resources/images/dddd.jpg" />');
        background-size: cover;
        background-position: center;
        }
        
    
</style>


<script>
function convertToUpperCase(element) {
    // Convert input value to uppercase
    element.value = element.value.toUpperCase();
}

$(function() {
    // Initialize datepicker with desired options
    $("#dobDoctor").datepicker({
        changeMonth: true,
        changeYear: true,
        yearRange: "-60:-23",
        dateFormat: "dd/mm/yy",
        onSelect: checkAge // Bind checkAge() function to onSelect event
    });
});

function checkAge(selectedDate) {
    // Perform age calculation based on the entered date of birth
    var parts = selectedDate.split("/");
    var dob = new Date(parseInt(parts[2], 10),
                        parseInt(parts[1], 10) - 1,
                        parseInt(parts[0], 10));
    var today = new Date();
    var age = today.getFullYear() - dob.getFullYear();
    var m = today.getMonth() - dob.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
        age--;
    }
    if (age < 22) {
        alert("Minimum age is 22.");
        $("#dobDoctor").val(""); // Clear the selected date
    }
}

function validateForm() {
    // Validate Gender
    var gender = document.getElementById('doctorGender').value;
    if (gender == 0) {
        alert("Please select a gender");
        return false;
    }
    // Validate Blood Group
    var bloodGroup = document.getElementById('doctorBloodGroup').value;
    if (bloodGroup == 0) {
        alert("Please select a blood group");
        return false;
    }

    // Validate Specialization
    var specialization = document.getElementById('doctorSpecialization').value;
    if (specialization == 0) {
        alert("Please select a specialization");
        return false;
    }

    return true;
}
</script>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>

 function capitalizeFirstLetter(input) {
        // Capitalize first letter of each word in the input value
        input.value = input.value.split(' ').map(function(word) {
            return word.charAt(0).toUpperCase() + word.slice(1);
        }).join(' ');
    }
    
window.onload = function() {
    // Formatting for doctor.doctorDateOfBirth
    var dobFieldDoctor = document.getElementById('dobDoctor');
    var originalDateDoctor = new Date('${doctor.doctorDateOfBirth}');
    var formattedDateDoctor = (originalDateDoctor.getDate().toString().padStart(2, '0')) + '/' + ((originalDateDoctor.getMonth() + 1).toString().padStart(2, '0')) + '/' + originalDateDoctor.getFullYear();
    dobFieldDoctor.value = formattedDateDoctor;
}
</script>



</head>
<body>
<div id="container">
    <table class="form-table">
        <thead class="thead-dark">
            <tr>
                <th colspan="2" class="form-heading" >Add Doctor</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <f:form action="save" modelAttribute="doctor" method="post" onsubmit="return validateForm()">

                        <!-- Hidden fields -->
                        <f:hidden path="doctorId"/>
                        <f:hidden path="doctorRegNo"/>
                        <f:hidden path="user.userId" value="${userId}"/>

                        <div class="form-row">
                            <label for="doctorName">Name:</label>
                            <f:input path="doctorName" pattern="[A-Za-z ]+" title="Only characters and spaces are allowed" oninput="capitalizeFirstLetter(this)" required="required"/>
                        </div>

                        <div class="form-row">
                            <label for="dobDoctor">Date of Birth:</label>
                            <input type="text" id="dobDoctor" name="doctorDateOfBirth" value="${doctor.doctorDateOfBirth}" required="required">
                        </div>

                        <div class="form-row">
                            <label for="doctorGender">Gender:</label>
                            <f:select path="doctorGender" id="doctorGender" required="required">
                                <f:option value="0" label="Select Gender"/>
                                <f:option value="Male" label="Male"/>
                                <f:option value="Female" label="Female"/>
                                <f:option value="Other" label="Other"/>
                            </f:select>
                        </div>

                        <div class="form-row">
                            <label for="doctorBloodGroup">Blood Group:</label>
                            <f:select path="doctorBloodGroup" id="doctorBloodGroup" required="required">
                                <f:option value="0" label="Select Blood Group"/>
                                <f:option value="A+" label="A+"/>
                                <f:option value="A-" label="A-"/>
                                <f:option value="B+" label="B+"/>
                                <f:option value="B-" label="B-"/>
                                <f:option value="AB+" label="AB+"/>
                                <f:option value="AB-" label="AB-"/>
                                <f:option value="O+" label="O+"/>
                                <f:option value="O-" label="O-"/>
                            </f:select>
                        </div>

                        <div class="form-row">
                            <label for="doctorPhoneNo">Phone Number:</label>
                            <input type="tel" name="doctorPhoneNo" id="doctorPhoneNo" pattern="^[0-9]{10}$" title="Enter a 10 digit phone number" value="${doctor.doctorPhoneNo}" required="required" />
                        </div>

                        <div class="form-row">
                            <label for="doctorAddress">Address:</label>
                            <f:input path="doctorAddress" required="required" minlength="4" maxlength="100"/>
                        </div>

                        <div class="form-row">
                            <label for="doctorQualification">Qualification:</label>
                            <input type="text" name="doctorQualification" id="doctorQualification" value="${doctor.doctorQualification}" oninput="convertToUpperCase(this)" required="required" minlength="4" maxlength="50"/>
                        </div>

                        <div class="form-row">
                            <label for="doctorEmail">Email:</label>
                            <input type="email" name="doctorEmail" id="doctorEmail" value="${doctor.doctorEmail}" required="required" />
                        </div>

                        <div class="form-row">
                            <label for="doctorSpecialization">Specialization:</label>
                            <f:select path="doctorSpecialization" id="doctorSpecialization" required="required">
                                <f:option value="0" label="Select Specialization"/>
                                <f:option value="Cardiology" label="Cardiology"/>
                                <f:option value="Neurology" label="Neurology"/>
                                <f:option value="Orthopedics" label="Orthopedics"/>
                                <f:option value="Pediatrics" label="Pediatrics"/>
                                <f:option value="Radiology" label="Radiology"/>
                                <f:option value="Generalsurgery" label="Generalsurgery"/>
                                <f:option value="Pathology" label="Pathology"/>
                                <f:option value="Oncology" label="Oncology"/>
                                <f:option value="Urologist" label="Urologist"/>
                                <f:option value="Geriatrics" label="Geriatrics"/>
                            </f:select>
                        </div>

                        <div class="form-row">
                            <label for="doctorConsultationFee">Consultation Fee:</label>
                            <input type="number" name="doctorConsultationFee" id="doctorConsultationFee" value="${doctor.doctorConsultationFee}" min="100" required="required" />
                        </div>

                        <div class="form-row">
                            <input type="submit" value="Save" class="save">
                        </div>
                    </f:form>
                </td>
            </tr>
        </tbody>
    </table>
    <p>
        <a class="btn btn-info" href="${pageContext.request.contextPath}/doctor/list">Back to List</a> 
    </p>
</div>
</body>
</html>
