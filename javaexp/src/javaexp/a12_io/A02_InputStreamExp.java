package javaexp.a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A02_InputStreamExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ex) A02_InputSteamExp.java를 만들고 InputStream에 의해서
		//     정답을 입력하세요(1~4): 를 통해 입력 받고 해당 정답이 3이면 정답 그 외는 오답으로 처리하세요
		//     hint! '3' vs 3 은 다름,   code값과 코드는 다름
		// hint!
		System.out.println(" 3='3': "+(3=='3'));
		System.out.println("문자 3의 코드값:"+(int)'3');
		
		/*
		1. 숫자
		2. 문자 : 숫자의 코드값 생성
		3. 입력 받는 데이터는 코드값과 매핑된 문자로 받을 수 있다
		
		*/
		
		
		System.out.print("정답을 입력하세요(1~4): ");
		InputStream is = System.in;  // 간지나게 객체 할당
		
		try {
			
//			int answer = is.read();
			int code = is.read(); // read()에서 가져오는 것은 code
			char inData = (char)code; // code를 문자로 변환
			char corNum ='3'; // 문자와 문자를 비교 // 정답인 문자'3'과 비교
			
//			if(Integer.parseInt(answer)==3) {
			if(inData == corNum){
				System.out.println("입력한 답: "+inData+"\n정답입니다.");
			}else {
				System.out.println("입력한 답: "+inData+"\n오답입니다");
			}
			
			// 오류
//			if(Integer.parseInt(inData)==3) {
//				System.out.println("입력한 답: "+inData+"\n정답입니다.");
//			}else {
//				System.out.println("입력한 답: "+inData+"\n오답입니다");
//			}
//			문자를 숫자로 Integer.parseInt(String)  //(char)가 아님
			/*
			문자(char)를 숫자로 변환하기 위해 문자열로 바꾸고
			Integer.parseInt()등의 함수를 이용해서 처리해야한다
			문자 ==> 문자열
			1) ""+'안'
			2) Character.valueOf('안').toString()
			
			*/
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
