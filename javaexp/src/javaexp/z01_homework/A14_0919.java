package javaexp.z01_homework;

public class A14_0919 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		2022-09-19
[1단계:개념] 1. 사용자 정의 예외 클래스의 기본 형식과 Exception 클래스의 기본 생성자2개, 주요메서드2개를 기술하세요
[1단계:코드] 2. User03Exception을 통해 생성자를 매개변수로 문자열을 넘기고, getMessage()를 재정의하여 [사용자정의]라는 문자열을
         포함하여, 이 사용자 정의 예외가 11~20 반복문에서 짝수일 때, 처리되게 하세요
[1단계:개념] 3. Object클래스가 기본적으로 가지고 있는 메서드(equals(), toString(), hashCode())를 기술하세요.
[1단계:코드] 4. 같은 클래스의 두개 객체의 속성값이 같으면 hashCode가 동일하게 처리할려고 한다.  Bus(번호,행선지)를 기준으로 처리하세요.
[1단계:코드] 5. 특정 프로그램의 실행 시간을 확인할려고 한다. 해당 코드의 메서드와 결과를 설명하세요.
[1단계:코드] 6. 문자열로 대문자/소문자/특수문자를 선언하고, 이 중에서 8자를 추출하여 비번호를 처리할려고 한다.
      charAt를 활용하여 처리하세요.
		
		*/
		
		//1
		/*
		<사용자 정의 예외 클래스의 기본 형식>
		 class XXXException extends [Exception|RuntimeException]{
		  	public XXXException(){}
      		public XXXException(String message){
		        super(message);
		    }
		 }    
		 <Exception 클래스의 기본 생성자2개, 주요메서드2개> // 솔직히 맞는지 모르겠어요..
		 기본 생성자
		 	public XXXException(){}
      		public XXXException(String message){ super(message); } 
		 주요 메서드
		 	getMessage() 
		 		- 예외 발생시킬 때 생성자 매개값으로 사용한 메세지 리턴
		 		  catch절에서 활용
		 	printStackTrace
		 		- 예외 발생 코드 추적한 내용을 모두 콘솔 창에 출력
		*/
		//2
		for(int cnt=11;cnt<=20;cnt++) {
			System.out.println(cnt);
			try {
			if(cnt%2==0) {
				throw new User03Exception(cnt+": 짝수 일때 예외 처리");
			}
			}catch(User03Exception e) {
				System.out.print("<예외 발생> ");
				System.out.println(e.getMessage());
			}finally {
				System.out.println("예외처리(상관없이)");
			}
		}		
		//3 
		/*
		equals() : 논리적 동등 비교할 때 이용/ 객체의 속성(ex 문자열)을 비교할 때 사용
		toString() : 참조변수만 호출 했을 때 나타나는 데이터와 비교가능하고 
		             재정의하면 참조변수도 동일한 값으로 변경이 된다
		hashCode() : 객체 식별할 하나의 정수값이고 객체의 메모리 번지 이용해 해시코드로 만들어 리턴하여 데이터값 비교 가능 
		             개별 객체는 해시코드가 모두 다름
		*/
		//4 String.hashCode()+String.hashCode() = 는 안되는건지...ㅠ
		Busss b1 = new Busss(52,"건대행");
		Busss b2 = new Busss(52,"건대행");
		Busss b3 = new Busss(574,"홍대행");
		System.out.println("b1=b2 비교 : "+(b1.hashCode()==b2.hashCode()));
		System.out.println("b1=b3 비교 : "+(b1.hashCode()==b3.hashCode()));
		
		//5 
		// for문이 1~100000까지의 수가 순차적으로 누적합을 도출하는 데 걸리는 시간을 출력하는 것이다
		/*
		1) 시작시간을 확인해서 가져오고
		2) 프로그램 수행
		3) 마지막 시간 확인
		4) 시작시간과 마지막 시간 차이 확인
		*/
//		long start = System.currentTimeMillis(); // 1/1000초
//		long end = System.currentTimeMillis();
//		long time = end-start;
//		System.out.println("걸린 시간: "+time/1000.0);
		
		
		long start = System.currentTimeMillis();
		System.out.println("시작: "+start);
		
		int sum =0;
		for(int cnt=1; cnt<100000; cnt++) {
			sum+=cnt;
		}
		long end = System.currentTimeMillis();
		System.out.println("종료: "+end);
		long time = end-start;
		System.out.println("결과: "+sum);
		System.out.println(time); // 시간이 1000*초 단위로 나온다
		System.out.println(time/1000+"초");
		System.out.println(time/1000/60+"분");
		System.out.println(time/1000/60/60+"시");
	
	
		//6
		String nothing = "uew;okvewoSeo-$^^dskWEFH#$%&eAXP#)IMsp*)@";//41개
		int pick1 = (int)(Math.random()*41+1);
		int pick2 = (int)(Math.random()*41+1);
		int pick3 = (int)(Math.random()*41+1);
		int pick4 = (int)(Math.random()*41+1);
		System.out.print("비밀번호 생성: ");
		System.out.println(nothing.charAt(pick1)+nothing.charAt(pick2)+nothing.charAt(5)+nothing.charAt(15)
		                   +nothing.charAt(pick3)+nothing.charAt(25)+nothing.charAt(35)+nothing.charAt(pick4));
	
	
		
		
	}
}
//4
class Busss {
	private int bnum;
	private String bdest;
	public Busss(int bnum, String bdest) {
		this.bnum = bnum;
		this.bdest = bdest;
	}
	@Override
	public int hashCode() {
		int hashcode = this.bnum+this.bdest.hashCode();
		return hashcode;
	}
		
}
/*
# 사용자 정의 클래스
1. extends Exception
2. 생성자 매개변수 처리
3. 재정의 메서드 선언
4. 상황에 맞게 해당 객체 강제 예외 처리 throw new 사용자정의 예외클래스 생성자();
	try{
		throw new User03Exception("예외메세지내용");
	}catch(User03Exception e){
		System.out.println("예외 메세지: "+e.getMessage());
	}catch(Exception e){
		System.out.println("최상위 예외");
	}finally{
		System.out.println("예외 상관없이 처리할 내용");
	}
*/
//2 
class User03Exception extends Exception{
	//매개변수로 getMessage()를 통해서 나타나는 문자열 전달 가능하게 처리
	public User03Exception(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		return "[재정의된 메서드] "+super.getMessage();
	}	
}
