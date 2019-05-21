<%@ page import="java.util.List" %>
<%@ page import="com.wk.model.TrainFand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wk.model.Train" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/20 0020
  Time: 23:56
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
    <title>查看我的培训</title>
</head>
<body>
    <div>
        <div>
            <a href="">返回</a>
        </div>


        <%
            List<Train> trains2 = (List<Train>) session.getAttribute("ts1");
            pageContext.setAttribute("list",trains2);
        %>

            <c:if test="${list != null && fn:length(list) != 0}">
                <c:forEach items="${list}" var="train" varStatus="i">
                    <form action="confirmTrain" method="post">
                        <div>
                            <label>培训主题:</label><div>${train.title}</div><br/>
                            <label>培训内容:</label><div>${train.content}</div><br/>
                            <label>开始时间:</label><div>${train.startTime}</div><br/>
                            <label>结束时间:</label><div>${train.endTime}</div><br/>
                            <label>培训地点:</label><div>${train.place}</div><br/>
                        </div>
                        <input type="hidden" name="id" value="${train.id}">
                        <input type="submit" value="确认培训">

                    </form>
                </c:forEach>
            </c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <div>没有培训</div>
            </c:if>

        <%
            int tp =  (int)session.getAttribute("tp");
            List list2 = new ArrayList();
            for (int i = 1; i <= tp; i++) {
                list2.add(i);
            }
            request.setAttribute("list2",list2);
        %>
        <div id="page">第
            <c:if test="${list2 != null && fn:length(list2) != 0}">
                <c:forEach items="${list2}" varStatus="i">
                    <a href="toShowMyTrain?currentPage=${list2[i.index]}">${list2[i.index]}</a>
                </c:forEach>
            </c:if>

            页</div>
    </div>
</body>
</html>
