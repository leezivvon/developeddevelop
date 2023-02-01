package javaexp.a08_inherit;

public class A03_Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PoliceMan pm = new PoliceMan();
		pm.working();
		
		FireMan fm = new FireMan();
		fm.working();
		
		Programmer pg = new Programmer();
		pg.working();
		
		// ex
		SamsungEle s = new SamsungEle();
		s.earnMoney();
		
		Hyundae h = new Hyundae();
		h.earnMoney();
	}

}
/*
# 메소드 재정의(override) ps) overloading 
1. 부모 클래스의 상속 메서드를 동일한 이름으로 수정해서 자식클래스에서 재정의하는 것 
2. 목적
    1) 동일한 이름이지만 여러 형태로 자식 클래스에서 기능적 처리를 하고자 할 때 활용된다
        - 주로 다형성(polymorphism)을 위하여 사용된다
            상위 클래스 = 하위 클래스
            cf) Object s = 모든 클래스();
                        
        - 상위 클래스에 메모리에 상속받은 여러가지 하위 클래스가 객체를 생성하면 사용할 수 있디(다형성)  
*/

// ex Company 필드(회사명) 생성자(회사명) 기능메서드earnMoney() @@회사 돈을 번다
//      하위 SamsungEle 오버라이딩 - 전자제품을 만든다, Hyundae 오버라이딩 - 배를 건조한다

//ex
class Company{
	private String cname;

	public Company(String cname) {
		this.cname = cname;
	}
	public void eanrMoney() {
		System.out.println(this.cname+"회사가 돈을 번다");
	}
}
class SamsungEle extends Company{
	
	public SamsungEle() {
		super("삼성전자");
	}
	public void earnMoney() {
		super.eanrMoney();
		System.out.println("전자제품을 만든다");
	}	
}
class Hyundae extends Company{
	public Hyundae() {
		super("현대"); // 필드값을 할당하는 것
	}
	public void earnMoney() {
		super.eanrMoney(); //상위 클래스에 정의
		System.out.println("배를 건조한다");
	}
}



class Worker{
	private String kind;
//	public Work() {}
	public Worker(String kind) {
		this.kind = kind;
	}
	public void working() {
		System.out.println(this.kind+" 열심히 일을 한다");
	}
}
// ex) Programmer 클래스를 선언하고 메서드를 재정의하여 main()에서 호출하세요
class Programmer extends Worker{
	
	public Programmer() {
		super("프로그래머");
	}
	public void working() {
		super.working();
		// 상위에 있는 메서드를 호출 super. : 동일한 이름의 메서드가 있을 때(재정의시) 구분하기 위해서 사용
		System.out.println("소프트웨어 개발을 하다");
	}
}

class PoliceMan extends Worker{
	// public PoliceMAn(){ super(); } 눈에 보이지 않지만 default로 만들어짐
	public PoliceMan() {
		super("경찰관");
	}
	public void working() { //overriding은 1. 상위와 동일한 이름으로 메서드를 정의 
		super.working();
		System.out.println("치안을 유지하는 일을 한다");
	}
}
class FireMan extends Worker{
	public FireMan() {
		super("소방관");
	}
	public void working() { //overriding은 1. 상위와 동일한이름으로 메서드를 정의 
		super.working();
		System.out.println("불 끄는 일을 한다");
	}
	
}