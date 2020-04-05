<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <h5>传统方式</h5>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br>

    <h5>SpringMVC的方式</h5>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br>

    <h5>跨服务器文件上传</h5>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br>
</body>
</html>
