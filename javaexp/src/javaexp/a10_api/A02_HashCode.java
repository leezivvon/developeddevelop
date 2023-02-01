package javaexp.a10_api;

public class A02_HashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# hash code 로 객체 동등 여부 체크
		// 주소값이 다르더라도 속성이 같은지 .hashCode()
		메모리 주소값
		*/
		Person p01 = new Person();
		Person p02 = new Person();
		Person p03 = p01;
		System.out.println("p01.hashcode(): "+p01.hashCode());
		System.out.println("p02.hashcode(): "+p02.hashCode());
		System.out.println("p03.hashcode(): "+p03.hashCode());
		// 주소값이 같을 때 확인
		
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		Student s3 = new Student(2, "김길동");
		System.out.println(s1); // 참조변수는 toString에 대한 내용..?
		System.out.println(s2); 
		
		System.out.println("주소값이 같은지 여부: "+(s1==s2));
		System.out.println("속성이 같은지 여부s1,s2 : "+(s1.hashCode()==s2.hashCode()));
		System.out.println("속성이 같은지 여부s1,s3 : "+(s1.hashCode()==s3.hashCode()));
		

		//ex Product로 물건명 가격을 설정하고 hashCode를 재정의하여 값이 동일할 때 true로 처리되게 하세요
		Product p1 = new Product("막걸리", 9000);
		Product p2 = new Product("메이플콘", 3000);
		Product p3 = new Product("막걸리", 9000);
		
		System.out.println("주소값 비교: "+(p1==p2));
		System.out.println("주소값 비교: "+(p1==p3));
		System.out.println(p1.hashCode()); // 유니코드
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		System.out.println("속성 비교: "+(p1.hashCode()==p2.hashCode()));
		System.out.println("속성 비교: "+(p1.hashCode()==p3.hashCode()));
		
	}
}
//ex
class Product{
	private String name;
	private int price;
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	// 자바의 모든 객체의 최상위 객체인 Object가 가지고 있는 기능메서드 hashCode를 재정의하여 
	// 속성값이 같은지 여부를 check할 수 있게 리턴 처리
	public int hashCode() {
		// 속성(이름의 hash코드값+price의 값 합산)
		int code = name.hashCode() + price;
		return code;
	}	
}


class Person extends Object{
		
}
class Student{
	private int no;
	private String name;
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	@Override
	public int hashCode() {
		// 속성 no와 name의 hash코드 즉, 주소값을 리턴
		int hashCode = no + name.hashCode();
		return hashCode;
	}
	
}
