package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.BaseTeam;
import a01_diexp.z01_vo.Car02;

public class DIExp90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di90.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		Car02 car01 = ctx.getBean("car01", Car02.class);
		System.out.println("컨테이너의 객체호출 "+car01);
		car01.showMyTire();
		System.out.println("종료");
		
		
		BaseTeam bt = ctx.getBean("bt01", BaseTeam.class);
		System.out.println("컨테이너의 객체호출 "+bt);
		System.out.println(bt.getHitOrders());
		System.out.println(bt.getDefends());
		
		System.out.println("종료");
		
		
		ctx.close();
		
		
		
		
	}

}
