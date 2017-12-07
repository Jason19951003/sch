<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/sch/global/head.jsp"%>
<title>教師基本資料</title>
<script type="text/javascript">
	$(document).ready(function() {
		processMain();
	});
	
	function processMain() {		
		var option = {
			url : "<%=request.getContextPath()%>/TchInfoController.do?action=processMain"			
			,data : {}
			,success : function (jsonResult) {
				formUtil.binddata({
					tableObj : $(".table-command")
					,tableData : jsonResult.data
				})				
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
				<th>教師編號</th><td name="tch_no"></td>
				<th>姓名</th><td name="tch_name"></td>				
			</tr>
			<tr>
				<th>身分證字號</th><td name="tch_idn"></td>
				<th>生日</th><td name="tch_birthday"></td>
			</tr>
			<tr>
				<th>手機</th><td name="tch_tel"></td>
				<th>家裡電話</th><td name="tch_hometel"></td>
			</tr>
			<tr>
				<th>辦公室位子</th><td name="tch_office"></td>
				<th>所屬科系</th><td name="tch_series"></td>
			</tr>
			<tr>
				<th>通訊地址</th><td name="tch_addr" colspan="3"></td>	
			</tr>
		</table>
	</div>
</body>
</html>