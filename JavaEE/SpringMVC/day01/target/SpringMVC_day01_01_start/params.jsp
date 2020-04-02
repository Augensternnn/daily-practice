<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数的绑定</title>
</head>
<body>
    <%--请求参数绑定--%>

    <%--<a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>

    <%--请求参数绑定实体类型(JavaBean)
        把数据封装到Account类中，类中存在JavaBean
    表单里name应和JavaBean的属性名一致，因为数据要往JavaBean里封装 [会通过name找属性的set方法，若找不到则不会封装数据]
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>
        用户姓名：<input type="text" name="user.uname"><br>
        用户年龄：<input type="text" name="user.age"><br>
        <input type="submit" value="提交">
    </form>
    --%>

    <%--请求参数绑定集合类型
        把数据封装到Account类中，类中存在List和Map的集合
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>

        用户姓名：<input type="text" name="list[0].uname"><br>
        用户年龄：<input type="text" name="list[0].age"><br>

        用户姓名：<input type="text" name="map['one'].uname"><br>
        用户年龄：<input type="text" name="map['one'].age"><br>
        <input type="submit" value="提交">
    </form>
    --%>

    <%--自定义类型转换器
    <form action="param/saveUser" method="post">
        姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>
    --%>

    <%--获取Servlet原生API--%>
    <a href="param/testServlet">获取Servlet原生API</a>
</body>
</html>
