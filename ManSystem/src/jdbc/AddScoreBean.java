package jdbc;

public class AddScoreBean {
	public boolean valid(int number,String name,int math,int java,int english,int pe) {
		boolean isvalid = false;
		MysqlBean db=new MysqlBean();
		if(db.createConn()) {
			String sql="insert into score(number,name,math,java,english,pe) "
					+ "values('"+number+"','"+name+"','"+math+"','"+java+"','"+english+"','"+pe+"')";			
			isvalid=db.update(sql);
			
		}
		return isvalid;
	}
	
}
