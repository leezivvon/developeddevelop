package javaexp.a04_process;

public class A08_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# While문 : 조건에 따라 반복을 계속할지 결정할 때 상ㅇ
		1. while문 형식
		   while(반복조건){
		        조건이 true일 때
		        반복처리..
		   }
		
		
		*/
		
		
		int cnt =1;
		while(cnt<=10 ) {
			System.out.println((cnt++)+"번째");
		}
		
		/*
		cnt=1;
		Scanner sc =new Scanner(System.in);
		while(true) { //무한 루프
			System.out.println("카운트: "+(cnt++));
			System.out.print("계속하실려면 Y: ");
			String isCon =sc.nsxtLine(); //
			if(!isCon.equals("Y")) {
				break; //반복중단 처리
			}
		}
		System.out.println("프로그램 종료!!");
		*/
		
		
		
		// ex1) while문을 이용해서 100부터 90까지 출력하세요
		//풀이
		int cnt0 = 100;
		while(cnt0>=90) {
			System.out.println(cnt0);
		}
		//정답
		int cnt1=100;
		while(cnt1>=90) {
			System.out.println("카운트다운: "+cnt1--);
		}
		
		
		/*
		   ex2) 사과의 단가가 1200일 때, 더 구매하시겠습니까? Y일때,
		   @@개 구매 @@@원 누적출력 처리
		 */
		 //풀이
		int appleCnt = 1;
		int applePri = 1200;
		while(true) {
			System.out.println(appleCnt+"개 구매 "+appleCnt++*applePri+"원");
		}
		
		//정답
		Scanner sc =new Scanner(System.in);
		int appPrice=1200;
		int appCnt=1;
		while(true) { //break;를 만나기 전까지 무한루프
			System.out.println(appCnt+"개 구매 "+appPrice*appCnt+" 원");
			System.out.println("구매를 중단하시겠습니까? ");
			// 입력받은 데이터를 바로"Y"인지 여부를 boolean으로 확인
			if(sc.nextLine().equals("Y")) {
				//break는 for문while문 반복문에 다 사용됨
				break;
			}
			appCnt++; //Y 아니면 계속 증가
		}
		System.out.println("구매종료!!");
		
		
		
		
		
		
		
		
	}

}
