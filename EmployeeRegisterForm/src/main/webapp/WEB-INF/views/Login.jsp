<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>

</head>

<style>

body{
color:black;
background-color: silver;
}


</style>
<body>
<h1><b>LOGIN PAGE</b></h1>
</br>

<b>${message}</b>
<br/>
</br>
<form:form action="check" method="post" modelAttribute="login">
Name         :&nbsp;&nbsp;&nbsp;&nbsp; <form:input path="userName" required="true" placeholder="Email"/><br>
Password  :<form:password path="userPwd" required="true" placeholder="Password"/><br>
<input type="submit" value="Login"/>
</form:form>
<br/>
${message}
${edits}
${deletes}
<br>

<b><a href="reg">Register</a></b>

</body>
</html>