package javaexp.a11_collection;

import java.util.HashSet;
import java.util.Set;

public class A02_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# Set 컬렉션
		1. 특징
			수학의 집합에 비유
			저장 순서가 유지되지 않음
			객체를 중복 저장 불가
		2. 구현 클래스
			HashSet, LinkedHashSet, TreeSet
		3. 주요 메서드
			.add()
			.contain()
			.isEmpty()
			Iterator<E> iterator()
			.size()
			.clear()
			.remove(Object ob)	
		    # 전체 객체 대상으로 한번씩 반복해서 가져오는 반복자(Iterator)제고
		      - 인덱스로 객체를 검색해서 가져오는 메서드 없음
		
		4. HashSet
		 1) Set<E> set = new HashSet<E>();
		 2) 특징
		 	동일 객체 및 등등 객체는 중복 저장하지 않음
		 	동등 객체 판단 hashCode ==> equals
		
		*/
		Set<String> set = new HashSet<String>(); // 순서가 확보되지않음
		set.add("딸기");
		set.add("사과");
		set.add("바나나");
		set.add("수박");
		set.add("오렌지");
		set.add("딸기");
		set.add("딸기");
		set.add("딸기");
		System.out.println("# 저장된 set #");
		for(String fruit : set) {
			System.out.println(fruit);
		}
		
		// ex) 주머니 속에 구슬 빨강2개 파랑3개 노랑2개를 Set으로 할당하고 for문을 통해 출력해서 
		//     들어가 있는 모든 구슬의 개수를 출력하세요
		
		Set<String> pouch = new HashSet<String>();
		pouch.add("빨간 구슬");
		pouch.add("빨간 구슬");
		pouch.add("파란 구슬");
		pouch.add("파란 구슬");
		pouch.add("파란 구슬");
		pouch.add("노란 구슬");
		pouch.add("노란 구슬");
		
		System.out.println("마법 주머니 속 구슬");
		for(String one : pouch) { // 배열에 할당
			System.out.println(one); 
		}
		System.out.println("총 구슬 수: "+pouch.size());
		
	
		
	}
}