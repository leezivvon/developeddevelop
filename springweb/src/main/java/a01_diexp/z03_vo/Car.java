package a01_diexp.z03_vo;

public class Car {
	private String name;
	private int maxSpeed;
	
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String name, int maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
}
