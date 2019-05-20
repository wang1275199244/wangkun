<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>用户注册界面</title>

    <style>
        #outer{
            border: 1px solid #ececf5;
            width: 100%;
            height: 100%;
            background: url("image/1.png") no-repeat;
        }

        #inner{
            border: 1px solid #ececf5;
            width: 350px;
            height: 349px;
            background-color: #ececf5;
            position: fixed;/*固定定位：相对于浏览器视窗定位*/
            top:121px;
            left:810px;
            position: relative;
        }

        p{
           margin-left: 40px;
        }

        #sub{
            margin-left: 60px;
            margin-right: 15px;
        }
        img{
            vertical-align:middle;
            height: 30px;
        }
        lable{
            display: inline-block;
            text-align: right;
            width: 150px;
        }

        .ab{
            background-color: #F52B00;
            color: white;
            font-size: 16px;
            border: 1px solid #F52B00;
            width: 80px;
            height: 30px;
        }
        .bc{
            width: 250px;
            height: 30px;
        }
        a{
            text-decoration: none;
            position: absolute;
            right: 50px;
            top: 300px;

        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {
            var af = false;//保存验证用户名的函数
            var bf = false;//保存验证密码的函数
            $("#name").keyup(function () {

                var name = $("#name").val();
                if(!(/^[a-zA-Z_]+[0-9a-zA-Z_]{4,9}$/).test(name)){
                    $("#span_name").html("用户名格式不正确,字母或者下划线开头，长度为5-10位");
                    $("#span_name").css({"color":"red","face":"楷体"});
                    $(":submit").attr("disabled",true);
                    af = false;
                }else{
                    $.ajax({
                        type:"post",
                        url:"checkName",
                        data:{name:$("#name").val()},
                        success:function (obj) {
                            if(obj == 0) {
                                $("#span_name").html("此用户名已经注册");
                                $("#span_name").css({"color":"red","face":"楷体"});
                                $(":submit").attr("disabled",true);
                                af = false;
                            }else{
                                $("#span_name").html("用户名可用");
                                $("#span_name").css({"color":"green","face":"楷体"});
                                $(":submit").attr("disabled",false);
                                af = true;
                            }
                        }
                    });
                }
            });
            $("#pass").keyup(function () {
                var pass = $("#pass").val();
                if(!(/^(?![0-9]*$)[a-zA-Z0-9]{6,}$/).test(pass)){
                    $("#span_pass").html("密码格式不正确,密码不能为纯数字，长度不能低于6位");
                    $("#span_pass").css({"color":"red","face":"楷体"});
                    $(":submit").attr("disabled",true);
                    bf = false;
                }else{
                    $("#span_pass").html("密码可用");
                    $("#span_pass").css({"color":"green","face":"楷体"});
                    $(":submit").attr("disabled",false);
                    bf = true
                }
            });

            $(":submit").submit(function () {
                return af&&bf;
            })

        });
    </script>
</head>
<body>
<div id="outer">
    <div id="inner">
    <h3 style="margin-left: 140px">用户注册</h3>
    <form action="register" method="post">
        <p>
            <label>用户名:</label>
            <input type="text" id="name" class="bc" name="name" required/>
            <span id="span_name"></span>
        </p>
        <p>
            <label>密　码:</label>
            <input type="password" id="pass" class="bc" name="pass" required/>
            <span id="span_pass"></span>
        </p>
        <p>
            <label>性　别:</label>
            <input type="radio" name="sex" value="男" checked/>男
            <input type="radio" name="sex" value="女"/>女
        </p>
        <input type="submit" id = "sub" class="ab" value="注 册"/>
        <input type="reset" class="ab" value="取 消"/>
    </form>
    <a href="toLogin" >登 录</a>
    </div>
</div>
</body>
</html>
