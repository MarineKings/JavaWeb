package jdbc;

public class AddStudentBean {
	public boolean valid(String name,String sex,String birth) {
		boolean isvalid = false;
		MysqlBean db=new MysqlBean();
		if(db.createConn()) {
			String sql="insert into information(name,sex,birth)values('"+name+"','"+sex+"','"+birth+"')";			
			isvalid=db.update(sql);
			
		}
		return isvalid;
	}
	
}
