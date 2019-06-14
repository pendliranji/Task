<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER PAGE</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>
	<table border="1">
		<form:form action="save" method="post" modelAttribute="employee">

			<tr>
				<th>Name :</th>
				<th><form:input path="empName" /></th>
				<th><form:errors path="empName" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th>Designation :</th>
				<th><form:input path="empDesg" /></th>
				<th><form:errors path="empDesg" cssClass="err"></form:errors></th>
			</tr>
			</tr>
			<tr>
				<th>Email :</th>
				<th><form:input path="empMail" /></th>
				<th><form:errors path="empMail" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th>Password :</th>
				<th><form:password path="empPwd" /></th>
				<th><form:errors path="empPwd" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th><input type="submit" value="REGISTER"></th>
			</tr>

		</form:form>
	</table>

<%
	HttpSession ses=request.getSession(false); 
	
	if(ses!=null&& ses.getAttribute("name")!=null){
	
	out.println("<b><a href=view>View Employee</a></b>");
       }
	else
	{
	
		out.println("<b><a href=log>Login Employee</a></b>");
	}

 %>

</body>
</br>
<b>${message}</b>
</br>
<!--  Scripting tag -->





</html>