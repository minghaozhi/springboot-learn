<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/26
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
单个文件上传:</br>
<form action="/upload" method="post"enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="上传文件"/>
</form>

多个文件上传:</br>
<form action="/uploads" method="post"enctype="multipart/form-data">
    <input type="file" name="file"/><br/>
    <input type="file" name="file"/><br/>
    <input type="file" name="file"/><br/>
    <input type="submit" value="多个上传文件"/>
</form>
</body>
</html>
