package javaexp.a03_calcu;

public class A06_TripleCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 삼항연산자
		1. 세 개의 피연산자를 필요로 하는 연산식
		2. 앞의 조건식 결과에 따라 콜론 앞 뒤의 피연사자를 선택 ==>
		3. 형식
		   (비교연산자, 논리연산자)?true일때:false일때 // 한라인에 처리
		      cf) 조건1?처리1:(조건2?처리2:(조건?처리3:그외처리))	
		        ex)	point>=90?"A":(point>=80?"B":(point>=70?"C":(point>=60?"D":F)))   
		   
		*/
		
		int point = 80;
		String result = (point>=60)?"합격":"불합격";
		System.out.println("결과:"+result);
		
		// ex1) 나이가 4세 미만 65세 이상이면 무료, 그 외에는 유료를 처리하여 나이에 따른 입장료 무료/유료를 출력하세요
		// ex2) 위에서 입장료가 50000일 때 4미만, 65이상 80%할인하여 할인된 금액, 그외는 20%할인하여 할인된 금액을 출력하세요

		// 1.
		int age;  
		
	    String result01 = (age<4 || age>=65)?"무료":"유료";
	    System.out.println("입장료: "+result01);
	    // 스캐너 만ㄷ르고 싶었어
	    
	    // 정답
	    // 1.
	    int age =25;
	    System.out.println("입장료?"+(age<4 || age>65?"무료":"유료"));
		//2.
	    int pay =50000;
	    double disRatio = age<4 || age>=65? 0.8:0.2;
	    // pay = pay -(int)(pay*disRatio);   (이거나 아래 방법은 같은거)
	       pay -= -(int)(pay*disRatio);
	    System.out.println("나이: "+age);
	    System.out.println("할인율: "+(int)(disRatio*100)+"%");
	    System.out.println("최종입장료: "+pay);
	    
	    
	    
	    
	}

}
