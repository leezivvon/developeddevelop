package javaexp.a06_object;

public class A02_Field {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 클래스의 구성 멤버
		1. 필드 : 객체의 데이터가 저장되는 곳
		2. 생성자 : 객체 생성시 초기화 역할 담당
		3. 메소드 : 객체의 동작에 해당하는 실행 블록
		
		#
		*/
		
		Baby b1 = new Baby("홍길동(아기)");
		System.out.println("이름: "+b1.name);
		b1.move();
		Baby b2 = new Baby("마길동(아기)");
		System.out.println("이름: "+b2.name);
		b2.move();
		
		/*
		1. 클래스(객체)의 전역변수 역할을 하는 클래스명 바로 밑에 선언하는 변수/상수를 말한다
		2. 데이터 유형
		    기본 데이터 유형
		    객체(문자열, 배열, 외부 선언된 객체, 내장된 객체 등등)
		3. 필드의 내용
		    객체의 고유 데이터
		    객체가 가져야 할 부품 객체
		    객체의 현재 상태 데이터
		    ex) 
		    현실 세계               자동차 클래스 
		    자동차                  class Car  
		        고유 데이터              
		            제작회사        String company;
		            모델           String model;
		            색깔           int maxSpeed
		        상태 
		            현재속도        int speed;
		            엔진회전수      int rpm;
		        부품 (외부객체) : 객체 안에 객체를 사용하여 조합적인 처리를 할 때. 
		            차체           Body body;
		            엔진           Engine engine;
		            타이어          Tire tire;
		 4. 필드의 사용
		    1) 필드는 초기에 할당된 경우
		    2) main()에서 할당해서 사용하는 경우
		    3) 생성자를 통해서 초기값 설정/생성자를 통해서 할당하는 경우
		*/
		Car c1 = new Car();             // 객체 생성 후
		System.out.println(c1.company); // 호출하여 사용
		
		c1.company = "삼성전자";
		System.out.println(c1.company);
		Car c2 = new Car("LG전자");  // 생성자를 통해서 필드 초기화
		System.out.println(c2.company);
		
		
		//ex1) Product 클래스를 선언하고 필드 물건명 가격 개수를 선언하되 위의 예제와같이 
		//     1) 초기에 할당한 경우
		//     2) main()에서 할당한 경우를 구분해서 할당하고 필드값을 출력하세요		==>클래스는 하나 객체는 두개
		
		Product p1 = new Product(); 
		System.out.println("초기에 할당된 데이터 호출"); // 1) 초기에 할당한 경우
		System.out.println("물건명: "+p1.proName);
		System.out.println("가격: "+p1.proPrice);
		System.out.println("개수: "+p1.proCnt);
		
		Product p2 = new Product(); // 2) main()에서 할당한 경우
		p2.proName = "볼펜"; p2.proPrice = 2000; p2.proCnt=5;
		System.out.println("main()에서 할당하여 호출하는 경우");
		System.out.println("물건명: "+p2.proName);
		System.out.println("가격: "+p2.proPrice);
		System.out.println("개수: "+p2.proCnt);
		
		Product p3 = new Product("샤인머스켓", 12000, 3); // 3) 생성자를 통해 초기화된 데이터 사용
		System.out.println("생성자를 통해 초기화된 데이터 사용");
		System.out.println("물건명: "+p3.proName);
		System.out.println("가격: "+p3.proPrice);
		System.out.println("개수: "+p3.proCnt);
	
		
		// ex2) Computer클래스 선언, 생성자를 통해서 제조사, CPU사양, 가격을 할당하게 하고 할당된 필드를 출력하게 하세요
		Computer01 c01 = new Computer01("LG", "I7 3.6GHZ", 1200000);
		System.out.println("제조사: "+c01.company);
		System.out.println("cpu사양: "+c01.cpu);
		System.out.println("가격: "+c01.price);
		
//		// ex3) Bus(최고속도, 탑승가능인원, 버스번호) 클래스 선언, 생성자를 통해서 필드를 초기화하고 출력..  
//		Bus bus01 = new Bus(200, 50, 05);
//		System.out.println("최고속도: "+bus01.fast+"km/h");
//		System.out.println("탑승가능인원: "+bus01.possibleCnt+"명");
//		System.out.println("버스번호: "+bus01.busNumber+"번");
		Bus bb1 = new Bus();
		System.out.println("초기 최대 속도: "+bb1.maxSpeed);
		bb1.maxPerson = 35;
		bb1.no = "8001";
		System.out.println("# 버스1의 정보 #");
		System.out.println("버스번호: "+bb1.no);    // default생성자로 
		System.out.println("버스최대속도: "+bb1.maxSpeed);
		System.out.println("버스최대인원: "+bb1.maxPerson);
		Bus bb2 = new Bus("M3001");
		
		System.out.println("# 버스2의 정보 #");
		System.out.println("버스번호: "+bb2.no);    // default생성자로 
		System.out.println("버스최대속도: "+bb2.maxSpeed);
		System.out.println("버스최대인원: "+bb2.maxPerson);
	}

}
class Bus{
	int maxSpeed =120;
	int maxPerson; // 할당하는
	String no;
	Bus(){} // 생성자 매개변수X
	Bus(String no){ // 생성자 매개변수1
		this.no =no;
	}
	Bus(String no, int maxSpeed, int maxPerson){
		this.no=no;
		this.maxSpeed = maxSpeed;
		this.maxPerson = maxSpeed;
		
	}
}


class Computer01 { // 같은 패키지 내에 동일한 이름의 클래스가 선언되면 에러 발생
	String company;
	String cpu;
	int price;
	Computer01(){} //  매개변수 없는 생성자 클래스는 여러 유형의 생성자를 선언할 수 있다.-매개변수가 다를 때..
	Computer01(String company, String cpu, int price) { // 매개변수가 3개 있는 생성자
		this.company = company;
		this.cpu = cpu;
		this.price = price;
	}
}

class Product {
	String proName = "필통";
	int proPrice = 5000;
	int proCnt = 2;
	Product(){} // 3) 생성자
	Product(String name, int price, int cnt){ //클래스명과동일(매개변수1, 매개변수2, 매개변수3)
		this.proName = name; //  proName 매개변수의 명과 필드의 이름이 동일한 경우 구분해주기 위해 this.를 붙여서 할당
		this.proPrice = price;
		this.proCnt = cnt;
	}
}


class Car {
	String company = "회사1";
	Car(){} // 기존 생성자 선언(매개변수 없음)
	Car(String company){
		this.company = company;
	}
	
}


class Baby{
	String name;  // 필드 : 객체의 구성요소의 모든 공간에 전연적으로 할당 및 호출이 가능한 데이터
	Baby(String name){
		this.name = name; // 생성자의 매개변수로 이름을 저장
		// 생성자
		System.out.println("생성자(이름저장)");
	}
	void move() {
		// 메서드
		System.out.println(name+"이 아장아장 걷다");
	}
}