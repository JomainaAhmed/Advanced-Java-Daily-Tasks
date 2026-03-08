<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updated Table</title>
</head>
<body>
<h2>Update Employee</h2>

<form action="update" method="post">

    ID:
    <input type="hidden" name="id"
           value="${employee.id}" readonly><br><br>

    Name:
    <input type="text" name="name"
           value="${employee.name}"><br><br>

    Phone:
    <input type="text" name="phone"
           value="${employee.phone}"><br><br>

    Email:
    <input type="text" name="email"
           value="${employee.email}"><br><br>

    <input type="submit" value="Update">

</form>

</form>
</body>
</html>
