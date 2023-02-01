package javaexp.z01_homework;

import java.util.Scanner;

public class A05_0905 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		2022-09-05
[1단계:개념] 1. stack영역과 heap영역의 차이점을 기술하세요.
[1단계:코드] 2. 정수형 배열(arr05)로 물건의 가격을 3개 할당하고, 새로운 배열 변수(arr06)에 물건의 가격 변수(arry05)
      를 할당하고 arr06에 중간데이터를 변경 후 두 변수를 비교시 동일한 데이터가 나오는 이유를 기술하세요.
[1단계:개념] 3. 객체형 데이터를 선언하여 초기화(null)후, 구성요소를 호출할 때 나오는 에러와 원인을 예제를 통해서
      설명하세요
[1단계:개념] 4. 배열에서 사용하는 구성요소와 선언 및 할당 처리를 기본 예제와 함께 설명하세요.
[1단계:코드] 5. 유럽챔피언스리그 팀과 성적을 배열로 선언하고 출력하세요.
[1단계:코드] 6. 학생3명의 이름과 국어 점수를 배열로 선언하고 Scanner로 입력한 후, 출력하세요.
[3단계:코드] 7. 임시비번에 사용할 임의의 데이터를 입력후(갯수 입력 후 문자입력), 문자 5개로 구성된 임시 비밀번호를 생성출력하세요.
		*/

		/*
		1. 
		메모리는 크게 stack영역과 heap영역이 있는데 
		기본 타입 변수를 선언하고 실제 값을 변수 안에 할당, 저장하는 곳은 stack 영역이고
		기본 타입 변수뿐만 아니라 참조타입 변수의 주소를 통해 객체를 참조하는 곳은 heap영역이다. 
         // 솔직히 이해가 갈듯 말듯 하다..
		*/
		
		// 2.
		
		int[] arr05 = {3000, 4000, 5000};
		int[] arr06 = arr05;
		arr06 = new int[] {10000, 20000, 30000};
		System.out.println("arr05:"+ arr05[0]);
		System.out.println("arr06:"+ arr06[0]);
		// 다른 데이터가 나온다.. 왜 같은 데이터가 안나오는지 모르겠다..
		
		// 3.
		String[] diff;
		diff = null;
		System.out.println(diff);
		// 오류가 안난다ㅠㅠㅠㅠ
		
		// 4. 
		// 선언과 할당 처리를 동시에 한 경우 (빈배열..?)
		int[] array01 = {100, 200, 300, 400}; // 해당 배열에서 사용하는 구성요소는 1000, 2000, 3000, 4000 이다
		// 선언 후 할당한 경우
		int[] array02;
		array02 = new int[] {500, 200, 300, 400};
		// 선언하고 초기화 한 경우
		int[] array03;
		array03 = null;
		
		//5. 
		String[] names = {"바이에른 뮌헨","벤피카","바르셀로나","디나모 키예프"};
		int[] score = {18, 8, 7, 1};
		System.out.println("팀 이름:\t"+names[0]+"\t"+names[1]+"\t"+names[2]+"\t"+names[3]+"\t");
		System.out.println("팀 성적:\t"+score[0]+"\t"+score[1]+"\t"+score[2]+"\t"+score[3]+"\t");
		
		//6.학생3명의 이름과 국어 점수를 배열로 선언하고 Scanner로 입력한 후, 출력하세요.
		Scanner scN = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);
		
		String[] nameStu = new String[3];
	    int[] scoreKr = new int[3];
	    System.out.println("<학생의 이름을 입력하세요>");
		for(int idx=0;idx<nameStu.length;idx++) {
			nameStu[idx] = scN.nextLine();
			System.out.println(idx+1+") "+ nameStu[idx]);
		}
		System.out.println("<등록한 학생의 국어점수를 차례로 입력하세요>");
		for(int idx=0;idx<scoreKr.length;idx++) {
			scoreKr[idx] = scS.nextInt();
			System.out.println(idx+1+") "+ scoreKr[idx]);
		}
		System.out.println("<등록된 학생들의 국어점수 목록>\n이름\t국어점수");
		for(int idx=0;idx<nameStu.length;idx++) {
		System.out.println(nameStu[idx]+"\t "+scoreKr[idx]+"점");
		}


		// 7
		Scanner scsc = new Scanner(System.in);
		System.out.println("몇자리의 임시비밀번호를 만드시겠습니까?");
		int scrNCnt = scsc.nextInt();
		System.out.println(scrNCnt+"자리 비밀번호 생성 중..");
		System.out.println("!!"+scrNCnt+"자리 비밀번호 생성 완료!!");
		
		String[] secNum = new String[scrNCnt-1];	
		for(int idx=0;idx<secNum.length;idx++) {
			int ranNum =(int)(Math.random()*26+65);
			System.out.print((char)ranNum);
		}
		
		// 정답
		
		/*
		 * 
		1.
		객체를 사용하느냐에 따라 heap영역의 사용여부를 결정한다
		stack영역
		1. 기본 데이터 유형 : 변수명 선언과 실제 데이터 할당
		2. 객체 유형  : 변수명 선언과 주소값 할당
		heap영역
		1. 객체 유형에 실제 객체 유형의 데이터 할당
		
		*/
		
		// 2
		int[] arr5 = {3000, 4000, 5000};
		//stack영역에는 arr5라는 이름으로 실제 할당돼 heap영역의 주소를 저장
		// heap영역에는 {3000, 4000, 5000} 객체 데이터 할당
		int[] arr6 = arr5;
		// arr5에 할당되어 있는 stack영역에 있는 주소를 복사해서 arr6에 할당
		arr6[1]=7000;
		System.out.println("중간 데이터 변경(arr6[1]):"+arr6[1]);
		System.out.println("변경 후 데이터 arr5[1]의 데이터 확인 :"+arr5[1]);
		// 주소값이 같으므로 한쪽에 있는 데이터(arr6[1])를 변경하더라도 다른 쪽 데이터(arr5[1])가 변경되는 것을 확인할 수 있다
		
		// 3
		int[] arr7;
		arr7 = null; //배열형 객체 초기화
		
		Person p01;
		p01 = null; // 사용자 정의 클래서 객체 초기화	
//		System.out.println("배열 구성 요소 호출: "+arr7[0]);  NullPointerException
//		System.out.println("객체 구성 요소 호출: "+p01.name); NullPointerException
//		  - heap영역에 객체가 만들어져 있지 않는 상황에서 구성요소를 호출하므로 에러가 발생한다
		
		arr7 = new int[] {100, 200,300};
		p01 = new Person();
		System.out.println("배열 구성 요소 호출: "+arr7[0]);  
		System.out.println("객체 구성 요소 호출: "+p01.name); 
//		  - heap영역에 객체가 만들어 진 후에는 구성요소를 호출해도 에러가 발생하지 않는다
		
		// 6
		
		// 데이터를 할당할 수 있게 배열 객체 선언 / 객체 생성
		String[] nameS = new String[3];
		int[] kors = new int[3];          // 메모리 공간 만듦
		
		Scanner sc = new Scanner(System.in);
		
		for(int idx=0;idx<nameS.length;idx++) {
			System.out.println(idx+1+"번째 학생의 이름 입력: ");
			nameS[idx] = sc.nextLine();
			System.out.println(idx+1+"번째 학생의 국어점수 입력: ");
			kors[idx] = Integer.parseInt(sc.nextLine());   //형변환으로 문자열데이ㅓ를 숫자형으로 만들든지 아니ㅕㄴ 스캐너 두개 
		}
		System.out.println("번호\t이름\t국어점수");
		for(int idx=0;idx<names.length;idx++) {
			System.out.println(idx+1+"\t"+names[idx]+"\t"+kors[idx]);
		}
		
		
		/*
				Scanner scsc = new Scanner(System.in);
		System.out.println("몇자리의 임시비밀번호를 만드시겠습니까?");
		int scrNCnt = scsc.nextInt();
		System.out.println(scrNCnt+"자리 비밀번호 생성 중..");
		System.out.println("!!"+scrNCnt+"자리 비밀번호 생성 완료!!");
		
		String[] secNum = new String[scrNCnt-1];	
		for(int idx=0;idx<secNum.length;idx++) {
			int ranNum =(int)(Math.random()*26+65);
			System.out.print((char)ranNum);
		}
		*/
		
		
		// 7 -1 임시비밀번호로 사용할 배열 선언 후 
		String[] tmpStrs = new String[10];
		Scanner sc2 = new Scanner(System.in);
		System.out.println("임시 비밀번호로 사용할 문자열10개를 입력하세요");
		for(int idx=0;idx<tmpStrs.length;idx++) {
			System.out.println(idx+1+"번째 문자입력: ");
			tmpStrs[idx] = sc2.nextLine();
		}
		System.out.println("비밀번호로 사용할 문자열");
		for(int idx=0;idx<tmpStrs.length;idx++) {
			System.out.print(tmpStrs[idx]+",");
		}
		String tmPass = "";
		for(int cnt=1;cnt<=5;cnt++) {
			int rIdx = (int)(Math.random()*tmpStrs.length);
			tmPass+=tmpStrs[rIdx]; // += 사칙연산으로 계산뿐 아니라 문자열을 차례로 연결해주기도 하는 것...?
		}
		System.out.println("임시비밀번호: "+tmPass);
		

		// 7 -2
		// 48~57, 65~90, 97~122 : 숫자 소문자 대문자 : 배열을 char로 만들어서 이 범위에 있는 문자만 입력, 랜덤
		// 33~126 : 숫자 소문자 대문자 특수문자
		char[] tmpPassC = new char[8];
		for(int idx=0;idx<tmpPassC.length;idx++) {
			int ranCod =(int)(Math.random()*93+33);    //경우의 수 93가지 시작수33
			tmpPassC[idx] = (char)ranCod;
		}
		for(int idx=0;idx<tmpPassC.length;idx++) {
			System.out.println(tmpPassC[idx]);
		}
		
		System.out.println();
		//char[] ==> String으로 변환처리
		String tmpPass = new String(tmpPassC);
		System.out.println("최종 임시비번: "+tmpPass);
		

	
		
		
		
		
		
		
		
		
		
		
	}

}

class Person{
	String name = "홍길동";
}
