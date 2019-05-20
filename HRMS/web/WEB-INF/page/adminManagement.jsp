<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/17 0017
  Time: 18:58
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
    <title>管理员管理界面</title>
</head>
<body>

<div>
    <div>
        <a href="beforeindex">返回</a>
    </div>
    <table>
        <tr>
            <th>招聘</th>
            <th>培训</th>
            <th>部门管理</th>
            <th><a href="">考勤</a></th>
            <th><a href="">薪资</a></th>
        </tr>
        <tr>
            <td><a href="toShowAllRI">招聘信息</a></td>
            <td><a href="toShowTrain">查看培训信息</a></td>
            <td><a href="toShowDepartment">部门</a></td>
        </tr>
        <tr>
            <td><a href="toShowAppJob">已申请岗位</a></td>
            <td></td>
            <td><a href="">职位</a></td>
        </tr>
        <tr>
            <td><a href="toGetAcceptInvitation">已发送的面试邀请</a></td>
        </tr>
    </table>
</div>
</body>
</html>
