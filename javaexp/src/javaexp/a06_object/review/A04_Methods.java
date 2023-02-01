package javaexp.a06_object.review;

public class A04_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c01 = new Calculator(2,5);// 생성자에서 받은 값을 통해서

	}

}
/*
# 객체에서 생성자와 메서드 처리
1. 생성자는 주로 객체가 생성될 때 초기값을 주로 설정한다
2. 메서드는 변경되는 필드값을 처리할 때 활용된다
*/

class Calculator{
	int num01;
	int num02;
	public Claculator(int num01, int num02) {
		super();
		this.num01 = num01;
		this.num02 = num02;
	}
	int plus () {
		return this.num01+this.num02;
	}
	int minus () {
		return this.num01-this.num02;
	}
	int multi () {
		return this.num01*this.num02;
	}
	int divide () {
		return this.num01/this.num02;
	}
	
	
	public Claculator() {
		super();
		// TODO Auto-generated constructor stub
	}
}
