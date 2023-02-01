package springweb2.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// 얘를 컨테이너에 등록해야함
// springweb2.a01_start.A01_Controller

@Controller
public class A01_Controller {
	
	// http://localhost:7080/springweb2/start.do
	@RequestMapping("/start.do")
	public String start() {
		return "WEB-INF\\views\\a01_start.jsp";
	}
	
}

// 서버 restart하고 페이지 호출할 것!!!
