<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/check" method="post">
    <input type="text" name="username"><br>
    <input type="submit" value="提交">
</form>
<form action="/check" method="get">
    <input type="text" name="username"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
