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
	<!-- basic styles -->
	<link href="${contextPath }/static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${contextPath }/static/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${contextPath }/static/css/font-awesome.min.css" />
	
	<!-- 导入layer插件样式 -->
	<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
	<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>
	<!-- 下拉框-->
	<link rel="stylesheet" href="${contextPath }/static/css/chosen.css" />
	<!-- ace styles -->
	<link rel="stylesheet" href="${contextPath }/static/css/ace.min.css" />
	<link rel="stylesheet" href="${contextPath }/static/css/ace-responsive.min.css" />
	<link rel="stylesheet" href="${contextPath }/static/css/ace-skins.min.css" />
	<link rel="stylesheet" href="${contextPath }/static/css/datepicker.css" /><!-- 日期框 -->
		
	<!-- 导入日期插件 -->
	<script type="text/javascript" src="${contextPath }/plugin/My97DatePicker/WdatePicker.js"></script>  
	<style>
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
					<form action="employee/${msg}.do" method="post" name="Form" id="Form">
						<table>
							<tr>
								<td>
									<span class="input-icon"> 
										<input autocomplete="off" id="nav-search-input" type="text" name="name" value="${pd.name}" placeholder="请输入姓名" /> 
										<i id="nav-search-icon" class="icon-search"></i>
									</span>
								</td>
								<td>
									<%-- <input class="span10 date-picker" name="STARTTIME" id="STARTTIME" value="${pd.STARTTIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:88px;" placeholder="开始日期" /> --%>
									<input type="text" name="startTime" id="startTime" value="${pd.startTime}" placeholder="开始日期"  class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" style="width:172px;" />
								</td>
								<td>
									<%-- <input class="span10 date-picker" name="ENDTIME" id="ENDTIME" value="${pd.ENDTIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:88px;" placeholder="结束日期" /> --%>
									<input type="text" name="endTime" id="endTime" value="${pd.endTime}" placeholder="结束日期"  class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" style="width:172px;" />
								</td>
								<td style="vertical-align:top;">
									<button class="btn btn-mini btn-light" onclick="search();" value="检索" title="检索">
										<i id="nav-search-icon" class="icon-search"></i>
									</button>
								</td>
								<%-- <td>
									<a href="<%=basePath%>static/html/outtray_view.html" target="_blank">查看</a> 
								</td> --%>
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
									<th class="center">身份证号</th>
									<th class="center">房间号</th>
									<th class="center">性别</th>
									<th class="center">手机号</th>
									<th class="center">入住时间</th>
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
												<td class='center' style="width: 160px;">${var.idNumber}</td>
												<td class='center' style="width: 80px;">${var.roomNumber}</td>
												<td class='center' style="width: 80px;">
													<c:if test="${var.gender == 1 }">
														男													
													</c:if>
													<c:if test="${var.gender == 2 }">
														女													
													</c:if>
												</td>
												<td class='center' style="width: 150px;">${var.phone}</td>
												<td class='center' style="width: 150px;">${var.enterTime}</td>
												<td style="width:120px;" class="center">
													<a href="javascript:;" onclick="edit(${var.empId});">修改</a> 
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
		//检索
		function search(){
			$("#Form").submit();
		}
		
		function edit(id)
		{
			layer.open({
                type:2,
                area: ['500px', '450px'],
                resize:false,
                content:'${contextPath }/employee/goEmployeeEdit.do?empId=' + id,
                btn:['保存','返回'],
                yes:function (index,layero) {
                	var body = layer.getChildFrame('body', index);
                	body.find('#infoForm').submit();
                	layer.close(index);
                	window.location.href = "${contextPath }/employee/empList.do";
                },
                btn2:function () {
                }
            })
		}
		
	</script>
</body>
</html>

