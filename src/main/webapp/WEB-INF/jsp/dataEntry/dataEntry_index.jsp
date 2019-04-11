<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${pd.SYSNAME}</title>
	<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
	<!-- basic styles -->
	<link href="${contextPath }/static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${contextPath }/static/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${contextPath }/static/css/font-awesome.min.css" />
	<!-- page specific plugin styles -->
	<!-- 下拉框-->
<%-- 	<link rel="stylesheet" href="${contextPath }/static/css/chosen.css" /> --%>
	<!-- ace styles -->
	<link rel="stylesheet" href="${contextPath }/static/css/ace.min.css" />
	<link rel="stylesheet" href="${contextPath }/static/css/ace-responsive.min.css" />
	<link rel="stylesheet" href="${contextPath }/static/css/ace-skins.min.css" />
	<%-- <script type="text/javascript" src="${contextPath }/static/js/jquery-1.7.2.js"></script> --%>
	<link rel="stylesheet" href="${contextPath }/static/css/datepicker.css" /><!-- 日期框 -->
	<!-- 导入layer插件样式 -->
	<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
	<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>	
	<!-- 导入日期插件 -->
	<script type="text/javascript" src="${contextPath }/plugin/My97DatePicker/WdatePicker.js"></script>  
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="${msg}.do" method="post" name="Form" id="Form">
						<table>
							<tr>
								<td>
									<span class="input-icon"> 
									<input type="text" name="time" id="time" value="${pd.time}" placeholder="请输入时间"  class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM',readOnly:true})" style="width:154px;" />
									</span>
									<span class="input-icon"> 
										<input autocomplete="off" id="nav-search-input" type="text" name="roomNumber" value="${pd.roomNumber}" placeholder="请输入房间号" /> 
										<i id="nav-search-icon" class="icon-search"></i>
									</span>
								</td>
								<td style="vertical-align:top;">
									<button class="btn btn-mini btn-light" onclick="search();" value="检索" title="检索">
										<i id="nav-search-icon" class="icon-search"></i>
									</button>
								</td>
							</tr>
						</table>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">
										<label>
											<input type="checkbox" id="zcheckbox" />
											<span class="lbl"></span>
										</label>
									</th>
									<th class="center">序号</th>
									<th class="center">房间号</th>
									<th class="center">房间类型</th>
									<th class="center">人员人数</th>
									<th class="center">人员性别</th>
									<th class="center">用水量</th>
									<th class="center">用电量</th>
									<th class="center">操作</th>
								</tr>
							</thead>
							<tbody>
								<!-- 开始循环 -->
								<c:choose>
									<c:when test="${not empty varList}">
										<c:forEach items="${varList}" var="var" varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;">
													<label>
														<input type='checkbox' name='ids' value="${var.roomId}" />
														<span class="lbl"></span>
													</label>
												</td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center' style="width: 60px;">${var.roomNumber}</td>
												<td class='center' style="width: 150px;">${var.roomType}</td>
												<td class='center' style="width: 150px;">${var.total}</td>
												<td class='center' style="width: 150px;">
													<c:if test="${var.gender == 1 }">
														男													
													</c:if>
													<c:if test="${var.gender == 2 }">
														女													
													</c:if>
												</td>
												<td class='center' style="width: 150px;">
													<div class="kv-item-content">
				                                    	<input type="text" placeholder="请输入用水量" name="water" id="water${var.roomId}" onkeyup="check(this)">
				                                    </div>
												</td>
												<td class='center' style="width: 150px;">
													<div class="kv-item-content">
			                                    		<input type="text" placeholder="请输入用电量" name="electric" id="electric${var.roomId}" onkeyup="check(this)">
			                                    	</div>
												</td>
												<td style="width:200px;" class="center">
													<a href="javascript:;" onclick="save(${var.roomId});">录入</a> 
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr class="main_info">
											<td colspan="100" class="center">没有相关数据</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<div class="page-header position-relative">
							<table style="width:100%;">
								<tr>
									<td style="vertical-align:top;">
										<div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
				<!-- PAGE CONTENT ENDS HERE -->
			</div>
		</div>
		<!--/#page-content-->
	</div>

	<!--提示框-->
	<script type="text/javascript">
	
		function check(obj)
		{
			obj.value = obj.value.replace(/[^\d.]/g,"");//清除"数字"和"."以外的字符
			obj.value = obj.value.replace(/^\./g,"");//验证第一个字符是数字而不是
			obj.value = obj.value.replace(/\.{2,}/g,".");//只保留第一个. 清除多余的
			obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
			obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
		}
	
		//检索
		function search(){
			$("#Form").submit();
		}
		function save(roomId)
		{
			var url = "${contextPath}/dataEntry/save.do";
			//var reqData = ("#Form").serialize();
			var water = $("#water" + roomId).val();
			var electric = $("#electric" + roomId).val();
			var time = $("#time").val();
			var roomNumber = $("#roomNumber").val();
			var reqData = 'roomId=' + roomId + '&water=' + water + "&electric=" + electric + "&time=" + time + "&roomNumber=" + roomNumber;
			$.post(url, reqData, function(data){
				
				if(data = 'SUCCESS')
				{
					parent.layer.alert("录入成功", {icon: 1});
					window.location.href = "${contextPath }/dataEntry/list.do?time=" + time;
				}
				else
				{
					parent.layer.alert("录入失败", {icon: 1});
				}
			}, "text");
		}
	</script>
</body>
</html>