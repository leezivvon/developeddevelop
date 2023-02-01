package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Music;
import a01_diexp.z01_vo.Person;
import a01_diexp.z01_vo.Product;

public class DIExp11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di11.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서 가져온다
		Person p01 = ctx.getBean("p01", Person.class);
		System.out.println("컨테이너의 객체호출 "+p01);
		System.out.println("이름:"+p01.getName());
		System.out.println("나이:"+p01.getAge());
		System.out.println("주소:"+p01.getLoc());
		System.out.println("종료");
//		ctx.close();
		// di10.xml
		// <bean id="obj" class="java.lang.Obect"/>
		
		
		/*
		ex) vo a01_diexp.z01_vo하위에 Product클래스만들고 di11.xml에서 prod01로 물건명 가격, 개수 선언 및 할당 후
			여기서 prd01 Product객체호출 후 메서드 출력
		 */
		Product prd01 = ctx.getBean("prd01",Product.class);
		System.out.println("컨테이너의 객체호출 "+prd01);
		System.out.println("물건명:"+prd01.getPname());
		System.out.println("가격:"+prd01.getPrice());
		System.out.println("개수:"+prd01.getPcnt());
		System.out.println("종료");
//		ctx.close();
		
		Product prd02 = ctx.getBean("prd02", Product.class);
		System.out.println("@@두번째 객체@@");
		System.out.println(prd02.getPname());
		System.out.println(prd02.getPrice());
		System.out.println(prd02.getPcnt());
		System.out.println("종료");
//		ctx.close();
		
		
		
		// ex) vo Music title, singer를 
		//	   생성자를 객체 생성 후 호출
		Music music01 = ctx.getBean("music01", Music.class);
		System.out.println("#음악 객체 호출#");
		System.out.println(music01.getTitle());
		System.out.println(music01.getSinger());
		
		ctx.close();

		
	}

}
