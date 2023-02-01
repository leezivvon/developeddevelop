package javaexp.a02_primitive;

public class A04_StringTypeExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		// 풀이 
		  System.out.println("물건명:"+args[0]);
		  System.out.println("가격:"+Integer.parseInt(args[1]));
		  System.out.println("개수:"+Integer.parseInt(args[2]));
		 */
		
		
		// 답
		System.out.println("# 물건 구매 처리 #");  // 프로그램 이름
		String pname = args[0]; // 물건명 데이터 입력
		int price = Integer.parseInt(args[1]);
		int cnt = Integer.parseInt(args[2]);
		System.out.println("물건명:"+pname);
		System.out.println("가격:"+price);
		System.out.println("개수:"+cnt);
		System.out.println("총계:"+price*cnt);
		
		// java A04_StringTypeExp  아이맥스    500000    1
 		// java A04_StringTypeExp  args[01]  args[02]  args[03]
		
		
	}

}
