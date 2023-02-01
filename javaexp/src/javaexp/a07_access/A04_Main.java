package javaexp.a07_access;

public class A04_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 선언한 vo class 를  main()에서 호출하여 사용한다  // vo class 가뭐야,,,?
		// 같은 패키지에 있는 클래스는 import를 하지 않아도 된다.
		A01_Person p01 = new A01_Person(); 
		A01_Person p02 = new A01_Person("홍길동",25,"서울"); 
//		System.out.println(p01.name); 필드의 접근제어자 private
		System.out.println(p02.getName()); //public

	}

}
