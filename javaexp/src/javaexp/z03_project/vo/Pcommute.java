package javaexp.z03_project.vo;

import java.util.Date;

public class Pcommute {
	
	private String empno;
	private String ename;
	private String cdateS;
	private Date cdate;
	private String art;
	private String arrtimeS;
	private String udArrtimeS;
	private Date arrtime;
	private String lvt;
	private String leavtimeS;
	private Date leavtime;
	private String note;
	public Pcommute() {

	}

	// 출근조회
	public Pcommute(Date cdate, String empno, String ename, String art, String lvt) {
		this.empno = empno;
		this.ename = ename;
		this.cdate = cdate;
		this.art = art;
		this.lvt = lvt;
	}
	// 출근조회 - 출근/휴가/결근 출력
	public Pcommute(String empno, Date cdate) {
		this.empno = empno;
		this.cdate = cdate;
	}
	

	// 출근부 수정-출근시간
	public Pcommute(String udArrtimeS, String arrtimeS, String empno) {
		this.empno = empno;
		this.arrtimeS = arrtimeS;
		this.udArrtimeS = udArrtimeS;
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

	public String getCdateS() {
		return cdateS;
	}

	public void setCdateS(String cdateS) {
		this.cdateS = cdateS;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getArrtimeS() {
		return arrtimeS;
	}

	public void setArrtimeS(String arrtimeS) {
		this.arrtimeS = arrtimeS;
	}

	public String getUdArrtimeS() {
		return udArrtimeS;
	}

	public void setUdArrtimeS(String udArrtimeS) {
		this.udArrtimeS = udArrtimeS;
	}

	public Date getArrtime() {
		return arrtime;
	}

	public void setArrtime(Date arrtime) {
		this.arrtime = arrtime;
	}

	public String getLeavtimeS() {
		return leavtimeS;
	}

	public void setLeavtimeS(String leavtimeS) {
		this.leavtimeS = leavtimeS;
	}

	public Date getLeavtime() {
		return leavtime;
	}

	public void setLeavtime(Date leavtime) {
		this.leavtime = leavtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getLvt() {
		return lvt;
	}

	public void setLvt(String lvt) {
		this.lvt = lvt;
	}
	
	

	
	
	
	
	
	
	

}
