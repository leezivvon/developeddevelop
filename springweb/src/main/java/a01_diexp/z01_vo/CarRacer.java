package a01_diexp.z01_vo;

public class CarRacer {
	private String name;
	private Car car;
	
	public CarRacer() {
		// TODO Auto-generated constructor stub
	}
	public CarRacer(String name) {
		this.name = name;
	}
	
	public void driving() {
		System.out.println("#자동차를 운행#");
		System.out.println("운전자:"+name);
		if(car!=null) {
			System.out.println("자동차이름:"+car.getName());
			System.out.println("최고속도:"+car.getMaxSpeed());
		}else {
			System.out.println("차가 없습니다");
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	// 컨테이너의 id와 메서드의 property가 동일할때 해당 객체 할당하는 것 byname
	public void setCar03(Car car) {
		this.car = car;
	}
	
	
}
