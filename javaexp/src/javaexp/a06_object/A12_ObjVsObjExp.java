package javaexp.a06_object;

public class A12_ObjVsObjExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student stu = new Student("율리아");
		stu.congratu();

		stu.child(new ElementSch("여울초등학교", 2013));
		stu.congratu();
		
		// 정답
		Studentt st = new Studentt("이철수");
		st.showInfo();
		
//		System.out.println(st);// toString() 선언 메서드 호출
		
		st.setEleSchool(new ElementSchl("홍대부속초등학교",2008));
		st.showInfo();
	}
}
// ex Student(이름, ElementSch), ElementSch(학교명, 졸업연도)
/*
1) ElementSch - 필드와 기본 정보 출력
1) Student - 이름, ElementSCh, 생성자, ElementSCh추가메서드, 출려메서드
*/



class ElementSch {
	private String schName;
	private int graduY;
	public ElementSch(String schName, int graduY) {
		this.schName = schName;
		this.graduY = graduY;
	}
	public void showInfo() {
		System.out.println("# 축 졸업 #");
		System.out.println("학교이름: "+schName);
		System.out.println("졸업연도: "+graduY);
	}	
}
class Student {
	private String name;
	private ElementSch esch;
	public Student(String name) {
		this.name = name;
	}
	public void child(ElementSch esch) {
		this.esch=esch;
	}
	public void congratu() {
		System.out.println("# 졸업식을 시작합니다 #");
		if (this.esch != null) {
			this.esch.showInfo();
			System.out.println("졸업하는 학생이름: "+this.name);
		}else {
			System.out.println("!귀빈 여러분 모두 자리에 착석해주십시오!");
		}
	}
}

// 정답
class ElementSchl{
	private String sname;
	private int gradeYear;
	public ElementSchl(String sname, int gradeYear) {
		this.sname = sname;
		this.gradeYear = gradeYear;
	}
	@Override
	public String toString() {
		return "초등학교 [학교명=" + sname + ", 졸업연도=" + gradeYear + "년]";
	}
}
class Studentt{
	private String name;
	private ElementSchl eleSchool;
	public Studentt(String name) {
		this.name = name;
	}
	public void setEleSchool(ElementSchl eleSchool) {
		this.eleSchool = eleSchool;
	}
	public void showInfo() {
		System.out.println("## "+name+"의 초등학교 ##");
		if(eleSchool==null) {
			System.out.println("초등학교 정보가 없습니다");
		}else {
			System.out.println(this.eleSchool);
		}
	}
	
}