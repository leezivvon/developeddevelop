package springweb.a03_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a05_mvc.a02_service.A01_EmpService;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Person;

@Controller
public class A03_JsonViewCallCtrl {
	
	
	@GetMapping("callJson01.do")
	public String calljson01(Model d) {
		d.addAttribute("json01", new Dept(10, "인사", "서울"));
		return "pageJsonReport";
		// 컨테이너에서 객체를 json데이터로 모델데이터를 출력하게 해준다
	}
	
	// ex) callJson02.do Person객체를 json데이터로 출력하세요
	@GetMapping("callJson02.do")
	public String callJson02(Model d) {
		d.addAttribute("json02", new Person("홍길동", 25, "대전"));
		return "pageJsonReport";
	}
	
	//디비연결된사원정보불러오기
	@Autowired(required=false)
	private A01_EmpService service;
	// 사원정보
	@GetMapping("callJson03.do")
	public String callJson03(Model d) {
		d.addAttribute("empList", service.getEmpList(new Emp()));
		return "pageJsonReport";
	}
	
	
	@Autowired(required=false)
	private A01_EmpService service2;
	
	// 230130과제#6
	@RequestMapping("/getEmpAll.do")
	public String getEmpAll(Model d) {
		d.addAttribute("empList", service2.getEmpAll());
		return "pageJsonReport";
		
	}
	
}
