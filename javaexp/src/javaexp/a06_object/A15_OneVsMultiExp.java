package javaexp.a06_object;

import java.util.ArrayList;

public class A15_OneVsMultiExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		SchClass sc = new SchClass("1-1");
		sc.addStu(new SchStudent("홍길동"));
		sc.addStu(new SchStudent("김길동"));
		sc.addStu(new SchStudent("신길동"));
		ArrayList<SchStudent> list = new ArrayList<SchStudent>();
		list.add(new SchStudent("홍길동"));
		sc.showList();	
	}
}
// ex SchClass(반/ArrayList<SchStudent>)-, SchStudent(번호, 이름) 1:다 관게를 설정하여 출력 처리하세요
class SchClass{
	private String cname;
	
	private ArrayList<SchStudent> slist;
	public SchClass(String cname) {
		this.cname = cname;
		this.slist= new ArrayList<SchStudent>();
	}
	public void addStu(SchStudent ss) {
		// 현재 데이터 크기에서 하나씩 증가 시켜 번호로 등록
		ss.setNum(slist.size()+1);
		this.slist.add(ss);
		System.out.println(ss.getName()+"학생 등록.");
	}
	public void addStuAll(ArrayList<SchStudent> alist) {
//		this.slist.addAll(alist);// 외부에서
		for(SchStudent st:alist){//내부에서
			st.setNo(slist.size())
		
			
//			this.addStu(ss); // 기존에 선언한 기능 메서드 활용
		}
		System.out.println(slist.size()+"명 등록.");
	}
	public void showList() {
		System.out.println(cname+"반의 학생 리스트");
		if(slist.size()>0) {
			for(SchStudent sst:slist) {
				System.out.println(sst.getNum()+"\t");
				System.out.println(sst.getName());
			}
		}else {
			System.out.println("등록된 학생이 없습니다");
		}
	}	
}


class SchStudent {
	private String name;
	private int num;
	public SchStudent(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}	
}
