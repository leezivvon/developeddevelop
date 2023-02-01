package javaexp.z01_homework;

import java.util.ArrayList;

public class A12_0915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		  2022-09-15
[1단계:개념] 1. (연습이 필요한 분)1:다관계 설정 연습 - 버스/승객, 영화/배우들, 회사/종업원  
[1단계:개념] 2. this/super의 사용을 생성자와 메서드를 나누어 기본예제를 통해 설명하세요.
[1단계:코드] 3. 상위클래스 School 학교의 분류 , 하위클래스 EleSchool/MiddleSchool/HighSchool을 선언하여 상위 생성자를 통해 하위객체를 할당처리하세요.
[1단계:개념] 4. 메서드 overriding이란 무엇인가? overloading과 차이점과 함께 기본예제를 통해 기술하세요.
[1단계:코드] 5. 상위클래스 ComPart 컴퓨터 부품, partFunction()부품의 기능,  하위클래스 Cpu, Ram, Ssd를 선언하여 오버라이딩을 처리하여 구현하세요.
[1단계:개념] 6. 다형성이란 무엇인가? 개념을 기술하세요.
[1단계:코드] 7. 상위클래스 Blabar 나비애벌래로 다양한 나비(호랑나비, 노랑나비, 파랑나비)가 나오게 다형성 처리하고 showColor()메서드를 통해서 재정의 하세요

		*/
		
		
		
		
		//2 
		/*
		생성자에서
		1. this(), this(name) : 다른 생성자를 호출할 때 사용
		2. super() : 상속관계에서 상위/하위 클래스에서 동일한 멤버를 사용할 때 구분하기 위해서 사용
		             하위 객체는 상위 객체의 생성자를 생성하면 dafault 생성자에 의해서 자동으로 기본 호출된다
		             class Father{
		                 public Father(){} // default 생성자가 포함되어 있음 
		             }
		             class Son extends Father{
		                 public Son(){
		                     super();  //
		                 }
		              }
		메서드에서
		1. this.필드명  : 인스턴스의 필드나 메서드를 호출할 때 사용   
		2. super() : 상속관계에서 상위/하위 클래스에서 동일한 멤버를 사용할 때 구분하기 위해서 사용	          
		*/
		
		//3. 
		EleSchool es = new EleSchool("초등학교");
		System.out.println(es.getKind());
		MiddleSchool ms = new MiddleSchool("중학교");
		System.out.println(ms.getKind());
		HighSchool hs = new HighSchool("고등학교");
		System.out.println(ms.getKind());
		
		//4 
		/*		
		메서드 overriding이란 
		메서드 재정의로서 상속관계에서 쓰인다. 부모 클래스의 상속 메서드를 동일한 이름으로 수정해서 자식클래스에서 재정의하는 것 
		메서드 overloading이란 
		같은 클래스 안에서 메서드의 이름이 같지만	매개변수의 개수, 유형, 순서에 따라 별개로 취급하여 선언을 할 수 있는 것을 말한다.
		
		메서드 overriding
		class Plant{..public void wateringDate(){}..}
		class Rose extends Plant {..public void wateringDate(){}..} 자식 클래스의 데이터로 출력되고 부모클래스의 데이터를 출력하고 싶다면
		class Rose extends Plant {..public void wateringDate(){super.wateringDate();..}..}
		
		메서드 overloading
		void setData(String name, int age){}
		void setData(int age, String name){} 은 다른 기능메서드로 취급된다
	    */
		
		//5 
		ComPart c1 = new Cpu();
		c1.partFunction();
		ComPart c2 = new Ram();
		c2.partFunction();
		ComPart c3 = new Ssd();
		c3.partFunction();
		
		//6
		/*
		다형성이란 같은 타입이지만 실행 결과가 다양한 객체를 이용 가능한 성질로
		부모 타입에는 모든 자식 객체가 대입 가능하다
		*/
		
		//7 
		Blabar bf1 = new TigerButf();
		System.out.println(bf1.showColor());
		Blabar bf2 = new YellowButf();
		System.out.println(bf2.showColor());
		Blabar bf3 = new BlueButf();
		System.out.println(bf3.showColor());
	
		
		
		//1
		//1-1
		Buss bus = new Buss("6-2", "광화문-용산");
		bus.showPassAll();
		System.out.println();
		
		bus.addPassenger(new Passenger("학생", "c5", 900));
		bus.addPassenger(new Passenger("성인", "d7", 200));
		bus.addPassenger(new Passenger("성인", "f1", 900));
		bus.addPassenger(new Passenger("우대", "a4", 0));
		bus.showPassAll();
		
		//1-2
		Movie mv = new Movie("9월 15일","한산");
		mv.showScreen(); // 등록 전
		System.out.println();
		
		mv.addActor(new Actor("박해일","이순신 장군"));
		mv.addActor(new Actor("변요한","일본인 장수"));
		mv.addActor(new Actor("김선규","일본인 장수"));
		mv.showScreen();
		
		//1-3
		Enterprise ep = new Enterprise("VARO","사이버마케팅 3팀");
		ep.showWorkList();// 등록 전
		System.out.println();
		
		ep.addWorker(new Workers("김태평",43,"팀장"));
		ep.addWorker(new Workers("천우희",35,"과장"));
		ep.addWorker(new Workers("최우식",33,"대리"));
		ep.addWorker(new Workers("이지은",30,"대리"));
		ep.showWorkList();
		
		
		// 정답(abstract 응용)
		Computer02 com = new Computer02("맥프로 노트북");
		com.setParts(new Cpuu());
		com.setParts(new Ramm());
		com.setParts(new Ramm());
		com.setParts(new Ssdd());
		com.setParts(new Ssdd());
		com.showPartList();
		
	}
}

//정답-5
class Computer02{
	private String kind;
	private ArrayList<ComPartt> parts;
	public Computer02(String kind) {
		this.kind = kind;
		this.parts = new ArrayList<ComPartt>();
	}
	public void setParts(ComPartt parts) {
		//1. 다형성 : 상위에서 하위가 할당 가능
//		                   상위    =    하위
//		           ComPartt part1 = new Cpu();
//                 ComPartt part2 = new Ramm();
//                 ComPartt part3 = new Ssd();
		
		//2. ArrayList 데이터 할당
//		ArrayList<Cpuu> list = new ArrayList<Cpuu>();
//		list.add(new Cpuu());
//		list.add(new Cpuu());
//		list.add(new Cpuu());
		
//		ArrayList<CpmPartt> list2 = new ArrayList<>();
//		list2.add(new Cpuu());
//		list2.add(new Ramm());
//		list2.add(new Ssdd());
//		
		this.parts.add(parts);
	}
	public void showPartList() {
		System.out.println("컴퓨터 종류 :"+ kind);
		// 단위객체가ComPartt
		// 추상클래스는 자체로 객체를 생성하지 못할 뿐이지 종속된 하위클래스를 할당해서 사용하는 것은 가능 
		for(ComPartt cp: this.parts) {
			// 각 객체에서 재정의된 내용을 호출
			cp.partFunction();
		}
	}
}
abstract class ComPartt{
	private String kind;
	public ComPartt(String kind) {
		this.kind = kind;
	}
	// 공통메서드
	public String getKind() {
		return this.kind;
	}
	// 다양하게 처리할 메서드
	public abstract void partFunction();
}
class Cpuu extends ComPartt{
	public Cpuu() {
		super("CPU");
	}
	public void partFunction() {
		System.out.println(getKind()+"컴퓨터의 핵심 중앙 처리");
	}
}
class Ramm extends ComPartt{
	public Ramm() {
		super("RAM");
	}
	public void partFunction() {
		System.out.println(getKind()+"컴퓨터의 핵심 휘발성 ");
	}
}
class Ssdd extends ComPartt{
	public Ssdd() {
		super("ssd");
	}
	public void partFunction() {
		System.out.println(getKind()+"컴퓨터의 핵심 중앙 처리");
	}
}


//1-3
class Enterprise{
	private String ename;
	private String tname;
	private ArrayList<Workers> wlist;
	public Enterprise(String ename, String tname) {
		this.ename = ename;
		this.tname = tname;
		this.wlist = new ArrayList<Workers>();
	}
	public void addWorker(Workers wo) {
		this.wlist.add(wo);
		System.out.println(this.tname+"에 "+wo.getGrade()+"직책이 발령예정입니다.");
	}
	public void showWorkList() {
		System.out.println("\t축 "+this.ename+" 신설 부서 창립");
		System.out.println("_______"+this.tname+"발령 명단______");
		if(wlist.size()>0) {
			System.out.println("\t직책\t이름\t");
			for(Workers w:wlist) {
				w.workerInfo();
			}	
		}else{
			System.out.println("명단이 아직 발표되지 않았습니다");
		}
	}
	
}
class Workers{
	private String name;
	private int age;
	private String grade;
	public Workers(String name, int age, String grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public void workerInfo() {
		System.out.println("\t"+this.grade+"\t"+this.name+"  ( "+this.age+" )" );
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
//1-2
class Movie {
	private String date;
	private String title;
	private ArrayList<Actor> mvlist;
	public Movie(String date, String title) {
		this.date = date;
		this.title = title;
		this.mvlist = new ArrayList<Actor>();
	}
	public void addActor(Actor act) {
		this.mvlist.add(act);
		System.out.println(act.getName()+" 전격출연!");		
	}
	public void showScreen() {
		if(mvlist.size()>0) {
			System.out.println("-----영화 "+this.title+" 캐스팅 결과-----");
			System.out.println("이름\t\t배역");
			for(Actor a:mvlist) {
				a.actorsInfo();
			}
			System.out.println("\t"+this.date+"  대 개 봉");
		}else {
			System.out.println("아직 캐스팅 발표가 되지 않았습니다");
		}
	}

}
class Actor{
	private String name;
	private String casting;
	public Actor(String name, String casting) {
		this.name = name;
		this.casting = casting;
	}
	public void actorsInfo() {
		System.out.print(this.name+"\t\t");
		System.out.println(this.casting+" 역");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCasting() {
		return casting;
	}
	public void setCasting(String casting) {
		this.casting = casting;
	}
	
}
//1-1
class Buss {
	private String no;
	private String fromTo;
	private ArrayList<Passenger> plist;
	public Buss(String no, String fromTo) {
		this.no = no;
		this.fromTo = fromTo;
		this.plist = new ArrayList<Passenger>();
	}
	public void addPassenger(Passenger pass) {
		this.plist.add(pass);
		System.out.println("-삑  "+pass.getAge()+"입니다.");
	}
	public void showPassAll() {
		System.out.println("< "+this.no+"번 "+this.fromTo+"구간 버스 탑승객 총 목록 >");
		if(plist.size()>0) {
			System.out.println("\t승객\t좌석위치\t요금");
			for(Passenger pf:plist) {
				pf.showInfo();
			}
		}System.out.println("\t- 총 탑승객은 "+plist.size()+"명 입니다.");
	}
}
class Passenger {
	private String age;
	private String seat;
	private int fee;
	public Passenger(String age, String seat, int fee) {
		this.age = age;
		this.seat = seat;
		this.fee = fee;
	}
	public void showInfo() {
		System.out.print("\t"+this.age+"\t");
		System.out.print(this.seat+"\t");
		System.out.print(+this.fee+"\n");
	}
	public String getAge() {
		return age;
	}
	
}

//7 return 으로 출력해보기
class Blabar {
	private String bkind;
	public Blabar(String bkind) {
		this.bkind = bkind;
	}
	public String showColor () {
		return this.bkind+"의 색깔은.. ";
	}	
}
class TigerButf extends Blabar {
	public TigerButf(){
		super("호랑나비");
	}
	public String showColor() {
		System.out.print(super.showColor());
		return "모르겠고! 어쨌든 호랑이 무늬";
	}
}
class YellowButf extends Blabar {
	public YellowButf(){
		super("노랑나비");
	}
	public String showColor() {
		System.out.println(super.showColor());
		return "노란색";
	}
}
class BlueButf extends Blabar {
	public BlueButf(){
		super("파랑나비");
	}
	public String showColor() {
		System.out.println(super.showColor());
		return "파란색";
	}
}
//5 
class ComPart {
	private String pkind;

	public ComPart(String pkind) {
		this.pkind = pkind;
	}
	public void partFunction() {
		System.out.print(this.pkind+"의 기능은 ");
	}
}
class Cpu extends ComPart{
	public Cpu() {
		super("cpu");
	}
	public void partFunction() {
		super.partFunction();
		System.out.println("명령어 장치,해독, 데이터인출,처리,쓰기입니다. ");
	}
}
class Ram extends ComPart{
	public Ram() {
		super("ram");
	}
	public void partFunction() {
		super.partFunction();
		System.out.println("메모리 장치이며 cpu와 가장 가까운 메모리 중 하나로 단기메모리이다.");
	}
}
class Ssd extends ComPart{
	public Ssd() {
		super("ssd");
	}
	public void partFunction() {
		super.partFunction();
		System.out.println("비휘발성 메모리입니다.");
	}
}

//3
class School {
	private String kind;
	public School(String kind) {
		this.kind = kind;
	}
	public String getKind() {
		return kind;
	}
}
class EleSchool extends School{
	EleSchool(String kind){
		super(kind);// 상위 생성자가 매개변수가 생겼기때문에 상위생성자와 같은 매개값
	}
}
class MiddleSchool extends School{
	MiddleSchool(String kind){
		super(kind);
	}
}
class HighSchool extends School{
	HighSchool(String kind){
		super(kind);
	}
}
