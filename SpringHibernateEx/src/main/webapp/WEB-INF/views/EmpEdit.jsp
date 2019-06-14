<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err
{
color :red;
}
</style>
</head>
<body>
<table border="1">
<form:form action="update" method="post" modelAttribute="employee">
<tr>
<th> ID    :</th><th><form:input path="empId" readonly="true"/></th>
</tr>
<tr>
<th> Name    :</th><th><form:input path="empName" /></th>
</tr>
<tr><th> Designation :</th><th><form:input path="empDesg" /></th></tr>
</tr>
<tr><th> Email :</th><th><form:input path="empMail" /></th><th> </th><th><form:errors path="empMail" cssClass="err" /></th></tr>
<tr><th> Password :</th><th><form:input path="empPwd"  /></th></tr>
<tr><th><input type="submit" value="UPDATE"></th></tr>

</form:form>
</table>

</body>
</html>