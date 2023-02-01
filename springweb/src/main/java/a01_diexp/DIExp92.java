package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a02_diexp.z07_web.A01_Controller;
import springweb.z01_vo.Emp;

public class DIExp92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di92.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		A01_Controller empCtrl = ctx.getBean("A01_Controller", A01_Controller.class);
		empCtrl.showEmpList(new Emp());

		
		System.out.println("종료");
		ctx.close();
		
		
		
		
	}

}
