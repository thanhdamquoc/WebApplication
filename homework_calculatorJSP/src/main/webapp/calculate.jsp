<%--
  Created by IntelliJ IDEA.
  User: ThanhDQ
  Date: 5/28/2021
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%
    double result = 0;
    double num1 = Double.parseDouble(request.getParameter("num1"));
    double num2 = Double.parseDouble(request.getParameter("num2"));
    String operator = request.getParameter("operator");
    switch (operator) {
        case "add":
            result = num1 + num2;
            break;
        case "subtract":
            result = num1 - num2;
            break;
        case "multiply":
            result = num1 * num2;
            break;
        case "divide":
            result = num1 / num2;
            break;
    }
%>
<h1>Result</h1>
<%=result%>
</body>
</html>
