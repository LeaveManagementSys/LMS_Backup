<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${operation}"/></title>
</head>
<body>
<div style="background-color: #CCC;width:100px;height:100px;">
<p align="center"><c:out value="${operation}"/></p>
</div>
<table>
<tr>
<th>Employee Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>PhoneNumber</th><th>Hire Date</th><th>Date Of Birth</th><th>Designation</th><th>Salary</th><th>JobLocation</th>
</tr>
<tr>
<td><c:out value="${insertEmployeeModel.employeeId}"/></td>
<td><c:out value="${insertEmployeeModel.firstName}"/></td>
<td><c:out value="${insertEmployeeModel.lastName}"/></td>
<td><c:out value="${insertEmployeeModel.email}"/></td>
<td><c:out value="${insertEmployeeModel.phoneNumber}"/></td>
<td><c:out value="${insertEmployeeModel.hireDate}"/></td>
<td><c:out value="${insertEmployeeModel.designation}"/></td>
<td><c:out value="${insertEmployeeModel.dateOfBirth}"/></td>
<td><c:out value="${insertEmployeeModel.salary}"/></td>
<td><c:out value="${insertEmployeeModel.jobLocation}"/></td>
</tr>
</table>
</body>
</html>