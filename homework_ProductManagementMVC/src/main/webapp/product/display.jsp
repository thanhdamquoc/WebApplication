<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product List</title>
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
<h1>Product List</h1>
<table>
  <tr>
    <th>id</th>
    <th>name</th>
    <th>price</th>
    <th>description</th>
    <th>origin</th>
    <th>update</th>
    <th>remove</th>
  </tr>
  <c:forEach items="${requestScope['products']}" var="product">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.description}</td>
      <td>${product.origin}</td>
      <td><a href="/products?action=update&id=${product.id}">update</a></td>
      <td><a href="/products?action=remove&id=${product.id}">remove</a></td>
    </tr>
  </c:forEach>
  <form method="post" action="/products?action=add">
    <tr>
      <td></td>
      <td><input type="text" size="5" name="name"></td>
      <td><input type="text" size="5" name="price"></td>
      <td><input type="text" size="5" name="description"></td>
      <td><input type="text" size="5" name="origin"></td>
      <td colspan="2"><input type="submit" value="add"></td>
    </tr>
  </form>
</table>
</body>
</html>
