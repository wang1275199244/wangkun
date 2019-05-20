<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 18:58
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
    <title>登录界面</title>
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
            height: 350px;
            background-color: #ececf5;
            position: fixed;/*固定定位：相对于浏览器视窗定位*/
            top:121px;
            left:847px;
            position: relative;
        }

        h4{
            position: absolute;
            left: 136px;
            top:16px;
        }
        #in1{
            background: url("image/uname.png") no-repeat;
            background-size: 42px 42px;
            background-position: left;
            border: 1px solid #DDDDDD;
            width: 300px;
            height: 42px;
            position: absolute;
            left: 27px;
            top: 90px;
        }
        #in2{
            background: url("image/password.png") no-repeat;
            background-size: 42px 42px;
            background-position: left;
            border: 1px solid #DDDDDD;
            width: 300px;
            height: 42px;
            position: absolute;
            left: 27px;
            top: 160px;
        }
        input{
            border: 1px solid #DDDDDD;
            width: 262px;
            height: 42px;

        }
        #in3{
            position: absolute;
            left: 27px;
            top: 230px;
            background-color: #F52B00;
            color: white;
            font-size: 16px;
            border: 1px solid #DDDDDD;
            width: 300px;
            height: 42px;
        }

        .be{
            transform: translateX(40px);
        }
        a{
            text-decoration: none;
            position: absolute;
            right: 50px;
            top: 300px;

        }

        #in4{
            width: 15px;
            height: 15px;
            vertical-align: middle;
        }
        p{
            margin-left: 50px;
            margin-top: 300px;
        }
    </style>
</head>
<body>
<div id="outer">
    <div id="inner">
        <h4>管理员登录</h4>
        <form action="test2" method="post">
        <div id="in1">
        <input type="text" class="be" name="name" placeholder="请输入用户名" required/>
        </div>
        <div id="in2">
        <input type="password" class="be" name="pass" placeholder="请输入密码" required/>
        </div>
            <input type="submit" id="in3" value="登 录"/>
            <p><input type="checkbox" id="in4" name="log"/>记住账号密码</p>
            <input type="hidden" name="method" value="adminLogin"/>
        </form>

    </div>
</div>
</body>
</html>
