<%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/7
  Time: 09:19
  简介 : el中的隐式对象
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  ${pageContext.request}<br>
  <h3>在JSP页面动态的获取虚拟目录</h3>
  ${pageContext.request.contextPath}<br>
</body>
</html>
