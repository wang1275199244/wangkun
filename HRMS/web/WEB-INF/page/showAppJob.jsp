<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wk.model.RecruitmentInformation" %>
<%@ page import="com.wk.model.FandRecruitmentInformation" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/14 0014
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +   request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>查看已申请岗位</title>
</head>
<body>

<div>
    <div>
        <a href="adminManagement">返回</a>
    </div>
    <%
        List<FandRecruitmentInformation> list = (List<FandRecruitmentInformation>) session.getAttribute("fris");
        pageContext.setAttribute("list",list);
    %>

    <div>

        <table>
            <tr>
                <th></th>
                <th>职位申请日期</th>
                <th>职位名称</th>
                <th>所属部门</th>
                <th>工作经验</th>
                <th>学历要求</th>
                <th>薪资范围</th>
                <th>工作地点</th>
                <th>发布日期</th>
                <th>招聘人数</th>
            </tr>

<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="fri" varStatus="i">

        <tr>
            <c:if test="${fri.viewState == 0}">
                <td>未读</td>
            </c:if>
            <c:if test="${fri.viewState == 1}">
                <td>已读</td>
            </c:if>
            <td>${fri.date}</td>
            <td><a href="toGetAppResume?id=${fri.recruitmentInformation.id}">${fri.recruitmentInformation.position}</a></td>
            <td>${fri.recruitmentInformation.department}</td>
            <td>${fri.recruitmentInformation.workExperience}</td>
            <td>${fri.recruitmentInformation.degreeRequired}</td>
            <td>${fri.recruitmentInformation.salaryRange}</td>
            <td>${fri.recruitmentInformation.workPlace}</td>
            <td>${fri.recruitmentInformation.releaseDate}</td>
            <td>${fri.recruitmentInformation.recruitingNumbers}</td>
            </tr>

    </c:forEach>
</c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td colspan="9">还没有人应聘</td>
                </tr>
            </c:if>

        </table>
    </div>

    <%
        int tp =  (int)session.getAttribute("tp");
        List<Integer> list2 = new ArrayList();
        for (int i = 1; i <= tp; i++) {
            list2.add(i);
        }
        request.setAttribute("list2",list2);
    %>
    <div id="page">第

        <c:if test="${list2 != null && fn:length(list2) != 0}">
            <c:forEach items="${list2}" varStatus="i">
                <a href="toShowAppJob?currentPage=${list2[i.index]}">${list2[i.index]}</a>
            </c:forEach>
        </c:if>

        页</div>
</div>

</body>
</html>
