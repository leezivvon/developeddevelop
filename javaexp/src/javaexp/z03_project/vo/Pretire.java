package javaexp.z03_project.vo;

import java.util.Date;

public class Pretire {
	
	private String empno;
	private String ename;
	private String dname;
	private String pos;
	private Date entrydate;
	private String retiredateS;
	private Date retiredate;
	private String address;
	private String retirereason;
	private String ph;
	
	public Pretire() {

	}
	// 퇴사정보 입력(등록)
	public Pretire(String empno, String retiredateS, String retirereason, String ph) {
		this.empno = empno;
		this.retiredateS = retiredateS;
		this.retirereason = retirereason;
		this.ph = ph;
	}
	
	//퇴사자정보검색(출력)
	public Pretire(String empno, String ename, String dname, String pos, Date entrydate, Date retiredate,
			String address, String retirereason, String ph) {
		this.empno = empno;
		this.ename = ename;
		this.dname = dname;
		this.pos = pos;
		this.entrydate = entrydate;
		this.retiredate = retiredate;
		this.address = address;
		this.retirereason = retirereason;
		this.ph = ph;
	}
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public Date getRetiredate() {
		return retiredate;
	}
	public void setRetiredate(Date retiredate) {
		this.retiredate = retiredate;
	}
	public String getRetirereason() {
		return retirereason;
	}
	public void setRetirereason(String retirereason) {
		this.retirereason = retirereason;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public String getRetiredateS() {
		return retiredateS;
	}
	public void setRetiredateS(String retiredateS) {
		this.retiredateS = retiredateS;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	
	

}
