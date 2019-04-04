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
	<script src="static/js/md5.js" type="text/javascript"></script>
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
					<!-- 检索  -->
					<form action="account/${msg}.action" method="post" name="Form" id="Form">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">选择</th>
									<th class="center">序号</th>
									<th class="center">用户名</th>
									<th class="center">角色</th>
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
															<c:if test="${var.role == 0 }">
																<input type='checkbox' name='ids' value="${var.loginId}" />
																<span class="lbl"></span>
															</c:if>
														</label>
													</td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center' style="width: 160px;">${var.loginName}</td>
												<td class='center' style="width: 150px;">
													<c:if test="${var.role == 1 }">
														超级管理员													
													</c:if>
													<c:if test="${var.role == 0 }">
														管理员													
													</c:if>
												</td>
												<td class='center' style="width: 150px;">
													<c:if test="${var.role == 0}">
														<a href="javascript:;" onclick="edit(${var.loginId })">重置密码</a> 
													</c:if>
													<c:if test="${var.loginId == sessionScope.USER_ID}">
														<a href="javascript:;" onclick="edit('${var.loginId }', '${var.password }')">修改</a> 
													</c:if>
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
		
		function isEmpty(value)
		{
			if(value == null || value == '')
			{
				return true;
			}
			return false;
		}
		
		function save()
		{
			layer.open({
                type:2,
                area: ['500px', '350px'],
                resize:false,
                content:'${contextPath }/account/goSave.action',
                btn:['保存','返回'],
                yes:function (index,layero) {
                	var body = layer.getChildFrame('body', index);
                	var password = body.find("input[name='password']").val();
                	var password1 = body.find("#password1").val();
                	var loginName = body.find("#loginName").val();
                	
                	if(!isEmpty(loginName))
                	{
                		$.post("${contextPath}/account/checkUser.action", {loginName: loginName}, function(data){
                			// console.log(data);
                			if(data != 'SUCCESS')
                			{
                				parent.layer.msg('用户名已存在');
                			}
                			else if(isEmpty(loginName))
                        	{
                        		parent.layer.msg('用户名不可为空');
                        	}
             	            else if(isEmpty(password))
                        	{
                        		parent.layer.msg('密码不可为空');
                        	}
                        	else if(isEmpty(password1))
                        	{
                        		parent.layer.msg('请再次输入密码');
                        	}
                        	else if(password != password1)
                        	{
                        		parent.layer.msg('请确保密码一致');
                        	}
                        	else
                        	{
        	                	body.find('#infoForm').submit();
        	                	parent.layer.alert("新增成功", {icon: 1});
        	                	window.location.href = "${contextPath }/account/list.action";
                       		    /* layer.tips('请确保密码一致', body.find("input[name='password1']"), {
                       		        tips: [1, '#3595CC'],
                       		        time: 4000
                       		    }); */
                        	}
                			
                		}, "text");
                	}
                	
                		//layer.close(index);
                },
                btn2:function () {
                }
            })
		}
		
		function edit(id, oldPassword)
		{
			layer.open({
                type:2,
                area: ['500px', '350px'],
                resize:false,
                content:'${contextPath }/account/goEdit.action?loginId=' + id,
                btn:['保存','返回'],
                yes:function (index,layero) {
                	var body = layer.getChildFrame('body', index);
                	var newPassword = body.find("input[name='newPassword']").val();
                	var password = body.find("input[name='password']").val();
                	var password1 = body.find("#password1").val();
                	var loginName = body.find("#loginName").val();
                	newPassword = hex_md5(newPassword).toUpperCase();
                	// console.log(newPassword);
                	// console.log(oldPassword);
                	
                	if(isEmpty(loginName))
                	{
                		parent.layer.msg('用户名不可为空');
                	}
                	else if(isEmpty(newPassword))
                	{
                		parent.layer.msg('请输入原密码');
                	}
                	else if(newPassword != oldPassword)
                	{
                		parent.layer.msg('原密码输入不不正确');
                	}

                	else if(isEmpty(password))
                	{
                		parent.layer.msg('请输入新密码');
                	}
                	else if(isEmpty(password1))
                	{
                		parent.layer.msg('请再次输入密码');
                	}
                	else if(password != password1)
                	{
                		parent.layer.msg('请确保密码一致');
                	}
                	else
                	{
	                	body.find('#infoForm').submit();
	                	parent.layer.alert("修改成功", {icon: 1});
	                	window.location.href = "${contextPath }/account/list.action";
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
	                $.post("${contextPath}/account/removeAll.action", {ids: str}, function (data) {  
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
	                    		window.location.href = "${contextPath }/account/list.action";
	                        });  
	                }, "text");  
				}
            }); 
		}
	</script>
</body>
</html>