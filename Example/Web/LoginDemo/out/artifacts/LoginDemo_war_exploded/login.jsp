<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/23
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            var img = document.getElementById("img");
            img.onclick = function () {
                this.src = "/loginDemo/checkCodeServlet?time="+new Date().getTime();
            }
            document.getElementById("change").onclick = img.onclick;
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/loginDemo/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/loginDemo/checkCodeServlet"><a id="change" href="">看不清？换一张</a></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>

    <div><%=request.getAttribute("checkCode_error")==null ? "" : request.getAttribute("checkCode_error")%></div>
    <div><%=request.getAttribute("login_error")==null ? "" : request.getAttribute("login_error")==null%></div>
</body>
</html>
