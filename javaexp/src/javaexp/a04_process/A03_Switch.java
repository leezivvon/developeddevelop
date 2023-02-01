package javaexp.a04_process;

import java.util.Scanner;

public class A03_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# switch문과 if문의 차이점
		1. 매개값 ()에 들어가 데이터가 변수와 boolean값으로 구별한다
		2. 조건문은 boolean에 의해서 데이터의 범위를 지정할 수 있다. 
		   하지만 switch문은 단일한 데이터를 지정하여 처리할 때 주로 활용된다.
		# switch문 
		1. 변수나 연산식의 값에 따라서 실행문을 선택할 때 사용된다
		2. 기본형식
		 switch(변수){
		     case 값1:
		         처리할 내용
		         break;
		     case 값2:
		         처리할 내용
		         break;
		         .
		         .
		         .
		     default: 
		         처리할 내용 : 위에 선언된 case가 아닐 때.        
		 }
		 3. switch문에서 break;
		     break를 만나야지 switch문을 벗어난다
             break를 만나지 않으면 하위 프로세스를 처리한다		 
		*/
		
		// if문은 범위 지정 switch문은 하나의 데이터를 딱딱 지정해서 
		
		
		int chBtnNum = 3; // 3개짜리 어떤 버튼 3을 눌렀을 때ㅋㅋ
		switch( chBtnNum ) {
		case 1:
			System.out.println("A쪽 구역에 불이 켜졌습니다");
			break;
		case 2:
			System.out.println("B쪽 구역에 불이 켜졌습니다");
			break;
		case 3:
			System.out.println("C쪽 구역에 불이 켜졌습니다");
			break;
		default:
			System.out.println("해당 버튼은 사용하지 않습니다");
	
		}
		
		
		//ex) 4지 선다 문제 정답을 입력하고 정답일 경우만 정답 표시, 그외는 오답표시처리하세요
		// case 1,2,3,4 표시 
		
		// 풀이
	
		int correct = (int)(Math.random()*4+1);
		switch( correct ) {
		case 1:
			System.out.println("오답입니다");
			break;
		case 2:
			System.out.println("정답입니다");
			break;
		case 3:
			System.out.println("오답입니다");
			break;
		case 4:
			System.out.println("오답입니다");
			break;
			
		}
		
		
		// 정답
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정답을 입력하세요(1~4)");
		int chNum = sc.nextInt();
		System.out.println("입력한 번호:"+chNum);
		switch(chNum) {
		case 1:
			System.out.println("오답입니다");
			break;
		case 2:
			System.out.println("오답입니다");
			break;
		case 3:
			System.out.println("정답입니다");
			break;
		case 4:
			System.out.println("오답입니다");
			break;
		default:
			System.out.println("입력범위는 숫자로 1~4까지 입니다");
		}
		
		// break 생략
//		switch(chNum) {
//		case 1:
//		case 2: //break가 없기에 프로세스가 밑으로 진행
//		case 4:
//			System.out.println("오답입니다");
//			break;
//		case 3:
//			System.out.println("정답입니다");
//			break;
//		case 4:
//			System.out.println("오답입니다");
//			break;
//		default:
//			System.out.println("입력범위는 숫자로 1~4까지 입니다");
//		}
//		
		
		/*
		 * ex) break 생략활용 예제 
		 *     월을 입력하여 해당 월의 마지막 날짜를 출력 처리하세요 
		 *     예외처리: 1~12 범위로 입력 메세지 출력
		 *     30.31.28 switch문 활용 출력 처리
		 */
		
		// 풀이
	Scanner sc001 = new Scanner(System.in);
		System.out.print("마지막 날짜가 궁금한 달을 입력하세요: ");
		int month = sc001.nextInt();
		System.out.println("당신이 궁금한 달: "+ month+"월");
		switch (month) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month+"월의 마지막 날짜는 31일입니다");
			break;
		case 4:	
		case 6:	
		case 9:	
		case 11:	
			System.out.println(month+"월의 마지막 날짜는 30일입니다");
			break;
		case 2:
			System.out.println(month+"월의 마지막 날짜는 28일입니다");
			break;
		default:
			System.out.println("1~12 범위로 입력하세요");
		}
		
		
		
		// 정답- 숫자 임의로 지정하겠댜ㅐ
		
		int chMonth = (int)(Math.random()*15); //0~14
		System.out.println("선택한 월 입력: "+chMonth);
		switch (chMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일이 마지막 날");
		    break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일이 마지막 날");
			break;
		case 2:
			System.out.println("28일이 마지막 날");
			break;
		default :
			System.out.println("월입력범위는 숫자 1~12입니다");
		
		}
		
		
		
	}

}
