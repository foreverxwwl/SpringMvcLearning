<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/10
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用的注解--%>
<a href="anno/testRequestParam?name=RequestParam">RequestParam</a>

<br>

<form action="anno/testRequestBody" method="post">
    用户姓名：<input type="text" name="username" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>

<a href="anno/testPathVariable/testPathVariable">testPathVariable</a>

<br>

<a href="anno/testRequestHeader">RequestHeader</a>

<br>

<a href="anno/testCookieValue">CookieValue</a>
<br>

<form action="anno/testModelAttribute" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>
<form action="anno/testModelAttributeMap" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>
</body>
</html>
