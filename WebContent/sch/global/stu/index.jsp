<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/sch/global/head.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
<title>學生管理系統</title>
</head>
<frameset rows="15%,*">
	<frame src="<%=request.getContextPath()%>/sch/global/stu/title.jsp" noresize="noresize" name="title">
	<frameset cols="15%,*" >
		<frame src="<%=request.getContextPath()%>/sch/global/stu/menu.jsp" noresize="noresize" name="menu">
		<frame src="<%=request.getContextPath()%>/sch/global/stu/main.jsp" name="main">
	</frameset>
<noframes>
<body></body>
</noframes>
</frameset>
</html>