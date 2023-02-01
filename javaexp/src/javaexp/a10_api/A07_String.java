package javaexp.a10_api;

import java.util.StringTokenizer;

public class A07_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# String 기능 메서드
		1. replace("찾는 문자열", "변경할 문자열")
				
		*/
		String target = "자바는 객체지향프로그램입니다.\n"+"자바는 풍부한 API를 지원합니다~";
		String newStr = target.replace("자바","JAVA");
		System.out.println("기존문자열: ");
		System.out.println(target);
		
		System.out.println();
		System.out.println("변경한 문자열: ");
		System.out.println(newStr);
		System.out.println();
		
		
		/*
		2. substring("추출할 시작위치(0~), 추출할 마지막 위치(1~) )
			한다	
		*/		
		String subStr = target.substring(0,3); // index 1부터 3까지
		System.out.print("추출한 문자열: ");
		System.out.println(subStr);
		System.out.println();
		
		//ex 주민번호 앞자리 입력받아(2000년도 전 생일 기준)
		//   @@@@년 @@월 @@일생 출력하세요
		String num = "891231-1946294";
		String substrYNum=num.substring(0, 2);
		String substrMNum=num.substring(2, 4);
		String substrDNum=num.substring(4, 6);
		System.out.println("19"+substrYNum+"년 "+substrMNum+"월 "+substrDNum+"일생 ");		
		System.out.println();
		/*
		 * 선생님 풀이 
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 앞자리를 입력하세요(YYMMDD):");
		String civilNum = sc.nextLine();
		if(civilNum.length()==6) {
			String yyyy = "19"+civilNum.substring(0, 2);
			String mm = civilNum.substring(2, 4);
			String dd = civilNum.substring(4, 6);
			System.out.println(yyyy+"년 "+mm+"월 "+dd+"일 생입니다.");
		}else {
			System.out.println("입력형식은 6자리입니다");
		}
		*/
		
		/*
		3. split("구분자") : 특정문자열을 구분자에 의해 구분해서 구분된 데이터를 배열로 할당 처리
		
			"사과&3000&2@바나나&4000&3@오렌지&2000&4"
			==> 리스트
				사과		3000 2
				바나나	4000 3
				오렌지	2000 4
				1) 1단계 @ 구분자로 데이터 split처리
				   사과&3000&2     바나나&4000&3     오렌지&2000&4    
				   문자열 배열로 설정
				2) 2단계 & 구분자로 데이터 split 처리
			==> 1단계 2단계로 처리하려면 2중 for문을 활동하여 처리	
				String[] lev01 = str.split(@);
				for(String lvStr:lev01){
					String[] lev02 = lvStr.split("&");
					for(String lv2Str:lev02){
						lv2Str + "\t"
					}
					System.out.println();
				}
		 
		*/
		String[] fruits = "사과&바나나&딸기".split("&");
		//{"사과, "바나나", "딸기"}
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		
		
		// ex1) 서울-대전-대구-부산 과 같은 나열된 문자열을 split구무을 이용해서 배열로 만들어 향상된 for문을 통해서 출력하세요		     
		String[] countries = "서울-대전-대구-부산".split("-");
//		=
//		String data02 = "서울-대전-대구-부산";
//		String[] locs = data02.split("-");
		
		for(String country : countries) {
			System.out.print(country+" ");
		}
		
		
		/*
		# StirngTokenizer("문자열","구분자") 객체 활용
		1. 기능 메서드
			coutTokens() : 구분자를 통해 나온 데이터의 건수
			nextToken() : 구분자를 통해서 나온 각 데이터 하나씩, 호출시마다 하나씩 데이터를 가져온다
						  메서드를 호출하는 순간 저장되어있는 데이터가 하나씩 사라진다
						  while()문 사용하면 효과적
			hasMoreTokens() : 해당 데이터가 있을 때 True
							  while()문 등에서 위에 처리한 nextToken()이후에 데이터가 있는지 여부를 boolean으로 나타낸다

		*/
		StringTokenizer st = new StringTokenizer("오렌지&수박&딸기","&");
		int count = st.countTokens();
		System.out.println("# token #");
		for(int cnt=1;cnt<=count;cnt++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println("#while문활용#");
		st = new StringTokenizer("홍길동/김길동/신길동","/");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		
		//ex) StringTokenizer 객체를 이용하여 사과@3000@2개를 for/while문 하나씩 예제를 통하여 출력하세요
		String ex = "사과@3000@2개";
		StringTokenizer st2 = new StringTokenizer(ex,"@");
		// = StringTokenizer st2 = new StringTokenizer("사과@3000@2개","@");
		
		int len = st2.countTokens(); // 토큰(구분자)에 의해 구분된 데이터 건수
		System.out.println("< for문 >");
		for(int cnt =1; cnt<=len; cnt++) {
			// 바로 입력 시 countTokens() 개수가 줄어들어 3번까지 반복을 처리 못 함
			String token2 = st2.nextToken();
			System.out.print(token2+" ");
			// = System.out.println(cnt+":"+st2.nextToken());
		}
		System.out.println("\n");
		
		
		// 데이터를 초기화하는 처리가 필요하다
		st2 = new StringTokenizer(ex,"@");
		System.out.println("< while문 >");
		while(st2.hasMoreTokens()) {
			System.out.print(st2.nextToken()+" ");
		}
		
		
		
		
		
	}
}
