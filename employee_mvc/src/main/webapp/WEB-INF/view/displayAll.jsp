<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
</head>
<body>

<h2>All Employees</h2>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>

    <c:forEach var="e" items="${employees}">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.phone}</td>
            <td>${e.email}</td>
        </tr>
    </c:forEach>

</table>

<br><br>
<a href="register">Add New Employee</a>

</body>
</html> --%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>List of All The Employees:</h2>

<table border="5" cellpadding="12">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Action</th>
</tr>

<c:forEach var="e" items="${employees}">
<tr>
    <td>${e.id}</td>
    <td>${e.name}</td>
    <td>${e.phone}</td>
    <td>${e.email}</td>
    <td>
        <a href="edit?id=${e.id}">Update</a> |
        <a href="delete?id=${e.id}"
           onclick="return confirm('Are you sure?')">
           Delete
        </a>
    </td>
</tr>
</c:forEach>

</table>

<br>
<a href="register">Add New Employee</a>