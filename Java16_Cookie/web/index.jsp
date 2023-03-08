<%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/1
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
    System.out.println("hello jsp");
    int i = 5;
    String contextPath = request.getContextPath();
    out.print(contextPath);
%>
<%!
    int i = 3;
%>
<%=
    i
%>
System.out.println("hello jsp");
<h1>Hello,Cookie!</h1>
<%
    response.getWriter().write("what fuck....");
%>
</body>
</html>
