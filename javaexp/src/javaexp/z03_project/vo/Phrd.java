package javaexp.z03_project.vo;

import java.util.Date;

public class Phrd {
	// pperplan 등록 // 인사계획 입력
	private String ppyearS;
	private Date ppyear;
	private int deptno;
	private int bu;
	private int cha;
	private int gwa;
	private int dae;
	private int sawon;
	
	private String pos;
	private int ct;
	
	private int hab;
	private int dgc;
	private double per;
	public Phrd() {

	}
	// 인사계획입력
	public Phrd(String ppyearS, int deptno, int bu, int cha, int gwa, int dae, int sawon) {
		this.ppyearS = ppyearS;
		this.deptno = deptno;
		this.bu = bu;
		this.cha = cha;
		this.gwa = gwa;
		this.dae = dae;
		this.sawon = sawon;
	}
	
	// 현재 인원 조회
	public Phrd(String pos, int ct) {
		this.pos = pos;
		this.ct = ct;
	}

	// 계획 인원 조회 & 직원 비율
	public Phrd(int deptno, int bu, int cha, int gwa, int dae, int sawon, int hab, int dgc, double per) {
		this.deptno = deptno;
		this.bu = bu;
		this.cha = cha;
		this.gwa = gwa;
		this.dae = dae;
		this.sawon = sawon;
		this.hab = hab;
		this.dgc = dgc;
		this.per = per;
	}

	public String getPpyearS() {
		return ppyearS;
	}
	public void setPpyearS(String ppyearS) {
		this.ppyearS = ppyearS;
	}
	public Date getPpyear() {
		return ppyear;
	}
	public void setPpyear(Date ppyear) {
		this.ppyear = ppyear;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getBu() {
		return bu;
	}
	public void setBu(int bu) {
		this.bu = bu;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public int getGwa() {
		return gwa;
	}
	public void setGwa(int gwa) {
		this.gwa = gwa;
	}
	public int getDae() {
		return dae;
	}
	public void setDae(int dae) {
		this.dae = dae;
	}
	public int getSawon() {
		return sawon;
	}
	public void setSawon(int sawon) {
		this.sawon = sawon;
	}
	public int getHab() {
		return hab;
	}
	public void setHab(int hab) {
		this.hab = hab;
	}
	public int getDgc() {
		return dgc;
	}
	public void setDgc(int dgc) {
		this.dgc = dgc;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public int getCt() {
		return ct;
	}
	public void setCt(int ct) {
		this.ct = ct;
	}
	

	
}
