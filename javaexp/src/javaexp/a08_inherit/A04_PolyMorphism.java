package javaexp.a08_inherit;

import java.util.ArrayList;

public class A04_PolyMorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 다형성(PolyMorphism)		
		1. 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질
		    1) 부모 타입에는 모든 자식 객체가 대입 가능
		        - 자식 타입은 부모 타입으로 자동 타입 변환
		2. 자동 타입 변환(Promotion)
		    1) 형식
		        부모클래스 변수 = 자식클래스 타입
		        class Animal{}
		        class Cat extends Animal{}
		        class Bird extends Animal{}
		        
		        Cat cat = new Cat();
		        Animal ani1 = cat;
		        Animal ani2 = new Cat();
		        Animal ani3 = new Bird();
		*/
		// 상위 하나의 부모 객체를 여러가지 형태의 자식 객체로 생성 가능
		Larba l1 = new Dron();
		l1.attack(); // 다형성에 의해서 첫번째 라바는 Dron으로 변형 되었기에 Dron에서 정의된 attack()을 처리
		Larba l2 = new Zerggling();
		l2.attack();
		
		//ex
		// 풀이
		Animal a1 = new Cat();
		a1.sound();
		Animal a2 = new Dog();
		a2.sound();
		Animal a3 = new Tiger();
		a3.sound();
		
		// Animal a = new Cat();
		// 정답 1
		Animal[] arr = {new Cat(), new Dog(), new Tiger()};
		for(Animal an:arr) {
			an.sound();
		}
		// 정답2
		ArrayList<Animal> alist = new ArrayList<Animal>();
		alist.add(new Cat());
		alist.add(new Dog());
		alist.add(new Tiger());
		// 단위 객체 : 배열형 객체(동적 배열)
		for(Animal an:arr) {
			an.sound();
		}
	}
}
// ex Animal 동물종류 sound(), 하위 Cat Dog Tiger
//    다형성에 의해 객체 생성을 하고 재정의 된 sound()호출하세요
class Animal {
	private String kind;

	public Animal(String kind) {
		this.kind = kind;
	}
	public void sound() {
		System.out.print(this.kind+"의 울음소리 ");
	}
}
class Cat extends Animal{
	public Cat () {
		super("고양이");
	}
	public void sound() {
		super.sound();
		System.out.println("야옹야옹");
	}
}
class Dog extends Animal{
	public Dog () {
		super("강아지");
	}
	public void sound() {
		super.sound();
		System.out.println("멍멍");
	}
}
class Tiger extends Animal{
	public Tiger () {
		super("호랑이");
	}
	public void sound() {
		super.sound();
		System.out.println("어흥어흥");
	}
}
// starCraft 
// 프로토스  테란(사람)  저그(파충류)

class Larba{ // 애벌레 유닛
	private String kind;
	public Larba(String kind) {
		this.kind = kind;
	}
	public void attack() {
		System.out.println("전혀 공격을 하지 못 함..");
	}
	public String getKind() {
		return this.kind;
	}
}

class Dron extends Larba{
	public Dron() {
		super("드론");
	}	
	public void attack( ) {
		System.out.println(getKind()+" 약한 근접 공격을 한다");
	}
}

class Zerggling extends Larba{
	public Zerggling() {
		super("저글링");
	}	
	public void attack( ) {
		System.out.println(getKind()+" 빠른 근접 공격을 한다");
	}
}