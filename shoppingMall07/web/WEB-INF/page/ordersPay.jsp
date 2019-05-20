<%@ page import="java.util.List" %>
<%@ page import="com.xd1810.service.BuyDetailService" %>
<%@ page import="com.xd1810.service.UserDetailService" %>
<%@ page import="com.xd1810.model.*" %>
<%@ page import="com.xd1810.service.impl.*" %>
<%@ page import="com.xd1810.service.GoodService" %>
<%@ page import="com.xd1810.service.UserService" %><%--
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
             border: 1px solid #F4F4F4;
             width: 700px;
             height: 400px;
             background: #F4F4F4;
             position: absolute;
             left: 0px;
             top:50px;

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
              width: 310px;
              height: 169px;
              background: #F4F4F4;
              position: absolute;
              left: 180px;
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
             width: 180px;
             height: 42px;
         }

         #d1{
             width: 180px;
         }

         .bc{
             font-weight: bold;
             font-size:20px;
             letter-spacing:40px;
             font-family: 宋体;
             color: white;
         }

     </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("tr:first").css({"background":"#FF6905","font-size":"20px"});
            $("#sub").css({"background":"green","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "500px","top":"300px","letter-spacing":"5px"});


        });
    </script>
</head>
<body>
    <div id="outer">
    <div><a href="main">返回首页</a></div>
        <div id="inner">
        <form action="payOrders" method="post">

    <div id="b">
        <table>
            <tr>
                <td colspan="2" class="bc">订单支付</td>
            </tr>

            <%
                Object user = session.getAttribute("user");
                User user1 = (User)user;
                pageContext.setAttribute("user",user1);
                Orders orders = (Orders) session.getAttribute("orders1");
                pageContext.setAttribute("orders",orders);
            %>

            <tr>
                <td id="d1">订单ID</td>
                <td>${orders.id}</td>

            </tr>
            <tr>
                <td>账户余额</td>
                <td>¥${user.money}</td>

            </tr>
            <tr>
                <td>应付金额</td>
                <td>¥${orders.money}</td>

            </tr>


        </table>


        </div>
            <input type="hidden" name="orid" value="${orders.id}"/>
            <input type="hidden" name="money" value="${orders.money}"/>
            <input type="submit" id="sub" value="支付"/>
        </form>
    </div>
    </div>

</body>
</html>
