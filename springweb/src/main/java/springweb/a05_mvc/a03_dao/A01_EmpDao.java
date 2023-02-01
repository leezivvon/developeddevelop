package springweb.a05_mvc.a03_dao;

import java.util.List;

import springweb.z01_vo.Code;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpInit;

// springweb.a05_mvc.a03_dao
// public List<Emp> getEmpList(Emp sch)
public interface A01_EmpDao {
	public List<Emp> getEmpList(Emp sch); //mapper에 영향을 미침
	
	
	//사원정보 어쩌고(관리)
	public List<Dept> getDeptComb();
	public List<Code> getMgrComb();
	public List<String> getJobComb();

	
	// 230130과제#6
	public List<EmpInit> getEmpAll();
	
	
}
