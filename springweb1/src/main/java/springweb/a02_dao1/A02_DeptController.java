package springweb.a02_dao1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a13_database.A06_PareparedDao;
import springweb.z01_vo.Dept;

// springweb.a02_dao1.A02_DeptController <<dispatcher-servlet에 등록
@Controller
public class A02_DeptController {

	// ex) http://localhost:7080/springweb/deptList.do
	/*
	부서정보 검색
	1. 초기화면 호출
		- 요청처리 VO선언
	2. 모델데이터 dao설정
		- dname, loc null초기화
		- dao.getDeptList(sch)
	3. 모델데이터 화면출력(view단처리)
	*/
	
	private A06_PareparedDao dao;
	
	public A02_DeptController() {
		dao = new A06_PareparedDao();
	}
	
	// http://localhost:7080/springweb/deptList.do
	@RequestMapping("/deptList.do")
	public String deptList(Dept sch, Model d) {
		//초기화면 <<원래 service단에서 해야하는 것
		if(sch.getDname()==null) sch.setDname("");
// 		if(sch.getDeptno()==0) sch.setDeptno(0);
		if(sch.getLoc()==null) sch.setLoc("");
		d.addAttribute("dlist", dao.getDeptList(sch));
		
		return "WEB-INF\\views\\a02_dao01\\a02_deptList.jsp";
	}
	
	@RequestMapping("/insertDept.do")
	public String deptInsert(Dept ins, Model d) {
		dao.insertDept(ins);
		// d.addAttribute("msg", "등록완료");  //redirect하면 적용안됨 
		
		// 선언된 controller 호출 1)redirect 2)forward 
		//						<< forward하면 등록한걸 가져오게 됨, redirects는 전체 출력 
		return "redirect:/deptList.do";
		
	}
	
}
