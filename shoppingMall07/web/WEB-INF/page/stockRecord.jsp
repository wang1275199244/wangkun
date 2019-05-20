<%@ page import="com.xd1810.model.StockRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/26 0026
  Time: 20:19
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
    <title>库存记录</title>
    <style>
        div{
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
            width: 1170px;
            height: 560px;
            background: #F4F4F4;
            position: absolute;
            left: 70px;
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
        }
        th{
            padding:10px;
            border: 1px solid #FF6905;
            text-align: center;
            width: 87px;
            height: 42px;
        }

        .d{
            width: 220px;
        }
        #bc{
            background:#FF6905;
            font-weight: bold;
            font-size:20px;
            color: white;
            letter-spacing:40px;
            font-family: 宋体;
        }

        #page{
            border: 1px solid #F4F4F4;
            text-align: center;
            width: 780px;
            height: 24px;
            position: absolute;
            left: 290px;
            top:560px;
        }

        .sta{
            color: white;
        }
        .time{
            width: 180px;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("tr:first").css({"background": "#FF6905", "font-size": "20px"})

            $(":input[id^='count']").css({
                "width": "75px",
                "height": "36px",
                "text-align": "center",
                "font-size": "16px"
            });

        });


    </script>
</head>
<body>
<div>
    <div><a href="page/adminSuccess.jsp">返回</a></div>
    <div id="b">

        <table>
            <tr>
                <td colspan="10" id="bc">商品库存记录管理</td>
            </tr>
            <tr>
                <th>商品ID</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品类型</th>
                <th class="d">商品描述</th>
                <th>商品产地</th>
                <th>出入库</th>
                <th>数量</th>
                <th>库存总数</th>
                <th class="time">记录时间</th>

            </tr>

            <%
                List<StockRecord> list = (List<StockRecord>)session.getAttribute("srs");
                pageContext.setAttribute("list", list);
            %>

                <c:if test="${list != null && fn:length(list) != 0}">
                    <c:forEach items="${list}" var="stockRecord" varStatus="i">
                            <tr>
                                <td>${stockRecord.good.id}</td>
                                <td>${stockRecord.good.name}</td>
                                <td>¥<span>${stockRecord.good.price}</span></td>
                                <td>${stockRecord.good.type}</td>
                                <td class="d">${stockRecord.good.description}</td>
                                <td>${stockRecord.good.factory}</td>
                                <c:if test="${stockRecord.state == 0}">
                                    <td style="background-color: green" class="sta">入库</td>
                                </c:if>
                                <c:if test="${stockRecord.state == 1}">
                                    <td style="background-color: orange" class="sta">出库</td>
                                </c:if>
                                <td>${stockRecord.gcount}</td>
                                <td>${stockRecord.good.realStock.gcount}</td>
                                <td>${stockRecord.time}</td>
                            </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${list == null||fn:length(list) == 0}">
                    <tr>
                        <td colspan="10">还没有库存记录</td>
                    </tr>
                </c:if>

        </table>

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
            <a href="stockRecord?&currentPage=${list2[i.index]}">${list2[i.index]}</a>
        </c:forEach>
    </c:if>

    页</div>
</body>
</html>
