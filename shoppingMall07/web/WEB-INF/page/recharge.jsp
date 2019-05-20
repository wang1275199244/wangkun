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
    <title>充值中心</title>
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
            width: 360px;
            height: 172px;
            background: #F4F4F4;
            position: absolute;
            left: 200px;
            top:40px;
        }

        table{
            table-layout: fixed;
            border-collapse: collapse;
            border-spacing: 0px;
            width: 360px;
            height: 170px;

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

        #sp{
            border: 1px solid white;
            width: 300px;
            height: 42px;
            line-height: 42px;
            position: absolute;
            left: 370px;
            top:130px;
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
            $("#sub").css({"background":"green","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "40px","top":"240px","letter-spacing":"5px"});

            $("#res").css({"background":"orange","width":"110px","height":"42px","color":"white","font-size":"20px","position":"absolute","left": "230px","top":"240px","letter-spacing":"5px"});


            var af = null;//保存验证用户名的函数
            var bf = null;//保存验证密码的函数
            $("input[name='money1']").blur(af = function () {
                var a = $(this).val();
                var number = parseInt(a);
                if (!(/^[1-9]\d*|0$/).test(number)||number.length<=1||number.length>5) {
                    alert("请输入1-5位正数");
                    $(":submit").attr("disabled",true);
                    return false;
                } else {
                    $(":submit").attr("disabled",false);
                    return true;
                }
            });

            $("input[name='pass']").blur(bf = function () {
                var a =$("input[name='pass']").val();
                if (a!=null&&a.length!=0){
                    $.ajax({
                        type:"post",
                        url:"rechargeCheckPass",
                        data:{pass:$("input[name='pass']").val()},
                        success:function (obj) {
                            if (obj==1){
                                $("#sp").html("密码不正确，请重新输入");
                                $("#sp").css({"color":"red","face":"楷体"});
                                $(":submit").attr("disabled",true);
                                return false;
                            }else {
                                $("#sp").html("密码正确");
                                $("#sp").css("color","green");
                                $(":submit").attr("disabled",false);
                                return true;
                            }
                        }
                    })
                }else {
                    $("#sp").html("密码不可为空");
                    $("#sp").css({"color":"red","face":"楷体"});
                    return false;
                }


            })

            $(":submit").submit(function () {
                return af()&&bf();
            })
        });
    </script>
</head>
<body>
<div id="outer">
    <div><a href="main">返回首页</a></div>
    <form action="recharge" method="post">
        <div id="b">
            <table>
                <tr>
                    <td colspan="2" class="bc">充值中心</td>
                </tr>

                <tr>
                    <td>账户余额</td>
                    <td>¥${sessionScope.user1.money}</td>

                </tr>
                <tr>
                    <td>充值金额</td>
                    <td>¥<input name="money1" id="mon" required/></td>
                </tr>
                <tr>
                    <td>付款密码</td>
                    <td><input type="password" name="pass"  required/></td>
                </tr>
                <input type="submit" id="sub" style="background-color: green" value="确认充值"/>
                <input type="reset" id="res" style="background-color: orange" value="取消"/>
            </table>
            <div id="sp"></div>

        </div>

    </form>
</div>

</body>
</html>

