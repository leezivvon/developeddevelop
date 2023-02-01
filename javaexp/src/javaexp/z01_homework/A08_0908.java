package javaexp.z01_homework;

public class A08_0908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		  
		2022-09-08
[1단계:개념] 1. 메서드의 기본 구성요소들의 특징을 기본예제를 통해 기술하세요.
[1단계:개념] 2. 생성자의 메서드를 통한 필드값 저장의 차이점을 예제를 통해서 기술하세요.
[1단계:코드] 3. Counter 클래스를 만들고, 생성자를 통해 시작, 마지막변수를 입력하고,  메서드를 통해서 해담 범위 내용 출력하고, 누적합을 리턴 처리하게 하세요.
[1단계:코드] 4. Car 클래스의 필드 차종,색상,현재속도를 선언하고, 이 중 생성자를 통한 초기값 설정과 메서드를 통한 설정을 분리하여
             생성자, 메서드(속도증가,속도감소,현재속도확인)를 구현하여 처리하세요.
[1단계:코드] 5. 1차원 배열로 회원의 이름 5명을 선언하고 할당 출력하세요
              2차원 배열로 위 회원이름에 추가하여 나이와 사는 곳을 만들어 할당하고 출력하세요
[1단계:개념] 6. 패키지란 무엇이면, 외부패키지의 클래스를 객체로 사용할 때 전제조건과 방법 2가지를 기술하세요.		
		
				*/
		/*
		1. 
		  1) <메서드의 기본 구성요소> 
		   리턴타입 메소드명(매개변수1, 매개변수...){
		       프로세스 처리
		       return 실제리턴값
		   	
		  2) <주요 특징>
	     	리턴은 해당 메서드를 호출했을 때 나오는 데이터의 유형을 선언한다
		    맨 마지막에 리턴할 데이터의 유형을 선언하고 리턴값이 없는 경우에는 void를 적고 리턴하지 않는다
		    매개변수는 외부 객체나 main()에서 데이터를 넘겨서 처리할 때 필요하다. 필드값이랑도 연결해주는 역할.
		*/
		
		/*
		 2. 생성자의 메서드를 통한 필드값 저장의 차이점을 예제를 통해서 기술하세요.
		    생성자는 주로 객체가 생성될 때 초기값을 설정하고 메서드는 변경되는 필드값을 처리할 때 활용된다
		    필드에서 선언되는 변수는 디폴트값, 생성자는 초기값 설정, 메서드는 변경되는 필드값
		    
		    class Product {
		       String kind;  // 생성자를 통할 것
		       int cnt;      // 생성자를 통하지 않을 것 
		       
		       Product(String kind){ // 생성자
		           this.kind = kind;
		       }
		       int prodCnt(){ // 메서드
		           cnt=5;
		           return this.cnt;
		       }
		  }
		   Product p = new Product("아이맥스"); // 생성자를 통한 출력은 외부에서 입력
	       System.out.println(p.kind);
	       System.out.println(p.prodCnt()); //  내부 입력을 통한 메서드를 통한 출력

		 */
		
		//3
		Counter ct = new Counter(1,7);
		ct.prdOnC(10000);
		ct.prdOnC(3000);
		ct.prdOnC(500);
//		System.out.println("누적 합: "+c.getTot());  
		
		
		//4
		
		Car cr1 = new Car("벤츠","흰색");
		Car cr2 = new Car(50.6);
		
		System.out.println("차종 : "+cr1.ckind);
		System.out.print("속도 증가 여부 : "+cr1.color);
		cr2.spInc(60);
		System.out.print("속도 감소 여부 : ");
		cr2.spDec(25.7);
		System.out.print("현재 속도 : "+cr2.spCk());
		

		// 5.
		
		System.out.println();
		String[] member = null;
		member = new String[] {"헬레나","다마소","비비안나","소피아","율리아"};

		String[][] mem = {
				{"58살","서울"},
				{"58살","부산"},
				{"30살","대전"},
				{"27살","세종"},
				{"24살","제주"}
		};
		for(int idx=0;idx<member.length;idx++) {
			System.out.print(member[idx]+": ");
			for(int jdx=0;jdx<mem[idx].length;jdx++) {
				System.out.print("\t"+mem[idx][jdx]+" ");
			}
			System.out.println();
		}
		
		
		/*
		6
		 
		패키지란 클래스를 기능별로 묶어서 그룹 이름을 붙여 놓은 것을 말한다
		외부패키지의 클래스를 객체로 사용할 때 전제조건은 public 접근 제어자가 선언되어 있을 때 가능하다
		방법은 
		1. 패키지명.클래스명 p = new 패키지명.클래스명();
		2. import 패키지명.클래스명 을 상단 main()가 있는 클래스 전에 선언
	    이다.
	    
	    // 그런데 하이퍼 텍스트가 어떻게 생성 되는지 모르겠습ㄴㅣ다! 커서를 가져다 대도 안뜹니다
		*/
		
		
		
	}	
}
class Car {
	String ckind;
	String color;
	double speed;
	Car(){
		this.ckind="";
		this.color="";
		this.speed=0;
	}
	Car(String ckind, String color){
		this();
		this.ckind=ckind;
		this.color=color;
	}
	Car(double speed){
		this();
		this.speed=speed;
	}
	double spInc (double howsp) {
		System.out.println(this.speed>howsp?"속도증가":"속도증가X");
		return howsp;
	}
	double spDec(double howsp) {
		System.out.println(this.speed<howsp?"속도감소":"속도감소X");
		return howsp;
	}double spCk() {
		return this.speed;
	}
}



//3
class Counter {
	int price ;
	int start;
	int end;
	int tot ;
	
	Counter(){
		int start;
		int end;
	}
	Counter (int start, int end){
		this.start = start;
		this.end = end;
	}
	void prdOnC(int price) {
		for(int cnt=start;cnt<=end;cnt++) {
			System.out.println(cnt+")"+"구매 가격: "+this.price) ;
			this.tot += this.price;		
		}
	}	
	int getTot () {
		return this.tot;
	}
}
