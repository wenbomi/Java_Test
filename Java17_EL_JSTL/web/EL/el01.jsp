<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  EL.User: miwenbo
  Date: 2022/12/6
  Time: 09:02
  简介 ： EL运算符的使用 & empy运算符
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--自动被解析--%>
    ${ 3 > 4}
    \${ 3 > 4}
<hr>
<h3>算数运算符</h3>
        ${3 + 4}<br>

        ${ 3 / 4}<br>
        ${ 3 div 4} <br>

        ${ 3 % 4}<br>
        ${3 mod 4}<br>

<h3>逻辑运算符</h3>
    ${3 > 4 && 3 > 2}<br>
    ${3 > 4 and 3 > 2}<br>

<%
    String str = "abc";
    request.setAttribute("str",str);

    ArrayList list = new ArrayList();
    request.setAttribute("list",list);
%>

<h3>empty 运算符</h3>
    ${empty str} <br>
    ${not empty str} <br>

    ${empty list} <br>
    ${not empty list} <br>
</body>
</html>
