package javaexp.a06_object;

import java.util.ArrayList;

public class A13_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 객체형 배열 
		1. 고정된 배열안에 객체를 담는 처리
		2. 크기가 고정되어서 추가나 삭제 불가능
		*/
		int[] arry = {1000, 2000, 3000}; // 정수형 배열 // 단일데이터
		for (int idx=0; idx<arry.length;idx++) {
			System.out.println(idx+":"+arry[idx]); // stack 영역 데이터
		}
		
		Food01[] obArray= {new Food01("짜장면", 6000), new Food01("짬뽕", 7000), new Food01("탕수육", 15000)};// 객체형
		// cf) 참조변수, 메서드명, 일반변수는 소문자로 시작하되, 합성어로 구분자로 대문자를 중간에 추가한다
		for(int idx=0; idx<obArray.length;idx++) {
			System.out.println(idx+":"+obArray[idx]+":");//주소값 출력 // stack영역 데이터
			Food01 f01 = obArray[idx]; // 속성값
			System.out.println(f01.getName()+":"+f01.getPrice()); // 객체의 구성요소 호출
		}
		
		
		// ex Student 이름 국어 영어 속성 생정자 set/get    Student[] 선언하고 학생 정보 3명을 할당 for문을 통해서 이름 국어 영어 출력
		// 정답
		
		/*
		1. 클래스 선언
		    필드, 생성자, get/set
		2. 객체형 배열 선언 및 할당
		3. for 배열처리 선언 및 할당
		    for(int idx=0;idx<배열명.length;idx++)
		 
		*/
		
		Student01[] stArry = {new Student01("비비",98,86,75), 
				              new Student01("소피",100, 76, 100), 
				              new Student01("율리", 90,100,50)
				            };
		for(int idx=0;idx<stArry.length;idx++) {
			System.out.println(idx+":"+stArry[idx]); // 주소값 출력
			Student01 stu = stArry[idx];
			System.out.println("# "+stu.getName()+"의 성적표 #");
			System.out.println("국어성적: "+stu.getKor()+"점");
			System.out.println("영어성적: "+stu.getEng()+"점");
			System.out.println("수학성적: "+stu.getMath()+"점");
		}
		
		/*
		# 객체형 동적배열
		1. 데이터타입이 List, ArrayList선형 형식으로 선언된다
		2. 크기가 동적으로 변경이 가능하다
		*/
		ArrayList list = new ArrayList();// java.util.ArrayList //ctrl+shift+o import형성
		// Object
		Object ob; //자바의 모든 객체의 상속 관계에서 최상위 객체
		// 모든 객체를 할당할 수 있다.
		ob = "홍길동";
		ob new Student01("홍길동",50,60,80);
		// ArrayList<Object> list; default로 된거나 다름 없음 
		//  .add(추가할 데이터)
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		System.out.println("크기: "+list.size());
		//  .size();  동적 배열의 크기
		for(int idx=0;idx<list.size();idx++) {
			// list.get(인덱스)
			System.out.println(idx+":"+list.get(idx));
		}
		list.add("오렌지");
		for(int idx=0;idx<list.size();idx++) {
			System.out.println(idx+":"+list.get(idx));
		}
		
		//ex 좋아하는 노래 3곡명을 ArryList를 선언하고 추가하여 반복문르 통해서 출력하세요
		ArrayList slist = new ArrayList();
		slist.add("Hype Boy");
	
		for(int idx=0;idx<slist.size();idx++) {
			System.out.println(idx+":"+slist.get(idx));
		}
		// add(), get(), remove(), size()
		slist.add("겨울잠");
		slist.add("드라마");
		
		// 삭제 처리
		slist.remove(0); // 첫번째 데이터 삭제
		System.out.println("삭제 후...");
		for(int idx=0;idx<slist.size();idx++) {
			System.out.println(idx+":"+slist.get(idx));
		}
		
		// 향상된 반복문
		// for(단위데이터 : 배열형 객체) // 정적. 동적 배열 모두 
		System.out.println("# 향상된 반복문 처리 #");
		// ArrayList는 기본유형으로 Object 가 담기낟
		for(Object music:slist) {
			System.out.println(music);
		}
		
		/*
		# 동적배열(ArrayList)에 객체할당하여 처리하기
		1. 유형의 선언
		   ArrayList list;  : 기본 Object 형 데이터 선언
		2. 특정한 객체의 유형의 데이터 처리
		    ArrayList<클래스명> list = new ArrayList<클래스명>() ;
		    <> : generic
		         해당 유형의 동적 배열을 선언한다는 의ㅁ이다  
		*/
		ArrayList<Student01> stList = new ArrayList<Student01>();//Student01 이 객체만 담김
		stList.add(new Student01("홍길동", 70, 90, 60));
		stList.add(new Student01("김길동", 70, 90, 70));
		stList.add(new Student01("신길동", 70, 90, 34));
		for(int idx=0;idx<stList.size();idx++) {
			Student01 st = stList.get(idx);
			System.out.println(idx+":"+st); //주소값 
			System.out.print("     "+st.getName());
			System.out.print(":"+st.getKor());
			System.out.print(":"+st.getEng());
			System.out.println(":"+st.getMath());
		}
		
		//ex Food01 클래스를 ArrayList<타입>으로 할당하고 for문을 통해서 출력하세요

		ArrayList<Food01> flist = new ArrayList<Food01>();
		flist.add(new Food01("애호박",1000));
		flist.add(new Food01("가지",500));
		flist.add(new Food01("숙주",1500));
		for(int idx=0;idx<flist.size();idx++) {
			Food01 fo = flist.get(idx);
			System.out.println(idx+" : "+fo); //주소값 출력
			System.out.println(idx+" : "+fo.getName()+" : "+fo.getPrice());
		}
		for(Food01 food:flist) {
			System.out.print(food.getName()+"\t");
			System.out.println(food.getPrice());
			
		}
		
		

		
	}
}
class Student01 {
	private String name;
	private int kor;
	private int eng;
	private int math;
	public Student01(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {// 필드 값을 호출할때(간접적)
		return name;
	}
	public void setName(String name) { // 필드 값을 저장할 때(간접적)
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
}


class Food01 {
	private String name;
	private int price;
	public Food01(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
