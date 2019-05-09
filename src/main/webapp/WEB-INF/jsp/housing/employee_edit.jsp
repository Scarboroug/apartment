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
                        <form id="infoForm" method="post" action="${msg }.do">
                            <div class="kv-item clearfix">
                                <label>姓名：</label>
                                <div class="kv-item-content">
                                	<input type="text" name="name" value="${pd.name }">
                                	<input type="hidden" name="empId" value="${pd.empId }">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label>性别：</label>
                                <div class="kv-item-content" id="sex">
                                    <span class="choose">
                                        <input type="radio" name="gender" value="1" ${pd.gender == 1 ? 'checked' : ''} disabled/>
                                        <span class="text">男</span>
                                    </span>
                                    <span class="choose">
                                        <input type="radio" name="gender" value="2" ${pd.gender == 2 ? 'checked' : ''} disabled/>
                                        <span class="text">女</span>
                                    </span>
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label>房间号：</label>
                                <div class="kv-item-content">
                                	<input type="text" readonly="readonly" name="roomNumber" value="${pd.roomNumber }">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label>手机号：</label>
                                <div class="kv-item-content">
                                    <input type="text" name="phone" value="${pd.phone }">
                                </div>
                            </div>
                            <div class="kv-item address clearfix">
                                <label>详细地址：</label>
                                <div class="kv-item-content">
                                    <input type="text" name="detailed" value="${pd.detailed }">
                                </div>
                            </div>

                            <div class="kv-item clearfix">
                                <label>入住日期：</label>
                                <div class="kv-item-content">
                                    <input type="text" name="enterTime" value="${pd.enterTime }" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"  />
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