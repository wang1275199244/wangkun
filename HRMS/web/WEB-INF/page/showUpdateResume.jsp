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
            <a href="toShowResume">返回</a>
        </div>

        <h4>修改简历</h4>

        <div>
            <%
                Resume resume = (Resume) session.getAttribute("resume");
                pageContext.setAttribute("resume",resume);
            %>
            <form action="updateResume" method="post">
                <p>
                    <label>姓名:</label>
                    <input type="text" class="bc" name="name" value="${resume.name}" required/>
                </p>
                <p>
                    <label>性别:</label>
                    <input type="radio" name="sex" value="${resume.sex}" checked/>男
                    <input type="radio" name="sex" value="${resume.sex}"/>女
                </p>
                <p>
                    <label>出生年月:</label>
                    <input type="text" name="birthDate" value="${resume.birthDate}"/>
                </p>
                <p>
                    <label>民族:</label>
                    <select name="national">
                        <option>${resume.national}</option>
                        <option>汉族</option>
                        <option>回族</option>
                        <option>壮族</option>
                        <option>彝族</option>
                    </select>
                </p>
                <p>
                    <label>学历:</label>
                    <select name="degree">
                        <option>${resume.degree}</option>
                        <option>中专</option>
                        <option>高中</option>
                        <option>大专</option>
                        <option>本科</option>
                        <option>研究生</option>
                    </select>
                </p>
                <p>
                    <label>婚姻状况:</label>
                    <select name="maritalStatus">
                        <option>${resume.maritalStatus}</option>
                        <option>未婚</option>
                        <option>已婚</option>
                        <option>离异</option>
                    </select>
                </p>
                <p>
                    <label>毕业院校:</label>
                    <input type="text" class="bc" name="graduateSchool" value="${resume.graduateSchool}"/>
                </p>
                <p>
                    <label>籍贯:</label>
                    <input type="text" class="bc" name="resident" value="${resume.resident}"/>
                </p>

                <p>
                    <label>专业:</label>
                    <select name="major">
                        <option>${resume.major}</option>
                        <option>软件工程</option>
                        <option>电子工程</option>
                        <option>计算机工程</option>
                    </select>
                </p>

                <p>
                    <label>政治面貌:</label>
                    <select name="pliticsStatus">
                        <option>${resume.pliticsStatus}</option>
                        <option>群众</option>
                        <option>共青团员</option>
                        <option>中共党员</option>
                    </select>
                </p>

                <p>
                    <label>联系电话:</label>
                    <input type="text" class="bc" name="phone" value="${resume.phone}"/>
                </p>

                <p>
                    <label>电子邮件:</label>
                    <input type="email" class="bc" name="email" value="${resume.email}"/>
                </p>

                <p>
                    <label>求职意向:</label>
                    <textarea name="objective" cols="12" rows="3" required >${resume.objective}</textarea>
                </p>

                <p>
                    <label>获得证书:</label>
                    <textarea name="certificate" cols="12" rows="3"required >${resume.certificate}</textarea>
                </p>

                <p>
                    <label>工作经历:</label>
                    <textarea name="workExperience" cols="12" rows="3"required >${resume.workExperience}</textarea>
                </p>

                <p>
                    <label>自我评价:</label>
                    <textarea name="selfAssessment" cols="12" rows="3"required >${resume.selfAssessment}</textarea>
                </p>
                <input type="hidden" name="vid" value="${resume.vid}">
                <input type="submit" value="确认">
                <input type="reset" value="取消">
            </form>

        </div>

    </div>
</body>
</html>
