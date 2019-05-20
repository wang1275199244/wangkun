<%@ page import="com.wk.model.Visitor" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/16 0016
  Time: 23:52
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
    <title>我的简历</title>

</head>
<body>
    <div>
        <div>
            <a href="toShowResume">返回</a>
        </div>

        <h4>我的简历</h4>
        <form action="addResume" method="post">
            <p>
                <label>姓名:</label>
                <input type="text" class="bc" name="name"/>
            </p>
            <p>
                <label>性别:</label>
                <input type="radio" name="sex" value="男" checked/>男
                <input type="radio" name="sex" value="女"/>女
            </p>
            <p>
                <label>出生年月:</label>
                <input type="text" name="birthDate" value=""/>
            </p>
            <p>
                <label>民族:</label>
                <select name="national">
                    <option>汉族</option>
                    <option>回族</option>
                    <option>壮族</option>
                    <option>彝族</option>
                </select>
            </p>
            <p>
                <label>学历:</label>
                <select name="degree">
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
                    <option>未婚</option>
                    <option>已婚</option>
                    <option>离异</option>
                </select>
            </p>
            <p>
                <label>毕业院校:</label>
                <input type="text" class="bc" name="graduateSchool"/>
            </p>
            <p>
                <label>籍贯:</label>
                <input type="text" class="bc" name="resident"/>
            </p>

            <p>
                <label>专业:</label>
                <select name="major">
                    <option>软件工程</option>
                    <option>电子工程</option>
                    <option>计算机工程</option>
                </select>
            </p>

            <p>
                <label>政治面貌:</label>
                <select name="pliticsStatus">
                    <option>群众</option>
                    <option>共青团员</option>
                    <option>中共党员</option>
                </select>
            </p>

            <p>
                <label>联系电话:</label>
                <input type="text" class="bc" name="phone"/>
            </p>

            <p>
                <label>电子邮件:</label>
                <input type="email" class="bc" name="email"/>
            </p>

            <p>
                <label>求职意向:</label>
                <textarea name="objective" cols="12" rows="3"required ></textarea>
            </p>

            <p>
                <label>获得证书:</label>
                <textarea name="certificate" cols="12" rows="3"required ></textarea>
            </p>

            <p>
                <label>工作经历:</label>
                <textarea name="workExperience" cols="12" rows="3"required ></textarea>
            </p>

            <p>
                <label>自我评价:</label>
                <textarea name="selfAssessment" cols="12" rows="3"required ></textarea>
            </p>
            <input type="hidden" name="vid" value="${sessionScope.visitor.id}">
            <input type="submit" value="确认">
            <input type="reset" value="取消">
        </form>
    </div>
</body>
</html>
