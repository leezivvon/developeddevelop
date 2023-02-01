package javaexp.a04_process;

public class A07_DoubleFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 중첩 반복문_for문 안에 for문
		1. 반복문안에 반복을 처리하여, 단위 데이터를 계층적으로 처리할 때 사용된다
		2. 형식
		   for(;;){//상위 단계 반복
		      for(;;){
		          // 상위 단계 각 데이터별 하위 데이터 처리
		      }
		   } 
		*/
		
		
		// 이해가 안간다ㅏ 시바ㅏ라쟏ㄷㅈ
		//출력
		for(int row=1;row<=5;row++) { //행
			System.out.print(row+"\t");
			for(int col=1;col<=5;col++) { //열
				System.out.print("* ");
		}
			System.out.println();// 줄바꿈
	}
		
		int cnt=1;
		for(int row=1;row<=5;row++) {
			for(int col=1;col<=5;col++) {
				System.out.print(cnt+++"\t");
			}
		}
		
		
		// ex) 구구단 이중 for문  2~9단까지
		//     밖for문 grade, 안for문 cnt

		// 풀이
		for(int grade=2;grade<=9;grade++) {
			for(int cnt1=1;cnt1<=9;cnt1++) {
				System.out.println(grade+" * "+cnt1+" = "+grade*cnt1);
			}
			System.out.println();
		}
		// 정답
		for(int grade=2;grade<=9;grade++) {
			System.out.println("#"+grade+"단 #");
			for(int cnt2=1;cnt2<=9;cnt2++) { 
				System.out.println(grade+" * "+cnt2+" = "+grade*cnt2);
			}
		}
		// 구구단을 옆으로 처리하려면
		// 빨리 반복되는 부분과 천천히 반복되는 부분 
		//        단            1~9
		// 행 단위로 화면에 출력되기 때문이다.
		for(int cnt3 =1; cnt3<=9;cnt3++){
			for(int grade=2;grade<=9;grade++) {
				System.out.print(grade + " X " + cnt3 + " = " + grade*cnt3 + "\t");
			}
			System.out.println();
		}
		
		
		
	}

}
