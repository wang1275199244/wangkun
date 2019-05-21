<%--
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
        $(function () {
            var initializationTime=(new Date()).getTime();
            function showLeftTime() {
                var now = new Date();
                var year = now.getYear();
                var month = now.getMonth();
                var day = now.getDate();
                var hours = now.getHours();
                var minutes = now.getMinutes();
                var seconds = now.getSeconds();
                document.all.show.innerHTML = "" + year + "年" + month + "月" + day + "日 " + hours + ":" + minutes + ":" + seconds + "";
                var timeID = setTimeout(showLeftTime, 1000);
            }
        })
    </script>
</head>
<body onload="showLeftTime()">
<label id="show"></label>
    <div>
        <div>
            <a href="toEmployeeInformation">返回</a>
        </div>

        <div>
            <form action="confirmAttendance" method="post">
                <input type="submit" value="打卡">
            </form>
        </div>
    </div>
</body>
</html>
