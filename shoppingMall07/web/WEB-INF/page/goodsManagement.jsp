<%@ page import="com.xd1810.model.Good" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
    <title>商品管理界面</title>
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
            height: 30px;
            background: #F4F4F4;
        }
         #b2{
             border: 1px solid #FF6905;
             width: 1150px;
             height: 128px;
             background: #F4F4F4;
             position: absolute;
             left: 90px;
             top:485px;
         }


         #b{
             border: 1px solid #FF6905;
             width: 1150px;
             height: 582px;
             background: #F4F4F4;
             position: absolute;
             left: 90px;
             top:32px;
         }

         #bc{
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
             width: 87px;
             height: 42px;
         }

         #page{
             border: 1px solid #F4F4F4;
             text-align: center;
             width: 780px;
             height: 24px;
             position: absolute;
             left: 290px;
             top:450px;
         }
         .d{
             width: 156px;
         }
         #noGood{
             border: 1px solid #FF6905;
             width: 1018px;
             height: 22px;
             text-align: center;
             background: #F4F4F4;
             position: absolute;
             left: 0px;
             top:43px;
         }


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


         .td1{
             padding: 0px;
             border: 1px solid #FF6905;
             width: 106px;
             height: 40px;
         }

         .ud,.del,.in{
            width: 80px;
             height: 25px;
             background-color: #FF6905;
             color: white;
         }
         #str1{
             position: absolute;
             left: 860px;
             top:13px;
             border: 1px solid #F4F4F4;
             width: 400px;
             height: 23px;
             color: #F52B00;
             text-align: right;

         }
     </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {

            $(":input[class='inp']").css({
                "width": "90px",
                "height": "30px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":input[id='de']").css({
                "width": "200px",
                "height": "30px",
                "text-align": "center",
                "font-size": "16px"
            });

            $("#spac").css({
                "width": "113px",
                "height": "30px",
                "text-align": "center",
                "font-size": "16px"
            });

            $(":submit").click(function () {
                var we = $(this).parent().parent().children().first().text();
                var wr = $(this).parent().prev().text();
                $(":hidden[name='id']").val(we);
                $(":hidden[name='state']").val(wr);

            });

            var af = false;
            var bf = false;
            $("input[id = 'pr']").blur(function () {
                var price = $("#pr").val();
                if(!(/^0\.([1-9]|\d[1-9])$|^[1-9]\d{0,7}\.\d{0,2}$|^[1-9]\d{0,7}$/).test(price)){
                    $("submit[id='sub']").attr("disabled",true);
                    alert("输入数据格式不正确，小数点前面0-8位，两位小数");

                }else{
                    $("submit[id='sub']").attr("disabled",false);
                    af = true;
                }
            });

            $("input[id ='gc']").blur(function () {
                var gcount = $("#gc").val();

                if (!(/^[1-9][0-9]{0,10}$/).test(gcount)) {
                    alert("你输入的数据不合法，只能输入0-11位正整数");
                    $("submit[id='sub']").attr("disabled",true);
                } else {
                    $("submit[id='sub']").attr("disabled",false);
                    bf = true;
                }
            });
            $("#sub").click(function () {
                if(af&&bf){
                    $("#form2").submit();
                }else {
                    return false;
                }

            })

            $("#str1").show(5000,function () {
                $("#str1").fadeOut(2000);

            });

        });

    </script>
</head>
<body>

    <div>
    <div id="a">
        <a href="page/adminSuccess.jsp">返回</a>
    </div>

    <div id="b">
        <form action="" method="post" >
        <table>
            <tr>
                <th>商品ID</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品类型</th>
                <th class="d">商品描述</th>
                <th>商品产地</th>
                <th>商品库存</th>
                <th>上架状态</th>
                <th></th>
                <th></th>
            </tr>

            <%
                List<Good> list = (List<Good>) session.getAttribute("goods1");
                pageContext.setAttribute("list",list);
            %>
<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="good" varStatus="i">
            <tr>
                <td>${good.id}</td>
                <td>${good.name}</td>
                <td>¥ ${good.price}</td>
                <td>${good.type}</td>
                <td class="d">${good.description}</td>
                <td>${good.factory}</td>
                <td>${good.stock.gcount}</td>

                <c:if test="${good.state == 0}">
                    <td>未上架</td>
                    <td class="td1"><input type="submit" formaction="updateGood" style="background-color: green" value="上架"id="ud${i.index}" class="ud"/></td>
                </c:if>
                <c:if test="${good.state == 1}">
                    <td>已上架</td>
                    <td class="td1"><input type="submit" formaction="updateGood" value="下架" id="ud${i.index}" class="ud"/></td>
                </c:if>
                    <td class="td1"><input type="submit" style="background-color: orange" formaction="delGood" value="删除" id="ab${i.index}" class="del"/></td>

            </tr>
    </c:forEach>
</c:if>
<c:if test="${list == null || fn:length(list) == 0}">
            <tr>
                <td colspan="10" id="noGood">没有任何商品，请添加</td>
            </tr>
</c:if>
            <input type="hidden" name="id"/>
            <input type="hidden" name="state"/>
        </table>
        </form>
    </div>
        <div id="b2">
            <table>
                <tr>
                    <td colspan="10" id="bc">添加商品</td>
                </tr>
                <tr>
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品类型</th>
                    <th class="d">商品描述</th>
                    <th>商品产地</th>
                    <th>商品库存</th>
                    <th>上架状态</th>
                    <th></th>
                    <th></th>

                </tr>

                <form action="addGood" method="post" id="form2">
                    <tr>
                        <td id="spac"></td>
                        <td style="padding: 4px"><input class="inp" id="na" name="name" required/></td>
                        <td style="padding: 4px"><input id="pr" class="inp" name="price" required/></td>
                        <td style="padding: 4px"><input id="ty" class="inp" name="type" required/></td>
                        <td style="padding: 4px"><input id="de" name="description" required/></td>
                        <td style="padding: 4px"><input class="inp" id="fa" name="factory" required/></td>
                        <td style="padding: 4px"><input  class="inp" id="gc" name="gcount" required/></td>
                        <td style="padding: 4px"></td>

                        <td class="td1"><input type="submit"style="background-color: green;padding: 4px" value="添加商品"id="sub" class="in"/></td>
                        <td class="td1"><input type="reset" style="background-color: orange;padding: 4px" value="取消" class="in"/></td>


                    </tr>
                </form>

            </table>

        </div>

    </div>

    <%
        int tp =  (int)session.getAttribute("tp1");
        List list2 = new ArrayList();
        for (int i = 1; i <= tp; i++) {
            list2.add(i);
        }
        request.setAttribute("list2",list2);
    %>

    <div id="page">第
        <c:if test="${list2 != null && fn:length(list2) != 0}">
            <c:forEach items="${list2}" varStatus="i">
                <a href="goodsManagement?currentPage1=${list2[i.index]}">${list2[i.index]}</a>
            </c:forEach>
        </c:if>

        页</div>
    <%--<span id="str1">${sessionScope.str1}</span>--%>
</body>

</html>
