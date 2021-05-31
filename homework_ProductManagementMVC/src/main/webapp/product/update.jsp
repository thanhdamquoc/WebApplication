<%--
  Created by IntelliJ IDEA.
  User: ThanhDQ
  Date: 5/31/2021
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
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
<h1>Update Product</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>description</th>
        <th>origin</th>
        <th>update</th>
    </tr>
    <form action="/products?action=update" method="post">
        <tr>
            <td><input type="hidden" size="2" name="id" value="${requestScope["product"].id}">${requestScope["product"].id}</td>
            <td><input type="text" size="5" name="name" value="${requestScope["product"].name}"></td>
            <td><input type="text" size="5" name="price" value="${requestScope["product"].price}"></td>
            <td><input type="text" size="5" name="description" value="${requestScope["product"].description}"></td>
            <td><input type="text" size="5" name="origin" value="${requestScope["product"].origin}"></td>
            <td><input type="submit" value="update"></td>
        </tr>
    </form>
</table>
</body>
</html>
