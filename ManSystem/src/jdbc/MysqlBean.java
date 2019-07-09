package jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlBean 
{
	private String drv = "com.mysql.jdbc.Driver";//数据库驱动程序
	private String url = "jdbc:mysql://localhost:3306/student";//主机的URL
	private String usr = "root";//用户名
	private String pwd = "huang136";//口令
	private Connection conn = null;//数据库的连接对象
	private Statement stm = null;//SQL语句的声明对象
	private ResultSet rs = null;//结果集对象

//为以上定义的7个变量编写getter/setter方法
    public String getDrv() {
		return drv;
	}
	public void setDrv(String drv) {
		this.drv = drv;
	}
    public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
    public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
    public Statement getStm() {
		return stm;
	}
	public void setStm(Statement stm) {
		this.stm = stm;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	public boolean createConn() {//创建数据库连接
		boolean b = false;
		try { 
			Class.forName(drv);
			conn = DriverManager.getConnection(url, usr, pwd);
			b = true;
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		} 
		return b;
	}

	public boolean update(String sql) {//更新数据库内容的SQL方法
		boolean b = false;
		try {	
			stm = conn.createStatement();
			stm.execute(sql);
			b = true;
		} catch (Exception e) {System.out.println(e.toString());  }
		return b;
	}
	
	public void query(String sql) {  //查询数据库内容的SQL方法
		try {	
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {	}
	}

	public boolean next() {//移到下条记录的方法
		boolean b = false;
		try { 	
			if(rs.next())  
			b = true;
		} catch (Exception e) {	}
		return b;		
	}

	public String getValueString(String field) {//取得当前记录的字段field的值
		String value = null;
		try {
			if(rs!=null)
				value = rs.getString(field);
			} catch (Exception e) {	}
		return value;
	}
	public int getValueInt(String field) {//取得当前记录的字段field的值
		int value = 0;
		try {
			if(rs!=null)
				value = rs.getInt(field);
			} catch (Exception e) {	}
		return value;
	}
	public Date getValueDate(String field) {//取得当前记录的字段field的值
		Date value = null;
		try {
			if(rs!=null)
				value = rs.getDate(field);
			} catch (Exception e) {	}
		return value;
	}
	
	
	
	
	
	
	public List<StudentBean> getValueScore(int number) {//取得当前记录的字段field的值
		List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();
		try {
			String sql="select * from score where number like '%"+number+"%'";	
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				StudentBean studentbean=new StudentBean();
				
				System.out.println(rs.getString("name"));
				
				studentbean.setnumber(rs.getInt("number"));
				studentbean.setname(rs.getString("name"));
				studentbean.setmath(rs.getInt("math"));
				studentbean.setjava(rs.getInt("java"));
				studentbean.setenglish(rs.getInt("math"));
				studentbean.setpe(rs.getInt("pe"));
				studentbeanlist.add(studentbean);
			}
		} catch (Exception e) {	}
		return studentbeanlist;
	}
	public List<StudentBean> getNameScore(String name) {//取得当前记录的字段field的值
		List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();
		try {
			String sql="select * from score where name like '%"+name+"%'";	
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				StudentBean studentbean=new StudentBean();
				
				System.out.println(rs.getString("name"));
				
				studentbean.setnumber(rs.getInt("number"));
				studentbean.setname(rs.getString("name"));
				studentbean.setmath(rs.getInt("math"));
				studentbean.setjava(rs.getInt("java"));
				studentbean.setenglish(rs.getInt("math"));
				studentbean.setpe(rs.getInt("pe"));
				studentbeanlist.add(studentbean);
			}
		} catch (Exception e) {	}
		return studentbeanlist;
	}
	

//关闭与数据库连接相关的三个对象
	public void closeConn() { 
		try {	if (conn != null)	conn.close();
		} catch (SQLException e) {	}
	}

	public void closeStm() {
		try {	if (stm != null)	stm.close();
		} catch (SQLException e) {	}
	}

	public void closeRs() {
		try {	if (rs != null)	    rs.close();
		} catch (SQLException e) {}
	}
}
