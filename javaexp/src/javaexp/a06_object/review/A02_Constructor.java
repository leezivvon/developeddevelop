package javaexp.a06_object.review;

public class A02_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 생성자 overloading
		1. 생성자를 선언할 수 있는 규칙을 말한다 - 메서드 오버로딩 규칙과 동일
		2. 규칙
		    1) 매개변수의 *개수가 다를 때
		    2) 매개변수의 개수가 같더라도 *타입이 다를 때
		    3) 매개변수의 개수가 같고 타입이 같더라도 타입이 선언된 *순서가 다를 때 
		*/
		
		// ex) BasePlayer 클래스를 선언하고 팀명, 이름, 타율을 필드로 선언하고
		//     생성자를 통해서 팀명과 이름을 초기화하고 출력하세요
		// 생성자는 필드값을 초기화
		
		BasePlayer bp1 = new BasePlayer();
		System.out.println("# 입력 없는 초기값 #");
		System.out.println("팀명: "+bp1.teamName);
		System.out.println("이름: "+bp1.playerName);
		System.out.println("타율:"+bp1.ratio);
		
		BasePlayer bp2 = new BasePlayer("두산","박찬호");
		System.out.println("# 매개변수 있는 초기값 #");
		System.out.println("팀명: "+bp2.teamName);
		System.out.println("이름: "+bp2.playerName);
		System.out.println("타율:"+bp2.ratio);
		
		// ex) 물건클래스에 필드로 물건명,가격, 개수를 선언하되 
		//     오버로딩 규칙에 의해서 생성자를 선언해 보세요
		Product p1 = new Product("땅콩잼");
		System.out.println("제품명: "+p1.name);
		System.out.println("개수 :"+p1.cnt);
		
		Product p2 = new Product(5);
		System.out.println("제품명: "+p2.name);
		System.out.println("개수 :"+p2.cnt);
		
		Product p3 = new Product("딸기",10);
		System.out.println("제품명: "+p3.name);
		System.out.println("개수 :"+p3.cnt);
	}

}
/*
class Product {
	String name;
	int cnt;
	Product(String name){
		this.name=name;
	}
	Product(int cnt){
//		this(); //매개변수가 없는 생성자를 선언해야 사용 가능
		this.cnt=cnt;
	}
	Product(String name, int cnt){
		this.name=name;
		this.cnt=cnt;
	}
}
*/
class Product {
	String name;
	int price;
	int cnt;
	Product(){
		this.name = ""; // 의미없다
	}
	//  개수
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	//  타입
	Product(int price, int cnt){
		// name은 매개변수로 선언안했는데 
//		this(); // 상위에 있는 생성자를 호출하는데 
//		this(매개변수); // ()안에 있는 매개변수에 따라서 호출하는 생성자가 달라짐
		this();// 정의된 생성자를 호출할 때 사용
		this.price = price;
		this.cnt = cnt;
	}	
	// 순서가 다른(타입이 다를 때만 가능)
	Product(int price, String name){
		this.name = name;
		this.price = price;
	}
	}
}


class BasePlayer {
	String teamName;  // 필드에 선언
	String playerName;
	double ratio;
	BasePlayer(){
		// 매개변수없이
		// 외부입력없이 초기화
		this.teamName = ""; // 공백값으로 두려고 할때 // String은 default 초기값 null 
		this.playerName = "";
	}
	BasePlayer(String teamName, String playerName){
		this.teamName = teamName; // 외부입력에 의해서 데이터 결정
		this.playerName = playerName;
	}
	BasePlayer(String teamName, double ratio){ // 매개변수 두개지만 
		this.teamName = teamName;
		this.ratio = ratio;
	}
	// 클래스 내에는 오버로딩 규칙에 의해 여러 생성자를 선언할 수 있고 
	// 객체를 생성할 때는 이중에 하나만 사용하여 처리할 수 있다
	// BasePlayer b1 = new BasePlayer("해태",0.275);
}