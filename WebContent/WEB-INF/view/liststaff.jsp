<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="path/to/script.js"></script>

<!-- Add Bootstrap stylesheet link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<html>
<head>
    <title>List of Staff</title>
    
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
        #myTable{
        background-color:#dcdcdc;
        
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
    <div class="container-fluid"> <!-- Changed to container-fluid to utilize maximum width -->
        <div class="row">
            <div class="col-12 table-container"> 
                <h1 class="text-center" style="color:#ffffff;">STAFF LIST</h1>
            
                <input style="width:15%;" class="form-control mb-4" type="text" id="searchInput" placeholder="Search RegNo/Name">
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
                            <th>Department</th>
                            <th>Qualification</th>
                            <th>Email</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
        <c:forEach var="staffs" items="${staffList}">
         
             <!-- Construct an update link with staff id -->
				<c:url var="editLink" value="/staff/edit">
					<c:param name="staffId" value="${staffs.staffId}" />
				</c:url>

				<!-- construct an delete link with staff id -->
				<c:url var="disableLink" value="/staff/disable">
					<c:param name="staffId" value="${staffs.staffId}" />
				</c:url>
				
        
            <tr>
                <td>${staffs.staffRegNo}</td>
                <td>${staffs.staffName}</td>
                <td>${staffs.staffGender}</td>
                <td>${staffs.staffDateOfBirth}</td>
                <td>${staffs.staffBloodGroup}</td>
                <td>${staffs.staffPhoneNo}</td>
                <td>${staffs.staffAddress}</td>
                <td>${staffs.staffDepartment}</td>
                <td>${staffs.staffQualification}</td>
                <td>${staffs.staffEmail}</td>
            <!--<td>${staffs.isActive}</td>--> 
                <td><a class="btn btn-info" href="${editLink}">Edit</a> <a class="btn btn-info" href="${disableLink}">Disable</a></td>
            </tr>
        </c:forEach>
    </table>
    <script>
		function searchTable() {
			// Get the input value and convert it to lowercase
			var input = document.getElementById("searchInput").value
					.toLowerCase();

			// Get the table and rows
			var table = document.getElementById("myTable");
			var rows = table.getElementsByTagName("tr");

			// Loop through each row and hide/show based on search input
			for (var i = 0; i < rows.length; i++) {
				var rowData = rows[i].getElementsByTagName("td");
				var rowVisible = false;

				for (var j = 0; j < rowData.length; j++) {
					if (j == 0 || j == 1) {
						var cellValue = rowData[j].textContent
								|| rowData[j].innerText;
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
