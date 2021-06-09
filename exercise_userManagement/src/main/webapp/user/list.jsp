<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
    <style>
        table {
            border-collapse: collapse;
        }
        table tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>User List</h1>
<form action="/users" method="get">
    <input type="text" name="q">
    <input type="submit" value="search by id">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Remove</th>
    </tr>
    <c:forEach items="${requestScope['users']}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="users?action=remove&id=${user.id}">remove</a></td>
        </tr>
    </c:forEach>
    <form action="/users?action=add" method="post">
        <tr>
            <td></td>
            <td><input size="5" type="text" name="name"></td>
            <td><input size="5" type="text" name="email"></td>
            <td><input size="5" type="text" name="country"></td>
            <td><input type="submit" value="add new"></td>
        </tr>
    </form>
</table>
</body>
</html>
