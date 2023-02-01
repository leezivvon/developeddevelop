package javaexp.z01_homework;

public class A02_0830 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//      [1단계:개념] 1. 기본 출력형식과 특수문자에 대하여 예제를 통해 기술하세요
//      [1단계:개념] 2. 변수명의 선언 규칙을 예제를 통하여 기술하세요.
//      [1단계:코드] 3. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
//      [1단계:개념] 4. 150라는 데이터는 기본데이터유형 중에 어디에 할당이 가능한가를 기술하고 그 이유에 대하여 설명하세요
//      [2단계:코드] 5. 알파벳의 코드값 범위와 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
//      [1단계:개념] 6. 형변환 두가지 유형을 예제를 통해서 기술하고 설명하세요..
//      [1단계:코드] 7. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
//            소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
		
		
		
	/*
	  1. 기본 출력형식 : System.out.println(); // 줄바꿈
 	                  System.out.print(); // 줄 안바꿈
 	     특수문자 : \n // 줄 바꿈
 	              \t // 일정한 간격을 처리할 때 활용            
    */
		// 예제
	 System.out.println("\t나이\t생일\t좋아하는 음식\t선호하는 여행지\n우희\t24\t6월\t떡볶이\t\t네덜란드\n희원\t27\t6월\t삼겹살\t\t베트남\n수지\t30\t8월\t파스타\t\t스위스");
	
	 int age1 = 24;  double birth1 = 6.4;  String food1 = "떡볶이";  String travel1 = "네덜란드";   
	 int age2 = 27;  double birth2 = 6.1;  String food2 = "삼겹살";  String travel2 = "다낭";
	 int age3 = 30;  double birth3 = 8.9;  String food3 = "파스타";  String travel3 = "스위스";   
	 System.out.println("\t나이\t생일\t좋아하는 음식\t선호하는 여행지");
	 System.out.print("우희\t" + age1 );
	 System.out.print("\t"+ birth1 );
	 System.out.print("\t"+ food1 );
	 System.out.print("\t\t"+ travel1 + "\n" );	 
	 System.out.print("희원\t" + age2 );
	 System.out.print("\t"+ birth2 );
	 System.out.print("\t"+ food2 );
	 System.out.print("\t\t"+ travel2 + "\n" );
	 System.out.print("수지\t" + age3 );
	 System.out.print("\t"+ birth3 );
	 System.out.print("\t"+ food3 );
	 System.out.print("\t\t"+ travel3 + "\n" );
	 
	// 2. 예제
	 int num = 15; // 변수명 첫글자는 문자이거나 $, _이어야 하고 숫자로 시작할 수 없다
	 double birthday = 12.12;
	 double birthDay = 12.12; 
	 // 영어 대소문자가 구분된다 birthday와 birthDay는 다른 변수 
	 // if difficult = 0 ; // 자바 예약어는 사용할 수 없다
	 
	 // 3. 
    int mill21 = 210000000;
    int mill15 = 150000000;
    int total = mill21 + mill15;
    System.out.println(total);
    
    // 4. 
    //    byte, short, int에 할당 가능하다 
    //    byte는 121까지 가능하고 int는 21억 4천까지 가능하기 때문이다
    
    // 5. 
    char chA = 'A';
    char chZ = 'Z';
    int codeA = chA;
    int codeZ = chZ;
    System.out.println("#알파벳 코드값 범위#");
    System.out.println(codeA+"~"+codeZ);
    
    char ch0 = '0';
    char ch9 = '9';
    int code0 = ch0;
    int coed9 = ch9;
    System.out.println("#0에서 9까지의 코드값 범위#");
    System.out.println(code0+"~"+ coed9);
    
    //  6. 
	byte num01 = 27;
	int num02 = num01 + 31;
	System.out.println(num02); // 자동형 변환 : 작은 타입이 큰 타입으로 자동으로 변환되는 것
                               //             작은 타입인 byte가 큰 타입인 int으로 자동 변환 됨 
	double num03 = 3.14;
	int num04 = (int)num03; 
	System.out.println(num04); // 강제타입 변환 : 큰 타입을 작은 타입 단위로 쪼개기
	                           //              int < double 인데 int형으로 강제로 변환을 한 것 
	                           //              정수형 이외에는 모두 삭제
	
	// 7. 
	int orangeJuice = 500;
	int num05 = 3;
	System.out.println(orangeJuice/num05 + "cc"); // 소숫점 이하가 처리
	System.out.println(orangeJuice/(double)num05 + "cc"); // 소숫점 이하가 처리되지 않은 경우1
    double num06 = 3.0;
	System.out.println(orangeJuice/num06 + "cc"); // 소숫점 아래가 처리되지 않는 경우2
	
	
	
	// 정답
	
	// 1

	/*
		1. 
		1) 메서드
		 System.out.println(); //줄바꿈
		 System.out.print(); //줄변경없이
		2) \n : 문자열로 줄바꿈 기능 포함
		   \t : 문자열로 탭간격 처리
		   \"
		   
		2.    변수명의 선언 규칙
		1) 숫자는 첫자로 사용하지 않아야 한다
		   int 10num;(X) int num01;(0)
		2) 변수명에 특수문자는 허용되지 않는다. 단, _,$는 허용된다
		   int $name;(O) String #alis;(X)
		3) 대소문자는 구분하여 다른 변수명으로 인식한다
		   int num01;    
		   int nuM01;    
		4) 예약어 - 명령어(내장 keyword)는 변수명으로 사용하지 못한다
		   int if; (X)
		5) 합성어는 대문자로 시작하여 구분하여 사용한다.(가독성)
           String seName;		
		
		*/
	
	// 	3.
	int num10 = 200000000;
	int num11 = 150000000;
	int sum = num10+num11; // 결과값이 엉망이 됨
	long sum2 = (long)num10+(long)num11;
	System.out.println("합산결과:"+sum);
	System.out.println("합산결과:"+sum2);
	
	// 4.
//	byte num011 = 150;
	short num012 = 150;
	int num013 = 150;
	long num014 = 150;
	System.out.println(num012);
	System.out.println(num013);
	System.out.println(num014);
	// 150은 byte범위는 1byte 초과하여 할당이 불가능하여 에러가 발생 
	// 그외 2byte이상의 데이터유형에는 할당이 가능하다
	
	// 5.
	int code11 = '0';
	int coed12 = '9';
	System.out.println("코드값:"+code11);
	System.out.println("코드값:"+code12); 
	//48~57
	for(int cnt = 28; cnt ,=57; cnt++) {
		System.out.println(cnt+":"+(char)cnt);
	} // for문으로 확인
	
	// A~Z, a~z
	int code13 = 'A';
	int code14 = 'Z';
	int code15 = 'a';
	int code16 = 'z';
	System.out.println("A:"+code13);
	System.out.println("알파벳"+code14);
	System.out.println("알파벳"+code15);
	System.out.println("알파벳"+code16);
	
	
	// 6. 형 변환은 데이터유형(타입)이 변경되는 것을 말한다.
//	   1) promote(자동형변환) : 보통 작은데이터유형의 데이터를 큰 데이터 유형에 할당할 때, 주로 발생
//        별다른 처리없이 데이터를 할당하여 변경
	 int num30 = 10;
	 double num31 = num30;
	 System.out.println(num30);
//	   2) casting(강제형변환)
	

	 // 7.
	 int juicy = 500;
	 int glasses =3;
	 System.out.println("한 잔당 용량(int):"+(juicy/glasses));
	 System.out.println("한 잔당 용량(double):"+(double)juicy/glasses);
	
	
	
	}

}
