<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/7
  Time: 09:51
  简介 : choose标签的学习
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>完成数字编号对应星期几的案例</h3>
    <%
        request.setAttribute("number",8);
    %>
<c:choose>
    <c:when test="${number == 1}">星期一</c:when>
    <c:when test="${number == 2}">星期二</c:when>
    <c:when test="${number == 3}">星期三</c:when>
    <c:when test="${number == 4}">星期四</c:when>
    <c:when test="${number == 5}">星期五</c:when>
    <c:when test="${number == 6}">星期六</c:when>
    <c:when test="${number == 7}">周日</c:when>
    <c:otherwise>数字输入不正确</c:otherwise>
</c:choose>
</body>
</html>
