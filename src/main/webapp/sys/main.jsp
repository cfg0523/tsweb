<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
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

<title>TSWEB</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" id="page-header">
	    <div class="container-fluid">
	        <div class="navbar-header">
	            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </button>
	            <a href="<c:url value="${brand.path}"/>" class="navbar-brand">${brand.label}</a>
	        </div>
	        <div class="collapse navbar-collapse" id="navbar-collapse">
	            <ul class="nav navbar-nav" id="pagenavbar">
	                <c:forEach items="${brand.subMenus}" var="module">
	                    <c:choose>
	                        <c:when test="${empty module.path}">
	                            <li class="dropdown">
	                                <a href="<c:url value="${module.path}"/>" class="dropdown-toggle" data-toggle="dropdown">
	                                    <span>${module.label}</span> <span class="caret"></span>
	                                </a>
	                                <ul class="dropdown-menu">
	                                    <c:forEach items="${module.subMenus}" var="subModule">
	                                        <li><a href="<c:url value="${subModule.path}"/>">${subModule.label}</a></li>
	                                    </c:forEach>
	                                </ul>
	                            </li>
	                        </c:when>
	                        <c:otherwise>
	                            <li><a href="<c:url value="${module.path}"/>">${module.label}</a></li>
	                        </c:otherwise>
	                    </c:choose>
	                </c:forEach>
	            </ul>
	            <ul class="nav navbar-nav navbar-right">
	                <li class="dropdown">
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                        <span>用户</span> <span class="caret"></span>
	                    </a>
	                    <ul class="dropdown-menu dropdown-menu-right">
	                        <li><a href='<c:url value="/sys/logout"/>'>退出</a></li>
	                    </ul>
	                </li>
	            </ul>
	        </div>
	    </div>
	</div>
	
	<div class="container-fluid" id="page-body">
        <div class="row">
            <div class="col-md-2">
                <c:if test="${not empty module}">
					<div class="panel panel-default">
					    <div class="panel-heading">${module.label}</div>
					    <ul class="list-group">
					        <c:forEach items="${module.subMenus}" var="menu">
					            <c:choose>
					                <c:when test="${empty menu.path}">
					                    <li class="list-group-item">
					                        <div class="collapsed" data-toggle="collapse" data-target="#collapse-menu-${menu.name}">
					                            <span>${menu.label}</span>
					                            <span class="glyphicon glyphicon-chevron-down pull-right"></span>
					                        </div>
					                        <ul class="nav nav-list collapse" id="collapse-menu-${menu.name}">
					                            <c:forEach items="${menu.subMenus}" var="menuItem">
					                                <li><a target="pagecontent" href="<c:url value="${menuItem.path}"/>">${menuItem.label}</a></li>
					                            </c:forEach>
					                        </ul>
					                    </li>
					                </c:when>
					                <c:otherwise>
					                    <li class="list-group-item">
					                        <a target="pagecontent" href="<c:url value="${menu.path}"/>">${menu.label}</a>
					                    </li>
					                </c:otherwise>
					            </c:choose>
					        </c:forEach>
					    </ul>
					</div>
				</c:if>
            </div>
            <div class="col-md-10"></div>
        </div>
	</div>
</body>
</html>