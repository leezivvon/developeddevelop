package jspexp.vo;

import java.util.Date;

public class Pemp {

	private String empno;
	private String ename;
	private int deptno;
	private String pos;
	private Date birthd;
	private String birthdS;
	private String address;
	private String pass;
	
	private int grd;

	public Pemp() {
	}
	// 조회
	public Pemp(String empno, String ename, int deptno, String pos, Date birthd, String address, String pass) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.pos = pos;
		this.birthd = birthd;
		this.address = address;
		this.pass = pass;
	}
	// 등록
	public Pemp(String empno, String ename, int deptno, String pos, String birthdS, String address, String pass) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.pos = pos;
		this.birthdS = birthdS;
		this.address = address;
		this.pass = pass;
	}
	// 로그인
	public Pemp(String empno, String pass) {
		this.empno = empno;
		this.pass = pass;
	}
	// 관리자페이지들어갈때 사용
	public Pemp(String empno, int grd, String pos) {
		this.empno = empno;
		this.grd = grd;
		this.pos = pos;
	}
	
	// 부서이동결과조회
	public Pemp(String empno, String ename, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
	}
	
	public Pemp(String empno) {
		this.empno = empno;
	}
	
	
	
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
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
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public Date getBirthd() {
		return birthd;
	}
	public void setBirthd(Date birthd) {
		this.birthd = birthd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getBirthdS() {
		return birthdS;
	}
	public void setBirthdS(String birthdS) {
		this.birthdS = birthdS;
	}
	public int getGrd() {
		return grd;
	}
	public void setGrd(int grd) {
		this.grd = grd;
	}

	
	
}
