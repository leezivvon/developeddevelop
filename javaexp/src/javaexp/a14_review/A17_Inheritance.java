package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A17_Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Worker w1 = new PoliceMan();	w1.working(); // 다양한 하위 형태를 변형되어 처리
		 Worker w2 = new FireMan(); w2.working();
		 
		 // 1단계
		 Book b1 = new ComputerBook();
		 b1.read();
		 Book b2 = new CookBook();
		 b2.read();
		 // 2단계
		 // List<상위> list
		 // list.add( new 하위() )
		 List<Book> list = new ArrayList<Book>();
		 list.add(new ComputerBook());
		 list.add(new CookBook());
		 list.get(0).read(); //  ComputerBook의 내용 처리
		 list.get(1).read(); //  CookBooke 내용 처리
		 for(Book bk : list) { 	// 향상된 for문을 통해 단일 : 다중객체 선언
			 bk.read();			// 각각 단위 객체의 read() 메서드 호출 처리
		 }
		 
		 
		 // ex) 상위를 Book() read() 책을 읽다
//		 		하위 ComputerBook() read() 컴퓨터관련 내용 읽습니다
//		 		하위 CookBook() read() 요리관련 내용 읽습니다
//		 		다형성으로 해당 객체의 read()를 호출하여 출력하세요
		 
	}
}
class Book{
	void read() {
		System.out.println("책을 읽다");
	}
}
class ComputerBook extends Book{
	void read() {
		System.out.println("컴퓨터 관련 내용을 읽습니다");
	}
}
class CookBook extends Book{
	void read() {
		System.out.println("요리 관련 내용을 읽습니다");
	}
}

/*
# 상속
1. 다형성
	같은 타입이지만 실행 결과가 다양한 객체를 대입할 수 있는 성질
	- 부모 타입에는 모든 자식 객체가 대입
	- 인터페이스 타입에는 모든 구현 객체가 대입
	효과
	- 객체를 부품화시키는 것이 가능
	- 유지보수가 용이하다
2. 추상클래스
3. 인터페이스	
*/
// Main(
// 상위객체.메서드() : 하위객체의 재정의된 내용을 처리한다
// Worker w1 = new PoliceMan();	w1.working(); 다양한 하위 형태를 변형되어 처리
// Worker w2 = new FireMan(); w2.working();
/*
# 상속관계에 새로운 필요성
1. 상위객체는 주로 사용하지 않고 하위객체에 구체적인 기능메서드만 사용
	==> 상위에 있는 메서드를 구체적으로 할 필요 없음 
	==> 추상적 메서드 처리
2. 재정의하는 메서드명이 혹 실수로 다른 메서드를 사용하는 부분에 대하여 컴파일로 엄격하게 check할 필요성이 있음
	==> 상위에 있는 재정할 메서드를 추상메서드를 선언함으로 하위에 반드시 재정의하게 함
	==> 위 내용을 다 처리하고 다형성을 처리하는 새로운 solution이 생김 
	==> 이게 추.상.클.래.스
	
	
	Larba  vs Dron/Zerggling/Hydra 
	공통메서드: 이동하다 
	재정의메서드: 공격하다
	1단계) 기본 상속
	2단계) 추상클래스 상속
	
	
	
*/



abstract class Worker{
	public void goWork() {
		System.out.println("출근하다"); // 공통으로 사용할 메서드
	}
	abstract void working() ; // 하위에서 재정의해서 다양하게 사용할 메서드
}

class PoliceMan extends Worker {
	void working() {
		System.out.println("경찰이 도둑을 잡습니다");
	} // 추상 메서드를 재정의하지 않으면 에러 발생
}

class FireMan extends Worker {
	void working() {
		System.out.println("소방관이 화재진압을 합니다");
	}
}