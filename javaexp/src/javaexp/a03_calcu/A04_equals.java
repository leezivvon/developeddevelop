package javaexp.a03_calcu;

public class A04_equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 비교연산자
		1. 두 개의 피연산자의 값을 비교하여 동일한지(==)
		    같지 않은지(!=), 큰 지(>), 작은 지(<) 등을 
		    boolean(true/false)값으로 결과를 처리하는 연산자를 말한다.
		2. 종류
		    ==, !=, >=, <=, >, <
		3. 활용
		 조건문이나 반복문에 처리할 때 사용된다.
		
		*/
		
		int num01 = 25;
		int num02 = 5;
		System.out.println("#비교 연산 결과#");
	    System.out.println(num01+"=="+num02+"="+(num01==num02));
	    System.out.println(num01+"!="+num02+"="+(num01!=num02));
	    System.out.println(num01+">="+num02+"="+(num01!=num02));
	    System.out.println(num01+"!="+num02+"="+(num01!=num02));
	    System.out.println(num01+"!="+num02+"="+(num01!=num02));
	
	    // ex) 획득 점수, 합격기준점수를 입력받거나 임의로 입력하여 합격여부를 boolean(true/false)로 출력
	    
	    int score = 895;
	    int goal = 800;
	    System.out.println("#합격여부결과#");
	    System.out.println(score+">="+goal+"="+(score>=goal));

//	    정답		
	    int score01 = 70; // 획득점수
	    int stdpt = 80; // 합격기준점수
	    System.out.println("합격여부:"+(score>=stdpt));
	    
	    
	    // ex) 4지 선다에 정답번호 지정, 체크한 번호 선언 정답여부를 출력 
	    // 풀이
	    int correctNum = 5;
	    int check = 3;
	    System.out.println("정답여부:"+(correctNum==check));
	    // 정답
	    int corNum = 3;
	    int chNum = 3;
	    System.out.println("정답여부:"+(corNum==chNum));
	    		
	
	
	
	
	
	}

}
