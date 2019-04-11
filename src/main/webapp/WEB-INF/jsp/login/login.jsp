<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
<!-- 导入layer插件样式 -->
<link type="text/css" rel="stylesheet" href="${contextPath }/js/layer/mobile/need/layer.css"/>
<script type="text/javascript" src="${contextPath }/js/layer/layer.js" ></script>	
<link rel="stylesheet" href="${contextPath }/static/css/login.css" />

<title>公寓管理系统</title>
</head>
<div id="container">
	<div id="bd">
		<div class="login">
			<form id="loginForm">
				<div class="login-top">
					<h1 class="logo"></h1>
				</div>
				<div class="login-input">
					<p class="user ue-clear">
						<label>用户名</label> <input type="text" id="userName"
							name="userName" />
					</p>
					<p class="password ue-clear">
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;码</label> <input type="password"
							name="password" id="password" />
					</p>
				</div>
				<div class="login-btn ue-clear">
					<a onclick="login();" class="btn">登录</a>
					<%--<div class="remember ue-clear">--%>
						<%--<input type="checkbox" name="remember" /> <em></em> <label--%>
							<%--for="remember">记住密码</label>--%>
					<%--</div>--%>
				</div>
			</form>
		</div>
	</div>
</div>
</body>

<script type="text/javascript">
	var height = $(window).height();
	$("#container").height(height);
	$("#bd").css("padding-top",height/2 - $("#bd").height()/2);
	
	$(window).resize(function(){
		var height = $(window).height();
		$("#bd").css("padding-top",$(window).height()/2 - $("#bd").height()/2);
		$("#container").height(height);
		
	});
	
	$('#remember').focus(function(){
	   $(this).blur();
	});
	
	$('#remember').click(function(e) {
		checkRemember($(this));
	});
		
	$("body").bind('keyup',function(event) { 
		if(event.keyCode==13){ //keyCode=13是回车键
			login();
		}   
	});
	
	function checkRemember($this){
		if(!-[1,]){//IE 下返回true，其他标准浏览器返回false
			 if($this.prop("checked")){
				$this.parent().addClass('checked');
			}else{
				$this.parent().removeClass('checked');
			}
		}
	}
	
	function login()
	{
		var userName = $("#userName").val();
		var password = $("#password").val();
		if(userName == null || userName == '')
		{
			parent.layer.alert("用户名不可为空", {icon: 7});
			return;
		}
		
		if(password == null || password == '')
		{
			parent.layer.alert("密码不可为空", {icon: 7});
			return;
		}
		
		var url = '<%=request.getContextPath()%>/login/doLogin.do';
		var reqData = $("#loginForm").serialize();
		$.ajax({
			type: "POST",
			async: true,  //默认true,异步
			data: reqData,
			dataType: 'text',
			url: url,
			success:function(data){
				
				if(data == 'SUCCESS')
				{
					window.location.href = "${contextPath}/login/toIndex.do";
				}
				else
				{
					layer.alert("用户名或密码错误", {icon: 2});
				}
				
		    }
		});
	}

</script>
</html>