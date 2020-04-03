<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应数据</title>
    <%--引入jquery.min.js--%>
    <script src="js/js/jquery.min.js"></script>

    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                alert("hello btn");
            });
        });
    </script>
</head>
<body>
    <%--返回值为字符串--%>
    <a href="user/returnString">返回值为字符串</a>
    <br>

    <%--返回值是void类型--%>
    <a href="user/returnVoid">返回值为void类型</a>
    <br>

    <%--返回值是ModelAndView对象--%>
    <a href="user/returnModelAndView">返回值是ModelAndView对象</a>
    <br>

    <%--使用关键字进行转发和重定向：用不了视图解析器对象，故路径需要自己写全写对--%>
    <a href="user/testForwardOrRedirect">使用关键字进行转发和重定向</a>
    <br>

    <%--ResponseBody响应json数据--%>
    <button id="btn">发送ajax请求</button>
</body>
</html>
