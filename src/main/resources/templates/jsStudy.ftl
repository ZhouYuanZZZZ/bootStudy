<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome!</title>
</head>
<body>


<form id="testForm" action="list.do" method="post" >

    <input type="text" name="uesrname"/>
    <input type="password" name="password"/>

    <input type="submit"/>
    <input type="reset"/>
</form>

</body>
</html>
<script src="common/jquery-3.2.1.js"></script>
<script>
    window.onload = function () {
        debugger;
        $('#testForm').reset(function (event) {
            debugger;
        });
    }
</script>