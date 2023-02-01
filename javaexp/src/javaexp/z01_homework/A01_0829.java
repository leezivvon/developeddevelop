package javaexp.z01_homework;

public class A01_0829 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		  1) 1. 자바 소스 파일(*.java)을 작성한 후 
		     2. 컴파일러로(javac.exe)로 컴파일 후
		     3. 바이트 코드 파일(*.class)을 생성한다.
		     4. 자바 가상 기계 (java.exe)가 기계어로 번역 후 실행한다.
		        단, 이때 main() 메소드가 있어야 한다.
		    
		     1. A01_0829.java 를 작성 후 저장.
		     2. C:\a01_javaexp\jdk-15\bin 안에 있는 프로그램을 
		        path로 지정해서 바로 실행하게 처리. javac A01_0829.java
		     3. eclips에서는 저장하는 순간 클래스 파일 A01_0829.class이 생성된다.
		     4. eclips에서는 실행했을 때, 
		        운영체제에 프로그램을 실행할 수 있는 메모리 안에서 해당 내용을 처리하게끔 
		        수행. java A01_0829
		       Consol 창에서 실행   
		
		
		  2) 타입 변수이름;  // 선언
		     변수이름 = 데이터;  // 할당
		     타입 변수이름 = 데이터;  // 선언과 할당
		  
		     - 문자열 선언 
		     Stirng name = "홍길동" 
		     // name이라는 변수에 홍길동이라는 문자열 데이터를 선언, 할당 처리
		        String 타입과 "" 적용
		     
		     - 정수형, 실수형 선언과 할당
		      int num01 = 30 // 정수형 선언과 할당, 
		                        num01이라는 변수에 데이터 30 선언, 할당
		                        int 타입 사용
		      double num02 = 3.1  // 실수형 선언과 할당  
		                             double 타입 사용
		                            
		  3) 변수명을 아래와 같이 선언하고 출력
		  

     - 이름, 나이, 키
        String name = "이지원";
		int age = 27;
		double high = 162.8;
		System.out.println(name age high);
		
		- 좋아하는 음악명, 발매연도
		String song = "눈을 감으면"
		int year = 2022
		System.out.println(song year)
	
    - 오늘 지출금액 목록과 비용, 합산
		String list = "지출항목"
		...
		
		 */
		
		/*
		정답
		
		1) javac A01_0829.java 컴파일
		>> A01_0829.class ㄱ계어생성
		이 클래스에 main()메서드가 포함되어 있을 때
		java A01_0829를 통해서 메모리에 로딩 및 실행 처리된다.
		
		2) -
		문자열 선언 방법:

		String 변수명;
		ㄷㅌ) String name = "홍길동"
		변수명을 name으로 문자열을 선언하고 동시에 데이터 "홍길동"할당 처리
		- 정수형/실수형
		int num01 = 25;
		int 형은 정수형의 대표적인 데이터 유형, 데이터를 25할당
		double num02 = 3.15
		double 형은 실수형의 대표적인 데이터 유형 		
				*/
		
	// 3)
	//	이름, 나이, 키
	String name01 = "마길동";	
	int age = 25;
	double height = 178.2;
	System.out.println("이름:"+name01);
	System.out.println("나이:"+age+"살");
	System.out.println("키:"+height+"cm");
		
	// 좋아하는 음악명, 발매연도
	String music = "눈을 감으면";
	int pubYear = 2022;		
	System.out.println("# 좋아하는 음악#");
	System.out.println("이름:"+music);
	System.out.println("발매연도:"+pubYear);
	System.out.println(music+"," +pubYear);
	
	// 오늘 지출금액 목록과 비용, 합산
	String pay01 = "버스비";
	int payPrice01 = 2000;
	String pay02 = "점심식사";
	int payPrice02 = 7000;
	String pay03 = "지하철";
	int payPrice03 = 1500;
	int totPay = payPrice01 + payPrice02 + payPrice03;
	System.out.println("# 오늘 지출 목록 #");
	System.out.println("목록1:"+pay01);
	System.out.println("목록1의 비용:"+payPrice01);
	System.out.println("목록2:"+pay02);
	System.out.println("목록2의 비용:"+payPrice02);
	System.out.println("목록3:"+pay03);
	System.out.println("목록3의 비용:"+payPrice03);
	System.out.println("총 비용:"+totPay);

			
	
	}

}
