<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="PhoneServlet">
    <input type="hidden" value="upDatePhone"name="action">
    <input type="hidden" value="${phone.id}"name="id">
    <input type="hidden"value="${phone.relation}"name="relation">
    关系：${phone.relation}<br/>
    电话：<input type="text"value="${phone.tel}"name="tel"><br/>
    <input type="submit"value="修改">
</form>
</body>
</html>
