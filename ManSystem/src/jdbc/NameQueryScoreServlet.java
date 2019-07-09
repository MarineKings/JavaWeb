package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameQueryScoreServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public NameQueryScoreServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"); 				 
		MysqlBean db = new MysqlBean();
		//boolean isvalid =false;	
		if(db.createConn()) {
			List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();	
			studentbeanlist = db.getNameScore(name);
			//System.out.println(studentbean.getnumber());
			//System.out.println(request.getContextPath());
			if(studentbeanlist!=null){
				request.getSession().setAttribute("studentbeanlist", studentbeanlist);
				RequestDispatcher view = request.getRequestDispatcher("view/queryscore.jsp");
				view.forward(request, response);				
				db.closeRs();
				db.closeStm();
				db.closeConn();
			}else{
				RequestDispatcher view = request.getRequestDispatcher("/view/menu.jsp");
				view.forward(request, response);
				db.closeRs();
				db.closeStm();
				db.closeConn();
			}
	}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
