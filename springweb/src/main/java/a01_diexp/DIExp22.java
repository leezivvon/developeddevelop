package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis.dao.A01_EmpDao;
import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpDept;
import springweb.z01_vo.EmpSalgrade;

public class DIExp22 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 컨테이너 객체 호출 처리
      String path = "a01_diexp\\di22.xml";
      AbstractApplicationContext 
      ctx = new GenericXmlApplicationContext(path);
      // DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      // A01_EmpDao
      A01_EmpDao dao = ctx.getBean("a01_EmpDao", A01_EmpDao.class);
      System.out.println("컨테이너의 객체호출:"+dao.getEmpList(new Emp("","")).size());
      System.out.println("사원의 수"+dao.empCount());
      System.out.println("최대급여:"+dao.empMaxSal());		
      System.out.println("사원명:"+dao.getEname());	
      
      //ex
      System.out.println("부서의 최고 급여: "+dao.getMaxSalByDept());
      System.out.println("최대 관리자번호: "+dao.getMaxMgr());
      System.out.println("사원명에 의한 관리자번호: "+dao.getJobByEname());
      
      
      // 다중객체
      	Emp emp01= dao.getEmpByEmpno();
		System.out.println("객체의 사원번호:"+emp01.getEmpno());	
		System.out.println("객체의 사원명:"+emp01.getEname());
		
		Emp emp02 = dao.getEmpByEname();
		System.out.println("@@ 사원명으로 가져온 사원정보 @@");
		System.out.println("사원번호:"+emp02.getEmpno());
		System.out.println("사원명:"+emp02.getEname());
		
      
		
	// 다중의 리턴값
		List<EmpDept> edList = dao.getEmpDeptList();	
		System.out.println("#사원부서정보 다중열#: "+edList.size());
		for(EmpDept ed:edList) {
			System.out.print(ed.getEname()+"\t");
			System.out.println(ed.getDname());
		}
		
		
		List<EmpSalgrade> egrade = dao.getEmpSalGrade();
		System.out.println("등급별 사원정보");
		for(EmpSalgrade eg:egrade) {
			System.out.print(eg.getEname()+"\t");
			System.out.print(eg.getSal()+"\t");
			System.out.print(eg.getGrade()+"\n");
		}
      System.out.println("종료");
      ctx.close();

      
      
   }

}