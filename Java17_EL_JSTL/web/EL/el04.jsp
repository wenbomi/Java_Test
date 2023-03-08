<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: miwenbo
  Date: 2022/12/6
  Time: 10:14
  简介 : List & Map 集合数据的读取
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  List list = new ArrayList();
  list.add("aaa");
  list.add("bbb");
  request.setAttribute("list",list);

  HashMap hashMap = new HashMap();
  hashMap.put("sname","xiaomi");
  hashMap.put("sage","27");
  hashMap.put("sex","male");
  request.setAttribute("hashmap",hashMap);

%>
<h3>EL获取List内的值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>

<h3>EL获取Map内的值</h3>
    ${hashmap.sage}<br>

    ${hashmap.sname}<br>
    ${hashmap["sname"]}<br>

    ${hashmap.sex}<br>
    ${hashmap["sex"]}<br>

</body>
</html>
