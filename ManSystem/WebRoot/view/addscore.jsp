<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加成绩</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/nav.css">
<link rel="stylesheet" type="text/css" href="../css/addscore.css">
</head>
<body>
	<div class="title">
		<p>添加成绩</p>
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
	<div class="middle">
		<form action="../controller/addscore_controller.jsp">
			<p>
				学号<input name="number"></input>
			</p>
			<p>
				姓名<input name="name"></input>
			</p>
			<p>
				数学<input name="math"></input>
			</p>
			<p>
				JAVA<input name="java"></input>
			</p>
			<p>
				英语<input name="english"></input>
			</p>
			<p>
				体育<input name="pe"></input>
			</p>
			<p>
				<input type="submit" value="提交">
			<p>
		</form>
	</div>
</body>
</html>
