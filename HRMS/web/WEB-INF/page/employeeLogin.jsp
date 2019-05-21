<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/15 0015
  Time: 15:47
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
    <title>员工登录界面</title>
    <style>
        #outer{
            border: 1px solid #ececf5;
            width: 100%;
            height: 100%;
        }

        #inner{
            border: 1px solid #ececf5;
            width: 350px;
            height: 349px;
            background-color: #ececf5;
            position: fixed;
            top:121px;
            left:780px;
        }

        h3{
            position: absolute;
            left: 140px;
            top:17px;
        }
        #in1{
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
            width: 300px;
            height: 42px;

        }
        #in3{
            position: absolute;
            left: 27px;
            top: 230px;
            font-size: 16px;
            border: 1px solid #DDDDDD;
            width: 300px;
            height: 42px;
        }


        a{
            text-decoration: none;
            position: absolute;
            right: 50px;
            top: 300px;

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
        <h3>员工登录</h3>
        <form action="employeeLogin" method="post">
            <div id="in1">
                <input type="text" class="be" name="account" placeholder="请输入登录张账号" required/>
            </div>
            <div id="in2">
                <input type="password" class="be" name="pass" placeholder="请输入密码" required/>
            </div>
            <input type="submit" id="in3" value="登 录"/>

        </form>
    </div>
</div>
</body>
</html>
