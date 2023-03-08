<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="EL.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/7
  Time: 10:19
  简介 :
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("xiaomi", 27, new Date()));
    list.add(new User("lisi", 22, new Date()));
    list.add(new User("wangwu", 25, new Date()));

    request.setAttribute("list", list);
%>
<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="red">
                <td align="center">${s.count}</td>
                <td align="center">${user.name}</td>
                <td align="center">${user.age}</td>
                <td align="center">${user.birth}</td>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="green">
                <td align="center">${s.count}</td>
                <td align="center">${user.name}</td>
                <td align="center">${user.age}</td>
                <td align="center">${user.birth}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
