<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie:cookies){
        if("username".equals(cookie.getName())){
            response.sendRedirect("index.jsp");
            break;
        }
    }
%>
${msg}
<form action="StudentServlet?action=login"method="post">
    用户名：<input type="text"name="username"><br/>
    密码：<input type="password"name="password"><br/>
    <input type="checkbox"name="remember">免登陆
    <input type="submit"value="登录">
</form>
</body>
</html>
