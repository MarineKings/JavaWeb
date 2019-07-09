package jdbc;

import java.util.ArrayList;
import java.util.List;

public class FormBean {

	public List<StudentBean> getForm() {//取得当前记录的字段field的值
		List<StudentBean> studentbeanlist=new ArrayList<StudentBean>();
		MysqlBean db_information = new MysqlBean();
		MysqlBean db_score = new MysqlBean();
		if(db_information.createConn()) {
			if(db_score.createConn()) {
				try {
					String sql_information="select * from information";
					db_information.query(sql_information);
					while(db_information.next())
					{
						StudentBean studentbean=new StudentBean();
						studentbean.setnumber(db_information.getValueInt("number"));
						studentbean.setname(db_information.getValueString("name"));
						studentbean.setsex(db_information.getValueString("sex"));
						studentbean.setbirth(db_information.getValueString("birth"));

						String sql_score="select * from score where number='"+db_information.getValueInt("number")+"'";
						db_score.query(sql_score);
						db_score.next();
						studentbean.setmath(db_score.getValueInt("math"));
//						System.out.println("math"+db_score.getValueInt("math"));
						studentbean.setjava(db_score.getValueInt("java"));
						studentbean.setenglish(db_score.getValueInt("english"));
						studentbean.setpe(db_score.getValueInt("pe"));

						sql_score="SELECT number, (math+java+english+pe)/4 as avg FROM score GROUP BY number having number = '"+ db_information.getValueInt("number")+"';";
						db_score.query(sql_score);
						db_score.next();
						studentbean.setavg(db_score.getValueInt("avg"));
						
						studentbeanlist.add(studentbean);

					}

				} catch (Exception e) {	}	
				db_information.closeRs();
				db_information.closeStm();
				db_information.closeConn();	
				db_score.closeRs();
				db_score.closeStm();
				db_score.closeConn();	
			}
		}
		return studentbeanlist;
	}
	public int getavg_math() {
		MysqlBean db = new MysqlBean();
		int avg=0;
		if(db.createConn()) {
			String sql="SELECT avg(math) as avg FROM score";
			db.query(sql);
			db.next();
			avg = db.getValueInt("avg");
			db.closeRs();
			db.closeStm();
			db.closeConn();	
		}
		return avg;
	}
	public int getavg_java() {
		MysqlBean db = new MysqlBean();
		int avg=0;
		if(db.createConn()) {
			String sql="SELECT avg(java) as avg FROM score";
			db.query(sql);
			db.next();
			avg = db.getValueInt("avg");
			db.closeRs();
			db.closeStm();
			db.closeConn();	
		}
		return avg;
	}
	public int getavg_english() {
		MysqlBean db = new MysqlBean();
		int avg=0;
		if(db.createConn()) {
			String sql="SELECT avg(english) as avg FROM score";
			db.query(sql);
			db.next();
			avg = db.getValueInt("avg");
			db.closeRs();
			db.closeStm();
			db.closeConn();	
		}
		return avg;
	}
	public int getavg_pe() {
		MysqlBean db = new MysqlBean();
		int avg=0;
		if(db.createConn()) {
			String sql="SELECT avg(pe) as avg FROM score";
			db.query(sql);
			db.next();
			avg = db.getValueInt("avg");
			db.closeRs();
			db.closeStm();
			db.closeConn();	
		}
		return avg;
	}
	public int getavg_all() {
		MysqlBean db = new MysqlBean();
		int avg=0;
		if(db.createConn()) {
			String sql="SELECT avg((math+english+java+pe)/4)as avg FROM score";
			db.query(sql);
			db.next();
			avg = db.getValueInt("avg");
			db.closeRs();
			db.closeStm();
			db.closeConn();	
		}
		return avg;
	}
}
