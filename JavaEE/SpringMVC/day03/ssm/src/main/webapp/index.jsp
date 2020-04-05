<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h5>测试查询</h5>
    <a href="account/findAll">test</a>

    <h5>测试保存</h5>
    <form action="account/save" method="post">
        姓名：<input type="text" name="name"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="保存"><br>
    </form>
</body>
</html>
