package a01_diexp.z01_vo;

import java.util.List;

public class ShoppingMall {
	private String sname;
	private List<Member> mlist;
	public ShoppingMall() {
		// TODO Auto-generated constructor stub
	}
	public ShoppingMall(String sname) {
		this.sname = sname;
	}
	public void showMemberList() {
		System.out.println("@@@  "+sname+"회원리스트  @@@");
		if(mlist!=null && mlist.size()>0) {
			System.out.println("아이디\t비밀번호\t이름\t권한\t포인트");
			for(Member m:mlist) {
				System.out.print(m.getId()+"\t");
				System.out.print(m.getPass()+"\t");
				System.out.print(m.getName()+"\t");
				System.out.print(m.getAuth()+"\t");
				System.out.println(m.getPoint());
			}
		}else {
			System.out.println("등록된 회원이 없네요");
		}
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<Member> getMlist() {
		return mlist;
	}
	public void setMlist(List<Member> mlist) {
		this.mlist = mlist;
	}
	
	
	
}
