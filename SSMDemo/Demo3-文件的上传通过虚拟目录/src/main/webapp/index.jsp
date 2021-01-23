<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${pageContext.servletContext.contextPath}/uploadFile" method="post" enctype="multipart/form-data">
    文件1<input type="file" name="uploadFile"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
