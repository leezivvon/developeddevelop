package javaexp.a06_object;

public class A07_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 메소드
		1. 객체의 동작(기능)
		2. 호출해서 실행할 수 있는 중괄호{} 블록
		3. 메소드 호출하면 중괄호{} 블록에 있는 모든 코드들이 일괄 실행
		
		# 메소드 선언
		1. 핵심 기본 유형
		   리턴타입 메소드명(매개변수1, 매개변수...){
		       프로세스 처리
		       return 실제리턴데이터
		   }
		   int plus(int num01, int num02){
		       int sum = num01+ num02;
		       return sum;
		   }
		   String getGeet(){
		       return "안녕하세요";
		   }
		   
		   1) 리턴타입 :
		      이 메서드를 호출했을 때 나온는 데이터의 유형을 선언한다
		      마지막에 리턴할 데이터의 유형을 선언한다
		      리턴값이 없는 경우에는 void를 적고 리턴하지 않는다
		      ex) 사람의 귀는 음성정보를 입력하여 두뇌에 저장\
		      
		      void를 사용하는 경우
		      1. 입력값을 통해서 주로 필드에 저장하는 경우
		         void setName(String name){
		              this.name = name;
		         }
		      2. system.out.println()화면에 출력만 하는 경우
		          void showInf(){
		              System.out.println("이름: "+this.name);
		          }
		   2) 매개변수 :
		      메서드도 생성자와 동일하게 여러개의 데이터를 단일 또는 다중으로 입력받아서 처리할 수 있다
		      cf) 메서드 오버로딩
		        메서드의 이름이 같지만 개수, 유형, 순서(유형이 다른)에 따라 선언을 할 수 있다
		         
				*/
		MethodReturnExp m01 = new MethodReturnExp();
		m01.callString();
		System.out.println("리턴데이터: "+m01.callString());
		String ret = m01.callString();
		System.out.println(ret +"! 반갑습니다");
		System.out.println(m01.callInt());
		System.out.println(m01.callDouble()); // 3.14
		double num01 = m01.callDouble()+10;
		System.out.println("num01: "+num01); // 13.14
		System.out.println("호출: "+m01.callName());
		m01.setName("마길동");
		System.out.println("다시 호출:"+m01.callName());
		
		
		
		// ex Person클래스에  필드name, age 선언 
		//    1) 이름과 나이를 저장하는 메서드 1, 메서드2 각각
		//    2) return 이름과 나이를 호출하는 메서드3, 메서드4
		// main()에서 저장과 호출하여 출력하세요
		
		Person p01 = new Person(); // 생성자 객체 만들어주고
		System.out.println(p01.getName());  // 저장안하고 호출하니까 null값 나옴
		System.out.println(p01.getAge());   // 저장안하고 호출하니까 0 나옴
		
		p01.svName("이지은");  //  main()에서 이름 저장
		p01.svAge(30);         // main()에서 나이 저장
		System.out.println("이름:"+p01.getName()); // 호출
		System.out.println("나이: "+p01.getAge()); // 호출
		
		String name = p01.getName(); // 다른 변수에 저장해서 호출 가능
		System.out.println("이름: "+name); // 호출
		int age = p01.getAge();
		System.out.println("10년 후 나이: "+ (age+10));

		/* ex) Calcu 클래스 선언하고 num01, num01
		   1) 기능메서드1 num01 저장
           2) 기능메서드2 num02 저장
           3) 기능메서드3 num01, num02 - 1/3 오버로딩
           4) 기능메서드4 두 개의변수를 더해서 return
           5) 기능메서드5 두개의 변수를 곱해서 return
		*/
		Calcu c01 = new Calcu();
		c01.svN01(5);
		c01.svN02(6);
		System.out.println();
		System.out.println("더하기: "+c01.getPlus());
		System.out.println("곱하기: "+c01.getMulti());
		
		c01.svN01(10,20); // 오버로딩
		System.out.println("더하기: "+c01.getPlus());
		System.out.println("곱하기: "+c01.getMulti());
		
		System.out.println("생성자에 의해 초기화");
		Calcu c02 = new Calcu(70,50); // 기능 메서드 없이 바로
		System.out.println("더하기: "+c02.getPlus());
		System.out.println("곱하기: "+c02.getMulti());
		
	}
}
class Calcu{
	int num01;
	int num02;
	Calcu(){} // 
	Calcu(int num01, int num02){ // 생성자를 통해 데이터가 이미 할당
		this.num01 = num01;
		this.num02 = num02;
	}
	
	void svN01(int num01) { // 기능메서드 1
		this.num01=num01;
	}
	void svN02(int num02) { // 기능메서드 2
		this.num02=num02;
	}
	void svN01(int num01, int num02) {  // 기능 메서드3 // 이름svN01 같아도 오버로딩 돼서 읽힘
		this.num01 = num01;
		this.num02 = num02;
	}
	int getPlus() {
		return this.num01+this.num02;  //return num01+num02;//필드를 지칭할 때 this
	}
	int getMulti() {
		return this.num01*this.num02;  //return num01*num02;
	}
}


 
class Person{
	String name;  // 선언
	int age;
	
	void svName(String name) { // 이름 저장 메서드1  // 저장하는 거기떼ㅐ문에 딴거 필요없고 void
		this.name= name; 
	}
	// 매개 변수 없음
	void setData() { 
		name = "없음"; // 초기 변수
		age = -1;
	}
	// 매개 변수 1
	void setData(String name) {
		this.setData(); // 현재 이 객체가 소속된 기능메서드 호출
		this.name=name;
	}
	// 매개 변수 1 - 유형 다름
	void setData(int age) {
		this.setData(); // 현재 이 객체가 소속된 기능메서드 호출
		this.age=age;
	}
	// 매개 변수 2
	void setData(String name, int age) {
		this.setData(name); 
		this.age=age;
	}
	// 매개 변수 2 - 순서 다름
	void setData(int age, String name) {
		this.setData(name); 
		this.age=age;
	}	
	
	void svAge (int age) {  // 나이 저장 메서드2
		this.age = age;
	}
	String getName() { // 저장된 이름 호출 return
		return name;
	}
	int getAge() {  // 저장된 나이 호출 return
		return age;
	}
}


class MethodReturnExp{ 
	String name;
	void setName(String name) {
		this.name = name;
		System.out.println("저장할 데이터: "+name);
		// void를 쓰면 하단에 return을 하지 않아야 한다
	}
	String callName() {
		return name;
	}
	
	
	String callString() {
		return "안녕하세요";
	}
	int callInt() {
		return 35;
	}
	double callDouble() {
		return 3.14;
	}
	
}



