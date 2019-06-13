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
	<h3>
		<b>WELCOME TO STUDENT EDIT PAGE</b>
	</h3>
	<pre>
	<form:form action="update" method="POST" modelAttribute="student">
ID   :<form:input path="stu_Id" readonly="true" />  	
NAME :<form:input path="stu_Name" />
EMAIL:<form:input path="stu_mail" />
PASSWORD:<form:hidden path="stu_Pass" />
HOBBY :<form:input path="stu_Hobby" />

		<input type="submit" value="Update" />
	</form:form>
</pre>
</body>
</html>