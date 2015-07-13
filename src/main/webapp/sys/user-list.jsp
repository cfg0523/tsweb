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
<script type="text/javascript" src="<c:url value="/static/js/tsweb.js"/>"></script>

<style type="text/css">
    #page-body {
        margin-top: 70px;
    }
    
    .tab-pane .panel {
        border-top:0;
        border-top-left-radius:0;
        border-top-right-radius:0;
    }
    
    .nav-tabs .close {
        margin-left: .8em;
        font-size: 1em;
    }
</style>

<script type="text/javascript">
$(function(){
	$("#page-content").on('click', '.nav-tabs a', function(e){
		$(this).tab('show');
	});
	
	$('.tab-trigger').tabtrigger();
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
                                <a href="<c:url value="/sys/user/add"/>" class="btn btn-primary tab-trigger" data-url="/tsweb/sys/user/add" data-tabpaneid="user-add" data-tablabel="添加用户" data-navtabs=".nav-tabs" data-tabcontent=".tab-content">添加</a>
                            </div>
                            <table class="table table-hover table-responsive table-condensed">
                                <thead>
                                    <tr>
                                        <th>用户ID</th>
                                        <th>用户名</th>
                                        <th>首页</th>
                                        <th><input type="checkbox" title="select all"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.username}</td>
                                        <td>${user.indexMenu.path}</td>
                                        <th><input type="checkbox" name="selectIds" value="${user.id}"></th>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
</body>
</html>