<%@ page import="java.util.List" %>
<%@ page import="com.wk.model.Department" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/20 0020
  Time: 23:16
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
    <title>发布培训信息</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {

            $("#department").change(function () {
                var department = $(this).val();
                $("#depart").val(department);

                $.get("getEmploy",{"depid":$(this).val()},function (obj) {
                    $("#employee").empty();
                    for (var i in obj) {
                        $("#employee").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")
                        console.log(obj[i].name)
                    }
                })
            })

            $("#employee").change(function () {
                var employee = $(this).val();
                $("#emp").val(employee);
            })
        })
    </script>
</head>
<body>
<div>
    <div>
        <a href="toShowTrain">返回</a>
    </div>

    <div>
        <label>培训主题:</label><div>${sessionScope.train2.title}</div><br/>
        <label>培训内容:</label><div>${sessionScope.train2.content}</div><br/>
        <label>开始时间:</label><div>${sessionScope.train2.startTime}</div><br/>
        <label>结束时间:</label><div>${sessionScope.train2.endTime}</div><br/>
        <label>培训地点:</label><div>${sessionScope.train2.place}</div><br/>
    </div>

    <div>
        <%
            List<Department> list = (List<Department>) session.getAttribute("dts2");
            pageContext.setAttribute("list",list);
        %>

        <p>
            <label>部门:</label>
            <select name="department" id="department">
                <c:if test="${list != null && fn:length(list) != 0}">
                    <c:forEach items="${list}" var="department" varStatus="i">
                        <option value="${department.id}">${department.name}</option>
                    </c:forEach>
                </c:if>

                <c:if test="${list == null || fn:length(list) == 0}">
                    <option></option>
                </c:if>
            </select>
        </p>

        <p>
            <label>员工:</label>
            <select name="employee" id="employee">
            </select>
        </p>

    </div>

    <div>
        <form action="" method="post">
            <input type="hidden" name="trid" value="${sessionScope.train2.id}">
            <input type="hidden" name="deid" id="depart" value="">
            <input type="hidden" name="empid" id="emp" value="">
            <input type="submit" formaction="confirmReleaseTtainMany" id="rtm" value="多人培训发布">
            <input type="submit" formaction="confirmReleaseTtain" value="培训发布">
        </form>
    </div>

</div>
</body>
</html>
