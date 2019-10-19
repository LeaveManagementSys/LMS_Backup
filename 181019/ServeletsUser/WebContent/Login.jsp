<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="post" action="Login"></form>

	<h2 align="center">User Login</h2>
	<div align="center">
		<table>
			<tr>
				<th>EmployeeId</th>
				<th>Password</th>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			<tr>

				<c:forEach items="${userModelList}" var="usermodel">
					<tr>
						<td><c:out value="${usermodel.empId}" /></td>
						<td><c:out value="${usermodel.password}" /></td>
					</tr>
				</c:forEach>


		</table>
	</div>
</body>
</html>