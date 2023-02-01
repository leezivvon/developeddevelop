package javaexp.z01_homework;

import java.util.Scanner;

public class A04_0902_w1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		2022-09-02
[1단계:개념] 1. switch case에 break문의 특징을 기술하세요.
[1단계:코드] 2. switch case문을 이용하여 1990~2010년생의 생년을 입력받아 띠를 출력하세요
              이외의 범위의 데이터는 받지 않습니다.
[1단계:개념] 3. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
[1단계:코드] 4. for(기본) - 200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
[1단계:코드] 5. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
               # 출력 형식
               1일차 2개 2개
               2일차 4개 6개
               3일차 6개 12개
[1단계:코드] 6. for을 이용하여 3,6,9게임을 출력하세요(20까지)- 3의 배수가 아닌 3의 배수란 말이 포함될 때.//팁!! %나머지 연산자 2번 써보세요
[1단계:개념] 7. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요
[1단계:개념] 8. while문의 기본 형식을 예제를 통해 설명하세요.
[3단계:코드] 9. while문을 이용해서 학생의 점수를 등록하고 총점과 평균을 
               출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
		*/
		
		/*
		1.
		switch문은 조건문으로 변수가 어떤 값을 갖느냐에 따라 실행문이 선택된다.
		 switch(변수){
		     case 값1:
		         처리할 내용
		         break;
		         .
		         .
		         .
		     default: 
		그리고 switch문에서 break;는 다음 case를 실행하지 말고 switch문을 빠져나가기 위해서 사용된다.
        break가 없으면 하위 프로세스를 처리한다	
		
		*/
		//2. 
		
		Scanner sc= new Scanner(System.in);
		System.out.print("당신은 몇년생입니까? \n생년을 입력해주세요.(1990~2010)");
		int birthY = sc.nextInt();
		System.out.println("당신은"+birthY+" 년생");
		switch(birthY) {
		case 1990: 
		case 2002:	
			System.out.println("당신은 말띠!!입니다");
			break;
		case 1991:
		case 2003:
			System.out.println("당신은 양띠!!입니다");
			break;
		case 1992:
		case 2004:
			System.out.println("당신은 원숭이띠!!입니다");
			break;
		case 1993: 
		case 2005:
			System.out.println("당신은 닭띠!!입니다");
		    break;
		case 1994: 
		case 2006:
			System.out.println("당신은 개띠!!입니다");
		    break;
		case 1995: 
		case 2007:
			System.out.println("당신은 돼지띠!!입니다");
		    break;
		case 1996: 
		case 2008:
			System.out.println("당신은 쥐띠!!입니다");
		    break;
		case 1997: 
		case 2009:
			System.out.println("당신은 소띠!!입니다");
		    break;
		case 1998: 
		case 2010:
			System.out.println("당신은 호랑이띠!!입니다");
		    break;
		case 1999: 
			System.out.println("당신은 토끼띠!!입니다");
		    break;
		case 2000: 
			System.out.println("당신은 용띠!!입니다");
		    break;
		case 2001:
			System.out.println("당신은 뱀띠!!입니다");
		    break;
	    default : System.out.println("1990~2010까지만 입력하세요.\n그 외의 데이터는 받지 않습니다");
		}
		System.out.println();
		
		// 3. for문의 기본예제
		
		System.out.println("!!새해가 밝기 5초 전!!\n카운트다운을 시작합니다.");
		for(int cnt=5;cnt>=1;cnt--) {
			System.out.println(cnt+"초!");
		}
		 System.out.println("!!새해가 밝았습니다!!\n!!희망찬 한 해 되세요!!");
		 System.out.println();
		
		// 4. for(기본)-200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
		 for(int cnt=200;cnt>=100;cnt-=3) {
			 System.out.print(cnt+",\n");
		 }
		 
		 // 5.  
		int bread = 0;
		int totBre = 0;
		for(int day=1;day<=10;day++) {
			bread +=2;
			totBre +=bread;
			System.out.println(day+"일차\t"+bread+"개\t"+totBre);
		}
		
		//6
		for (int cnt =1;cnt<=20;cnt++) {
			if(cnt<=10 && cnt%3==0) {
				System.out.print("짝!!");
			}else if(cnt>10 && cnt<=20 && (cnt-10)%3==0) {
				System.out.print("짝!!");
			}else {
				System.out.print(cnt+" ");
			}
		
	      }
		
	 // 7.
		        //break
		            for(int cnt=1;cnt<=10;cnt++ ) {
					if(cnt==5) break;
					System.out.println(cnt+", ");
				} //1,2,3,4
				
				//continue
				for(int cnt=1;cnt<=10;cnt++ ) {
					if(cnt==5) continue;
					System.out.println(cnt+", ");
				} //1, 2, 3, 4, 6, 7, 8, 9, 10
				
		
		//8.	
		  int cnt01=5;
		  while(cnt01>=0) {
		  	System.out.println("카운트다운: "+cnt01--);
		  }
		  
//			9. while문을 이용해서 학생의 점수를 등록하고 총점과 평균을 출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
//	    int scoreTot = 0;
//        Scanner sc01 = new Scanner(System.in);
//        Scanner sc02 = new Scanner(System.in);
//        
//        
//        System.out.println("# 학생의 점수를 등록하세요 #");
//        while(true) {
//     	   int scoreStu = sc01.nextInt();
//     	   System.out.println("등록한 점수: "+scoreStu+"점");
//     	   System.out.println("등록할 거면 <계속>을 입력하고 점수를 등록하세요.\n등록하지 않을거면 <-1>이라고 입력하세요");
//     	   int stopWri = sc02.nextInt();
//     	   if(stopWri==-1)
//     		   break;
//     	  scoreTot +=scoreStu;
//        }
//     	  
//        System.out.println("등록한 학생들의 총점: "+scoreTot);
//        System.out.println("등록한 학생들의 평균: "+scoreTot/5);

		  
		  
		  
		  // 정답
		 //5.
		  
		  int dBCnt = 2; //하루에 먹는 빵 //변경되지 않는 전역변수
          int tot = 0; // 누적된 빵의 개수 // 누적되어 변경되는 전역변수
          for(int dCnt=1;dCnt<=10;dCnt++) {
        	  tot += dBCnt*dCnt;
        	  System.out.println(dCnt+"일차 "+dBCnt*dCnt+"개 "+tot+"개");
          }
          
  
		  
		 //6.
		  
		  for (int cnt =1;cnt<=20;cnt++) {
			  // 10==0
			  // 11==1
			  // 12==2
			  // 13==3
				if(cnt%10!=0 && cnt%10%3==0) {
					System.out.print("짝, ");
				}else {
					System.out.print(cnt+",");
				}
			
		      }
		  // 왜 뭐는 == 이거고 뭐는 =이거야????????
		  for(int cntc =1; cntc<=20;cntc++)
		       System.out.println((cntc%10!=0 && cntc%10%3==0?"짝!":cntc)+",");
		  
		  
		  //9.
		  
		  Scanner scsc = new Scanner(System.in);
		  int sNo = 0; // 과목 수, 평균처리시 필요
		  int tot = 0; // 과목의 점수를 누적 //전역변수
		  while(true) {
			  System.out.print(++sNo + "번째 과목의 점수를 입력(중단시-1): "); // 입력한 과목 수 출력하는 법
			  int pt = scsc.nextInt();
			  if(pt==-1) {//중단 처리 시
				  sNo--; // 입력된 과목 증가 취소 처리
				  break;
			  }
			  System.out.println("입력한 점수: " +pt);
			  tot += pt;
		  }
		  System.out.println("입력한 과목수: " +sNo);
		  System.out.println("점수: " +tot); 
		  System.out.println("평균: " +tot/(double)sNo);
		  
		  
	}

}
