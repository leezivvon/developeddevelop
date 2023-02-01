package javaexp.z03_project.vo;

import java.util.Date;

public class Pjoin {
	private String empno;
	private Date entrydate;
	private String entrydateS1;
	private String entrydateS2;
	private String entrypos;
	private int deptno;
	public Pjoin() {

	}
	// 입력 
	public Pjoin(String entrydateS1, String entrydateS2, String entrypos, int deptno) {
		this.entrydateS1 = entrydateS1;
		this.entrydateS2 = entrydateS2;
		this.entrypos = entrypos;
		this.deptno = deptno;
	}
	// 출력
	
	public Pjoin(String empno, Date entrydate, String entrypos, int deptno) {
		this.empno = empno;
		this.entrydate = entrydate;
		this.entrypos = entrypos;
		this.deptno = deptno;
	}
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public String getEntrypos() {
		return entrypos;
	}
	public void setEntrypos(String entrypos) {
		this.entrypos = entrypos;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEntrydateS1() {
		return entrydateS1;
	}
	public void setEntrydateS1(String entrydateS1) {
		this.entrydateS1 = entrydateS1;
	}
	public String getEntrydateS2() {
		return entrydateS2;
	}
	public void setEntrydateS2(String entrydateS2) {
		this.entrydateS2 = entrydateS2;
	}

	
	
}
