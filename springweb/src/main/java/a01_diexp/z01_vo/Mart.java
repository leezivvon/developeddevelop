package a01_diexp.z01_vo;

import java.util.List;

public class Mart {
	private String mname;
	private List<Product> plist;
	
	//defalut생성자는 반드시 생성해야 함
	public Mart() {
		// TODO Auto-generated constructor stub
	}

	public Mart(String mname) {
		this.mname = mname;
	}
	public void buyList() {
		System.out.println(mname+" 구매한 목록");
		if(plist!=null && plist.size()>0) {
			System.out.println("물건명\t가격\t개수");
			for(Product p:plist) {
				System.out.print(p.getPname()+"\t");
				System.out.print(p.getPrice()+"\t");
				System.out.println(p.getPcnt()+"\t");
			}
		}else {
			System.out.println("구매한 물건이 없네요");
		}
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlsit(List<Product> plist) {
		this.plist = plist;
	}
	
	
	
	

}
