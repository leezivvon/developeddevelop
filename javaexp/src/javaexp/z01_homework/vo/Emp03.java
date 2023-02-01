package javaexp.z01_homework.vo;

public class Emp03 {

	private String ename; // 출력할 내용
	private int empno;
	private String div2;
	private double sal;
	private String bonus_per;
	private int bonus;
	private int totpay;
	public Emp03() {
		// 디폴트 생성자
	}
	public Emp03(String ename, int empno, String div2, double sal, String bonus_per, int bonus, int totpay) {
		this.ename = ename;
		this.empno = empno;
		this.div2 = div2;
		this.sal = sal;
		this.bonus_per = bonus_per;
		this.bonus = bonus;
		this.totpay = totpay;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getDiv2() {
		return div2;
	}
	public void setDiv2(String div2) {
		this.div2 = div2;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getBonus_per() {
		return bonus_per;
	}
	public void setBonus_per(String bonus_per) {
		this.bonus_per = bonus_per;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getTotpay() {
		return totpay;
	}
	public void setTotpay(int totpay) {
		this.totpay = totpay;
	}
	
	
	
}
