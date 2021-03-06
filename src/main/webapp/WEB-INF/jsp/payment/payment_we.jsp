<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>${pd.SYSNAME}</title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
	<!-- 导入layer插件样式 -->
	<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
	<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>
	<%--<link type="text/css" rel="stylesheet" href="${contextPath }/layui/css/layui.css"/>--%>
	<%--<script type="text/javascript" src="${contextPath }/layui/layui.js" ></script>--%>
	<!-- basic styles -->
	<link href="static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="static/css/font-awesome.min.css" />
	<!-- page specific plugin styles -->
	<!-- 下拉框-->
	<link rel="stylesheet" href="static/css/chosen.css" />
	<!-- ace styles -->
	<link rel="stylesheet" href="static/css/ace.min.css" />
	<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
	<link rel="stylesheet" href="static/css/ace-skins.min.css" />
<%-- 	<script type="text/javascript" src="${contextPath }/static/js/jquery-1.7.2.js"></script> --%>
	<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
	<!-- 导入日期插件 -->
	<script type="text/javascript" src="${contextPath }/plugin/My97DatePicker/WdatePicker.js"></script>  
	<style type="text/css">
		.subfile{
			position: relative;
		    line-height: 33px;
		    background: url('../webapp/common/images/righttitlebig.png') repeat-x scroll 0% 0% transparent;
		    border: 1px solid #C1D3DE;
		    overflow: visible;
		}
		.subfile span {
		    float: left;
		    margin-left: 7px;
		    padding-left: 22px;
		    font-weight: bold;
		    font-size: 14px;
		    color: #000;
		    background: url('../webapp/common/images/titleico.png') no-repeat scroll left center transparent;
		}
	</style>
</head>
<body>
	<!-- <div class="subfile clearfix">
        <span>我的资料</span>
    </div> -->
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="payment/${msg}.do" method="post" name="Form" id="Form">
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
									<th class="center">姓名</th>
									<th class="center">房间号</th>
									<th class="center">需交费用</th>
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
														<input type='checkbox' name='ids' value="${var.empId}" />
														<span class="lbl"></span>
													</label>
												</td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center' style="width: 60px;">${var.name}</td>
												<td class='center' style="width: 150px;">${var.roomNumber}</td>
												<td class='center' style="width: 150px;">${var.price}</td>
												<td class='center' style="width: 150px;">${var.water}</td>
												<td class='center' style="width: 150px;">${var.electric}</td>
												<td class='center' style="width: 150px;">
													<a href="javascript:;" onclick="payment('${var.empId}', '${var.price }');">缴费</a> 
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
										<div class="pagination" style="float: right; padding-top: 0px; margin-top: 0px;">${page.pageStr}</div>
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
	<!--/.fluid-container#main-container-->
	<script type="text/javascript">
	
		//检索
		function search(){
			$("#Form").submit();
		}
		function payment(empId, price)
		{
			var url = "${contextPath}/payment/payWE.do";
			//var reqData = ("#Form").serialize();
			var time = $("#time").val();
			var roomNumber = $("#roomNumber").val();
			var reqData = 'empId=' + empId + '&price=' + price;
			layer.open({
			content: '是否缴费？'
			,btn: ['确定', '返回']
			,yes: function(index, layero){
				$.post(url, reqData, function(data){
					if(data = 'SUCCESS')
					{
						layer.alert("支付成功！", {icon: 1,closeBtn: 0}, function () {
							$("#Form").submit();
						});
						<%--layer.alert("支付成功", {icon: 1});--%>
						<%--window.location.href = "${contextPath }/payment/paymentWE.do";--%>
						<%--$("#Form").submit();--%>
					}
					else
					{
						layer.alert("支付失败，请重新尝试！！", {icon: 2,closeBtn: 0}, function () {
							$("#Form").submit();
						});
					}
				}, "text");
			}
			,btn2: function(index, layero){
				layer.close(index);
			}
			,cancel: function(){

			}
		});

		}
	</script>
</body>
</html>