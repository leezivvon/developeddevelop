package javaexp.z01_homework.vo;

public class Emp06 {

	private String ename;
	private int deptno;
	private double sal;
	public Emp06() {
	}
	public Emp06(String ename, int deptno, double sal) {
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
	}
	public Emp06(String ename) {
		this.ename = ename;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
	
	
}
