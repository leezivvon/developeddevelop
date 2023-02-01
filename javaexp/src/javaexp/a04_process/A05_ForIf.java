package javaexp.a04_process;

public class A05_ForIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		# for문과 if의 사용
		1. for문을 통한 변수는 조건문으로 여러가지 처리를 할 수 있다.
		2. 처리 형식
		 1) 출력 형식 변경 처리
		     조건문에 따라 탭간격 또는 줄바꿈 처리
		     연산자의 형태 처리
		*/
		
		//3단위로 줄바꾸기 처리
		for(int cnt=1;cnt<9;cnt++) {
			System.out.println(cnt+"   ");
			if(cnt%3==0) {
				System.out.println();
			}
		}
		// 3,6,9 단위로 박수 짝 출력하기
		for(int cnt=1;cnt<=20;cnt++) {
			if(cnt%3==0) {
				System.out.print("박수 짝  ");
			}else {
			    System.out.print(cnt+"  ");
			}
		}
		
		
		
		
		// ex1) 1~100 출력하되 5개 단위로 줄바꿈 처리로 출력하세요
		// ex2) 위 내용을 처리하면서 홀수의 총합과 짝수의 총합을 하단에 출력하세요
		// 풀이
		for(int cnt=1;cnt<=100;cnt++) {
			System.out.println(cnt);
			if(cnt%5==0) {
				System.out.print(" ");
			}
			if(cnt%2==0) {
//				System.out.println(+=cnt);
			}
		}
		 
		// 정답
		int oddTot=0;
		int evnTot=0;
		for(int cnt=1;cnt<=100;cnt++) {
			System.out.println(cnt+(cnt%5==0?"\n":"\t"));
			if(cnt%2==0) {
				evnTot+=cnt;
			}else {
				oddTot+=cnt;
			}
		}
		System.out.println("홀수의 총계: "+oddTot);
		System.out.println("짝수의 총계: "+evnTot);
		
		
		
		
		
		
	}

}
