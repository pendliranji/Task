<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<b>FAILURE PAGE</b>
	</h1>
	<h2>Login Failed</h2>
	<h3>Email or password is incorrect</h3>
	
	${message}
	<br>
	<a href="log">Try Again for Login</a>
	
<%-- 	<%@ include file="Login.jsp"%> --%>
	
</body>
</html>