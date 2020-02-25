<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/24
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
    <%
    //在域中存储数据
        session.setAttribute("name","李四");
        request.setAttribute("name","张三");
        session.setAttribute("age","23");
    %>

    <h3>el获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}

    &{name}<%--获取到的name=张三，因为request域比session小--%>
</body>
</html>
