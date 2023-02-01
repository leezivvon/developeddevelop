package javaexp.z01_homework.vo;

public class Emp01 {

	private String ename;
	private String dname;
	private double sal;
	private int grade;
	private int losal;
	private int hisal;
	private int div;
	public Emp01() {
		
	}
	public Emp01(String ename, String dname, double sal, int grade) {
		this.ename = ename;
		this.dname = dname;
		this.sal = sal;
		this.grade = grade;
	}
	public Emp01(String dname, int losal, int hisal, int div) {
		this.dname = dname;
		this.losal = losal;
		this.hisal = hisal;
		this.div = div;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLosal() {
		return losal;
	}
	public void setLosal(int losal) {
		this.losal = losal;
	}
	public int getHisal() {
		return hisal;
	}
	public void setHisal(int hisal) {
		this.hisal = hisal;
	}
	public int getDiv() {
		return div;
	}
	public void setDiv(int div) {
		this.div = div;
	}
	
	
}
