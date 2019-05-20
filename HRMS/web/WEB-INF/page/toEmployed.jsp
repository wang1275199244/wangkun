<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.wk.model.Invitation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19 0019
  Time: 13:20
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
    <title>确认录用</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#sal").blur(function () {
                var salary = $("#sal").val();
                if(salary < 4000){
                    $("#sal").val(4000);
                    $(":submit").attr("disabled",true);
                }else if(salary > 100000){
                    $("#sal").val(10000);
                    $(":submit").attr("disabled",true);
                }else {
                    $(":submit").attr("disabled",false);
                }
            })


        })
    </script>
</head>
<body>
    <div>
        <div>
            <a href="adminManagement">返回</a>
        </div>

        <div>

        <form action="" method="post">
            面试职位:<p>${sessionScope.inv.position}</p>
            面试部门:<p>${sessionScope.inv.department}</p>
            基本工资:<p><input type="text" value="请输入基本工资" required id="sal">输入值在4000-10000之间</p>
            <input type="hidden" name="id" value="${sessionScope.inv.id}">
            <input type="submit" formaction="confirmEmployed" value="录用">
            <input type="submit" formaction="confirmUnemployed" value="不录用">
        </form>

        </div>
    </div>
</body>
</html>
