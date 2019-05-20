<%@ page import="com.xd1810.model.*" %>
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
    <title>订单评价</title>
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
            width: 1340px;
            height: 311px;
            background: #F4F4F4;
            position: absolute;
            left: -18px;
            top:40px;
        }

        table{
            table-layout: fixed;
            border-collapse: collapse;
            border-spacing: 0px;
        }
        td{
            padding:10px;
            border: 1px solid #FF6905;
            text-align: center;
            width: 87px;
            height: 42px;
            font-size: 14px;
        }
        th{
            padding:10px;
            border: 1px solid #FF6905;
            text-align: center;
            width: 87px;
            height: 42px;
            font-size: 14px;
        }

        #d1{
            width: 130px;
        }

        #d2{
            width: 200px;
        }
        .bc{
            font-weight: bold;
            font-size:20px;
            color: white;
            background-color: darkorange;
            letter-spacing:40px;
            font-family: 宋体;
        }
        #com{
            width: 1100px;
            height: 100px;
        }

        #a{
            position: absolute;
            left: 0px;
            top:0px;
            border: 1px solid #F4F4F4;
            width: 1306px;
            height: 27px;
            background: #F4F4F4;
        }

    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("tr:first").css({"background":"#FF6905","font-size":"20px"});
            $("#sub").css({"background":"green","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "1130px","top":"330px","letter-spacing":"5px"});
            $("#res").css({"background":"orange","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "920px","top":"330px","letter-spacing":"10px"});

        });
    </script>
</head>
<body>
<div id="outer">
    <div id="a">
        <a href="main">返回首页</a>
    </div>
    <form action="comment" method="post">
        <div id="b">
            <table>
                <tr>
                    <td colspan="12" class="bc">订单信息</td>
                </tr>
                <tr>
                    <td colspan="5" class="bc">商品信息</td>
                    <td colspan="3" class="bc">收货信息</td>
                    <td colspan="4" class="bc">订单状态</td>
                </tr>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品类型</th>
                    <th id="d1">商品描述</th>
                    <th>商品产地</th>
                    <th>收货人</th>
                    <th>联系方式</th>
                    <th id="d2">收货地址</th>
                    <th>购买数量</th>
                    <th>订单时间</th>
                    <th>订单金额</th>
                    <th>支付状态</th>
                </tr>
                <%
                    Orders orders = (Orders) session.getAttribute("orders2");
                    pageContext.setAttribute("orders",orders);
                %>

                <tr>

                    <td>${orders.good.name}</td>
                    <td>¥${orders.good.price}</td>
                    <td>${orders.good.type}</td>
                    <td class="d">${orders.good.description}</td>
                    <td>${orders.good.factory}</td>
                    <td>${orders.userDetail.receiver}</td>
                    <td>${orders.userDetail.phone}</td>
                    <td>${orders.userDetail.address}</td>
                    <td>${orders.gcount}</td>
                    <td>${orders.time}</td>
                    <td>¥${orders.money}</td>
                    <td>已收货</td>

                </tr>
                <tr>
                    <td>评论内容</td>
                    <td colspan="12"><textarea name="comment" id="com" cols="12" rows="3" placeholder="请输入评论内容，字数在100以内" required></textarea></td>
                </tr>
            </table>

            <input type="hidden" name="orid" value="${orders.id}"/>
            <input type="submit" id="sub" value="提交评论"/>
            <input type="reset" id="res" value="取消"/>
        </div>

    </form>
</div>

</body>
</html>
