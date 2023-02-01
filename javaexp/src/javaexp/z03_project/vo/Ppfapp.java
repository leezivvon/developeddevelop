package javaexp.z03_project.vo;

import java.util.Date;

public class Ppfapp {

	private String empno;
	private Date pfapdate;
	private String dname;
	private String pos;
	private String ename;
	private double pfapscore;
	private String prresult;
	private String impinfo;

	// 인사평가등록할 때
	public Ppfapp(String empno, double pfapscore, String prresult, String impinfo) {
		this.empno = empno;
		this.pfapscore = pfapscore;
		this.prresult = prresult;
		this.impinfo = impinfo;
	}
	
	public Ppfapp(String empno, Date pfapdate, double pfapscore, String prresult, String impinfo) {
		this.empno = empno;
		this.pfapdate = pfapdate;
		this.pfapscore = pfapscore;
		this.prresult = prresult;
		this.impinfo = impinfo;
	}
	// 인사평가조회할 때
	public Ppfapp(Date pfapdate, String dname, String pos, String ename, String prresult, String impinfo) {
		this.pfapdate = pfapdate;
		this.dname = dname;
		this.pos = pos;
		this.ename = ename;
		this.prresult = prresult;
		this.impinfo = impinfo;
	}
	
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public Date getPfapdate() {
		return pfapdate;
	}
	public void setPfapdate(Date pfapdate) {
		this.pfapdate = pfapdate;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getPfapscore() {
		return pfapscore;
	}
	public void setPfapscore(double pfapscore) {
		this.pfapscore = pfapscore;
	}
	public String getPrresult() {
		return prresult;
	}
	public void setPrresult(String prresult) {
		this.prresult = prresult;
	}
	public String getImpinfo() {
		return impinfo;
	}
	public void setImpinfo(String impinfo) {
		this.impinfo = impinfo;
	}
	
	
	
	
}
