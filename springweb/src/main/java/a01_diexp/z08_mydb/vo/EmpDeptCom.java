package a01_diexp.z08_mydb.vo;

public class EmpDeptCom {
	private Emp emp;
	private Dept dept;
	
	//생성자말고 get/set메서드만 
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
}
