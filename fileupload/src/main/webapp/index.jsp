<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/11
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Springmvc文件上传</h3>

<form action="user/fileupload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
