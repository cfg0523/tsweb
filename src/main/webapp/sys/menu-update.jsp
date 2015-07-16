<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<div class="panel panel-default">
    <div class="panel-body">
        <form action="<c:url value="/sys/menu/update"/>" class="form-horizontal" method="post">
            <div class="form-group">
                <label class="col-md-1 control-label" for="id">菜单ID</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="id" id="id" value="${menu.id}" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="name">菜单名</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="name" id="name" value="${menu.name}" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="label">菜单描述</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="label" id="label" value="${menu.label}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="path">菜单路径</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="path" id="path" value="${menu.path}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="resourceGroup">资源分组</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="resourceGroup" id="resourceGroup" value="${menu.resourceGroup}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="resourceIndex">组内索引</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="resourceIndex" id="resourceIndex" value="${menu.resourceIndex}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="resourceIndex">组内索引</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="resourceIndex" id="resourceIndex" value="${menu.resourceIndex}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-1 control-label" for="parentId">父级菜单</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="parent.id" id="parentId" value="${menu.parent.id}"/>
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