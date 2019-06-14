<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="goooo" mathod="POST" modelAttribute="email">
EMAIL   :<form:input path="from"/>
PASSWORD:<form:password path="password"/>
TO-MAIL :<form:input path="to"/>
SUBJECT :<form:input path="subject"/>
MESSAGE :<form:input path="message"/>

<input type="submit" value="Send-Mail"/>
</form:form>
</body>
</html>