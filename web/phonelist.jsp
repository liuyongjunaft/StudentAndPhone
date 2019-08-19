<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function btn() {
            var test = document.getElementsByName("id")
            var id=[];
            var j=0;
            for(var i=0;i<test.length;i++){
                if(test[i].checked){
                    id[j]=test[i].value;
                    j++;
                }
            }
            location.href="PhoneServlet?action=deletePhoneAll&id="+id;
        }
    </script>
</head>
<body>
<table border="1" cellspacing="0">
    <thead>
        <tr>
            <th>选中</th>
            <th>关系</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="phone">
        <tr>
            <td><input type="checkbox"name="id" value="${phone.id}"></td>
            <td>${phone.relation}</td>
            <td>${phone.tel}</td>
            <td>
                <a href="PhoneServlet?action=getPhoneBYid&id=${phone.id}">编辑</a>/
                <a href="PhoneServlet?action=deletePhoneById&id=${phone.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfort>
        <tr>
            <td colspan="2"style="text-align: right"><a href="#"onclick="btn()">批量删除</a><%--<input type="button"value="批量删除"onclick="btn()">--%></td>
            <td colspan="3" style="text-align: right">
                <a href="addPhone.jsp">添加</a>
            </td>
        </tr>
    </tfort>
</table>
${msg}
</body>
</html>
