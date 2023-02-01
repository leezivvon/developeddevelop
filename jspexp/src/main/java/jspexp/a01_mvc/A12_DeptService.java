package jspexp.a01_mvc;

import java.util.List;

import com.google.gson.Gson;

import jspexp.a13_database.A06_PareparedDao;
import jspexp.vo.Dept;

public class A12_DeptService {

	//A06_PareparedDao.java
	//getDeptList(Dept sch)메서드 활용
	
	private A06_PareparedDao dao; 
	private Dept sch;
	
	public A12_DeptService() {
		dao = new A06_PareparedDao();
	}
	
	// json문자열 처리 기능메서드
	public String getDeptAjax(String dname, String loc){
		sch = getDept(dname, loc);
		Gson g = new Gson();
		System.out.println(g.toJson(sch));
		
		return g.toJson(getDeptList());
	}
	
	// 요청값 null처리 후 객체를 만드는 기능메서드
	public Dept getDept(String dname, String loc) {
		if(dname==null) dname="";
		if(loc==null) loc="";
		sch = new Dept(dname,loc);
		
		return sch;
	}
	
	public List<Dept> getDeptList(){
		//부서정보를 가져오는거
		return dao.getDeptList(sch);
	}
}
