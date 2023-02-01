package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A08_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("인터페이스의 구성요소 사용");

		System.out.println("1. 바로 사용이 가능한 것");
		System.out.println(FlyWay.title);
		FlyWay.goMz();
		System.out.println("2. 하위 클래스에 의해서 사용이 가능한 것");
		FlyWay w1 = new Wing01(); 	// 다형성에 의해서 객체가 생성이 가능하다
		w1.remoteWing();	// 객체 생성 해야 사용가능 default 공통 메서드 사용
		w1.fly();			// 재정의된 추상 메서드 사용
		
		FlyWay w2 = new Wing02();	 w2.remoteWing(); 	w2.fly();
		FlyWay w3 = new Wing03();	 w3.remoteWing(); 	w3.fly();

		System.out.println("# 인터페이스 할당 list #");
		System.out.println(FlyWay.title);
		FlyWay.goMz();
		List<FlyWay> list = new ArrayList<FlyWay>();
		list.add(new Wing01());
		list.add(new Wing02());
		list.add(new Wing03());
		for(FlyWay fw : list) {
			fw.remoteWing();
			fw.fly();
		}

		
		
	}
}

/*
# 인터페이스란
1. 개발 코드와 객체가 서로 통신하는 접점
	1) 개발 코드는 인터페이스의 메소드만 알고 있으면 된다
2. 인터페이스 역할
	1) 개발 코드가 객체에 종속되지 않게 즉 객체 교체할 수 있도록 하는 역할
	2) 개발 코드 변경없이 리턴값 또는 실행 내용이 다향해 질 수 있음(다형성)
3. 인터페이스의 선언
	1) 인터페이스 이름 - 자바 식별자 작성 규칙에 따라 작성
	2) 소스파일 생성 - 인터페이스 이름과 대소문자가 동일한 소스 파일 생성
	3) 인터페이스 선언 - [public] interface 인터페이스명{}
	4) 인터페이스의 구성 멤버
		interface 인터페이스명 {
			타입 상수명 = 값;	// 상수
			타입 메서드명(매개변수..);			// 추상메서드
			default 타입 메소드명(매개변수..){}	
				// 디폴트 메서드 -	공통기능 메서드	 하위에서 객체의 참조값으로 사용(무조건)
			static 타입 메소드명(매개변수){}
				// 정적 메서드	  - 인터페이스명.기능메서드() 형태로 사용
		}
		# 선언하지 않더라도 자동으로 붙는 내용 : 컴파일 시 아래 내용이 코드에 없더라도 자동으로 붙게 처리된다
		- 일단 모든 멤버는 선언을 하지 않더라도 public이 자동으로 붙는다
		  public이 모든 멤버에 추가됨
		- 필드인 상수는 자동으로 static final이 붙는다 
			ex) int PI = 3.14;	==>	public static final int PI = 3.14;
				인터페이스명.PI로 활용가능
		- 추상메서드는 abstract가 붙는다
			ex) void call(); ==> public abstract void call();	
*/
/*
System.out.println("인터페이스의 구성요소 사용");

System.out.println("1. 바로 사용이 가능한 것");
System.out.println(FlyWay.title);
FlyWay.goMz();
System.out.println("2. 하위 클래스에 의해서 사용이 가능한 것");

*/

/*
인터페이스와 추상클래스
0. 추상내용을 재정의하여 사용한다는 내용, 다형성을 처리한다는 점에서는 같지만
1. 인터페이스의 구성메버인 4가지인 경우에 한정적으로 간편하게 사용할 경우에 사용되고
2. 추상클래스 인터페이스가 처리되는 것을 포함하여 다양하게 사용되는 경우에 활용된다
ps) 상속 > 추상클래스 > 인터페이스
	형식으로 상위 내용을 하위 내용을 포함하여 구현할 수 있지만 보다 특수한 경우에 효과적으로 사용하기 위해서 활용한다
*/
interface FlyWay{
	String title = "MZ의 날개"; // public static final이 자동으로 붙게 된다
	void fly();	// 하위에서 상속하여 재정의할 추상 메서드
	default void remoteWing() {
		System.out.println("원격 조정에 의해 날아간다(객체 공통)");
	}
	static void goMz() {
		System.out.println("MZ에 의해 날아가다(정적메서드)");
	}
}


// FlyWay w1 = new Wing01(); 	다형성에 의해서 객체가 생성이 가능하다
// w1.remoteWing();	// 객체 생성으로 사용가능 default 공통 메서드 사용
// w1.fly();		// 재정의된 추상 메서드 사용
class Wing01 implements FlyWay{
	// 추상메서드 재정의
	@Override
	public void fly() {
		System.out.println(title+"1호");
		System.out.println("우리 동네를 날다");	
	}
}
class Wing02 implements FlyWay{
	// 추상메서드 재정의
	@Override
	public void fly() {
		System.out.println(title+"2호");
		System.out.println("세계의 창공을 누비다");	
	}
}
class Wing03 implements FlyWay{
	// 추상메서드 재정의
	@Override
	public void fly() {
		System.out.println(title+"3호");
		System.out.println("로켁 엔진으로 우주를 날다");	
	}
}
