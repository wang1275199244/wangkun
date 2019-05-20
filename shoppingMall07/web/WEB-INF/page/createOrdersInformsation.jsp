<%@ page import="com.xd1810.model.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25 0008
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
    <title>购物信息</title>
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
              width: 800px;
              height: 129px;
              background: #F4F4F4;
              position: absolute;
              left: 240px;
              top:40px;
          }

         #la{
             border: 1px solid #FF6905;
             width: 800px;
             height: 450px;
             background: #F4F4F4;
             position: absolute;
             left: 240px;
             top:170px;
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

         #d1{
             width: 130px;
         }

         #d2{
             width: 500px;
         }
         .bc{
             background:#FF6905;
             font-weight: bold;
             font-size:20px;
             color: white;
             letter-spacing:40px;
             font-family: 宋体;
         }

     </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("tr:first").css({"background":"#FF6905","font-size":"20px"});
            $(":submit").css({"background":"green","color":"white","font-size":"20px","position":"absolute","left": "900px","top":"580px"});
            $(":radio:first").attr("checked","checked");

        });
    </script>
</head>
<body>
    <div id="outer">
    <div><a href="main">返回首页</a></div>
        <form action="addOrders" method="post">
    <div id="b">
        <table>
            <tr>
                <td colspan="7" class="bc">商品信息</td>
            </tr>
            <tr>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品类型</th>
                <th id="d1">商品描述</th>
                <th>商品产地</th>
                <th>购买数量</th>
                <th>小计</th>
            </tr>

            <%
                User user = (User) session.getAttribute("user");
                pageContext.setAttribute("user",user);

                Good good = (Good) request.getAttribute("gd");
                pageContext.setAttribute("good",good);
                Integer gcount = (Integer) session.getAttribute("got");
                pageContext.setAttribute("gcount",gcount);
            %>

            <tr>

                <td>${good.name}</td>
                <td>¥${good.price}</td>
                <td>${good.type}</td>
                <td class="d">${good.description}</td>
                <td>${good.factory}</td>
                <td>${gcount}</td>
                <td>¥${good.price*gcount}</td>

            </tr>

        </table>

    </div>

        <div id="la">
            <table>
                <tr>
                    <td colspan="7" class="bc">收货信息</td>
                </tr>
                <tr>
                    <th></th>
                    <th>收货人</th>
                    <th>联系方式</th>
                    <th id="d2" colspan="4">收货地址</th>
                </tr>

                <%
                    List<UserDetail> list = (List<UserDetail>) session.getAttribute("udls");
                    pageContext.setAttribute("list",list);
                %>
<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="userDetail" varStatus="i">
                <tr>

                        <td><input type="radio" name="udid" value="${userDetail.id}"/></td>
                        <td>${userDetail.receiver}</td>
                        <td>${userDetail.phone}</td>
                        <td colspan="4">${userDetail.address}</td>

                </tr>
    </c:forEach>
</c:if>
<c:if test="${list == null || fn:length(list) == 0}">

                  <tr>
                      <td colspan="7"><a href="toShowUserDetail">添加收货信息</a></td>
                  </tr>
</c:if>

            </table>

        </div>
            <input type="hidden" name="gid" value="${good.id}"/>
            <input type="hidden" name="gcount" value="${gcount}"/>
            <input type="submit" value="生成订单"/>
        </form>
    </div>

</body>
</html>
