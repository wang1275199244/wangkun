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
    <title>首页</title>
    <%
        Object o=session.getAttribute("recruitmentInformations");
        Object tpcache=session.getAttribute("tp");
        System.out.println(tpcache);
        if(o!=null&&tpcache!=null){
            List<RecruitmentInformation> list = (List<RecruitmentInformation>)o;
            pageContext.setAttribute("list",list);
        }else{
            System.out.println("asdasdasdasdasdasd");
            request.getRequestDispatcher("beforeindex").forward(request,response);
        }
    %>
</head>
<body>
<div>
    <ul>
        <li><a href="#">首页</a></li>
        <li><a href="toShowVisitorInformation">个人中心</a></li>
        <li><a href="adminLogin">管理员登录</a></li>
        <li><a href="visitorLogin">游客登录</a></li>
        <li><a href="employeeLogin">员工登录</a></li>
        <li><a href="toRegister">注册</a></li>
    </ul>
</div>
<div>

    <div>
        <table>
            <tr>
                <th>职位名称</th>
                <th>工作地点</th>
                <th>招聘人数</th>
                <th>发布日期</th>
            </tr>
<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="recruitmentInformation" varStatus="i">
        <tr>
            <td><a href="showPositionDetail?id=${recruitmentInformation.id}">${recruitmentInformation.position}</a></td>
            <td>${recruitmentInformation.workPlace}</td>
            <td>${recruitmentInformation.recruitingNumbers}</td>
            <td>${recruitmentInformation.releaseDate}</td>
        </tr>
    </c:forEach>
</c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td colspan="3">暂无招聘信息</td>
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
                <a href="index?currentPage=${list2[i.index]}">${list2[i.index]}</a>
            </c:forEach>
        </c:if>

        页</div>
</div>

</body>
</html>
