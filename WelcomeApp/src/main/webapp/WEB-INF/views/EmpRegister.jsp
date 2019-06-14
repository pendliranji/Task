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

body {
	color: black;
	background-color: silver;
	align: "center";
}
h1 {
    color : #000000;
    text-align : center;
    font-family: "SIMPSON";
}

form {
	align: "center";
	width: 300px;
	margin: 0 auto;
}

A {
	text-decoration: none;
	text-transform: uppercase;
}
#form_reg
{
 left: 50%;
    top: 50%;
    margin-left: -25%;
    position: absolute;
    margin-top: -25%;
}
</style>
</head>
<body>
	<table border="2">
		<form:form action="save" method="post" modelAttribute="employee" id="form_reg">

			<tr>
				<th>Name :</th>
				<th><form:input path="empName" placeholder="Employee Name" /></th>
				<th><form:errors path="empName" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th>Designation :</th>
				<th><form:input path="empDesg"
						placeholder="Employee Designation" /></th>
				<th><form:errors path="empDesg" cssClass="err"></form:errors></th>
			</tr>
			</tr>
			<tr>
				<th>Email :</th>
				<th><form:input path="empMail" placeholder="Employee Email" /></th>
				<th><form:errors path="empMail" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th>Password :</th>
				<th><form:password path="empPwd"
						placeholder="Employee Password" /></th>
				<th><form:errors path="empPwd" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th>Roles :</th>
				<th><form:radiobutton path="roles" value="ADMIN" />ADMIN
				<form:radiobutton path="roles" value="USER" />USER
				<form:radiobutton path="roles" value="SUPER_USER" />SUPER_USER
						 </th>
				<th><form:errors path="empPwd" cssClass="err"></form:errors></th>
			</tr>
			<tr>
				<th><button>
						<input type="submit" value="REGISTER">
					</button></th>
			</tr>

		</form:form>
	</table>

	<%
		HttpSession ses = request.getSession(false);

		if (ses != null && ses.getAttribute("name") != null) {

			out.println("<b><button><a href=view>View Employee</a></button></b>");
		} else {

			out.println("<b><button><a href=login>Login Employee</a><button></b>");
		}
	%>

</body>

<b>${message}</b>
</br>
<!--  Scripting tag -->





</html>