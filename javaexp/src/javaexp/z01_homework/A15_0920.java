package javaexp.z01_homework;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class A15_0920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-20
[1단계:개념] 1. String 문자열 byte데이터부터 만들어지는 과정을 기술해보자.
[1단계:코드] 2. 한글 무지개 색상 첫자를 코드값을 확인하여 임의의 색상 5가지를 문자열로 만들어 출력하세요.
[1단계:코드] 3. Hello! 자바!를 한글 encoding방식 euc-kr와 utf-8로 설정하여 문자열로 출력하세요.
[1단계:개념] 4. 오늘 진행한 문자열 관련 기능메서드의 기능을 기본예제와 함께 정리하세요.
[1단계:코드] 5. switch case문을 활용하여 주문할 메뉴 짜장면, 짬뽕, 탕수육 입니다. indexOf를 사용하여 해당 메뉴가 있으면, @@번 메뉴 주문하였습니다.
             없으면 없는 메뉴입니다로 표시하세요.
[1단계:코드] 6. 다음과 같은 고등학교 학번을 아래 형식을 기준으로 입력받아 @@고등학교 @@학년 @@반 @@@로 출력하세요
              형식  "세화030523홍길동" ==> 세화고등학교 03학년 05반 23번 홍길동
[1단계:코드] 7. 사과&3000&2-딸기&12000&3-오렌지&3000&3를 split을 이용해서 단위별로 출력(이중 for문 활용)하세요
[1단계:개념] 8. StringTokenizer의 기능 메서드를 기술하세요
[1단계:개념] 9. StringBuffer를 문자열 추가시, 사용하는 이유와 주요 기능 메서드를 기술하세요.
[1단계:코드] 10. StringBuffer로 두 팀의 임의의 주사위 던지기 10회 내용과 결과를 저장하고, 마지막에 출력하세요.
              no  홍  청  결과
              1   3   4  청승
              2   4   4  무

[1단계:개념] 11. Wrapper클래스란 무엇인가? 유형과 형식을 기술하세요
[1단계:개념] 12. boxing과 auto boxing, unboxing, auto unboxing의 개념을 예제를 통해서 기술하세요
[1단계:코드] 13. Scanner nextLine()으로 문자열로 두개의 수를 입력 받아서 Boxing으로 Wrapper객체를 만든 후, 다시 Unboxing으로 합산된 결과를 출력하세요.
[1단계:코드] 14. ArrayList로 임의의 수학점수(0~100) 정수형데이터 반복문에 의해 5개 데이터를 나오게 한후, autoBoxing에 의해 할당처리하세요.
[1단계:코드] 15. Random 클래스를 이용해서 3과목의 점수를 임의로 출력하세요.
*/
		
		
		//1 
		/*
		   bit  : 데이터 최소단위  (ex. 0
		>> byte : bit가 8개, 정수형의 가장 기본 데이터  (ex.01000112
		>> char : 숫자들에 코드를 대입해서 문자를 설정하여 생성   (ex.'A'
		>> char[] : 문자들을 배열로 만들어서 문자열 사용   (ex. {'H','e','l','l','o'}
		>> String : 객체지향프로그램으로 Stirng문자열 객체 만듦.
		 
		 *** {25,34,72,43,22} : bytes배열은 코드값으로 문자열을 사용할 수 있다
		*/
		
		//2
		// 코드값 확인 48744, 51452, 45432, 52488, 54028, 45224, 48372
//		System.out.print((int)'빨'+", ");
//		System.out.print((int)'주'+", ");
//		System.out.print((int)'노'+", ");
//		System.out.print((int)'초'+", ");
//		System.out.print((int)'파'+", ");
//		System.out.print((int)'남'+", ");
//		System.out.println((int)'보');
		int []arr01 = {48744, 51452, 45432, 52488, 54028, 45224, 48372};
		System.out.println("< 다섯 색깔 무지개 >");	
		for(int idx=1; idx<=5; idx++) {
			int rnum = (int)(Math.random()*7);
			System.out.print((char)arr01[rnum]+" ");
		}
		System.out.println();
		System.out.println();
		
		//2 정답
		/*
		# 처리순서
		1. 색상 문자열 선언
		2. getBytes byte 배열로 확인, 새로 생성할 임의 색성 배열 선언
		3. for 5번 호출 및 랜던 호출
		   임의 색상 코드값 배열에 할당
		4. new String(newByte) 할당 후 출력
		*/
		String rbColor ="빨주노초파남보";
		// # char[] <==> String
		// .toCharArray() : String ==> char[]
		// String s = new String(char[]); : char[] ==> String
		char[] arr = rbColor.toCharArray(); 
		// 배열로 위 색상의 한글 코드값을 저장
		char[] ranChar = new char[5];
		for(int cnt=1;cnt<=5;cnt++) {
			int rCIdx = (int)(Math.random()*arr.length);
			// "빨주노초파남보"를 char배열로 만든 내용 중에 한개 임의 추출 
			char charVal = arr[rCIdx];
			System.out.println(cnt+"번째 색: "+charVal);
			// 새로만든 ranChar에 하나씩 할당..
			ranChar[cnt-1] = charVal;
		}
		String ranColor = new String(ranChar);
		System.out.println("임의의 5가지 색상: "+ranColor);
	
		
		//3
		String str01 = "Hello! 자바!";
		try {
		byte[] bytes01 = str01.getBytes("EUC-KR");
		System.out.println("euc-kr 문자열: "+new String(bytes01));
		
		byte[] bytes02 = str01.getBytes("UTF-8");
		System.out.println(" utf-8 문자열: "+new String(bytes02));
		
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//4
		/*
		<문자열 관련 기능 메서드>
		1.  .charAt(int idx) : 특정위치에 문자 리턴
		2.  .getBytes() : 문자열의 byte배열을 가져옴, 한글 encoding형식을 EUC-KR이나 UTF-8로 지정할 수 있다 
		3.  .indexOf("찾을 문자열") : 해당 문자열 안에서 찾을 문자열의 시작 위치를 index로 리턴 해줌. 
		                           해당 문자열을 포함하지 않으면 -1을 리턴
		4.  .length() : 문자열의 크기를 나타낸다, *배열의 크기는 length 구별할 것
		5.  .replace("찾는 문자열", "변경할 문자열")  
		6.  .substring("추출할 시작위치","추출할 마지막 위치") : 특정한 문자열에서 문자열을 추출하여 문자를 만들 때 사용
		                                                 "추출할 시작위치" <   범위  <= "추출할 마지막 위치"
		7.  .split("구분자") : 특정문자열을 구분자에 의해 구분해서 구분된 데이터를 배열로 할당 처리                  
		
		8. StirngTokenizer("문자열","구분자") 객체 
			1) coutTokens()  : 구분자를 통해 나온 데이터의 건수
			2) nextToken()   : 구분자를 통해서 나온 각 데이터 호출할 때마다 하나씩 데이터를 가져온다
			3) hasMoreToken() : 해당 데이터가 있을 때 True
			
		9. StringBuffer, StringBuilder 객체 :버퍼(buffer: 데이터를 임시로 저장하는 메모리)에 문자열 저장
			1) append(...)
			2) insert(int offset,...)
			3) delete(int start, int end) : 범위를 정해서 삭제
			4) deleteCharAt(int index)    : 특정한 위치 문자 삭제
			5) replace(int start, int end, Stirng str) : 특정한 위치 문자 대체
			6) reverse() : 문자열을 뒤집어 사용
			7) setCharAt(int index, char ch) : 특정한 위치에 문자를 대체
		*/
		
		// 5
		Scanner sc = new Scanner(System.in);
		String menuInfo = "짜장면, 짬뽕, 탕수육";
		// 데이터 위치 각각 0,5,9
//		System.out.println(menuInfo.indexOf("짜장면"));
//		System.out.println(menuInfo.indexOf("짬뽕"));
//		System.out.println(menuInfo.indexOf("탕수육"));	
		System.out.println("\t  <  메 뉴  >  ");
		System.out.println("\t"+menuInfo);
		System.out.print("선택한 메뉴를 적어주세요(메뉴 1개): ");
		String chFood = sc.nextLine();
		
		int midx = menuInfo.indexOf(chFood); 
		switch( midx ) {
		case -1 : System.out.println("없는 메뉴입니다."); break;
		case  0 : System.out.println("1번 메뉴 "+chFood+"을 주문하였습니다."); break;
		case  5 : System.out.println("2번 메뉴 "+chFood+"을 주문하였습니다."); break;
		case  9 : System.out.println("3번 메뉴 "+chFood+"을 주문하였습니다."); break;
		default : System.out.println("준비하지 않은 메뉴 혹은 한 개 이상의 메뉴를 적었습니다.");
		}
		System.out.println("주문이 완료 되었습니다.");
		System.out.println();
		
		//6
		Scanner sc2 = new Scanner(System.in);
		System.out.println("<< 학교학년반학번이름을 입력하세요 >>");
		System.out.println("ex)솔내고등학교 1학년 3반 5번 이지은 >> 솔내010305이지은\n ");
		String hschNum= sc2.nextLine();
		if(hschNum.length()==11) {
			String sch = hschNum.substring(0,2);
			String grd = hschNum.substring(2,4);
			String cls = hschNum.substring(4,6);
			String num = hschNum.substring(6,8);
			String name = hschNum.substring(8,11);
			System.out.println(sch+"고등학교 "+grd+"학년 "+cls+"반 "+num+"번 "+name);
		}else {
			System.out.println("입력형식은 11자리입니다. 입력창을 확인해주세요.");
		}
		System.out.println();
		
		//7
		String[] prods = "사과&3000&2-딸기&12000&3-오렌지&3000&3".split("-");
		for(String prod : prods) {
			for(String detail : prod.split("&")) {
				System.out.print(detail+"  ");
			}
		}
		System.out.println();
		
		// 7 정답
		/*
		1) 구분자로 데이터 split 처리
		2) for문을 통해서 &구분자로 split 처리
		3) 출력 형식을 처리
		*/
		String data ="사과&3000&2-딸기&12000&3-오렌지&3000&3";
		String []lev1 = data.split("-");
		for(String str1 : lev1) {
//			System.out.println(str1); // 한 번 찍어본거
			String[] lev2 = str1.split("&");
			for(String str2:lev2) {
				System.out.print(str2+"\t");
			}
			System.out.println(); // 이걸로 줄(문단)이 나눠졌나... 맞음
		}
		
		//8
		/*
		StirngTokenizer("문자열","구분자") 객체 
			1) coutTokens()  : 구분자를 통해 나온 데이터의 건수
			2) nextToken()   : 구분자를 통해서 나온 각 데이터 호출할 때마다 하나씩 데이터를 가져온다
			3) hasMoreToken() : 해당 데이터가 있을 때 True	
		*/
		//9
		/*
		<StringBuffer를 사용하는 이유>
		  String 문자열은 +를 통해서 새롭게 heap영역에 만들어지기 때문에 반복문을 활용하면 더해진만큼의 많은 객체가 만들어지게 된다
		  따라서 문자열을 +를 통해서 만들면 새로운 메모리가 만들어지므로 특히 반복문 안에서 사용하는 것은 가능한한 자제하여야 한다.
		  하지만 StringBuffer를 사용하면 데이터를 임시로 저장하는 메모리인 buffer, 
		  즉 같은 주소값(같은 메모리)을 쓰면서도 많은 문자열이 생성가능하기 때문이다.
		<주요 기능 메서드>
			1) append(...)
			2) insert(int offset,...)
			3) delete(int start, int end) : 범위를 정해서 삭제
			4) deleteCharAt(int index) : 특정한 위치 문자 삭제
			5) replace(int start, int end, Stirng str) : 특정한 위치 문자 대체
			6) reverse() : 문자열을 뒤집어 사용
			7) setCharAt(int index, char ch) : 특정한 위치에 문자를 대체
		*/
		//10
//		String tlt ="no\t홍\t청\t결과";
//		StringBuffer sbf = new StringBuffer(tlt);
		
		StringBuffer sbf = new StringBuffer("< 주사위 던지기 게임 10회 >\nno\t홍\t청\t결과\n");
		for(int cnt=1;cnt<=10;cnt++) {
			int rIdxR = (int)(Math.random()*6+1);
			int rIdxB = (int)(Math.random()*6+1);
			// String rs = rIdxR>rIdxB?"홍승":((rIdxR<rIdxB)?"청승":"무")+"\n"; 따로 선언 해도 좋음  // heap영역에 메모리3개만 차지
			sbf.append(cnt+"회\t"+rIdxR+"\t"+rIdxB+"\t"+(rIdxR>rIdxB?"홍승":(rIdxR<rIdxB)?"청승":"무")+"\n"); // 결과는 같은 메모리안에 누적됨
		}
		System.out.println(sbf.toString());
		
		// 10 정답
		/*
		# 처리 순서
		1) StringBuffer sbf 초기 선언
		2) 반복문 for 1~10
		3) 홍팀과 청 팀 점수 임의(1~6)
		   int red = (int)(Math.random()*6+1); 
		   int blue = (int)(Math.random()*6+1); 
		   String rs = red>blue?"홍승":(blue>red?"청승":"무승부");
		   sbf.append(cnt+"\t"+red+"\t"+blue+"\t"+rs+"\n")
		4) 반복문 후 출력
		   sbf.toString();
		*/
		
		
		//11
		/*
		  1. Wrapper 객체
            기본 타입(byte, char, short, int, long, float, double, boolean)값을 내부에 두고 포장하는 객체를 말한다.
            객체로 전환되는 순간, 여러가지 기능 메서드가 지원되기에 데이터변환이나 기능처리를 할 수 있기때문이다.
          2. Wrapper class(포장 클래스)
			대부분은 기본유형타입에서 대문자로 시작하여 선언한다
			byte ==> Byte
			short ==> Short
			double ==> Double
			단, 아래 두가지만 긴문자형식으로 Wrapper클래스를 선언한다
			char ==> Character
			int ==> Integer
         3. 기본 유형의 데이터를 Wrapper객체로 변환 처리
            int num01 = 25;
            Integer num01Obj = new Integer(num01);
		*/
		//12
		/*
		1. 박싱(Boxing)과 언박싱(Unboxing)
			기본데이터 <==> Wrapper
			1) 박싱 : 기본 타입의 값을 포장(Wrapper)객체로 만드는 과정을 말한다
				Integer obj1 = Integer.valueOf(1000);
				Byte obj2 = Byte.valueOf(25);
			2) 언박싱 : 포장 객체에서 기본 타입의 값을 얻어내는 과정
				byte value1 = obj2.byteValue();
				int value2 = obj1.intValue();
		2. autoBoxing, autoUnboxing
			기본데이터 <==> Wrapper
			위 기본 박싱과 언박싱을 거치지 않고 바로 할당하는 것을 jvm에서 내부적으로 지원한다
			1) autounBoxing
				Integer obj1 = 30;
				Double obj2 = 30.25;
			2) autoUnboxing
				int num1 = obj1;
				double obj2 = obj2;
		*/
		//13
		Scanner sc3 = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		String numOne = sc3.nextLine();
		System.out.print("숫자를 한 번 더 입력하세요: ");
		String numTwo = sc3.nextLine();
		
		Integer obj1 = Integer.valueOf(numOne); // boxing >>Wrapper객체 생성 //boxing으로 데이터 할당 // 숫자든 문자든 다 들어갈 수 있음
		Integer obj2 = Integer.valueOf(numTwo); // boxing >>Wrapper객체 생성
		int result = obj1.intValue()+obj2.intValue(); // unboxing
		// int num1 = obj1; 
		// int num2 = obj2; // autoUnboxing
		
		System.out.println("입력한 두 숫자의 합: "+result);
		
		//13 정답
		/*
		1) Scanner 객체 생성
		2) 입력문자열 1, 입력문자얄2
		3) Wrapper Integer num01Obj, num02Obj 할당 //Boxing 처리 - 숫자형 문자열 ==> Wrapper 객체
		4) AutoUnBoxing
			int num01 = num01Obj;
			int num02 = num02Obj;
		5) 합산 출력
			num01 + num02;
		*/
		
		//14 ArrayList <MathScore> mslist// 이런 거는 안되는 건가.. 
		ArrayList <Integer> mslist = new ArrayList<Integer>();
		
		for(int cnt=1;cnt<=5;cnt++) {
			int rscore = (int)(Math.random()*101);
			mslist.add(rscore);
		}
		System.out.println("< 수학 점수 확인 >");
		System.out.print(mslist.get(0)+", ");
		System.out.print(mslist.get(1)+", ");
		System.out.print(mslist.get(2)+", ");
		System.out.print(mslist.get(3)+", ");
		System.out.println(mslist.get(4));
		System.out.println();
		
		// 14 정답
		// 기본 정수 ==> autoboxing에 의애 Wrapper 할당
		Integer numObj = (int)(Math.random()*101);//autoboxing
		System.out.println("Auto Boixng: "+numObj);
		
		ArrayList <Integer> iList = new ArrayList<Integer>();
		// Integer 형태의 객체가 ArrayList로 만들어진 구조
		// int num = (int)(Math.random()*101);
		// iList.add( new Integer( num ) );  Boxing
		
		for(int cnt=1;cnt<=5;cnt++) {		
			iList.add((int)(Math.random()*101));
			System.out.println(iList);
		}
		
		
		
		//15	
		Random rsc = new Random();
		System.out.println("첫번째 과목 점수: "+rsc.nextInt(101));
		System.out.println("두번째 과목 점수: "+rsc.nextInt(101));
		System.out.println("두번째 과목 점수: "+rsc.nextInt(101));
		
	
		
	
		
	
	}
}
