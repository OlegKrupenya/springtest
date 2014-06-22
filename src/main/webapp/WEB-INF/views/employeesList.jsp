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
		function cbOnChange() {
			var elements = document.getElementsByName('cbSelected');
			var selectedCount = 0;
			var index;
			for (index = 0; index < elements.length; index++) {
				if (elements[index].checked) {
					selectedCount++;
				}
			}
			if (selectedCount > 0) {
				document.getElementById('btnDelete').disabled = false;
			} else {
				document.getElementById('btnDelete').disabled = true;
				document.getElementById('btnEdit').disabled = true;
			}
			if (selectedCount == 1) {
				document.getElementById('btnEdit').disabled = false;
			} else {
				document.getElementById('btnEdit').disabled = true;
			}

		}
		function editOnClick() {
            window.location = "edit" + extractId();
		}
		function deleteOnClick() {
            window.location = "delete" + extractId();
		}
		
		function extractId() {
			var elements = document.getElementsByName('cbSelected');
            var id = "";
            var index;
            for (index = 0; index < elements.length; index++) {
                if (elements[index].checked) {
                    var selectedId = elements[index].id.substr(2);
                    if (id == "") {
                        id = "?id=" + selectedId;
                    } else {
                        id += "&id=" + selectedId;
                    }
                }
            }
            return id;
		}
	</script>
	<c:if test="${!empty employees}">
		<table class="data">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Cars</th>
			</tr>
			<c:forEach items="${employees}" var="emp">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.age}</td>
					<td><c:if test="true"><a href="cars">Cars</a></c:if></td>
					<td><input type="checkbox" name="cbSelected"
						id="cb${emp.employeeId}" onchange="cbOnChange()" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div>
		<button id="btnAdd" id="btnAdd" onclick="addOnClick()">Add</button>
		<button id="btnEdit" id="btnEdit" onclick="editOnClick()" disabled="disabled">Edit</button>
		<button id="btnDelete" id="btnDelete" onclick="deleteOnClick()" disabled="disabled">Delete</button>
	</div>
</body>
</html>