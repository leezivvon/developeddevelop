package javaexp.z03_project.vo;

import java.util.Date;

public class Pschedule {
	private String schno;
	private String empno;
	private String topic;
	private String schdateS;
	private Date schdate;
	private String cemp;
	private String list;
	private String schY;
	private String schM;
	private String updDateS;
	private String updTopic;
	private String delTopic;
	private String delDateS;
	public Pschedule() {
		// TODO Auto-generated constructor stub
	}
	//조회-출력
	public Pschedule(String topic, Date schdate, String cemp, String list) {
		this.topic = topic;
		this.schdate = schdate;
		this.cemp = cemp;
		this.list = list;
	}
	//조회-검색
	public Pschedule(String schY, String schM) {
		this.schY = schY;
		this.schM = schM;
	}
	//등록
	public Pschedule(String schno, String empno, String schdateS, String topic) {
		this.schno = schno;
		this.empno = empno;
		this.schdateS = schdateS;
		this.topic = topic;
	}

//	//날짜 수정
//	public Pschedule(String updDateS, String updTopic) {
//		this.updDateS = updDateS;
//		this.updTopic = updTopic;
//	}
//	
//	//스케줄 삭제
//	public Pschedule(String delTopic, String delDateS) {
//		this.delTopic = delTopic;
//		this.delDateS = delDateS;
//	}
	public String getSchno() {
		return schno;
	}
	
	public void setSchno(String schno) {
		this.schno = schno;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Date getSchdate() {
		return schdate;
	}
	public void setSchdate(Date schdate) {
		this.schdate = schdate;
	}
	public String getCemp() {
		return cemp;
	}
	public void setCemp(String cemp) {
		this.cemp = cemp;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getSchY() {
		return schY;
	}
	public void setSchY(String schY) {
		this.schY = schY;
	}
	public String getSchM() {
		return schM;
	}
	public void setSchM(String schM) {
		this.schM = schM;
	}
	public String getUpdDateS() {
		return updDateS;
	}
	public void setUpdDateS(String updDateS) {
		this.updDateS = updDateS;
	}
	public String getUpdTopic() {
		return updTopic;
	}
	public void setUpdTopic(String updTopic) {
		this.updTopic = updTopic;
	}
	public String getDelTopic() {
		return delTopic;
	}
	public void setDelTopic(String delTopic) {
		this.delTopic = delTopic;
	}
	public String getDelDateS() {
		return delDateS;
	}
	public void setDelDateS(String delDateS) {
		this.delDateS = delDateS;
	}
	public String getSchdateS() {
		return schdateS;
	}
	public void setSchdateS(String schdateS) {
		this.schdateS = schdateS;
	}
	
	
	
	

}
