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
    <title>岗位申请</title>

</head>
<body>
    <div>
        <div>
            <a href="toShowResume">返回</a>
        </div>

        <h4>岗位申请</h4>
        <%
            Resume resume = (Resume) session.getAttribute("resume2");
            pageContext.setAttribute("resume",resume);
        %>
        <div>
            <form action="confirmApplicationJob" method="post">
                <hr/>
                <h4>姓名:</h4>
                <div>${resume.name}</div>
                <hr/>
                <h4>性别:</h4>
                <div>${resume.sex}</div>
                <hr/>
                <h4>出生年月:</h4>
                <div>${resume.birthDate}</div>
                <hr/>
                <h4>民族:</h4>
                <div>${resume.national}</div>
                <hr/>
                <h4>学历:</h4>
                <div>${resume.degree}</div>
                <hr/>
                <h4>婚姻状况:</h4>
                <div>${resume.maritalStatus}</div>
                <hr/>
                <h4>毕业院校:</h4>
                <div>${resume.graduateSchool}</div>
                <hr/>
                <h4>籍贯:</h4>
                <div>${resume.resident}</div>
                <hr/>
                <h4>专业:</h4>
                <div>${resume.major}</div>
                <hr/>
                <h4>政治面貌:</h4>
                <div>${resume.pliticsStatus}</div>
                <hr/>
                <h4>联系电话:</h4>
                <div>${resume.phone}</div>
                <hr/>
                <h4>电子邮件:</h4>
                <div>${resume.email}</div>
                <hr/>
                <h4>求职意向:</h4>
                <div>${resume.objective}</div>
                <hr/>
                <h4>获得证书:</h4>
                <div>${resume.certificate}</div>
                <hr/>
                <h4>工作经验:</h4>
                <div>${resume.workExperience}</div>
                <hr/>
                <h4>自我评价:</h4>
                <div>${resume.selfAssessment}</div>
                <hr/>
                <input type="hidden" name="id" value="${resume.id}">
                <input type="submit" value="申请岗位">
            </form>


        </div>


    </div>
</body>
</html>
