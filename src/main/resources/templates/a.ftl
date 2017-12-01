<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>
    <!--if指令-->
    Welcome ${user}<#if user == "Big Joe">, our beloved leader</#if>
</h1>

<ul>
    <!--list指令-->
    <#list listName as item>
        <li>item</li>
    </#list>
</ul>

</body>
</html>