package springweb.a02_dao1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a13_database.A02_EmpDao;
import springweb.z01_vo.Code;
import springweb.z01_vo.Emp;
// springweb/a02_dao1.A01_EmpController

@Controller
public class A01_EmpController {
	
	
	private A02_EmpDao dao;
	
	public A01_EmpController() {
		dao = new A02_EmpDao();
	}
	@ModelAttribute("mgrCode")
	public List<Code> getMgrInf(){
		return dao.getMgrInf();
	}
	@ModelAttribute("deptCode")
	public List<Code> getDeptInf(){
		return dao.getDeptInf();
	}
	/*
	@ModelAttribute("sch") 추가
	// ModelAttribute("요청값의 모델명지정")
	*/ 
	// http://localhost:7080/springweb/empList.do
	@RequestMapping("/empList.do")
	public String empList(@ModelAttribute("sch") Emp sch, Model d) {
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		if(sch.getToSal()==0) sch.setToSal(9999);
		d.addAttribute("empList", dao.getEmpSch(sch));
		
		return "WEB-INF\\views\\a02_dao01\\a01_empList.jsp";
	}
	
	//view단에 가서
	//<input value="${emp.ename}">  ==> <input value="${sch.ename}">
	
	
	/*
	기본 Emp 자동으로 emp
	//http://localhost:7080/springweb/empList.do
	@RequestMapping("/empList.do")
	public String empList(Emp sch, Model d) {
		//초기화면 <<원래 service단에서 해야하는 것
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		if(sch.getToSal()==0) sch.setToSal(9999);
		d.addAttribute("empList", dao.getEmpSch(sch));
		
		return "WEB-INF\\views\\a02_dao01\\a01_empList.jsp";
	}
	*/
	
	
	//사원정보 등록처리
	/*
	1. 등록화면 구성
	2. 컨트롤러 선언
	*/
	// 1)redirect 방식 << redirect는 전체 출력 
	@RequestMapping("/insertEmp.do")
	public String empInsert(Emp ins, Model d) {
		dao.insertEmp(ins);
		// 선언되어있는 상단의 controller를 다시 호출 1)redirect 2)forward 
		return "redirect:/empList.do";
	}
	
	/*
	// 2)forward방식 << forward하면 등록한걸 가져오게 됨 //여기서는 foward를 사용하지 않는게 좋음
	@RequestMapping("/insertEmp.do")
	public String empInsert(Emp ins, Model d) {
		dao.insertEmp(ins);
		// 선언되어있는 상단의 controller를 다시 호출 1)redirect 2)forward 
		d.addAttribute("msg", "등록완료");
		return "forward:/empList.do";
	}
	*/
	
	//230113-10
	//getSalGradeInf
	@ModelAttribute("salGradeCode")
	public List<Code> getSalGradeInf(){
		return dao.getSalGradeInf();
	}


	
	
}
