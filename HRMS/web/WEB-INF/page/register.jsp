<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/70008
  Time: 16:26
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
        }

        #inner{
            border: 1px solid #ececf5;
            width: 800px;
            height: 450px;
            background-color: #ececf5;
            position: relative;
            left:230px;
            top:50px;

        }

        p{
           margin-left: 90px;
            margin-top: 20px;
        }

        img{
            vertical-align:middle;
            height: 30px;
        }
        label{
            display: inline-block;
            text-align: right;
            width: 150px;
        }

        #sub{
            font-size: 16px;
            margin-left: 235px;
            margin-right: 80px;

        }

        #res{
            font-size: 16px;
        }

        .bc{
            width: 250px;
            height: 30px;
            margin-bottom: 20px;
        }
        a{
            text-decoration: none;
            position: absolute;
            right: 160px;
            top: 320px;

        }

        span{
            position: absolute;
            left: 240px;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {
            $("#name").blur(function () {

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
            $("#pass").blur(function () {
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

            $("#pass1").blur(function () {
                var pass = $("#pass").val();
                var pass1 = $("#pass1").val();
                if(pass != pass1){
                    $("#span_pass1").html("两次密码输入不一致，请重新输入");
                    $("#span_pass1").css({"color":"red","face":"楷体"});
                    $(":submit").attr("disabled",true);
                    cf = false;
                }else{
                    $("#span_pass1").html("OK");
                    $("#span_pass1").css({"color":"green","face":"楷体"});
                    $(":submit").attr("disabled",false);
                    cf = true
                }
            });


            $(":submit").submit(function () {
                return af&&bf&&cf;
            })

        });
    </script>
</head>
<body>
<div id="outer">
    <div id="inner">
    <h3 style="margin-left: 350px">用户注册</h3>
    <form action="register" method="post">
        <p>
            <label>用户名:</label>
            <input type="text" id="name" class="bc" name="name" placeholder="请输入用户名" required/></br>
            <span id="span_name"></span></br>
        </p>
        <p>
            <label>密   码:</label>
            <input type="password" id="pass" class="bc" name="pass" placeholder="请输入密码"  required/></br>
            <span id="span_pass"></span></br>
        </p>
        <p>
            <label>确认密码:</label>
            <input type="password" id="pass1" class="bc" placeholder="请再次输入密码" required/></br>
            <span id="span_pass1"></span></br>
        </p>
        <input type="submit" id = "sub" class="ab" value="注 册"/>
        <input type="reset" id="res" class="ab" value="取 消"/>
    </form>
    <a href="visitorLogin">登 录</a>
    </div>
</div>
</body>
</html>
