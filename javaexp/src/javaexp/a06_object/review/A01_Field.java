package javaexp.a06_object.review;

public class A01_Field {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 필드
		1. 클래스의 전역 변수역할을 하며 객체를 만들었을 때 주로 저장할 내용을 지정하여 처리한다	
		2. 일반적으로 클래스명 밑에 선언하여 처리한다
		3. 생성자에 의해 초기화되거나 메서드에 의해 값을 변경 저장하는 경우가 많다
		   바로 선언하는 경우도 있다
		*/
		/*
		# 생성자 //초기값에 필요한 것만
		1. 클래스에서 객체로 생성할 때 필드로 초기값을 설정이 필요한 경우에 보통 활용된다
		2. default 생성자는 생성자를 선언하지 않을 때 컴파일 과정에서 자동으로 생성되는 것을 말하고 
		   추가적인 생성자를 코드를 직접 입력하는 순간 사라진다
		*/
		
		
		Person p01 = new Person();
		p01.name = "홍길동";
		p01.visiInfo = "가을의 파란하늘";
		p01.audioInfo = "좋아하는 가을 음악";
		System.out.println(p01.name);
		System.out.println(p01.visiInfo);
		System.out.println(p01.audioInfo);
		System.out.println("#초기화된 생성자 호출#");
		Person p02 = new Person();
		System.out.println(p02.name);
		System.out.println(p02.visiInfo);
		Person p03 = new Person("이지수");
		System.out.println(p03.name);
		
		
		
		// ex) 학생 클래스를 선언하고 이름. 국어, 영어, 수학 필드를 선언하고 할당하고 출력(총점/평균 포함)하세요
		Student st = new Student(); // 객체 생성
		st.name = "이지은";
		st.kor = 100;
		st.eng = 92;
		st.math = 65;
		System.out.println("이름: "+st.name);
		System.out.println("국어점수: "+st.kor);
		System.out.println("영어점수: "+st.eng);
		System.out.println("수학점수: "+st.math);
		System.out.println("총점: "+(st.kor+st.eng+st.math));
		System.out.println("평균: "+(st.kor+st.eng+st.math)/3.0);
		
		// 일부 정답
		int tot = st.kor+st.eng+st.math;
		double avg = tot/3.0;
		System.out.println("총점: "+tot);
		System.out.println("평균: "+avg);
	

    }
}
class Student { // 생성자가 없ㄴ음에도 호출되는 이유는 내부저으로 default 값이 있어서 
	String name; // 변수선언
	int kor;
	int eng;
	int math;
	
}

class Person {
	String name;
	String visiInfo; // 시각정보
	String audioInfo; // 청각정보
	Person(){ // 생성자. 매개변수가 없는 생성자 생성
		this.name = "익명"; // 초기화를 위해 사용된다
		this.visiInfo = "";
		this.audioInfo = "";
	}
	Person(String name){
		this(); // 생성된 생성자 호출
		this.name = name; // 이름은 내가 입력한 대로
	}
}
