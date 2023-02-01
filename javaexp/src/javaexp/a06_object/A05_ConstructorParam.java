package javaexp.a06_object;

public class A05_ConstructorParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 생성자와 매서드의 매개변수 처리
		1. 기능적 처리하는 함수형에서는 매개변수를 호율적으로 처리하는 것이 필요하다
		2. 주로 외부에서 데이터를 입력했을 때 순서와 타입에 따라 선언된 내용을 처리한다
		3. 선언
		  1) 생성자 선언
		     Person(){}
		     Person(int num){} //매개변수가 정수형 데이터 받는 데이터유형이다
		     Person(String name){}
		     Person(String name, int age){}  // 얘를 호출한 것
		     Person(int age, String name) {} 
		4. 호출
		  1) 객체 생성시 호출   
			 Person p01 = new Person();
			 Person p02 = new Person(25);
			 Person p01 = new Person("홍길동");
			 Person p01 = new Person("신길동",25);
			 선언된 데이터 유혀와 개수에 맞게 생성하여야 한다.
			 	
				*/
		
		// ex) House 클래스 선언 후 char, int, double, boolean으로 매개변수가 할당하게 하는 1개의 생성자를 선언하고 
		//     해당 생성자를 통해 객체가 생성되게 처리하세요(위 데이터 유형에 맞게 선언 및 생성자를 통해 초기화)
		/*
		House h01 = new House();
		House h02 = new House(char ch);
		House h03 = new House(int num);
		House h04 = new House(double db);
		System.out.println(h01.ch);
		System.out.println(h01.num);
		System.out.println(h01.db);
		System.out.println(h01.bl);
		*/
		// 정답
		House h1 = new House('A');  //char
		System.out.println("집의 등급: "+h1.grade);
		House h2 = new House((byte)25); // 25를 매개변수로 넘길 때는 정확하게 해당 유형으로 casting해서 전달하여야 한다 
		// House(byte b)를 호출하기 위해 casting해야 함
		// 25 데이터는 dafault는 int 형 이상 데이터 유형 할당
		House h3 = new House(30.7F); // float타입으로 선언 30.7은 에러남
		House h4 = new House(35); // long  원래 int형인데 int가 선언되지않아서 long타입으로 잘 출력됨 // 그넫 int형이 선언되면..??
		House h7 = new House(true); // boolean
	}

}
class House {
	char grade;
	byte data01;
	House (char grade){
		this.grade = grade;
		System.out.println("char 생성자 호출:"+grade);
	}
	House(byte b){
		this.data01 = b;
		System.out.println("byte 생성자 호출:"+b);
	}
	House(float f){
		System.out.println("float 생성자 호출:"+f);
	}
	House(int f){
		System.out.println("int 생성자 호출: "+f);
	}
	House(long f){
		System.out.println("long 생성자 호출: "+f);	
	}
	House(boolean b){
		System.out.println("boolean 타입 생성자: "+b);
	}
}

/*
class House{
	char ch;
	int num;
	double db;
	boolean bl;
	House(){
		char ch = '없';
		int num = 0;
		double db = 0.1;
		boolean bl = false;	
	}
	House(char ch){
		this.ch ='뭐';
	}
	House(int num){
		this.num = 1000;
	}
	House(double db){
		this.db=3.14;
	}
	House(boolean bl){
		this.bl=(4>=2);
	}
}
*/