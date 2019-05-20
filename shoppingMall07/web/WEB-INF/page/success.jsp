<%@ page import="com.xd1810.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/9 0009
  Time: 1:25
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
    <title>Title</title>
    <style>
        a{
            text-decoration: none;
        }
        td{
            border: 1px solid #DDDDDD;
            width: 100px;
            height: 20px;
            background: #DDDDDD;
            text-align: center;
        }
        td:hover{
            background-color: #FF6905;
        }

        td:active{
            background-color: royalblue;
        }
    </style>


</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user",user);
%>

    <h4 style="font-weight: normal; font-family: 宋体">欢迎您，${user.name}</h4>
<table>
    <tr>
        <td>
            <a href="toShowUserDetail">我的个人信息</a>
        </td>
        <td>
            <a href="toShowOrders">我的订单</a>
        </td>
        <td>
            <a href="toShowBuyCar">我的购物车</a>
        </td>
        <td>
            <a href="toMyWallet">我的钱包</a>
        </td>
        <td>
            <a href="main">返回首页</a>
        </td>
    </tr>
</table>
</body>
</html>
