package a01_diexp.z01_vo;

import java.util.Map;
import java.util.Properties;

public class BaseTeam {
	private Map<Integer, String> hitOrders;
	private Properties defends;
	public BaseTeam() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseTeam(Properties defends) {
		this.defends = defends;
	}
	public BaseTeam(Map<Integer, String> hitOrders) {
		this.hitOrders = hitOrders;
	}
	
	public void setDefends(Properties defends) {
		this.defends = defends;
	}



	public Map<Integer, String> getHitOrders() {
		return hitOrders;
	}
	public void setHitOrders(Map<Integer, String> hitOrders) {
		this.hitOrders = hitOrders;
	}
	public Properties getDefends() {
		return defends;
	}

	
	
}
