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
<script type="text/javascript" src="<c:url value="/static/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/jquery.form.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>

<style type="text/css">
    #page-body {
        margin-top: 70px;
    }
</style>

<script type="text/javascript">
$(function(){
	$(".nav-tabs a").on('click', function(e){
		$(this).tab('show');
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
            <div class="col-md-2">
                <jsp:include page="/aside.jsp"/>
            </div>
            <div class="col-md-10">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#user-list">用户列表</a></li>
                    <li><a href="#user-add">添加用户</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="user-list">
                        <div class="panel panel-default" style="border-top:0; border-top-left-radius:0; border-top-right-radius:0;">
                            <table class="table table-hover table-responsive table-condensed">
                                <thead>
                                    <tr>
                                        <th>用户ID</th>
                                        <th>用户名</th>
                                        <th>首页</th>
                                        <th>选择</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.username}</td>
                                        <td>${user.indexMenu.path}</td>
                                        <td><input type="checkbox"/></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane" id="user-add">
                        <div class="panel panel-default" style="border-top:0; border-top-left-radius:0; border-top-right-radius:0;">
                            <div class="panel-body">
	                            <form action="#" class="form-horizontal">
	                                <div class="form-group">
	                                    <label class="col-md-1 control-label" for="username">用户名</label>
	                                    <div class="col-md-5">
	                                        <input type="text" class="form-control" name="username" id="username"/>
	                                    </div>
	                                </div>
	                                <div class="form-group">
                                        <label class="col-md-1 control-label" for="indexMenu">首页</label>
                                        <div class="col-md-5">
                                            <input type="text" class="form-control" name="indexMenu" id="indexMenu"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-offset-1 col-md-5">
                                            <input type="submit" class="btn btn-primary" name="submit" value="保存"/>
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
</body>
</html>