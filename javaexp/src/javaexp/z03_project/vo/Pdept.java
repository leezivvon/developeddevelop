package javaexp.z03_project.vo;

public class Pdept {
	private int deptno;
	private String dname;
	private String loc;
	private String ctp;
	public Pdept() {
	
	}
	// ctp : 부서별총인원 출력
	public Pdept(int deptno, String dname, String loc, String ctp) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.ctp = ctp;
	}
	public Pdept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public Pdept(int deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCtp() {
		return ctp;
	}
	public void setCtp(String ctp) {
		this.ctp = ctp;
	}
	
}



//pdept랑 pemp join class
//SELECT d.*, e.ct||' 명'
//FROM pdept d, ( SELECT deptno, count(deptno) ct
//			   FROM pemp 
//			   GROUP BY deptno ) e
//WHERE e.deptno=d.deptno
//AND (d.deptno = 501
//OR dname LIKE '%'||upper('a')||'%');



