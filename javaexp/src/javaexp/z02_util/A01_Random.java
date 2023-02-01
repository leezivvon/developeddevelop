package javaexp.z02_util;

public class A01_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*	
		 # 임의의 수를 처리하는 Math.random()
		 1. Math.random()는 Math클래스 하위에 static 메서드로 
		   0.0<=Math.random()<1.0 
		 2. 임의의 수 처리하기 
		   0.0<=Math.random()*10<10.0   
		   0<=(int)Math.random()*10<10   // 0~9, 10가지 경우의 수
		   1<=(int)Math.random()*10+1<11 // 1~10, 1~10까지 열가지의 임의의 정수처리
		 3. 임의의 정수 처리 공식 
		   (int)(Math.random()*경우의 수+시작 수)	
		   1) 주사위를 임의로 처리하기
		      6가지의 경우의 수
		      1~6 :시작은 1부터
             int dice01 = (int)(Math.random()*6+1);
		   	   
	    */
		double r1 = Math.random();
		System.out.println(r1);
		System.out.println(r1*10);
		System.out.println((int)r1*10);
		
		int dice01 = (int)(Math.random()*6+1);
		int dice02 = (int)(Math.random()*6+1);
		System.out.println("주사위1: "+dice01);
		System.out.println("주사위2: "+dice02);
		System.out.println("주사위 합: "+(dice01+dice02));
		
		// ex1) 홀짝을 임의로 처리하기 위해 1, 2가 임의로 나오게 하세요
		// ex2) 가위 바위 보를 위한 0,1,2가 임의로 나오게 하세요
		//ex3) 100점 만점 점수가 임의로 나오게
		
		//1
		int ran01 = (int)(Math.random()*2+1);//간단 이 방식으로 할 ㅓ것
		System.out.println(ran01);
		
		double ran02 = Math.random();
		System.out.println((int)ran02*2+1);  //복잡
		//2
		int rsp = (int)(Math.random()*3);
		System.out.println(rsp);
		//3
		int manZom = (int)(Math.random()*100);
		System.out.println(manZom);
		 
		//정답
		//1
		int gIdx1 = (int)(Math.random()*2+1);
		System.out.println("홀짝 index:"+gIdx1);
		System.out.println(gIdx1==1?"홀":"짝");
		
		//2
		int gIdx2 = (int)(Math.random()*3);
		System.out.println("가위/바위/보 idx: "+gIdx2);
		System.out.println(gIdx2==0?"가위":(gIdx2==1?"바위":"보"));
		
		//3. 1~100 = 경우의 수가 101
		int point = (int)(Math.random()*101);
		System.out.println("임의의 점수: "+point);
		
	}

}
