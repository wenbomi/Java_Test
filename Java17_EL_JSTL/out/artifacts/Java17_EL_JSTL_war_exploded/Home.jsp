<%--
  Created by IntelliJ IDEA.
  EL.User: miwenbo
  Date: 2022/12/5
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--html的注释 如下--%>
<!--
<h3> hello SAP </h3>>
-->

<%--jsp的注释如下（多行注释）--%>
<%--
<%
    System.out.println("what fuck");
%>
--%>

    <%
        pageContext.setAttribute("msg","hello");

    %>

    <%=pageContext.getAttribute("msg")%>

<h3>主体信息</h3>
</body>
</html>
