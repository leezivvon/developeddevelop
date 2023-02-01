package javaexp.a06_object;

public class A09_StaticMember {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 인스턴스 멤버란?
		1. 객체(인스턴스)마다 가지고 있는 필드와 메소드
		   - 이들은 각각 인스턴스 필드, 인스턴스 메소드라고 부른다
		   >> 객체가 생성된 후에 사용할 수 있는 객체 소속 멤버
		2. 인스턴스 멤버는 객체 소속된 멤버이기 때문에 객체가 없이 사용불가능하다 
		3. this
		    객체(인스턴스) 자신의 참조(번지)를 가지는 키워드
		    객체 내부에서 인스턴스 멤버임을 명확히 하기 위해 this.사용
		    매개변수와 필드명이 동일할 때 인스턴스 필드임을 명확히 하기 위해 사용  
		*/
		Car01 c1 = new Car01(20);
		c1.gas = 10; // 객체별로 다른 필드와
		c1.setSpeed(100); //객체별로 다른 메소드의 매개값을 넘긴다
		                  // 이것을 인스턴스 멤버라고 한다
		
		Car01 c2 = new Car01(30);
		c2.gas = 20; // 객체별로 다른 필드와
		c2.setSpeed(200); //객체별로 다른 메소드의 매개값을 넘긴다
		                  // 이것을 인스턴스 멤버라고 한다
		
		
		/*
		# 정적 멤버와 static
		1.  정적(static) 멤버란?
		    1) 클래스에 고정된 필드와 메서드 - 정적 필드, 정적 메서드 를 이야기함
		       >> 객체의 공유메모리, 클래스 소속 멤버, 객체 생성 없이 사용가능, 클래스명.멤버 = 데이터;
		    2) 정적 멤버는 클래스에 소속된 멤버(=객체의 공유메모리를 취급
		        - 객체 내부에 존재하지 않고 메소드 영역에 존재
		        - 정적 멤버ㄴ은 객체를 생성하지 않고 클래스로 바로 접근해 사용ㅊ
		2. 정적 멤버 선언
		    1) 필드 또는 메소드 선언할 때, static 키워드 붙은
		        class 클래스{
		            static 타입 필드;
		            static 리턴타입 메소드명(매개변수){}
		cf) 클래스를 통해서 만들어지는 객체들은 다른 조소에 실제 메모리를 가지고 사용한다
		    롯데월드타워 도면으로 서울, 부산, 제주도에 빌딩을 짓는다고 가정하면
		    롯데월드 타워도면 : 클래스,  각 지역에 실제 만들어진 빌딩 : 객체
		    건축비용 : 도면 비용 +(자재비용+인건비+부지비용)
		       자재 비용, 인건비, 부지비용 각 위치에 따라 다르게 설정
		       ==> 객체의 instance 변수는 다르게 설정할 수 있따
		       도면 비용은 건축물의 위치에 상관없이 일정한 비용이 든다
		       ==> 객체의 static변수는 특정한 클래스에서 생성된 객체에서 동일하게 사용할 수 있따
		           객체가 공유하는 필드이기에 class 변수라고 한다
		           참조변수.static변수 ==> 클래스명.static변수                    
		
		*/
		BuildingLotte.drawingPay = 3000000; // 객체 생성전에 클래스명.static변수로 사용가능 
		BuildingLotte b01 = new BuildingLotte("서울", 1000000);
//		BuildingLotte.drawingPay = 3000000; 
//		b01.drawingPay += 10000;  사용 가능하지만 의미없다
		
		BuildingLotte b02 = new BuildingLotte("부산", 1200000);
		b01.showInfo();
		b02.showInfo();
		BuildingLotte.drawingPay += 100000; // 객체 b01,b02에도 변경 // 도면 비용은 동시에 변경
		b01.showInfo();
		b02.showInfo();
		
		
		// ex
		BankAccount.totBal = 200000; //static 변수는 객체 생성없이 객체의 공유 메모리 설정 // 초기값
		BankAccount ba01 = new BankAccount ("농협",10000);
		BankAccount ba02 = new BankAccount ("신한",12000);
		BankAccount ba03 = new BankAccount ("국민",13000);
		ba01.savingMoney(1000);
		ba02.savingMoney(2000);
		ba03.savingMoney(3000);
//		BankAccount.totBal +=
		
	

	}
}
// ex BankAccount 클래스를 선언하고 필드로( 계좌명, 계좌별잔액 )- 인스턴스변수, 
//    (모든 계좌의 총액)-static변수를 선언하여 데이터로 확인하세요


class BankAccount{
	String aname;
	int balance;  // 객체에 종속된 변수 인스턴스 변수
	static int totBal; // 객체에 종속되지 않ㄴ느 변수
	
	public BankAccount (String aname, int balance) {
		super();
		this.aname=aname;
		this.balance=balance;
		totBal+=balance; // 모든 객체의 공유변수로 사용할 수 있게 
		                 // 클래스 소속이기 때문에 this.굳이사용X
		
		System.out.println(aname+"계좌 개설! 초기금액: "+ this.balance);
		System.out.println("은행 전계좌 잔액: "+totBal);
	}
	void savingMoney(int money) {
		this.balance+=money;
		totBal+=money;
		System.out.println("계좌: "+aname);
		System.out.println("계좌 잔고: "+ this.balance);
		System.out.println("은행 잔고: "+ totBal);
	}
//	void showInfo(){
//		System.out.print(aname+"에 남은 계좌 잔액: ");
//		System.out.println(balance);
//	}
//	void showTot() {
//		tot+=this.balance;
//	}
}



class BuildingLotte{
	String loc; // instance 변수 - 위치
	int siteCost; // instance 변수 - 부지비용
	static int drawingPay; // static변수 - 도면 비용
	
	public BuildingLotte(String loc, int siteCost) {
		this.loc =loc;
		this.siteCost = siteCost;
	}
	void showInfo() {
		System.out.println(loc+"에 있는 롯데월드 타워");
		System.out.println("도면비용: "+drawingPay);
		System.out.println("부지비용: "+siteCost);
	}
}


class Car01{
	int gas;
	public Car01(int gas) {
		this.gas=gas;
	}
	void setSpeed(int speed) {}
	
}
