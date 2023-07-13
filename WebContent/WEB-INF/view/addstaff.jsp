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
            width: 70%; /* Adjust the width as per your requirement */
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color:#dcdcdc;
        }
        
        table {
            width: 100%;
        }
        
        label {
            display: inline-block;
            width: 100px;
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
            margin-left: 110px; /* Adjust the margin as per your requirement */
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        a {
            text-decoration: none;
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
            element.value = element.value.toUpperCase();
        }
        
        $(function() {
    	  // Initialize datepicker with desired options
    	  $("#dob").datepicker({
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
    	    $("#dob").val(""); // Clear the selected date
    	  }
    	}
        
       function validateForm() {
        // Validate Gender
        var gender = document.getElementById('staffGender').value;
        if(gender == 0) {
            alert("Please select a gender");
            return false;
        }
        // Validate Blood Group
        var bloodGroup = document.getElementById('staffBloodGroup').value;
        if(bloodGroup == 0) {
            alert("Please select a blood group");
            return false;
        }

        // Validate Department
        var department = document.getElementById('staffDepartment').value;
        if(department == 0) {
            alert("Please select a department");
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
        	    var dobField = document.getElementById('dob');
        	    var originalDate = new Date('${staffs.staffDateOfBirth}'); 
        	    var formattedDate = (originalDate.getDate().toString().padStart(2, '0')) + '/' + ((originalDate.getMonth() + 1).toString().padStart(2, '0')) + '/' + originalDate.getFullYear();
        	    dobField.value = formattedDate;
        	}

        	         
    </script>
</head>
<body>
    <div id="container">
        <h3 style="margin-left:40%;">Add Staff</h3>
        <f:form action="save" modelAttribute="staffs" method="post" onsubmit="return validateForm();">
        <!--  Hidden fields -->
            <f:hidden path="staffId"/>
            <f:hidden path="staffRegNo"/>
            <f:hidden path="user.userId" value="${userId}"/> 
            <table>
                <tbody>
                    <!-- Name -->
                    <tr>
                        <td><label style="margin-left:45%;">Name:</label></td>
                        <td>
                            <f:input path="staffName" pattern="[A-Za-z ]+" title="Only characters and spaces are allowed" oninput="capitalizeFirstLetter(this)" required="required"/>
                        </td>
                    </tr>
                    
                     <!-- Department -->
                    <tr>
                        <td><label style="margin-left:45%;" >Department:</label></td>
                        <td>
                            <f:select path="staffDepartment" id="staffDepartment" required="required">
                                <f:option value="0" label="Select Department" />
                                <f:option value="Surgery" label="Surgery" />
                                <f:option value="Cardiology" label="Cardiology" />
                                <f:option value="Neurology" label="Neurology" />
                                <f:option value="Nurses" label="Nurses" />
                                <f:option value="Dermatology" label="Dermatology" />
                                <f:option value="Therapists" label="Therapists" />
                                <f:option value="Radiology" label="Radiology" />
                                <f:option value="Pediatrics" label="Pediatrics" />
                                <f:option value="Gynaecology" label="Gynaecology" />
                                <f:option value="MedicineDept" label="MedicineDept" />
                                <f:option value="Laboratory" label="Laboratory" />
                                <f:option value="ENT" label="ENT" />
                            </f:select>
                        </td>
                    </tr>
                    
                   <!-- Date of Birth -->
                   <tr>
    <td><label style="margin-left:45%;" >Date of Birth:</label></td>
    <td>
        <input type="text" id="dob" name="staffDateOfBirth" value="" required="required">
    </td>
</tr>

                    
                     <!-- Gender -->
                    <tr>
                        <td><label style="margin-left:45%;">Gender:</label></td>
                        <td>
                            <f:select path="staffGender" id="staffGender" required="required">
                                <f:option value="0" label="Select Gender"/>
                                <f:option value="Male" label="Male"/>
                                <f:option value="Female" label="Female"/>
                                <f:option value="Other" label="Other"/>
                            </f:select>
                        </td>
                    </tr>
                    
                     <!-- Blood Group -->
                   <tr>
                        <td><label style="margin-left:45%;" >Blood Group:</label></td>
                        <td>
                            <f:select path="staffBloodGroup" id="staffBloodGroup" required="required">
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
                        </td>
                    </tr>
                    
                     <!-- Phone Number -->
                    <tr>
                        <td><label style="margin-left:45%;" >Phone Number:</label></td>
                        <td>
                            <input type="tel" name="staffPhoneNo" id="staffPhoneNo" pattern="^[0-9]{10}$" title="Enter a 10 digit phone number" value="${staffs.staffPhoneNo}" required="required" />
                        </td>
                    </tr>
                    
                     <!-- Address -->
                   <tr>
                        <td><label style="margin-left:45%;">Address:</label></td>
                        <td>
                            <f:input path="staffAddress" required="required" minlength="4" maxlength="100"/>
                        </td>
                    </tr>
                    
                    <!-- Qualification -->
                    <tr>
                        <td><label style="margin-left:45%;" >Qualification:</label></td>
                        <td>
                            <input type="text" name="staffQualification" id="staffQualification" value="${staffs.staffQualification}" oninput="convertToUpperCase(this)" required="required" minlength="4" maxlength="50"/>
                        </td>
                    </tr>
                    
                     <!-- Email -->
                    <tr>
                        <td><label style="margin-left:45%;">Email:</label></td>
                        <td>
                            <input type="email" name="staffEmail" id="staffEmail" value="${staffs.staffEmail}" required="required" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </f:form>
        <p><a class="btn btn-info" href="${pageContext.request.contextPath}/staff/list">Back to List</a></p>
    </div>
</body>
</html>
