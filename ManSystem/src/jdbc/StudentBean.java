package jdbc;
import java.sql.Date;
public class StudentBean {
	private int number = 0;
	private String name=null;
	private String sex=null;
	private String birth=null;
	private int math=0;
	private int java=0;
	private int english=0;
	private int pe=0;
	private int avg=0;
	
	public StudentBean() {}
	public StudentBean(int number,String name,int math,int java,int english,int pe,int avg) {
		this.number=number;
		this.name=name;
		this.math=math;
		this.java=java;
		this.english=english;
		this.pe=pe;
		this.avg=avg;
	}
	public int getnumber() {return this.number;}
	public String getname() {return this.name;}
	public String getsex() {return this.sex;}
	public String getbirth() {return this.birth;}
	public int getmath() {return this.math;}
	public int getjava() {return this.java;}
	public int getenglish() {return this.english;}
	public int getpe() {return this.pe;}
	public int getavg() {return this.avg;}
	
	public void setnumber(int number) {this.number=number;}
	public void setname(String name) {this.name=name;}
	public void setsex(String sex) {this.sex=sex;}
	public void setbirth(String birth) {this.birth=birth;}
	public void setmath(int math) {this.math=math;}
	public void setjava(int java) {this.java=java;}
	public void setenglish(int english) {this.english=english;}
	public void setpe(int pe) {this.pe=pe;}
	public void setavg(int avg) {this.avg=avg;}

}

