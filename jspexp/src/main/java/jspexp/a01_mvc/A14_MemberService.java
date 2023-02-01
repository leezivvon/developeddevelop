package jspexp.a01_mvc;

import jspexp.a13_database.A06_PareparedDao;
import jspexp.vo.Member;

public class A14_MemberService {

	private A06_PareparedDao dao;
	private Member sch;
	
	public String chcekIdJson(String id){
		// checkId메서드가 boolean값이기 때문에 ==> 문자열로 형변환
		return ""+dao.checkId(id);
	}
}
