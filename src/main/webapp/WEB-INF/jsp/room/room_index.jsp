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
	<!-- 导入layer插件样式 -->

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
	<!-- 导入layer插件样式 -->
	<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
	<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>
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
					<form action="room/${msg}.do" method="post" name="Form" id="Form">
						<table>
							<tr>
								<td>
									<span class="input-icon"> 
										<input autocomplete="off" id="nav-search-input" type="text" name="roomNumber" value="${pd.roomNumber}" placeholder="请输入房间号" /> 
										<i id="nav-search-icon" class="icon-search"></i>
									</span>
									<span class="input-icon"> 
										<input autocomplete="off" id="nav-search-input" type="text" name="total" value="${pd.total}" placeholder="请输入人数" /> 
										<i id="nav-search-icon" class="icon-search"></i>
									</span>
									<span class="input-icon"> 
										<select name="roomTypeId" id="roomTypeId">
											<option value="6" ${pd.roomTypeId == 6 ? 'selected' : '6' }>请选择房间类型</option>
	                                        <option value="5" ${pd.roomTypeId == 5 ? 'selected' : '6' }>单人间</option>
	                                        <option value="2" ${pd.roomTypeId == 2 ? 'selected' : '6' }>双人间</option>
	                                        <option value="1" ${pd.roomTypeId == 1 ? 'selected' : '6' }>四人间</option>
	                                        <option value="3" ${pd.roomTypeId == 3 ? 'selected' : '6' }>六人间</option>
	                                        <option value="4" ${pd.roomTypeId == 4 ? 'selected' : '6' }>八人间</option>
	                                    </select> 
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
									<th class="center">性别</th>
									<th class="center">入住人数</th>
									<th class="center">房间类型</th>
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
														<c:if test="${var.total == 0}">
															<input type='checkbox' name='ids' value="${var.roomId}" />
														</c:if>
														<span class="lbl"></span>
													</label>
												</td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center' style="width: 160px;">${var.roomNumber}</td>
												<td class='center' style="width: 150px;">
													<c:if test="${var.gender == 1 }">
														男													
													</c:if>
													<c:if test="${var.gender == 2 }">
														女													
													</c:if>
													<c:if test="${var.gender == 3 }">
														未定													
													</c:if>
												</td>
												<td class='center' style="width: 150px;">${var.total}</td>
												<td class='center' style="width: 150px;">${var.roomType}</td>
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
										<c:if test="${sessionScope.SESSION_USER_ROLE == 1 }">
											<a class="btn btn-small btn-success" onclick="save();">新增</a>
											<a title="批量删除" class="btn btn-small btn-danger" onclick="removeAll('确定要删除选中的数据吗?');" ><i class='icon-trash'></i></a>
										</c:if>
									</td>
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
	<script type="text/javascript">
		//检索
		function search(){
			$("#Form").submit();
		}
		
		function save(id)
		{
			layer.open({
                type:2,
                area: ['500px', '300px'],
                resize:false,
                content:'${contextPath }/room/goSave.do',
                btn:['保存','返回'],
                yes:function (index,layero) {
                	var body = layer.getChildFrame('body', index);
					var roomId = body.find('#roomTypeId').val()
					var roomNumber = body.find("input[name='roomNumber']").val();
					//console.log(roomId)
					//console.log(roomNumber)
					if(!checkRoomId(roomId))
					{
						parent.layer.msg("请选择房间类型");
					}
					else if(!checkRoomNumber(roomNumber))
					{
						parent.layer.msg("请输入房间号");
					}
					else
					{
						body.find('#infoForm').submit();
						parent.layer.alert("新增成功", {icon: 1});
						layer.close(index);
						window.location.href = "${contextPath }/room/list.do";
					}
                },
                btn2:function () {
                }
            })
		}
		//批量操作
		function removeAll(msg){
			layer.confirm(msg, { title: "删除确认" }, function (index) {
				var str = '';
				for(var i=0;i < document.getElementsByName('ids').length;i++)
				{
					if(document.getElementsByName('ids')[i].checked){
						if(str=='') str += document.getElementsByName('ids')[i].value;
						else str += ',' + document.getElementsByName('ids')[i].value;
					}
				}
				if(str == '')
				{
					layer.alert("您没有选择任何内容", {icon: 2});
				}
				else
				{
					$.post("${contextPath}/room/removeAll.do", {ids: str}, function (data) {
						if(data == 'SUCCESS')
						{
							data = '删除成功';
						}
						else
						{
							data = '删除失败';
						}
						layer.alert(data, {
									title: "删除操作",
									btn: ['确定']
								},
								function (index, item) {
									layer.close(index);
									// location.reload();
									window.location.href = "${contextPath }/room/list.do";
								});
					}, "text");
				}
			});
		}
		function checkRoomId(roomId)
		{
			if(roomId != '6')
			{
				return true;
			}
			return false;
		}

		function checkRoomNumber(checkroomNumber)
		{
			if(checkroomNumber != '')
			{
				return true;
			}
			return false;
		}
	</script>
</body>
</html>