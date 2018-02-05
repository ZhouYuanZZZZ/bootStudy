<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome!</title>

    <style type="text/css">
        .first{
            border:solid #FF0000;
            height:700px;
            width: 700px;
        }
        .second{
            border:solid #00FF00
        }
        .third{
            border:solid #0000FF
        }

    </style>
</head>
<body>


<form id="testForm" action="list.do" method="post" >

    <input type="text" name="uesrname"/>
    <input type="password" name="password"/>

    <input type="submit"/>
    <input type="reset"/>
</form>

</br>

<div  class="first">
    testFirst
    <div class="second">
        testSecond
        <div class="third">
            testThird
        </div>
    </div>
</div>


</body>
</html>

<script>
    window.onload = function () {

        $(".first")[0].addEventListener('click', handlerDiv0, false);
        $(".second").mousemove(function () {
            var aaaaa = 3;
        });
        $(".first")[0].addEventListener('mousemove', showMouse, false);

        var person = new Person('will', 23);
    }

    function handlerDiv0() {

      var event = arguments[0];
    }

    function handlerDiv1() {
        var event = arguments[0];
    }

    function handlerDiv2() {
        alert('handlerDiv2');
    }

    function showMouse() {
        var event = arguments[0];
    }

    function Person(name, age){
        this.name = name;
        this.age = age;
    }

    $(document).ready(function () {
        var reg1 = new RegExp('\w')
        var reg2 = /\w/;
        var s = 'e';

    });
</script>