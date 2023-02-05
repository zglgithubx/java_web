<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户信息管理</title>
    <link href="./bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style>
        h2,tr,th{
            text-align: center;
        }
    </style>
    <script>
        function dele(id){
            if(confirm("您确定要删除吗？")){
                location.href="${pageContext.request.contextPath}/deleteServlet?id="+id;
            }
        }
        window.onload=function () {
            document.getElementById("delselected").onclick=function () {
                let cbs=document.getElementsByName("uid");
                let flag=false;
                for(let i=0;i<cbs.length;i++){
                    if(cbs[i].checked){
                        flag=true;
                    }
                }
                if(flag){
                    if(confirm("您确定要删除选中的吗？")){
                        document.getElementById("form").submit();
                    }
                }else{
                    confirm("你未选择任何用户！")
                }

            }
            document.getElementById("box-0").onclick=function () {
                let cbs=document.getElementsByName("uid");
                for(let i=0;i<cbs.length;i++){
                    cbs[i].checked=this.checked;
                }
            }
            document.getElementById("quit").onclick=function () {
                location.href="${pageContext.request.contextPath}/";
            }
        }
    </script>

</head>
<body>
<h2 style="text-align: center;margin:20px 0;">用户信息</h2>
<h3>管理员:${user}</h3>
<div>
    <form class="form-inline" style="float:left;" action="${pageContext.request.contextPath}/pageQueryServlet" method="post">
        <div class="form-group">
            <label for="exampleInputName2" >姓名</label>
            <input type="text" class="form-control" id="exampleInputName2" name="name" placeholder="Jane Doe" value="${condition.name[0]}">
        </div>
        <div class="form-group">
            <label for="exampleInputName3">籍贯</label>
            <input type="text" class="form-control" id="exampleInputName3" name="address" placeholder="火星"  value="${condition.address[0]}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">邮箱</label>
            <input type="email" class="form-control" id="exampleInputEmail2" name="email" placeholder="jane.doe@example.com"  value="${condition.email[0]}">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
</div>
<div style="float: right">
    <a class="btn btn-primary" href="add.jsp">添加联系人</a>
    <a class="btn btn-primary" href="javascript:void(0)" id="delselected">删除选中</a>
    <a class="btn btn-primary" href="javascript:void(0)" id="quit">退出</a>
</div>
<form  action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post" id="form">
    <table border="1" class="table table-bordered table-hover">
    <tr style="background-color: #2aabd2" class="success">
        <th><input type="checkbox" id="box-0"></th>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>籍贯</th>
        <th>QQ号</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pb.list}" varStatus="s" var="fc">
        <tr>
            <td><input type="checkbox" value="${fc.id}" name="uid"></td>
            <td>${s.count}</td>
            <td>${fc.name}</td>
            <td>
                <c:if test="${fc.gender.toString()==true}">男</c:if>
                <c:if test="${fc.gender.toString()==false}">女</c:if>
            </td>
            <td>${fc.address}</td>
            <td>${fc.qq}</td>
            <td>${fc.email}</td>
            <td>
                <a class=" btn btn-default btn-sm" href="${pageContext.request.contextPath}/echoServlet?id=${fc.id}">修改</a>
                <a class=" btn btn-default btn-sm" href="javascript:dele(${fc.id});">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
<div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pb.currentPage == 1}">
            <li class="disabled">
            </c:if>

            <c:if test="${pb.currentPage != 1}">
            <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/pageQueryServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage==i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/pageQueryServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                </c:if>
                <c:if test="${pb.currentPage!=i}">
                    <li><a href="${pageContext.request.contextPath}/pageQueryServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                </c:if>
            </c:forEach>

            <c:if test="${pb.currentPage==pb.totalPage}">
                <li class="disabled">
            </c:if>
            <c:if test="${pb.currentPage!=pb.totalPage}">
                <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/pageQueryServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;margin-left:10px">
                共${pb.totalCount}条记录，共${pb.totalPage}页
            </span>
        </ul>
    </nav>
</div>
</body>
</html>
