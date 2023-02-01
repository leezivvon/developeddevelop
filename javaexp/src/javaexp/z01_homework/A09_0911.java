package javaexp.z01_homework;

public class A09_0911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		2022-09-11
[1단계:확인] 1. [리턴유형연습] 쇼핑몰에서 구매한 물건, 가격, 갯수, 배송지를 리턴값으로 선언하는 메서드와, 
            리턴값이 없이 위 정보를 출력하는 메서드를 선언하세요
[1단계:확인] 2. [매개변수연습] driving메서드에 매개변수로 1~3개를 각각 선언하되,
            차량명, 목적지, 거리를 선언하여 출력하되 오버로딩 규칙에 따라 처리하세요.
[1단계:확인] 3. [매개변수+리턴] Student 클래스
            tot() 매개변수:국어,영어,수학점수 리턴값:총점수(정수)
            avg() 매개변수:국어,영어,수학점수 리턴값:평균값(실수)
            reg() 매개변수:번호,이름  리턴값:@@번 @@@(문자열)
            show() 매개변수:이름,국어,영어,수학  리턴값:없음, 출력:매개변수값
[1단계:확인] 4. [매개변수+리턴] Member 클래스 선언하고, regdate()메서드로
            회원명, 아이디, 패스워드 매개변수로 입력과 String으로 등록 내용을 리턴
            usePoint()메서드로 사용한 포인트를 입력받아 10%적립포인트 리턴(실수)
            addPoint()메서드로 추가할포인트를 입력받아 지역변수로 있는 point=1000
            에 추가하여 리턴처리하세요.		
		*/
		
		//1-1 리턴값으로 선언
		Shp1 s1 = new Shp1();
		s1.prod();
		s1.cnt();
		s1.price();
		s1.ad();
		System.out.println("물건: "+s1.prod());
		System.out.println("개수: "+s1.cnt());
		System.out.println("가격: "+s1.price());
		System.out.println("배송지: "+s1.ad());
		// 1-2 리턴값안쓰고 선언
		Shp2 s2 = new Shp2();
		s2.getshp("테라", 4, 2200,"서울특별시 영등포구 행복동 행복아파트");
		System.out.println("물건: "+s2.callshp());
		System.out.println("개수: "+s2.callshpc());
		System.out.println("가격: "+s2.callshpp());
		System.out.println("배송지: "+s2.callshpa());		
		
		
		// 2 // 모르겠어요,,,ㅠㅠ
		Trip tr = new Trip();
		tr.driving("Volvo XC60");
		System.out.println(tr.driving("Volvo XC60"));
		tr.driving("Volvo XC60","경주");
		System.out.println(tr.driving("Volvo XC60","경주"));
		tr.driving("Volvo XC60","경주","216km");
		System.out.println(tr.driving("Volvo XC60","경주","216km" ));

		//3
		Student st = new Student();
		
		int tot=st.tot(96, 87,100);
		System.out.println("총점: "+tot);
		double avg=st.avg(96, 87, 100);
		System.out.println("평균: "+avg);
		String reg= st.reg("36","소피아");
		System.out.println(reg);


		//4 //...ㅠㅠ포기요..
		Member11 m = new Member11();
		String re= m.redata("다마소","zzinvanilla","zzinvv65");
		System.out.println(re);
		double up=m.usePoint("50");
		System.out.println(up);
		double ap= m.addPoint(20);
		System.out.println(ap);
		
		
		
		// 정답
		//2
		/*		
		class Car{
		     // 필드 출력 안해도 됨// 그냥 오버로딩이니까ㅋ
		     // 하지만 생성자를 위해 초기화 하겠음
		    String name;
		    String target;
		    int distance;
		    Car(){  // 거리는 int값이니까...? 무슨 말..
		        this.name="정하지 않음";
		        this.target="없음";  
		    }
		     void driving(){ // 매개변수 없음
		         System.out.println("차량명: "+this.name);
		         System.out.println("목적지: "+this.target);
		         System.out.println("거리: "+this.distance);
		     }
		     void driving(String name) { // 1개 매개변수
		         this.name=name;
		         this.driving();
		     }
		     void driving(int distance) { // 매개변수 타입이 다름
		         this.distance=distance;
		         this.driving();
		     }
		     void driving(String name, int distance) { 
		         this.name=name;
		         this.distance = distance;
		         this.driving();
		     }
		     void driving(int distance, String name) { // 매개변수의 타입의 순서가 다름
		         this.name=name;
		         this.distance = distance;
		         this.driving();
		     }
		}		
				
				*/
		
		//4
		/*
		class Member{
		    String name;
		    String id;
		    String pass;
		    double point; // 전역변수
		    
		    String regdate(String name, String id, String pass){
		         this.name = name;
		         this.id = id;
		         this.pass =pass;
		         String ret = "이름: "+name+", 아이디: "+id+", 패스워드: "+pass;
		         
		         return ret;
		    }
		    double usePoint(double point){
		        this.point = point*0.1;
//		        point*0.1 로 바로 해도 됨
 
		        return this.point;
		    }
		    double addPoint(double addPt){
		        int point = 1000; // 지역변수
		        point += addPt;
		        return point;
		    } 
		}
		
		
		
		 */
		
		
		
		
		
		
		
		
	}
}
//4
class Member11 {
	String name;
	String id;
	String pw;
	
	String redata(String name, String id, String pw) {
		String tot = name+"\t"+id+"\t"+pw;
		return tot;
	}
	double usePoint(String upoint) {
		double svpt1 = (Double.upoint)*0.1;
		return svpt1;
	}
	double addPoint (double apoint) {
		double point=1000.0;
		double svpt2=point+apoint+this.svpt1;
	}
}
//3
class Student {
	String name;
	int kor;
	int eng;
	int math;
	int tot (int kor, int eng, int math) { 
	    int tott= kor+eng+math;
	    return tott;
	}
	double avg(int kor, int eng, int math) {
		double avgg=(kor+eng+math)/3.0;
		return avgg;
	}
	String reg(String num, String name) {
		String regg =  num+"번\t"+name ;
		return regg;
	}
	void show() {// return 없이 값을 어떻게 출력하는지 모르겠습니다ㅠㅠ
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		System.out.println("이름: "+ name);
		System.out.println("국어점수: "+kor);
		System.out.println("영어점수: "+eng);
		System.out.println("수학점수: "+math);
	}
}
//2
class Trip{
	String ckind;
	String des;
	String dis;
	String driving (String ckind) { 
		return ckind;
	}
	String driving(String ckind, String des){
		this.ckind =ckind;
		return des;
	}
	String driving(String ckind, String des, String dis) {
		this.ckind=ckind;
		this.des=des;
		return dis;
	}
}
// 1-1 리턴값으로 선언
class Shp1{
	String prod() {
		return "테라";
	}
	int cnt() {
		int cnt = 4;
		return cnt;
	}
	int price() {
		int price = 2200;
		return price;
	}
	String ad() {
		return "서울특별시 영등포구 행복동 행복아파트";
	}
}
// 1-2 리턴값안쓰고 선언
class Shp2{
	String prod;
	int cnt;
	int price;
	String ad;
	Shp2(){};
	void getshp (String prod,int cnt, int price, String ad) {
		this.prod= prod;
		this.cnt=cnt;
		this.price=price;
		this.ad=ad;
	}
	String callshp() {
		return this.prod;
	}
	int callshpc() {
		return this.cnt;
	}
	int callshpp() {
		return this.price;
	}
	String callshpa() {
		return this.ad;
	}
}

