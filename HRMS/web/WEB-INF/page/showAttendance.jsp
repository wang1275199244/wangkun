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

            $("#but").click(function () {
                $.post("getAttendance",{"date":$("#date").val()},function (obj) {
                    $("#at").empty();
                    for (var i in obj) {
                        $("#at").append("<td>" + obj[i].employee.name +"</td>"
                            +"<td>" + obj[i].attendanceRecord.date +"</td>"
                            +"<td>" + obj[i].attendanceRecord.clockIn +"</td>"
                            +"<td>" + obj[i].attendanceRecord.clockOut +"</td>"
                            +"<td>" + obj[i].attendanceRecord.attendanceTime +"</td>"
                            +"<td>" + obj[i].attendanceRecord.overtime +"</td>"
                            +"<td>" + obj[i].attendanceRecord.state +"</td>"
                        )
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
           <form>
               <input type="date" value="2019-05-23" id="date">
               <input type="button" value="查看考勤记录" id="but">
           </form>
            <table>
                <tr>
                    <th>员工姓名</th>
                    <th>日期</th>
                    <th>上班打卡时间</th>
                    <th>下班打卡时间</th>
                    <th>正常出勤时间</th>
                    <th>加班时间</th>
                    <th>上班情况</th>
                </tr>
                <tr id="at"></tr>
                <tr>
                    <td colspan="5">备注:-1.缺勤,0.正常,1.迟到,2.旷工,3.早退</td>
                </tr>
            </table>

        </div>
    </div>
</body>
</html>
