package javaexp.a05_restore;

import java.util.Scanner;

public class A03_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		# 배열이란
		1. 같은 타입의 데이터를 같은 이름으로 연속된 공간에 저장하는 자료구조를 말한다
		2. 같은 이름이기 때문에 각 구성데이터를 구분하는 구분자는 index로 0부터 시작하여 처리한다.
		
		무궁화호100 (서울~부산)
		1호차, 2호차, 3호차..
		무궁화호 100 1호차
		*/
		// 배열 선언하고 바로 할당한 경우
		int[] array01 = {1000, 2000, 3000, 4000}; // 객체
		System.out.println(array01); // 객체이기 때문에 heap 주소값 출력
		System.out.println(array01[0]); // 데이터값 출력		
		System.out.println(array01[1]);
		System.out.println(array01[2]);
		System.out.println(array01[3]);
		String[] array02 = {"사과", "바나나", "딸기"};
		System.out.println(array02); 
		System.out.println(array02[0]); 	
		System.out.println(array02[1]);
		System.out.println(array02[2]);
	
		/*
		
		ex1) 좋아하는 영화제목 3개를 배열로 선언할당하고 출력하세요
		ex2) KBO 타율 rank number3 선언할당출력
		
		*/
		
		// 풀이
		// 1
		String[] movieNa = {"어바웃타임", "괴물", "커피프린스1호점"};
		System.out.println(movieNa[0]);
		System.out.println(movieNa[1]);
		System.out.println(movieNa[2]);
		// 2
		String[] rankN = {"뭐야","누구야","1루"};
		System.out.println(rankN[2]);
		
		// 답
		// 1
		String []movies = {"공조2", "알라딘", "블랙폰"};
		// 2
		double []hitRatio = {0.347, 0.343, 0.317, 0.304};
		// 배열.length : 배열의 길이
		System.out.println("영화제목 길이: " + movies.length);
		System.out.println("타율배열의 길이: "+ hitRatio.length);
		// index와 길이는 1 차이가 난다. 반복조건문에 idx<배열.length
		for(int idx=0;idx<movies.length;idx++) {
			System.out.println(idx+":"+movies[idx]);
		}
		for(int idx=0;idx<hitRatio.length;idx++) {
			System.out.println(idx+"]"+hitRatio[idx]);
		}
		
		// ex 맛집 5를 배열로 선언하고 for문을 통해 출력
		// 풀이
		String []goodRes = {"텐동집", "백반집", "떡볶이집", "국수집", "서브웨이"};
		System.out.println("맛집의 길이 : "+goodRes.length);
		for(int idx=0;idx<goodRes.length;idx++) {
			System.out.println(idx+") "+goodRes[idx]);
		}
	
		// 정답
		String []restas= {"지로우라멘", "조선화로구이", "또보겠지떡볶이집", "홍스쭈꾸미", "몬비엣"};
		System.out.println("#홍대입구역맛집#");
		for(int idx=0;idx<restas.length;idx++) {
			System.out.println(idx+1+") "+restas[idx]);
		}
		
		/*
		# 배열의 처리
		1. 배열의 선언
		   타입[] 변수명;
		   타입 변수명[];
		   cf) 배열의 기본 유형으로 선언할 수 있을 뿐만아니라 객체형도 배열로 선언이 가능하다
		       int[] arry;
		       Person[] arry01;
		   
		2. 배열의 초기화
           변수명 = null; // 주소는 할당되지 않음
           - 모든 객체(배열, enum, 내장 객체, 사용자 정의 객체)
		3. 배열의 할당
		   1) 값이 할당되지 않았지만 주소는 생성된 경우(=heap영역에 객체는 생성
		     변수명 = new 타입[크기];
		   2) 선언 후 할당
		     타입[] 변수명 = null;
		     변수명 = new 타입[]{데이터1, 데이터2, 데이터3};
		     
		     타입[] 변수명 = {데이터1, 데이터2, 데이터3};
		     ex) 
		     int[] arry01 = null;
		     arry01 = new int[3];
		     
		     int[] arry02 = new int[5];
		     
		     int[] arry03 = null;
		     array03 = new int[]{1000,2000,3000}
		     
		     int[] array04 = {4000,5000,6000}
		*/
		
		int[] arry10;
		int arry11[];
		arry10 = null;
		arry11 = null;
		int[] arry12 = null;
		int[] arry13 =new int[3];
		arry12 = new int[] {1000, 2000, 3000};
		int[] arry14 = {5000, 6000, 7000};
		System.out.println(arry10);
		System.out.println(arry11);
		System.out.println(arry12);
		System.out.println(arry13);
		System.out.println(arry14);
		// ex) 도서명배열, 운동선수배열, 핸드폰회사배열을 선언, 선언 후 할당, 빈배열 3가지 형태로 선언과 할당하세요
		
		// 풀이
		String[] bookAr;
		bookAr = null; // 선언
		System.out.println(bookAr);
		
		String[] arAr;
		arAr = new String[] {"박세리","박지성","박찬호"}; // 선언 후 할당
		System.out.println(arAr);
		
		String[] cell = {"삼성","애플","팬택"}; // 빈배열,,?
		System.out.println(cell);
		
		// 정답
		String[] books = null; // 선언
		String[] players = null;
		players = new String[] {"홍길동","김길동","이길동"};// 선언후 할당
		String[] elCom = new String[3]; // 빈배열
		System.out.println(books);
		System.out.println(players);
		System.out.println(elCom);
		
		/*
		# 여러가지 응용 예제 활용하기
		1. 배열의 index를 랜덤으로 호출하여 출력
		
		*/
		
		String[] games = {"가위","바위","보"};
		int rIdx1 = (int)(Math.random()*games.length);
		int rIdx2 = (int)(Math.random()*games.length);
		System.out.println(games[rIdx1]+"vs"+games[rIdx2]);
		
		// ex) 홀짝 게임을 5회 처리하여 출력하세요
		// 풀이
		String[] games00 = {"홀", "짝"};
		int gIdx1 = (int)(Math.random()*games00.length);
		int gIdx2 = (int)(Math.random()*games00.length);
		int gIdx3 = (int)(Math.random()*games00.length);
		int gIdx4 = (int)(Math.random()*games00.length);
		int gIdx5 = (int)(Math.random()*games00.length);
		System.out.println("1회: "+ gIdx1);
		System.out.println("2회: "+ gIdx2);
		System.out.println("3회: "+ gIdx3);
		System.out.println("4회: "+ gIdx4);
		System.out.println("5회: "+ gIdx5);
		
		// 정답
		String[] game2 = {"홀", "짝"};
		for(int cnt=1; cnt<=5; cnt++) {
			int rIdx3 = (int)(Math.random()*game2.length);
			System.out.println(cnt+"번째"+game2[rIdx3]);
		}
	
		/*
		2. 초기의 배열의 크기를 설정한 후 데이터 할당 처리
		
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 회원의 인원을 입력: ");
		int cnt = Integer.parseInt(sc.nextLine());
		
		String[] names= new String[cnt];   // new가 있는 순간 배열이 만들어짐
		System.out.println("# 회원 "+cnt+"명의 이름을 입력하세요 #");
//		String[] names= new String[3];      // 3명으로 지정하고 싶을 때
//		System.out.println("# 회원 3명의 이름을 입력하세요 #");
//		Scanner sc = new Scanner(System.in);
		
		for(int idx=0;idx<names.length;idx++) {
			System.out.print(idx+1+"번째 회원명: ");
			names[idx] = sc.nextLine();
		}
		System.out.println("# 등록한 회원명단 #");
		for(int idx=0;idx<names.length;idx++) {
			System.out.println(idx+1+"번째 회원 - " +names[idx]);
		}
		
		
		// ex) 대출할 책의 수를 입력하고 도서명을 입력한 후, 대출 도서 리스트를 출력하세요
		// 풀이
		Scanner sc = new Scanner(System.in);
		System.out.print("대출할 책의 권수를 입력: ");
		int cntB = Integer.parseInt(sc.nextLine());
		
		String[] nameB = new String[cnt];
		System.out.println(" 대출하는 책의 도서명 전부를 입력하세요: ");
		
		for(int idx=0;idx<nameB.length;idx++); {
			System.out.println(idx+1+"번째 도서명: ");
			nameB[idx] = sc.nextLine();
		}
		System.out.println("# 대출한 도서 리스트 #");
		for(int idx=0;idx<nameB.length;idx++); {
			System.out.println(idx+1+"번째 도서명 - "+nameB[idx]);
		}
		// 정답
		Scanner sc2 = new Scanner(System.in);
		System.out.print("대출할 책의 권수를 입력: ");
		int bCnt = Integer.parseInt(sc2.nextLine());
		
		String[] bList = new String[bCnt]; 
		System.out.println(" 대출하는 책의 도서명 전부를 입력하세요: ");
		
		for(int idx=0;idx<bList.length;idx++); {
			System.out.println(idx+1+"번째 도서 입력: ");
			bList[idx] = sc2.nextLine();
		}
		System.out.println("# 대출할 도서 리스트 #");
		for(int idx=0;idx<bList.length;idx++); {
			System.out.println((idx+1)+") "+bList[idx]);
		}
		
		
		
		String shape[] = {"♠","♥","♣","◈"};
		String []nums = {"A","2","3","4","5","6","7","8","9","10","K","Q","J"};
		String cards[] = new String[52];
		int cIdx=0;
		
		for(int idx=0;idx<shape.length;idx++) {
			for(int jdx=0;jdx<=nums.length;jdx++) {
				cards[cIdx++]=shape[idx]+""+nums[jdx];
				System.out.println(cards[cIdx]+",");
				cIdx++;
			}
		}
		System.out.println();
		System.out.println("# 임의의 7장 카드 #");
		for(int cnt1=1;cnt1<=7;cnt1++) {
			int rIdx = (int)(Math.random()*cards.length);
			System.out.print(cards[rIdx]+",");
		}
			
		
		
		
	}

}
