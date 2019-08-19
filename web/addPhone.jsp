<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="PhoneServlet">
    <input type="hidden" value="addPhone"name="action">
    <input type="hidden" value="${phone.id}"name="id">
    <input type="text"value="${phone.relation}"name="relation"><br/>
    <input type="text"value="${phone.tel}"name="tel"><br/>
    <input type="submit"value="增加">
</form>
</body>
</html>
