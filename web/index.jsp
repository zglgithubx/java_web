
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>人力信息管理系统</title>
  <link href="./bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="./bootstrap-3.3.7-dist/js/jquery.min.js"></script>
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="./bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  <style>
    div.container{
      margin: 120px auto;
      background-image: url("image/javaweb.jpg");
    }
    body{
      color:white;
    }
  </style>
  <script>
    window.onload=function () {
      document.getElementById("img").onclick=function () {
        this.src="/JavaWeb_FirstCase_war_exploded/CheckCodeServlet?time="+new Date().getTime();
      }
    }
  </script>
</head>
<body>
<div class="container" style="width: 500px">
  <h2 style="text-align: center">登录</h2>
  <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    <div class="form-group">
      <label for="username" >用户名</label>
      <input type="text" name="username" class="form-control" id="username" placeholder="请输入账号"/>
    </div>
    <div class="form-group">
      <label for="password" >密码</label>
      <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
    </div>
    <div class="form-inline">
      <label for="vcode">验证码：</label>
      <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
      <a><img src="${pageContext.request.contextPath}/CheckCodeServlet" title="看不清点击刷新" id="img"/></a>
    </div>
    <hr/>
    <div class="form-group" style="text-align: center;">
      <input class="btn btn btn-primary" type="submit" value="登录">
    </div>
  </form>
  <c:if test="${error!=null}">
    <div class="alert alert-warning alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" >
        <span>&times;</span>
      </button>
      <strong>${error}</strong>
    </div>
  </c:if>
</div>
</body>
</html>
