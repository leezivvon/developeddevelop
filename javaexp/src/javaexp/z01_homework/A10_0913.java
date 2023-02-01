package javaexp.z01_homework;

public class A10_0913 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-13
[1단계:개념] 1. 자바의 접근제어자 4가지 범위를 예제를 통하여 설명하세요.
[1단계:코드] 2. playroom패키지 선언과 내부적으로 친구1, 친구2 클래스 선언, studyroom패키지선언 학생1, 학생2 클래스 선언, 
             친구1, 학생1에서 private, X(default), public에 적절한 필드값을 선언하고, 상호간에 호출하세요.
[1단계:개념] 3. 인스턴스변수와 스태틱변수의 차이점을 기술하세요.
[1단계:코드] 4. ScoccerPlayer에 팀명, 팀성적, 이름, 개인성적에서 팀명과 팀성적은 static, 이름과 개인성적으로 instance변수를 선언하여 데이터를 할당하세요.
[1단계:개념] 5. final와 static final의 필드 차이점을 예제를 통해 기술하세요.
[1단계:코드] 6. 컴퓨터의 종류, 사양내용(cpu,ram,hdd)을 static final, static)을 이용하여 초기화 호출하여 출력하세요.
[1단계:개념] 7. 1:1관계 객체의 선언 순서를 기술하세요.
[1단계:코드] 8. 아래의 1:1관계 객체를을 선언해보세요.
            1) 자동차(차종,최고속도,배기량)와 자동차의소유주(이름,자동차, takeCar(자동차) driving() ) 를 선언
            2) 학생과 성적표
            3) 결혼할 커플(신랑, 신부)
		*/
		
		//1
		/*
		 <접근 제한자의 종류>
		     *ex) WoodCutter 기준.
		    - public : 패키지가 다르더라도 접근이 가능 
		                ex) 외부 패키지에 있는 uncle까지 접근 가능
		    - protected : 상속 관계에 있을 때 외부 패키지까지 접근 가능 
		                ex) 외부 패키지에 있고 상속관계(extends)에 있는 son1까지 접근 가능
		    - default(X) : 같은 패키지에서만 접근 가능
		                ex) 같은 패키지에 있는 Angel, Daughter, Son2, Son3만 접근 가능 
		    - private : 다른 클래스에서는 접근이 불가능 
		                ex) WoodCutter만 접근 가능
		                    같은 패키지에 있더라도 Angel, Daughter, Son2, Son3 모두 접근 불가능
		*/
		
		//3
		/*
		인스턴스 변수와 static변수의 차이점
		 인스턴스 변수는 객체에 소속되어 객체 생성없이는 사용이 불가능하며 객체 내부에서 인스턴스 변수임을 명확히 하기 위해 this.사용
		  또한 객체마다 다르게 선언가능
		 static 변수는 객체가 아닌 클래스에 고정되어 메소드 영역에 존재, 객체를 생성하지 않고 사용 가능
		  객체의 공유메모리를 취급/ 모든 객체에 영향을 끼침
  
		 */
		
		
		//5
		/*
		final와 static final 의 필드 차이점
		
		class Tumbler{
	        int cnt; // 인스턴스 변수 
	        final String favTumbler; // 객체단위로 초기값 설정 가능 // 객체단위로 변경 가능
	        static final String storeTumbler = "스타벅스";  // 객체 단위로 변경 불가, 생성자를 통해서도 변경 불가
	        Tumbler(int cnt, String favTumbler){}    
	    
	    Tumbler t = new Tumbler( 5, "민트색 텀블러");    // final 생성자로 변경 가능(= 객체단위로 변경 가능
	    t.favTumbler="검은색 콜드컵"; // final 객체마다 변경 불가
	                               // static final은 둘 다 안됨                                                        
		 */
		
	
		//7 종속될 클래스를 먼저 선언하고 포함할 클래스를 후에 선언한다, 포함할 클래스 메소드 중 하나의 매개변수를 종속될 클래스명으로 해야 한다.
		
		//6 정답
		Computer c01 = new Computer ("조립식", 1500000);
		c01.show();
		c01.kind="노트북"; // 인스턴스 변수 변경 함 해보고
		Computer.comp="삼성컴퓨터"; 
		c01.show();
		
		//8 정답
		/*
		#코드 순서
		1. 종속될 클래스 선언
		  - 속성값(필드, 메서드) 구분
		  - 출력할 가능 메서드 선언
		2. 포함할 클래스 선언
		  - 기본 속성-필드선언
		  - 종속될 클래스 선언
		  - 생성자(기본 속성-필드)
		  - 종속될 클래스를 할당할 메서드 선언 
		  - 전체 데이터 출력 메서드 	
			*/
		// 8-1
		CarOwner ca01= new CarOwner("비비안나");
		ca01.driving();
		// public void takeCar(Carr car)
		ca01.takeCar(new Carr("BMW",280,3500)); 
		ca01.driving();
		
		//8-2
		Record r1 = new Record("영어",90);
		System.out.println(r1.toString());
		System.out.println(r1);
		// toString
		//
		Stu st= new Stu("헬레나");
		st.setR1(r1);
		st.show();
		st.setR1(new Record("수학", 85));
		st.show();
			
		//8-3
		Bridee br = new Bridee("헬레나");
		br.coupleInfo();
		br.setWedding(new Groomm("다마소",28));
		br.coupleInfo();
	
		
		
	}
}
//8 정답
//8-3
class Groomm{
	private String name;
	private int age;
	public Groomm(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "신랑정보 [신랑이름=" + name + ", 신랑나이=" + age + "]";
	}
	public String getName() {
		return this.name;
	}
}
class Bridee{
	private String name;
	private Groomm groomm;
	public Bridee(String name) {
		this.name = name;
	}
	public void setWedding(Groomm groomm) {
		this.groomm = groomm;
		System.out.println("신랑"+groomm.getName()+"와 결혼하다");	
	}
	public void coupleInfo() {
		System.out.println("신부"+name+"");
		if(this.groomm!=null) {
			System.out.println(this.groomm);
		}else {
			System.out.println("아직 결혼하지 않았습니다");
		}
	}
}
//8-2
class Record{
	private String subject;
	private int point;
	public Record(String subject, int point) {
		this.subject = subject;
		this.point = point;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	// toString()는 참조변수를 호출했을 때 리턴할 내용을 기술
	// 객체의 참조 : 패키지명.클래스명@heap영역의 주소값
	@Override
	public String toString() {
		return "Record [과목=" + subject + ", 점수=" + point + "]";
	}
}
class Stu{
	private String name;
	private Record r1;
	public Stu(String name) {
		this.name = name;
	}
	public void setR1(Record r1) {
		this.r1=r1;
	}
	public void show() {
		System.out.println("# "+name+"학생 성적표 #");
		if(r1!=null) {
			System.out.println(r1);
		}else {
			System.out.println("성적표가 없네요");
		}
	}
}
//8-1
class Carr{
	private String kind;
	private int maxSpeed;
	private int cc;
	public Carr() {}// 생성자 
	public Carr(String kind, int maxSpeed, int cc) {
		this.kind = kind;
		this.maxSpeed = maxSpeed;
		this.cc = cc;
	}
	public void showCarInfo() {
		System.out.println("차종: "+ this.kind);
		System.out.println("최고속도: "+ this.maxSpeed+"km/h");
		System.out.println("배기량: "+this.cc);
	}
}
class CarOwner{
	private String name;
	private Carr car;
	public CarOwner(String name) {
		this.name = name;
	}
	public void takeCar(Carr car) {
		System.out.println("차를 타다");
		this.car=car;
	}
	public void driving() {
		System.out.println(this.name+"차를 운행하려고 합니다");
		if(this.car!=null) { // 객체가 할당되어 있을 때
			System.out.println("차를 운행합니다");
			this.car.showCarInfo();
		}else {
			System.out.println("차가 없네요");
		}
	}
}


//6 정답
class Computer{
	String kind; // 인스턴스 변수 : 객체별, 기능메서드별로 변경 가능
	final int cost; // final변수 : 객체별, 객체단위로는 변경 불가
	static String comp; // static변수 : 클래스 단위 변수설정, 클래스 단위로는 변경 가능 
	static final String NATION = "KOR"; // static final 상수 : 클래스 단위로 상수설정, 변경불가
	
	public Computer(String kind, int cost) {
		this.kind = kind;
		this.cost = cost;
	}
	public void show() {
		System.out.println("# 컴퓨터 종류 #");
		System.out.println("컴퓨터종류(인스턴스): "+this.kind);
		System.out.println("구매비용(인스턴스단위상수)"+this.cost);
		
		System.out.println("제조사(static): "+comp);//this. 쓰면 안됨
		System.out.println("(클래스상수): made in "+NATION);
	}
}


//8-1
class Caar{
	String ckind;
	double highspeed;
	int volume;
	
	public Caar(String ckind, double highspeed, int volume) {
		this.ckind = ckind;
		this.highspeed = highspeed;
		this.volume = volume;
	}
	public void info() {
		System.out.println("차종: "+ckind);
		System.out.println("최고속도: "+highspeed);
		System.out.println("배기량: "+volume);
	}
}
class OweCar{
	private String name;
	private Caar car;
	public Owecar(String name){
		this.name=name;
	}
	public void takeCar(Caar car) {
		this.car=car;
	}
	public void dirving() {
		car.info();
	}
//8-2
	class ScoreRe{
		int kor;
		int eng;
		int math;
		public ScoreRe(int kor, int eng, int math) {
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		public void info() {
			System.out.println("국어: "+kor);
			System.out.println("영어: "+eng);
			System.out.println("수학: "+math);
		}
	}
	class Student{
		private String name;
		private ScoreRe scr;
		public Student(String name){
			this.name=name;
		}
		public void checkSco(ScoreRe scr) {
			this.scr=scr;
		}
		public void momGetSco() {
			scr.info();
		}
		
		// 8-3
		class Groom{
			String gname;
			int gage;
			String gjob;
			public Groom(String gname, int gage, String gjob) {
				this.gname = gname;
				this.gage = gage;
				this.gjob = gjob;
			}
			public void info() {
				System.out.println("신랑 이름: "+gname);
				System.out.println("신랑 나이: "+gage);
				System.out.println("신랑 직업: "+gjob);
			}
		}
		class Bride{
			String bname;
			int bage;
			String bjob;
			Groom husband;
			public Bride(String bname, int bage, String bjob) {
				this.bname = bname;
				this.bage = bage;
				this.bjob = bjob;
			}
			public void (Groom husband) {
				this.husband=husband;
			}
			public void wedding() {
			    System.out.println(" 축 결혼 ");
			    System.out.println("신부 이름: "+bname);
				System.out.println("신부 나이: "+bage);
				System.out.println("신부 직업: "+bjob);
				System.out.println();
				husband.info();	
			}
			
			}		
	
}

//6
class Com{
	static final String ckind = "노트북";
	final String cpu= "i3";
	final double ram;
	final String hdd;
	
	public Com(double ram, String hdd) {
		this.ram = ram;
		this.hdd = hdd;
	}
	void showInfo() {
		System.out.println("종류: "+ckind );
		System.out.println("# "+ckind+" 사양 내용 #");
		System.out.println("cpu: "+cpu);
		System.out.println("ram: "+ this.ram +"gb");
		System.out.println("hdd: "+ this.hdd);
	}
}


//4 
class SoccerPlayer{
	static String tname;
	static String tscore;
	String name;
	double score;
	
	public SoccerPlayer(String name, double score) {
		this.name = name;
		this.score = score;
	}
	void showInfo() {
		System.out.println("# 현재 "+tname+"의 성적은 "+tscore+" #");
		System.out.println(tname+"소속 선수 "+this.name+"의 개인성적은");
		System.out.println("....."+this.score);	
	}
}}

