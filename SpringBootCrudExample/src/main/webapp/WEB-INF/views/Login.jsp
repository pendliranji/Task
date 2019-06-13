<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${again}
<body>
	<pre>
	<form:form action="check" method="POST" modelAttribute="student">
ID      :<form:input path="stu_Id" />  	
PASSWORD:<form:password path="stu_Pass" />

		<input type="submit" value="LOGIN" />
	</form:form>
</pre>

</body>
<b><a href="register">Register</a></b>
</html>
