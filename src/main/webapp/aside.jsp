<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<c:if test="${not empty moduleMenu}">
    <div class="panel panel-default">
        <div class="panel-heading">${moduleMenu.label}</div>
        <ul class="list-group">
            <c:forEach items="${moduleMenu.subMenus}" var="asideMenu">
                <c:choose>
                    <c:when test="${empty asideMenu.path}">
                        <li class="list-group-item">
                            <div class="collapsed" data-toggle="collapse" data-target="#collapse-menu-${asideMenu.name}">
                                <span>${asideMenu.label}</span>
                                <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                            </div>
                            <ul class="nav nav-list collapse" id="collapse-menu-${asideMenu.name}">
                                <c:forEach items="${asideMenu.subMenus}" var="asideMenuItem">
                                    <li><a href="<c:url value="${asideMenuItem.path}"/>">${asideMenuItem.label}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="list-group-item">
                            <a href="<c:url value="${asideMenu.path}"/>">${asideMenu.label}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </div>
</c:if>