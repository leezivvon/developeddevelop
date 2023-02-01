package javaexp.z01_homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class A16_0921 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		2022-09-21
[1단계:개념] 1. Collections의 핵심 3가지 인터페이스와 특징을 기술하세요.
[1단계:개념] 2. List에서 지원하는 메서드의 기능을 예제를 통하여 설명하세요.
[1단계:코드] 3. List<Player>를 통해 Player팀명,선수명,성적을 선언하고, 회원등록/수정/삭제 처리를 하세요.
[1단계:코드] 4. List<Card>를 통해 카드(모양,번호) 52장을 만들고, 임의의 카드 7장을 추출하여 출력하세요.
[2단계:코드] 5. 위 3번 선수데이터를 임의로 5명 정도 등록하고, 선수의 이름과 성적으로 검색되는 로직를 처리하세요.
[1단계:코드] 6. 주머니속에 1000원 2장, 5000원 3장, 10000원 2장을 넣었을 때, Set객체로 처리하여 안에 있는
      금액의 합산을 출력하세요
[1단계:개념] 7. Map의 기능메서드를 기본 예제와 함께 나열하세요.
[2단계:코드] 8. Map<String, Civilian> 형태로 주민번호와 주민(이름, 사는곳)을 설정하여 5명을 할당하고, 출력하세요
	
		*/
		//1
		/*
		1. 인터페이스
			List 
			 - *ArrayList, Vector, LinkedList
			 - 순서를 유지하고 저장, 중복 저장O
			Set 
			 - HashSet, TreeSet
			 - 순서를 유지하지 않고 저장, 중복 저장X
			Map 
			 - HashMap, HashTable, TreeMap, Properties
			 - 키와 값이 함께 저장, 키는 중복 저장X, 값은 중복저장O
		*/
		//2 List 메서드 
		/*
		.add()
		.add(int index, 추가객체)	: 특정위치에 추가	
		.set(int index) : 특정위치 변경
		
		.contains(요소객체) : 요소 객체 있는지 여부 리턴
		.get(int index) : 특정위치에 있는 요소객체 가져오기
		.isEmpty() : 컬렉션이 비어 있는지 확인 // boolean 값
		.size() : 크기
		
		.clear() : 포함된 모든 객체를 삭제
		.remove(int index) : 해당 위치의 객체를 삭제
		.remove(Object o) : 주어진 객체를 삭제	
		*/
		List<String> jlist = new ArrayList<String>();
		jlist.add("포도쥬스");
		jlist.add("오렌지쥬스");
		System.out.println(jlist); // [포도쥬스, 오렌지쥬스]
		
		jlist.add(1, "수박쥬스");    // 두 번째 순서에 수박쥬스추가
		System.out.println(jlist); // [포도쥬스, 수박쥬스, 오렌지쥬스]		
		jlist.set(0, "키위쥬스");    // 첫 번째 포도쥬스를 키위쥬스로 변경
		System.out.println(jlist); // [키위쥬스, 수박쥬스, 오렌지쥬스]
		System.out.println(jlist.contains(jlist.get(0)));
		// jlist[0] 에 요소 객체 있는지 여부 true ..
		
		//3  3. List<Player>를 통해 Player팀명,선수명,성적을 선언하고, 
//		회원등록/수정/삭제 처리를 하세요.
		List<Player> plist = new ArrayList<Player>(); // 객체 선언
		// 회원등록&확인
		plist.add(new Player("토트넘","손흥민",1));
		plist.add(new Player("마요르카","이강인",20));
		plist.add(new Player("울산 현대","조현우",261));
		plist.add(new Player("올림피아코스","황의조",145));
		plist.add(new Player("나폴리","김민재",201));
		for(Player p : plist) {
			System.out.print(p.getTname()+"의 ");
			System.out.print(p.getPname()+" 선수가 회원으로 등록되었습니다");
			System.out.println("\t랭킹 "+p.getGrd()+" 위");
		}
		
		plist.add(new Player("전북 현대","김진수",160));
		Player pl = plist.get(plist.size()-1);
		System.out.println("-새로운 회원이 등록하였습니다-");
		System.out.println(pl.getTname()+"의 "+pl.getPname()+" 선수가 회원으로 등록되었습니다\t랭킹 "+pl.getGrd()+" 위");
		
		plist.remove(plist.get(3));
		
		System.out.println("  <  등록된 선수 목록  >");
		for(Player p : plist) {
			System.out.println("\t"+p.getPname()+" 선수");
		}
		plist.clear();
		
		//3 정답
		/*
		처리순서
		1. Player 클래스선언
		2. add(new Player())
		3. set(index, new Player)
		4. remove(index)
		*/
//		List<Player> plist = new ArrayList<Player>(); // 객체 선언
		// 객체 등록
		plist.add(new Player("LG","김길동",3432 ));
		plist.add(new Player("SK","신길동",542 ));
		plist.add(new Player("기아","한길동",623 ));
		
		// 크기 확인
		System.out.println("크기 "+plist.size());
		
		// 객체 수정
		plist.set(1,  new Player("KT","오길동",201));

		//객체 삭제
		plist.remove(0);
		
		//출력
				for(Player p: plist) {
					System.out.println(p.getPname()+" : "+p.getTname()+" : "+p.getGrd());
				}
		

		//4
		List<Card> card = new ArrayList<Card>();

		for(int cnt2=2;cnt2<15;cnt2++) {
			card.add(new Card("♠",cnt2));		
			card.add(new Card("◆",cnt2));		
			card.add(new Card("♣",cnt2));		
			card.add(new Card("♥",cnt2));		
			}
		
		for(int cnt=1; cnt<=7;cnt++) {
			Card c = card.get((int)(Math.random()*52));
			System.out.print(c.getShape()+c.getNum()+" ");
		}
		
		System.out.println();
		
		// 4 정답
		/*
		처리순서
		1. Card클래스
		2. 2중 for문 이용해서 Card생성
		   모양 배열 선언
		   번호 ArrayList 선언
		   for(){} 모양
		   	for(){} 번호
		   		cardList.add(new Card(모양, 번호))
		3. 임의의 카드 7장 추출   		
			// 랜덤 클래스 이용
			Randmon =r = new Random(); 
			ArrayList<Card> team01 = new ArrayList<Card>();
			for(1~7)
				int rIdx = r.nextInt(52); //0~51 임의값 추출
				team01.add(cardList.get)(rIdx)

		*/
		String[] shapes = {"♠","◆","♣","♥"};
		ArrayList<String> nums = new ArrayList<String>();
		nums.add("A");
		for (int cnt = 2; cnt<=10; cnt++) {
			nums.add(""+cnt); // 자동형변환
//			nums.add(Integer.valueOf(cnt).toString());   정석.
		}
		nums.add("K"); 
		nums.add("Q"); 
		nums.add("J");
	
		List<Cardd> cardList = new ArrayList<Cardd>(); // 카드를 배열로 선언

		for(String shape : shapes) { // 모양 반복
			for(String num:nums) {   // 번호 반복
				cardList.add(new Cardd(shape,num));
			}
		}
		int cnt =1;
		for(Cardd c : cardList) {
			System.out.println(cnt++ +":"+c.getShape()+c.getNum());
		}
		// 7개 카드 추출
		List<Cardd> team01 = new ArrayList<Cardd>();
		List<Cardd> team02 = new ArrayList<Cardd>();
		Random r = new Random();
		for(cnt=1; cnt<=7;cnt++) {
			int rIdx = r.nextInt(52);
			team01.add(cardList.get(rIdx));
		}
		for(cnt=1; cnt<=7;cnt++) {
			int rIdx = r.nextInt(52);
			team02.add(cardList.get(rIdx));
		}
		System.out.println("# 첫 번째 팀카드 #");
		for(Cardd d : team01) System.out.print(d.getShape()+d.getNum()+"  ");
		System.out.println();
		
		System.out.println("# 두 번째 팀카드 #");
		for(Cardd d : team02) System.out.print(d.getShape()+d.getNum()+"  ");
		System.out.println();
		
		// 로직에 의해 중복을 배제
		// 기능 객체에 의해 섞어 주는 처리 
		Collections.shuffle(cardList); // 52객체를 임의의순서로 만들어줌
		int cntt=1;
		System.out.println("# 1번 팀 #");
		for(int idx=0; idx<7;idx++) { //1~7
			Cardd d = cardList.get(idx);
			System.out.print(d.getShape()+d.getNum()+"  ");
		}
		System.out.println();
		System.out.println("# 2번 팀 #");
		for(int idx=7; idx<14;idx++) { //8~14
			Cardd d = cardList.get(idx);
			System.out.print(d.getShape()+d.getNum()+"  ");
		}
		System.out.println();
	
	
		
		
		//5 5. 위 3번 선수데이터를 임의로 5명 정도 등록하고, 선수의 이름과 성적으로 검색되는 로직를 처리하세요.
		// 
//	    Map<Integer,Player> ply = new HashMap<Integer,Player>();
//	    ply.put(1, new Player("토트넘","손흥민",1));
//	    ply.put(20, new Player("마요르카","이강인",20));
//	    ply.put(160, new Player("전북 현대","김진수",160));
//	    ply.put(261, new Player("울산 현대","조현우",261));
//	    ply.put(201, new Player("나폴리","김민재",201));
//	   
//	    Set<Integer> rank =ply.keySet();
//	    for(int ranking : rank) {
//	    	System.out.print(ranking+"\t");
//	    	Player pp = ply.get(ranking);
//	    	System.out.println(pp.getPname());
//	    }
//	    Player pr = new Player();
//	    ply.containsKey(1);
//	    ply.containsValue(pr."손흥민"); //포기 
		
		Map<String,String> ply = new HashMap<String, String>();
		ply.put("1", "손흥민");
		ply.put("20", "이강인");
		ply.put("160", "김진수");
		ply.put("261", "조현우");
		ply.put("201", "김민재");
		
		Scanner scsc = new Scanner(System.in);
		System.out.println("검색하고 싶은 선수의 이름을 입력하세요: ");
		String str1 = scsc.nextLine();
		System.out.println(str1+"선수 등록 여부: "+ply.containsValue(str1));
		System.out.println("검색하고 싶은 선수의 랭킹을 입력하세요: ");
		String str2 = scsc.nextLine();
		System.out.println("랭킹"+str2+"위 선수 등록 여부: "+ply.containsKey(str2));
		
		// 5정답
		/*
		처리 순서
		1. 선수등록 plist.add(new Player())
		2. Scanner 생성 
			이름: ==> schName
			성적: ==> schRecord 형변환 처리 Integer.parseInteger()  //Double.parseDouble()  
			둘 중에 하나만 맞으면 검색(or)
		3.
		  List<Player> schRList = new ArrayList<Player>();
	      for(Player p : plist)
			if(p.getName().equals(schName)){ // 정확한 이름이 있을 때
			
			} 
			if(schRecord==p.getRecord() || p.getName().indexOf(schName)!=-1){ // 해당 keyword가 있으면 검색
				schRList.add(p);
			}
		4. 검색 결과 출력
			if(schRList.size()>0){
				for(Player p : schRList){
					p.getTname(), p.getPname(), p.getGrd()
				}
			}else{
				검색된 결과가 없습니다
			}
		*/
	
		System.out.println(plist.size());
		plist.add(new Player("KT", "이영철",301));
		plist.add(new Player("SK", "홍현만",312));
		plist.add(new Player("기아","이정후",78));
		System.out.println(plist.size());
		System.out.println("# 전체 리스트 #");
		for(Player p : plist) {
			System.out.println(p.getTname()+"팀\t"+p.getPname()+":\t"+p.getGrd() );
		}
		
		Scanner scc = new Scanner(System.in);
		System.out.print("검색할 이름: ");
		String schName = scc.nextLine();
	
		System.out.print("검색할 성적: ");
		int schRecord = Integer.parseInt(scc.nextLine());
				
		List<Player> schRList = new ArrayList<Player>();
	    for(Player p : plist) {
	    	// indexOf() : 해당 문자가 포함되어 있으며 해당 index 위치를 리턴
	    	// equals() : 해당 문자열이 정확하게 있으면..
	    	if(schRecord==p.getGrd() || p.getPname().indexOf(schName)!=-1){ // 해당 keyword가 있으면 검색
				schRList.add(p); // 검색한 결과 누적..?
			}
	    }
	    System.out.println("# 검색 결과 #");
		if(schRList.size()>0){
			for(Player p : schRList){
				System.out.println(p.getTname()+"\t"+p.getPname()+"\t"+p.getGrd());
			}
		}else{
			System.out.println("검색된 결과가 없습니다");
		}
		
		
		
		
	 
	    //6
		Set<Integer> set = new HashSet<Integer>();
		set.add(1000);
		set.add(1000);
		set.add(5000);
		set.add(5000);
		set.add(5000);
		set.add(10000);
		set.add(10000);
		System.out.println();
		int sum =0;
		for(int money:set) {
			sum+=money;
		}
		System.out.println("총 합: "+sum);
		
		//7
		/*		
		 Map의 기능메서드
		    1) put(Key, Value) : 주어진 키와 값을 추가, 저장이 되면 값을 리턴
		 	2) containsKey(Object key) : 주어진 키가 있는지 여부 
		 	3) containsValue(Object val) : 주어진 값이 있는지 여부
		 	4) Set<Map.Entry<K,V>> entrySet() : 키와 값의 쌍으로 구성된 모든 Map.Entry객체를 Set에 담아서 리턴
		 	5) V get(Object key) : 컬렉션이 비어있는지 여부
		 	6) keySet() :모든 키를 Set 객체에 담아서 리턴
		 	7) size() : 저장된 크기
		 	8) clear() : 전체 삭제
		 	9) remove(Object key) : 키로 해당 구성데이터 삭제 	
		*/
		//8
		Map<String, Civillian> civil = new HashMap<String, Civillian>();
		civil.put("900214-100****",new Civillian("김철수", "서울")); // 00 서울
		civil.put("920419-210****",new Civillian("김영희", "부산")); // 10 부산
		civil.put("940624-113****",new Civillian("이민우", "인천")); // 13 인천
		civil.put("960829-240****",new Civillian("이윤지", "대전")); // 40 대전
		civil.put("981003-255****",new Civillian("박현희", "광주")); // 55 광주
		Set<String> cnums = civil.keySet();
		for(String cnum : cnums) {
			System.out.print(cnum+"\t");
			Civillian cv = civil.get(cnum);
			System.out.print(cv.getName()+"\t");
			System.out.print(cv.getLoc()+"\n");
		}
		
			// 알고리즘 문제
				ArrayList<Integer> points = new ArrayList<Integer>();
				points.add(new Integer(70));
				points.add(90);
				points.add(100);
				points.add(new Integer("80"));
				int minPoint = 100; // 배열에서 최소값을 도출할 때는 나올 수 있는 최대값을 초기값으로 설정
				int maxPoint =0; // 최대값을 도출할 때는 나올 수 있는 최소값ㅇㄹ 설정
				for(int num01:points){
					System.out.println("최소값- "+num01+":"+minPoint);
					System.out.println("최대값- "+num01+":"+maxPoint);
					// 초기 최소값보다 적은 값이 나올 때 최소값으로 설정
					if(minPoint >= num01){
				       minPoint=num01;
				   }else if(num01>maxPoint) { // 나온 값이 현재 설정된 최대값보다 많을 때
					    maxPoint = num01;
				   }
				}
				System.out.println("최소값:"+minPoint);
				System.out.println("최대값:"+maxPoint);
				
				// 알고리즘 20일
				/*
1. 문자열을 검색할 때, 검색하는 형식이 틀린 것은
    1) 
       // 배열안에 있는 검색을 전체를 하여 결과를 처리해야 하기 때문에 검색 결과를 전역변수로 선언
       // {"홍길동","김길동","신길동"} : members
       // "홍" : schStr
        boolean hasData=false;
        for(String mem : members){
            if(mem.indexOf(schStr) !=-1){ // 비슷한 글자
                hasData=true;
            }
        }
        // 하나라도 검색이 되면 hasData=true;
 
    2) 
        boolean hasData=false;
        for(String mem : members){
            if(mem.equals(schStr)){ // 동일한 문자열 있을 때
                hasData=true;
            }
        }
    3) 
        // {"홍길동","김길동","신길동"} : members
        // "홍" : schStr
        for(String mem : members){
            String result=""; 
            // for문안에 들어 가서 초기값 설정 필
            // 외부에서 for문에서 검색된 결과를 볼 수 없을 뿐만아니라
            // 반복분을 통해 다시 ""으로 초기화가 되어 배열 중에 한 개 검색된 내용을 정상적으로 처리가 되지 않는다
            if(mem.indexOf(schStr) !=-1){
                result="검색됨";
            }
        }
    4)  String result="";
        for(String mem : members){
            if(mem.equals(schStr) ){
                result="검색됨";
            }
        }

				
				*/
				
				
				
				

		

	}
}
//8
class Civillian{
	private String name;
	private String loc;
	public Civillian(String name, String loc) {
		this.name = name;
		this.loc = loc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
// 4 정답
class Cardd{
	private String shape;
	private String num;
	public Cardd(String shape, String num) {
		this.shape = shape;
		this.num = num;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}



//4
class Card{
	private String shape;
	private int num;
	public Card(String shape, int num) {
		this.shape = shape;
		this.num = num;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}


//3
class Player{
	private String tname;
	private String pname;
	private int grd;  // private double record; // 야구선수 타자로 한대요
	public Player() {
	}
	public Player(String tname, String pname, int grd) {
		this();//super();
		this.tname = tname;
		this.pname = pname;
		this.grd = grd;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getGrd() {
		return grd;
	}
	public void setGrd(int grd) {
		this.grd = grd;
	}	
}