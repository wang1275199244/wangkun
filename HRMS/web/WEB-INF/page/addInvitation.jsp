<%@ page import="com.wk.model.Invitation" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19 0019
  Time: 9:49
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
    <title>添加面试邀请信息</title>
</head>
<body>
    <div>
        <div>
            <a href="toAppJob">返回</a>
        </div>
        <div>

        <form action="toConfirmInvitation" method="post">
            <p>
                <input name="interviewer" value="${sessionScope.invitation.interviewer}">
            </p>
            <p>
                <input name="company" placeholder="请输入公司名称" required>面试信息
            </p>
            <p>
                <label>面试职位:</label>
                <input name="position" value="${sessionScope.invitation.position}" required>
            </p>
            <p>
                <label>所属部门:</label>
                <input name="department" value="${sessionScope.invitation.department}" required>
            </p>
            <p>
                <label>面试时间:</label>
                <input name="interviewTime" placeholder="请输入面试时间" required>
            </p>
            <p>
                <label>面试地点:</label>
                <input name="place" placeholder="请输入面试地点" required>
            </p>
            <p>
                <label>联系人:</label>
                <input name="contact" placeholder="请输入联系人" required>
            </p>
            <p>
                <label>联系电话:</label>
                <input name="phone" placeholder="请输入联系电话" required>
            </p>
            <input type="hidden" name="state" value="${sessionScope.invitation.state}">
            <input type="hidden" name="vid" value="${sessionScope.invitation.vid}">

            <input type="submit" value="确认">
            <input type="reset" value="取消">

        </form>
        </div>
    </div>
</body>
</html>
