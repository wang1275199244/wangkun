<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/16 0016
  Time: 22:56
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
    <title>游客查看个人信息</title>
</head>
<body>
    <div>
        <div>
            <a href="toFirst">返回</a>
        </div>

        <div>
            <table>
                <tr>
                    <td>
                        <a href="showResume">我的简历</a>
                    </td>
                    <td>
                        <a href="">已投递</a>
                    </td>
                    <td>
                        <a href="toShowInterview">面试邀请</a>
                    </td>

                </tr>
            </table>
        </div>
    </div>
</body>
</html>
