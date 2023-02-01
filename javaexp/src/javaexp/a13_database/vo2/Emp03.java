package javaexp.a13_database.vo2;

public class Emp03 {

	private int empno;
	private String ename;
	private String job;
	private int deptno;
	// default 생성자
	public Emp03() { 
		
	}
	// select 관련 생성자
	public Emp03(int empno, String ename, String job, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.deptno = deptno;
	}
	// where 조건 관련 생성자
	public Emp03(String job, int deptno) {
		super();
		this.job = job;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
	
}
