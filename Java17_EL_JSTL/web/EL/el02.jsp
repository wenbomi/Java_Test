<%--
  Created by IntelliJ IDEA.
  EL.User: miwenbo
  Date: 2022/12/6
  Time: 09:20
  简介 : 获取值
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
<%
    // 在域中存储数据
    session.setAttribute("msg","69");
    request.setAttribute("msg","SAP");
    session.setAttribute("age","23");


%>
<h3>el获取值</h3>
<hr>
        ${requestScope.msg} <br>
        ${sessionScope.age} <br>
        ${sessionScope.hh} <br>

<%--有查找的动作，表示依次从最小的域中查找是否有该键对应的值，直到找到为止--%>
${msg}
</body>
</html>
