<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应数据</title>
    <%--引入jquery.min.js--%>
    <script src="js/jquery.min.js"></script>

    <script>
        //页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123","age":"18"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //参数data：服务器端响应的json的数据
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
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
