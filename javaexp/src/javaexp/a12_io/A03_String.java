package javaexp.a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A03_String {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		/*
		# InputStream
		1. 바이트 기반 입력 스트림의 최상위 클래스로 추상 클래스
		2. 주요 메서드
			int read() : 입력 스트림으로부터 1 바이트를 읽고 읽은 바이트를 리턴하다
			int read(byte[] b): 입력 스트림으로부터 읽은 바이트들을 매개값으로 주어진 바이트 배열 b에 저장하고
			                    실제로 읽은 바이트 수를 리턴한다
			int read(byte[] b, int off, int len) : 입력 스트림으로부터 len개 바이트만큼 읽고
			매개값으로 주어진 바이트 배열 b[off]부터 len개까지 저장한다.
			그리고 실제로 읽은 바이트 수인 len개를 리턴한다. 만약 len개를 모두 읽지 못하면 실제로 읽은 바이트 수를 리턴한다
			void close() : 사용한 시스템 자원을 반납하고 입력 스트림을 닫는다                    
		
		*/
		//1 입력스트림 객체 System.in 통해 객체 생성
		InputStream is = System.in;
		
		//2. 여러개의 문자열을 입력할 수 있게 지정(영문)
		byte[] brr = new byte[10]; // 10개의 문자열만 입력받겠습니다 선언 // 여기에 데이터가 할당
		                           // byte단위의 범위
		
		//3 read(byte[]) : 해당 배열의 개수만큼 문자열을 받을 수 있음
		System.out.println("입력할 문자열: ");
		try {
			// 기본 형태
//			int cod = is.read(); // 문자 한 자를 받아서 byte코드로 할당 
//			System.out.println((char)cod); // 코드값을 받아서 문자 한 자를 가지고 출력
			
			int n = is.read(brr); // 이 안에서 배열이 쌓여있음
			// ex) byte[]이라는 문자를 담을 가방을 들고 is.read()라는 문자를 입력해주는 마트에 가서 
			//     문자를 가방에 담아서 처리하고 최종적으로 문자데이터가 byte[]가방에 담겨져 있음
			// 주의: 문자열의 크기는 배열로 설정되었기때문에 설정된 문자보다 적게 입력하더라도 해당 문자의 크기new byte[10]로 담겨진다
			//      {'H','e','l','l','o','','','','',''};
			//      또한 더 많은 문자를 입력하더라도 10만 입력이 된다
			//      만약 hello를 입력하면 String inStr = new String(brr) // inStr.equals("Hello") false발생    
			//    cf) new String(byte[]), new String(char[])
			// n : 입력한 문자의 개수
			// byte [] brr : 입력한 문자의 코드 배열을 할당
			// 만약 입력하면 ABC ==> byte[] brr={64, 65, 66};
			
			System.out.println("문자의 개수"+ n);
			System.out.println("입력된 문자!!");
			// brr[] : 입력된 데이터는 매개변수로 넘길 byte[]에 쌓인다
			for(byte b : brr) {
				// brr={64, 65, 66};
				// (char)brr[0]
				// 'A', 'B', 'C'
				
				
				System.out.println((char)b);
			}
			System.out.println();
			
			String str1 = new String(brr);
			System.out.println("입력된 문자열: "+str1);
			
			System.out.println();	
			//4. 자원의 해제
			is.close();	
			
			} catch(IOException e) {
				
				e.printStackTrace();
		}
		// ex) 위 형식으로 byte[]에 사용할 id를 입력받아서 출력하세요
		//     new String(byte[])을 이용하여 "himan"인 경우와 비교하여 동일 여부를 나타내세요
		//     A05_StringExp.java(영문으로만)
	
	
	}
}
