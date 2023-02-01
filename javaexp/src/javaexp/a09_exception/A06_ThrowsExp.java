package javaexp.a09_exception;

public class A06_ThrowsExp {
	//call01()
	static void call01() throws ArithmeticException{
		System.out.println("메서드1 ");
		for(int cnt=10;cnt>=10;cnt--)
		System.out.println(1/(double)cnt);
	}
	//call02
	static void call02() throws ArithmeticException{
		System.out.println(1/0);
		System.out.println("메서드2 ");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(1/0);
		// 위 call01()과 call02() 해당 코드를 넣고 예외를 위임 처리
		// main()에서 예외 처리를 하게 하세요
		try {
			call01();
			call02();
		}catch(ArithmeticException e) {
			System.out.println("예외: "+e.getMessage());
		}

	}

}
