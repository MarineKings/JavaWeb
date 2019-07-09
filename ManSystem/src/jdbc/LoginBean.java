package jdbc;
import java.sql.*;

public class LoginBean {
	public boolean valid(String userid,String password){
		boolean isvalid =false;
		MysqlBean db =new MysqlBean();
		if(db.createConn()) {
			String sql="select * from login where userid='"+userid+"'and password='"+password+"'";
			db.query(sql);
			if(db.next()){
				isvalid=true;
				}
				db.closeRs();
				db.closeStm();
				db.closeConn();
			}
		return isvalid;	
	}
}
