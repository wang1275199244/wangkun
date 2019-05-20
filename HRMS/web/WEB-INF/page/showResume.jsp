<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wk.model.Resume" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/16 0016
  Time: 23:52
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
    <title>我的简历</title>

</head>
<body>
    <div>
        <div>
            <a href="toShowVisitorInformation">返回</a>
        </div>

        <h4>我的简历</h4>
        <%
            List<Resume> resumeList = (List<Resume>) session.getAttribute("resumes");
            pageContext.setAttribute("list",resumeList);
        %>
        <div>
                <c:if test="${list != null && fn:length(list) != 0}">
                    <c:forEach items="${list}" var="resume" varStatus="i">
                        <form action="" method="post">
                            <table>
                                <tr>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>出生年月</th>
                                    <th>学历</th>
                                    <th>专业</th>
                                </tr>
                                <tr>
                                    <td>${resume.name}</td>
                                    <td>${resume.sex}</td>
                                    <td>${resume.birthDate}</td>
                                    <td>${resume.degree}</td>
                                    <td>${resume.major}</td>
                                    <input type="hidden" name="id" value="${resume.id}">
                                    <td><input type="submit" formaction="toShowResumeDetail" value="查看简历详情"></td>
                                    <td><input type="submit" formaction="toAddResume" value="添加"></td>
                                    <td><input type="submit" value="修改" formaction="toUpdateResume"></td>
                                    <td><input type="submit" value="删除" formaction="delResume"></td>
                                </tr>

                            </table>
                        </form>
                    </c:forEach>
                </c:if>

                <c:if test="${list == null || fn:length(list) == 0}">
                    <div>您还没有简历<a href="toAddResume">去添加</a></div>
                </c:if>

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
