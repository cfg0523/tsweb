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
            <div class="col-md-10"></div>
        </div>
	</div>
</body>
</html>