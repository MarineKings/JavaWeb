package jdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UpdateChangeInformationBean {

	public List<StudentBean> changeInformation(int number,String name,String sex,String birth) {//取得当前记录的字段field的值
		List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();
		MysqlBean db = new MysqlBean();
		if(db.createConn()) {
			try {
				String sql="update information set name='"+name+"',sex='"+sex+"',birth='"+birth+"'where number='"+number+"'";
				db.update(sql);
				sql="select * from information";	
				db.query(sql);
				while(db.next())
				{
					StudentBean studentbean=new StudentBean();				
//					System.out.println(db.getValueString("name"));
//					System.out.println(db.getValueString("sex"));
					studentbean.setnumber(db.getValueInt("number"));
					studentbean.setname(db.getValueString("name"));
					studentbean.setsex(db.getValueString("sex"));
					studentbean.setbirth(db.getValueString("birth"));
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
