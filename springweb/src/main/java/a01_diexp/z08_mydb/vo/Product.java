package a01_diexp.z08_mydb.vo;

public class Product {
	private String name;
	private int price;
	private int bcnt;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int price, int bcnt) {
		this.name = name;
		this.price = price;
		this.bcnt = bcnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBcnt() {
		return bcnt;
	}
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	
	
}
