<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/quick17" method="post">
    <input type="text" name="name"><br>
    <input type="submit" value="提交"><br>
</form>

<form action="/quick15" method="post">
    <%--表明是第一个User对象的username age--%>
    <input type="text" name="userList[0].username"><br/>
    <input type="text" name="userList[0].age"><br/>
    <input type="text" name="userList[1].username"><br/>
    <input type="text" name="userList[1].age"><br/>
    <input type="submit" value="提交">
</form>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
    var userList = new Array();
    userList.push({username:"李四",age:18});
    userList.push({username:"王五",age:28});

    $.ajax({
        type:"POST",
        url:"${pageContext.request.contextPath}/quick16",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=utf-8"
    });

</script>
</body>
</html>
