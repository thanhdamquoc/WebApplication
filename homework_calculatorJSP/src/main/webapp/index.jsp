<%--
  Created by IntelliJ IDEA.
  User: ThanhDQ
  Date: 5/28/2021
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="calculate.jsp" method="post">
    <fieldset>
      <legend>Calculator</legend>
      <label for="num1">First operand:</label>
      <input type="text" id="num1" name="num1"><br><br>
      <label for="operator">Operator:</label>
      <select name="operator" id="operator">
        <option value="add">Addition</option>
        <option value="subtract">Subtraction</option>
        <option value="multiply">Multiplication</option>
        <option value="divide">Division</option>
      </select>
      <br><br>
      <label for="num2">Second operand:</label>
      <input type="text" id="num2" name="num2"><br><br>
      <button type="submit">Calculate</button>
    </fieldset>
  </form>
  </body>
</html>
