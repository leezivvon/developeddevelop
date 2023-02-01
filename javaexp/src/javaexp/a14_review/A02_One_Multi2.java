package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A02_One_Multi2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
1 대 다 관계 (2단계)
1. 쇼핑몰에서 회원리스트의 판매리스트, 구매리스트 처리


# 개발 순서
1. 일단, List형의 단일 객체 선언하기
	회원클래스 ==> 회원리스트
	물품클래스 ==> 판매물품리스트, 구매물품리스트
2. 필드 선언 및 생성자를 통한 초기화
3. 기능메서드 처리
	1) 물품 등록 메서드
	2) 등록된 물품 조회 메서드
	3) 구매 선택 메서드
	4) 구매된 내용 리스트 메서드
*/
class ShoppingMall{
	private String smname;
	private List<Member> mlist;
	private List<SProduct> slist;
	private List<SProduct> blist;
	public ShoppingMall() {
		// TODO Auto-generated constructor stub
	}
	public ShoppingMall(String smname) {
		this.smname = smname;
		mlist = new ArrayList<Member>();
		slist = new ArrayList<SProduct>();
		blist = new ArrayList<SProduct>();
	}
	public void regMember(Member m) {
		System.out.println(m.getId()+"님 쇼핑몰에 회원가입");
		mlist.add(m);
		System.out.println("현재 회원수: "+mlist.size());
	}
	public void addSellProduct(SProduct p) {
		System.out.println(p.getName()+" 관리자에 의한 물건 등록");
		slist.add(p);
		System.out.println("현대 등록된 회원 수:"+slist.size());
	}
	public void buyProduct(SProduct p) {
		System.out.println(p.getName()+"구매자에 의한 구매 리스트에 등록");
		blist.add(p);
		System.out.println("현재 구매한 뭂품 수 :"+blist.size());
	}
}
class SProduct {
	private String name;
	private int price;
	private int cnt;
	
	public SProduct() {
		// TODO Auto-generated constructor stub
	}
	public SProduct(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}	
}

class Member{
	private String id;
	private String pass;
	private String name;
	private String auth;
	private int point;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String pass, String name, String auth, int point) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.auth = auth;
		this.point = point;
	}
	public void showInfo() {
		System.out.print(id+"\t");
		System.out.print(name+"\t");
		System.out.print(auth+"\t");
		System.out.print(point+"\n");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}

