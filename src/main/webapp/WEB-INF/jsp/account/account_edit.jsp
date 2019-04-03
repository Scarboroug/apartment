<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
<link rel="stylesheet" href="${contextPath }/common/css/sapar.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/common.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/static/css/my_info.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/plugin/address/style/common.css">
<link rel="stylesheet" type="text/css" href="${contextPath }/plugin/address/style/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="${contextPath }/plugin/My97DatePicker/skin/WdatePicker.css">
<script type="text/javascript" src="${contextPath }/plugin/My97DatePicker/WdatePicker.js"></script>  
<style type="text/css">
	.citys{
		margin-bottom: 10px;
	}
	.citys p{
		line-height: 28px;
	}
	.warning{
		color: #c00;
	}
	.main a{
		margin-right: 8px;
		color: #369;
	}
</style>
<title>我的资料信息</title>
</head>

<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled-content">
                <div class="tab-content">
                    <div class="tab-content-item">
                        <form id="infoForm" method="post" action="${msg }.action">
                            <div class="kv-item clearfix">
                                <label>用户名：</label>
                                <div class="kv-item-content">
		                            <c:if test="${pd.loginId == sessionScope.USER_ID}">
    	                            	<input type="text" name="loginName" value="${pd.loginName }" id="loginName">
	                                </c:if>
	                                <c:if test="${pd.role == 0}">
	                                	<input type="text" name="loginName" value="${pd.loginName }" id="loginName" readonly="readonly">
	                                </c:if>
                                	<input type="hidden" name="loginId" value="${pd.loginId }">
                                </div>
                            </div>
                            <c:if test="${pd.loginId == sessionScope.USER_ID}">
	                            <div class="kv-item clearfix">
	                                <label>原密码：</label>
	                                <div class="kv-item-content">
	                                	<input type="password" name="newPassword" id="newPassword">
	                                </div>
	                            </div>
	                        </c:if>
                            <div class="kv-item clearfix">
                                <label>新密码：</label>
                                <div class="kv-item-content">
                                    <input type="password" name="password" id="password">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label>再次输入：</label>
                                <div class="kv-item-content">
                                    <input type="password" name="password1" id="password1">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
           </div>
    </div>
    <div id="saper-ft"></div>
</body>
<script type="text/javascript">
</script>
</html>