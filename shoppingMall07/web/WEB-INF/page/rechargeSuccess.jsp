<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 18:45
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
    <title>充值成功</title>
    <style>
        #outer{
            border: 1px solid #F4F4F4;
            width: 1306px;
            background: #F4F4F4;
            position: relative;
            margin: 0px auto;
        }

        #c a{
            border: 1px solid #F4F4F4;
            width: 150px;
            height: 30px;
            text-align: center;
            text-decoration: none;
            font-size: 14px;
            padding-top: 4px;

        }

        #b{
            border: 1px solid #FF6905;
            width: 500px;
            height: 40px;
            color: white;
            text-align: center;
            vertical-align: middle;
            font-size: 27px;
            background: #FF6905;
            position: absolute;
            left: 100px;
            top:40px;
        }


        .c{
            border: 1px solid #FF6905;
            width: 500px;
            height: 40px;
            color: white;
            text-align: center;
            vertical-align: middle;
            font-size: 27px;
            background: #FF6905;
            position: absolute;
            left: 100px;
            top:85px;
        }



        span{
            border: 1px solid #F4F4F4;
            background-color: #F4F4F4;
            width: 200px;
            height: 30px;
            text-align: center;
            text-decoration: none;
            padding-top: 4px;
            position: absolute;
            left: 100px;
            top:160px;
        }

    </style>
    <script SRC="js/jquery-3.1.0.js"></script>

</head>
<body>

<div id="outer">
    <div><a href="toSuccess">返回</a></div>
    <div id="b" style="background-color: green">充值成功</div>
    <div class="c">您的账户余额为:¥${sessionScope.user1.money}</div>


</div>

</body>
</html>