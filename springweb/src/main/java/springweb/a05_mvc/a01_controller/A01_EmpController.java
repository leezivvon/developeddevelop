package springweb.a05_mvc.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a05_mvc.a02_service.A01_EmpService;
import springweb.z01_vo.Code;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

@Controller("empCtrl") //같은이름의 파일 잇으니까("empCtrl")
public class A01_EmpController {
	@Autowired
	private A01_EmpService service;
	
	
	
	@RequestMapping("empListMy.do")
	// http://localhost:7080/springweb/empListMy.do
//	public String empList(Emp sch, Model d) { >>>> 디폴트emp.  >> ${emp.ename}
	public String empList(@ModelAttribute("sch") Emp sch, Model d) { // >>>>sch. >>${sch.ename}
		d.addAttribute("empList", service.getEmpList(sch));
		return "\\WEB-INF\\views\\a05_mvc\\a01_empList.jsp";
	}
	
	
	// 회원어쩌고 (관리)
	@ModelAttribute("deptCom")
	// deptCom  mgrCom  jobCom
	public List<Dept> getDeptComb(){
		return service.getDeptComb();
	}
	@ModelAttribute("mgrCom")
	public List<Code> getMgrComb(){
		return service.getMgrComb();
	}
	@ModelAttribute("jobCom")
	public List<String> getJobComb(){
		return service.getJobComb();
	}
	
	
	
	
}
