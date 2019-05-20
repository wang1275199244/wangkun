<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
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
    <title>订单支付</title>
     <style>
         #outer{
             border: 1px solid #F4F4F4;
             width: 1306px;
             background: #F4F4F4;
             position: relative;
             margin: 0px auto;
         }

         #inner{
             border: 1px solid #FF6905;
             width: 500px;
             height: 300px;
             background: #FF6905;
             position: absolute;
             left: 100px;
             top:40px;
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
              left: -1px;
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
             left: -1px;
             top:85px;
         }

         .ad{
             border: 1px solid #F4F4F4;
             background-color: #F4F4F4;
             width: 100px;
             height: 30px;
             text-align: center;
             text-decoration: none;
             padding-top: 4px;
             position: absolute;
             left: 100px;
             top:200px;
         }

         #mid{
             border: 1px solid #F4F4F4;
             background-color: #F4F4F4;
             width: 100px;
             height: 30px;
             text-align: center;
             text-decoration: none;
             padding-top: 4px;
             position: absolute;
             left: 310px;
             top:200px;
         }

         .ad:hover{
             background-color: green;
         }

         .ad:active{
             background-color: royalblue;
         }
         #mid:hover{
             background-color: green;
         }

         #mid:active{
             background-color: royalblue;
         }



     </style>
    <script SRC="js/jquery-3.1.0.js"></script>

</head>
<body>

    <div id="outer">
        <div><a href="main">返回首页</a></div>
        <div id="inner">

            <c:if test="${sessionScope.strog == 0}">
                <div id="b">支付成功，欢迎您再次购物</div>
                <div class="c">您的账户余额为:¥ ${sessionScope.mone}</div>
                <div class="ad">
                    <a id="a1" href="main">继续购物</a>
                </div>
                <div id="mid">
                    <a id="a2" href="toShowOrders">查看订单</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.strog == 1}">
                <div id="b">您的余额不足，请充值</div>
                <div class="c">您的账户余额为:¥ ${sessionScope.mone}</div>
                <div class="ad">
                    <a href="toRechargeConfirm">去充值</a>
                </div>
        </c:if>
        </div>
    </div>

</body>
</html>
