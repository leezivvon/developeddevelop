package jspexp.vo;
// jspexp.vo.Product

public class Product {
	String pname;
	int price;
	int cnt;
	public Product() {

	}
	public Product(String pname, int price, int cnt) {
		this.pname = pname;
		this.price = price;
		this.cnt = cnt;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
