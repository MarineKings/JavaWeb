<%@ page import="jdbc.LoginBean" %>
<%@ page import="jdbc.MysqlBean" %>
<%
	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	
	if(userid==""||password==""){
		response.sendRedirect("../view/login.jsp");
	}else{
		LoginBean loginbean=new LoginBean();
		boolean isvalid = loginbean.valid(userid,password);
		out.print(isvalid);

		if(isvalid){
			session.setAttribute("userid",userid);
			response.sendRedirect("../view/menu.jsp");
		}else{
			response.sendRedirect("../view/login.jsp");			
		}
	}
 %>
