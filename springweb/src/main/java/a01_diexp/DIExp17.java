package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z02_vo.Person;
import a01_diexp.z02_vo.Product;
import a01_diexp.z02_vo.Student;

public class DIExp17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di17.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		Person person = ctx.getBean("person", Person.class);
		Product product = ctx.getBean("product", Product.class);
		Student student = ctx.getBean("student", Student.class);
		System.out.println("컨테이너의 객체호출 "+person);
		System.out.println("컨테이너의 객체호출 "+product);
		System.out.println("컨테이너의 객체호출 "+student);
		System.out.println("종료");
		ctx.close();
		
	}

}
