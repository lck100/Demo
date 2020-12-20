<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html>
<body>
    <h1>表单post提交</h1>
    <form action="submitServlet" method="post">
        <input type="text" name="username"><br/>
        <input type="submit" value="提交">
    </form>
    <br>
    <h1>表单get提交</h1>
    <form action="submitServlet" method="get">
        <input type="text" name="username"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
