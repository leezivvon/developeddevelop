package a01_diexp.mybatis.dao;

import java.util.List;

import springweb.z01_vo.Emp;

public interface A01_EmpDao {
	public List<Emp> getEmpList(Emp sch);
	
	//단일 객체
	public int empCount();
	
	public double empMaxSal();
	public String getEname();
	//ex
	public double getMaxSalByDept();
	public int getMaxMgr();
	public String getJobByEname();
	
	
	// 다중객체
	public Emp getEmpByEmpno();
	public Emp getEmpByEname();
}
