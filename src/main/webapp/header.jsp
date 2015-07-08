<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="<c:url value="${brandMenu.path}"/>" class="navbar-brand">${brandMenu.label}</a>
    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse">
        <ul class="nav navbar-nav" id="pagenavbar">
            <c:forEach items="${brandMenu.subMenus}" var="topMenu">
                <c:choose>
                    <c:when test="${empty topMenu.path}">
                        <li class="dropdown">
                            <a href="<c:url value="${topMenu.path}"/>" class="dropdown-toggle" data-toggle="dropdown">
                                <span>${topMenu.label}</span> <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <c:forEach items="${topMenu.subMenus}" var="subTopMenu">
                                    <li><a href="<c:url value="${subTopMenu.path}"/>">${subTopMenu.label}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="<c:url value="${topMenu.path}"/>">${topMenu.label}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                <span><shiro:principal/></span> <span class="caret"></span>
	            </a>
	            <ul class="dropdown-menu dropdown-menu-right">
	                <li><a href='<c:url value="/logout"/>'>退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
