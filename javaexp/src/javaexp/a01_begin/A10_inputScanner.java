package javaexp.a01_begin;

import java.util.Scanner; //내장된 객체 사용

public class A10_inputScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 외부데이터입력 (Scanner)
		1. 내장된 객체를 사용하는 방법
		   1) import를 통해서 선언
		      import java.util.Scanner;
		      클래스명 위에 선언
		2. 객체의 생성
		   1) 객체유형  참조변수 = new 객체유형();
		   2) 객체유형에 생성되는 생성자의 매개변수로 
		      기본 입력 Stream인 System.in로 전달한다
		      ps) System.out : 기본출력 객체
		          System.in : 기본입력 객체
		3. 객체의 메서드를 활용하여 데이터를 입력받기 처리
		   1) 문자열형 데이터
		    .nextLine() : 입력 후, enter를 입력시(줄이 바뀌기 전)까지 입력 처리 메서드
		                  문자열을 받아들인다
		   2) 숫자형 데이터
		    .nextInt() : 정수형데이터 입력
		    .nextDouble() : 실수형데이터 입력
		 
		*/
		
		// int num01 + 25; (비교)
		// Scanner : 객체 타입   new Scanner(System.in) : 객체
		// 문자열형 데이터
		/*
		  Scanner sc01 = new Scanner(System.in);  // 문자형 입력 scanner
		  Scanner sc02 = new Scanner(System.in); // 두개의 객체 생성 
		                                          // 숫자형 입력 scanner
		  System.out.println("데이터를 입력하세요!!");
		  String strData01 = sc01.nextLine(); 
		  System.out.println("입력된 문자열 출력:"+strData01)
		 
		 // 객체 - 저장메모리(필드),    기능(실행처리)(메서드)ex).nextInt
		 */
		
		/*
		  ex) A11_InputScanner.java 
		      좋아하는 과일명 입력: 
		      입력 
		      과일명:@@
		 */
		
		// 숫자형 데이터
		Scanner sc01 = new Scanner(System.in);
		System.out.println("과일의 가격을 입력하세요");
		int fruPrice = sc01.nextInt();
		System.out.println("과일의 중량을 입력하세요(kg)");
		double fruitWeight = sc01.nextDouble();
		System.out.println("과일의 가격:"+fruPrice+"원");
		System.out.println("과일의 중량:"+fruitWeight+"kg");
		System.out.println("kg당가격:"+fruPrice/fruitWeight);
		
		/*
		 ex) A12_InputNumber.java
		     구매한 사과의 갯수
		     구매한 바나나의 개수
		     총 과일의 개수:@@ 
		 */
		
		
		
		
		
		
		
	}

}
