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
        String ad = String.valueOf(session.getAttribute("ad"));
    %>

    <h4 style="font-weight: normal; font-family: 宋体">欢迎您，<%=ad%></h4>
<table>
    <tr>
        <td>
            <a href="goodsManagement">商品管理</a>
        </td>
        <td>
            <a href="ordersManagement">订单管理</a>
        </td>
        <td>
            <a href="stockRecord">库存记录管理</a>
        </td>
        <td>
            <a href="goodComment">商品评论管理</a>
        </td>
        <td>
            <a href="index.jsp">返回</a>
        </td>
    </tr>
</table>
</body>
</html>
