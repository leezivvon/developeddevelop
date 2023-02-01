package a01_diexp.z01_vo;

import java.util.Properties;
import java.util.Set;

//a01_diexp.z01_vo.Sensor
public class Sensor {
	private Set<String> agent;
	private Properties addInfo; // key/value형색 객체
	
	public Sensor() {
		// TODO Auto-generated constructor stub
	}

	public Set<String> getAgent() {
		return agent;
	}
	public void setAgent(Set<String> agent) {
		this.agent = agent;
	}
	public Properties getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(Properties addInfo) {
		this.addInfo = addInfo;
	}
	
	
}
