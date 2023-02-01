package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z06_vo.Music;

public class DIExp91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di91.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		Music m = ctx.getBean("m", Music.class);
		System.out.println("컨테이너의 객체호출 "+m);
		
		System.out.println("종료");
		
		

		
		
		ctx.close();
		
		
		
		
	}

}
