package springweb.z01_vo;

public class Player {

	private String pname;
	private int hits;
	private int anta;
	private double hitRatio;
	
	/*
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(String pname, int hits, int anta) {
		this.pname = pname;
		this.hits = hits;
		this.anta = anta;
	}
	*/
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getAnta() {
		return anta;
	}
	public void setAnta(int anta) {
		this.anta = anta;
	}
	public double getHitRatio() {
		return hitRatio;
	}
	public void setHitRatio(double hitRatio) {
		this.hitRatio = hitRatio;
	}
	
	
	
}
