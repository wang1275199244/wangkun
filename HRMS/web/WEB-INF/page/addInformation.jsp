<%@ page import="java.util.List" %>
<%@ page import="com.wk.model.Department" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/18 0018
  Time: 8:40
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
    <title>添加招聘信息</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script>

        $(function () {
            //获得职位
            $("#dep").change(function () {
                $.get("getALLOptions",{"name":$(this).val()},function (obj) {
                    $("#pos").empty();
                    for (var i in obj) {
                        $("#pos").append("<option value='" + obj[i].name + "'>" + obj[i].name +"</option>")
                        console.log(obj[i].name)
                    }
                })
            })

            //招聘人数校验（输入数量小于1时人数为1，大于100时人数为100）
            $("#ren").blur(function () {
                var num = $("#ren").val();
                if(num < 1){
                    $("#ren").val(1);
                }else if(num > 100){
                    $("#ren").val(100);
                }
            })

        })
    </script>
</head>
<body>
    <div>
        <div>
            <a href="toShowAllRI">返回</a>
        </div>

        <%
            List<Department> list = (List<Department>) session.getAttribute("dts");
            pageContext.setAttribute("list",list);
        %>
        <h4>招聘信息</h4>
        <form action="confirmAddInformation" method="post">
            <p>
                <label>部门:</label>
                <select name="department" id="dep">
                    <c:if test="${list != null && fn:length(list) != 0}">
                        <c:forEach items="${list}" var="department" varStatus="i">
                            <option>${department.name}</option>
                        </c:forEach>
                    </c:if>

                    <c:if test="${list == null || fn:length(list) == 0}">
                            <option></option>
                    </c:if>
        </select>
            </p>
            <p>
                <label>职位:</label>
                <select name="position" id="pos">

                </select>
            </p>
            <p>
                <label>工作经验:</label>
                <select name="workExperience">
                    <option>应届毕业生</option>
                    <option>1-3年</option>
                    <option>3-5年</option>
                    <option>5-10年</option>
                    <option>10年以上</option>
                </select>
            </p>
            <p>
                <label>学历要求:</label>
                <select name="degreeRequired">
                    <option>不限</option>
                    <option>高中</option>
                    <option>大专</option>
                    <option>本科</option>
                    <option>研究生</option>
                </select>
            </p>
            <p>
                <label>工作方式:</label>
                <select name="working">
                    <option>全职</option>
                    <option>兼职</option>
                </select>
            </p>
            <p>
                <label>薪资范围:</label>
                <input type="text" name="salaryRange"/>
            </p>
            <p>
                <label>工作地点:</label>
                <input type="text" name="workPlace"/>
            </p>
            <p>
                <label>福利待遇:</label>
                <textarea name="welfare" cols="12" rows="3"required ></textarea>
            </p>
            <p>
                <label>职位描述:</label>
                <textarea name="positionDescription" cols="12" rows="3"required ></textarea>
            </p>
            <p>
                <label>公司信息:</label>
                <textarea name="companyInformation" cols="12" rows="3"required ></textarea>
            </p>
            <p>
                <label>招聘人数:</label>
                <input type="number" name="recruitingNumbers" id="ren"><span>输入人数为1-100</span>
            </p>
            <input type="submit" value="确认">
            <input type="reset" value="取消">
        </form>
    </div>
</body>
</html>
