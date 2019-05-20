<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xd1810.model.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/21 0021
  Time: 0:30
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
    <title>商品评论</title>
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

        #b{
            border: 1px solid #FF6905;
            width: 900px;
            height: 560px;
            background: #F4F4F4;
            position: absolute;
            left: 130px;
            top:60px;
        }
        table{
            table-layout: fixed;
            border-collapse: collapse;
            border-spacing: 0px;
            width: 900px;
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

        #page{
            border: 1px solid #F4F4F4;
            text-align: center;
            width: 780px;
            height: 24px;
            position: absolute;
            left: 200px;
            top:590px;
        }
        .d{
            width: 130px;
        }

        #bc{
            background:#FF6905;
            font-weight: bold;
            font-size:20px;
            color: white;
            letter-spacing:40px;
            font-family: 宋体;
        }

        .cd{
            background:orange;
            font-weight: bold;
            font-size:20px;
            color: white;
            letter-spacing:20px;
            font-family: 宋体;
        }

        #noGood{
            border: 1px solid #FF6905;
            width: 878px;
            height: 24px;
            text-align: center;
            background: #F4F4F4;
            position: absolute;
            left: 0px;
            top:173px;
        }

        #use{
            letter-spacing:5px;
        }

        .com{
            width: 200px;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
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
    <div id="a">
        <div><a href="page/goodComment.jsp">返回</a></div>
    </div>
    <div id="b">
        <table>
            <tr>
                <td colspan="6" id="bc">商品评论</td>
            </tr>
            <tr>
                <th>商品ID</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品类型</th>
                <th class="d">商品描述</th>
                <th>商品产地</th>
            </tr>

            <%
                Good good = (Good) session.getAttribute("good3");
                pageContext.setAttribute("good", good);

            %>

            <tr>
                <td>${good.id}</td>
                <td>${good.name}</td>
                <td>¥ ${good.price}</td>
                <td>${good.type}</td>
                <td class="d">${good.description}</td>
                <td>${good.factory}</td>
            </tr>

            <tr>
                <th class="cd">用户名</th>
                <th colspan="5" class="cd">评论</th>
            </tr>
            <%
                List<Comment> list = (List<Comment>)session.getAttribute("comments1");
                pageContext.setAttribute("list", list);

            %>
            <c:if test="${list != null && fn:length(list) != 0}">
                <c:forEach items="${list}" var="comments">

                    <tr>
                        <td>${comments.user.name}</td>
                        <td colspan="5">${comments.comment}</td>
                    </tr>

                </c:forEach>
            </c:if>
            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td colspan="6">还没有任何评论，请添加</td>
                </tr>
            </c:if>
        </table>
    </div>

</div>

    <%
        int tp =  (int)session.getAttribute("tp3");
        List list2 = new ArrayList();
        for (int i = 1; i <= tp; i++) {
            list2.add(i);
        }
        request.setAttribute("list2",list2);
    %>
<div id="page">第

    <c:if test="${list2 != null && fn:length(list2) != 0}">
        <c:forEach items="${list2}" varStatus="i">
            <a href="adminGetComments?&currentPage2=${list2[i.index]}">${list2[i.index]}</a>
        </c:forEach>
    </c:if>
    页</div>

</body>
</html>
