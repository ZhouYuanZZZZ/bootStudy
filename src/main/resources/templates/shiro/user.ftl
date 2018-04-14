
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>User Page</h4>

    <shiro:hasRole name="admin">
        <h4>admin</h4>
    </shiro:hasRole>

    <shiro:hasRole name="user">
        <h4>User</h4>
    </shiro:hasRole>
	
</body>
</html>