<%--
  Created by IntelliJ IDEA.
  User: 华硕
  Date: 2022/7/7
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>

<h1> 添加账户信息表单</h1>
<form name="acccountForm" action="${pageContext.request.contextPath}/account/save" method="post">
    账户名称：<input type="text" name="name"><br/>
    账户金额：<input type="text" name="money"> <br/>
    <input type="submit" value="保存">
</form>
</body>
</html>
