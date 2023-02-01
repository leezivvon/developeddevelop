package javaexp.a09_exception;

public class A03_CompileException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 컴파일 예외 처리
			// 에러가 나면 시스템에 치명적인 영향
			// 반드시 처리 후 컴파일 해야지 처리되게끔 구현되어있음
			Class.forName("aa.bb");
		} catch (ClassNotFoundException e) {
			// e.getMessage() 에러의 메세지를 처리
			System.out.println("에러내용: "+e.getMessage());
			
			// e.printStackTrace(); : 에러 경로 처리
		}
	}

}
