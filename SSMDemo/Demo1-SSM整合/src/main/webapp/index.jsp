<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>
<h1>保存账户信息表单</h1>
<form action="${pageContext.request.contextPath}/save" method="post">
    用户名称：<input type="text" name="name"><br/>
    账户金额：<input type="text" name="money"><br/>
    <input type="submit" value="保存">
</form>
</body>
</html>
