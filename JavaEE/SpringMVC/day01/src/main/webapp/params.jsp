<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数的绑定</title>
</head>
<body>
    <%--请求参数绑定--%>

    <%--<a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>
    <%--表单里name应和JavaBean的属性名一致，因为数据要往JavaBean里封装 [会通过name找属性的set方法，若找不到则不会封装数据]--%>
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
