package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A01_One_Multi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
1:다   : DB에서 데이처를 가져와서 한 화면에 출력하거나 사용할 때 주로 사용되는 형식
		하나의 객체 안에서 다중으로 여러개의 객체를 사용하는 것을 말한다
		# 유형
		1) 하나의 객체 안에서 하나타입의 여러 객체
			ex) 마트에 물건리스트
		2) 하나의 객체안에서 여러 개의 객체들
			ex) 쇼핑몰 안에 구매물품리스트와 회원리스트
		3) **하나의 객체 안에서 추상클래스로 정의된 여러개의 객체를 할당할 수 있게 선언
			ex) 컴퓨터 객체 안에 부품리스트를 추상클래스를 상속받은 하위 실제부품을 가지는 형태로 
				다형성이 처리된 내용을 할당하는 객체
			class Computer{
				private String comp;
				private List<Part> parts;
			}
			abstract class Part{
				String kind;
				abstract void showInfo();
			}
			class Cpu extends Part{
				void showInfo(){
					kind+"는 성능은 코어가 @@개이고 처리 속도가 @@이다"
				}
			}
			class Ram extends Part{
				void showInfo(){
					kind+"는 @@ 메모리를 갖고 있고 전송 bus속도는 @@이다"
				}
			}
			
			
			
# 1 대 다 관계 객체 구조
1. 하나의 클래스 안에 여러 개의 선언된 클래스를 객체를 호출하여 궁극적으로 하나의 객체 안에 여러개의 객체를 사용할 수 있는 구조로 처리하는 형태를 말한다
2. 단계별 구조에 대한 이해
	1) 단순 1:다 관계
		ex) 마트에 파는 여러가지 물건
	2) 여러개의 다중 객체가 포함되어 있는 경우
		ex) 온라인 쇼핑몰의 여러회원과 여러가지 물품
	3) 추상클래스를 상속받은 클래스에 생성되는 다중의 객체를 선언하여 사용하는 경우	
		ex) 컴퓨터엥서 부품이라는 추상클래스에서 상속받은 하위의 여러 실체클래스를 
			관계로 선언하여 할당하는 경우
*/	
		
		// # 단순 1:다 관계
		Mart m1 = new Mart("행복마트");
		m1.addCart(new Product("사과",2000,2));
		m1.addCart(new Product("바나나",4000,3));
		m1.addCart(new Product("딸기",12000,3));
		m1.calcuList();
		
		
		//ex) Player : 이름 성적 ==> Team 팀명, List<Player>  addPlayer, showPlayerList()
		Team t1 = new Team("두산 베어스");
		t1.addPlayer(new Team());
		
	}
}
// ex) Player
class Team{
	private String tname;
	private List<Player> list;
	public Team() {

	}
	public Team(String tname) {
		this.tname = tname;
		list = new ArrayList<Player>(); // 1 대 다 관계로 객체를 생성
	}
	
	public void addPlayer(Player player) {// list에 등록하는 기능메서드
		System.out.println(player.getPname()+"선수 등록");
		list.add(player);
		System.out.println("팅의 선수 수 : "+list.size());
	}
	public void showPlayList() {
		System.out.println(tname+"팀 소속 선수 명단");
		for(Player p : list) {
			System.out.println(p.getPname()+"\t");
			System.out.println(p.getScore()+"\n");
		}
		
	}
}

class Player{
	private String pname;
	private int score;
	public Player() {

	}
	public Player(String pname, int score) {
		this.pname = pname;
		this.score = score;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}


// # 단순 1:다 관계
class Mart{
	private String mname;
	private List<Product> list;
	public Mart() {

	}
	public Mart(String mname) {
		this.mname = mname;
		list = new ArrayList<Product>();
	}
	public void addCart(Product prod) {
		System.out.println("장바구니 담기"+prod.getName());
		list.add(prod);
		System.out.println("현재 담기 물건 개수: "+list.size());
	}
	public void calcuList() {
		System.out.println(mname+"의 계산대에서!!");
		int tot = 0;
		for(Product p :list) {
			tot +=p.showInfo(); // return값이 누적해서 합산
		}
		System.out.println("총 비용:"+tot);
	}	
}

class Product{
	private String name;
	private int price;
	private int cnt;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	public int showInfo() {
		System.out.print(name+"\t");
		System.out.print(price+"\t");
		System.out.print(cnt+"\t");
		System.out.print(price*cnt+"\n");
		return price*cnt;
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



