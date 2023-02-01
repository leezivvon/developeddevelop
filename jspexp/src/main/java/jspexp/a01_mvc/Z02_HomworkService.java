package jspexp.a01_mvc;

import java.util.List;

import com.google.gson.Gson;

import jspexp.a13_database.A03_PrEmp;
import jspexp.vo.Pemp;

public class Z02_HomworkService {
	
	private A03_PrEmp dao;
	private Pemp sch;
	
	public Z02_HomworkService() {
		dao = new A03_PrEmp();
	}
	
	//json문자열
	public String getPempAjax(String empno) {
		sch = getPemp(empno);
		Gson g = new Gson();
		System.out.println(g.toJson(sch));
		
		return g.toJson(getPempList());
	}
	
	public Pemp getPemp(String empno) {
		sch = new Pemp(empno);
		return sch;
	}
	
	public List<Pemp> getPempList(){
		return dao.equalPempno(sch);
	}
}

