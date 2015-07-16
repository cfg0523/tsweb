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
<script type="text/javascript" src="<c:url value="/static/js/tsweb-pager.js"/>"></script>

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
                    <li class="active"><a href="#menu-list">菜单列表</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="menu-list">
                        <div class="panel panel-default">
                            <table class="table table-hover table-responsive table-condensed">
                                <thead>
                                    <tr>
                                        <th>菜单ID</th>
                                        <th>菜单名</th>
                                        <th>菜单描述</th>
                                        <th>菜单路径</th>
                                        <th>资源分组</th>
                                        <th>组内索引</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${menus}" var="menu">
                                    <tr>
                                        <td>${menu.id}</td>
                                        <td>${menu.name}</td>
                                        <td>${menu.label}</td>
                                        <td>${menu.path}</td>
                                        <td>${menu.resourceGroup}</td>
                                        <td>${menu.resourceIndex}</td>
                                        <td>
                                            <a href="<c:url value="/sys/menu/update/${menu.id}"/>" class="btn-link tab-trigger"
                                                data-url="<c:url value="/sys/menu/update/${menu.id}"/>"
                                                data-tabpaneid="menu-update-${menu.id}"
                                                data-tablabel="修改菜单:${menu.name}"
                                                data-navtabs=".nav-tabs"
                                                data-tabcontent=".tab-content">修改</a>
                                            <a href="<c:url value="/sys/menu/delete/${menu.id}"/>" class="btn-link">删除</a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <form action="<c:url value="/sys/menu"/>" method="post">
                                        <div class="query-group">
                                            <c:forEach begin="0" end="${pager.phrases.size() > 2 ? pager.phrases.size() - 1 : 2}" var="index">
                                            <c:set var="phrase" value="${pager.phrases[index]}"/>
                                            <div class="query row">
                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                    <select class="form-control" name="phrases[${index}].relation">
                                                        <option value="and" ${phrase.relation == "and" ? "selected" : ""} >And</option>
                                                        <option value="or" ${phrase.relation == "or" ? "selected" : ""} >Or</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4">
                                                    <select class="form-control" name="phrases[${index}].condition">
                                                        <option value="" ${empty phrase.condition ? "selected" : ""}></option>
                                                        <option value="menu_id" ${phrase.condition == "menu_id" ? "selected" : ""} >菜单ID</option>
                                                        <option value="menu_name" ${phrase.condition == "menu_name" ? "selected" : ""} >菜单名</option>
                                                        <option value="menu_label" ${phrase.condition == "menu_label" ? "selected" : ""} >菜单描述</option>
                                                        <option value="menu_path" ${phrase.condition == "menu_path" ? "selected" : ""} >菜单路径</option>
                                                        <option value="menu_resource_group" ${phrase.condition == "menu_resource_group" ? "selected" : ""} >资源分组</option>
                                                        <option value="menu_resource_index" ${phrase.condition == "menu_resource_index" ? "selected" : ""} >组内索引</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                    <select class="form-control" name="phrases[${index}].operator">
                                                        <option value="eq" ${phrase.operator == "eq" ? "selected" : ""} >=</option>
                                                        <option value="like" ${phrase.operator == "like" ? "selected" : ""} >like</option>
                                                        <option value="gt" ${phrase.operator == "gt" ? "selected" : ""} >&gt;</option>
                                                        <option value="ge" ${phrase.operator == "ge" ? "selected" : ""} >&gt;=</option>
                                                        <option value="lt" ${phrase.operator == "lt" ? "selected" : ""} >&lt;</option>
                                                        <option value="le" ${phrase.operator == "le" ? "selected" : ""} >&lt;=</option>
                                                        <option value="ne" ${phrase.operator == "ne" ? "selected" : ""} >!=</option>
                                                        <option value="notlike" ${phrase.operator == "notlike" ? "selected" : ""} >not like</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-xs-4">
                                                    <input type="text" class="form-control" name="phrases[${index}].value" value="${phrase.value}"/>
                                                </div>
                                            </div>
                                            </c:forEach>
                                            <div class="row">
                                                <div class="col-md-1 col-sm-1 col-xs-1">
                                                    <input type="text" class="form-control" id="pageskip" value="${pager.pagecode}"/>
                                                    <input type="hidden" class="form-control" name="pagecode" id="pagecode" value="${pager.pagecode}"/>
                                                    <input type="hidden" class="form-control" id="maxpagecode" value="${pager.maxpagecode}"/>
                                                    <input type="hidden" class="form-control" name="pagesize" value="${pager.pagesize}"/>
                                                </div>
                                                <div class="col-md-10 col-sm-10 col-xs-10" style="height:34px;">
                                                    <ul class="pagination">
                                                        <c:set var="prevpagecode" value="${pager.pagecode > 1 ? pager.pagecode - 1 : 1}"/>
                                                        <c:set var="nextpagecode" value="${pager.pagecode < pager.lastpagecode ? pager.pagecode + 1 : pager.lastpagecode}"/>
                                                        <li class='${prevpagecode == pager.pagecode ? "disabled" : ""}' ><a href="#" data-pagecode="${prevpagecode}">&laquo;</a></li>
                                                        <c:forEach begin="${pager.firstpagecode}" end="${pager.lastpagecode}" var="code">
                                                        <li class='${pager.pagecode == code ? "active" : ""}' ><a href="#" data-pagecode="${code}">${code}</a></li>
                                                        </c:forEach>
                                                        <li class='${nextpagecode == pager.pagecode ? "disabled" : ""}' ><a href="#" data-pagecode="${pager.pagecode < pager.lastpagecode ? pager.pagecode + 1 : pager.lastpagecode}">&raquo;</a></li>
                                                    </ul>
                                                </div>
                                                <div class="col-md-1 col-sm-1 col-xs-1">
                                                    <input type="submit" class="btn btn-primary pull-right" name="submit" id="querybtn" value="查询"/>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-md-6" style="margin-top:5px; padding-left:0; padding-right:0;">
                                    <a href="<c:url value="/sys/menu/add"/>" class="btn btn-primary tab-trigger pull-right"
                                        data-url="<c:url value="/sys/menu/add"/>"
                                        data-tabpaneid="user-add"
                                        data-tablabel="添加菜单"
                                        data-navtabs=".nav-tabs"
                                        data-tabcontent=".tab-content">添加</a>
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