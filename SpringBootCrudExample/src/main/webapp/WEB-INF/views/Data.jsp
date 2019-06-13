<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student Data</title>
</head>
<body bgcolor="gray">
	${del} ${upd}
	<table border="1 ">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th>HOBBY</th>

			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach var="stu" items="${list}">
			<tr>
				<td><c:out value="${stu.stu_Id}"></c:out></td>
				<td><c:out value="${stu.stu_Name}"></c:out></td>
				<td><c:out value="${stu.stu_mail}"></c:out></td>
				<td><c:out value="${stu.stu_Pass}"></c:out></td>
				<td><c:out value="${stu.stu_Hobby}"></c:out></td>
				<td><a href="edit?id=${stu.stu_Id}">EDIT</a></td>
				<td><a href="delete?id=${stu.stu_Id}"><button
							onclick="return confirm('are you sure to delete');">DELETE</button></a></td>

			</tr>
		</c:forEach>
	</table>

</body>
<a href="register">Register</a>   |||||||||    <a href="logout">Logout</a>
</html>