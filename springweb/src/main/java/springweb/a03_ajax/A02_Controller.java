package springweb.a03_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A02_Controller {
	
	// http://localhost:7080/springweb/empForAjax.do  <<이걸로 들어감
	@GetMapping("/empForAjax.do")
	public String empForAjax() {
		return "a01_jquery\\a17_ajax.html";
	}
	// view단 : $("h2").text("jquery Ajax")
	
	
	// http://localhost:7080/springweb/deptForAjax.do 
	@GetMapping("/deptForAjax.do")
	public String deptForAjax() {
		return "a01_jquery\\a18_ajax.html";
	}
	
	
	
	// 230118-3
	// http://localhost:7080/springweb/buyProd99.do 
	@GetMapping("buyProd99.do")
	public String buyProd99() {
		return "z_homework\\a08_230118.jsp";
	}
	
	// 230118-4
	// http://localhost:7080/springweb/memListAjax.do
	@GetMapping("/memListAjax.do")
	public String memListAjax(){
//		return "z_homework\\a08_hw230118_4.jsp";
		return "z_homework\\a08_230118.jsp";
	}
}
