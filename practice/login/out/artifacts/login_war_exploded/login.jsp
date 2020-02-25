<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <script>
      window.onload = function () {
        var img = document.getElementById("img");
        img.onclick = function () {
          this.src = "${pageContext.request.contextPath}/CheckCodeServlet?time="+new Date().getTime();
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
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
      <table>
        <tr>
          <td>用户名：</td>
          <td><input type="text" name="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input type="password" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
          <td>验证码：</td>
          <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
          <td colspan="2">
            <img id="img" src="${pageContext.request.contextPath}/CheckCodeServlet">
            <a id="change" href="">看不清？换一张</a>
          </td>
        </tr>
        <tr align="center">
          <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
      </table>
    </form>
    ${requestScope.checkCode_error}
    ${requestScope.login_error}
  </body>
</html>
