package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Person;

// springweb.a01_start.A04_RequestVo
@Controller
public class A04_RequestVo {
	
	// http://localhost:7080/springweb/person.do
	//	?name=홍길동&age=&loc=서울 절대 안됨
	@RequestMapping("/person.do")
	public String callPerson(Person person) { //vo에 age property가 int(숫자형)로 되어있기때문에 숫자여야하고 공백이면 안된다 
		// 요청값이 없더라도 해당 메서드가 호출되고 type에 맞게 호출되면 해당 요청값을 Person객체에 할당된다
		System.out.println("#요청값#");
		System.out.println("이름:"+person.getName());
		System.out.println("나이:"+person.getAge());
		System.out.println("주소:"+person.getLoc());
		
		return "WEB-INF\\views\\a01_start\\a14_insertPerson.jsp";
	}
	
	
	
	
	// ex)
	// http://localhost:7080/springweb/deptIns.do
	// 부서번호, 부서명, 부서위치로 등록화면을 구현하세요
	
	//	?name=홍길동&age=&loc=서울 절대 안됨
	@RequestMapping("/deptIns.do")
	public String callDept(Dept dpt, Model d) { //vo에 age property가 int(숫자형)로 되어있기때문에 숫자여야하고 공백이면 안된다 
		// 요청값이 없더라도 해당 메서드가 호출되고 type에 맞게 호출되면 해당 요청값을 Person객체에 할당된다
		System.out.println("#요청값#");
		System.out.println("부서번호:"+dpt.getDeptno());
		System.out.println("부서명:"+dpt.getDname());
		System.out.println("부서위치:"+dpt.getLoc());
		
		return "WEB-INF\\views\\a01_start\\a15_insertDept.jsp";
	}
	
}
