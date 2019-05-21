<%@ page import="java.util.List" %>
<%@ page import="com.wk.model.TrainFand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wk.model.Train" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/20 0020
  Time: 13:16
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
            <a href="">返回</a>
        </div>
        <div>
        <table>
            <tr>
                <td><a href="toShowTrains?status=0">所有培训</a></td>
                <td><a href="toShowTrains?status=1">草稿</a></td>
                <td><a href="toShowTrains?status=2">已发布培训</a></td>
                <td><a href="toShowTrains?status=3">已完成培训</a></td>
            </tr>

        </table>
        </div>

        <%
            List<Train> trains1 = (List<Train>) session.getAttribute("trains");
            pageContext.setAttribute("list",trains1);
        %>

        <table>
            <tr>
                <th>主题</th>
                <th>培训开始时间</th>
                <th>培训结束时间</th>
                <th>培训地点</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:if test="${list != null && fn:length(list) != 0}">
                <c:forEach items="${list}" var="train" varStatus="i">
                    <form action="" method="post">
                    <tr>
                        <td><a href="toShowTrainDetail?id=${train.id}">${train.title}</a></td>
                        <td>${train.startTime}</td>
                        <td>${train.endTime}</td>
                        <td>${train.place}</td>
                        <input type="hidden" name="id" value="${train.id}">
                        <c:if test="${train.state == 0}">
                            <td>未发布</td>
                            <td><input type="submit" formaction="toReleaseTrain" value="发布"></td>
                            <td><input type="submit" formaction="toUpdateTrain" value="修改"></td>
                            <td><input type="submit" formaction="toDelTrain" value="删除"></td>
                        </c:if>

                        <c:if test="${train.state == 1}">
                            <td>已发布</td>
                        </c:if>

                        <c:if test="${train.state == 2}">
                            <td>已培训</td>
                            <td><input type="submit" formaction="toDelTrain1" value="删除"></td>
                        </c:if>

                    </tr>


                    </form>
                </c:forEach>
            </c:if>

            <c:if test="${list == null || fn:length(list) == 0}">
                <tr>
                    <td>没有培训计划</td>
                </tr>
            </c:if>
        </table>

        <div><a href="toAddTrain">添加培训</a></div>
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
                    <a href="toShowTrain?currentPage=${list2[i.index]}">${list2[i.index]}</a>
                </c:forEach>
            </c:if>

            页</div>
    </div>
</body>
</html>
