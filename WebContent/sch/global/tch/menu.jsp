<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/sch/global/head.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/menu.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(document).ready(function() {
		$(".detail").hide();
		
		$(".controll").click(function() {
			var url = $(this).children("div.direction").css("background-image")
			
			$(".direction").css("background-image" , "url('/sch/resource/image/right.png')");
			
			if(url.match("down") == 'down') {
				$(this).children("div.direction").css("background-image" , "url('/sch/resource/image/right.png')");
			} else {
				$(this).children("div.direction").css("background-image" , "url('/sch/resource/image/down.png')");
			}
			
			$(this).next().children().slideToggle(500);
		})
	});
</script>
</head>
<body>
	<ul>
		<li>
			<div class="controll"><div class="direction"></div><div class="item">個人資訊</div></div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/tch_info.jsp" target="main">基本資料</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/timetable.jsp" target="main">個人課表</a></li>
			</ul>
		</li>
		<li>
			<div class="controll">
				<div class="direction"></div><div class="item">課程管理</div>
			</div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/course_insert.jsp" target="main">課程新增與查詢</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/course_grade.jsp" target="main">課程成績輸入</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/course_abs.jsp" target="main">缺曠記錄管理</a></li>
			</ul>
		</li>
		<li>
			<div class="controll">
				<div class="direction"></div><div class="item">班級資訊</div>
			</div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/class_Edit.jsp" target="main">班級資訊編輯</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/class_Query.jsp" target="main">班級名單查詢</a></li>				
			</ul>
		</li>
		<li>
			<div class="controll"><div class="direction"></div><div class="item">人資專區</div></div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/stu_Update.jsp" target="main">學生資料更改與查詢</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/tch_Update.jsp" target="main">教師資料更改與查詢</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/newStu.jsp" target="main">新進學生資料輸入</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/newTch.jsp" target="main">新進教師資料輸入</a></li>
			</ul>
		</li>
		<li>
			<div class="controll"><div class="direction"></div><div class="item">教師請假系統</div></div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/tch/tch_leave.jsp" target="main">請假申請與查詢</a></li>
			</ul>
		</li>
	</ul>
</body>
</html>