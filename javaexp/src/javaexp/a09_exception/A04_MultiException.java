package javaexp.a09_exception;

public class A04_MultiException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name= null;
		try {
			System.out.println(name.toString());
			System.out.println(args[1]);
			System.out.println(1/0);
		// 다중 예외 처리
		// 1. 상위 계층의 예외는 최종적으로 처리한다
		}catch(NullPointerException e){
			System.out.println("예외1: "+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외2: "+e.getMessage());
		}catch(Exception e) {
			System.out.println("예외3: "+e.getMessage());
		}
	}

}
/*
# 다중의 예외 처리
1. 예외는 여러가지 예외를 catch block으로 처리를 할 수 있다
2. 단 계층적으로 하위 예외부터 처리하고 상위 예외를 처리한다
*/