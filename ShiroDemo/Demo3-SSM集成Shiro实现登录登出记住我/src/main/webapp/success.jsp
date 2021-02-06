<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>恭喜${sessionScope.get("user").username}登录成功！</h1>
<a href="/user/logout">退出</a>
</body>
</html>
