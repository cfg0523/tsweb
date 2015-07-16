<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<div class="panel panel-default">
    <div class="panel-body">
        <form action="<c:url value="/sys/role/update"/>" class="form-horizontal" method="post">
            <div class="form-group">
                <label class="col-md-1 control-label" for="id">角色ID</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="id" id="id" value="${role.id}" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="name">角色名</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="name" id="name" value="${role.name}" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="label">角色描述</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="label" id="label" value="${role.label}"/>
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