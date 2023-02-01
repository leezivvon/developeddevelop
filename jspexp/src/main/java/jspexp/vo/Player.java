package jspexp.vo;
// jspexp.vo.Player
public class Player {
	private String tname;
	private String pname;
	private double score;
	public Player() {

	}
	public Player(String tname, String pname, double score) {
		this.tname = tname;
		this.pname = pname;
		this.score = score;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
