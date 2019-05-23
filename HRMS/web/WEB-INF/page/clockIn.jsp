<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/21 0021
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>打卡页面</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        function getTime(){
            var date = new Date();
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            var h = date.getHours();
            var i = date.getMinutes();
            var s = date.getSeconds();
            $("#sysTime").html(y+"-"+(m>9?m:("0"+m))+"-"+d+" "+(h>9?h:("0"+h))+":"+(i>9?i:("0"+i))+":"+(s>9?s:("0"+s)));
        }

        window.onload=function(){
            window.setInterval("getTime()",1000);
        }

        $(function () {

            $("#sub").mousedown(function () {
                $.post("confirmAttendance",{"io":$("#sub").val(),"time":$("span").text()},function (obj) {

                })
                var str = $("#sub").val();
                var clock= $("span").text();
                if("上班打卡" == str){
                    $("#sub").val("下班打卡")
                    $("#ab").html("上班打卡时间:"+clock);
                }else {
                    $("#bc").html("下班打卡时间:"+clock);
                }

            })
        })


    </script>

</head>
<body>
    <div>
        <div>
            <a href="toEmployeeInformation">返回</a>
        </div>

        <div id="a">上班时间:9:00</div>
        <div id="ab"></div>

        <div>
            <form action="confirmAttendance" method="post">
                <span id="sysTime"></span><br/>
                <input type="button" name="io" value="${requestScope.strin}" id="sub">
            </form>
        </div>
        <div>下班时间:18:00</div>
        <div id="bc"></div>
    </div>
</body>
</html>
