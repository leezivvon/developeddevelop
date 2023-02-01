package javaexp.a03_calcu;

public class A03_incre_des {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 증감 연사자
		1. 변수명++, 변수명--
		 1씩 증가/감소 처리
		 ++cnt01 증가한 뒤에 이 라인에서 증가되 ㄴ내용 확인
		 cnt01++
		 
		 
		# 증감 대입연산자
		  특정한 단위로 증감하는 연산자
		  1. 변수명 +=증가단위;
		     변수명 -=감소단위;
		     
		     cnt01+=3  증가된 내용을 출력
		 
		*/
		int cnt =1;
		System.out.println(cnt++);
		System.out.println(cnt++);
		System.out.println(cnt--);
		System.out.println(cnt--);
		System.out.println(cnt--);
		System.out.println(cnt++);
		System.out.println(cnt++);
		System.out.println(cnt+=3);
		System.out.println(cnt+=3);
		System.out.println(cnt+=5);
		System.out.println(cnt-=5);
		System.out.println(cnt-=5);
		System.out.println(cnt-=5);
		/*
		ex1) 1~5까지 증가 5~1로 감소처리하세요
		ex2) 증감 대입연산자를 활용해서 3의 배수로 5회 증가하세요
		ex3) 증가 연산자로 1~10까지 누적합산값을 처리하세요
		*/
	// 1.
		int lego = 1;
		System.out.println(lego+=1);
		System.out.println(lego+=1);
		System.out.println(lego+=1);
		System.out.println(lego+=1);
		System.out.println(lego+=1);
		System.out.println(lego+-1);
		System.out.println(lego+-1);
		System.out.println(lego+-1);
		System.out.println(lego+-1);
		
	// 2. 
		int lego02 = 3;
		System.out.println(lego02*=3);
		System.out.println(lego02*=3);
		System.out.println(lego02*=3);
		System.out.println(lego02*=3);
		System.out.println(lego02*=3);
		
	// 3.
		int lego03 = 1;
		System.out.println(lego03+=1);
		System.out.println(lego03+=1);
		System.out.println(lego03+=1);
		System.out.println(lego03+=1);
		System.out.println(lego03+=1);
		System.out.println(lego03+=1);
		System.out.println(lego03+=1);

	// 정답
	// 1.
		//++cnt01 증가된 내용을 출력
		// cnt01++ 다음 호출 시 증가된 내용 확인
	//3.
		int cnt03=0;
		System.out.println(cnt03+=1);
		System.out.println(cnt03+=2);
		System.out.println(cnt03+=3);
		System.out.println(cnt03+=4);
		System.out.println(cnt03+=5);
		System.out.println(cnt03+=6);
		System.out.println(cnt03+=7);
		System.out.println(cnt03+=8);
		System.out.println(cnt03+=9);
		System.out.println(cnt03+=10);
	
		
	
	// ex) 초기값 cnt04 100을 할당한 후, -5씩 3회 감소 처리 출력
	// 내 답
		int cnt04 = 100;
		System.out.println(cnt04-=5);
		System.out.println(cnt04-=5);
		System.out.println(cnt04-=5);
	// 정답
		System.out.print(cnt04+"\t");
		System.out.print((cnt04-=5)+"\t");
		System.out.print((cnt04-=5)+"\t");
		System.out.print((cnt04-=5)+"\t");
		
	}

}
