<%@ page import="jdbc.AddScoreBean"%>
<%@ page import="jdbc.MysqlBean"%>
<%
	int number = Integer.parseInt(request.getParameter("number"));
	String name = request.getParameter("name");
	int math = Integer.parseInt(request.getParameter("math"));
	int java = Integer.parseInt(request.getParameter("java"));
	int english = Integer.parseInt(request.getParameter("english"));
	int pe = Integer.parseInt(request.getParameter("pe"));

	if (name=="") {
		response.sendRedirect("../view/addscore.jsp");
	} else {
		AddScoreBean addscorebean = new AddScoreBean();
		boolean isvalid = addscorebean.valid(number,name,math, java, english,pe);
		out.print(isvalid);
		if (isvalid) {
			//session.setAttribute("userid",userid);
			response.sendRedirect("../view/addscore.jsp");

		} else {
			response.sendRedirect("../view/menu.jsp");

		}

	}
%>