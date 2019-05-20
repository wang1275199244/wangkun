<%@ page import="com.wk.model.RecruitmentInformation" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/16 0016
  Time: 20:31
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
    <title>Title</title>

</head>
<body>
<div>
    <div>
        <a href="toShowAllRI">返回</a>
    </div>
    <%
        RecruitmentInformation recruitmentInformation = (RecruitmentInformation) session.getAttribute("rtf");
        pageContext.setAttribute("rtf1",recruitmentInformation);
    %>

       <h3>岗位详情:</h3>
        <hr/>
        <p><h4>职位名称:</h4><div>${rtf1.position}</div></p>
        <hr/>
        <p><h4>所属部门:</h4><div>${rtf1.department}</div></p>
        <hr/>
        <p><h4>招聘人数:</h4><div>${rtf1.recruitingNumbers}</div></p>
        <hr/>
        <p><h4>工作经验:</h4><div>${rtf1.workExperience}</div></p>
        <hr/>
        <p><h4>学历要求:</h4><div>${rtf1.degreeRequired}</div></p>
        <hr/>
        <p><h4>工作方式:</h4><div>${rtf1.working}</div></p>
        <hr/>
        <p><h4>薪资范围:</h4><div>${rtf1.salaryRange}</div></p>
        <hr/>
        <p><h4>工作地点:</h4><div>${rtf1.workPlace}</div></p>
        <hr/>
        <p><h4>福利待遇:</h4><div>${rtf1.welfare}</div></p>
        <hr/>
        <p><h4>职位描述:</h4><div>${rtf1.positionDescription}</div></p>
        <hr/>
        <p><h4>公司信息:</h4><div>${rtf1.companyInformation}</div></p>
        <hr/>
        <c:if test="${rtf1.state == 0}">
            <p><h4>发布状态:</h4><div>未发布</div></p>
            <hr/>
        </c:if>

        <c:if test="${rtf1.state == 1}">
            <p><h4>发布状态:</h4><div>已发布</div></p>
            <hr/>
            <p><h4>发布日期:</h4><div>${rtf1.releaseDate}</div></p>
            <hr/>
        </c:if>
</div>
</body>
</html>
