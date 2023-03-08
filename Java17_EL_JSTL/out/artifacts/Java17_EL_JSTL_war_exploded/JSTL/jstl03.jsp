<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/7
  Time: 09:57
  简介 : foreach标签的使用
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%-- foreach ：相当于Java中的for循环
        作用1：完成重复的操作
            for(i=0;i<10;i++){}
          * 属性：
              begain: 开始值
              end : 结束值
              var : 临时变量
              step: 步长
              varStatus: 循环状态对象
                  - index: 容器中元素的索引，从0开始
                  - count: 循环次数从1开始
        作用2：遍历容器
            List<User> list
            for (User user: list){}
            * 属性
              items:容器对象
              var: 容器中元素的临时变量
              varStatus: 循环状态对象
                  - index: 容器中元素的索引，从0开始
                  - count: 循环次数从1开始
 --%>
    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
      ${i} ${s.index}  ${s.count}<br>
    </c:forEach>
<hr>
  <%
    ArrayList list = new ArrayList();
    list.add("AAA");
    list.add("bbb");
    list.add("CCC");

    request.setAttribute("list",list);
  %>
<c:forEach items="${list}" var="str" varStatus="s">
  ${s.index} ${s.count} ${str} <br>
</c:forEach>

</body>
</html>
