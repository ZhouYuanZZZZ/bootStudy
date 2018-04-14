<html>
<head>
    <title>Welcome!</title>
</head>
<body>

<h4>Login Page</h4>

<form action="${ctx.contextPath}/login" method="POST">
    username: <input type="text" name="username"/>
    <br><br>

    password: <input type="password" name="password"/>
    <br><br>

    <input type="submit" value="Submit"/>
</form>

</body>
</html>