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
    <title>部门管理</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {
            //获得职位
            $("#dep").change(function () {
                var department = $(this).val();
                $("#de").val(department);
                $("#depart").val(department);
                $("#depart1").val(department);

                $.get("getPositions",{"depid":$(this).val()},function (obj) {
                    $("#pos").empty();
                    for (var i in obj) {
                        $("#pos").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")
                        console.log(obj[i].name)
                    }
                })
            })

            //获得员工
            $("#pos").change(function () {
                var position = $(this).val();
                $("#posid").val(position);
                $("#posid1").val(position);

                $.get("getEmployees",{"pid":$(this).val()},function (obj) {
                    $("#emp").empty();
                    for (var i in obj) {
                        $("#emp").append("<option value='" + obj[i].id + "'>" + obj[i].name +"</option>")
                        console.log(obj[i].name)
                    }
                })
            })

            //验证添加部门重名
            $("#newdep").blur(function () {
                $.post("checkDepName",{"depname":$(this).val()},function (obj) {
                    if(obj == 0) {
                        alert("此部门已经存在")
                        $("#addDep").attr("disabled",true);

                    }else{
                        $("#addDep").attr("disabled",false);

                    }
                })
            })

            //验证更新部门重名
            $("#newdep1").blur(function () {

                $.post("checkDepName1",{"depname1":$(this).val()},function (obj) {
                    if(obj == 0) {
                        $("#updateDep").attr("disabled",true);
                        alert("此部门已经存在")
                    }else{
                        $("#updateDep").attr("disabled",false);

                    }
                })
            })


            //验证添加职位重名
            $("#newpos").blur(function () {
                $.post("checkPosName",{"deid1":$("#depart1").val(),"pname":$(this).val()},function (obj) {
                    if(obj == 0) {
                        alert("该部门此职位已经存在")
                        $("#addPos").attr("disabled",true);
                        $("#updatePos").attr("disabled",true);

                    }else{
                        $("#addPos").attr("disabled",false);
                        $("#updatePos").attr("disabled",false);

                    }
                })
            })


            //验证修改职位重名
            $("#newpos1").blur(function () {
                $.post("checkPosName1",{"posid":$("#posid").val(),"pname1":$(this).val()},function (obj) {
                    if(obj == 0) {
                        alert("该部门此职位已经存在")
                        $("#addPos").attr("disabled",true);
                        $("#updatePos").attr("disabled",true);

                    }else{
                        $("#addPos").attr("disabled",false);
                        $("#updatePos").attr("disabled",false);

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
            </form>
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

            <div>
                <form action="toAddDepartment" method="post">
                    <input name="depname" id="newdep" placeholder="请输入部门名称" required>
                    <input type="submit" id="addDep" value="添加部门">
                </form>
            </div>

            <div>
                <form action="toUpdateDep" method="post">
                    <input name="depname1" id="newdep1" placeholder="请输入部门名称" required>
                    <input type="hidden" name="did" id="de" value="">
                    <input type="submit" id="updateDep" value="修改部门">
                </form>
            </div>

            <div>
                <form action="toDelDep" method="post">
                    <input type="hidden" name="deid" id="depart" value="">
                    <input type="submit" id="delDep" value="删除部门">
                </form>
            </div>

            <div>
                <form action="toAddPosition" method="post">
                    <input type="hidden" name="deid1" id="depart1" value="">
                    <input name="pname" id="newpos" placeholder="请输入职位名称" required>
                    <input type="submit" id="addPos" value="添加职位">
                </form>
            </div>

            <div>
                <form action="toUpdatePosition" method="post">
                    <input type="hidden" name="posid" id="posid" value="">
                    <input name="pname1" id="newpos1" placeholder="请输入职位名称" required>
                    <input type="submit" id="updatePos" value="修改职位">
                </form>
            </div>

            <div>
                <form action="toDelPosition" method="post">
                    <input type="hidden" name="posid1" id="posid1" value="">
                    <input type="submit" id="delPos" value="删除职位">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
