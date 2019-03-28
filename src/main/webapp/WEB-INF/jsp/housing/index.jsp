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
<link rel="stylesheet" type="text/css" href="${contextPath }/static/system/css/my_info.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/plugin/address/style/common.css">
<link rel="stylesheet" type="text/css" href="${contextPath }/plugin/address/style/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="${contextPath }/plugin/My97DatePicker/skin/WdatePicker.css">
<script type="text/javascript" src="${contextPath }/plugin/My97DatePicker/WdatePicker.js"></script>  
<!-- 导入layer插件样式 -->
<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>
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
            <div class="subfiled clearfix">
                <h2>员工资料</h2>
            </div>
            <div class="subfiled-content">
                <div class="tab-content">
                    <div class="tab-content-item">
                        <form id="infoForm" method="post">
                            <div class="kv-item clearfix">
                                <label><span class="impInfo">*</span>姓名：</label>
                                <div class="kv-item-content">
                                	<input type="text" placeholder="请输入姓名" name="name" id="name" onblur="checkName();">
                                </div>
                                <div style="float:left; color:#C0BFBF; padding-top:5px; font-size:14px; margin-left:10px; width:200px; height:22px;" id="checkName">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label><span class="impInfo">*</span>身份证：</label>
                                <div class="kv-item-content">
                                	<input type="text" placeholder="请输入身份证号" name="idNumber" id="idNumber" onblur="checkID()">
                                </div>
                                <div style="float:left; color:#C0BFBF; padding-top:5px; font-size:14px; margin-left:10px; width:200px; height:22px;" id="checkID">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label><span class="impInfo">*</span>性别：</label>
                                <div class="kv-item-content" id="sex">
                                    <span class="choose">
                                        <input type="radio" name="gender" value="1" checked="checked" id="gender" onchange="findRoom();">
                                        <span class="text">男</span>
                                    </span>
                                    <span class="choose">
                                        <input type="radio" name="gender" value="2" onchange="findRoom();">
                                        <span class="text">女</span>
                                    </span>
                                </div>
                            </div>
                            <div class="kv-item address clearfix">
                                <label><span class="impInfo">*</span>房间：</label>
                                <div class="kv-item-content">
                                    <select name="roomTypeId" id="roomTypeId" onchange="findRoom();" onblur="checkFindRoom()" >
                                        <option value="6" selected="selected">请选择房间类型</option>
                                        <option value="5" >单人间</option>
                                        <option value="2" >双人间</option>
                                        <option value="1" >四人间</option>
                                        <option value="3" >六人间</option>
                                        <option value="4" >八人间</option>
                                    </select>
                                    <select name="roomId" id="roomId" onblur="checkFindRoom()">
                                        <option value="0" selected="selected">请选择房间号</option>
                                    </select>
                                </div>
                                <div style="float:left; color:#C0BFBF; padding-top:5px; font-size:14px; margin-left:10px; width:10px; height:22px;" id="checkFindRoom">
                                </div>
                            </div>
                            <div class="kv-item clearfix">
                                <label><span class="impInfo">*</span>手机号：</label>
                                <div class="kv-item-content">
                                    <input type="text" placeholder="请输入手机号" name="phone" id="phone" onblur="checkPhone();">
                                </div>
                                <div style="float:left; color:#C0BFBF; padding-top:5px; font-size:14px; margin-left:10px; width:200px; height:22px;" id="checkPhone">
                                </div>
                            </div>
                            <div class="kv-item address clearfix">
                                <label><span class="impInfo">*</span>户籍地址：</label>
                                <div class="kv-item-content">
                                    <input type="text" placeholder="请输入户籍地址" name="detailed" id="detailed" onblur="checkDetails()">
                                </div>
                                <div style="float:left; color:#C0BFBF; padding-top:5px; font-size:14px; margin-left:10px; width:200px; height:22px;" id="checkDetails">
                                </div>
                            </div>

                            <div class="kv-item clearfix">
                                <label><span class="impInfo">*</span>入住日期：</label>
                                <div class="kv-item-content">
                                    <input type="text" name="enterTime" id="enterTime" placeholder="请选择入住日期" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"  />
                                </div>
                                <div style="float:left; color:#C0BFBF; padding-top:5px; font-size:14px; margin-left:10px; width:200px; height:22px;" id="checkEnterTime">
                                </div>
                            </div>
                            <div class="buttons" style="margin-left: 115px;">
			                    <a href="javascript:;" onclick="add()" class="sapar-btn sapar-btn-recom">确定</a>
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
	function findRoom()
	{
		var roomTypeId = $("#roomTypeId").val();
		var url = "${contextPath}/employee/findRoom.action";	
		var reqData = "roomTypeId=" + roomTypeId + "&gender=" + $("#sex input[name='gender']:checked").val();
		if($(roomTypeId != null && roomTypeId != ''))
		{
			$.post(url, reqData, function(data){
				$("#roomId").empty();
				if(data != 'FALSE' && !jQuery.isEmptyObject(data))
				{
					$.each(data.varList,function(index,item){
						if(index == 0)
						{
							$("#roomId").append("<option selected='selected' value='" + item.roomId + "' >" + item.roomNumber + "  --  " + item.total + "</option>");
						}
						else
						{
							$("#roomId").append("<option value='" + item.roomId + "' >" + item.roomNumber + "  --  " + item.total + "</option>");
						}
					});
				}
				else
				{
					$("#roomId").append("<option value='0'>请先选择房间类型</option>");
				}
			}, "json");
		}
	}
	
	function checkName()
	{
		var name = $("#name").val();
		if(/^[\u2E80-\u9FFF]+$/.test(name)) 
		{
			$("#checkName").css("color", "green");
			$("#checkName").text("✔");
			return true;
		}
		else
		{
			$("#checkName").text("");
			layer.tips('请输入姓名', '#name', {
		        tips: [2, "#E45151"],
		        time: 2000
		    })
		}
		return false;	
	}
	
	function checkID()
	{
		var idNumber = $("#idNumber").val();
		if(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(idNumber)) 
		{
			$("#checkID").css("color", "green");
			$("#checkID").text("✔");
			return true;
		}
		else
		{
			$("#checkID").text("");
			layer.tips('请输入合法身份证号', '#idNumber', {
		        tips: [4, "#E45151"],
		        time: 2000
		    })
		}
		return false;	
	}
	
	function checkPhone()
	{
		var phone = $("#phone").val();
		if(/^1(3|4|5|7|8)\d{9}$/.test(phone))
		{
			$("#checkPhone").css("color", "green");
			$("#checkPhone").text("✔");
			return true;
		}
		else
		{
			$("#checkPhone").text("");
			layer.tips('请输入正确手机号', '#phone', {
		        tips: [4, "#E45151"],
		        time: 2000
		    })
		}
		return false;	
	}
	
	function checkDetails()
	{
		var detailed = $("#detailed").val();
		if(detailed != '')
		{
			$("#checkDetails").css("color", "green");
			$("#checkDetails").text("✔");
			return true;
		}
		else
		{
			$("#checkDetails").text("");
			layer.tips('请输入户籍地址', '#detailed', {
		        tips: [4, "#E45151"],
		        time: 2000
		    })
		}
		return false;	
	}
	
	/* function checkEnterTime()
	{
		var enterTime = $("#checkEnterTime").val();
		if(enterTime != '')
		{
			$("#checkEnterTime").css("color", "green");
			$("#checkEnterTime").text("✔");
			return true;
		}
		else
		{
		}
		return false;	
	} */
	
	function checkFindRoom()
	{
		var roomTypeId = $("#roomTypeId").val();
		var roomId = $("#roomId").val();
		console.log(roomTypeId);
		console.log(roomId);
		if(roomTypeId != 6 && roomId != 0)
		{
			$("#checkFindRoom").css("color", "green");
			$("#checkFindRoom").text("✔");
			return true;
		}
		else
		{
			$("#checkFindRoom").text("");
			layer.tips('请选择房间', '#roomId', {
		        tips: [2, "#E45151"],
		        time: 2000
		    })
		}
		return false;	
	}
	
	function add()
	{
		var roomTypeId = $("#roomTypeId").val();
		var roomId = $("#roomId").val();
		var enterTime = $("#enterTime").val();
		
		if(!checkName() || !checkID() || !checkPhone() || !checkDetails() || !checkFindRoom)
		{
			return;
		}
		else if(enterTime == '')
		{
			layer.tips('请选择入住日期', '#enterTime', {
		        tips: [4, "#E45151"],
		        time: 2000
		    })
		    return;
		}
		
		var url = "${contextPath}/employee/saveEmployee.action";
		var reqData = $("#infoForm").serialize();
		$.post(url, reqData, function(data){
			if("SUCCESS" == data)
			{
				top.layer.alert("添加成功", {icon: 1});
				window.location.href = "${contextPath}/employee/toIndex.action";			
			}
			else
			{
				top.layer.alert("添加失败", {icon: 2});
				window.location.href = "${contextPath}/employee/toIndex.action";
			}
		}, "text");
	}
</script>
</html>