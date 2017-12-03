<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/sch/global/head.jsp"%>
<title>班級資訊編輯</title>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<div class="table-padding top">
		<a href="#" class="button button-border">新增</a>&nbsp;&nbsp;
		<a href="#" class="button button-border">查詢</a>&nbsp;&nbsp;
		<!-- <input type="button" value="新增">&nbsp;&nbsp;
		<input type="button" value="查詢">&nbsp;&nbsp; -->
	</div>
	
	<div class="table-padding">
		<table class="table-edit">
			<tr>
				<th>科系</th>
				<td>
					<select name="series">
						<option></option>
						<option value="IM">資管系</option>
					</select>
				</td>
				<th>年級</th>
				<td>
					<select name="grade">
						<option></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
				<th>班級</th>
				<td>
					<select name="classNO">
						<option></option>
						<option value="甲">甲</option>
						<option value="乙">乙</option>
						<option value="丙">丙</option>
						<option value="丁">丁</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>老師</th><td colspan="5"><input type="text"></td>				
			</tr>			
		</table>
	</div>
</body>
</html>