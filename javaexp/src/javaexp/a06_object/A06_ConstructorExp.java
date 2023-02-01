package javaexp.a06_object;

public class A06_ConstructorExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		
		Fruit f01 = new Fruit("포도",10); 
		Book99 b9 = new Book99("아픔이 길이 된다면","민음사");
		Mouse m01 = new Mouse("m-19","로지텍");
		Taxi t01 = new Taxi("전주","아반떼");
*/
		Fruit f01 = new Fruit("포도",10); 
		Book99 b99 = new Book99("아픔이 길이 된다면","민음사");
		Mouse m01 = new Mouse("m-19","로지텍");
		Taxi t01 = new Taxi("전주","아반떼");
	}
}
/*
# 아래의 필드값을 초기화하는 생성자를 선언하고 생성자 안에서 필드값을 출력하는 클래스를 정의 및 호출하세요
 과일(종류,개수), 도서99(도서면, 출판사), 마우스(이름, 제조사), 택시(지역,차종)
*/
class Fruit {
	String kind;
	int cnt;  // 필드값 선언하고
	Fruit(String kind, int cnt){
		this.kind= kind;
		this.cnt = cnt;
		System.out.println("과일객체 생성"); // 바로 출력
		System.out.println("종류: "+kind);
		System.out.println("개수: "+cnt);
	}
}
class Book99 {
	String title;
	String publisher;
	Book99(String title, String publisher){
		this.title= title;
		this.publisher = publisher;
		System.out.println("도서객체 생성");
		System.out.println("도서명: "+title);
		System.out.println("출판사: "+publisher);
	}
}
class Mouse {
	String nm;
	String co;
	Mouse(String nm, String co){
		System.out.println("마우스 객체 생성");
		System.out.println("마우스 종류: "+nm);
		System.out.println("마우스 제조사: "+co);
	}
}
class Taxi {
	String loc; 
	String kind;
	Taxi(String loc, String kind){
		System.out.println("택시 객체 생성");
		System.out.println("운행지역: "+loc);
		System.out.println("차종: "+kind);
	}
}



/*
class Fruit {
	String type;
	int cnt;
	Fruit(String type, int cnt){
		this.type="복숭아";
		this.cnt = 5;
		System.out.println("과일: "+ type +", "+ cnt);
	}
}
class Book99 {
	String bn;
	String co;
	Book99(String bn, String co){
		System.out.println("도서: "+bn+", "+co);
	}
}
class Mouse {
	String nm;
	String co;
	Mouse(String nm, String co){
		System.out.println("마우스: "+nm+", "+co);
	}
}
class Taxi {
	String contry;
	String typeCar;
	Taxi(String contry, String typeCar){
		System.out.println("택시: "+contry+", "+typeCar);
	}
}
*/