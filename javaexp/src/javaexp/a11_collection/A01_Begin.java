package javaexp.a11_collection;

import java.util.ArrayList;
import java.util.List;

public class A01_Begin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	    # 컬렉션 프레임워크
		1. 컬렉션 : 사전적 의미로 요소(객체)를 수집해 저장하는 것
		2. 배열의 문제점
			1) 저장할 수 있는 객체 수가 배여을 생성할 때 결정
				==> 불특정 다수의 객체를 저장하기에는 문제
			2) 객체 삭제했을 때 해당 인덱스가 비게 됨
				- 낱알 빠진 옥수수 같은 배열
				- 객체를 저장하려면 어디가 비어 있는 확인 필요			
		3. 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 제공되는 컬렉션 라이브러리
		4. java.util 패키지에 포함
		5. 인터페이스를 통해서 정형화된 방법으로 다양한 컬렉션 클래스 이용
		
		# 컬렉션 프레임워크의 주요 인터페이스
		1. 인터페이스
			*List - *ArrayList, Vector, LinkedList
			Set - HashSet, TreeSet
			Map - HashMap, HashTable, TreeMap, Properties
		2. 주요 기능
			List - 순서를 유지하고 저장
				 - 중복 저장 기능
			Set - 순서를 유지하지 않고 저장
			    - 중복 저장 안됨
			Map - 키와 값의 쌍으로 저장
			    - 키는 중복 저장 안됨    	 
			    List >>  MAp >>>>Set 순서로 사용빈도
		
		# List 컬렉션
		1. 특징
			인덱스로 관리
			중복해서 객체 저장 가능
		2. 구현 실제 클래스
			ArrayList
			Vector
			LinkedList
		3. 주요 메서드
		- 리턴 메서드
		*boolean add()
		void add(int index, 추가객체)	: 특정위치에 추가	
		set(int index) : 특정위치 변경
		
		boolean contains(요소객체) : 요소 객체 있는지 여부 리턴
		*get(int index) : 특정위치에 있는 요소객체 가져오기
		isEmpty() : 컬렉션이 비어 있는지 확인 // boolean 값
		int size() : 크기
		
		if( !list.isEmpty() ){}
		== if( list.size()>0) {}
		
		void clear() : 포함된 모든 객체를 삭제
		remove(int index) : 해당 위치의 객체를 삭제
		boolean remove(Object o) : 주어진 객체를 삭제
		
		
		*/
		// 인터페이스 = 실제객체
		List<String> slist = new ArrayList<String>();
		slist.add("사과");
		slist.add("오렌지");
		slist.add("수박");
		System.out.println(slist);
		
		slist.add(0, "바나나"); // 0번에 바나나 추가
		System.out.println(slist);
		
		slist.set(1, "키위"); // 사과>>키위
		System.out.println(slist);
		
		
		// ex) slist2로 List 실제 하위 객체를 생성하고 컴퓨터부품 3개를 할당, 두 번째 위치에 할당, 첫번째 위치 변경
		List<String> slist2 = new ArrayList<String>();
		slist2.add("CPU");
		slist2.add("RAM");
		slist2.add("HDD");
		System.out.println(slist2);
		
		// index(0~)를 지정해서 데이터 추가
		slist2.add(1, "SSD");
		System.out.println(slist2);
		
		// 변경
		slist2.set(0, "I7 3.2Ghz");
		System.out.println(slist2);
		
		System.out.println("졸려요 졸려요 너무 졸린건아닌데 슬슬 졸음이 옵니다..........");
		
		// 객체형 VO를 넣고 처리하는 List
		List<Product> buyList = new ArrayList<Product>();
		buyList.add(new Product("사과",1200,3));
		buyList.add(new Product("바나나",3400,3));
		buyList.add(new Product("오렌지",1500,3));
		
		Product p = buyList.get(0);
		System.out.println("객체등록여부1: "+buyList.contains(p));
		// 객체에 동일한 참조값이 있을 때, true
		Product p2 = new Product("오렌지", 1500, 3);
		System.out.println("객체등록여부2: "+buyList.contains(p2));
		System.out.println("크기: "+buyList.size());
		System.out.println("비어있는지: "+buyList.isEmpty() );
		
		buyList.remove(0); // remove(0) : 첫번째 데이터 삭제
		System.out.println("크기: "+buyList.size());
		
		buyList.clear();// 모두 다 삭제
		System.out.println("크기: "+buyList.size());
		System.out.println("비어있는지: "+buyList.isEmpty());
		

		// ex) Member(이름/나이) class 선언, mlist로 회원 3명을 등록하고 
		//     마지막 데이터 삭제, 회원 목록 확인, 전체 삭제, 크기 확인
		List<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member("이지은", 30));
		mlist.add(new Member("이지수", 30));
		mlist.add(new Member("정은지", 30));

		// 마지막 데이터의 index번호는 : .size()-1
		mlist.remove(mlist.size()-1); 
		
		// 전체 데이터 확인
		for(Member m:mlist) {  // 향상된 for문
			System.out.println(m.getName()+"\t");
			System.out.println(m.getAge()+"\n");
		}
		for(int idx=0;idx<mlist.size();idx++) { // idx<mlist.size() : 크기
			// 단위객체 = .get(인덱스번호)
			Member m = mlist.get(idx);
			System.out.println(m.getName()+"\t");
			System.out.println(m.getAge()+"\n");
		}		
		mlist.clear();// 전체 삭제		
		System.out.println(mlist.size());
		// 회원명 검색
		// 회원의 나이에 해당되는 데이터 검색
		
		/*
		#Vector
		1. List<E> list = new Vector<E>();
		2. 특징
			1) 쓰레드 동기화
			2) 복수의 쓰레드가 동시에 Vector에 접근해 객체를 추가, 삭제하더라도 스레드에 안정
			==> 쓰레드가 안정성이 부족하여 추가/삭제시 Thread 안정성 기능이 지원되지 않으면 생략되는 경우가 있다
		
		# LinkedList
		1. List<E> list = new LinkedList<E>();
		2. 특징
			1) 인접 참조를 링크해서 체인처럼 관리
			2) 특정 인덱스에서 객체를 제거하거나 추가하게 되면 바로 앞뒤 링크만 변경
			3) 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList보다 좋은 성능
		
		*/
		
		
		
		
		
		
		
		
	
	}

}
class Member{
	private String name;
	private int age;
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

class Product{
	private String name;
	private int cnt;
	private int price;
	public Product(String name, int cnt, int price) {
		this.name = name;
		this.cnt = cnt;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	
}