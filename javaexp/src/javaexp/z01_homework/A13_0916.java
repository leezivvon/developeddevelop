package javaexp.z01_homework;

public class A13_0916 {
	

	//8 
		static void calling01()throws NullPointerException{
			String s = null;
			System.out.println(s.toString());
		}
		static void calling02()throws NullPointerException{
			String s = null;
			System.out.println(s.toString());
		}
		
	//9 
		static void call01 () throws ArrayIndexOutOfBoundsException{
			String[] arr01 = {"할","수","있","다"};
			System.out.println(arr01[4]);
			/*
			int[] arry = new int[3]; // index 범위가 3  0,1,2
			System.out.println(arry[3]);
			*/
		}
		
		static void call02( ) throws ArrayIndexOutOfBoundsException{
			int[] arr02 = {1,2,3};
			System.out.println(arr02[5]);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 2022-09-16
[1단계:개념] 1. 추상클래스 사용의 기본 형식을 기본 예제와 함께 설명하세요.
[1단계:코드] 2. 다각형이라는 추상클래스(필드-종류,실제메서드 도화지를 가져오다(), 추상메서드 drawing() @@을 그리다)를 생성하고 
      상속받은 실제 클래스(삼각형,사각형,오각형)을 처리하세요.
[1단계:개념] 3. 추상클래스와 인터페이스의 차이점을 개념과 함께 정리해보세요.
[1단계:코드] 4. 인터페이스 PaintWay를 선언(추상메서드 paint() @@ 색칠을 하다) 상속받은 실제
      클래스(빨강색, 파랑색, 노랑색)을 처리하세요.
[1단계:개념] 5. 예외 처리의 기본 형식과 처리 순서를 기본 예제에 의해 기술하세요.
[1단계:확인] 6. args를 통해서 나올 수 있는 예외를 아래에 하나씩 처리하세요
      1) args값을 입력 하지 않았을 때. 
      2) args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때.
[1단계:개념] 7. 예외 처리의 계층별 처리란 무엇인지 기술하세요.
[1단계:개념] 8. 예외의 위임처리하는 내용을 예제를 통해서 기술하세요.
[1단계:확인] 9.  call01(), call02()에 배열의 범위를 벗어났을 때, 예외를 위임하는 예제를 처리해보세요.

				*/
		
		
		//1
		Flower f01 = new Rose(); // Rose 클래스 객체 생성
		Flower f02 = new Violet(); // Violet 클래스 객체 생성
		f01.rain(); // 공통 메서드 // 재정의하지 않아도 되는
		f01.bloom();// 추상메서드
		f02.rain();
		f02.bloom();
		
		//2 
		Poly p01 = new Triangle();
		Poly p02 = new Square();
		Poly p03 = new Pentagon();
		p01.paper();
		p01.drawing();
		p02.paper();
		p02.drawing();
		p03.paper();
		p03.drawing();

		//3
		/*
		추상클래스 : 추상 클래스는 단독으로 객체 생성을 하지 못한다 
		           실체 클래스는 추상 클래스르 무조건 상속 받아 작성해야 함
		인터페이스 : 인터페이스는 인터페이스의 메서드만 알고 있으면 됨. 
		           개발코드 변경 없이 내용이 다양해질 수 있음
		*/
		
		//4
		Paperr pr01 = new Paperr();
		pr01.setPaintway(new Red());
		pr01.startPainting();
		pr01.setPaintway(new Blue());
		pr01.startPainting();
		pr01.setPaintway(new Yellow());
		pr01.startPainting();
		
		// 5
//		5. 예외 처리의 기본 형식과 처리 순서를 기본 예제에 의해 기술하세요.
		/*
		 < 기본 형식 >
        try{
        
            // 예외 발생 가능 코드
             
       }catch{예외클래스 선언 e}{
           예외 처리
       }finally{
           예외 상관없이 처리.
       }   
       
          < 순서 >
		1. 기본코드내용 실행 >> 예외가 발생하면 예외 처리 
		2. try{}catch(예외 클래스 내용 선언){}finally{} 사용
		    >> catch 매개변수에 발생한 예외 처리 내용 선언 (예외코드 복붙이 안전)
		    >> 하위{} 블럭에 예외 발생시 내용 기술
		    >> finally{} 예외 발생 상관없이 처리할 내용 처리
		*/
		int num01 = 0;
		
		String str = null;
		
		System.out.println("숫자: "+(++num01));
		System.out.println("숫자: "+(++num01));
		System.out.println("숫자: "+(++num01));
		
		try {
		// 객체 생성안하고 객체.메서드 호출
		System.out.println("코드: "+str.toString());
		}catch(NullPointerException e){
			System.out.println("예외 발생"+e.getMessage());
		}//finally {
		 //	System.out.println("밑으로 예외 발생 없이 처리할 코드");
		 //} finally 없어도 작동 잘되는 거 확인..ㅎㅎ
		System.out.println("숫자: "+(++num01));

		
		// 6 -1 args값을 입력하지 않았을 때
		System.out.println("1");
		System.out.println("2");
		try {
		System.out.println(args[0]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("발생한 예외: "+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 처리하는 내용");
		}
		System.out.println("3");
		System.out.println("4");
		// 6-2 args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때.
	    // Integer.parseInt(args[0]) 첫번째 매개문자가 숫자형이아닐 때 발생 에러 확인 후 처리

		//7 
		/*
		여러가지 예외를 catch block으로 처리할 때, 즉 다중의 예외처리를 할 때 
		하위 예외부터 처리한 후 상위 예외를 순차적으로 처리하는 것을 계층별 처리라고 한다.
		*/
		//8 예외의 위임처리
		try {
			calling01();
			calling02();
		}catch(NullPointerException e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
		
		//9 
		/*
		# 위임 예외 처리 순서
		1. 해당 예외 내용 파악과 실제 나타날 상황 코드 생성 및 예외 copy
		   배열의 범위를 벗어났을 때
		   System.out.println(args[1]);
		   ArrayIndexOutOfBoundsException
		2. 위임할 기능메서드 선언
		    해당 예외와 비슷하게 발생할 내용을 구현
		3. 위임할 예외 내용 throws 위임 예외
		4. 호출하는 곳에서 try{}catch 문으로 예외 처리       
		
		
		
		*/
		
		try {
			call01();
			call02();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위를 벗어남");
			System.out.println("예외위임처리: "+e.getMessage());
		}

	}
}
//4
interface Paintway{
	void paint();
}
class Red implements Paintway{
	public void paint() {
		System.out.println("빨간색을 색칠하다");
	}
}
class Blue implements Paintway{
	public void paint() {
		System.out.println("파란색을 색칠하다");
	}
}
class Yellow implements Paintway{
	public void paint() {
		System.out.println("노란색을 색칠하다");
	}
} 
class Paperr{
	private Paintway paintway; // 인터페이스가 들어올 수 있는 접점..?
	
	public void setPaintway(Paintway paintway) {
		this.paintway = paintway;
	}
	public void startPainting() {
		this.paintway.paint();
	}
	
}

//2 
abstract class Poly {
	private String kind;
	public Poly(String kind) {
		this.kind = kind;
	}
	// 공통 메서드
	public void paper() {
		System.out.println("도화지를 가져오다");
	}
	public String getKind() {
		return kind;
	}
	// 추상메서드
	public abstract void drawing();
}
class Triangle extends Poly {
	public Triangle() {
		super("삼각형");
	}
	@Override
	public void drawing() {
		System.out.println(getKind()+"을 그리다");	
	}	
}
class Square extends Poly {
	public Square() {
		super("사각형");
	}
	@Override
	public void drawing() {
		System.out.println(getKind()+"을 그리다");	
	}	
}
class Pentagon extends Poly {
	public Pentagon ( ) {
		super("오각형");
	}
	@Override
	public void drawing() {
		System.out.println(getKind()+"을 그리다");	
	}
}

//1 추상클래스 기본형식
abstract class Flower {
    private String kind;
    public Flower(String kind) {
    	this.kind = kind;
    }
    // 공통 메서드 : 
    public void rain() {
    	System.out.println(this.kind+" 비를 맞았다.");
	}
	// 추상 메서드: 하위 클래스에서 반드시 재정의해야 함
	public abstract void bloom( );	
	}

class Rose extends Flower{
	public Rose() {
		super("장미가"); // 상속으로 받아서 super(kind);
	}
	@Override
	public void bloom() {
		// 상위에 있는 추상메서드 재정의하는 곳
		System.out.println("담벼락에 만개한 빨간 장미들이 가득하다.");
	}
}
class Violet extends Flower{
	public Violet () {
		super("제비꽃이");
	}
	@Override
	public void bloom() {
		// 상위에 있는 추상메서드 재정의하는 곳
		System.out.println("보라색 제비꽃들이 들판에 가득하다.");
	}
}





