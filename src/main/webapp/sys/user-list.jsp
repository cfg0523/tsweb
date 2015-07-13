<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/tsweb.css"/>"/>

<script type="text/javascript" src="<c:url value="/static/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/jquery.form.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/tsweb.js"/>"></script>

<script type="text/javascript">
$(function(){
    $("#page-content").on('click', '.nav-tabs a', function(e){
        $(this).tab('show');
    });
    
    $('.tab-trigger').on('click', function(e) {
        e.preventDefault();
        $(this).tabtrigger();
    });
});
</script>

<title>TSWEB</title>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top" id="page-header">
        <jsp:include page="/header.jsp"/>
    </div>
    
    <div class="container-fluid" id="page-body">
        <div class="row">
            <div class="col-md-2" id="page-aside">
                <jsp:include page="/aside.jsp"/>
            </div>
            <div class="col-md-10" id="page-content">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#user-list">用户列表</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="user-list">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <a href="<c:url value="/sys/user/add"/>" class="btn btn-primary tab-trigger"
                                    data-url="<c:url value="/sys/user/add"/>"
                                    data-tabpaneid="user-add"
                                    data-tablabel="添加用户"
                                    data-navtabs=".nav-tabs"
                                    data-tabcontent=".tab-content">添加</a>
                            </div>
                            <table class="table table-hover table-responsive table-condensed">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" title="select all"></th>
                                        <th>用户ID</th>
                                        <th>用户名</th>
                                        <th>首页</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                    <tr>
                                        <th><input type="checkbox" name="selectIds" value="${user.id}"></th>
                                        <td>${user.id}</td>
                                        <td>${user.username}</td>
                                        <td>${user.indexMenu.path}</td>
                                        <td>
                                            <a href="<c:url value="/sys/user/update/${user.id}"/>" class="btn-link tab-trigger"
                                                data-url="<c:url value="/sys/user/update/${user.id}"/>"
                                                data-tabpaneid="user-update-${user.id}"
                                                data-tablabel="修改用户:${user.username}"
                                                data-navtabs=".nav-tabs"
                                                data-tabcontent=".tab-content">修改</a>
                                            <a href="<c:url value="/sys/user/chgpwd/${user.id}"/>" class="btn-link tab-trigger"
                                                data-url="<c:url value="/sys/user/chgpwd/${user.id}"/>"
                                                data-tabpaneid="user-chgpwd-${user.id}"
                                                data-tablabel="修改密码:${user.username}"
                                                data-navtabs=".nav-tabs"
                                                data-tabcontent=".tab-content">修改密码</a>
                                            <a href="<c:url value="/sys/user/delete/${user.id}"/>" class="btn-link">删除</a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <form action="#" method="post">
                                        <div class="query-group">
                                            <div class="query row">
                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                    <select class="form-control">
                                                        <option>And</option>
                                                        <option>Or</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4">
                                                    <select class="form-control">
                                                        <option></option>
                                                        <option>用户名</option>
                                                        <option>密码</option>
                                                        <option>首页</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                    <select class="form-control">
                                                        <option>=</option>
                                                        <option>like</option>
                                                        <option>&gt;</option>
                                                        <option>&gt;=</option>
                                                        <option>&lt;</option>
                                                        <option>&lt;=</option>
                                                        <option>!=</option>
                                                        <option>not like</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4">
                                                    <input type="text" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="query row">
                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                    <select class="form-control">
                                                        <option>And</option>
                                                        <option>Or</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4">
                                                    <select class="form-control">
                                                        <option></option>
                                                        <option>用户名</option>
                                                        <option>密码</option>
                                                        <option>首页</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                    <select class="form-control">
                                                        <option>=</option>
                                                        <option>like</option>
                                                        <option>&gt;</option>
                                                        <option>&gt;=</option>
                                                        <option>&lt;</option>
                                                        <option>&lt;=</option>
                                                        <option>!=</option>
                                                        <option>not like</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4">
                                                    <input type="text" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-1 col-sm-1 col-xs-1">
                                                    <input type="text" class="form-control"/>
                                                </div>
                                                <ul class="pagination" style="margin:0; margin-left:10px;">
                                                    <li><a href="#">&laquo;</a></li>
                                                    <li><a href="#">1</a></li>
                                                    <li><a href="#">2</a></li>
                                                    <li><a href="#">3</a></li>
                                                    <li><a href="#">4</a></li>
                                                    <li><a href="#">5</a></li>
                                                    <li><a href="#">&raquo;</a></li>
                                                </ul>
                                                <button type="button" class="btn btn-primary pull-right">查询</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>