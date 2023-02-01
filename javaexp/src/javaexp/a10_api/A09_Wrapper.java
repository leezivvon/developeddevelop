package javaexp.a10_api;

import java.util.ArrayList;

public class A09_Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# Wrapper 객체란?
		1. 기본 타입(byte, char, short, int, long, float, double, boolean)값을 내부에 두고 포장하는 객체를 말한다
		   객체로 전환되는 순간 여러가지 기능 메서드가 지원되기에 데이터변환이나 기능처리를 할 수 있기 때문이다			
		*/
		int num01 =25;
		// 기본 유형의 데이터를 Wrapper객체로 변환 처리
		Integer num01Obj = new Integer(num01); // 조만간에 사라질 거니까 사용자제 부탁;
		// 객체의 속성(필드/메서드)를 통해서 여러가지 기능을 처리할 수 있댜
		System.out.println(num01Obj.byteValue());
		System.out.println(num01Obj.hashCode());
		System.out.println(num01Obj.MAX_VALUE);
		
		
		/*
		 * 25 ==> ( 25 )
		   포장하는 순간 여러 형태로 변환할 수 있는 객체(heap 메모리) // Boxing
		 * ( 25 ) ==> 25
		   포장을 벗겨내고 순수한 데이터 자체로 저장(stack영역만 메모리) // UnBoxing
		  
		2. Wrapper class(포장 클래스)
			대부분은 기본유형타입에서 대문자로 시작하여 선언한다
			byte ==> Byte
			short ==> Short
			double ==> Double
			단, 아래 두가지만 긴문자형식으로 Wrapper클래스를 선언한다
			char ==> Character, int ==> Integer
		3. 박싱(Boxing)과 언박싱(Unboxing)
			기본데이터 <==> Wrapper
			1) 박싱 : 기본 타입의 값을 포장(Wrapper)객체로 만드는 과정을 말한다
				Integer obj1 = Integer.valueOf(1000);
				Byte obj2 = Byte.valueOf(25);
				cd) 클래스며.메서드() : static 메서드로 클래스 종속 메서드
			2) 언박싱 : 포장 객체에서 기본 타입의 값을 얻어내는 과정
				byte value01 = obj2.byteValue();
				int value02 = obj1.intValue();
		4. autoBoxing, autoUnboxing
			기본데이터 <==> Wrapper
			위 기본 박싱과 언박싱을 거치지 않고 바로 할당하는 것을 jvm에서 내부적으로 지원한다
			1) autoBoxing
				Integer obj1 = 30;
				Double 0bj2 = 30.25;
			2) autoUnboxing
				int num01 = obj1;
				double obj2 = obj2;
		*/
		// Boxing 처리
		Byte obj01 = Byte.valueOf("25");
		Integer obj02 = Integer.valueOf(30);
		Double obj03 = Double.valueOf("30.7");
		// 숫자형 문자열 또는 기본 데이터 유형이 Boxing에 의해 Wrapper클래스로 처리되었다
		System.out.println("박싱된 객체: "+obj01);
		System.out.println("박싱된 객체: "+obj02);
		System.out.println("박싱된 객체: "+obj03);
		
		// autoboxing
		// 기본데이터 유형을 바로 할당할 때 autoboxing이 일어나서 객체로 사용된다
		Integer obj04 = 1000;
		Double obj05 = 35.24;
		ArrayList<Integer> iList = new ArrayList<Integer>();
		iList.add(new Integer(25)); //박싱
		iList.add(Integer.valueOf(30)); //박싱
		iList.add(50); // 오토박싱
		iList.add(40);
		Integer i10 = iList.get(2);
		int num10 = i10; // 오토 언박싱
		int num11 = i10+10; // 오토언박싱
		int num12 = iList.get(2)+10; // 오토언박싱
		
		
		// ex) char, boolean, float 데이터를 boxing/autoboxing에 의해 Wrapper 클래스로 할당하여 출력하세요
		//char
		Character obj06 = Character.valueOf('얍'); // boxing
		Character obj07 = '헉'; //autoboxing
		//boolean
		Boolean obj08 = Boolean.valueOf(5==2+3);
		Boolean obj09 = 6==2+3 ;
		//float
		float obj10 = Float.valueOf(2.7f);
		float obj11 = 3.0f;
		
		// 정답
		//boxing
		char c01 = 'A';
		Character obj6 = new Character(c01);
		Boolean obj7 = Boolean.valueOf("true");
		//autoboxing
		Float obj8 = 35.5F;
		System.out.println("obj6: "+obj6);
		System.out.println("obj7: "+obj7);
		System.out.println("obj8: "+obj8);
		//unboxing 처리
		float value10 = obj8.floatValue();
		boolean value11 = obj7.booleanValue();
		//autounboxing 처리
		char value12 =obj6;
		System.out.println("value10: "+value10);
		System.out.println("value11: "+value11);
		System.out.println("value12: "+value12);
		
		//ex) args의 값으로 정수, boolean, 실수값을 입력후 Boxing으로 Integer, Boolean, Double에 할당하고 출려하세요
		//    args Run As>> Coverage Configuration
		
		Integer obj12 = Integer.valueOf(args[0]);
		Boolean obj13 = Boolean.valueOf(args[1]);
		Double obj14 = Double.valueOf(args[2]);
		System.out.println("args[0]: "+obj12);
		System.out.println("args[1]: "+obj13);
		System.out.println("args[2]: "+obj14);
		
		int num13 = obj12;
		System.out.println("auto unboxing: "+num13);
		System.out.println("boxing + auto unboxing: "+(Double.valueOf(args[2])+1.27)); 
		// 언박싱하고 연산까지
		// Double.valueOf(args[2]) ==> Double Wrapper 객체만들어짐
		// +1.27과 연산하려면 기본객체로 autounboxing ==> 
		// double(3.14) +1.27 ==> 4.41

		
	}

}
