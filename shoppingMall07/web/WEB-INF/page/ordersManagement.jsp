<%@ page import="java.util.List" %>
<%@ page import="com.xd1810.service.BuyDetailService" %>
<%@ page import="com.xd1810.service.UserDetailService" %>
<%@ page import="com.xd1810.model.*" %>
<%@ page import="com.xd1810.service.impl.*" %>
<%@ page import="com.xd1810.service.GoodService" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/16 0008
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>订单处理界面</title>
    <style>

        #tab1 a{
            text-decoration: none;
        }
        #tab1 td{
            border: 2px solid white;
            width: 100px;
            height: 20px;
            font-size: 18px;
            background: #DDDDDD;
            text-align: center;
            padding:5px;
        }
        #outer{
            border: 1px solid #F4F4F4;
            width: 1306px;
            height: 27px;
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
            height: 550px;
            background: #F4F4F4;
            position: absolute;
            left: -18px;
            top:70px;
        }

        table{
            table-layout: fixed;
            border-collapse: collapse;
            border-spacing: 0px;
        }
        #tab2 td{
            padding:0px;
            border: 1px solid #FF6905;
            text-align: center;
            font-size: 14px;
            width: 87px;
            height: 36px;
        }
        #tab2 th{
            padding:0px;
            border: 1px solid #FF6905;
            text-align: center;
            font-size: 14px;
            width: 89px;
            height: 36px;
        }

        .d1{
            width: 130px;
        }

        .d2{
            width: 150px;
        }

        #d3{
            width: 800px;
            height: 42px;
            position: absolute;
            left: 80px;
            top:30px;
        }
        .bc{
            background:orange;
            font-weight: bold;
            font-size:16px;
            text-align: center;
            color: white;
            letter-spacing:40px;
            font-family: 宋体;
        }


        #tab1 td:hover{
            background-color: #FF6905;
        }

        #tab1 td:active{
            background-color: royalblue;
        }

        input{
            color: white;
        }

        #page{
            border: 1px solid #F4F4F4;
            text-align: center;
            width: 780px;
            height: 24px;
            position: absolute;
            left: 290px;
            top:590px;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("tr:first").css({"background":"#FF6905","font-size":"20px"});
            $("#sub1").css({"background":"green","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "1130px","top":"300px","letter-spacing":"5px"});
            $("#sub2").css({"background":"#F52B00","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "920px","top":"300px","letter-spacing":"10px"});
            $(":submit").click(function () {
                var we = $(this).parent().parent().children().first().text();
                var wr = $(this).parent().parent().children("td:eq(11)").children().text();
                $(":hidden[name='orid']").val(we);
                $(":hidden[name='money']").val(wr);

            });
        });
    </script>
</head>
<body>
<div id="outer">
    <div><a href="page/adminSuccess.jsp">返回</a></div>
    <div id="d3">
        <table id="tab1">
            <tr>
                <td>
                    <a href="ordersManagement?status=0">所有订单</a>
                </td>
                <td>
                    <a href="ordersManagement?status=1">未付款订单</a>
                </td>
                <td>
                    <a href="ordersManagement?status=2">已付款订单</a>
                </td>
                <td>
                    <a href="ordersManagement?status=3">待退款订单</a>
                </td>
                <td>
                    <a href="ordersManagement?status=4">已退款订单</a>
                </td>
                <td>
                    <a href="ordersManagement?status=5">已发货订单</a>
                </td>
                <td>
                    <a href="ordersManagement?status=6">已收货订单</a>
                </td>
            </tr>
        </table>
    </div>
    <%
        List<Orders> list = (List<Orders>) session.getAttribute("orders1");
        pageContext.setAttribute("list",list);
    %>
    <div id="b">
        <form method="post">

            <table id="tab2">
                <tr>
                    <td colspan="16" class="bc">订单信息</td>
                </tr>
                <tr>
                    <td colspan="6" class="bc">商品信息</td>
                    <td colspan="3" class="bc">收货信息</td>
                    <td colspan="5" class="bc">订单状态</td>
                    <td colspan="2" class="bc">操作</td>
                </tr>
                <tr>
                    <th>订单ID</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品类型</th>
                    <th class="d1">商品描述</th>
                    <th>商品产地</th>
                    <th>收货人</th>
                    <th>联系方式</th>
                    <th class="d2">收货地址</th>
                    <th>订单时间</th>
                    <th>购买数量</th>
                    <th>订单金额</th>
                    <th>支付状态</th>
                    <th>发货状态</th>
                    <th></th>
                    <th></th>
                </tr>

            <c:if test="${list != null && fn:length(list) != 0}">
                <c:forEach items="${list}" var="orders" varStatus="i">
                <tr>
                    <td>${orders.id}</td>
                    <td>${orders.good.name}</td>
                    <td>¥${orders.good.price}</td>
                    <td>${orders.good.type}</td>
                    <td class="d1" style="width: 130px">${orders.good.description}</td>
                    <td>${orders.good.factory}</td>
                    <td>${orders.userDetail.receiver}</td>
                    <td style="width: 100px">${orders.userDetail.phone}</td>
                    <td class="d2" style="width: 150px">${orders.userDetail.address}</td>
                    <td>${orders.time}</td>
                    <td>${orders.gcount}</td>
                    <td>¥<div>${orders.money}</div></td>

                    <c:if test="${orders.state == 0 && orders.delivery == 0}">
                        <td>未支付</td>
                        <td>未发货</td>
                        <td></td>
                        <td></td>
                    </c:if>

                    <c:if test="${orders.state == 1 && orders.delivery == 0}">
                        <td>已支付</td>
                        <td>未发货</td>
                        <td><input type="submit" formaction="confirmDelivery" style="background-color: green" id="su${i.index}" value="确认发货"/></td>
                        <td></td>
                    </c:if>

                    <c:if test="${orders.state == -1 && orders.delivery == 0}">
                        <td>待退款</td>
                        <td></td>
                        <td><input type="submit" formaction="confirmMoneyBack" style="background-color: orange" id="su${i.index}" value="确认退款"/></td>
                        <td></td>
                    </c:if>

                    <c:if test="${orders.state == 2 && orders.delivery == 0}">
                        <td>已退款</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </c:if>

                    <c:if test="${orders.state == 1 && orders.delivery == 1}">
                        <td></td>
                        <td>已发货</td>
                        <td></td>
                        <td></td>
                    </c:if>

                    <c:if test="${orders.state == 1 && orders.delivery == 2}">
                        <td></td>
                        <td>已收货</td>
                        <td></td>
                        <td></td>
                    </c:if>
                </tr>

                </c:forEach>
            </c:if>
            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td colspan="16" id="noGood">还没有订单</td>
                </tr>

            </c:if>
            </table>
            <input type="hidden" name="orid" value=""/>
            <input type="hidden" name="money" value=""/>

            </form>
        </div>

</div>
<%
    int tp =  (int)session.getAttribute("tp");
    List list2 = new ArrayList();
    for (int i = 1; i <= tp; i++) {
        list2.add(i);
    }
    request.setAttribute("list2",list2);
%>
<div id="page">第
    <c:if test="${list2 != null && fn:length(list2) != 0}">
        <c:forEach items="${list2}" varStatus="i">
            <a href="ordersManagement?currentPage=${list2[i.index]}">${list2[i.index]}</a>
        </c:forEach>
    </c:if>

    页</div>
</body>
</html>
