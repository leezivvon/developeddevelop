package javaexp.a06_object;

import java.util.ArrayList;

public class A14_OneVsMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShoppingMall sm = new ShoppingMall("행복");
		sm.showAllList();
		
		sm.regdateMember(new Member("himan", "홍길동", 1000));
		sm.regdateMember(new Member("higirl", "홍리나", 3000));
		sm.showAllList();
		
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("goodMan","이철수",5000));
		list.add(new Member("badGirl","김현지",10000));
		sm.regMemAll(list);
		sm.showAllList();

	}
}
class ShoppingMall{
	private String name;
	private ArrayList<Member> mlist;
	public ShoppingMall(String name) {
		this.name = name;
		//ArrayList 객체 생성
		this.mlist = new ArrayList<Member>();
	}
	// 하나씩 멤버를 추가하는 메서드
	public void regdateMember(Member m) {
		this.mlist.add(m);
		System.out.println(m.getId()+"회원 추가되었습니다");
	}
	public void regMemAll(ArrayList<Member> list) {
//		this.mlist = mlist; 전체 데이터 덮어씌우기
		this.mlist.addAll(list);  // 기존에서 list 추가
		System.out.println(list.size()+"명 회원 추가");
	}
	public void showAllList( ) {
		System.out.println("# "+this.name +"쇼핑몰 회원 #");
		if(this.mlist.size()>0) {
			for(Member m: this.mlist) {
				System.out.print(m.getId()+"\t");
				System.out.print(m.getName()+"\t");
				System.out.print(m.getPoint()+"\n");
			}
		}else {
			System.out.println("회원 등록 준비 중");
		}
	}	
}

class Member{
	private String id;
	private String name;
	private int point;
	public Member(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
/*
# 1대 다 관계 객체 활용
1. 하나의 객체안에 여러개의 객체들을 사용할 수 있는 형태의 데이터 구조 처리를 말한다
2. 실무적인 예
    1) 쇼핑몰에서 여러회원의 관리
    2) 쇼핑몰에서 여러 물건 판매
    3) 마트 안에서 여러 개 물건 판매
    4) 컴퓨터 안에서 여러 개 부품
    5) 하나의 클래스(1/1반)안에서 여러명의 학생

3. 처리 순서
    1) 다중의 포함될 객체의 단일 유형의 클래스 선언(포함될 클래스)
       -필드
       -생성자
       -메서드(get,set...)
       ex) 회원들 ==> 단일 회원 클래스 정의
       
    2) 포함할 클래스 선언
       ex) 회원관리 쇼핑몰
        1) 필드 - 고유 피드  ex) 쇼핑몰의 이름, 주소 등 쇼핑몰 기본 정보들
        2) 필드 - 동적 배열 형태의 클래스 선언
                 ArrayList<Member> mlist
                 ex) 쇼핑몰에 포함될 다중의 데이터요소 : 회원들, 물품...
        3) 생성자 - 고유필드 초기화, 동적배열 형태 초기화
                 ex) this.name = name;
                     this.mlist = new ArrayList<Member>();
                     담을 동적배열을 초기화하여 객체로 생성
       -----------------------------------------------------메모리 설정-------------------              
        4) 추가등록 메서드
           - 하나씩 추가
               public void regMember(Member mem){
                  this.mlist.add(mem);
                  필드로 선언한  ArrayList에 하나씩 담기 처리   
               ex) sh.regMember(new Member("himan","홍길동",1000));  
                   sh.regMember(new Member("goodman","마길동",1000));  
                   sh.regMember(new Member("higirl","오길동",1000));    
           
           - 다중으로 추가 //뭉텅이로 담을 때
               public void regMemberAll(ArrayList<Member> mlist){
                this.mlist.allAdd(mlist);         
                }
                ex) 
                ArrayList<Member> addM = new ArrayList<Member>();
                addM.add(new Member("obMAn", "신현식", 20000));
                addM.add(new Member("whiteMAn", "김철수", 20000));
                addM.add(new Member("goodMAn", "이영희", 20000));
                sh.regMemberAll( addM ); 
                
        5) 정보 출력 메서드
            - 기본 정보 출력 : 쇼핑몰 이름 @@@
            - ArrayList 출력
                 if(mlist.size()>0) {
                    등록된 회원은 @@@명이고 리스트 정보는
                    for(Member m:mlist){ // 생성자가 생성되어잇기 때무에 에러는 안나지만 그래도 더 효과적
                    sysout    m.getName() m.getId() m.getPoint()
                    } 
                }else{
                    sysout 등록된 회원이 없습니다
                }


*/

/*
+ 추가 리뷰\
1:다   : DB에서 데이처를 가져와서 한 화면에 출력하거나 사용할 때 주로 사용되는 형식
		하나의 객체 안에서 다중으로 여러개의 객체를 사용하는 것을 말한다
		# 유형
		1) 하나의 객체 안에서 하나타입의 여러 객체
			ex) 마트에 물건리스트
		2) 하나의 객체안에서 여러 개의 객체들
			ex) 쇼핑몰 안에 구매물품리스트와 회원리스트
		3) **하나의 객체 안에서 추상클래스로 정의된 여러개의 객체를 할당할 수 있게 선언
			ex) 컴퓨터 객체 안에 부품리스트를 추상클래스를 상속받은 하위 실제부품을 가지는 형태로 
				다형성이 처리된 내용을 할당하는 객체
			class Computer{
				private String comp;
				private List<Part> parts;
			}
			abstract class Part{
				String kind;
				abstract void showInfo();
			}
			class Cpu extends Part{
				void showInfo(){
					kind+"는 성능은 코어가 @@개이고 처리 속도가 @@이다"
				}
			}
			class Ram extends Part{
				void showInfo(){
					kind+"는 @@ 메모리를 갖고 있고 전송 bus속도는 @@이다"
				}
			}
*/






