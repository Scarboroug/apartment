<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${contextPath}/common/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/common/js/sapar.js"></script>
<script type="text/javascript" src="${contextPath}/static/js/index.js"></script>
<link rel="stylesheet" href="${contextPath}/common/css/sapar.css" />
<link rel="stylesheet" href="${contextPath}/static/css/index.css" />

<title>公寓管理系统</title>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap clearfix">
        	<div class="top-light"></div>
            <h1 class="logo"></h1>
            <ul class="main-nav clearfix">
                <li class="current" data-src="${contextPath}/static/system/index.html"><a href="javascript:;">系统</a></li>
                <li data-src="${contextPath}/static/ticket/index.html"><a href="javascript:;">机票</a></li>
                <li data-src="${contextPath}/static/msg/index.html"><a href="javascript:;">短信</a></li>
                <li data-src="${contextPath}/static/xingchengdan/index.html"><a href="javascript:;">行程单</a></li>
                <li data-src="${contextPath}/static/insurance/index.html"><a href="javascript:;">保险</a></li>
                <li data-src="${contextPath}/static/user/index.html"><a href="javascript:;">用户</a></li>
                <li data-src="${contextPath}/static/caiwu/index.html"><a href="javascript:;">财务</a></li>
            </ul>
            <div class="toolbar">
                <div class="login-info clearfix">
                    <div class="welcome clearfix"><span>欢迎您,</span><a href="javascript:;" class="user-name">${sessionScope.USER_NAME }</a>
	                <div class="tool clearfix">
	                    <a href="javascript:;" class="quit-btn exit">退出</a>
	                </div>
	                </div>
                </div>
            </div>          
        </div>
    </div>
</div>
</body>

</html>

