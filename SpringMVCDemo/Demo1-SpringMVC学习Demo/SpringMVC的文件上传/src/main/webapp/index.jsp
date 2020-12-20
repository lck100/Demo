<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1>单文件上传</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件1<input type="file" name="uploadFile"><br/>
    <input type="submit" value="提交">
</form>
<h1>多文件上传</h1>
<form action="/upload2" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件1<input type="file" name="uploadFile"><br/>
    文件2<input type="file" name="uploadFile"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
