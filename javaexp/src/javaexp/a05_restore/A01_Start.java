package javaexp.a05_restore;

public class A01_Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		# 방에 물건을 저장할  때, 효율적인 방법은
		1. 작은 물건, 큰물건 적재
		2. 하나의 공간(작은 메모리) - stack 영역
		   1) 작은 물건 - primitive 데이터 타입(크기가 일정)
		   2) 큰물건들이 있는 위치 정리 (해당 heap영역의 주소를 저장)
		       
		3. 두번째 공간(큰 메모리-방1, 방2...) - heap영역
		   1) 실제 큰 물건들이 있는 공간 
		      - 객체형 데이터 - 배열, 내장 객체, 사용자 정의객체(크기가 일정치 않음)

		# 자바의 데이터 타입 분류
		1. 기본 타입
		2. 참조 타입
		 - 자바는 정수/실수/boolean형을 바로 선언하여 사용하는 기본형 타입과, 
		   객체형 타입(배열/열거/클래스/인터페이스)에 의해 특정한 메모리를 참조하는 참조타입으로 크게 분류할 수 있다
		# 변수의 메모리 사용
		1. 기본 타입 변수 - 실제 값을 변수 안에 저장
		   cf) stack영역에 선언하고 실제 데이터를 할당 
		2. 참조 타입 변수 - 주소를 통해 객체 참조		
		   cf) heap영역에 저장하고 이 heap영역의 주소값을 stack영역에 저장한다.	
				*/
		

	int num01 = 15; //stack영역에 15할당
	int num02 = 20; // ex) 바나나가 있습니다. 바나나를 위치 시킴
	int[] arr01 = {10}; // heap영역의 주소를 stack영역에 arr01에 해당 . 자동차가 있는 위치 주차구역1 12자리
	int[] arr02 = {10}; // ex) 자동차가 있습니다. 자동차가 있는 위치를 할당 // 데이터는 같지만 주소값은 다르게
    System.out.println(num01 + ":" + num02);
    // 1. 동일한 데이터이므르 동일한 데이터 할당 
    System.out.println(arr01 + ":" + arr02);// stack 영역의 주소값이 출력 
	// 2. 동일한 데이터이지만 heap영역의 주소값이 다르기에 다른 데이터가 나타난다.
    int num03 = num01; // num01의 데이터를 num03에 할당
    System.out.println(num01 +":"+num03);
    num03 = 20; // 직접 다른 데이터를 할당
    System.out.println(num01 + ":" + num03); // num01, num03은 실제 데이터를 직접 할당
    
    //객체의 경우
    int[] arr03 = arr01;  // 메모리의 주소를 할당하기 
    // ex) 같은 위치에 있는, 같은 주소의 집에 홍길동(아버지)의 집, 이영자(어머니)의 집
    // 자동차3이 있습니다. 여기에 자동차가 있습니다라고 적힌 곳의 위치 정보를 복사해서 할당
    // 이 정보(주차구역1 12자리) 자동차3에 할당
    System.out.println(arr03+":"+arr01);
    System.out.println(arr03[0]+":"+arr01[0]);  
    arr03[0] = 20; // 해당 위치에 있는 자동차(자동차1 자동차3)에 사과 1박스를 트렁크에 할당
    System.out.println(arr03[0]+":"+arr01[0]); 
    // 같은 주소에 있는 데이터를 이름만 달리하고 호출하기 때문에 데이터를 동일하게 가지고 있다

    
    
    // 비교연산자의 비교
    // 기본 유형의 비교는 할당된 실제 데이터를 비교
    // *(자바)데이터의 비교 연산자==는 stack 영역의 데이터를 비교하는 것이다.
    // 1. 기본데이터 유형 - 실제 데이터를 확인해서 true/false
    // 2. 객체 유형 - heap영역의 주소가 같은지 여부를 확인
    System.out.println("#기본 유형 데이터#");
    System.out.println("num01 == num02 : "+(num01 == num02));
    System.out.println("num02 == num03 : "+(num02 == num03));

    System.out.println("#객체(배열) 비교#");
    System.out.println("arr01 == arr02 : "+(arr01 == arr02));
    System.out.println("arr01 == arr03 : "+(arr01 == arr03));
    
    // ex1) 나이1 나이2 나이3 정수형으로 선언하고 
    //      나이1과 나이2에 각각 25를 할당하고 나이3은 나이1의 데이터를 할당하여 각각의 데이터를 비교하세요
    // ex2) int train[]={3}을 3개 train1, train2 선언 후 
    //      train3을 train1에서 할당한 후 train1에 데이터를 변경 후, train3의 데이터를 확인하세요
    
    // 풀이
    //1
    int age1 = 25;
    int age2 = 25;
    int age3 = age1;
    System.out.println("나이1: "+age1+"  나이2:"+age2+"  나이3: "+age3);
    
    // 2
//    int train1[]= {3};
//    int train2[]= {3};
//    int train3[]= train1[];
//    train1[]= {5};
//    System.out.println("train3[]: " + train3[]);    
//    
    // 정답
    // 1
    
    int age01, age02, age03;
    age01 = age02= 25;
    age03 = age01;
    System.out.println(age01); // 출력값 25
    System.out.println(age02); // 출력값 25
    System.out.println(age03); // 출력값 25
    age03=30;
    System.out.println(age01); // 출력값 25
    System.out.println(age02); // 출력값 25
    System.out.println(age03); // 출력값 30
    
    
    //2
    int[] train01, train02, train03;
    train01 = new int[]{3,3,2};
    train02 = new int[]{3,3,2};
    train03 = train01;
    System.out.println(train01); // 주소값 출력 [I@28a418fc 같
    System.out.println(train02); // 주소값 출력 [I@5305068a
    System.out.println(train03); // 주소값 출력 [I@28a418fc 같
    train03[0]=10;
    System.out.println(train01[0]); //10
    System.out.println(train02[0]); //3
    System.out.println(train03[0]); //10

    
    
	}

}
