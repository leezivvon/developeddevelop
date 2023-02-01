package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Bus;
import a01_diexp.z01_vo.Monitor;
import a01_diexp.z01_vo.Sensor;
import a01_diexp.z01_vo.Student;

public class DIExp14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "a01_diexp\\di14.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		// DL(dependenct lookup)으로 id명으로 객체를 찾아서
		Sensor sensor01 = ctx.getBean("sensor01", Sensor.class);
		System.out.println("컨테이너의 객체호출 "+sensor01);
		System.out.println(sensor01.getAgent());
		System.out.println("구매정보(addInfo)"+sensor01.getAddInfo());
		System.out.println("종료");
		
		
	/*
	ex) Class Bus setPassenger(Set<String> names)
		di로 할당한 후 getPassenger()호출하여 출력
	*/
		Bus bus01 = ctx.getBean("bus01", Bus.class);
		System.out.println("탑승한 승격명단:"+bus01.getPassenger());
		// ex) Properties 선언하여 busInfo로 버스번호, 구간시작, 종점정보를 추가
		System.out.println("버스정보:"+bus01.getBusInfo());
		
		
		
		System.out.println("종료");
		
		
		Monitor monitor01 = ctx.getBean("monitor01", Monitor.class);
		System.out.println(monitor01.getConfig());
		//
		
	/*
	ex) Class Student Map<String, Integer> records
		과목당 점수를 설정할 수 있는 Map선언 di에서 할당 후 출력하세요
	*/
		Student stud01 = ctx.getBean("stud01", Student.class );
		System.out.println("학생성적: "+stud01.getRecords());
		
		ctx.close();
	}
	
	

}
