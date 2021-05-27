<%--
  Created by IntelliJ IDEA.
  User: ThanhDQ
  Date: 5/27/2021
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/display-discount" method="post">
    Product Description: <input type="text" name="product-name"><br>
    List Price: <input type="text" name="product-price"><br>
    Discount Percentage (%): <input type="text" name="discount-percentage"><br>
    <button type="submit">Calculate</button><br>
  </form>
  </body>
</html>
