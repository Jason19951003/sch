<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/button/css/buttons.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/index.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resource/button/js/buttons.js"></script>

<script type="text/javascript">
	$(function(){
		// 預設顯示第一個 Tab
		var _showTab = 0;
		var $defaultLi = $('ul.tabs li').eq(_showTab).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
		
		// 當 li 頁籤被點擊時...
		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
		$('ul.tabs li').click(function() {
			// 找出 li 中的超連結 href(#id)
			var $this = $(this),
				_clickTab = $this.find('a').attr('href');
			// 把目前點擊到的 li 頁籤加上 .active
			// 並把兄弟元素中有 .active 的都移除 class
			$this.addClass('active').siblings('.active').removeClass('active');
			// 淡入相對應的內容並隱藏兄弟元素
			$(_clickTab).stop(false, true).fadeIn().siblings().hide();

			return false;
		}).find('a').focus(function(){
			this.blur();
		});
		
		$("input").each(function() {
			$(this).next().hide();
		});
	});
	
	function login(str) {
		var str_no = $("#" + str + "_form input[name=" + str + "_no]");
		var str_password = $("#" + str + "_form input[name=" + str + "_password]");
		
		str_no.next().hide();
		str_password.next().hide();
		
		if(str_no.val() == '')
			str_no.next().show();
		if(str_password.val() == '')
			str_password.next().show();
		if(str_no.val() != '' && str_password.val() != '') {				
			$("#" + str + "_form").submit();
		}
	}
	
	function clean(str) {
		$("input").each(function() {
			$(this).next().hide();
		});
		$("#" + str + "_form").trigger('reset');
	}
</script>
</head>
<body>
	<c:if test="${ERROR != null }">
		<script type="text/javascript">alert('${ERROR }')</script>
	</c:if>

	<div class="abgne_tab">
		<ul class="tabs">
			<li><a href="#tab1">學生登入</a></li>
			<li><a href="#tab2">教師登入</a></li>
		</ul>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
				<form action="<%=request.getContextPath() %>/login/stuLogin.do" method="post" id="stu_form">
					帳號：<input type="text" name="stu_no"><span id="validate" style="color:red;">請輸入帳號</span><br><br>
					密碼：<input type="password" name="stu_password"><span id="validate" style="color:red;">請輸入密碼</span><br><br>
					<a href="#" class="button glow" onclick="login('stu');"><span>確認登入</span></a>
					<a href="#" class="button glow" onclick="clean('stu')"><span>清除資料</span></a>
				</form>
			</div>
			<div id="tab2" class="tab_content">
				<form action="<%=request.getContextPath() %>/login/tchLogin.do" method="post" id="tch_form">
					帳號：<input type="text" name="tch_no"><span id="validate" style="color:red;">請輸入帳號</span><br><br>
					密碼：<input type="password" name="tch_password"><span id="validate" style="color:red;">請輸入密碼</span><br><br>
					<a href="#" class="button glow" onclick="login('tch');"><span>確認登入</span></a>
					<a href="#" class="button glow" onclick="clean('tch')"><span>清除資料</span></a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>