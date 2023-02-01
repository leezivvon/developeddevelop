package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//springweb.a01_start.A03_ModelController

@Controller
public class A03_ModelController {
	//model은 view에 넘겨주기 위한 페이지
	
	// http://localhost:7080/springweb/model01.do
	// Model데이터의 처리
	// 1. 메서드의 매개변수값을  Model d를 설정
	// 2. d.addAttribute("모델명", 모델값)
	// 3. view단에서 ${모델명}
	@RequestMapping("/model01.do")
	public String model01(Model d) {
		d.addAttribute("md_name", "홍길동");
		d.addAttribute("md_age", 25);
		d.addAttribute("md_loc", "서울");
		
		return "WEB-INF\\views\\a01_start\\a03_modelView.jsp";
	}
	/*
	# a03_modelView.jsp
		<h2>이름 : ${md_name}</h2>
		<h2>나이 : ${md_age}</h2>
		<h2>주소 : ${md_loc}</h2>
	*/
	
	
	
	// mapping url은 중복선언을 하며 에러가 난다
	// 단 아래와 같이 get방식과 post방식을 분리하면 에러가 발생하지 않음
	// get방식으로 화면 호출
	// http://localhost:7080/springweb/call10.do
	@GetMapping("/call10.do")
	public String call10() {
		return "WEB-INF\\views\\a01_start\\a10_callCalcu.jsp";
	}
	
	// post방식으로 화면 호출
  //@PostMapping("/call11.do") 
	@PostMapping("/call10.do") //도 가능
	public String call11( @RequestParam("price") int price,
						  @RequestParam("cnt") int cnt,
						  Model d
					  	) {
		d.addAttribute("calcu", price*cnt);
		
		return "WEB-INF\\views\\a01_start\\a10_callCalcu.jsp";
	}
	
	
	
	/* get방식이랑 post방식이랑 분리시킨 방법 */
	
	// http://localhost:7080/springweb/student.do
	// url을 호출할 때는 get방식 @GetMapping, form에 post방식으로 넘길때 @PostMapping 
	@GetMapping("/student.do") 
	public String student01() {
		return "WEB-INF\\views\\a01_start\\a11_studentView.jsp";
	}
	
	// form에서 post방식으로 전송이 되면
	@PostMapping("/student.do") 
	public String student02( @RequestParam("kor") int kor,
						     @RequestParam("eng") int eng,
						     @RequestParam("math") int math,
						     Model d
					  	) {
		d.addAttribute("avg", (kor+eng+math)/3);
		
		return "WEB-INF\\views\\a01_start\\a11_studentView.jsp";
	}
	
	/*
	get방식이랑 post방식이랑 합친 방법
	
	@RequestMapping : get방식과 post방식 모두를 사용할 때 활용된다
	@RequestParam(value="kor", defaultValue="0") int kor
		요청값이 없을 때 default값으로 0을 설저앟고 요청값이 있을 때는 해당 요청값을 처리함으로 
		get방식과 post방식 둘 다 처리가 가능하게 하는 메서드 선언이다
	*/
	// http://localhost:7080/springweb/studentPt.do
	@RequestMapping("/studentPt.do")
	public String student03( @RequestParam(value="kor", defaultValue="0") int kor,
							 @RequestParam(value="eng", defaultValue="0") int eng,
							 @RequestParam(value="math", defaultValue="0") int math,
							 Model d
			) {
		d.addAttribute("avg", kor+eng+math);
		
		return "WEB-INF\\views\\a01_start\\a12_studentPointView.jsp";
	}
	
	
	
	/*
		ex) http://localhost:7080/springweb/buyProduct.do
		   	구매물건 [ ]
			구매가격 [ ]
			구매개수 [ ] [구매] 모델로 총비용 계산
			구매 클릭 시 하단에 구매물건은 @@@ 총비용은 @@@라고 출력
	*/
	@RequestMapping("/buyProduct.do")
	public String buyProd01( @RequestParam(value="pname", defaultValue="구매없음") String pname,
							 @RequestParam(value="price", defaultValue="0") int price,
							 @RequestParam(value="pcnt", defaultValue="0") int pcnt,
							 Model d
			) {
		d.addAttribute("totalCost", price*pcnt);
		
		return "WEB-INF\\views\\a01_start\\a13_buyProdViewExp.jsp";
	}
	
}
