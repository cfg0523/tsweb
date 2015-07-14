<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<form action="<c:url value="/sys/user/page"/>" method="post">
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
                    <option value="user_id" ${phrase.condition == "user_id" ? "selected" : ""} >用户ID</option>
                    <option value="user_name" ${phrase.condition == "user_name" ? "selected" : ""} >用户名</option>
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
                <input type="text" class="form-control" name="pagecode" id="pagecode" value="${pager.pagecode}"/>
                <input type="hidden" class="form-control" name="pagesize" value="${pager.pagesize}"/>
            </div>
            <div class="col-md-10 col-sm-10 col-xs-10">
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

<script type="text/javascript">
$(function(){
    var $querybtn = $('#querybtn');
    var $pagecode = $('#pagecode');
    $("a[data-pagecode]").on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var pagecode = $this.data('pagecode');
        $pagecode.val(pagecode);
        $querybtn.click();
    });
});
</script>
