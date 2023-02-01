package springweb.a02_dao1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a13_database.A06_PareparedDao;
import springweb.z01_vo.Count;
import springweb.z01_vo.Member;
import springweb.z01_vo.Player;


//  springweb.a02_dao1.Z03_HWController
@Controller
public class Z03_HWController {

	
	// 2-1 
	// http://localhost:7080/springweb/hwcount.do
	@RequestMapping("/hwcount.do")
	public String callCount(Count ct) {
		if(ct.getCount()>=0) {
			ct.setCount(ct.getCount()+1);
		}
		return "WEB-INF\\views\\z01_homework\\a03_hw1count.jsp";
	}
	//reqeustParam으로 해도 됨
	/*
	//정답
	
	1. 요청값 cnt ==> VO : Counter //int cnt
	2. controller 로직 처리
		if(cntOb.getCnt()!=0){
			cntOb.setCnt(cntOb.getCnt()+1);
		}
	3. 화면단
		<input type="hidden" name="cnt" value="${counter.cnt}">
		<button>현재:${counter.cnt} 다음카운트up</button>
		
		
	// 초기값때문에 get/post방식 나눠서	
	VO : Counter //int cnt
		
	@GetMapping("/count.do")
	public String count(Counter cntOb) {
		return "WEB-INF\\views\\z01_homework\\a03_hw1count.jsp";
	}	
	
	@PostMapping("/count.do")
	public String count(Counter cntOb) {
		cntOb.setCnt(cntOb.getCnt()+1);
		return "WEB-INF\\views\\z01_homework\\a03_hw1count.jsp";
	}
		
	*/
	
	// 2-2
	// http://localhost:7080/springweb/hwbaseball.do
	/*
	@RequestMapping("/hwbaseball.do")
	public String record(Player p, Model d) {
		double ratio = 0.0;
		if(p.getHits()>0 && p.getAnta()>0) {
			ratio = (int)(p.getAnta())/(int)(p.getHits());
		}
		d.addAttribute("ratio", ratio);
		
		return "WEB-INF\\views\\z01_homework\\a03_hw2ratio.jsp";
	}
	
	//정답
	
	1. 요청값 VO 
		Player pname, anta, hits, hitRatio
	2. 모델데이터 처리
		if(p.getName()!=null){
			p.setHitRatio(hit/(double)hseat);
		}
	3. 화면단
		<input name="pname" value="${player.pname}">
		<input name="anta" value="${player.anta}">
		<input name="hits" value="${player.hits}">
		타율 ${player.hitRatio}
		
	// 정답	
	*/
	@RequestMapping("/hwbaseball.do")
	public String record(Player p) {
		//초기화면 구분
		if(p.getPname()!=null) {
			p.setHitRatio(p.getHits()/p.getAnta());
		}
		
		return "WEB-INF\\views\\z01_homework\\a03_hw2ratio.jsp";
	}
	
	
	// 4
	private A06_PareparedDao dao;
	public Z03_HWController() {
		dao = new A06_PareparedDao();
	}
	
	// http://localhost:7080/springweb/memList.do
	@RequestMapping("/memList.do")
	public String memList(Member sch, Model d) {
		//초기화면 <<원래 service단에서 해야하는 것
		if(sch.getName()==null) sch.setName("");
		if(sch.getAuth()==null) sch.setAuth("");
		d.addAttribute("mlist", dao.getMemberList(sch));
		
		return "WEB-INF\\views\\z01_homework\\a03_hw3memList.jsp";
	}
	//5
	@RequestMapping("/insertMem.do")
	public String memInsert(Member ins) {
		dao.insertMember(ins);
		return "redirect:/memList.do";
	}
	
	
	
	//6 로그인 화면에서 로그인 되었을 때는 회원리스트 화면, 그렇지 않을 때는 로그인 화면으로 가게 처리하세요.
	/*
	// 정답
	// 중간에 service단 있는데 생략한 것
	1. DB연동 모듈 확인 dao 	//A06_PareparedDao  login
	2. controller, Member
	3. if(member.getXXX!=null){
		return ""; //회원리스트로 redirect처리
	   }else{
	   	d.addAttribute("msg", "로그인 다시하세요" )
	   	return ""; //로그인 화면
	   }

	 */
	// http://localhost:7080/springweb/hwlogin.do
	@RequestMapping("/hwlogin.do")
	public String login(Member m, Model d) {
		
		String page = "redirect:/memList.do"; //로그인 성공 시 회원리스트 화면
	
		if(m.getId()==null) {
			page = "WEB-INF\\views\\z01_homework\\a03_hw4login.jsp"; // 로그인 실패 시 
		}else if(dao.login(m)==null) {
			d.addAttribute("msg", "해당 아이디와 비밀번호가 일치하지않습니다\\n다시 로그인하세요");
			page = "WEB-INF\\views\\z01_homework\\a03_hw4login.jsp"; // 로그인 실패 시 
		}
		
		return page;
	}
	
	
	
	// 230118 -6
	@Autowired
	private Z03_HWService service;
	
	// http://localhost:7080/springweb/deptDI01.do
	@GetMapping("/deptDI01.do")
	public String dept(Model d) {
		d.addAttribute("dept", service.getDeptInfo());
		return "z_homework\\a08_230118.jsp";
	}
	
	
	
}
