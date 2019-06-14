<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER REGISTER</title>
</head>
<body>

	<h2>USER REGISTRATION</h2>
	<form:form action="save" method="POST" modelAttribute="user">
		<pre> 
		 NAME     : <form:input path="userName" /> 
		 EMAIL    : <form:input path="userEmail" /> 
		 PASSWORD : <form:password path="userPwd" /> 
		 ROLES    :    <form:checkbox path="roles" value="ADMIN" /> ADMIN 
	   			     <form:checkbox path="roles" value="EMPLOYEE" /> EMPLOYEE    
	  	 <input type="submit" value="Create User" /> </pre>
	</form:form>
</body>
${message}
</html>

</body>
</html>