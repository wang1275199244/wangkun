<%@ page import="java.util.Date" %><%--
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

</head>
<body>


<span id="time"></span>
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
<script type="text/javascript">
    $(function () {
        $("time").html(new Date().toLocaleString());
        window.setInterval("getTime();",1000);

        window.onload = getTime();
    })


</script>

</html>
