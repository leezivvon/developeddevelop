package springweb.z01_vo;

//springweb.z01_vo.Product
public class Product {
	private String pname;
	private int price;
	private int pcnt;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String pname, int price, int pcnt) {
		this.pname = pname;
		this.price = price;
		this.pcnt = pcnt;
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
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	
	
}
