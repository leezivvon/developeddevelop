package javaexp.a08_inherit;

public class A02_Super_This {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# super와 this
		1. this.
		// 현재클래스
		    1) 인스턴스 필드/메서드를 호출할 때 사용 ex) this.필드명
		    2) this() 다른 생성자를 호출할 때 사용 ex) this(), this(name)
		2. super
		// 상위 클래스
		    1) 상속관계에서 상위/하위 클래스에서 동일한 멤버를 사용할 때 	구분하기 위해서 활용	
		        ex) 주로 생성자와 메서드에서 활용된다
		    2) 생성자
		        - 하위 객체는 상위객체의 생성자를 생성하면서 처리가 된다
		           default 생성자에 의해서 기본적으로 호출된다
		           class Father{
		               public Father(){} // default 생성자가 포함되어 있음 
		               Father(String s){} // 매개변수가 있는 생성자가 생긴 순간 
		           }
		           class Son extends Father{
		               public Son(){
		                   super();  // default 상위 생성자 호출
		               }
		               // 객체 생성자를 통해 상위에 있는 매개변수가 있는 생성자를 반드시 호출해야여 하기 때문에
		                  기본 선언으로 에러가 발생
		                  public Son(){
		                    super("홍길동"); // super() 생성자 첫라인에 선언상위에 있는 생성자 호출해야 함
		                  }
		                  // 상속관계로 인하여 객체를 사용하려면 상위에 있는 필드와 메서드를 활용하여야 하는데 
		                   * 상위에 있는 선언된 생성자를 호출하지 않고는 사용할 수 없기 때문에 
		                   * 반드시 선언된 생성자 1개라도 호출하여야 한다  
		           }
		           cf) 자바는 모든 클래스가 상위/하위 상속관계로 설정
		               - 자바는 Object(내장되어 있음)가 최상위 클래스로 선언되어 있다
		               ArrayList l1 = new ArrayList();  //객체를 담는 동적 배열
		     (..동일..) ArrayList<Object> l2 = new ArrayList<Object>();  
		     
		               // Object는 모든 객체를 다형성으로 할당이 가능
		               Object ob = new Person();
		               l1.add(new Person());
		               l1.add("안녕하세요");
		               l1.add(25); // Wrapper(Integer)로 자동변환되어 할당(Boxing)
		               
		               
		               
		               
		               for(Object ob:l2){
		                   System.(ob)
		                   // 객체는 주소값 /// String은 문자열의 toString()으로 문자열자체를 가지고있기 때문에 그대로 문자열이 나온다
;		           
		               }
		               
		               
		               
		    3) 메서드에 사용하는 super.메서드()
		       - 오버라이딩
		           상위에 있는 기능 메서드를 하위 클래스에서 다양한 기능을 처리하기 위해 동일한 메서드 
		           메서드명을 재정의하는 것을 말한다.
		           이때, 상위의 매서드 내용도 호출해서 사용하려면 
		           현재 정의된 메서드와 구분하기 위해 super.메서드명();으로 호출하여 처리한다
		    
		       # 명시적 부모 생성자 호출
		       1. 부모 객체 생성할 때 부모 생성자 선택해 호출
		           자식 클래스(매개변수 선언ㅇ..){
		               super(매개값)
		           }
		       2. super(매개값)
		           - 매개값과 동일한 타입, 개수, 순서 맞는 부모 생성자 호출
		       3. 부모 생성자 없다면 컴파일 오류 발생
		       4. 부모 클래스에 기본(매개변수없는) 생성자 없다면 필수 작성    
				
				*/
		
//		Object ob1 = new Object();
		//ob1.기본메서드()
		
		Son01 s1 = new Son01("신길동");
		System.out.println(s1.getName()); // son에는 getName이 없지만 상위에서 받아와서 사용 가능
		
		//ex) Mother 잘하는 요리필드 선언, 생성자 할당, 잘하는 요리return메서드
		//    Daughter Mother상속 생성자 호출 할당, Daughter 생성..
		Daughter01 d1 = new Daughter01("시금치 나물");
		System.out.println(d1.getBestMenu());
		
	}
}
class Mother01 {
	String bestMenu;
	public Mother01(String bestMenu) { // 생성자 통해서 할당
		this.bestMenu = bestMenu;
	}
	public String getBestMenu() {
		return this.bestMenu;
	}
}
// Daughter01 d1= new Daughter01();
// d1.getBestMen();
class Daughter01 extends Mother01{
	public Daughter01(){
		super("짜장면");
	}
	public Daughter01(String s) {
		super(s);		
	}
}
class Daughter02 extends Mother01{
	public Daughter02(){
		super("한식");
	}
}


class Father01{
	private String name;
	Father01(String s){
		this.name =s;
	}
	public String getName() {
		return name;
	}
	
	
}
class Son01 extends Father01{
	Son01(String name){
		super(name); // 하위에서는 반드시 상위 클래스의 생성자를 호출하여야 한다
	}// default로 보이지 않지만 처리되어 있다
}