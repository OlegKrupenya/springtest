<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Employee</title>
<style type="text/css">
.formLayout {
	background-color: #f3f3f3;
	border: solid 1px #a1a1a1;
	padding: 10px;
	width: 300px;
}

.formLayout label,.formLayout input {
	display: block;
	width: 120px;
	float: left;
	margin-bottom: 10px;
}

.formLayout label {
	text-align: right;
	padding-right: 20px;
}

br {
	clear: left;
}
</style>
</head>
<body>
	<form:form action="editEmployee" commandName="employee">
		<div class="formLayout">
			<br> <label>ID</label> <form:input path="employeeId" readonly="true"></form:input><br>
			<label>First Name</label> <form:input path="firstName" name="name"></form:input><br>
			<label>Last Name</label> <form:input path="lastName" name="name"></form:input><br>
			<label>Age</label> <form:input path="age"></form:input><br> <label></label>
			<button>Submit</button>
		</div>
	</form:form>
</body>
</html>