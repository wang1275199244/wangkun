<%@ page import="java.util.List" %>
<%@ page import="com.xd1810.model.User" %>
<%@ page import="com.xd1810.model.Good" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xd1810.model.GoodFand" %>

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
    <title>主界面</title>
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
            height: 122px;
            background: #F4F4F4;
            text-decoration: none;
        }
         #c{
             position: absolute;
             left: 0px;
             top:0px;
             border: 1px solid #F4F4F4;
             width: 1306px;
             height: 35px;
             background: #F4F4F4;
         }

         .a1{
             display: block;
             border: 1px solid #F4F4F4;
             width: 120px;
             height: 30px;
             text-align: center;
             text-decoration: none;
             font-size: 14px;
             padding-top: 4px;
             margin-left: 45px;
             float: left;
         }
         .a2{
             display: block;
             border: 1px solid #F4F4F4;
             width: 70px;
             height: 30px;
             text-align: center;
             text-decoration: none;
             font-size: 14px;
             padding-top: 4px;
             float: left;
         }
         #in1{
             border: 2px solid #FF6905;
             width: 630px;
             height: 40px;
             margin-left: 290px;
             margin-top: 40px;
         }

         #in2{
             border: 1px solid #FF6905;
             background: #FF6905;
             width: 80px;
             height: 40px;
             color: white;
             font-size: 16px;
             margin-left: -85px;

         }
         #b{
             border: 1px solid #FF6905;
             width: 1160px;
             height: 450px;
             background: #F4F4F4;
             position: absolute;
             left: 90px;
             top:165px;
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

         #page{
             border: 1px solid #F4F4F4;
             text-align: center;
             width: 780px;
             height: 24px;
             position: absolute;
             left: 290px;
             top:590px;
         }
         .d{
             width: 130px;
         }
         #noGood{
             border: 1px solid #FF6905;
             width: 1088px;
             height: 24px;
             text-align: center;
             background: #F4F4F4;
             position: absolute;
             left: 0px;
             top:43px;
         }

         .jia{
             width: 39px;
             height: 16px;
             font-size: 16px;
             font-weight: bold;
             padding: 1px;
             background-color: silver;
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
             color: white;
         }

         ul{
             border: 1px solid white;
             width: 507px;
             position: absolute;
             left: 290px;
             top:64px;
             z-index: 2;
             background-color: white;
         }

         li{
             list-style-type: none;
             margin-bottom: 5px;
             text-align: left;
         }
         li:hover{
             background-color: steelblue;
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

            $("td[id^='add']").click(function () {
                var a = $(this).next().children().val();
                if (a == "" || undefined || null || a <= 1) {
                    $(this).next().children().val(1);
                }

                $(this).next().children().val(parseInt(a) + 1);
                $(this).next().children().attr("value", parseInt(a));

                if (a >= 5) {
                    $(this).next().children().val(5);
                }
            });
            $("td[id^='sub']").click(function () {
                var b = $(this).prev().children().val();
                $(this).prev().children().val(parseInt(b) - 1);
                if (b <= 1) {
                    $(this).prev().children().val(1);
                }
            });
            $(":input[id^='count']").blur(function () {
                var val = $(this).val();
                var gcount = $(this).parent().prev().prev().text();
                if (!(/[1-5]{1}$/).test(val)||(parseInt(gcount)-parseInt(val)<=0)) {
                    alert("你输入的数据不合法，只能输入1-5,请确认库存");
                    $(":input[class = in]").attr("disabled",true);
                } else {
                    $(":input[class = in]").attr("disabled",false);
                }
            });

            $(":input[id='in1']").keyup(function () {
                var inComment = $("#in1").val()
                if(!inComment == null||!inComment == "") {
                    $.ajax({
                        type: "post",
                        url: "search",
                        dataType: "json",
                        data: {searchComment: $("#in1").val()},
                        success: function (obj) {
                            if (obj != null) {
                                var goods = obj.goods;
                                for (var i = 0; i < goods.length; i++) {
                                    console.log(goods[i].name)
                                    $("ul").append("<li><a href=\"https://www.baidu.com/s?wd="+goods[i].name + "\">" + goods[i].name + "</a></li>");
                                }
                            }

                        }
                    });
                }else {
                    $("ul").html("");
                }

            })
        });

    </script>
</head>
<body>
    <div>
    <div id="a">
    <form action="search" method="post">
        <input type="text" id="in1" value=""/>
        <input type="submit" id="in2" value="搜索"/>
    </form>
        <ul>
            <li><a href="https://www.baidu.com/s?wd="></a></li>
        </ul>
    </div>
    <div id="b">
        <table>
            <tr>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品类型</th>
                <th class="d">商品描述</th>
                <th>商品产地</th>
                <th>商品库存</th>
                <th colspan="3">购买数量</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <%
                List<GoodFand> list = (List<GoodFand>) session.getAttribute("goodFands");
                pageContext.setAttribute("list",list);
            %>

<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="goodFand" varStatus="i">
        <form action="createOrdersInformation" method="post" id="form${i.index}">
            <tr>
                <td>${goodFand.good.name}</td>
                <td>¥ ${goodFand.good.price}</td>
                <td>${goodFand.good.type}</td>
                <td class="d">${goodFand.good.description}</td>
                <td>${goodFand.good.factory}</td>
                <td>${goodFand.stock.gcount}</td>
                <td class="jia" id="add${i.index}">+</td>
                <td style="padding: 0px"><input id="count${i.index}" name="gcount" value="${1}" required/></td>
                <td class="jia" id="sub${i.index}">-</td>
                    <input type="hidden" name="id" value="${goodFand.good.id}"/>
                    <td class="td1"><input type="submit" value="立即购买"id="tb${i.index}" class="in" style="background-color: green"/></td>
                    <td class="td1"><input type="submit" formaction="addBuyDetail" value="加入购物车" id="ab${i.index}" class="in" style="background-color: #FF6905"/></td>
                    <td class="td1"><input type="submit" formaction="getComments" value="查看评论" id="co${i.index}" class="in" style="background-color: orange"/></td>


            </tr>
        </form>
    </c:forEach>
</c:if>
<c:if test="${list == null || fn:length(list) == 0}">
            <tr>
                <td colspan="12" id="noGood">没有任何商品，请添加</td>
            </tr>

</c:if>

        </table>

        <%
            User user = (User) session.getAttribute("user");
            request.setAttribute("u",user);
        %>

    </div>
    <div id="c">
        <span>
            <c:if test="${requestScope.u == null}">
        <a href="checkLogin" class="a1">亲,请登录</a>
        <a href="toRegister" class="a2">免费注册</a>
            </c:if>
            <c:if test="${requestScope.u != null}">
            <a href="toSuccess" class="a1">欢迎您，${user.name}</a>
            <a href="toLogOut" class="a2">退出</a>
            </c:if>
        </span>
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
                <a href="main?currentPage=${list2[i.index]}">${list2[i.index]}</a>
            </c:forEach>
        </c:if>

    页</div>
</body>
</html>
