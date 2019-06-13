<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STUDENT REGISTER</title>
</head>
<body>
<h1><b>WELCOME TO STUDENT REGISTRATION PAGE</b></h1>
	<pre>
	<form:form action="insert" modelAttribute="student">
NAME :<form:input path="stu_Name" />
EMAIL:<form:input path="stu_mail" />
PASSWORD:<form:password path="stu_Pass"/>
HOBBY :<form:input path="stu_Hobby" />

		<input type="submit" value="Register" />
	</form:form>
</pre>
</body>
</html>