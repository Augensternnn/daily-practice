<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/24
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3 > 4}<%--返回一个boolean的输出--%>
    \${3 > 4}<%--忽略当前这个el表达式--%>

    <hr>

    <h3>算术运算符</h3>
    ${3+4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>

    <h3>比较运算符</h3>
    ${3 == 4}<br>

    <h3>逻辑运算符</h3>
    ${3 > 4  && 3 < 4}<br>
    ${3 > 4  and 3 < 4}<br>

    <h3>empty运算符</h3>
<%
    String str = "";
    request.setAttribute("str",str);
    List list = new ArrayList();
    request.setAttribute("list",list);
%>
    ${not empty str}
    ${not empty list}
</body>
</html>
