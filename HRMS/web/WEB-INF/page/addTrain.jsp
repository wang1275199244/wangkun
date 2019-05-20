<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/20 0020
  Time: 14:45
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
    <title>添加培训内容</title>
</head>
<body>
    <div>
        <div>
            <a href="toShowTrain">返回</a>
        </div>
        <form action="confirmAddTrain" method="post">
        <div>
            <p>
            <label>培训主题</label>
            <input name="title" required>
            </p>

            <p>
            <label>培训内容</label>
            <textarea name="content" cols="10" rows="3"required ></textarea>
            </p>
            <input type="hidden" name="state" value="0">
            <input type="submit" value="确认">
            <input type="reset" value="取消">
        </div>
        </form>
    </div>
</body>
</html>
