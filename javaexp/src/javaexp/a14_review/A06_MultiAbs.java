package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A06_MultiAbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Robot에 다양한 형태로 할당 및 attack()호출
//		List<Robot> rlist = new ArrayList<Robot>();
//		rlist.add(new Mz("로켓포 발사"));
//		rlist.add(new Tv("발차기"));
//		// private String way; 가 선언되지 않았다면
//		// rlist.add(new Mz()); << 이렇게만하기
//
//		for(Robot r : rlist ) {
//			r.attack();
//		}
		
		
		RobotWar rw = new RobotWar("로봇 1차 대전");
		rw.attendRobot(new Mz("로켓포 발사"));
		rw.attendRobot(new Tv("발차기"));
		
		rw.showAttendlist();
		
		
		
		
		
		
	}
}
// class RobotWar
// 		필드로 로봇1차대전 List<Robot>
//		메서드 attendRobot()
//		메서드 showAttendlist
// ex) Robot 추상 필드 종류, 클래스 attack() 재정의 메서드 공격방법
// 		상속받은 하위 클래스 Mz 로켓포 발사
// 		상속받은 하위 클래스 Tv 발차기 공격
// 		상속받은 하위 클래스 Dagan 변신 공격을 하다
class RobotWar{
	private String wname;
	List<Robot> rb;
	public RobotWar(String wname) {
		this.wname = wname;
		rb = new ArrayList<Robot>();
	}
	public void attendRobot(Robot robot) {
		System.out.println(wname+"에 "+robot.getHero()+"가 첨전합니다");
		rb.add(robot);
		System.out.println("참석 로봇의 수: "+rb.size());
	}
	public void showAttendlist() {
		System.out.println(wname+" 참전 로봇의 공격정보");
		if(rb.size()>0) {
			for(Robot rr : rb) {
				rr.attack();
			}
		}else {
			System.out.println("모든 로봇이 참전을 거부했습니다");
			System.out.println(wname+"은 종료됩니다_삐리릭");
		}
	}
}

abstract class Robot{
	private String hero;
	private String way;
	public Robot(String hero, String way) {
		this.hero = hero;
		this.way = way;
	}
	public String getHero() {
		return hero;
	}
	public String getWay() {
		return way;
	}
	
	public abstract void attack();// 재정의할 내용
}

class Mz extends Robot{
	public Mz(String way) {
		super("마징가Z", way);
	}
	@Override
	public void attack() {
		System.out.println(getHero()+"가 "+getWay()+" 공격을 한다");
	}
}
class Tv extends Robot{
	public Tv(String way) {
		super("태권V", way);
	}
	@Override
	public void attack() {
		System.out.println(getHero()+"가 "+getWay()+" 공격을 한다");
	}
}


