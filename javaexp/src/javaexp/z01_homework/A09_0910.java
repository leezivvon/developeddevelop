package javaexp.z01_homework;

public class A09_0910 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-10
[1단계:개념] 1. 배열과 반복문의 관계를 기술하고, 학생 30명을 임의의 점수(0~100)로 배열에 할당/출력하세요.
[1단계:응용] 2. 무지개 색상을 배열로 선언하고, 이 중에서 임의의 색상 3개를 출력하세요
[1단계:개념] 3. 클래스와 객체의 관계를 메모리를 활용하여 설명하고, 주소값을 출력하세요..
[1단계:개념] 4. 클래스를 통해 만들어진 객체와 일반 primitive 데이터와 어떠한 차이점이 있는지 기술하세요.
[1단계:확인] 5. 아래와 같이 여러가지 생성자를 초기화하고 출력하세요.
          1) Singer 클래스를 선언하고 매개변수로 이름, 소속사, 메인곡을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
          2) Game 클래스를 선언하고 출시회사, 비용, 인기순	
				*/
		
		//1 배열과 반복문의 관계는.. 랜덤 기능을 이용하면 배열의 인덱스마다 랜덤으로 값을 할당할 수 있다 
		int[] stu =new int[30];
		for(int idx=0; idx<stu.length; idx++) {
			int rsco = (int)(Math.random()*101);
			stu[idx] =rsco;
			System.out.println(idx+1+"번 학생의 점수: "+stu[idx]);
		}
		
		//2
		String[] rainbow = {"빨강", "주황", "노랑", "초록", "파랑", "남색", "보라"};
		int ridx1 = (int)(Math.random()*7);
		System.out.println(rainbow[ridx1]);
		int ridx2 = (int)(Math.random()*7);
		System.out.println(rainbow[ridx2]);
		int ridx3 = (int)(Math.random()*7);
		System.out.println(rainbow[ridx3]);
		
		
		/*
		3. 
		클래스와 객체는 설계도와 건물의 관계라고 할 수 있다
		객체가 건물이라면 클래스는 그 건물의 설계도라고 할 수 있다
		*/
		// 주소값
		Exp3 ex = new Exp3();
		System.out.println(ex);  // javaexp.z01_homework.Exp@5305068a
		
		/*
		 4. 
		클래스를 통해 만들어진 객체는 heap영역에서 저장되고 
		일반 primitive 데이터는 primitive 변수에 값이 저장되어 stack영역에서 출력될 수 있다.
		*/
		
		// 5
	
		//5-1	
	    Singer sg = new Singer("아이유","EDAM엔터테인먼트","라일락");
        System.out.println("가수이름: "+sg.name);
        System.out.println("소속 회사: "+sg.company);
        System.out.println("대표 노래: "+sg.song);
        
        //5-2
        Game g = new Game("넥슨", 50000, 3);
        System.out.println("출시 회사: "+g.company);
        System.out.println("비용 :"+g.much);
        System.out.println("인기순위: "+g.poChart+"순위");
	}
}
//5 -2
class Game{
	String company;
	int much;
	int poChart;
	Game(String company, int much, int poChart){
		this.company= company;
		this.much=much;
		this.poChart=poChart;
	}
}
//5 -1
class Singer {
	String name;
	String company;
	String song;
	Singer(String name, String company, String song){
		this.name= name;
		this.company= company;
		this.song=song;
	}		
}

//3
class Exp3 {}