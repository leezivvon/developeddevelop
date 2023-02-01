package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.CarRacer;
import a01_diexp.z01_vo.HPUser;

public class DIExp16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 
		String path = "a01_diexp\\di16.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		HPUser obj = ctx.getBean("us01", HPUser.class);
		System.out.println("컨테이너의 객체호출 "+obj);
		obj.usingMyPhone();
		
		CarRacer carRacer01 = ctx.getBean("carRacer01", CarRacer.class);
		carRacer01.driving();
		System.out.println("종료");
		ctx.close();
		// di10.xml
		// <bean id="obj" class="java.lang.Obect"/>
		
	}

}
