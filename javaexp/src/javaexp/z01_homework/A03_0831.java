package javaexp.z01_homework;

import java.util.Scanner;

public class A03_0831 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
2022-08-31
[1단계:개념] 1. Scanner객체의 사용방법을 예제를 통하여 기술하세요.
[1단계:코드] 2. Scanner객체를 활용하여 타율계산방법을 확인(검색)하고, 선수명과 함께 입력데이터를 입력 받아 해당 타자의 타율을 출력하세요.
[1단계:개념] 3. 숫자형 문자열의 숫자 변환 형식을 예제를 통하여 기술하세요.
[1단계:코드] 4. args로 물건1 가격1 갯수1 물건2 가격2 갯수2로 입력받아 계산서를 출력하세요.
[1단계:개념] 5. 연산자와 피연산자, 연산식의 개념을 예제와 함께 기술하세요.
[2단계:코드] 6. 방어율 계산 방법을 찾아보고, 해당 항목을 입력받아 방어율을 출력하세요.
[1단계:개념] 7. 연산자의 종류를 기본 예제와 함께 기술해보세요
[2단계:코드] 8. 아래와 같은 일일 가계부를 처리할려고 한다. 초기 잔액 10000
              Scanner를 통해 입력에 필요한 연산식을 만들고 아래 형식으로 출력하세요
              날짜   내용   입금액    출금액     잔액
              8/31  용돈   30000    0        40000
              9/1   식사       0    5000     35000
[2단계:코드] 9.구매하는 김밥의 갯수를 선언하고, 1씩 증가하여 김밥의 단가(2500) 아래와 같이 출력
              김밥 1개 구매  2500 
              김밥 2개 구매  5000
              김밥 3개 구매  10000
[1단계:개념] 10. 비교연산자의 종류를 예시와 함께 기술하세요.
		*/
		
		
		// 1. import를 통해 선언하여 내장된 객체 사용  
		//    package와 class 중간에 >> import java.util.Scanner; 선언
		
		Scanner sc = new Scanner(System.in);
		System.out.print("구매한 에그타르트의 가격을 입력하세요");
		int eggPrice = sc.nextInt();
		System.out.print("구매한 에그타르트의 개수를 입력하세요");
		int eggCnt = sc.nextInt();
		System.out.println("에그타르트 가격: "+eggPrice+" 원");
		System.out.println("에그타르트 개수: "+eggCnt+" 개");
		System.out.println("총 구매 가격: "+eggPrice*eggCnt+" 원");
		
		// 2. 
		System.out.println("#야구선수 이정후의 타율#");
		System.out.print("안타");
		int anta = sc.nextInt();
	    System.out.print("홈런");
	    int homerun = sc.nextInt();
	    System.out.print("타수");
	    int tasoo= sc.nextInt();
	    System.out.println("이정후선수의 타율: "+(anta+homerun)/tasoo);
	    
	    //3. 
	    // 정수형
	    String diff01 = "27";
	    System.out.println(31+Integer.parseInt(diff01));
	    // 실수형
	    String diff02 = "3.14";
	    Double diff022 = Double.parseDouble(diff02);
	    System.out.println(19.2+diff022);
	    
	    //4. 
	     
	    String it01 = args[0];
	    int pay01 = Integer.parseInt(args[1]);
	    int cnt01 = Integer.parseInt(args[2]);
	    String it02 = args[3];
	    int pay02 = Integer.parseInt(args[4]);
	    int cnt02 = Integer.parseInt(args[5]);
		System.out.print("물건\t");
		System.out.print("가격\t");
		System.out.print("개수\n");
		System.out.print(it01+"\t");
		System.out.print(pay01+"\t");
		System.out.print(cnt01+"\n");
		System.out.print(it02+"\t");
		System.out.print(pay02+"\t");
		System.out.print(cnt02+"\n");
		System.out.print("총액\t");
		System.out.println(pay01*cnt01+pay02*cnt02);
		
		// 5. 연산자와 피연산자, 연산식의 개념을 예제와 함께 기술하세요.
		int num01 = 27;
		int num02 = 31;
		System.out.println(num01+num02);
		// 연산자 : 연산에 사용되는 표시나 기호 ex) +, -, *, /, %, =, !, !=
		// 피연산자 : 연산이 되는 데이터 ex) 리터럴, 변수 / num01, num02, 27, 31
		// 연산식 : 연산자와 피연산자를 이용하여 연산의 과정을 기술한 것 / num01+num02
		
		// 6. 방어율 = 실점*9/투구이닝
		    System.out.println("#방어율#");
			System.out.print("실점");
			double losspt = sc.nextDouble();
		    System.out.print("투구이닝");
		    double pitchIn = sc.nextDouble();
		    System.out.println("방어율= "+losspt*9/pitchIn);

	    /*
	    7. 
          1) 산술연산자  :  +, -, *, /, %
          2) 부호  :  +,
          3) 문자열  :  +  :  문자열과 문자열을 이어주는 역할
          4) 대입  :  =
             증감대입연산자(사칙연산자적용)  :  +=, -=, *= ...
          5) 증감  :  ++, --  :  변수를 1씩 증가/감소처리
          6) 비교  :  ==, !=,  >, <, >=, <=  :   true/false인 boolean값을 리턴처리
          7) 논리  :  &&, ||
          8) 조건(삼항)  :  조건 ? A : B   :  ex) age>18 ?"성인":"미성년자
	    */
	    
         // 8.
		int balance = 10000;
		System.out.print("8/31의 입출금 내용을 입력하세요");
		String con0831 = sc.nextLine();
	    System.out.print("8/31의 입금액을 입력하세요");
	    int deAm0831 = sc.nextInt();
	    System.out.print("8/31의 출금액을 입력하세요");
	    int wiAm0831 = sc.nextInt();
	    System.out.print("9/1의 입출금 내용을 입력하세요");
		String con0901 = sc.nextLine();
	    System.out.print("9/1의 입금액을 입력하세요");
	    int deAm0901 = sc.nextInt();
	    System.out.print("9/1의 출금액을 입력하세요");
	    int wiAm0901 = sc.nextInt();
	    int balance02 = (balance+deAm0831-wiAm0831);
	    System.out.print("날짜\t");
		System.out.print("내용\t");
		System.out.print("입금액\t");
		System.out.print("출금액\t");
		System.out.print("잔액\n");
		System.out.print("8/31\t");
		System.out.print(con0831+"\t");
		System.out.print(deAm0831+"\t");
		System.out.print(wiAm0831+"\t");
		System.out.print(balance02+"\n");
		System.out.print("9/1\t");
		System.out.print(con0901+"\t");
		System.out.print(deAm0901+"\t");
		System.out.print(wiAm0901+"\t");
		System.out.print((balance02+deAm0901-wiAm0901)+"\n");
		
		// 9.
        int kimB01, kimB02, kimN03;
		kimB01=1; kimB02=2; kimB03=3;
        System.out.println("김밥 1개 구매"+"\t"+kimB01*2500);
        System.out.println("김밥 2개 구매"+"\t"+++kimB01*2);
        System.out.println("김밥 3개 구매"+"\t"+++kimB01*2);
        
        // 10. 비교연산자의 종류를 예시와 함께 기술하세요.
        int score = 895;
        int goal = 800;
        System.out.println("#합격 여부#");
        System.out.println("일차 합격: "+score+">="+goal+":"+(score>=goal));
        System.out.println("이차 합격: "+score+"=="+goal+":"+(score>=goal));
        System.out.println("불합격: "+score+"<="+goal+":"+(score<=goal));		
        
        
		
//2. 해당 타자의 타율을 출력하는 식은 세웠는데 그 다음을 모르겠습니다
//6. 문제에서 원하는 식이 이게 맞는지 모르겠습니다..
//8. System.out.print("8/31의 입출금 내용을 입력하세요"); 
//   String con0831 = sc.nextLine();
//   System.out.print("8/31의 입금액을 입력하세요"); 
//   int deAm0831 = sc.nextInt(); 
//		  >> 이게 한 번에 뜨는데 이유를 모르겠습니다
//9. 문제 풀이가 절실합니다..


        
		/*    
		1.
		1)  import java.util.Scanner;
		2)  객체생성 Scanner sc01 = new Scanner(System.in)
		3)  기능메서드
		    String str01 = sc01.nextLine();
		    int num01 = sc01.nextInt(); 
		    double num01 = sc01.nextDouble();
		    String str = sc01.next();
		*/
        
        //2. 
        Scanner sc01 = new Scanner(System.in);
        // ctrl+shift+o : import 처리 단축키
		System.out.println(" # 타율 계산 # ");
		System.out.println("타석의 횟수를 입력하세요:");
		int bset = sc01.nextInt();
		System.out.println("안타수를 입력하세요");
		int hit = sc01.nextInt();
		double hitRatio = (double)hit/bset;
		System.out.println("타율:"+);
		
		//3. 정수형 변환 : int num01
		
		// 4. 
		String pname01 = args[0];
    	int price01 = Integer.parseInt(args[1]);
		int cnt01 = Integer.parseInt(args[2]);
		String pname02 = args[3];
    	int price02 = Integer.parseInt(args[4]);
		int cnt02 = Integer.parseInt(args[5]);

		System.out.println("\t# 계산서 #")
		
		
		
		/*
		5. 연산자 : 산술연산자, 대입 연산자 , 비교 연산자, 논리연산자로 	              
		           대상이 되는 데이터를 연산식으로 처리해주는 기능을 가지고 있다.  
		   피연산자 : 실제 연산자를 처리하는 대상이 되는 데이터를 말하고
		            리터럴 데이터(25, 3.14...), 변수 등이 있다.
		   연산식 : 연산자와 피연산자를 통해서 원하는 데이터를 처리하는 식을 말한다. 
		           25+30, num01*num02, point>90          
		*/
		
		
		// 6.
		
		Scanner sc02 = new Scanner(System.in);
		System.out.print("총 실점을 입력하세요:");
		int pt = sc02.nextInt();
		System.out.print("총 투구이닝을 입력하세요:");
		int inning = sc02.nextInt();
		double defRatio = (double)pt*9/inning;		
	    System.out.println("방어율:"+ defRatio);
	/*
	    7.
	       산술 +,-,*,/,%    // 25%3 ==> 1 , 정수형/정수형 ==> 정수값  casting으로 처리해야 실수값
	       부호 +, -         // int num01 = -25;  -num01 ==> 25  
	       문자열 +          // "12"+"13" ==> "1213"
	            ps. java에서는 엄격하게 산술연산자를 숫자인 경우만 처리하지만 script(파이썬, 자바스크립트)등에서는 
	                숫자형 문자열의 경우 자동형변환으로 연산을 처리해준다.  "2"*"3" ==> 6 //자바에서는 지원하지 않음
	       대입 =, +=, *=... // 기본적으로 왼쪽에서 오른쪽으로 데이터 할당
	                           int num01
	       증감 ++, --      // num01++, --num01 1씩 증가 감소
	       비교 ==, !=, >, <, >=, <=   // boolean(true/false)을 리턴   
	       논리 비교연산자를 두 개 이상 또는 not(!)를 이용해서 논리값을 처리하는 것을 말한다.
	           &&(and), ||(or), !(not)    
	       조건(삼항연산자) 조건식 ?true일 때:false일 때         
	*/
	    
	    
	    
	    // 8.
	   /* 
	    1) scanner 2개(문자열 처리, 숫자형 처리 각각)
	    2) 문자열 다 입력후, 숫자형을 입력(순서가 맞지 않음)
	    3) 모두 다 .nextLine()으로 받고 정수형이 필요한 경우 
	       Integer.parseInt(sc.nextLine())으로 형변환
	   */
	    String date01, cont01, date02, cont02; // 문자열 변수선언
	    int incom01, spend01, incom02, spend02; // 숫자형 변수 선언
	    int rest = 10000; // 누적 변수 
	    
	    Scanner sc10 = new Scanner(System.in);
	    System.out.println("# 첫번째 항목 입력 #");
	    System.out.print("날짜 입력:"); date01=sc10.nextLine();
	    System.out.print("내용 입력:"); cont01=sc10.nextLine();
	    System.out.print("입금액 입력:"); incom01=Integer.parseInt(sc10.nextLine()); // 숫자형 변환
	    System.out.print("출금액 입력:"); spend01=Integer.parseInt(sc10.nextLine()); // 숫자형 변환
	   
	    System.out.println("# 두번째 항목 입력 #");
	    System.out.print("날짜 입력:"); date02=sc10.nextLine();
	    System.out.print("내용 입력:"); cont02=sc10.nextLine();
	    System.out.print("입금액 입력:"); incom02=Integer.parseInt(sc10.nextLine());
	    System.out.print("출금액 입력:"); spend02=Integer.parseInt(sc10.nextLine());
	 
	    System.out.println("날짜\t내용\t입금액\t출금액\t잔액");
	    System.out.print(date01+"\t");
	    System.out.print(cont01+"\t");
	    System.out.print(incom01+"\t");
	    System.out.print(spend01+"\t");
	    rest+=incom01-spend01; // 누적 변수는 해당 프로세스에서 처리하기때문에 라인에서 연산처리
	    System.out.print(rest+"\n");
	    
	    System.out.print(date02+"\t");
	    System.out.print(cont02+"\t");
	    System.out.print(incom02+"\t");
	    System.out.print(spend02+"\n");  
	    rest+=incom02-spend02;
	    System.out.println(rest+"\n");
	
	    
	    
	    // 9.
	    int cnt = 0; // 카운트 변수
	    int tot = 0; // 누적 금액
	    int foodPrice = 2500; //김밥의 개당 가격 
	    
	    System.out.println("김밥"+++cnt+"개 구매   "+(tot+=foodPrice));
	    System.out.println("김밥"+(++cnt)+"개 구매   "+(tot+=foodPrice));
	    System.out.println("김밥"+(++cnt)+"개 구매   "+(tot+=foodPrice));
	    System.out.println("김밥"+(++cnt)+"개 구매   "+(tot+=foodPrice));
	    System.out.println("김밥"+(++cnt)+"개 구매   "+(tot+=foodPrice));
	    
	   /*
	    10.
	    ==, !=, <=, >=, <, >
	    instansceOf : 객체의 참조변수인지 여부
	    
	    point>=80 점수가 80이상일 때, true처리
	    */
	  
	}

}
