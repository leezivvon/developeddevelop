package javaexp.z01_homework;

public class A09_0912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-12
[1단계:확인] 1. [매개변수+필드] Caffee 클래스 선언, 
         필드 : 주문커피종류, 주문 가격, 주문 갯수
         메서드 : orderName - 주문커피종류 저장
                orderCoffee - 주문커피종류, 가격, 갯수 저장
                getPay - 총비용(가격*갯수) 리턴
                getName() - 주문커피종류 리턴
                showAll() - 저장된 주문커피종류,가격,갯수,총액 문자열리턴
[1단계:확인] 2. [필드+로직처리] Gugu 클래스 선언
          필드 : 단수, 시작단수, 마지막단수
      메서드 : schGrade - 단수지정
          showResult - 해당 단수의 1~9까지 연산 출력
                             setFromTo - 시작단수,마지막단수 지정
          showResult2 - 범위가 있는 단수 출력
[1단계:확인] 3. [필드+로직처리] Bus 클래스 선언
         필드 : 버스번호, 구간, 비용
         메서드 : basicInfo - 입력 버스번호, 구간, 비용
            takeBus - 입력 : 인원수 리턴:비용*인원수
                    화면 출력 : 구간 @@ 인  @@번 @@명 탑승 
		 */
		//2
		Gugu gu = new Gugu();
		gu.schGrade(4);
		gu.showResult();	
		gu.setFromTo(2,7);
		gu.showResult2();	
		
		//1
		Coffee co =new Coffee();
		co.orderName("아이스아메리카노");
		co.orderCoffee(4500,5);
		System.out.println("총비용: "+co.getPay());
		System.out.println(co.getName());
		System.out.println(co.showAll());
		
		//3
		Bus b = new Bus();
		b.basicInfo(5, "효창공원~경복궁", 2100);
		
		System.out.println(b.takeBus(27));		
	}
}
//3
class Bus{
	int num;
	String sect;
	int cost;
	void basicInfo(int num, String sect, int cost) {
		this.num=num;
		this.sect=sect;
		this.cost=cost;
	}
	int takeBus(int pcnt){
		System.out.println("< 구간 "+this.sect+"인 "+this.num+"번 "+pcnt+"명 탑승 >");
		System.out.print("총액: ");
		return cost*pcnt;
	}
}


//1 
class Coffee{
	String kcof;
	int cocof;
	int cncof;
	
	void orderName(String kcof) { 
		this.kcof=kcof;
	}
	void orderCoffee(int cocof, int cncof ) {
		this.orderName(kcof);
		this.cocof=cocof;
		this.cncof=cncof;
	}
	int getPay() {
		int tot = this.cocof*this.cncof ;
		return tot;
	}
	String getName() {
		System.out.print("주문한 커피 종류: ");
		return this.kcof;
	}
	String showAll() {
		//tot로 출력하는 방법...
		return "주문한 커피: "+this.kcof+"\n"+"가격: "+Integer.toString(this.cocof)+"\n"+"개수: "+Integer.toString(this.cncof)+"\n"+"총액: "+Integer.toString(this.cocof*this.cncof);
	}
}


//2
class Gugu {
	int dan;
	int sdan;
	int edan;
	void schGrade (int dan) {
		this.dan=dan;
		System.out.println("< "+this.dan+"단 >");
	}
	void showResult() {
		for(int cnt=1;cnt<=9;cnt++) {
			System.out.println(this.dan+"X"+cnt+"="+this.dan*cnt);
		}
	}
	void setFromTo(int sdan, int edan){
		this.sdan=sdan;
		this.edan=edan;
		System.out.println();
		System.out.println("< "+this.sdan+"단 ~ "+this.edan+"단"+" >");
	}
	void showResult2() {
		for(int i=this.sdan;i<=edan;i++) {
			System.out.println("< "+i+"단 >");
			for(int cnt=1;cnt<=9;cnt++) {
			System.out.println(i+"X"+cnt+"="+i*cnt);
			}	
	}
	}	
}

// 정답
// 1
/*

class Coffee{
   private String cname;
   private int price;
   private int cnt;
   
   public void orderName(String cname){//주문커피종류 저장
       this.cname = cname;
   }
   public void orderCoffee(String cname, int price, int cnt){
       this.cname = cname;
       this.price = price;
       this.cnt = cnt;
   }
   public int getPay(){
       return this.price*this.cnt;
   }
   public String getname() {
       return this.cname;
   }
   public String showAll(){
       String ret = "커피종류: "+this.cname+", 가격: "+this.price+", 개수: "+this.cnt+", 총액: "+this.price*this.cnt;
       return ret;
   } 
}

*/


//2
/*
class Gugu {
    int grade;
    int start;
    int end;
    void schGrade(int grade){ // 매개변수받아서 필드값에 할당하고~
        this.grade = grade;
    }
    void showResult(){
        System.out.println("# "+this.grade+"단 #")
        for(int cnt =1; cnt<=9;cnt++){
            System.out.println(this.grade+" X "+cnt+" = "+this.grade*cnt)
        }
    }
    void setFromTo(int start, int end){
        this.start=start;
        this.end=end;
    }
    void showResult2(){
        for(int grade = this.start;grade<=this.end;grade++){
            System.out.println("# "+grade+"단 #") // 지역변수
            for(int cnt=1;cnt<=9;cnt++){
                System.out.println(grade+" X "+cnt+" = "+grade*cnt) // 지역변수
            } 
        }
    }
}

*/


//3
/*
class Bus{
     private int no;
     private String fromTo="";
     private int pay;
     
     public void basicInfo(int no, String fromTo, int pay){
         this.no=no;
         this.fromTo =fromTo;
         this.pay=pay;  
     }
     public int takeBus(int cnt) { // 인원수 입력 // 필드에 선언안해서 지역변수
         System.out.println("구간: "+fromTo+"인");
         System.out.println(this.no+"번 "+cnt+"명 탑승");
         return this.pay*cnt;  // 리턴 : 비용*인원수
     }


}


*/


