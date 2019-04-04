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
		<title>首页</title>
		<base href="<%=basePath%>">
		<!-- jsp文件头和头部 -->
		<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
		<link href="static/css/default.css" rel="stylesheet" />
	</head>
<body>
	<div class="container-fluid" id="main-container">
		<!-- #main-content -->
		<div class="main-content" style="height: 500px">
			<div style="display: flex;justify-content: space-between;">
				<div style="margin-right: 20px;width:100%">
				<%--<p style="margin-left:250px;padding-top: 40px; font-size: 40px;">xx公寓欢迎您！</p>--%>
				</div>
				<div>
					<div class="time-block">
						<div class="box" id="clock">
							<!-- 原点 -->
							<div class="origin"></div>
							<!-- 时钟数 -->
							<div class="dot_box">
								<div class="dot">6</div>
								<div class="dot">5</div>
								<div class="dot">4</div>
								<div class="dot">3</div>
								<div class="dot">2</div>
								<div class="dot">1</div>
								<div class="dot">12</div>
								<div class="dot">11</div>
								<div class="dot">10</div>
								<div class="dot">9</div>
								<div class="dot">8</div>
								<div class="dot">7</div>
							</div>
							<!-- 时、分、秒针 -->
							<div class="clock_line hour_line" id="hour_line"></div>
							<div class="clock_line minute_line" id="minute_line"></div>
							<div class="clock_line second_line" id="second_line"></div>
							<!-- 日期 -->
							<div class="date_info" id="date_info"></div>
							<!-- 时间 -->
							<div class="time_info">
								<div class="time" id="hour_time"></div>
								<div class="time" id="minute_time"></div>
								<div class="time" id="second_time"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/.fluid-container#main-container-->
	<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only"></i>
	</a>
	<!-- basic scripts -->
	<script type="text/javascript" src="${contextPath }/static/js/jquery-3.3.1.min.js" ></script>
	<script src="static/js/jquery.SuperSlide.2.1.1.js"></script>
	<script type="text/javascript">
		window.jQuery || document.write("<script src='static/js/jquery-3.3.1.min.js'>\x3C/script>");
	</script>
	<script src="static/js/bootstrap.min.js"></script>
	<!-- page specific plugin scripts -->

	<!--[if lt IE 9]>
		<script type="text/javascript" src="static/js/excanvas.min.js"></script>
	<![endif]-->
	<!-- inline scripts related to this page -->
	<!-- 时钟 -->
	<script>
		$(function() {
			var clock = document.getElementById("clock");
			function initNumXY() {
				// 1、12个数字的位置设置
				var radius = 135;//大圆半价
				var dot_num = 360 / $(".dot").length;//每个div对应的弧度数
				//每一个dot对应的弧度;
				var ahd = dot_num * Math.PI / 180;
				$(".dot").each(function(index, el) {
					$(this).css({
						"left" : 130 + Math.sin((ahd * index)) * radius,
						"top" : 130 + Math.cos((ahd * index)) * radius
					});
				});
				// 2、刻钟设置
				for (var i = 0; i < 60; i++) {
					clock.innerHTML += "<div class='clock-scale'> "
							+ "<div class='scale-hidden'></div>"
							+ "<div class='scale-show'></div>" + "</div>";
				}
				var scale = document.getElementsByClassName("clock-scale");
				for (var i = 0; i < scale.length; i++) {
					scale[i].style.transform = "rotate(" + (i * 6 - 90)
							+ "deg)";
				}
			}
			initNumXY();//调用上面的函数
			//获取时钟id
			var hour_line = document.getElementById("hour_line"), minute_line = document
					.getElementById("minute_line"), second_line = document
					.getElementById("second_line"), date_info = document
					.getElementById("date_info"), //获取date_info
			hour_time = document.getElementById("hour_time"), // 获去时间id
			minute_time = document.getElementById("minute_time"), second_time = document
					.getElementById("second_time");
			//3、设置动态时间
			function setTime() {
				var nowdate = new Date();
				//获取年月日时分秒
				var year = nowdate.getFullYear(), month = nowdate.getMonth() + 1, day = nowdate
						.getDay(), hours = nowdate.getHours(), minutes = nowdate
						.getMinutes(), seconds = nowdate.getSeconds(), date = nowdate
						.getDate();
				var weekday = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
				// 获取日期id
				date_info.innerHTML = year + "年" + month + "月" + date + "日   "
						+ weekday[day];
				hour_time.innerHTML = hours >= 10 ? hours : "0" + hours;
				minute_time.innerHTML = minutes >= 10 ? minutes : "0" + minutes;
				second_time.innerHTML = seconds >= 10 ? seconds : "0" + seconds;
				//时分秒针设置
				var hour_rotate = (hours * 30 - 90)
						+ (Math.floor(minutes / 12) * 6);
				hour_line.style.transform = 'rotate(' + hour_rotate + 'deg)';
				minute_line.style.transform = 'rotate(' + (minutes * 6 - 90)
						+ 'deg)';
				second_line.style.transform = 'rotate(' + (seconds * 6 - 90)
						+ 'deg)';
			}
			// setTime();
			setInterval(setTime, 1000);
		});
	</script>
</body>
</html>
