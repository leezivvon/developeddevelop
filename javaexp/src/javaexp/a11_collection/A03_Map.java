package javaexp.a11_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A03_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# Map 컬렉션의 특징 및 주요 메서드
		1. 특징
			- 키(key)와 값(value)로 구성된 Map.Entry객체를 저장하는 구조
			- 키와 값은 모두 객체
			- 키는 중복 될 수 없지만 값은 중복 저장 가능
		2. 구현 클래스
			HashMap, Hashtalbe, LinkedHaspMap, Properties, TreeMap
		3. 주요 메서드
			put(Key, Value) : 주어진 키와 값을 추가, 저장이 되면 값을 리턴
		 	containsKey(Object key) : 주어진 키가 있는지 여부 
		 	containsValue(Object val) : 주어진 값이 있는지 여부
		 	Set<Map.Entry<K,V>> entrySet() : 키와 값의 쌍으로 구성된 모든 Map.Entry객체를 Set에 담아서 리턴
		 	V get(Object key) : 컬렉션이 비어있는지 여부
		 	keySet() :모든 키를 Set 객체에 담아서 리턴
		 	size() : 저장된 크기
		 	clear() : 전체 삭제
		 	remove(Object key) : 키로 해당 구성데이터 삭제 
		
		*/
		Map<String, String> map1 = new HashMap<String, String>();
		// Map<유형선언, 유형선언>
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map1.put("1000","홍길동");
		map1.put("1000","김길동"); // 데이터가 겹치면 마지막 데이터로 변경
		map1.put("1001","신길동");
		map1.put("1002","오길동");
		System.out.println("map1의 데이터 건수: "+map1.size());
		
		map2.put(1, "himan"); // Auto Boxing  // map2.put(Integer.valueOf(1), "himan"); 
		map2.put(2, "goodman"); // Auto Boxing 
		map2.put(1, "hiGirl");
		map2.put(3, "goodGirl");
		map2.put(4, "Ohmy");
		System.out.println("map2의 데이터 건수: "+map2.size());
		// 맵.keySet() : Map에서 key만 가져오는 메서드
		// Set<String> 키로된 값
		Set<String> map1Key = map1.keySet(); 
		// Set<Integer>
		Set<Integer> map2Key = map2.keySet();
		
		for(String key:map1Key) {
			//map1.get(key) : 키를 통해 value값
			System.out.println(key+":"+map1.get(key));
		}
		for(int key:map2Key) {
			System.out.println(key+":"+map2.get(key));
		}
		
		// ex) 학생의 번호(문자열)와 점수(정수)를 설정한 Map을 선언하여 학생 3명의 번호와 점수를 할당하되
		//     2번은 중복하여 입력 결과를 출력하세요
		
		Map<String, Integer> map3 = new HashMap<String, Integer>();
		map3.put("32",80); // die
		map3.put("32",100); // 키 중복 
		map3.put("10",90);
		map3.put("20",90); // 값 중복
		
		System.out.println("데이터 건수: "+map3.size());
		Set<String> map3Key = map3.keySet(); // string 키값....?
		for(String key : map3Key) {
			System.out.println(key+" : "+map3.get(key)); // map3.get(key) key를 통해 value값
		}
		
		// 정답
		Map<String, Integer> studs = new HashMap<String, Integer>();
		studs.put("1000", 70);
		studs.put("1001", 80);
		studs.put("1002", 90);
		studs.put("1002", 50);
		
		Set<String> nos = studs.keySet();
		for(String no : nos) {
			System.out.println(no+" : "+studs.get(no)); // 
		}
		System.out.println(" 총 인원 수 : "+studs.size());
	
		// 정답 - class 이용
		Map<Integer,StuPoint> stdMap = new HashMap<Integer,StuPoint>(); // 객체가 들어감
		stdMap.put(1, new StuPoint("홍길동", 70,60,80));
		stdMap.put(2, new StuPoint("김길동", 70,60,80)); // 얘는 덮어씌워짐
		stdMap.put(3, new StuPoint("고길동", 70,60,80));
		stdMap.put(2, new StuPoint("모길동", 70,60,80)); // 얘로
		Set<Integer> inos = stdMap.keySet();
		for(int no : inos) {
			System.out.println(no+"\t");
			StuPoint st = stdMap.get(no);
			System.out.println(st.getName()+"\t");
			System.out.println(st.getKor()+"\t");
			System.out.println(st.getEng()+"\t");
			System.out.println(st.getMath()+"\n");
		}
		
		/*
		Wrapper클래스의 경우 key값은 중복을 제거하고 데이터가 자동 정렬된다
		*/
		
		
		
		
	}
}
// 정답
class StuPoint{
	private String name;
	private int kor; 
	private int eng; 
	private int math;
	public StuPoint(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
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