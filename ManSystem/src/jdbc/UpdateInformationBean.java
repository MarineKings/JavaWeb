package jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateInformationBean {

	public List<StudentBean> getInformation() {//取得当前记录的字段field的值
		List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();
		MysqlBean db = new MysqlBean();
		if(db.createConn()) {
			try {
				String sql="select * from information";	
				db.query(sql);
				while(db.next())
				{
					StudentBean studentbean=new StudentBean();
					//System.out.println("12321321321321323131313");
					//System.out.println(db.getValueString("name"));
					//System.out.println(db.getValueString("sex"));

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
