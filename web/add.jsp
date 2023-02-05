<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="./bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="verify.js"></script>
    <style>
        i{
            color:red;
            display: none;
        }
    </style>
</head>
<body>
<div class="container" style="width: 500px">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addServlet" method="post" id="addform">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" onfocus="name_verify()">
            <i></i>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value=true checked="checked"/>男
            <input type="radio" name="gender" value=false />女
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </select>
        </div>
        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码" onfocus="qq_verify()"/>
            <i></i>
        </div>
        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址" onfocus="email_verify()"/>
            <i></i>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-default" type="button" value="提交" onclick="addsubmit()" name="addsub"/>
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>
