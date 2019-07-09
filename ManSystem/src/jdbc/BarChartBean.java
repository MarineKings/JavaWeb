package jdbc;

import java.util.ArrayList;
import java.util.List;

public class BarChartBean {

	public List<StudentBean> getScore() {//取得当前记录的字段field的值
		List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();
		MysqlBean db = new MysqlBean();
		if(db.createConn()) {
			try {
				String sql="select * from score";	
				db.query(sql);
				while(db.next())
				{
					StudentBean studentbean=new StudentBean();
					studentbean.setnumber(db.getValueInt("number"));
					studentbean.setname(db.getValueString("name"));
					studentbean.setmath(db.getValueInt("math"));
					studentbean.setjava(db.getValueInt("java"));
					studentbean.setenglish(db.getValueInt("english"));
					studentbean.setpe(db.getValueInt("pe"));
					studentbeanlist.add(studentbean);
				}
			} catch (Exception e) {	}	
			db.closeRs();
			db.closeStm();
			db.closeConn();	
		}
		return studentbeanlist;
	}

}
