<!-- For teaching Only -->
< %@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>JSP Actions Example</title>
</head>
<body>

<h1> Student Registration Page</h1>
<form action="<%= request.getContextPath() %>/StudentServlet" method="post">
    First Name: <input type="text" name="firstName">
    <br> <br>
    ${testservice.getReport().getNewDeaths()}
    <br> <br>
    Last Name: <input type="text" name="lastName">
    <br> <br>

    Email ID: <input type="email" name="emailId">
    <br> <br>
    Password: <input type="password" name="password"><br>

    <br>
    <input type="submit" value="register">
</form>
</body>
</html>