package javaexp.a03_calcu;

import java.util.Scanner;

public class A05_LogicalCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*	
			# 논리 연산자
			1. 종류
			 논리곱(&&), 논리합(||), 배타적 논리합(^), 논리부정(!)연산을 수행
			2. 피연산자는 boolean타입(true/false)만 사용 가능하다
			
			*/
		
		// 논리곱 처리 : 두 비교연산자가 모두  true 일때, true. 그 외는 false처리
		int age = 17;
		System.out.println("나이:"+age);
		System.out.println("청소년요금제 적용 유무:"+(age>=14&& age<18));
		
		
		// ex1) 획득한 점수를 입력 받아서, 
		//     60~100사이인 경우만 유효한 점수이면 합격 여부가 true이게 처리하세요 
		
		int score = 98;
		System.out.println("점수: "+score);
		System.out.println("합격여부:"+(score>=60&&score<=100));
				
		// ex2) 획득한 국어, 영어, 수학 점수를 입력받아서 모두가 80점 이상이면 선물획득여부 true 그 외에는 false
		
		int kor = 100;
		int eng = 96;
		int math = 100;
		System.out.println("국어점수: "+kor);
		System.out.println("영어점수: "+eng);
		System.out.println("수학점수: "+math);
		System.out.println("선물획득: "+(kor>=80 && eng>=80 && math>=80));
		
		int kor01, kor02, eng01, eng02, math01, math02;
		kor01=80; eng01=76; math01=100;
		kor02=97; eng02=100; math02=86;
		kor01=85; eng01=60; math01=45;
		System.out.println("영희 선물 획득: "+(kor01>=80 && eng01>=80 && math01>=80));
		System.out.println("미연 선물 획득: "+(kor02>=80 && eng02>=80 && math02>=80));		
		
		// 정답
		int kor0,eng0,math0;
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수: "); kor0 = sc.nextInt();
		System.out.print("영어점수: "); eng0 = sc.nextInt();
		System.out.print("수학점수: "); math0 = sc.nextInt();
		System.out.print("선물 획득 여부: "+(kor0>=80 && eng0>=80 && math0>=80));
				
		
				
				/*
				 논리합(||)
				 비교연산자1 || 비교연산자2
				 두개의 비교연산식 중 하나만 true일 때ㅐ, true이고 모두 다 false일때 false 처리
				 ex) 국어, 영어, 수학 점수 중 하나만 80점 이상인 경우 상을 준다고 할 때 논리합을 이용해서 
				 kor>=80 || eng>=80 || math>=80  로 처리할 수 있다
				 
				*/
		
//				 ex) 물건 2개의 가격과 개수를 할당하여 이 중 물품의 구매 비용이 10000이상이 하나라도 있으면 
//				     할인 대상 여부가 true로 처리되게 하세요
				
				int shopPri01, shopCnt01, shopPri02 shopCnt02;
				Scanner sc = new Scanner(System.in);
				System.out.print("구매한 첫번째 물건 가격을 입력하세요: ");
				int shopPri01 = sc.nextInt();
				System.out.print("구매한 첫번째 물건 개수를 입력하세요: ");
				int shopCnt01 = sc.nextInt();
				System.out.print("구매한 두번째 물건 가격을 입력하세요: ");
				int shopPri02 = sc.nextInt();
				System.out.print("구매한 두번째 물건 개수를 입력하세요: ");
				int shopCnt02 = sc.nextInt();
				System.out.println("할인대상여부: "+(shop));
				
				// 정답
				int appPrice = 2000;
				int appCnt = 2;
				int banPrice = 4000;
				int banCnt = 3;
				boolean isDis = (appPrice*appCnt>=10000)||(banPrice*banCnt>=10000);
				System.out.println("할인 대상 여부: "+isDis);
					
				// !(비교/논리) : 논리 부정 연산자
				// true ==> false, false ==> true
				int age1 = 27;
				boolean isAdo = age1>=14 && age1<18 ;
				System.out.println("청소년 아닌지 여부:"+!isAdo);
						
						
				
				
				
	}

}
