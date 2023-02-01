package javaexp.a03_calcu;

public class A02_restoreCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		#대입연산자
		1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당하는 연산자
		*/
		int num01 = 25;
		int num02, num03, num04; // 한번에 정수형 데이터를 3개 선언
		num02 = num03 = num04 = 5;
		int num05 = 6; double num06 = 1.4; float num07 = 4.7F;
		System.out.println("#대입연산자#");
		System.out.println("num02:"+num02);
		System.out.println("num03:"+num03);
		System.out.println("num04:"+num04);
		System.out.println("num05:"+num05);
		System.out.println("num06:"+num06);
		System.out.println("num07:"+num07);
		double
		// ex) 회원의 ID를 3개 만들고, 해당 아이디를 각각 할당하고 회원 ID의 pt(포인트)를 3개변수로 만들고 
		//     초기에 10000을 할당하여 ID와 PT를 출력하세요
		// 문제가 아예 이해가 안가
	    
//		String id01 = watermelon93;
//		String id02 = cherry96;
//		String id03 = peach99;
//		int id01, id02, id03 =12;
		
		// 정답
		String id01, id02, id03;
		id01="cherry93";id02="peach96";id03="tomato99";
		int pt01, pt02, pt03;
		pt01= pt02 =
		
		
		
		/*
		 ex) 학생2명의 이름과 국어, 영어, 수학점수를 할당하여 아래와 같이 출력하세요 
		      이름 국어 영어 수학 평균
		       @@  @@ @@ @@ @@ @@ 
	           @@  @@ @@ @@ @@ @@
		 */
		
		String name01, name02;
		name01="소피아"; name02="율리아";
		int ko01=98; int eng01=86; int math01=100;
		int ko02=96; int eng02=100; int math02=72;
		int evg01= (ko01+eng01+math01)/3;
		int evg02= (ko02+eng02+math02)/3;
		System.out.print("이름\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.print("수학\t");
		System.out.print("평균\n");
		System.out.print(name01+"\t");
		System.out.print(ko01+"\t");
		System.out.print(eng01+"\t");
		System.out.print(math01+"\t");
		System.out.print(evg01+"\n");
		System.out.print(name02+"\t");
		System.out.print(ko02+"\t");
		System.out.print(eng02+"\t");
		System.out.print(math02+"\t");
		System.out.print(evg02+"\n");
		
		//정답
		String name1, name2; // 선언(,)
		name1="다마소"; name2="헬레나"; // 할당(;)
		int kor1,kor2,eng1,eng2,mat1,mat2;
		kor1=90;kor2=100;eng1=94;eng2=90;mat1=90;mat2=100;
		System.out.print("이름\t");
		System.out.print("국어\t");
		System.out.print("영어\t");
		System.out.print("수학\t");
		System.out.print("평균\n");
		double avg1 = (kor1+eng1+mat1)/3.0;
		double avg2 = (kor2+eng2+mat2)/3.0;
		System.out.println(name1+"\t"+kor1+"\t"+eng1+"\t"+mat1+"\t"+avg1);
		System.out.println(name2+"\t"+kor2+"\t"+eng2+"\t"+mat2+"\t"+avg2);
		
		
		
		
	}

}
