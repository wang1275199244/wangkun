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
    <title>员工信息界面</title>
</head>
<body>

<div>
    <div>
        <a href="beforeindex">返回</a>
    </div>
    <table>
        <tr>
            <td><a href="">个人信息</a></td>
            <td><a href="toShowAddressList">部门职位员工</a></td>
            <td><a href="toShowMyTrain">培训</a></td>
            <td><a href="">奖惩</a></td>
            <td><a href="toClockIn">打卡</a></td>
            <td><a href="">薪资</a></td>
        </tr>
    </table>
</div>
</body>
</html>
