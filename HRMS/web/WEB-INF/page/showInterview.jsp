<%@ page import="com.wk.model.Invitation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19 0019
  Time: 13:20
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
    <title>查看面试邀请</title>
</head>
<body>
    <div>
        <div>
            <a href="toShowVisitorInformation">返回</a>
        </div>

        <div>
            <%
                List<Invitation> invitations = (List<Invitation>) session.getAttribute("its");
                pageContext.setAttribute("list",invitations);
            %>
<c:if test="${list != null && fn:length(list) != 0}">
    <c:forEach items="${list}" var="invitation" varStatus="i">
        <form action="toAcceptInvitation" method="post">
            <p>${invitation.interviewer}</p>
            <h4>${invitation.company}</h4>面试信息
            面试职位:<p>${invitation.position}</p>
            面试部门:<p>${invitation.department}</p>
            面试时间:<p>${invitation.interviewTime}</p>
            面试地点:<p>${invitation.place}</p>
            联系人:<p>${invitation.contact}</p>
            联系方式:<p>${invitation.phone}</p>
            <input type="hidden" name="id" value="${invitation.id}">
            <input type="submit" value="接受邀请">
        </form>
    </c:forEach>
</c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <div>没有面试邀请</div>
            </c:if>
            <p></p>

        </div>
    </div>
</body>
</html>
