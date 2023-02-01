package javaexp.a04_process;

import java.util.Scanner;

public class A02_If_else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# if else 구문
		1. 여러가지 조건이 있을 때 처리하는 구문
		   1) 2가지 조건
		      if(조건1){
		          조건에 해당할 때,
		      }else{
		          조건에 해당하지 않을 때.
		      }
		   2) 3가지 이상 조건
		     if(조건1){
                		     
 		     }else if(조건2){
		        조건1을 제외하고 조건2일 때
		     }else if(조건3){
		     
		     }else{
		      위에 나열된 조건이 아닐 때
		     }
		     
	
		*/
		
		
		/*
		 * 홀짝 게임
		 
		int gIdx = (int)(Math.random()*2); // 0,1
		
		System.out.println("# 홀짝게임 #");
		Scanner sc = new Scanner(System.in);
		System.out.println(" 게임시작!!\n홀/짝 선택하세요");
	    String ch = sc.nextLine(); // 홀,짝 선택
	    
	    String com = ""; // 컴퓨터 선택 // 초기화를 위해(선생님은 습관적으로 한 것) // = String com ;으로 해도 됨
        System.out.print("컴퓨터의 선택은!! " );				
		if(gIdx==0) {// 위에 임의 값이0
			System.out.println("짝!!");
		    com = "짝"; // com이 짝
		}else { //임의 값이 1
			System.out.println("홀!!");
			com = "홀"; // com이 홀
		}
		if(ch.equals(com)) {
			System.out.println("짝짝짝!! 당신이 이겼습니다.");
		}else {
			System.out.println("하하하!! 당신이 졌습니다.");
		}
		*/
		
		
		/*
		  ex)  나이를 임의로 1~70까지 나오게 하고
		       if else이용하여 나이가 14세 이상 18미만이면 청소년 출력, 청소년 아님()
		  
		 */
		// scanner 이용
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 나이를 입력하세요: ");
		int myAge = sc.nextInt();
		
		if(myAge>=14 && myAge<18) {
			System.out.println("당신은 청소년입니다");
		}else {
			System.out.println("당신은 청소년이 아니군요");
		}
		
		//나이 임의 제시
		int age01 = (int)(Math.random()*71+1);
		if(age01>=14 && age01<18) {
			System.out.println("당신은 청소년입니다");
		}else {
			System.out.println("당신은 청소년이 아니군요");
		}
		
		// 정답
        int rAge = (int)(Math.random()*70+1);
        System.out.println("임의의 나이: "+rAge);
        if (rAge>=14 && rAge<18) {
        	System.out.println("청소년 입니다");
        }else {
        	System.out.println("청소년 아님(어린이/성인)");
        }
		
        
        int point = (int)(Math.random()*51+50); //50~100
        System.out.println("획득 점수: "+point);
        if (point>=90) {
        	System.out.println("A등급");
        }else if(point>=80) { // !!주의!! 앞에 90 이상 제외하고 else
        	System.out.println("B등급");
        }else if(point>=70) {
        	System.out.println("C등급");
        }else if(point>=60) {
        	System.out.println("D등급");
        }else {
        	System.out.println("F등급");
        }
		
		
        // ex1) 0,1,2 가 임의로 나오게 하여 컴퓨터가 가위/바위/보를 출력하게 하세요 
        
        int rsp = (int)(Math.random()*3);
        
        if(rsp==0) {
        	System.out.println("가위");
        }else if(rsp==1) {
        	System.out.println("바위");
        }else {
        	System.out.println("보");
        }
        
        // 정답
        int  gIdx2 =(int)(Math.random()*3);
        if(gIdx2==0) {
        	System.out.println("가위");
        }else if(gIdx2==1) {
        	System.out.println("바위");
        }else {
        	System.out.println("보");
        }
        
		/*
		# 중첩 조건문
		1. 조건문 안에 조건문 처리
		   if(조건1){
		    if(조건2){
		    }else{
		    }
		
		*/
        
        
        String gender = "남";
        int age = 25;
        if(age>=18) {
        	if(gender.equals("남"){
        		System.out.println("신사입니다.");
        	}else {
        	System.out.println("숙녀입니다");
        }
        
        
        
	}
}
