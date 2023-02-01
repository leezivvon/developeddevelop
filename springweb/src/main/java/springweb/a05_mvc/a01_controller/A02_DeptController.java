package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A02_DeptService;
import springweb.z01_vo.Dept;

@Controller("mydeptCtrl") //exisiting파일 에러나면 ("mydeptCtrl")추가
public class A02_DeptController {
	// 서비스단 연결
	@Autowired(required=false)
	private A02_DeptService service;
	
	// 메서드선언, view단 호출
	//http://localhost:7080/springweb/myDeptList.do
	@RequestMapping("myDeptList.do")
	public String myDeptList(@ModelAttribute("sch") Dept sch, Model d) {
		//controller단 model데이터 설정
		d.addAttribute("dlist", service.getDeptList(sch));
		return "WEB-INF\\views\\a05_mvc\\a02_deptList.jsp";
	}
	
	
	
	@GetMapping("deptAjaxInit.do")
	public String deptAjaxInit() {
		return "WEB-INF\\views\\a05_mvc\\a04_ajaxList.jsp";
	}
	
	
	// Get/Post ==> RequestMapping(둘다 가능)
	//http://localhost:7080/springweb/deptAjax.do
	@PostMapping("deptAjax.do")
	public String deptAjaxInitData(Dept sch, Model d) {
		d.addAttribute("dlist", service.getDeptList(sch));
		return "pageJsonReport";
	}
	
	
	// http://localhost:7080/springweb/getDept.do?deptno=10
	@GetMapping("getDept.do")
	public String getDept(@RequestParam("deptno") int deptno, Model d) {
		d.addAttribute("dept",service.getDept(deptno));
		return "pageJsonReport";
	}
	
	
	
	
	/* 230131과제#4 */
	
	
}