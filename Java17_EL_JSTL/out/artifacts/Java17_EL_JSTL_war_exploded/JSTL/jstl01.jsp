<%@ page import="java.sql.Array" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/7
  Time: 09:34
  简介 :
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  c:if标签
        1.属性：
          * test 必须属性 接收boolean表达式
          * 如果表达式为true 则显示if标签体内容，若为false 不显示标签体内容
          * 一般情况下， test属性都会结合el表达式一起使用
        2.注意
          * c:if标签没有else情况 ，想要满足else的情况，可以再次定义一个c:if标签
          --%>

<c:if test="true">
  哈哈哈哈哈哈～～～～
  <h2>严肃点</h2>
</c:if>

<%
  ArrayList list = new ArrayList();
  list.add("hhhh");
  request.setAttribute("list",list);
  request.setAttribute("number",3);
%>
<c:if test="${not empty list}">
  遍历集合。。。
</c:if>
<br>

<c:if test="${number % 2 != 0}">
  ${number}为奇数...
</c:if>
<c:if test="${number % 2 == 0}">
  ${number}为偶数...
</c:if>



</body>
</html>
