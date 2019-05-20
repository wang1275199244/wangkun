<%@ page import="com.xd1810.model.User" %>
<%@ page import="com.xd1810.model.UserDetail" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.xd1810.service.UserService" %>
<%@ page import="com.xd1810.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %><%--
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
    <title>用户详情界面</title>
     <style>
         div{
             border: 1px solid #F4F4F4;
             width: 1306px;
             background: #F4F4F4;
             position: relative;
             margin: 0px auto;
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

         #b1{
             border: 1px solid #FF6905;
             width: 1020px;
             height: 450px;
             background: #F4F4F4;
             position: absolute;
             left: 130px;
             top:60px;
         }

         #b2{
             border: 1px solid #FF6905;
             width: 1020px;
             height: 128px;
             background: #F4F4F4;
             position: absolute;
             left: 130px;
             top:472px;
         }
         .bc{
             background:#FF6905;
             font-weight: bold;
             font-size:20px;
             color: white;
             letter-spacing:40px;
             font-family: 宋体;
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
             width: 106px;
             height: 42px;
         }

         #noGood{
             border: 1px solid #FF6905;
             width: 998px;
             height: 22px;
             text-align: center;
             background: #F4F4F4;
             position: absolute;
             left: 0px;
             top:87px;
         }

         .td1{
             padding: 0px;
             border: 1px solid #FF6905;
             width: 106px;
             height: 40px;
         }

         .in{
            width: 80px;
             height: 25px;
             background-color: #FF6905;
             color: white;
         }

         #addre{
             width: 400px;
         }
     </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $(":input[id^='receiver']").css({
                "width": "120px",
                "height": "35px",
                "text-align": "center",
                "font-size": "16px"
            });
            $(":input[id='re']").css({
                "width": "120px",
                "height": "35px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":input[id^='phone']").css({
                "width": "150px",
                "height": "35px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":input[id='ph']").css({
                "width": "150px",
                "height": "35px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":input[id^='address']").css({
                "width": "400px",
                "height": "35px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":input[id='ad']").css({
                "width": "400px",
                "height": "35px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":submit[id='sub']").click(function () {
                var receiver = $("#re").val();
                var phone = $("#ph").val();
                var address = $("#ad").val();
                $(":hidden[name='receiver1']").attr("value",receiver);
                $(":hidden[name='phone1']").attr("value",phone);
                $(":hidden[name='address1']").attr("value",address);
            });

            $(":submit[id^='tb']").click(function () {
                var id = parseInt($(this).parent().parent().first().text());
                var receiver = $(this).parent().prev().prev().prev().children().val();
                var phone = $(this).parent().prev().prev().children().val();
                var address = $(this).parent().prev().children().val();
                $(":hidden[name='id2']").attr("value",id);
                $(":hidden[name='receiver2']").attr("value",receiver);
                $(":hidden[name='phone2']").attr("value",phone);
                $(":hidden[name='address2']").attr("value",address);

            });

            $(":submit[id^='ab']").click(function () {
                var id = parseInt($(this).parent().parent().first().text());
                $(":hidden[name='id2']").attr("value",id);
            });
        });

    </script>
</head>
<body>
    <div>
    <div id="a">
        <div><a href="toSuccess">返回</a></div>
    </div>
    <div id="b1">
        <table id="tab1">
            <tr>
                <td colspan="6" class="bc">用户信息详情</td>
            </tr>
            <tr>
                <th>ID</th>
                <th>收货人</th>
                <th>联系方式</th>
                <th id="addre">联系地址</th>
                <th></th>
                <th></th>
            </tr>
            <%
                List<UserDetail> userDetails = (List<UserDetail>) session.getAttribute("uds1");
                pageContext.setAttribute("uds",userDetails);
            %>
<c:if test="${uds != null && fn:length(uds) != 0}">
    <c:forEach items="${uds}" var="userDetail" varStatus="i">
            <form method="post" id="form${i.index}">
            <tr>
                <td>${userDetail.id}</td>
                <td style="padding: 4px"><input class="inp" id="receiver${i.index}" name="receiver" value="${userDetail.receiver}" required/></td>
                <td style="padding: 4px"><input class="inp" id="phone${i.index}" name="phone" value="${userDetail.phone}" required/></td>
                <td style="padding: 4px"><input class="inp" id="address${i.index}" name="address" value="${userDetail.address}" required/></td>


                    <td class="td1"><input type="submit" formaction="updateUserDetail" style="background-color: green" value="更新详情"id="tb${i.index}" class="in"/></td>
                    <td class="td1"><input type="submit" formaction="delUserDetail" style="background-color: orange" value="删除详情" id="ab${i.index}" class="in"/></td>

                <input type="hidden" name="id2" />
                <input type="hidden" name="receiver2" />
                <input type="hidden" name="phone2" />
                <input type="hidden" name="address2" />
            </tr>
            </form>
    </c:forEach>
</c:if>
<c:if test="${uds == null || fn:length(uds) == 0}">
            <tr>
                <td colspan="6" id="noGood">没有任何详情，请添加</td>
            </tr>
</c:if>

        </table>

    </div>

        <div id="b2">
            <table>
                <tr>
                    <td colspan="6" class="bc">添加用户信息详情</td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>收货人</th>
                    <th>联系方式</th>
                    <th>联系地址</th>
                    <th></th>
                    <th></th>

                </tr>

                <form action="addUserDetail" method="post">
                    <tr>
                        <td></td>
                        <td style="padding: 4px"><input id="re" name="receiver" required/></td>
                        <td style="padding: 4px"><input id="ph" name="phone" required/></td>
                        <td style="padding: 4px"><input id="ad" name="address" required/></td>


                        <input type="hidden" name="id1" />
                        <input type="hidden" name="receiver1" />
                        <input type="hidden" name="phone1" />
                        <input type="hidden" name="address1" />
                        <td class="td1"><input type="submit" style="background-color: green" value="添加详情"id="sub" class="in"/></td>
                        <td class="td1"><input type="reset" style="background-color: orange" value="取消" class="in"/></td>


                    </tr>
                </form>

            </table>

        </div>

    </div>

</body>
</html>
