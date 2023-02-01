package springweb.a04_di_last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A03_Controller {

	/*

	// A03_Controller.java
		http://localhost:7080/springweb/diCall02.do
	// A04_Service.java
	 	public String getGreet(){ 
	 		return "안녕하세요(의존성 주입)" 
	 	}
	
	 */	
	
	@Autowired
	private A04_Service service; // 컨트롤러에 있는 서비스 객체를 사용하겠다는 뜻
	
	// http://localhost:7080/springweb/diCall02.do
	@GetMapping("/diCall02.do")
	public String diCall02(Model d) {
		System.out.println("주입???"+service.getGreet());
		d.addAttribute("show", service.getGreet());
		
		return "WEB-INF\\views\\a01_start\\a21_showView.jsp";
	}
}
