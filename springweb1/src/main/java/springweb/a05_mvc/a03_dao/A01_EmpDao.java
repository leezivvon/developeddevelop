package springweb.a05_mvc.a03_dao;

import java.util.List;

import springweb.z01_vo.Emp;

// springweb.a05_mvc.a03_dao
// public List<Emp> getEmpList(Emp sch)
public interface A01_EmpDao {
	public List<Emp> getEmpList(Emp sch); //mapper에 영향을 미침
	
	
}
