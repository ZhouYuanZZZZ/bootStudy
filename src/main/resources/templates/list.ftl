<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h4>List Page</h4>

Welcome: <shiro:principal></shiro:principal>

<br><br>
<a href="${ctx.contextPath}/user">user</a>

<br><br>
<a href="${ctx.contextPath}/admin">admin</a>

<br><br>
<a href="${ctx.contextPath}/logout">Logout</a>

</body>
</html>