<%@ page import="EL.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  EL.User: miwenbo
  Date: 2022/12/6
  Time: 09:43
  简介 : EL获取对象中的数据
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
<%
  User user = new User();
  user.setName("xiaomi");
  user.setAge(27);
  user.setBirthday(new Date());

  request.setAttribute("user",user);
%>
<h3>EL获取对象中的值</h3>
<hr>
    ${requestScope.user}<br>
    <%--通过的是对象的属性来获取
        * setXxx 或 getXxx方法，去掉set或get ，剩余部分全部小写 xxx
        * setName --> Name -- > name --%>
    ${requestScope.user.name}<br>
    ${requestScope.user.age}<br>
    ${requestScope.user.birthday}<br>
    ${user.birth}<br>

<%--调用对象里的方法 --%>
    ${requestScope.user.birth}<br>
<%--    ${requestScope.user.birthday.year}<br>--%>
<%--    ${requestScope.user.birthday.month}<br>--%>

</body>
</html>
