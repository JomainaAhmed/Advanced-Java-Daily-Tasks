<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>

<h2>Enter Details</h2>

<form action="submitForm" method="post">
    Name: <input type="text" name="name"><br><br>
    Phone: <input type="text" name="phone"><br><br>
    Email: <input type="text" name="email"><br><br>
    <input type="submit" value="Submit">
</form>

<hr>

</body>
</html>