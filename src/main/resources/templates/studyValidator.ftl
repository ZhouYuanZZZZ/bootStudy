<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome!</title>

    <style type="text/css">
        input {
            display: block;
        }

        label.error{
            color: #ff0b23;
        }

    </style>
</head>
<body>


<form id="testForm" action="list.do" method="post">

    <input type="text" name="uesrname1"/>
    <input type="text" name="uesrname2"/>
    <input type="text" name="uesrname3"/>
    <input type="text" name="uesrname4"/>
    <input type="text" name="uesrname5"/>
    <input type="password" name="password"/>
    <input type="submit"/>
    <input type="reset"/>
</form>

</body>
</html>
<script src="common/jquery-3.2.1.js"></script>
<script src="common/jquery.validate.js"></script>

<script>
    window.onload = function () {
        var validate = $("#testForm").validate({
            debug: true, //调试模式取消submit的默认提交功能
            //errorClass: "label.error", //默认为错误的样式类为：error
            focusInvalid: true,
            onkeyup: false,
            submitHandler: function (form) {   //表单提交句柄,为一回调函数，带一个参数：form
                alert("提交表单");
                form.submit();   //提交表单
            },

            rules: {
                uesrname1: {
                    required: true,
                    number:true
                },

                uesrname2: {
                    required: true
                },

            },
            messages: {
                uesrname1: {
                    required: "必填"
                }
            }
        });


    }

</script>