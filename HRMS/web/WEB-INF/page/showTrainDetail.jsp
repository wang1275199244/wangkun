<%@ page import="java.util.List" %>
<%@ page import="com.wk.model.TrainFand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wk.model.Train" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/20 0020
  Time: 23:16
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
    <title>查看培训</title>
</head>
<body>
    <div>
        <div>
            <a href="toShowTrain">返回</a>
        </div>

        <div>
            <label>培训主题:</label><div>${sessionScope.train2.title}</div><br/>
            <label>培训内容:</label><div>${sessionScope.train2.content}</div><br/>
            <label>开始时间:</label><div>${sessionScope.train2.startTime}</div><br/>
            <label>结束时间:</label><div>${sessionScope.train2.endTime}</div><br/>
            <label>培训地点:</label><div>${sessionScope.train2.place}</div><br/>
        </div>
        <%
            List<TrainFand> trainFands = (List<TrainFand>) session.getAttribute("tfs1");
            pageContext.setAttribute("list",trainFands);
        %>


        <table>
            <tr>
                <th>员工</th>
                <th>职位</th>
                <th>部门</th>
            </tr>
            <c:if test="${list != null && fn:length(list) != 0}">
                <c:forEach items="${list}" var="trainFand" varStatus="i">
               <tr>
                   <td>${trainFand.employee.realName}</td>
                   <td>${trainFand.position.name}</td>
                   <td>${trainFand.department.name}</td>
               </tr>
                </c:forEach>
            </c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td>没有培训详情</td>
                </tr>
            </c:if>
        </table>


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
                    <a href="toShowTrainDetail?currentPage=${list2[i.index]}">${list2[i.index]}</a>
                </c:forEach>
            </c:if>

            页</div>
    </div>
</body>
</html>
