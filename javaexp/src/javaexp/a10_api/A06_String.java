package javaexp.a10_api;

import java.util.Scanner;

public class A06_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 문자열 처리 메서드
		1) indexOf("찾을 문자열")
			해당 문자열 안에서 찾을 문자열의 시작 위치를 index로 리턴 해준다
			해당 문자열을 포함하지 않으면 -1을 리턴한다
			ex) 키워드 검색할때 자주 사용 - 포함된 문자열의 시작 위치를 리턴
		2) length(): 문자열의 크기를 나타낸다
			cf) length : 배열의 크기와 구분
		3) 	
		*/
		String msg = "점심 맛나게 드실거죠?";
		int idxLoc = msg.indexOf("맛나게");
		System.out.println("시작위치:"+idxLoc);
		if(msg.indexOf("짜장면")!= -1) {// != -1 : 포함되면  == -1이 아닐때 검색이된다
			System.out.println("짜장면이 해당 문자열에 포함!");
		}else{
			System.out.println("짜장면이 해당 문자열에 포함되지않음");
		}
		System.out.println("문자열의 크기: "+msg.length());

		/*
		ex) 메뉴는 사과, 바나나 딸기입니다
		    선택한 과일을 입력하세요라고 Scanner 입력받아서 indexOf()에 확인하여 있으면 @@번째 과일입니다. 표시하고
		    없으면 해당 과일이 없습니다 라고 표시하세요	
		    
		    1) 문자열로 메뉴를 선언 "메뉴는 사과, 바나나, 딸기 입니다"
		    2) 각 문자열이 있는 시작위치를 확인 indexOf("사과")
		       해당 위치 지정
		    3) Scanner 입력 받아서 메뉴.indexOf(입력문자열)
		    4) 조건(if, switch)
		    	switch(입력받은 결과위치)
		    		-1 : 주문한 메뉴가 없음
		    		기타 해당하는 위치1 : 1번째 과일 사과를 주문하였습니다
		    		기타 해당하는 위치2 : 2번째 과일    를 주문하였습니다
		    		기타 해당하는 위치3 : 3번째 과일    를 주문하였습니다
		    		default : 입력범위를 벗어났습니다
		    		
		*/
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println(" < 메뉴 > ");
		System.out.println( "사과, 바나나, 딸기" );
		
		System.out.println("--메뉴 중에 과일을 선택해 입력하세요--");
		String str = sc.nextLine();
		
		String abs="사과 바나나 딸기";
		int idxabs=abs.indexOf(str);
		
		if(str.indexOf("사과")!= -1) {
			System.out.println(idxabs+"번째 과일입니다");
		}
	
		*/
		
		String menuIntr = "판매 과일은 사과, 바나나, 딸기입니다.";
//		System.out.println(menuIntr.indexOf("사과"));
//		System.out.println(menuIntr.indexOf("바나나"));
//		System.out.println(menuIntr.indexOf("딸기"));
		// 7, 11, 16 // 데이터 위치 확인
		
		System.out.println(menuIntr);
		System.out.print("선택할 과일을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		String chFruit = sc.nextLine(); // 입력할 과일
		
		int findIdx = menuIntr.indexOf(chFruit);
		switch( findIdx ) {
			case -1 : System.out.println("해당 과일은 메뉴에 없습니다."); break; // 메뉴가 없을 때 이야기
			case  7 : System.out.println("첫번째 과일 "+chFruit+"를 선택했습니다."); break;
			case 11 : System.out.println("두번째 과일 "+chFruit+"를 선택했습니다."); break;
			case 16 : System.out.println("세번째 과일 "+chFruit+"를 선택했습니다."); break;
			default : System.out.println("입력범위 초과 등 기타 유효성 문제");
		}
		System.out.println();
		System.out.println("프로그램 종료");
	}
}
