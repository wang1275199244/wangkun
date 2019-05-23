<%@ page import="com.wk.model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23 0023
  Time: 9:15
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
    <title>查看考勤</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {
            //获得职位
            $("#dep").change(function () {
                var department = $(this).val();
                $.get("getPositions",{"depid":$(this).val()},function (obj) {
                    $("#pos").empty();
                    for (var i in obj) {
                        $("#pos").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")

                    }
                })
            })

            //获得员工
            $("#pos").change(function () {
                var position = $(this).val();

                $.get("getEmployees",{"pid":$(this).val()},function (obj) {
                    $("#emp").empty();
                    for (var i in obj) {
                        $("#emp").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")

                    }
                })
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
            <%
                List<Department> list = (List<Department>) session.getAttribute("dts1");
                pageContext.setAttribute("list",list);
            %>


                <p>
                    <label>部门:</label>
                    <select name="department" id="dep">
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
                <label>职位:</label>
                <select name="position" id="pos">

                </select>
            </p>
            <p>
                <label>员工:</label>
                <select name="employee" id="emp">

                </select>
            </p>

        </div>
    </div>
</body>
</html>
