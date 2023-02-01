package jspexp.a01_mvc;

import java.util.List;

import com.google.gson.Gson;

import jspexp.a13_database.A02_EmpDao;
import jspexp.vo.Emp;

//주요 핵심 로직 처리 후 모델로 사용할 핵심 데이터를 리턴
//service에서 요청값처리하면 안됨
public class A08_EmpService {
	
	private A02_EmpDao dao;
	private Emp sch;
	
	public A08_EmpService(){
		dao = new A02_EmpDao();
	}
	
	// array/object(배열이나 객체를) ==> json문자열로 
	public String empAjax(String ename, String job, String frSalS, String toSalS) {
		sch = getEmp(ename, job, frSalS, toSalS);
		Gson g = new Gson();
		System.out.println(g.toJson(sch));
		
		return g.toJson(empList()); //emplist를 json데이터로 바꾸겠다
	}
	
	//3
	//초기에 값이 없더라도 나타날 수 있게 필터링
	
	public Emp getEmp(String ename, String job, String frSalS, String toSalS) {
		if(ename==null) ename="";
		if(job==null) job="";
		if(toSalS==null || toSalS.equals("")) toSalS="9999";
		if(frSalS==null || frSalS.equals("")) frSalS="0";
	    double frSal = Double.parseDouble(frSalS);
	    double toSal = Double.parseDouble(toSalS);

		sch = new Emp(ename, job, frSal, toSal);
		return sch;
	}
	public List<Emp> empList(){
		return dao.getEmpSch(sch);
	}
	
	
	//2
	public List<Emp> empList(String ename, String job, String frSalS, String toSalS){
		// 이러한 로직들은 service단에서 처ㅣㄹ!
		if(frSalS==null || frSalS.equals("")) frSalS="0";
		if(toSalS==null || frSalS.equals("")) toSalS="9999";
		int frSal = Integer.parseInt(frSalS);
		int toSal = Integer.parseInt(toSalS);
		
		Emp sch = new Emp(ename, job, frSal, toSal);
		return dao.getEmpSch(sch);
	}
	
	//1
	public List<Emp> empList(Emp sch){
		// 알고리즘, 로직처리.. 초기값 설정
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");			
		if(sch.getToSal()==0) sch.setToSal(9999);
		
		return dao.getEmpSch(sch);
		
		//public List<Emp> getEmpSch(Emp sch){
		//	List<Emp> list = new ArrayList<Emp>();
	}
	
	
}




