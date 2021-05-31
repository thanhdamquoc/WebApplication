<%@ page import="java.util.ArrayList" %>
<%@ page import="objects.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSP Customer List</title>
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
<%
  ArrayList<Person> people = new ArrayList<>();
  people.add(new Person("a", "1", "hn"));
  people.add(new Person("b", "2", "hn"));
  people.add(new Person("c", "3", "hn"));
  people.add(new Person("d", "4", "hn"));
  people.add(new Person("e", "5", "hn"));
  pageContext.setAttribute("people",people);
%>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${people}" var="person">
        <tr>
            <td><c:out value="${person.name}"/></td>
            <td><c:out value="${person.age}"/></td>
            <td><c:out value="${person.address}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
