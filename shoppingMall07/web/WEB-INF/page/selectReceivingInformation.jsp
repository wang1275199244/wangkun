<%@ page import="com.xd1810.model.*" %>
<%@ page import="java.util.Set" %><%--
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

            $(":submit").css({"background":"green","color":"white","font-size":"20px","position":"absolute","left": "900px","top":"580px","letter-spacing":"10px","text-align":"center"});
            $(":radio:first").attr("checked","checked");

        });
    </script>
</head>
<body>
    <div id="outer">
    <div><a href="showBuyCar">返回</a></div>
        <form action="processManyOrders" method="post">

        <div id="la">
            <table>
                <tr>
                    <td colspan="7" class="bc">选择收货信息</td>
                </tr>
                <tr>
                    <th></th>
                    <th>收货人</th>
                    <th>联系方式</th>
                    <th id="d2" colspan="4">收货地址</th>
                </tr>

                <%
                    Set<UserDetail> udset = (Set<UserDetail>) session.getAttribute("udls");
                    pageContext.setAttribute("set",udset);
                %>
<c:if test="${set != null && fn:length(set) != 0}">
    <c:forEach items="${set}" var="userDetail" varStatus="i">
                <tr>

                        <td><input type="radio" name="udid" value="${userDetail.id}"/></td>
                        <td>${userDetail.receiver}</td>
                        <td>${userDetail.phone}</td>
                        <td colspan="4">${userDetail.address}</td>

                </tr>
    </c:forEach>
</c:if>
<c:if test="${set == null || fn:length(set) == 0}">

                  <tr>
                      <td colspan="7"><a href="showUserDetail">添加收货信息</a></td>
                  </tr>
</c:if>

            </table>

        </div>
            <input type="hidden" name="method" value="confirmManyOrders"/>
            <input type="submit" value="确认"/>
        </form>
    </div>

</body>
</html>
