package javaexp.a09_exception;

public class A05_Throws {
	
	static void call01()throws ClassNotFoundException {
		// try{}catch문으로 예외 처리하여야 하는데 이 메서드를 호출하는 곳에 
		// 한꺼번에 예외를 처리할 수 있도록 위임 처리
		Class.forName("aa.bb.cc");
		System.out.println("메서드1");
	}
	static void call02() throws ClassNotFoundException{
		Class.forName("bb.cc");
		System.out.println("메서드2");
	}
	static void call03( ) throws NullPointerException{// 실행예외라서 직접 입력
		String s = null;
		System.out.println(s.toString());
	}
	static void call04( ) throws NullPointerException{
		String s = null;
		System.out.println(s.toString());
	}

	public static void main(String[] args) {

		// main()안에 다른 static 메서드 선언된 것은 객체 생성없이 바로 사용가능하다 
		
			try {
				call01();
				call01();
				call02();
				call02();				
				call03();
				call04();
				
				// 위임된 예외를 밖에서 한 번에 처리
			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
				System.out.println("예외 발생(컴파일): "+e.getMessage());
			}catch(NullPointerException e) {
				System.out.println("예외 발생(실행): "+e.getMessage());
			}
			
			try{
				call03();
				call04();
				
			}catch(NullPointerException e) {
				System.out.println("예외 발생(실행): "+e.getMessage());
			}
		
			
		
	}
}
/*
허리아파ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ짜증나ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
우웩 토도 나올것같ㄷ=아아아아아아아아아ㅏ아ㅏㅈ짜으낭 허리아ㅠㅏ

# 예외 위임(throws)
1. 메서드별로 현재 예외처리를 이 메서드를 호출하는 곳에서 처리하게끔 위임시키는 것을 말한다
2. 예외를 각 메서드별로 처리하기보다 호출되는 곳에서 한꺼번에 처리할 때 활용된다
3. 위임 형식
    public void 메서드명() throws 위임할 예외1, 위임할 예외2{
        
    }
4.  


*/


