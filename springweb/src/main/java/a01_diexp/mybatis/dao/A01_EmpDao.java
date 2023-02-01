package a01_diexp.mybatis.dao;

import java.util.List;

import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpDept;
import springweb.z01_vo.EmpSalgrade;

public interface A01_EmpDao {
	public List<Emp> getEmpList(Emp sch);
	
	// 단일 객체 (=단일 리턴값)
	public int empCount();
	
	public double empMaxSal();
	public String getEname();
	//ex
	public double getMaxSalByDept();
	public int getMaxMgr();
	public String getJobByEname();
	
	
	// 다중객체 (=객체형 리턴값)
	public Emp getEmpByEmpno();
	public Emp getEmpByEname();
	
	
	// 새롭게 시작
	// 다중행 객체 리턴값
	public List<EmpDept> getEmpDeptList();
	public List<EmpSalgrade> getEmpSalGrade();
}
