package javaexp.a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 데이터 전송을 처리하는 stream
		1. 자바에서는 Stream이라는 api객체를 통해서 데이터를 입력하거나 출력을 하는 등 처리를 하고 있다
			- 파일의 데이터를 입/출력 또는 파일 자체를 전송
		2. SYstem.out.println()은 기본적인 자바의 OutputStream의 한 형태로 console창을 통해 출력을 하게 된다
		3. System.in :자바에서 InputStream의 한 형태로 console 창에 데이터를 입력할 때 사용되는 객체이다
			InputStream is1 = System.in;
			InputStream is2 = System.in;
			한 main()프로그램 기능 메서드로 처리하면 같은 객체를 바라보기 때문에 정상적인 작동을 할 수 없다
			이런 여러가지 IO를 보완한 Scanner()는 이런 처리를 피할 수 있지만
			raw소스로는 주석처리하든지 다른 파일 실행하여야 한다
			그럼에도 사용하는 이유는 웹에서 첨부파일할 때 업로드/다운로드할 때 Stream사용하기 때문에
			
		4. 입력처리를 하는 InputStream!!
			데이터 처리 과정
			정수형 --> char --> 문자열 --> 문자열을 모아둔 파일(객체)
			 0/1 ==>  8개  ==>  문자  ==> 문자열
					코드값 65 ==> 'A'
					      49 ==> '1'
			1) 주요 메서드
				read() : 문자(char) --> byte code값으로 연결되어 있어서 저장되는 것은 정수형이라고 할 수 있다
				 		 이것은 char로 코드값과 연결되어 있는 문자로 변경되어 표현하고 처리할 수 있다.
		*/
		
		InputStream is = null;
		System.out.println("문자 한 자를 입력하세요: ");
		// console 창에서 문자 한 자를 입력받기 위해 InputStream객체 할당
		is = System.in; // 자바에서 기본지원 입력 객체 console창에서 입력할 때 데이터를 처리해 줄수 있는 객체 
		                // cf) Console창에서 출력시 사용되는 객체 System.out
		/*
		입력된 글자 한 자를 읽어와서 데이터를 할당하고 할당된 내용을 출력하는 IO(input output)는 
		첫 시작이 InputStream과 OutputStream이라고 할 수 있다
		그리고 데이터의 입출력이 일어나는 경우에는 자바에서는 필수 예외 처리를 해주어야 실행을 할 수 있다
		ex) int num01 = is.read(); // read()기는 메서드를 통해 io가 발생하므로 예외 처리를 한다
		*/
		try {
			// 문자 한 자를 입력 받는 메서드(read())
			// 'A' ==> 65(chCode),
			// '1' ==> 49(chCode)
			// cf) 숫자값을 받아서 처리하려면 
			// 입력: '1' ==> 49(코드값) ==> (char)49 ==> '1' ==> "1" ==> 1
			// 
			// Integer.parseInt('1')(X)
			// Integer.parseInt(""+'1')(O)
			// = Integer.parseInt("1")
			// = Integer.parseInt(Character.toString('1')) ==> 1
			
			
			
			int chCode = is.read();
			System.out.println("입력된 문자의 코드 번호: "+chCode);
			System.out.println("입력된 문자: "+(char)chCode);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// ex) A02_InputSteamExp.java를 만들고 InputStream에 의해서
		//     정답을 입력하세요(1~4): 를 통해 입력 받고 해당 정답이 3이면 정답 그 외는 오답으로 처리하세요
		
		
		
	}

}
