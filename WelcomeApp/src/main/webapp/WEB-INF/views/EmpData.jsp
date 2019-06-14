<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE DATA</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DESIGNATION</th>
			<th>EMAIl</th>
			<th>Password</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td><c:out value="${emp.empId}"></c:out></td>
				<td><c:out value="${emp.empName}"></c:out></td>
				<td><c:out value="${emp.empDesg}"></c:out></td>
				<td><c:out value="${emp.empMail}"></c:out></td>
				<td><c:out value="${emp.empPwd}"></c:out></td>
				<td><a href="edit?id=${emp.empId}">EDIT</a></td>
				<td><a href="delete?id=${emp.empId}"><button
							onclick="return confirm('are you sure to delete');">DELETE</button></a></td>

			</tr>
		</c:forEach>
	</table>
	

</body>


<b>${message}</b>
<br>
<br>
<b><a href="reg">Add new Employee</a></b>
<br />
<b><a href="logout">LOG OUT</a></b>


</html>