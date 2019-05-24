<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 23:10
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
    <title>奖惩记录</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {

            $("#but").click(function () {
                $.post("getPunishment",{"date":$("#dat").val()},function (obj) {
                    $("#rp").empty();
                    for (var i in obj) {
                        $("#rp").append("<td>" + obj[i].cause +"</td>"
                            +"<td>" + obj[i].bonus +"</td>"
                            +"<td>" + obj[i].bonusDate +"</td>")
                    }
                })

            })
        })


    </script>
</head>
<body>
    <div>
        <div>
            <a href="toEmployeeInformation">返回</a>
        </div>

        <form action="" method="post">
            <input type="month" name="date" value="2019-05" id="dat">
            <input type="button" value="查看奖惩记录" id="but">
        </form>
        <table>
            <tr>
                <th>奖惩原因</th>
                <th>奖惩金额</th>
                <th>奖惩时间</th>
            </tr>
            <tr id="rp"></tr>
        </table>


    </div>
</body>
</html>
