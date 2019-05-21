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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {

            //验证开始时间格式
            $("#sta").blur(function () {
                $.post("checkStartTime",{"startTime":$(this).val()},function (obj) {
                    if(obj == 0) {
                        alert("输入时间格式不对")
                        $(":submit").attr("disabled",true);

                    }else{
                        $(":submit").attr("disabled",false);

                    }
                })
            })

            //验证结束时间格式及是否大于开始时间
            $("#end").blur(function () {
                $.post("checkEndTime",{"startTime":$("#sta").val(),"endTime":$(this).val()},function (obj) {
                    if(obj == 0) {
                        alert("输入时间格式不对")
                        $(":submit").attr("disabled",true);

                    }else{
                        $(":submit").attr("disabled",false);

                    }
                })
            })


        })



    </script>
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
            <textarea name="content" cols="10" rows="3" required ></textarea>
            </p>

            <p>
                <label>培训开始时间</label>
                <input name="startTime" placeholder="请输入开始时间" id="sta" required>(格式:2019-10-5 10:00)
            </p>

            <p>
                <label>培训结束时间</label>
                <input name="endTime" placeholder="请输入结束时间" id="end" required >(格式:2019-10-5 10:30)
            </p>

            <p>
                <label>培训地点</label>
                <input name="place" placeholder="请输入地点" required>
            </p>

            <input type="hidden" name="state" value="0">
            <input type="submit" value="确认">
            <input type="reset" value="取消">
        </div>
        </form>
    </div>
</body>
</html>
