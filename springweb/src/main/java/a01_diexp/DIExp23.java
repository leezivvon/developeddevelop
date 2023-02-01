package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis.dao.A01_EmpDao;
import a01_diexp.mybatis.dao.A02_ExpDao;
import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpDept;
import springweb.z01_vo.EmpSalgrade;

public class DIExp23 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 컨테이너 객체 호출 처리
      String path = "a01_diexp\\di23.xml";
      AbstractApplicationContext 
      ctx = new GenericXmlApplicationContext(path);
      A02_ExpDao dao = ctx.getBean("A02_ExpDao", A02_ExpDao.class);
      List<Emp> empList = dao.getEmpData();
      System.out.println("데이터건수:"+empList.size());
      for(Emp e:empList) {
    	  System.out.print(e.getEmpno()+"\t");
    	  System.out.print(e.getEname()+"\t");
    	  System.out.print(e.getESal()+"\n");
      }
      
      System.out.println("종료");
      ctx.close();

      
      
   }

}