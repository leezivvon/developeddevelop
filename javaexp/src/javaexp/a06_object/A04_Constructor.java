package javaexp.a06_object;

public class A04_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 다른 생성자 호출(this())
		1. 생성자 오버로딩되면 생성자간의 중복된 코드 발생
		2. 초기화 내용이 비슷한 생성자들에서 이러한 현상을 많이 볼 수 있음
		  1) 초기화 내용을 한 생성자에 몰아 작성
		  2) 다른 생성자는 초기화 내용을 작성한 생성자를 this(..)로 호출
		
		*/
		
		Player p01 = new Player("홍길동","LG트윈스",0.304);
		System.out.println(p01.tname);
		System.out.println(p01.name);
		System.out.println(p01.record);
	
		
		// ex_ Music 클래스를 선언하고 필드로 음악명, 가수, 앨범 속성으로 처리하되 
		//     매개변수없는 것부터 3개까지 생성자로 선언하고 각 생성자에 선언된 생성자를 호출하여 처리하고 속성을 출력하세요
		/*
		 내가 한거
		Music m01 = new Music("겨울잠","이지은","조각집");
		System.out.println(m01.nameM);
		System.out.println(m01.nameS);
		System.out.println(m01.album);
		*/
		
		Music m1 = new Music(); //매개변수 없는거
		Music m2 = new Music("After Like"); //매개변수 하나
		Music m3 = new Music("Attention","뉴진스");
		Music m4 = new Music("Tomboy","아이들","Villan");
		System.out.println(m1);
		System.out.println(m1.title);
		System.out.println(m1.singer);
		System.out.println(m1.elbum);
		System.out.println(m2);
		System.out.println(m2.title);
		System.out.println(m2.singer);
		System.out.println(m2.elbum);
		System.out.println(m3);
		System.out.println(m3.title);
		System.out.println(m3.singer);
		System.out.println(m3.elbum);
		System.out.println(m4);
		System.out.println(m4.title);
		System.out.println(m4.singer);
		System.out.println(m4.elbum);
		
		

	}

}

class Music{
	String title;
	String singer;
	String elbum;
	
	Music(){ // default
		this.title="없음";
		this.singer="무명";
		this.elbum="없음";
	}
	Music(String title){ // 타이틀만 매개변수로 받아서
		this(); // 상위 생성자 호출
		this.title = title;
	}
	Music(String title, String singer){
		this(title);
		this.singer = singer;
	}
	Music(String title, String singer, String elbum){
		this(title,singer);
		this.elbum = elbum;
	}
}


/*
  내가 한거
class Music{
	String nameM;
	String nameS;
	String album;
	
	Music(){
		this.nameM = "비밀의 화원";
		this.nameS = "아이유";
		this.album = "꽃갈피";
	}
	Music(String nameM){
		this();
		this.nameM = nameM;
	}
	Music(String nameM, String nameS){
		this(nameM);
		this.nameM = nameM;
		this.nameS = nameS;
	}
	Music(String nameM, String nameS, String album){
		this(nameM);
		this.nameM = nameM;
		this.nameS = nameS;
		this.album = album;
	}	
}
*/



class Player{
	String name;
	String tname;
	double record;
	
	Player(){//default값 설정
		this.name = "무명"; 
		tname = "팀 할당 안됨"; // this안쓰는거 자바에선 허용
		this.record=0.0;
	}
	Player(String name){
		this(); // 선언된 생성자를 호출해서 아래 default자동 설정
		this.name = name; 
//		tname = "팀 할당 안됨";     // 위 this()로 생략가능
//		this.record=0.0;         // 필요없어짐
	}
	Player(String name, String tname){
		this(name); // 매개변수가 있는 생성자 호출
		this.tname =tname;
	}
	Player(String name, String tname, double record){
		this(name, tname);
		this.record = record; 
//		this(name, tname);  에러 발생! 반드시 첫라인에 선언하여야 한다
	}
}
