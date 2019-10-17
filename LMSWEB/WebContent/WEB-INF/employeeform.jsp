<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form method="post" action="Hrservlet?action=newEmployee">
<table>
<tr>
<td><label for="employeeId">Employee Id:</label></td>
<td><input type="number" name="employeeId"/>&nbsp;<label style="color:red"><c:out value="${employeeIderror}"/></label></td>
</tr>

<tr>
<td><label for="firstName">First Name:</label></td>
<td><input type="text" name="firstName"/>&nbsp;<label style="color:red"><c:out value="${firstnameerror}"/></label></td>
</tr>

<tr>
<td><label for="lastName">Last Name:</label></td>
<td><input type="text" name="lastName"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" name="email"/>&nbsp;<label style="color:red"><c:out value="${emailerror}"/></label><label style="color:red"><c:out value="${emailexisterror}"/></label></td>
</tr>

<tr>
<td><label for="phoneNumber">Phone Number:</label></td>
<td><input type="text" name="phoneNumber"/></td>
</tr>

<tr>
<td><label for="hireDate">Hire Date:</label></td>
<td><input type="date" name="hireDate"/></td>
</tr>

<tr>
<td><label for="dateOfBirth">Date Of Birth:</label></td>
<td><input type="date" name="dateOfBirth"/></td>
</tr>

<tr>
<td><label for="designation">Designation:</label></td>
<td>
<select name="designation">
<c:forEach items="${designationList}" var="retriveEmployeeModelDesignation">
<option><c:out value="${retriveEmployeeModelDesignation.designation}"/></option>
</c:forEach>
</select>
</td>
</tr>


<tr>
<td><label for="salary">Salary:</label></td>
<td><input type="number" name="salary"/>&nbsp;<label style="color:red"><c:out value="${salaryerror}"/></label></td>
</tr>

<tr>
<td><label for="jobLocation">Job Location:</label></td>
<td><input type="text" name="jobLocation"/></label></td>
</tr>

<tr>
<td><input type="submit" value="Register" class="button"></td>
<td><input type="reset" value="Cancel" class="button"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>