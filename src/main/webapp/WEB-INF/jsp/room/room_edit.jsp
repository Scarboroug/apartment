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
                                <label>房间类型：</label>
                                <div class="kv-item-content">
                                	<select name="roomTypeId" id="roomTypeId">
	                                        <option value="6" ${pd.roomTypeId == 6 ? 'selected' : '6' }>请选择房间类型</option>
	                                        <option value="5" ${pd.roomTypeId == 5 ? 'selected' : '6' }>单人间</option>
	                                        <option value="2" ${pd.roomTypeId == 2 ? 'selected' : '6' }>双人间</option>
	                                        <option value="1" ${pd.roomTypeId == 1 ? 'selected' : '6' }>四人间</option>
	                                        <option value="3" ${pd.roomTypeId == 3 ? 'selected' : '6' }>六人间</option>
	                                        <option value="4" ${pd.roomTypeId == 4 ? 'selected' : '6' }>八人间</option>
	                                    </select> 
                                	<input type="hidden" name="roomId" value="${pd.roomId }">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label>房间号：</label>
                                <div class="kv-item-content">
                                    <input type="text" name="roomNumber" value="${pd.roomNumber }">
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