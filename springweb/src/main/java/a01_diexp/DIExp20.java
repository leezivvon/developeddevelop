package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z05_vo.Computer;
import a01_diexp.z05_vo.Ram;

public class DIExp20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 
		String path = "a01_diexp\\di20.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		Ram ram = ctx.getBean("ram", Ram.class);
		System.out.println("컨테이너의 객체호출 "+ram);
		ram.setCompany("하이닉스");
		ram.setMemory("16G");
		
		Computer computer = ctx.getBean("computer", Computer.class);
		System.out.println("컨테이너의 객체호출 "+computer);
		computer.setCompany("Apple");
		
		computer.show(); //1:1관계가 mapping돼서 자동으로 처리가 됨
		
		System.out.println("종료");
		ctx.close();
		
		
		/*
		# 처리 순서
		1. Computer, Ram 1:1관계 및 출력기능메서드 처리
		2. di20.xml 컨테이너 안에 객체 로딩
		3. Computer에 소스상 Autowire처리
		4. main()에서 Ram객체 호출 및 데이터 처리
		5. main()에서 Computer객체 호출 및 제조사 처리
		6. main()에서 Computer의 출력메서드 처리
		 */
	
	
	}

}
