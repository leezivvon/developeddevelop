package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.CarRacer;
import a01_diexp.z01_vo.HPUser;

public class DIExp12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di12.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		HPUser hu01 = ctx.getBean("hu01", HPUser.class);
		HPUser hu02 = ctx.getBean("hu02", HPUser.class);		
		hu01.usingMyPhone();
		hu02.usingMyPhone();
		System.out.println("종료");
		
		
		
		// ex) Car(name, maxSpeed), CarRacer(name, Car)
		//	   1:1관계 설정			driving()
		CarRacer cr01 = ctx.getBean("cr01", CarRacer.class);
		CarRacer cr02 = ctx.getBean("cr02", CarRacer.class);
		cr01.driving();
		cr02.driving();
		System.out.println("종료");
		
		
		ctx.close();
	}

}
