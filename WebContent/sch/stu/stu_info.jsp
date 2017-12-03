<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/sch/global/head.jsp"%>
<title>學生基本資料</title>
<script type="text/javascript">	
	$(document).ready(function() {
		/* var html = "<table class='table-command'>" +
		"<tr><th>學號</th><td name='stu_no'></td><th>姓名</th><td name='stu_name'></td><th>導師</th><td></td></tr>" + 
		"<tr><th>身分證字號</th><td name='stu_idn'></td><th>生日</th><td name='stu_birthday'></td></tr>" + 
		"<tr><th>手機</th><td name='stu_tel'></td><th>家裡電話</th><td name='stu_hometel'></td></tr>" + 
		"<tr><th>家長姓名</th><td name='stu_parents'></td><th>家長電話</th><td name='stu_ptel'></td></tr>" + 
		"<tr><th>通訊地址</th><td name='stu_addr'></td></tr>" + 
		"</table>";
		
		$(html).appendTo("div.tableGrid"); */
		processMain();
	});
	
	function processMain() {
		//var formdata =  new FormData($('#editform')[0]);
		var option = {
			url : "<%=request.getContextPath()%>/StuInfoController.do?action=processMain"			
			,data : {}
			,success : function (jsonResult) {
				formUtil.binddata({
					tableObj : $(".table-command")
					,tableData : jsonResult.data
				})
				/* for(var key in jsonResult.data) {
					//$(".table-command").find("input[name" + key + "]").val(jsonResult.data[key]);
					$(".table-command").find("[name=" + key + "]").val(jsonResult.data[key]);
					$(".table-command").find("[name=" + key + "]").text(jsonResult.data[key])
					//$(".table-command").find("[name" + key + "]").text(jsonResult.data[key]);					
					//$(".table-command [name="+ key +"]").val(jsonResult.data[key]);//如果是input屬性需使用val給值
					//$(".table-command [name="+ key +"]").text(jsonResult.data[key]);//td使用text
					console.log(jsonResult.data[key]);
					//console.log($(".table-command [name="+ key +"]").val());
					console.log();
				} */
			}
		}
		formUtil.submit(option);
	}	
</script>
</head>
<body>
	<div class="table-padding">
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
				<th>通訊地址</th><td name="stu_addr" colspan="3"></td>	
			</tr>
		</table>
	</div>
</body>
</html>