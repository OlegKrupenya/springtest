<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div class="formLayout">
        <br> <label>First Name</label> <input id="firstName" name="name"><br>
        <label>Last Name</label> <input id="lastName" name="name"><br>
        <label>Age</label> <input id="age"><br> <label></label>
        <button>Submit</button>
    </div>
</body>
</html>