<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wk.model.RecruitmentInformation" %><%--
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
    <title>招聘信息显示管理员</title>
</head>
<body>

<div>
    <div>
        <a href="adminManagement">返回</a>
    </div>
    <%
        List<RecruitmentInformation> list = (List<RecruitmentInformation>) session.getAttribute("ris");
        pageContext.setAttribute("list",list);
    %>

    <div>
        <form action="toAddInformation" method="post">
            <input type="submit" value="添加">
        </form>

        <table>
            <tr>
                <th>职位名称</th>
                <th>工作地点</th>
                <th>招聘人数</th>
                <th>发布状态</th>
                <th>发布时间</th>
                <th></th>
                <th></th>
            </tr>

<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="recruitmentInformation" varStatus="i">
        <form action="" method="post">
        <tr>
            <td><a href="toGetPositionDetail?id=${recruitmentInformation.id}">${recruitmentInformation.position}</a></td>
            <td>${recruitmentInformation.workPlace}</td>
            <td>${recruitmentInformation.recruitingNumbers}</td>

        <input type="hidden" name="id" value="${recruitmentInformation.id}">
        <c:if test="${recruitmentInformation.state == 0}">
            <td>未发布</td>
            <td></td>

            <td><input type="submit" value="删除" formaction="toDelInformation"></td>

            <td><input type="submit" value="发布职位" formaction="toPublishformation"></td>
        </c:if>

        <c:if test="${recruitmentInformation.state == 1}">
            <td>已发布</td>
            <td>${recruitmentInformation.releaseDate}</td>

            <td></td>
            <td><input type="submit" value="撤销发布" formaction="toUnpublishInformation"></td>
            </tr>
            </form>
        </c:if>
    </c:forEach>
</c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td colspan="9">暂无招聘信息</td>
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
                <a href="toShowAllRI?currentPage=${list2[i.index]}">${list2[i.index]}</a>
            </c:forEach>
        </c:if>

        页</div>
</div>

</body>
</html>
