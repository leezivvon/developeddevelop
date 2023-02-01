package a02_diexp.z07_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springweb.a05_mvc.a02_service.A01_EmpService;
import springweb.z01_vo.Emp;

@Controller
public class A01_Controller {
	@Autowired
	private A02_Service service;
	
	// main에서 출력하는 것 즉 view단이 아니라서(없어서) requestmappint은 없어도 되나봄 몰라 ㅅ비ㅏㄹ
	public void showEmpList(Emp sch) {
		System.out.println("@@ 사원 정보 조회 @@");
		for(Emp e:service.getEmpSch(sch)) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t");
			System.out.print(e.getSal()+"\t");
			System.out.print(e.getDeptno()+"\n");
		}
	}
	
	
}

