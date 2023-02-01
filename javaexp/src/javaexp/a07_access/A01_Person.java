package javaexp.a07_access;
// 1.class명 앞에 public
//    선언 시 호출하는 곳에서 접근 여부 확인
//    A01_Person p01;

public class A01_Person {
// 2. 필드는 접근제어자를 private
	private String name;
	private int age;
	private String loc;
// 3. 생성자의 접근제어자는 객체 생성시 영향을 미친다
//    p01=A01_Person();
//	    public아닐 시에는 객체 생성을 외부패키지에서는 생성을 접근을 하지못한다
	public A01_Person() {
		// TODO Auto-generated constructor stub
	}
	public A01_Person(String name, int age, String loc) {
		this.name = name;
		this.age = age;
		this.loc = loc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
