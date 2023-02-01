package javaexp.a03_calcu;

import java.util.Scanner;

public class A01_Basic {
	/*
	# 연산이란?
	1. 데이터를 처리하여 결과를 산출하는 것
	2. 연산자(operations)
	    연산에 사용되는 표시나 기호
	    +,-,*,/,%,=,!=,...
	3. 피연산자(operand)
	    연산 대상이 되는 데이터(리터럴, 변수)
	4. 연산식(expressions)
	    연산자와 피연산자를 이용하여 연산의 과정을 기술한 것
	    ex) 25 + 2, num01 + num02   	
	
	# 연산자의 종류
	1. 산술연산자 : +-, *, /, %
	2. 부호 : +, -
	   ex) int num01 = -25;, -num01
	3. 문자열 : + :문자열과 문자열을 이어주는 역할
	4. 대입 : =
	   왼쪽데이터에서 오른쪽 변수에 할당
       int num01 = 25;
            증감대입연산자(사칙연산자적용)
            num01 = num01 + 2;
            num01 += 2;
            num01 += 5;
            num01 = num01 * 2;
            num01 *= 2;        
	5. 증감 : ++, --
	   변수를 1씩 증가/감소처리
	   cnt++;
	   cnt--;
	
	6. 비교 : true/false인 boolean값을 리턴처리
	   ==, !=
	   int point = 30;
	   System.out.println(point==20); false
       System.out.println(point!=20); true	
	   >, <, >=, <=
	   point>=60 60이상일 때, true
	   instanceof 객체참조
	
	7. 논리
	    비교연산식이 2개이상 또는 not(!)를 처리 시 사용
	    age>=14 && age<=18    //두 가지 비교 연산자가 모두 true일 때, true
	    age<5 || age >=65     //두 가지 비교 연산자 중에 하나라도 true이면, true
	    !(age>=14 && age<=18) //age<14 || age>18 (드모르간법칙)
	    !(age==13)            //!=not
	       
	       문자열비교연산
	       ex) id, pass동일시
	           이렇게 하면 안됨>> id == "himan" && pass == "7777"
	           이렇게 해야 함 >> id.equals("himan") && pass.equals("7777")
	           !! 주의 !!
	           !! 자바는 위와 같이 비교연산자로 문자열을 비교하면 안된다
               "" ==> new String("") ==> heap 영역 사용
               비교연산자는 스택영역 사용
               String id1 = new String("himan") < 서로 다른 주소 사용
               String id2 = new String("himan") < 서로 다른 주소 사용
	           id1==id2   false!!
	           id1.equals(id2)  true !!
	               
	8. 조건(삼항)	
		조건 ? A : B
		
		if(age>18){
		    "성인"
		}else{
		"미성년자"
		}
		
		age>18 ?"성인":"미성년자"
		
	# 연산의 방향과 우선 순위
	1. 연산자의 방향은 기본적으로 
	   비교연산자 : 왼쪽에서 오른쪽으로 처리된다.
	      age>=14 & age<=18   : age가 14미만이더라도 age<=18를 check한다
	      age>=14 && age<=18  : age가 14미만이면 age<=18를 check하지 않는다.
	   대입연산자 : 오른쪽에서 왼쪽으로 처리된다
	      age = 10;
	
	2. 산술연산자 우선순위
	   1) ()
	      최상위 우선처리 연산자
	      (2+5)*7   =>49
	   2) * , /
	      곱셈과 나눗셈이 우선순위로 처리된다 
	      2+5*7     =>37
	   3) + , -   
    ps) ()- 소괄호/매개변수
        {}- 중괄호/기능메서드
        []- 대괄호/배열
        
        */
	      
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		# 부호연산자
		피연산자에 부호 기호(+,-)를 붙여 양수와 음수를 처리하는 것을 말한다
		*/
		int num01 = 25;
		int num02 = -5;
		int num03 = -num01;
		int num04 = -num02;
		System.out.println("num03:"+num03);
		System.out.println("num04:"+num04);
	   /*
		ex) 가계부를 아래와 같이 입력하여 출력하려고 한다
		Scanner사용/임의로 입력
		날짜 내용 지출 수입 현재잔액
		@@  @@  @@  @@   @@
		항목별로 임의로 처리해서 위 형식으로 처리하되 현재 잔액은 100000로 진행
		*/
		// 포기
	
//		Scanner sc01 = new Scanner(System.in);
//		String date = "8월 9일";
//		System.out.println("date\t내용\t지출\t수입\t현재잔액");
		
		// 정답
		String date = "8/31";
		String con = "차비";
		int spend = 5000;
		int saving = 0;
		int rest = 10000;
		System.out.println("날짜\t");
		System.out.println("내용\t");
		System.out.println("지출\t");
		System.out.println("수입\t");
		System.out.println("현재잔액\n");
		System.out.println(date+"\t");
		System.out.println(con+"\t");
		System.out.println(spend+"\t");
		System.out.println(saving+"\t");
		rest=rest-spend+saving;
//		rest+=(-spend+saving);
		System.out.println(rest+"\n");
		
		
		
		
		
		
		
		
	}

}
