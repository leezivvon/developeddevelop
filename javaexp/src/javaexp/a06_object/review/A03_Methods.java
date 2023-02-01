package javaexp.a06_object.review;

public class A03_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		#메서드
		1. 필드와 상호관계속에서 데이터 처리 // 생성자는 초기값을 설정하는게 핵심
		   ex) 물건구매시 구매물건의 개수를 저장 및 전체 계 호출

		2. 주요 기능 처리
		   - 리턴타입/실제리턴값
		       메서드는 리턴타입을 먼저하고 그 리턴타입에 맞는 데이터를 마지막에 
		       return으로 처리하여야 한다
		       리턴값이 없으면 void를 선언한다
		   - 매개변수 처리
		       이 객체를 호출하는 외부 객체나 main()에서 데이터를 넘겨서 처리할 때 필요로 한다
		   - {}(중괄호블럭안)에 처리할 프로세스 처리    

		*/
		
		Person2 p01 = new Person2();
		System.out.println(p01.getStr());
		
		String ret = p01.getStr();
		System.out.println("리턴문자: "+ret);
		System.out.println("필드 리턴: " +p01.getName());
		
		// ex) 클래스로 Computer를 선언하고 필드로 컴퓨터명 선언 
		//     메서드1 : 컴퓨터의 이름, 메서드2: 컴퓨터의수량리턴(임의로 지정)
		//     해당 메서드를 호출하여 변수에 할당 또는 출력하세요
		/*
		Computer c = new Computer();
		System.out.println("이름: "+c.getCname());
		System.out.println("개수: "+c.getCnt());
		*/
		Computer com = new Computer();
		System.out.println(com.getName());
		String nam01 = com.getName();
		System.out.println("이름: "+nam01);
		int cnt01 = com.getCnt();
		System.out.println("리턴값과 +10: "+(cnt01+10));
		com.showInfo();
		
		System.out.println("컴퓨터 현재 상태: "+com.curOnOff());
		
		com.pushBtn(true);
		System.out.println("컴퓨터 현재 상태: "+com.curOnOff());
		
		
		
		
		// ex) Mart 클래스 선언 필드 pcnt(구매한 물건의 개수), 
		//     기능메서드 buyProd()매개변수로 한 번에 구매한 물건의 개수를 누적처리
		//     getProdCnt()는 리턴값 pcnt로 처리하여 현재 구매한 물건의 개수를 확인할 수 있도록 cjfl
		/*
		Mart m = new Mart();
		m.buyProd(5);
		System.out.println(m.getProdCnt());
	    */
		Mart m1 = new Mart();
		m1.buyProd(5);
		m1.buyProd(3);
		m1.buyProd(4);
		System.out.println("현재 구매한 물건의 누적 개수: "+m1.getProdCnt());
		/*
		Mart m2 = new Mart();
		m2.pnameProds("두부");
		m2.pnameProds("양파");
		System.out.println("현재 구매한 물건 전부: "+m2.getPnames());ㅡ
		*/
		m1.buyProdNames("사과");
		m1.buyProdNames("딸기");
		m1.buyProdNames("바나나");
		System.out.println("현재 구매한 물건 리스트: "+m1.buyList());
		System.out.println();
		
		m1.buyProd("컴퓨터");
		
		m1.showList();		
	}	
}
class Mart{
	// 초기에 데이터 할당하는 부분은 생성자를 통해서 처리하고
	// 계속 변경하고 호출하는 부분은 메서드를 통해서 처리
	int pcnt;
	String pnames;
	String[] buylist;
	int buyIdx; // 배열의 인덱스 증가시켜주는 것 default 가 0
	
	Mart(){ // 생성자 만들어야 null이 안나옴 왜..? 
		this.pnames = "";
		buylist = new String[5];
	}
	void buyProd(String pname) {
		if(buyIdx<5) {
		buylist[buyIdx++] = pname;
		}else {
			System.out.println("물건은 5개까지 구매가능합니다");
		}
	}
	void showList() {
		for(int idx=0; idx<buylist.length; idx++) {
			System.out.println(idx+1+") "+buylist[idx]);
		}
	}
	
	void buyProd(int cnt) {
		System.out.println("이번에 구매한 물건의 개수: "+cnt);
		this.pcnt +=cnt;
	}
	
	// +ex) 구매한 물건을 매개변수로 누적처리하는 메서드.. 사과, 바나나
	//  현재 구매된 물건 리스트를 리턴
	/*
	void pnameProds( String name ) { // 생성자가 없어서 null이 나왓음
		this.pnames += name; 
	}
	String getPnames() {
		return this.pnames;
	}
	*/
	void buyProdNames(String pname) {
		this.pnames+=pname+",";
	}
	String buyList() {
		return pnames;
	}
	
	int getProdCnt() {
		return this.pcnt;
	}
	
}
/*
class Mart{
	int pcnt;
	void buyProd(int pcnt) {
		int tot =+ this.pcnt;
	}
	int getProdCnt() {
		return tot;
	}
}
*/

class Computer{
	String name;
	boolean isOper; // boolean은 설정하지 않으면 default값 false
	
	Computer(){// 이름은 지정할 수 있게
		this.name = "보통컴퓨터";
	}
	Computer(String name){
		this.name = name;
	}
	
	void pushBtn(boolean on_or_off) { //매개변수를 통해서 
		isOper = on_or_off;
	}
	String curOnOff() {
		return isOper?"가동중":"중지중"; // true면 가동중 false면 중지중
	}
	
	
	void showInfo() {
		System.out.println("컴퓨터의 이름: "+this.name);
	}
	String getName() {
		return this.name;
	}
	int getCnt() {
		return 35;
	}
	int getCnt2() {
		int cnt =5;
		return cnt;
	}
}
/*
class Computer {
	String cname;
	
	String getCname() {
		return "LG 그램";
	}
	int getCnt() {
		return 1;
	}
}
*/
class Person2 {
	String name;
	Person2(){
		this.name ="무명";
	}
	// 문자열 리턴하는 경우
	String getStr() {
		return "안녕하세요"; // 바로 리턴
	}
	int getInt() {
		int num01 = 25; 
		return num01; // 선언된 데이터를 할당 후 리턴
	}
	String getName() {
		return this.name; // 필드값을 리턴
	}
	void show() {
		// 리턴값이 없는 경우는 void
		System.out.println("이름을 출력: "+this.name);
	}
}