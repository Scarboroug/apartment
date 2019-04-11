<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${contextPath }/static/js/jquery-1.9.1.min.js" ></script>
<link rel="stylesheet" href="${contextPath }/common/css/sapar.css" />
<link rel="stylesheet" href="${contextPath }/static/css/index_inner.css" />
<script type="text/javascript" src="${contextPath }/static/js/index_inner.js"></script>
<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>

<title>系统</title>
</head>

<body>
<div id="container">
    <div id="bd">
    	<div class="wrap clearfix">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
                	<li class="office current"><div class="nav-header"><a href="${contextPath }/account/list.do" target="iframe1" class="clearfix"><span>账户管理</span><i class="icon"></i></a></div></li>
                </ul>
            </div>
            <iframe src="${contextPath }/account/list.do" name="iframe1" width="100%" height="100%" frameborder="0"></iframe>
        </div>
    </div>
</div>
<script type="text/javascript" src="${contextPath }/static/js/index_inner.js" ></script>
</body>


</html>
