<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<div class="panel panel-default">
    <div class="panel-body">
        <form action="<c:url value="/sys/user/add"/>" class="form-horizontal" method="post">
            <div class="form-group">
                <label class="col-md-1 control-label" for="username">用户名</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="username" id="username"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="password">密码</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="password" id="password"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="indexMenu">首页</label>
                <div class="col-md-5">
                    <select class="form-control" name="indexMenu.id" id="indexMenu">
                        <c:forEach items="${menus}" var="menu">
                        <c:if test="${not empty menu.path}">
                        <option value="${menu.id}">${menu.path}</option>
                        </c:if>
                        </c:forEach>
                    </select>
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