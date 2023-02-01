package springweb.a05_mvc.a03_dao;

import java.util.List;

import springweb.z01_vo.Dept;

public interface A02_DeptDao {
	// 메서드 선언
//	public String myDeptList(); 땡..!!
	public List<Dept> getDeptList(Dept sch);

	public Dept getDept(int deptno);
	
	
	/* 230131과제#4 */
	public void updateDept(Dept upt);
	public void deleteDept(int deptno);

}
