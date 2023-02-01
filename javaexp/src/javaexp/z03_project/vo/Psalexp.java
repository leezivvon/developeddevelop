package javaexp.z03_project.vo;

public class Psalexp {
	private String ef;
	private String empno;
	private int sal;
	private int sevpay;
	private int ysal;
	
	private String expno;
	private String expkind;
	private int extrapay;
	private int summ;
	private String schexpno;
	public Psalexp() {

	}
	// 급여 등록
//	public Psalexp(String empno, int sal, int sevpay) {
//		this.empno = empno;
//		this.sal = sal;
//		this.sevpay = sevpay;
//	}
	// 급여 조회
	public Psalexp(String ef, int sal, int ysal) {
		this.ef = ef;
		this.sal = sal;
		this.ysal = ysal;
	}
	
	
	
	// 수당 등록
	public Psalexp(String empno, String expno, String expkind, int extrapay) {
		this.empno = empno;
		this.expno = expno;
		this.expkind = expkind;
		this.extrapay = extrapay;
	}
	// 수당 조회
	public Psalexp(String expkind, int summ) {
		this.expkind = expkind;
		this.summ = summ;
	}
	

	public String getEf() {
		return ef;
	}
	public void setEf(String ef) {
		this.ef = ef;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getSevpay() {
		return sevpay;
	}
	public void setSevpay(int sevpay) {
		this.sevpay = sevpay;
	}
	public int getYsal() {
		return ysal;
	}
	public void setYsal(int ysal) {
		this.ysal = ysal;
	}
	public String getExpno() {
		return expno;
	}
	public void setExpno(String expno) {
		this.expno = expno;
	}
	public String getExpkind() {
		return expkind;
	}
	public void setExpkind(String expkind) {
		this.expkind = expkind;
	}
	public int getExtrapay() {
		return extrapay;
	}
	public void setExtrapay(int extrapay) {
		this.extrapay = extrapay;
	}
	public int getSumm() {
		return summ;
	}
	public void setSumm(int summ) {
		this.summ = summ;
	}
	public String getSchexpno() {
		return schexpno;
	}
	public void setSchexpno(String schexpno) {
		this.schexpno = schexpno;
	}


	
	
}
