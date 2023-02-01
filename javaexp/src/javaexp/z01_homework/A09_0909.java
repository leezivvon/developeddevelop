package javaexp.z01_homework;

import java.util.Scanner;

public class A09_0909 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-09
[1단계:코드] 1. 짜장면(5000), 짬뽕(6000)의 가격으로 되었을 때, 증감 연산자를 활용해서
            1~3, 1~5까지의 총비용을 출력하세요.
[1단계:개념] 2. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
[1단계:코드] 3. 100에서 1/4로  4회 누적해서 나눈 값을 아래의 형식으로 출력 하세요
                 초기데이터 100
                 1회  25 
                 2회  6.2..
                 3회  1.54...
                   4회  0.38..
[2단계:코드] 4. [continue 활용]1~12월까지 마지막일수*10으로 월급여 산정하되,
            31일만 있는 월만 산정해서 출력하고 나머지 월(30일, 28일까지 있는 달)은 산정 처리하지 않고 총 급여을 아래와 같이 출력하세요
                      월  일수   월급여 누적연봉      
                      1월 31일  310만 310만원
                      3월 31일  310만 620만원
                      5월 31일  310만 930만원
                      ..
                      12 31일  ..
[2단계:응용] 5. 두명(컴퓨터vs컴퓨터)의 구슬 홀짝게임 : 한명이 구슬 10개를 가지고 임의의로 쥐게 하여, 
          다른 한명이 이것을 맞추었는지 여부에 따라 승/패로 출력하게 하세요.
[1단계:응용] 6. 두 팀(홍/청-컴퓨터vs컴퓨터)이 주사위를 던져 홍팀의 결과를 출력하세요(승/무/패)
[2단계:응용] 7. while문 숫자 맞추기 게임, 컴퓨터가 임의로 1~100범위의 숫자를 저장하면,
         while문을 통해서 해당 숫자를 입력한다. 비교해서 동일하면 종료,
[1단계:개념] 8. 참조변수가 무엇인지? 메모리 영역을 기본 데이터유형과 비교하여
      기본 예제를 통해서 설명하세요.
[1단계:확인] 9. Music 클래스를 선언하고, 해당 m01, m02 참조변수를 선언하고, 비교하세요.		
				*/
		
		
		
		
		// 1 
		int zza = 0;
		 for(int cnt=1;cnt<=3;cnt++) {
			 zza +=5000;
			 System.out.println("짜장면 "+cnt+"개의 누적비용: "+zza);
		 }
		System.out.println("# 짜장면의 총비용 #");
		System.out.println("\t"+zza+"원");
		System.out.println();
		
		int zzam =0;
		for (int cnt=1;cnt<=5;cnt++) {
			zzam += 6000;
			System.out.println("짬뽕 "+cnt+"개의 누적비용: "+zzam);
		}
		System.out.println("# 짬뽕의 총비용 #");
		System.out.println("\t"+zzam+"원");
		
		
		/*
		 2. 연산자 수를 기준으로 단항, 이항, 삼항이 나뉜다
		 단항연산자 : 부호연산자 +, - / 증감 연산자 +,-- / 
		 이항연산자 : 산술연산자 +, -, *, /  // 비교연산자 <, <=, >, >=<==, !=
		           논리연산자 논리곱(&&), 논리합(||), 배타적 논리합(^), 논리부정(!)연산
		 삼항연산자 : 조건식? true일때 출력되는 값/연산식 : flase일때 출력되는 값/연산식
		 */
		//예제
		int cnt = 7;
		System.out.println(cnt>10?cnt++:cnt--);
		// 삼항연산자를 조건식을 비교연산자를 사용하고 true일 때 값 1 증가, false일 때 값 1 감소 
		
//		// 3. 
		
		double data1st = 100.0;
		for(int num= 1;num<5;num++) {
			data1st/=4.0;
			System.out.println(num+"회\t"+data1st);
		}

 		// 4.
		
		int tot = 0;
		int pay = 310;
		
		System.out.println("월\t일수\t월급여\t누적연봉");
        for(int mon=1; mon<=12;mon++) {
        	if (mon==2) continue;
        	if (mon==4) continue;
        	if (mon==6) continue;
        	if (mon==9) continue;
        	if (mon==11) continue;
        	tot+=pay;
        	System.out.println(mon+"월\t"+"31일\t"+pay+"만\t"+tot+"만원");
        }
        
        // 4-1

        int totWage = 0;
        System.out.println("월\t일수\t월급여\t누적급여");
        
//        array활용 코드 - continue 사용
	      int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	      for(int i=0;i<days.length;i++) {
	    	  if(days[i]==30||days[i]==28)  continue;
	          totWage+=(days[i]*10);
	          System.out.println((i+1)+"월\t"+days[i]+"일\t"+(days[i]*10)+"만\t"+totWage+"만원");
	          } 


		
          // 5. 
        int bubble = (int)(Math.random()*10+1);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("<< 홀/짝 중 하나를 입력하세요 >>");
        String gPutin=sc.nextLine();
        
       
        System.out.println("컴퓨터의 선택은..");
        String com = " ";
        if (bubble%2==0) {
        	System.out.println("짝 입니다");
        	com= "짝";
        }else {
        	System.out.println("홀 입니다");
        	com="홀";
        }
        
        if (gPutin.equals(com)) {
        	System.out.println("승!! 짝짝짝!! 당신이 이겼습니다");
        }else {
        	System.out.println("패!! 아쉽네요.. 당신이 졌습니다");
        }
        
        // 6
        int diceR = (int)(Math.random()*6+1);
        int diceB = (int)(Math.random()*6+1);
        
        System.out.println("#홍팀/청팀의 주사위 게임을 시작합니다#");
        System.out.println("홍팀의 주사위...\t"+diceR);
        System.out.println("청팀의 주사위...\t"+diceB);
        if(diceR>diceB) {
        	System.out.println("축하축하 홍팀이 이겼습니다!!");
        }else if(diceR<diceB) {
        	System.out.println("안타깝네요 홍팀이 졌습니다..");
        }else {
        	System.out.println("비겼습니다!!");
        }
        
        //7
        
        int cnum = (int)(Math.random()*100+1);
        Scanner scsc = new Scanner(System.in);
        System.out.println("1~100까지 숫자를 골라 하나를 입력하세요");
       
        while (true) {
        	 int pnum = scsc.nextInt();
        	 System.out.println("당신이 입력한 숫자: "+pnum);
        	if(cnum!=pnum) {
        	    System.out.println("틀렸습니다 다시 입력하세요");
        	}else {
        		System.out.println("대단하군요! 숫자를 맞혔습니다!!");
        		break;
        	}
        	
        }
        
        /*
        // 8 
            자바의 데이터 타입은 크게 기본 타입과 참조 타입으로 나뉘는데 
           그 중 참조 타입인 배열, 열거, 클래스, 인터페이스를 이용해서 선언된 변수를 참조변수라고 한다
           기본 타입으로 선언된 변수는 실제 값을 변수에 직접 저장하여 stack영역에 저장되는 반면
           참조 타입으로 선언된 변수는 실제 값은 heap영역에 저장되고 heap영역의 주소값을 stack영역에 저장한다 
        */
        // 예제
        int num00 = 35;
        System.out.println(num00);  // 35출력
        int[] arr00 = {35};
        System.out.println(arr00); // [I@6e8cf4c6 출력
        
		
		// 9
		Music mm = new Music();
		mm.m01 = 10;
		mm.m02 = 20;
		System.out.println(mm.m01);
		System.out.println(mm.m02);
		
		
		
	}
}
class Music {
	int m01 ;
	int m02 ;
}
