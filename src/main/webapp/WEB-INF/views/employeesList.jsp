<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees:</title>
</head>
<body>
	<script type="text/javascript">
		function addOnClick() {
			window.location = "add";
		}
	</script>
	<c:if test="${!empty employees}">
		<table class="data">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
			<c:forEach items="${employees}" var="emp">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.age}</td>
					<td><input type="checkbox" name="cbSelected"  id="cb${emp.employeeId}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div>
		<button id="btnAdd" onclick="addOnClick()">Add</button>
		<button id="btnEdit">Edit</button>
		<button id="btnDelete">Delete</button>
	</div>
</body>
</html>