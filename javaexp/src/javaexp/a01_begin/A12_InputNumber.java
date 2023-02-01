package javaexp.a01_begin;

import java.util.Scanner;

public class A12_InputNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc01 = new Scanner(System.in);
		System.out.println("구매한 사과의 개수를 입력하세요");
		int appleNum = sc01.nextInt();
		System.out.println("구매한 바나나의 개수를 입력하세요");
		int bananaNum = sc01.nextInt();
		System.out.println("구매한 과일의 총 개수:"+(appleNum+bananaNum));
		
		
		// 정답
		Scanner sc = new Scanner(System.in);
		System.out.print("사과의 개수:");
		int appleCnt = sc.nextInt();
		System.out.print("바나나의 개수:");
		int banaCnt = sc.nextInt();
		int tot = appleCnt+banaCnt;
		System.out.println("과일의 총계:"+tot);
		
	}

}
