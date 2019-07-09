<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生成绩管理系统</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>

	<div class="title">
		<p>欢迎登录学生成绩管理系统</p>
	</div>
	<div id="index">
		<form action="../controller/login_control.jsp" method="post">
			<p>
				账号<input name="userid" type="text" /><br>
			</p>
			<p>
				密码<input name="password" type="password"/> 
			<p>				
				<input name="user" type="radio" value="student" checked>学生 
				<input name="user" type="radio" value="administrator">管理员<br>
			</p>
			<p>
				<input id="btn_login" type="submit" >
			</p>			
			</form>
</body>
</html>
