<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/sch/global/head.jsp"%>
<title>學生基本資料</title>
<script type="text/javascript">
	$(document).ready(function() {
		processMain();
	});
	
	function processMain() {
		//var formdata =  new FormData($('#editform')[0]);
		
		var json = {
			async : true
			,type : "POST"
			,cache : true
			,processData: false
			,contentType : false
			,url : "<%=request.getContextPath()%>/StuInfoController.do?action=processMain"
			,data: {}
			,dataType : "json"
			,success : function (jsonResult) {
				for(var key in jsonResult.data) {
					$("table tr td[name="+ key +"]").text(jsonResult.data[key]);
					console.log(key + "：" + jsonResult.data[key]);
				}
			}
			,error : function(xhr, textStatus, errorThrown) {
				alert(xhr.responseText);
				console.log(xhr.responseText);
			}
		}	
		
		$.ajax(json);
	}
</script>
<style type="text/css">	
	div {
		padding: 5px;
	}
</style>
</head>
<body>
	<div>
		<table class="table-command">
			<tr>
				<th>學號</th><td name="stu_no"></td>
				<th>姓名</th><td name="stu_name"></td>
				<th>導師</th><td></td>
			</tr>
			<tr>
				<th>身分證字號</th><td name="stu_idn"></td>
				<th>生日</th><td name="stu_birthday"></td>
			</tr>
			<tr>
				<th>手機</th><td name="stu_tel"></td>
				<th>家裡電話</th><td name="stu_hometel"></td>
			</tr>
			<tr>
				<th>家長姓名</th><td name="stu_parents"></td>
				<th>家長電話</th><td name="stu_ptel"></td>
			</tr>
			<tr>
				<th>通訊地址</th><td name="stu_addr"></td>	
			</tr>
		</table>
	</div>	
</body>
</html>