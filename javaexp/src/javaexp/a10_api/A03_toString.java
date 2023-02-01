package javaexp.a10_api;

class Food{
	// 재정의 
	public String toString() {
		return "toStirng() : 참조변수만 호출";
	}
}

public class A03_toString {

	public static void main(String[] args) {
		Food f = new Food();
		System.out.println(f);
		// 
		/*
		# toString()	
		1. 클래스의 패키지와 클래스명 + 16진수 주소를 리턴
		2. 참조변수만 호출 했을 때 나타나는 데이터와 동일하다
		3. toString() 재정의하면 참조변수도 동일한 값으로 변경이 된다
		*/
		Player p1 = new Player("홍길동",0.342);
		Player p2 = new Player("홍길동",0.342);
		Player p3 = new Player("김길동",0.342);
		System.out.println(p1);
		System.out.println(p1.toString());
		System.out.println(p2);
		System.out.println(p3);
		System.out.println("p1==p2: "+(p1==p2));
		System.out.println("p1==p3: "+(p1==p3));
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		// ex Music에 음악명 가수명을 속성으로 선언하고 toString()을 재정의하여 참조값으로 확인되게 하세요
		System.out.println("# toString()처리 #");
		Music m1 = new Music("아이유", "밤편지");
		Music m2 = new Music("태연", "사계");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));
	}
}
class Music{
	private String sname;
	private String stitle;
	public Music(String sname, String stitle) {
		this.sname = sname;
		this.stitle = stitle;	
	}
	@Override
	//재정의
	public String toString() {
		return this.sname+"의 대표곡 "+this.stitle;
	}
	
}

class Player{
	private String name;
	private double record;
	public Player(String name, double record) {
		this.name = name;
		this.record = record;
	}

	@Override
	public String toString() {
		return this.name+" : "+this.record;
	}
	
	
}
