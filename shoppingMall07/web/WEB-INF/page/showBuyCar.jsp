<%@ page import="java.util.List" %>
<%@ page import="com.xd1810.model.*" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/23 0008
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
    <title>我的购物车</title>
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
             width: 1150px;
             height: 560px;
             background: #F4F4F4;
             position: absolute;
             left: 80px;
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
             width: 156px;
         }
         #bc{
             background:#FF6905;
             font-weight: bold;
             font-size:20px;
             color: white;
             letter-spacing:40px;
             font-family: 宋体;
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
             background-color: #FF6905;
             color: white;
         }

         #pay{
             width: 433px;
             position: absolute;
             left: 717px;
             top:502px;
         }
         #pa{

         }

         #page{
             border: 1px solid #F4F4F4;
             text-align: center;
             width: 780px;
             height: 24px;
             position: absolute;
             left: 290px;
             top:520px;
         }

         #pays{
             background: coral;
             color: white;
             width: 90px;
             height: 36px;
             letter-spacing:5px;

         }
         #pays:hover{
             background-color: green;
         }

         #pays:active{
             background-color: royalblue;
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

            $("td[id^='add']").click(function () {
                var a = $(this).next().children().val();
                if (a == "" || undefined || null || a <= 1) {
                    $(this).next().children().val(1);
                }

                $(this).next().children().val(parseInt(a) + 1);
                $(this).next().children().attr("value", parseInt(a));
                var count = parseInt(a) + 1;
                var price = $(this).prev().prev().prev().prev().children().text();
                $(this).next().next().next().children().text((parseFloat(price) * count).toFixed(2));
                if (a >= 9999) {
                    $(this).next().children().val(9999);
                }
            });
            $("td[id^='sub']").click(function () {
                var b = $(this).prev().children().val();
                $(this).prev().children().val(parseInt(b) - 1);
                var count = parseInt(b) - 1;
                var price = $(this).prev().prev().prev().prev().prev().prev().children().text();
                $(this).next().children().text((parseFloat(price) * count).toFixed(2));
                if (b <= 1) {
                    $(this).prev().children().val(1);
                    var count = 1;
                    $(this).next().children().text((parseFloat(price) * count).toFixed(2));
                }
            });

            $(":input[id^='count']").blur(function () {
                var count = $(this).val();
                var price = $(this).parent().prev().prev().prev().prev().prev().children().text();
                $(this).parent().next().next().children().text((parseFloat(price) * count).toFixed(2));
                if (!(/[0-9]{1,4}$/).test(count)) {
                    $("form").submit(function () {
                        return false;
                    });
                } else {
                    return true;
                }
            });
            var af = true;
            var bf = true;
            //全选
            $("#check1").change(af = function () {
                if (this.checked) {
                    $("input[class='item']").each(function () {
                        $("input[class='item']").prop("checked",true);

                    });
                    total()

                    //全选判断库存
                    var arr = new Array();
                    $("input[class='item']").each(function () {
                        if(this.checked == true){
                            var bids = $(this).val();

                            arr.push(bids);
                            arr.join(',');
                            //alert(arr)
                        }
                    });
                    $.ajax({
                        type:"post",
                        url:"checkManyStock",
                        traditional: true,
                        data:{arr:arr},
                        success:function (obj) {
                            for (var i = 0; i < obj.length; i++) {
                                //alert(obj[i]);
                                if (obj[i] == 3) {
                                    alert("所选商品中有库存不足，请重新确认购买数量");
                                    $(this).attr("disabled", "true");
                                    $("input[id='pays']").attr("disabled", "disabled");
                                    return false;
                                    break;
                                } else if (obj == 4) {
                                    $(this).attr("disabled", "false");
                                    $("input[id='pays']").removeAttr("disabled", "disabled");
                                    return true;
                                }
                            }
                        }
                    });

                } else {
                    $("input[class='item']").prop("checked",false);
                    $("#total").text("0.00");
                }

            });

            //单选判断库存
            $("input[class='item']").mouseover(bf = function () {
                    $.ajax({
                        type:"post",
                        url:"checkStock",
                        data:{bid:$(this).val()},
                        success:function (obj) {
                            if(obj == 1) {
                                alert("该商品当前库存不足，请重新确认购买数量");
                                $(this).attr("disabled","true");
                                $("input[id='pays']").attr("disabled", "disabled");
                                return false;
                            }else if(obj == 0){
                                $(this).attr("disabled","false");
                                $("input[id='pays']").removeAttr("disabled", "disabled");
                                return true;
                            }
                        }
                    });
            });

            //多选
            $("input[class='item']").change(function () {
                    total()
                    $("input[class='item']").each(function () {
                        var a = $("input[class='item']:checked").length;
                        var b = $("input[class='item']").length;
                        if (a == 0) {
                            $("#total").text("0.00");
                        } else if (a == b) {
                            $("input[id='check1']:checkbox").prop("checked", true);
                        } else {
                            $("input[id='check1']:checkbox").prop("checked", false);
                        }
                    });

            });

            //计算总价
            function total(){
                var total = 0;
                $("input[class='item']").each(function(){
                    if(this.checked == true) {
                        var money = parseFloat($(this).parent().parent().children("td:eq(9)").children().text());
                        total += money;
                        $("#total").text(total.toFixed(2));
                        $("input[name='total']").val(total.toFixed(2));
                    }
                });
            }

            $("input[id='pays']").click(function () {
                var arr = new Array();
                $("input[class='item']").each(function () {
                    if(this.checked == true){
                        var bids = $(this).val();

                        arr.push(bids);
                        arr.join(',');


                    }
                });
                //$("input[name='bids']").val(arr);
                $.ajax({
                    type:"post",
                    url:"getManyBidAndTotal",
                    traditional: true,
                    data:{total:$("#total").text(),arr:arr},
                    success:function (obj) {

                    }
                });

            });

            $("input[id='pays']").mouseover(function () {
                $("input[class='item']").each(function () {
                    var a = $("input[class='item']:checked").length;
                    if (a == 0) {
                        $("input[id='pays']").attr("disabled", "disabled");
                    }else {
                        $("input[id='pays']").removeAttr("disabled", "disabled");
                    }

                });
            });

            $("input[id='pays']").submit(function () {
                return af()&&bf();
            });


        });

    </script>
</head>
<body>
    <div>
    <div><a href="toSuccess">返回</a></div>
    <div id="b">
        <form action="" method="post">
        <table id="tab1">
            <tr>
                <td colspan="12" id="bc">我的购物车</td>
            </tr>
            <tr>
                <th class="col1"></th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品类型</th>
                <th class="d">商品描述</th>
                <th>商品产地</th>
                <th colspan="3">购买数量</th>
                <th>小计</th>
                <th></th>
                <th></th>
            </tr>

            <%
                List<BuyDetailFand> list1 = (List<BuyDetailFand>)session.getAttribute("bdfs");
                pageContext.setAttribute("list", list1);
            %>

    <c:if test="${list != null && fn:length(list) != 0}">
        <c:forEach items="${list}" var="buyDetailFand" varStatus="i">
            <form  method="post" id="form${i.index}">
            <tr>
                <td class="col1"><input type="checkbox" name="bid" value="${buyDetail.id}" class="item"/></td>
                <td>${buyDetailFand.good.name}</td>
                <td>¥<span>${buyDetailFand.good.price}</span></td>
                <td>${buyDetailFand.good.type}</td>
                <td class="d">${buyDetailFand.good.description}</td>
                <td>${buyDetailFand.good.factory}</td>
                    <td class="jia" id="add${i.index}">+</td>
                    <td style="padding: 0px"><input id="count${i.index}" name="gcount" value="${buyDetailFand.gcount}" required/></td>
                    <td class="jia" id="sub${i.index}">-</td>
                    <td>¥<span>${buyDetailFand.good.price*buyDetailFand.gcount}</span></td>
                    <input type="hidden" name="id" value="${buyDetailFand.id}"/>
                    <input type="hidden" name="gid" value="${buyDetailFand.good.id}"/>
                <%--<input type="hidden" name="total" value=""/>
                <input type="hidden" name="bids" value=""/>--%>

                    <td class="td1"><input type="submit" formaction="updateBuyDetail" style="background-color: green" value="更新"id="tb${i.index}" class="in"/></td>
                    <td class="td1"><input type="submit" formaction="delBuyDetail" style="background-color: orange" value="删除" id="ab${i.index}" class="in"/></td>

            </tr>
            </form>
        </c:forEach>
    </c:if>
    <c:if test="${list == null || fn:length(list) == 0}">
            <tr>
                <td colspan="12">没有任何商品，请添加</td>
            </tr>
    </c:if>

        </table>

        <div id="pay">
        <table>
            <tr>
                <td><input type="checkbox" id="check1"/>全选</td>
                <td>总金额:</td>
                <td>¥<span id="total">0.00</span></td>
                <input type="hidden" name="method" value="selectReceivingInformation"/>
                <td id="pa"><input type="submit" formaction="processManyOrders" value="去结算" id="pays"/></td>
            </tr>
        </table>
        </div>
        </form>
    </div>

    </div>
    <%
        int tp3 =  (int)session.getAttribute("tp");
        List list2 = new ArrayList();
        for (int i = 1; i <= tp3; i++) {
            list2.add(i);
        }
        request.setAttribute("list2",list2);
    %>
    <div id="page">第

        <c:if test="${list2 != null && fn:length(list2) != 0}">
            <c:forEach items="${list2}" varStatus="i">
                <a href="showBuyCar?currentPage=${list2[i.index]}">${list2[i.index]}</a>
            </c:forEach>
        </c:if>

        页</div>
</body>
</html>
