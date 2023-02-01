package javaexp.z03_project.vo;

import java.util.Date;

public class Pvacation {
	private String worker;
	private String dname;
	private String ename;
	private String pos;
	private String empno;
	private String vacfdateS;
	private Date vacfdate;
	private String vacldateS;
	private Date vacldate;
	private String vacSdateS;
	
	
	public Pvacation() {

	}
	// 휴가 등록
	public Pvacation(String empno, String vacfdateS, String vacldateS) {
		this.empno = empno;
		this.vacfdateS = vacfdateS;
		this.vacldateS = vacldateS;
	}
	// 휴가 조회
	public Pvacation(String worker, Date vacfdate, Date vacldate) {
		this.worker = worker;
		this.vacfdate = vacfdate;
		this.vacldate = vacldate;
	}
	// 휴가 수정
	public Pvacation(String vacfdateS, String vacldateS, String empno, String vacSdateS) {
		this.empno = empno;
		this.vacfdateS = vacfdateS;
		this.vacldateS = vacldateS;
		this.vacSdateS = vacSdateS;
	}
	// 휴가 삭제
	public Pvacation(String empno, String vacSdateS) {
		this.empno = empno;
		this.vacSdateS = vacSdateS;
	}
	
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getVacfdateS() {
		return vacfdateS;
	}
	public void setVacfdateS(String vacfdateS) {
		this.vacfdateS = vacfdateS;
	}
	public Date getVacfdate() {
		return vacfdate;
	}
	public void setVacfdate(Date vacfdate) {
		this.vacfdate = vacfdate;
	}
	public String getVacldateS() {
		return vacldateS;
	}
	public void setVacldateS(String vacldateS) {
		this.vacldateS = vacldateS;
	}
	public Date getVacldate() {
		return vacldate;
	}
	public void setVacldate(Date vacldate) {
		this.vacldate = vacldate;
	}
	public String getVacSdateS() {
		return vacSdateS;
	}
	public void setVacSdateS(String vacSdateS) {
		this.vacSdateS = vacSdateS;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	
	
	

}
