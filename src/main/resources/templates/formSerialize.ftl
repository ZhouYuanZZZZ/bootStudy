<html>
<head>
    <title>Welcome!</title>
<#include "/common/head.ftl"/>

</head>
<body>

<form id="testForm">
   1 <input type="checkbox" name="username"/>
   2 <input type="checkbox" name="username"/>
   3 <input type="checkbox" name="username"/>
    <input type="password" name="password"/>
    <button id="submit">Submit</button>
</form>


</body>
</html>

<script type="text/javascript">
    $(document).ready(function () {
        $('#submit').click(function () {
            var form = $('#testForm');
            console.log(form.serialize());
            console.log(form.serializeArray());
            return false;
        });

    });

</script>