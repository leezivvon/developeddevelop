package a01_diexp.z08_mydb;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z08_mydb.vo.BuyInfo;
import a01_diexp.z08_mydb.vo.Dept;
import a01_diexp.z08_mydb.vo.Emp;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.EmpSalGd;
import a01_diexp.z08_mydb.vo.Salgrade;

public class A01_DIExp93 {
	//1.컨테이너 호출
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\z08_mydb\\a01_di93.xml"; //컨테이너위치
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		
		// 230125과제
		A02_ExpDao dao = ctx.getBean("a02_ExpDao", A02_ExpDao.class);
		System.out.println("컨테이너의 객체호출 "+dao);
		
		// 230125과제#2
		System.out.println("데이터 건수:"+dao.getSalgrade().size());
		for(Salgrade s : dao.getSalgrade()) {
			System.out.print(s.getGrade()+"\t");
			System.out.print(s.getHisal()+"\t");
			System.out.print(s.getLosal()+"\n");
		}
		
		// 230125과제#5-1
		System.out.println("데이터 건수:"+dao.getEmpList().size());
		for(Emp e : dao.getEmpList()) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t");
			System.out.print(e.getSal()+"\n");
		}

		// 230125과제#5-2
		System.out.println("데이터 건수:"+dao.getDeptList().size());
		for(Dept d : dao.getDeptList()) {
			System.out.print(d.getDeptno()+"\t");
			System.out.print(d.getDname()+"\t");
			System.out.print(d.getLoc()+"\n");
		}
		
		
		
		// # 객체안에 객체 1:1형태로 resultMap 설정하기
		System.out.println("데이터 건수:"+dao.getEmpDeptList().size());
		for(EmpDeptCom com:dao.getEmpDeptList()) {
			System.out.print(com.getEmp().getEname()+"\t");
			System.out.print(com.getDept().getDname()+"\n");
		}
		// ex) dept와 salgrade를 join하여 복합 EmpSalGd VO를 만들어 처리
		System.out.println("급여 등급 정보 건수:"+dao.getEmpSalgradeList().size());
		for(EmpSalGd com:dao.getEmpSalgradeList()) {
			System.out.print(com.getEmp().getEname()+"\t");
			System.out.print(com.getEmp().getSal()+"\t");
			System.out.print(com.getSalgrade().getGrade()+"\n");
		}
		
		
		
		// # 단일 매개변수 입력하기
		System.out.println("#사원검색#");
		Emp emp=dao.getEmp(7499);
		System.out.println("사원명:"+emp.getEmpno());	
		
		// # 다중 매개변수(객체) 입력하기
		System.out.println("#사원등록#");
		//dao.insertEmp(new Emp(0, "정길동", "과장", 7780, null, 5000, 1000, 10));
		
		// 삭제
		//dao.deleteEmp(1001);
		
		
		
		//230126과제
		List<BuyInfo> blist= dao.getBuyInfo();	
		System.out.println("구매건수:"+blist.size());
		for(BuyInfo bi:blist) {
			System.out.print(bi.getMember().getName()+"\t");
			System.out.print(bi.getProduct().getName()+"\t");
			System.out.println(bi.getProduct().getBcnt());
		}
		
		
		System.out.println("종료");
		ctx.close();
		
	}

}
