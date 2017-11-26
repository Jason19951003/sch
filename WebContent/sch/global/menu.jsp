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
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/stu_info.jsp" target="main">基本資料</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/abs_doc.jsp" target="main">缺曠紀錄</a></li>
			</ul>
		</li>
		<li>
			<div class="controll">
				<div class="direction"></div><div class="item">學習檔案</div>
			</div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/mid_grade.jsp" target="main">期中成績</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/end_grade.jsp" target="main">學期成績</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/lyear_grade.jsp" target="main">歷年成績</a></li>
			</ul>
		</li>
		<li>
			<div class="controll"><div class="direction"></div><div class="item">學生選課系統</div></div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/elective.jsp" target="main">選課系統</a></li>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/elective_list.jsp" target="main">本學習修課清單</a></li>
			</ul>
		</li>
		<li>
			<div class="controll"><div class="direction"></div><div class="item">學生請假系統</div></div>
			<ul>
				<li class="detail"><a href="<%=request.getContextPath() %>/sch/stu/leave.jsp" target="main">請假申請與查詢</a></li>
			</ul>
		</li>
	</ul>
</body>
</html>