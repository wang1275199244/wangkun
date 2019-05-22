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
        List<RecruitmentInformation> list = (List<RecruitmentInformation>)session.getAttribute("recruitmentInformations");
        pageContext.setAttribute("list",list);
    %>
</head>
<style>
    #outer{
        border: 1px solid #F4F4F4;
        width: 1306px;
        background: #F4F4F4;
        position: relative;
        margin: 0px auto;
    }
    #inner1{
        position: absolute;
        left: 0px;
        top:0px;
        border: 1px solid #F4F4F4;
        width: 1306px;
        height: 37px;
        background: #F4F4F4;
    }

    #inner2{
        position: absolute;
        left: 0px;
        top:145px;
        border: 1px solid #F4F4F4;
        width: 1306px;
        height: 470px;
        background: #F4F4F4;
    }

    #inner3{
        position: absolute;
        left: 0px;
        top:42px;
        border: 1px solid #F4F4F4;
        width: 1306px;
        height: 78px;
        font-size: 50px;
        font-weight: bold;
        font-family: 宋体;
        background: #F4F4F4;
        text-align: center;
        padding-top: 20px;
    }

    #inner4{
        position: absolute;
        left: 0px;
        top:0px;
        border: 1px solid #F4F4F4;
        width: 1306px;
        height: 32px;
        background: #F4F4F4;
        text-align: center;
        padding-top: 4px;
    }

    #inner5{
        position: absolute;
        left: 0px;
        top:32px;
        border: 1px solid #F4F4F4;
        background: #F4F4F4;
        padding-top: 4px;
    }

    .ab{
        border: 1px solid #F4F4F4;
        width: 120px;
        height: 28px;
        padding-top: 4px;
        text-align: center;
        vertical-align: text-bottom;
    }

    #fir{
        position: absolute;
        left: 20px;
        top:0px;
    }

    #login{
        position: absolute;
        left: 140px;

    }

    #log{
        border: 1px solid #F4F4F4;
        width: 100px;
        background: #F4F4F4;
        position: absolute;
        left:0px;
        top:28px;
        text-align: center;
        z-index: 2;
    }

    #rig{
        position: absolute;
        left: 400px;

    }

    #vif{
        position: absolute;
        left: 700px;

    }

    .bc{
        position: absolute;
        left: 140px;
        padding-top: 4px;
        text-align: center;
    }

    .cd{
        position: absolute;
        left: 400px;
        padding-top: 4px;
        text-align: center;
    }

    a{
        text-decoration: none;
    }

    th{
        text-align: center;
    }

    td{
        width: 145px;
        text-align: center;
    }

    #page{
        border: 1px solid #F4F4F4;
        text-align: center;
        width: 780px;
        height: 24px;
        position: absolute;
        left: 290px;
        top:430px;
    }
</style>
<script src="js/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $("#login").mousemove(function () {
            $("#log").css("display",'block');
        })

        $("#login").mouseout(function () {
            $("#log").css("display",'none');
        })
    })
</script>
<body>
<div id="outer">
<div id="inner1">

    <div class="ab" id="fir"><a href="#">首页</a></div>
<c:if test="${sessionScope.admin == null&&sessionScope.visitor == null&&sessionScope.employee == null}">
    <div class="ab" id="login">登录
        <div id="log" style="display: none">
            <a href="toAdminLogin">管理员</a><br/>
            <a href="toVisitorLogin">游客</a><br/>
            <a href="toEmployeeLogin">员工</a>
        </div>
    </div>
    <div class="ab" id="rig"><a href="toRegister">注册</a></div>
    <div class="ab" id="vif"><a href="toShowVisitorInformation">个人中心</a></div>
</c:if>
    <c:if test="${sessionScope.admin != null}">
        <a href="" class="bc">欢迎您，${admin.name}</a>
        <a href="toLogOut" class="cd">退出</a>
    </c:if>
    <c:if test="${sessionScope.visitor != null}">
        <a href=""  class="bc">欢迎您，${visitor.name}</a>
        <a href="toLogOut" class="cd">退出</a>
    </c:if>
    <c:if test="${sessionScope.employee != null}">
        <a href="" class="bc">欢迎您，${employee.account}</a>
        <a href="toLogOut" class="cd">退出</a>
    </c:if>
</div>

    <c:if test="${sessionScope.visitor != null}">
        <div class="ab" id="vif"><a href="toShowVisitorInformation">个人中心</a></div>
    </c:if>
    <div id="inner3">欢迎光临XX公司人力资源管理系统</div>
<div id="inner2">
<div id="inner4">最新招聘</div>
    <hr/>
    <div id="inner5">
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
</div>
</body>
</html>
