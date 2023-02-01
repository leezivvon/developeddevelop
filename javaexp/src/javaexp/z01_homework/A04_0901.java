package javaexp.z01_homework;

import java.util.Scanner;

public class A04_0901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
0901과제
[1단계:개념] 1. 증감연산식의 앞에 ++, 뒤에 ++의 차이점을 예제를 통하여 기술하세요.
[1단계:개념] 2. Math.random()을 통해 임의의 정수를 처리하는 공식을 예제를 통해 기술하세요.
[1단계:코드] 3. 임의의 점수(0~100)처리하고 아래와 같이 비교 연산식을 이용하여 boolean(true/false) 처리하세요
   1) 점수를 지정하여 A학점(90이상 경우) 여부를 출력하세요
   2) 점수를 지정하여 60점 미만인 경우 과락이면, 과락여부를 출력
[1단계:개념] 4. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
[2단계:코드] 5. 삼항연산자를 이용하여 놀이공원에 입장료가 50000원 일 때, 나이가 6미만이거나 65세 이상일 때는 무료,
      14~17일 때는 청소년 요금으로 20%할인이 된다. 나이에 따라 무료여부와, 청소년요금제 여부를
      처리하고, 총비용을 출력하세요
[1단계:개념] 6. main()에서 데이터의 기본 흐름 방향을 기술하고, 조건문이 처리되는 형식에 따른
            플로우를 설명하세요.
[1단계:코드] 7. 컴퓨터로 하여금 구슬을 1~7개를 임의로 쥐게 하고, 내가 Scanner를 통해 홀/짝을 입력하여,
      맞으면 승, 틀리면 패로 처리하세요. 
[3단계:코드] 8. 두명의 친구(이름입력)가 주사위 2개로 게임을 진행하였다. 결과를 표시하세요 
[1단계:코드] 9. 컴퓨터가 가위, 바위, 보를 내게 하고, 내가 가위 바위 보를 Scanner을 냈을 때, 승/무/패가
      되게 조건 처리하세요.	
				
				*/
		
		
		
		// 1.
		
		/*
		  2.(int)(Math.random()*경우의 수+시작 수)
		     1~100까지 임의의 정수 도출 : (int)(Math.random()*101+1) 
		 */
		
		// 3.
        // 1)
		int scoreR01 = (int)(Math.random()*101);
		Boolean score01 = scoreR01>=90;
		System.out.println("학점: "+scoreR01);
		System.out.println("A학점입니까? "+score01);
		// 2)
		int scoreR02 = (int)(Math.random()*101);
		Boolean score02 = scoreR02<60;
		System.out.println("학점: "+scoreR02);
		System.out.println("과락입니까? "+score02);
		
	
		// 4. 단항연산자, 이항연산자, 삼항 연산자의 차이점은 피연산자 수의 차이이다.
		// 단항연산자에는 부호연산자+,- 증감연산자++,-- 논리부정연산자! 가 있다
		// 이항연산자에는 산술연산자, 문자열연산자, 대입연산자, 비교 연산자 가 있다
		// 삼항연산자 (비교연산자, 논리연산자)?true일때:false일때 .
		int point = 80;
		String result = (point>=60)?"합격":"불합격";
		System.out.println("결과:"+result);
		
		// 5.
		int ticket = 50000;
		int age01 = (int)(Math.random()*100+1);
		int age02 = (int)(Math.random()*100+1);
		int result01 = (age01<6 || age01>=65)?0:ticket;
		int result02 = (age02<6 || age02>=65)?0:ticket;
		System.out.println("나이01: "+age01);
		System.out.println("요금01: " + (result01 ==0? "무료":(age01>=14&&age01<=17?(ticket*0.8):ticket)));
		System.out.println("나이02: "+age02);
		System.out.println("요금02: " + (result02 ==0? "무료":(age02>=14&&age02<=17?(ticket*0.8):ticket)));
		System.out.println("총 요금: " 
		+ (result01 ==0? "무료":(age01>=14&&age01<=17?(ticket*0.8):ticket))
		+ (result02 ==0? "무료":(age02>=14&&age02<=17?(ticket*0.8):ticket)));
		
		//6. main()에서 데이터의 기본 흐름 방향은 위에서 아래로 흐른다. 조건문의 흐름은.. 잘 모르겠다..ㅠ
	    
		//7. 
	      
	     int bubble00;
	     bubble00 = (int)(Math.random()*7+1);
	     Scanner sc00 = new Scanner(System.in);   
	     System.out.println("구슬이 홀수 개 일까요, 짝수 개일까요??\n홀수와 짝수 중 하나를 입력하세요!!");
	     String chPeo = sc00.nextLine();
	     
	     String com00 = "";
	     System.out.println("컴퓨터가 가진 구슬의 개수는!! "+bubble00);
	     if(bubble00%2==0) {
	    	 com00="짝수";
	     }else {
	    	 com00="홀수";
	     }
	     if(chPeo.equals(com00)) {
	    	 System.out.println("승!!! 당신이 이겼습니다!!");
	     }else {
	    	 System.out.println("패!! 당신이 졌습니다!!");
	     }
	     
	     
	     
		//8.
			int spDic=(int)(Math.random()*6+1);
			int yulDic=(int)(Math.random()*6+1);
			System.out.println("소피아의 주사위 숫자는??  "+spDic);
			System.out.println("율리아의 주사위 숫자는??  "+yulDic);
			if(spDic==yulDic) {
				System.out.println("비겼습니다!!");
			}else if(spDic>yulDic) {
				System.out.println("소피아가 이겼습니다!!! 율리아는 졌군요..");
			}else {
				System.out.println("율리아가 이겼습니다!!! 소피아는 졌군요..");
			}
	     
		
		// 9.
		
		 int rsp = (int)(Math.random()*3);
		 
		 String sePeo, roPeo, paPeo;
		 sePeo="가위"; roPeo="바위"; paPeo="보"; 
		 
		 System.out.println("!!가위 바위 보 게임을 시작합니다!!\n가위 바위 보 중 하나를 입력하세요.");
		 Scanner sc = new Scanner(System.in);
		 String rspPeo=sc.nextLine();
		 
		 String com = ""; 
		 System.out.println("컴퓨터의 선택은!!"); 
		 if(rsp==0) {
			  System.out.println("가위!!"); 
			  com = "가위"; 
			  }else if(rsp==1) {
			 System.out.println("바위!!"); 
			 com = "바위"; 
			  }else { 
				  System.out.println("보!!");
			      com ="보"; } 
		 if(rspPeo.equals(com)) { 
			 System.out.println("비겼습니다!!"); 
			 } else if(rspPeo.equals(sePeo) && com=="보") {
				 System.out.println("축하해요!! 당신이 이겼습니다!!");
			 } else if(rspPeo.equals(roPeo) && com=="가위") {
				 System.out.println("축하해요!! 당신이 이겼습니다!!");
			 } else if(rspPeo.equals(paPeo) && com=="바위") {
				 System.out.println("축하해요!! 당신이 이겼습니다!!");
			 } else {
				 System.out.println("안타깝군요!! 당신이 졌습니다!!");
			 }
		
		
		
		 
		 //5번의 총요금 내는 법을 잘 모르겠어요
		 
		 
		 
		 
		 // 정답
		 
			/*
			1. 
			해당 프로세스에서 ++에서 바로 증가를 처리해서 나타나느냐?
			다른 호출 시 나타나느냐
			int cnt = 1;
			system.out.println(++cnt) // 2출력
			
			int cnt1 =1;
			system.out.println(cnt1++); // 1출력
		    system.out.println(cnt1); // 2출력
			
			
			*/
		 
		 //3.
		 
		 int pt = (int)(Math.random()*101);
		 System.out.println("학점: "+pt);
		 System.out.println("A학점여부:"+(pt>=90)); //1)
		 System.out.println("과락여부:"+(pt<90)); //2)
		 
			/*
			4.
			단항연산자 +25, -25, -num01, ++cnt, cnt--, cnt+=2
			이항연산자 25 + 3, num01 + num02,
			삼항연산자 조건식 : 조건?true일때:false일때
			                point>=60?"합격":"불합격"
			*/
		 
		 //5.
		 int pay= 50000;
		 int age = (int)(Math.random()*80+1);
		 System.out.println("나이: "+age);
		 System.out.println(age<6||age>=65?"무료":"유료");
		 System.out.println(age>=14&&age<18?"청소년요금":"기타요금");
		 double disRatio = (age<6||age>=65?1.0:(age>=14&&age<18?0.2:0.1)); //할인율
		 System.out.println("할인율:"+(int)(disRatio*100)+"%");
		 pay = pay-(int)(pay*disRatio);  //총요금
//		 pay -=(int)(pay*disRatio); //총요금
		 System.out.println("총비용:" + pay); 
		 
			/*
			  6.
			  기본 플로우는 위에서 아래로 왼쪽에서 오른쪽으로 흐름 처리가 된다
			  단, 대입연산자는 데이터가 오른쪽에서 왼쪽으로 대입이 된다.
			  조건문인 경우에는 해당 조건이 true인 경우에 플로우가 진행 처리된다.
			  false인 경우에는 진행됮 않음
			  cf) 반복문인 경우에는 반복 조건이 true인 경우에만 반복을 수행처리한다. 
			  
			 */
	      
		 //7 .
		 
		 int ComCnt = (int)(Math.random()*7+1);
		 Scanner scsc = new Scanner(System.in);
		 System.out.println("# 홀짝 게임# ");
		 System.out.print("홀/짝을 선택하세요: ");
		 String myCh = scsc.nextLine();
		 System.out.println("컴퓨터의 구슬 개수: "+ComCnt);
		 String comCh = "홀"; // 컴퓨터의 값을 초기값으로 홀 할당
		 if(ComCnt%2==0) comCh = "짝"; // 그래서 else문이 없이 처리 가능
//		 String comCh = ComCnt%2==0?"짝":"홀"; //삼항연산자를 사용해도 됨
		 
		 if(myCh.equals(comCh)) { // 문자열 비교시 java에서는 .equals()를 사용// 문자열에는 == 사용하는 것이 아님!!(자바에서는)
			 System.out.println("나의 승!!");
		 }else {
			 System.out.println("컴퓨터의 승!!");
		 }
		 
		 //8. 스캐너로 이름을 입력해달라는 뜻
		 
		 Scanner sc1 = new Scanner(System.in);
		 System.out.println("# 주사위 게임 #");
		 System.out.println("첫번째 선수입장 이름입력: ");
		 String player01 = sc1.nextLine();
		 System.out.println("두번째 선수입장 이름입력: ");
		 String player02 = sc1.nextLine();
		 int player01Dice = (int)(Math.random()*6+1);
		 int player02Dice = (int)(Math.random()*6+1);
		 System.out.println(player01+":"+player01Dice);
		 System.out.println(player02+":"+player02Dice);
		 String rs = player01Dice>player02Dice?player01+"승":(player01Dice<player02Dice?player02+"승":"무승부");
		 System.out.println("결과: "+rs);
		 
		 
		 //9.
		 /*
		 최적의 방법
		 가위 0
		 바위 1
		 보 2
		 
		 0 1  1이 승
		 1 2  2가 승
		 2 0  0가 승
		 
		 idx++
		 0 1 2 3 4 5 ...
		 idx++%3
		 0 1 2 0 1 2...
		 */
		 
		 int comIdx = (int)(Math.random()*3); //0,1,2
		 Scanner sc100 = new Scanner(System.in);
		 System.out.println("# 컴퓨터와 함께하는 가위바위보 #");
		 System.out.print("가위바위보 중 하나를 선택하세요 : ");
		 String myChStr = sc100.nextLine();
		 int myIdx = myChStr.equals("가위")?0:(myChStr.equals("바위")?1:2);
		 String comChStr = comIdx==0?"가위":(comIdx==1?"바위":"보");
		 System.out.println("컴의 선택: "+comChStr);
		 System.out.println("나의 선택: "+myChStr);
		 if (comIdx==myIdx) {  
			 System.out.println("무승부");
		 }else if(comIdx++%3==myIdx) { // comIdx에 하나를 더하고 3으로 나눈 나머지값
			 System.out.println("나의 승");
		 }else {
			 System.out.println("컴퓨터 승");
		 }

		 
	}

}
