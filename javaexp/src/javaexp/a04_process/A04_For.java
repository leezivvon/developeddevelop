package javaexp.a04_process;

import java.util.Scanner;

public class A04_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		# 반복문for문
		1. 중괄호 블럭 내용을 반목적으로 실행할 때 사용한다
		2.종류 : for문 while문 do-while문
		3.for문 : 반복 횟수를 알고 있을 때, 주로 사용된다
		for(초기값설정1;반복조건2;증/감연산자4){
		   반복처리할 내용3
		}
		1) 처리 순서
		 1,2,3,4,2,3,4,2,3,4 ...
		 초기값은 한 번만 실행되고~
		 
		 for(;;){} // 무한반복

		*/

	
	System.out.println("반복문(카운트1~10)");
	for(int cnt=1;cnt<=10;cnt++) {
		System.out.println(cnt+"번째 안녕하세요!!");
	}
	System.out.println("디스카운트(10~0)");
	for(int cnt=10;cnt>=0;cnt--) {
		System.out.println("카운트다운: "+cnt);
	}	
	System.out.println("10부터 2개씩 증가");
    for(int cnt=10;cnt<=50;cnt+=2) {
    	System.out.println("번호:"+cnt);
    }
    
//    ex1) 0부터 20까지 출력
//    ex2) 100부터 80까지 출력
//	  ex3) 3부터 21까지 3의 배수 출력

    // 풀이
    // 1
    System.out.println("0부터 20까지 출력");
    for(int cnt01=0;cnt01<=20;cnt01++) {
    	System.out.println("번호: "+cnt01);
    }
	//2
    //3
    System.out.println("3부터 21까지 3의 배수 출력");
    for(int cnt03=3;cnt03<=21;cnt03*=3) {
    	System.out.println("번호: "+cnt03);
    }
    
    // 정답
    // 1
    for(int cnt=0;cnt<=20;cnt++) {
    	System.out.print(cnt+",");
    }
    System.out.println(); // 줄바꾸려고
   
    //2
    for(int cnt=100;cnt>=80;cnt--) {
    	System.out.println(cnt+" ");
    }
    System.out.println();
 
    //3
    for(int cnt=3;cnt<=21;cnt+=3) {
    	System.out.println(cnt+"\t");
    }
    System.out.println();
  
    
    
	/*
	# for문 밖 전역변수 활용
	
	1. 누적된 변수를 사용해야 할 경ㅇ 반복문 밖에 선언하여 처리한다
	 ex) 1~10의 총합 구하기, 문자열 연결데이터 누적처리하기
	
	*/
    
    int tot = 0;
    for(int cnt=1;cnt<=10;cnt++) {
    	System.out.println(cnt);
    	if (cnt!=10)System.out.print(" + ");
        tot +=cnt; //cnt가 증가하면서 누적된다
    }
    System.out.println(" = "+tot);
    
    //ex1) 김밥나라의 김밥 단가2500 방복문 이용해서 1~20개의 단위 계를 출력하고
    //     총비용을 누적해서 출력하세요
    //     김밥 1개 2500원
    //     김밥 2개 2500원
    //     ...
    //     누적 총비용 @@@원

    // 정답
    int kimB = 0;
    int totPay = 0;
    for(int cnt=1;cnt<=20;cnt+=2500) {
    	System.out.println("김밥  "+cnt+"개   "+kimB*cnt+"원"); //개수, 가격, 누적되는 데이터
    	totPay+=kimB*cnt;
    }
    System.out.println("누적 총비용:"+totPay);
    
    
	
	// ex2) 구구단의 단을 입력받아서 1~9까지 곱한 결과를 출력하세요
	// 풀이
//    Scanner sc = new Scanner(System.in);
//    System.out.println("1~9단을 입력하세요: ");
//    int googoo =sc.nextInt();
//    
//    for(int dan =1;cnt<=9;cnt*=googoo) {
//    	System.out.println();
//    }
    // 정답
    Scanner sc = new Scanner(System.in);
    System.out.println("단 입력: ");
    int grade=sc.nextInt();
    System.out.println("##"+grade+"##");
    for(int cnt=1;cnt<=9;cnt++) {
    	System.out.println("단 X"+cnt+" = "+grade*cnt);
    }
    
    // ex3) 전역변수 + 반복step 연습
	/*
	1~50까지 중에 홀수의 합을 출력하세요
	1 3 5 7 .... 49
	합 : @@@
	*/
    // 풀이
//    int tot01 = 0;
//    for(int cnt=1;cnt<=49;cnt+=2) {
//    	tot01+=cnt;                       
//    }
//    System.out.println("홀수의 누적 합 : "+(tot01+=cnt));
   
     //cnt 출력을 안했고 oddTot선언을 for문안에서 해야하는데 안했고(for문안에서 해야하는 이유는 cnt누적값이 for문안에서 계산되니까)
    // 마지막 출력을 tot01만했어야 했다 (이미 for문안에서 계산과 선언이 끝나서)
    
    
    
    //정답
    int oddTot = 0;
    for(int cnt=1;cnt<=50;cnt+=2) {
    	System.out.print(cnt+" ");
    	oddTot += cnt;
    }
    System.out.println();
    System.out.println("합: "+oddTot);
    
   
    
	}

}
