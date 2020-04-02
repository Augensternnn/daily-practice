<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <h3>成功！！！</h3>

    <%--
    isELIgnored="false"：不忽略EL表达式
    --%>
    <%--${requestScope}--%>
    ${requestScope.msg}<%--可简写为${msg}--%>
    ${sessionScope}
</body>
</html>
