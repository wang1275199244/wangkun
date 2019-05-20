<%@ page import="com.wk.model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19 0019
  Time: 18:15
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
    <title>通讯录</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {
            //获得职位
            $("#dep1").change(function () {
                $.get("getPositions1",{"depid1":$(this).val()},function (obj) {
                    $("#pos1").empty();
                    for (var i in obj) {
                        $("#pos1").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")
                        console.log(obj[i].name)
                    }
                })
            })

            //获得员工
            $("#pos1").change(function () {

                $.get("getEmployees1",{"pid1":$(this).val()},function (obj) {
                    $("#emp1").empty();
                    for (var i in obj) {
                        $("#emp1").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")
                        $("ul").append("姓名:<li>" + obj[i].realName +"</li>")
                        $("ul").append("性别:<li>" + obj[i].sex +"</li>")
                        $("ul").append("年龄:<li>" + obj[i].age +"</li>")
                        $("ul").append("手机:<li>" + obj[i].phone +"</li>")
                        $("ul").append("邮箱:<li>" + obj[i].email +"</li>")

                        console.log(obj[i].name)
                    }
                })
            })


        })
    </script>
</head>
<body>
    <div>
        <div>
            <a href="employeeInformation">返回</a>
        </div>

        <div>
            <%
                List<Department> list = (List<Department>) session.getAttribute("dts2");
                pageContext.setAttribute("list",list);
            %>


                <p>
                    <label>部门:</label>
                    <select name="department" id="dep1">
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
            </form>
            <p>
                <label>职位:</label>
                <select name="position" id="pos1">

                </select>
            </p>
            <p>
                <label>员工:</label>
                <select name="employee" id="emp1">

                </select>
            </p>

            <p>
                <label>员工基本信息:</label>
                <ul></ul>
            </p>

        </div>
    </div>
</body>
</html>
