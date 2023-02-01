package javaexp.a01_begin;

import java.util.Scanner;

public class A11_InputScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc01 = new Scanner(System.in);
		System.out.println("좋아하는 과일명 입력:");
		String strData01 = sc01.nextLine();
		System.out.println("과일명:"+strData01);
		
		
		// 정답
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 과일명을 입력하세요");
		String favFruit = sc.nextLine();
		System.out.println("입력한 과일명:"+favFruit);
		
		
	}

}
