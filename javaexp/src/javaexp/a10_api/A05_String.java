package javaexp.a10_api;

import java.io.UnsupportedEncodingException;

public class A05_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# String 클래스 메소드
		1. 문자열의 추출 , 비교, 찾기, 분리, 변환 등과 같은 다양한 메소드를 가진다
		2. 사용빈도가 높은 메소드
			1) charAt(int idx) : 특정위치에 문자 리턴
			
		
		
		*/
		String str01 ="EMP1063729";
		System.out.println("첫번째 문자: "+str01.charAt(0));
		System.out.println("마지막 문자: "+str01.charAt(9));
		
		// 주민번호로 생년월일의 문자를 charAt로 추출하여 출력하세요
		String civilNum = "901212-2102618";
		System.out.println("생일: 19"+civilNum.charAt(0)+civilNum.charAt(1)+"년 "
		                    +civilNum.charAt(2)+civilNum.charAt(3)+"월 "
				            +civilNum.charAt(4)+civilNum.charAt(5)+"일" );
		System.out.print("19");
		System.out.println();
		
		/*
		# String 문자열
		1. 숫자
			0, 1 : 데이터 최소단위 bit
			01000112 ==> 8개 byte ==> 정수형의 가장 기본 데이터
			==> 숫자들에 코드에 대입해서 'A', 'B' 문자를 설정하여 생성되었다
			문자들이 배열로 만들어서 일상에 문자열을 사용하게 되었음
			{'H','e','l','l','o'}
			==> {25, 34,72,43,22} : 코드값으로 bytes배열은 문자가 모인 문자열로 사용할 수 있다
			==> 객체 지향 프로그램에서 char[]배열에서 한단계 더 나아가 String 문자열 객체를 만들게 되었다
		*/
		System.out.println(65);
		System.out.println((char)65);
		/*
		2. String은 생성자로 byte[]를 받아서 처리할 수 있다
		
		*/
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97}; // hello java
		/*
		# 코드값 배열 <==> 문자열
		*/
		String str10 = "Hi! Man!"; 
		byte[] arr10 = str10.getBytes();  // 문자열을 code값으로 가져오는 방법
		String str11 = new String(arr10); // 코드값 배열을 문자열로 처리
		
		// 숫자에 해당하는 문자(char)가 모여서 문자열을 이루게 한다는 개념하에 
		// String 생성자를 통해서 문자열을 만들 수 있게 하였다
		String str1 = new String(bytes);
		System.out.println("출력: "+str1);
		
		// ex) Good job 을 위 byte배열에 의해 문자열로 만드려고 한다
		//     해당 문자들의 코드값 확인하고 문자열을 Good Job을 생성하ㅗ 출력하세요
		//g71   뜨이ㅓ쓰기32  a97  h 72  d100  j74  o111
		System.out.println((char)71);
		byte[] bytes1 = {71, 111, 111, 100, 32, 106, 111,98,33 };
		String str2 = new String(bytes1);
		System.out.println("출력: "+str2);
		/*
		1)Good job 각각의 문자열의 코드값 확인 // (int)G
		2) 해당 코드값의 byte 배열에 할당
		3) new String(byte배열)에 할당 및 문자열 확인
		*/
		System.out.print((int)'G'+", ");
		System.out.print((int)'o'+", ");
		System.out.print((int)'d'+", ");
		System.out.print((int)' '+", ");
		System.out.print((int)'j'+", ");
		System.out.print((int)'b'+", ");
		System.out.print((int)'!'+", "); // 문자열의 코드값 확인
		byte []arr = {71, 111, 111, 100, 32, 106, 111,98,33};
		String str3 = new String(arr);
		System.out.println("문자열: "+str3);
		
		// 한글도 가능
		System.out.println((int)'대');
		System.out.println((int)'한');
		
		/*
		# String의 여러가지 기능 메서드
		1. charAt(index)
		2. getBytes() : 문자열의 byte배열을 가져온다 이때 매개변수값을 EUC-KR이나 
		                UTF-8로 한글 encoding형식을 지정할 수 있다
		                
		*/
		String str4 = "반가워요";
		byte[] bytes4 = str4.getBytes();
		for(byte b:bytes4) {
			System.out.print(b+" ");
		}
		System.out.println();
		
		String str5 = new String(bytes4);
		System.out.println("다시 문자열 출력: "+str5);
		try {
			
			byte[] bytes6 = str5.getBytes("EUC-KR");
			String str7 = new String(bytes6);
			System.out.println("문자열6 : "+str7);
			
			byte[ ] bytes7 = str5.getBytes("UTF-8");
			String str8 = new String(bytes7);
			System.out.println("문자열7: "+str8);
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// ex) 오늘도 좋은 하루!! 문자열을 선언하고 encoding으로 EUC-KR과 UTF-8로 bytes배열을 만들고
		//     다시 문자열 생성자에 할당한 후 출력하셍ㅅ
		
		String gm = "오늘도 좋은 하루!!";
		
		try {
			// EUC-KR
			byte[] gmbyte1 = gm.getBytes("EUC-KR"); // encoding으로 bytes 배열
			String gmeuc = new String(gmbyte1);     // 다시 문자열 생성자에 할당
			System.out.println("EUC-KR 문자열: "+gmeuc); // 출력
			
			// UTF-8
			byte[] gmbyte2 = gm.getBytes("UTF-8");
			String gmutf = new String(gmbyte2);
			System.out.println("UTF-8 문자열: "+gmutf);
			
		}catch(UnsupportedEncodingException eur) {
			eur.printStackTrace();
		}
		
		// String 생성자로 매개값을 처리할 수 있는 데이터 유형
		// 1. 문자열 자체 new String("안녕하세요");
		// 2. 문자 배열: new String({'안','녕','하','세','요'});
		// 3. byte 배열 : new String({102, 105, 301, 420});
		//    65 ==> 'A' ==> "A"
		
		String str100 = new String();
		
		
		
		
		
	}	
}
























