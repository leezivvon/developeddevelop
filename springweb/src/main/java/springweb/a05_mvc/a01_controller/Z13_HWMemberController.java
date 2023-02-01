package springweb.a05_mvc.a01_controller;

import java.util.List;

// 230127과제

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.Z13_HWMemberService;
import springweb.z01_vo.Member;

@Controller("memCtrl")
public class Z13_HWMemberController {
	
	//service단 호출
	@Autowired(required=false)
	private Z13_HWMemberService service;
	
	/* 230127#2,3 */
	//@RequestMapping이 부여된 메서드들은 view를 생성하는역할, 즉 Controller메서드 = 메서드선언해서 view단 호출
	//http://localhost:7080/springweb/hwMemberList.do
	@RequestMapping("hwMemberList.do")
	public String hwMemberList(@ModelAttribute("sch") Member sch, Model d) {
		// 메서드의 매개변수:d.addAttribute("모델명", 모델객체)
		d.addAttribute("memList", service.getHWMemList(sch)); 
		return "WEB-INF\\views\\z01_homework\\a13_hw2memberList.jsp";
	}
	
	
	/* 230127#7 */
	@ModelAttribute("memAuthCom")
	public List<String> hwMemAuthComb(){
		return service.hwMemAuthComb();
	}
	
	
	
	
	// 230127#단일데이터검색.....?시발 무어ㅑ
	@GetMapping("/memberMy.do")
	public String getMember(@RequestParam("id") String id, Model d) {
		// 모달창에 데이터를 로딩
		d.addAttribute("mem", service.getMember(id));
		// 모달창 뒤에 전체조회된 내용 리스트를 위해 처리
		d.addAttribute("memList", service.getHWMemList(new Member())); 
		return "WEB-INF\\views\\z01_homework\\a13_hw2memberList.jsp";
	}
	

	/* 230127#4 */
	@RequestMapping("/hwUdtmem")
	public String hwUdtmem(Member upt, Model d) {
		service.hwUptMem(upt);
		d.addAttribute("mem", service.getMember(upt.getId()));
		d.addAttribute("memList", service.getHWMemList(new Member())); 
		return "WEB-INF\\views\\z01_homework\\a13_hw2memberList.jsp";
	}
	
	/* 230127#5 */
	@RequestMapping("/hwDelMem")
	public String hwDelMem(@RequestParam("id") String id) {
		service.hwDelMem(id);
		return "WEB-INF\\views\\z01_homework\\a13_hw2memberList.jsp";
	}
	
	
	/* 230130#2 */
	@PostMapping("insertMember.do")
	public String insertMember(Member ins, Model d){
		// 항상 프로그래밍을 조건문/반복문을 처리하기 전에 코드 순서를 먼저 잘 위치시켜야 한다
		service.insertMember(ins);
		d.addAttribute("mem", service.getMember(ins.getId()));
		d.addAttribute("memList", service.getHWMemList(new Member()));
		return "WEB-INF\\views\\z01_homework\\a13_hw2memberList.jsp";
	}
	
	
	
	
	// memberMyAjax.do?id=banana02
	/* 230131과제#2 json데이터로 */
	@GetMapping("/memberMyAjax.do")
	public String memberMyAjax(@RequestParam("id") String id, Model d) {
		d.addAttribute("mem", service.getMember(id));		
		return "pageJsonReport";
	}
}
