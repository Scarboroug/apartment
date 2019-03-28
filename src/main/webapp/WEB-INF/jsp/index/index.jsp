<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
<link rel="stylesheet" href="${contextPath }/common/css/sapar.css" />
<link rel="stylesheet" href="${contextPath }/static/css/index.css" />
<!-- 导入layer插件样式 -->
<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>
<title>公寓管理系统</title>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap clearfix">
        	<div class="top-light"></div>
            <h1 class="logo"></h1>
            <ul class="main-nav clearfix">
                <li class="current"><a href="${contextPath }/employee/toMenuIndex.action" target="iframe">住宿办理</a></li>
                <li><a href="${contextPath }/payment/toMenuIndex.action" target="iframe">缴费管理</a></li>
                <li><a href="${contextPath }/dataEntry/toMenuIndex.action" target="iframe">数据录入</a></li>
                <li><a href="${contextPath }/room/toMenuIndex.action" target="iframe">房间管理</a></li>
                <c:if test="${sessionScope.SESSION_USER_ROLE == 1 }">
	                <li><a href="${contextPath }/account/toMenuIndex.action" target="iframe">账户管理</a></li>
                </c:if>
                <c:if test="${sessionScope.SESSION_USER_ROLE == 1 }">
	                <li><a href="${contextPath }/chargeStandard/toMenuIndex.action" target="iframe">收费标准管理</a></li>
                </c:if>
            </ul>
            <div class="toolbar">
                <div class="login-info tool clearfix">
                    <div class="welcome clearfix"><span>欢迎您&nbsp;</span><span class="user-name">${sessionScope.USER_NAME }</span></div>
                   	<a href="${contextPath }/employee/toMenuIndex.action" target="iframe" class="quit-btn exit">首页</a>
                   	<a href="logout.action?userId=${sessionScope.USER_ID }" class="quit-btn exit">退出</a>
            	</div>          
        	</div>
    	</div>
    </div>
    <div id="bd">
     		<iframe src="${contextPath }/employee/toMenuIndex.action" name="iframe" width="100%" height="100%" frameborder="0"></iframe>
 	</div>
</div>

</body>
</html>

