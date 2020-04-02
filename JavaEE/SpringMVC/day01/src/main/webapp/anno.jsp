<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <%--RequestParam注解--%>
    <a href="anno/testRequestParam?name=哈哈">RequestParam注解</a>
    <br>

    <%--RequestBody注解：不适用get请求[因为get请求没有请求体]--%>
    <form action="anno/testRequestBody" method="post">
        姓名：<input type="text" name="username"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>

    <%--PathVariable注解--%>
    <a href="anno/testPathVariable/10">PathVariable注解</a>
    <br>

    <%--RequestHeader注解--%>
    <a href="anno/testRequestHeader">RequestHeader注解</a>
    <br>

    <%--CookieValue注解--%>
    <a href="anno/testCookieValue">CookieValue注解</a>
    <br>

    <%--ModelAttribute注解--%>
    <form action="anno/testModelAttribute" method="post">
        姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>

    <%--SessionAttributes注解：只能作用在类上--%>
    <a href="anno/testSessionAttributes">SessionAttributes注解：测试</a>
    <br>
    <a href="anno/getSessionAttributes">SessionAttributes注解：获取session中的值</a>
    <br>
    <a href="anno/deleteSessionAttributes">SessionAttributes注解：删除session中的值</a>
    <br>
</body>
</html>
