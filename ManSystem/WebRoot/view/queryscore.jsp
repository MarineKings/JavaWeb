<%@ page language="java" import="java.util.*,java.sql.*,java.io.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查询成绩</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="/ManSystem/css/nav.css">
<link rel="stylesheet" type="text/css" href="/ManSystem/css/query.css">
</head>
<body>
	<div class="title">
		<p>查询成绩</p>
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
	<div class="center">
		<div>
			<form name="numberqueryform" action="/ManSystem/NumberQueryScoreServlet" method="post">
				<p>
					学号查找 <input name="number"> <input type="button" value="提交" onClick="return NumberCheck()">
				</p>
			</form>
			<form name="namequeryform" action="/ManSystem/NameQueryScoreServlet"
				method="post">
				<p>
					姓名查找<input name="name"> <input type="button" value="提交"  onClick="return NameCheck()">
				</p>
			</form>
		</div>
		<div class="center_div1">
			<table class="center_tab" id="tab" border="1px">
				<tr>
					<th>学 号</th>
					<th>姓 名</th>
					<th>MATH</th>
					<th>JAVA</th>
					<th>ENGLISH</th>
					<th>PE</th>
				</tr>
				<c:forEach var="U" items="${studentbeanlist}">
					<tr>
						<td>${U.number}</td>
						<td>${U.name}</td>
						<td>${U.math}</td>
						<td>${U.java}</td>
						<td>${U.english}</td>
						<td>${U.pe}</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	function NumberCheck(){
		if (document.numberqueryform.number.value==""){			
			alert("学号为空");
			return false;
		}else{
			numberqueryform.submit();
			return true;
		}
	}
	
	function NameCheck(){
		if (document.namequeryform.name.value==""){			
			alert("名字为空");
			return false;
		}else{
			namequeryform.submit();
			return true;
		}
	}
	
	
</script>
</html>
