<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>更新删除</title>
<link rel="stylesheet" type="text/css" href="/ManSystem/css/nav.css">
<link rel="stylesheet" type="text/css" href="/ManSystem/css/update.css">
</head>
<body>
	<div class="title">
		<p>更新删除</p>
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
		<form action="/ManSystem/UpdateInformationServlet" method="post">
			<p>
				<input type="submit" value="查找">
			</p>
		</form>
		<table class="middle_table" border="1">
			<tr>
				<th>学 号</th>
				<th>姓 名</th>
				<th>性别</th>
				<th>出生</th>
				<th>修改</th>
			</tr>
<!-- 			<form name="numberqueryform" action="/ManSystem/NumberQueryScoreServlet" method="post">
				<p>
					<input type="submit" value="提交">
				</p>
			</form> -->
			<c:forEach var="U" items="${studentbeanlist}">
				<form action="/ManSystem/UpdateChangeInformationServlet"
					method="post">

					<tr>
						<td><input name="number" value="${U.number}"></td>
						<td><input name="name" value="${U.name}"></td>
						<td><input name="sex" value="${U.sex}"></td>
						<td><input name="birth" value="${U.birth}"></td>
						<td><input type="submit" value="修改"></td>
					</tr>

				</form>
			</c:forEach>
		</table>
	</div>




</body>
</html>
