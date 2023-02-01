package javaexp.a10_api;

public class A08_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# String 객체의 메모리 문제
		1. String 문자열은 +를 통해서 새롭게 heap영역에 만들어져 반복문을 활용하면 많은 객체가 만들어지게 된다
		2. 문자열은 +를 통해서 만들면 새로운 메모리가 만들어지므로 특히 반복문 안에서 사용하는 것은 가능한한 자제하여야 한다
		*/
		String name ="홍";
		for(int idx=0; idx<10; idx++) {
			name+=idx; // 새로운 메모리가 계속 만들어지는 것 = 주소값이 다 다름
			// + 를 통해서 하나의 메몰 name에 문자열 추가하는 것이 아니라
			// 새로운 메모리를 만들어서 name이란 이름으로 처리되기때문에 반복문에 문자열 + 연산자를 쓰는 것은 메모리효율화에 위험하다
			System.out.println(idx+":"+name.hashCode()+":"+name);	
		}
		
		
		/*
		# StringBuffer, StringBuilder
		1. 버퍼(buffer: 데이터를 임시로 저장하는 메모리)에 문자열 저장
		2. 버퍼 내부에서 추가, 수정, 삭제 작업 가능
		3. 멀티 쓰레드 환경: StringBuffer사용
			1초 0.0~0.1 ==> 사용자1
			1초 0.1~0.2 ==> 사용자2
			1초 0.2~0.3 ==> 사용자3 ...10명 // 1초 안에 10명
			2초 1.0~1.1 ==> 사용자1
			순서확보를 정확하게 할 수 없다. 그렇지만 한번에 여러 사용자 처리가 가능하다
		4. 단일 쓰레드 환경: StringBuilder사용
			1초 사용자1이 모든 걸 다 처리할 때까지 기다리고
			2초 사용자2..
			순서확보를 정확하게 할 수 있으나 한 번에 한 사용자만 사용하여 비효율적으로 처리되나
		5. 주요 메서드
			1) append(...) : 기본적으로 해당 초기 문자열 가장 뒤에 추가 처리된다.
			2) insert(int offset,...) : 특정한 위치에 추가
			3) delete(int start, int end) : 범위를 정해서 삭제
			4) deleteCharAt(int index) : 특정한 위치 문자 삭제
			5) replace(int start, int end, Stirng str) : 특정한 위치 문자 대체
				"안녕하세요 hi! 반갑습니다 hi!"
				첫번째 hi!를 "안녕"으로 바꿀 때
			6) reverse() : 문자열을 뒤집어 사용
			7) setCharAt(int index, char ch) : 특정한 위치에 문자를 대체
				"안녕하세요 hi! 반갑습니다 hi!"
				h==>g  특정한 위치index 문자하나로 변경
		*/
		System.out.println("# StringBuffer #");
		StringBuffer sbf = new StringBuffer("안녕하세요!!");
		for(int idx=0;idx<10;idx++) {
			sbf.append(""+idx);
			System.out.println(idx+":"+sbf.hashCode()+":"+sbf.toString());
			//같은 메모리를 사용 = 주소값 같음
		}
		
		System.out.println(sbf.reverse().toString()); // 요세하녕안
		
		// ex) 배열로 가위/바위/보로 문자열을 선언하고 반복문으로 1~100회 임의의 가위 바위 보를 추가하여
		//     StringBuffer에 할당하여 출력하세요
		
		
//		String[] rsp = {"가위", "바위", "보"};
//		
//		for(int cnt=1;cnt<=100;cnt++) {
//			int rd = (int)(Math.random()*3);
//			StringBuffer rspsbf = new StringBuffer(rsp[rd]);
//			rspsbf.append(""+cnt);}
	
		
		String[] games = {"가위", "바위", "보"};
		StringBuffer sbf2 = new StringBuffer("# 가위,바위,보 100회 #\n");
		for(int cnt=1;cnt<=100;cnt++) {
			int rIdx = (int)(Math.random()*games.length);
			sbf2.append(cnt+"\t"+games[rIdx]+"\n");// 하나의 buffer에 담아서 즉 문자열로 저장
		}
		System.out.println(sbf2.toString()); // 다른 곳에서 저장해놓은것을 한 번에 출력

		
		
	}

}
