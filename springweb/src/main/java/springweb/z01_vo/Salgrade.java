package springweb.z01_vo;

public class Salgrade {

	private int grade;
	private int losal;
	private int hisal;
	private int strgrade;
	private int fingrade;
	
	public Salgrade() {
		// TODO Auto-generated constructor stub
	}
	public Salgrade(int grade, int losal, int hisal) {
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
	}
	public Salgrade(int strgrade, int fingrade) {
		this.strgrade = strgrade;
		this.fingrade = fingrade;
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLosal() {
		return losal;
	}
	public void setLosal(int losal) {
		this.losal = losal;
	}
	public int getHisal() {
		return hisal;
	}
	public void setHisal(int hisal) {
		this.hisal = hisal;
	}
	public int getStrgrade() {
		return strgrade;
	}
	public void setStrgrade(int strgrade) {
		this.strgrade = strgrade;
	}
	public int getFingrade() {
		return fingrade;
	}
	public void setFingrade(int fingrade) {
		this.fingrade = fingrade;
	}
	
	
	
}
