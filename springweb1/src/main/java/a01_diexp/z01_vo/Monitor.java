package a01_diexp.z01_vo;

import java.util.Map;

//map을 한 번 설정해보자요
public class Monitor {
	
	private Map<String, Integer> config;
	
	public Map<String, Integer> getConfig(){
		return config;
	}
	public void setConfig(Map<String, Integer> config) {
		this.config = config;
	}
}
