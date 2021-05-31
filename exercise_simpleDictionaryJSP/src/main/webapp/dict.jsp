<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ThanhDQ
  Date: 5/28/2021
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Dict</title>
</head>
<body>
<%
  String word = request.getParameter("q");
  HashMap<String, String> dictionary = new HashMap<>();
  dictionary.put("dog","dawg");
  dictionary.put("cat","meow");
  String result = "not found";
  if (dictionary.containsKey(word)) {result = dictionary.get(word);}
%>

  <h1>Define: <%=word%></h1>
  <h1>Definition:  <%=result%></h1>
</body>
</html>
