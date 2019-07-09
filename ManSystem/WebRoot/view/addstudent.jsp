<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="../css/nav.css">
<link rel="stylesheet" type="text/css" href="../css/addstudent.css">
</head>
<body>
	<div class="title">
		<p>添加学生功能</p>
	</div>
	<div class="nav">
		<ul>
			<li><a href="/ManSystem/view/menu.jsp">首页</a></li>
			<li><a href="/ManSystem/view/addstudent.jsp">添加学生</a></li>
			<li><a href="/ManSystem/view/addscore.jsp">添加成绩</a></li>
			<li><a href="/ManSystem/view/queryscore.jsp">查询成绩</a></li>
			<li><a href="/ManSystem/view/barchart.jsp">成绩柱状图</a></li>
			<li><a href="/ManSystem/view/update.jsp">修改删除</a></li>
			<li><a href="/ManSystem/view/form.jsp">成绩报表</a></li>
		</ul>
	</div>
	<div class="div_max">
		<div class="middle">
			<form action="../controller/addstudent_control.jsp">
				<table class="student_table">
					<tr>
						<td>姓名</td>
						<td><input name="name"></td>
					</tr>
					<tr>
						<td>性别</td>
						<td><input name="sex"></td>
					</tr>
					<tr>
						<td>出生年月</td>
						<td><input name="birth"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
