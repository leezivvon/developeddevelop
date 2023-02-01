package a01_diexp.z01_vo;

import java.util.Properties;
import java.util.Set;

public class Bus {
	private Set<String> passenger;
	private Properties busInfo;

	
	public Bus() {
		// TODO Auto-generated constructor stub
	}


	public Set<String> getPassenger() {
		return passenger;
	}
	public void setPassenger(Set<String> passenger) {
		this.passenger = passenger;
	}
	
	public Properties getBusInfo() {
		return busInfo;
	}
	public void setBusInfo(Properties busInfo) {
		this.busInfo = busInfo;
	}
	
}
