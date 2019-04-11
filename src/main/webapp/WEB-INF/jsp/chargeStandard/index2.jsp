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
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
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
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
				<!-- <div class="saper-container saper-bd clearfix">
	                <h2>我的资料</h2>
	            </div> -->
					<!-- 检索  -->
					<form action="chargeStandard/${msg}.do" method="post" name="Form" id="Form">
						<table>
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
									<th class="center">标准名称</th>
									<th class="center">标准价格</th>
									<th class="center">单位</th>
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
														<input type='checkbox' name='ids' value="${var.csId}" />
														<span class="lbl"></span>
													</label>
												</td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center' style="width: 160px;">${var.name}</td>
												<td class='center' style="width: 160px;">${var.price}</td>
												<td class='center' style="width: 150px;">${var.unit}</td>
												<td style="width:200px;" class="center">
													<a href="javascript:;" onclick="edit(${var.roomTypeId});">修改</a> 
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
	<!--/.fluid-container#main-container-->
	<!-- 返回顶部  -->
	<script type="text/javascript">
		function edit(id){
			top.layer.open({
                type:2,
                area: ['500px', '300px'],
                resize:false,
                content:'${contextPath }/chargeStandard/goEdit.do?csId=' + id,
                btn:['保存','返回'],
                yes:function (index,layero) {
                	var body = layer.getChildFrame('body', index);
                	body.find('#infoForm').submit();
                	layer.close(index);
                	window.location.href = "${contextPath }/chargeStandard/list.do";
                },
                btn2:function () {
                }
            })
		} 
	</script>
</body>
</html>