package javaexp.a05_restore;

public class A02_NullPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기본 데이터의 초기값 설정
		int num01;
//		System.out.println(num01);  초기화를 해야 사용 가능
		num01=0;     // 초기데이터를 0 : stack영역에
		System.out.println(num01);
		
		Person p01;
//		System.out.println(p01);
		p01= null;  //객체는 초기화를 stack 영역에 null로 선언
                    // heap영역의 객체는 생성되지 않았다
		
		//stack영역에 초기화 처리
		// 1. 기본유형: 각 데이터의 초기값으로 데이터 선언 - int num01 =0;
		// 2. 객체유형: null이라는 키워드로 stack영역에 초기화를 선언 - int[] array = null;
		//            !!주의!! 아직까지 heap영역에 실제 객체를 할당하지 않음
		
		System.out.println(p01);
		// 초기화를 했지만 실제 객체를 할당하지 않았음에도 불구하고 실제 객체가 있는 것과 동일하게 구성요소를 호출할 때 발생
		// NullPointerException
		// Pointer : heap 영역에 주소를 지칭
		// Null 실제 객체가 없음을 의미
		/*
		if(p01=null){ // 객체가 생성되어 heap영역에 주소에 있을 때 // error 벗어나기 위해서
		    p01.name
		}
		*/		
		// System.out.println(p01.age); 
		// java.lang.NullPonterError
		// 객체가 heap영역에 생성되지 않았을 때 
		// 구성요소를 호출하면 runtime error인 NullPointerException
//		ex) 도서관에 해당 번호에 있어야 할 자리에 책이 없음. 그 책의 50페이지를 확인하려는 것과 비유할 수 있다
		
		
		p01 = new Person(); // 객체가 heap영역에 생성된다
		System.out.println(p01);
		System.out.println(p01.age);
		p01.age=25;
		System.out.println(p01.age);
	
		// 모든 객체는 객체가 생성됨과 동시에 구성요소들이 초기화된다.
		// 숫자는 0, 객체(String포함) null
	}

}
class Person{   // 사용정의 class 선언
	int age; // class 구성요소
    double height;
    String name;
	
} 