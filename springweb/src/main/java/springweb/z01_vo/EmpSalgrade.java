package springweb.z01_vo;

import java.util.Date;

//package springweb.z01_vo.EmpSalgrade
public class EmpSalgrade {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private String hiredateS;
	private double sal;
	private double frSal;
	private double toSal;
	private double comm;
	private int deptno;
	private int grade;
	private int losal;
	private int hisal;
	public EmpSalgrade() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpSalgrade(int empno, String ename, String job, int mgr, Date hiredate, String hiredateS, double sal,
			double frSal, double toSal, double comm, int deptno, int grade) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.hiredateS = hiredateS;
		this.sal = sal;
		this.frSal = frSal;
		this.toSal = toSal;
		this.comm = comm;
		this.deptno = deptno;
		this.grade = grade;
	}

	public EmpSalgrade(int empno, String ename, String job, int mgr, Date hiredate, String hiredateS, double sal,
			double frSal, double toSal, double comm, int deptno, int grade, int losal, int hisal) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.hiredateS = hiredateS;
		this.sal = sal;
		this.frSal = frSal;
		this.toSal = toSal;
		this.comm = comm;
		this.deptno = deptno;
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
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
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getHiredateS() {
		return hiredateS;
	}
	public void setHiredateS(String hiredateS) {
		this.hiredateS = hiredateS;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getFrSal() {
		return frSal;
	}
	public void setFrSal(double frSal) {
		this.frSal = frSal;
	}
	public double getToSal() {
		return toSal;
	}
	public void setToSal(double toSal) {
		this.toSal = toSal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
	

}
