<%@ page import="jdbc.AddStudentBean"%>
<%@ page import="jdbc.MysqlBean"%>
<%
	String name = request.getParameter("name");
	String sex = request.getParameter("sex");
	String birth = request.getParameter("birth");

	if (name == "" || sex == "" || birth == "") {
		response.sendRedirect("../view/addstudent.jsp");
	} else {
		AddStudentBean addstudentbean = new AddStudentBean();
		boolean isvalid = addstudentbean.valid(name, sex, birth);
		out.print(isvalid);
		if (isvalid) {
			//session.setAttribute("userid",userid);
			response.sendRedirect("../view/addstudent.jsp");

		} else {
	response.sendRedirect("../view/menu.jsp");

		}

	}
%>