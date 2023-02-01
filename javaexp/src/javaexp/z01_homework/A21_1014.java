package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.a13_database.DB;

// 1
/*
Statement 객체의 excuteUpdate(sql)
Connection 객체의 commit(), 예외 처리 내용을 rollback()	
*/

public class A21_1014 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	// 2
	public void insSalgrade(Salgrade100 ins) {
		String sql = "INSERT INTO salgrade100 VALUES("
					+ins.getGrade()+", "+ins.getLosal()+", "+ins.getHisal()+");\r\n"
					+ "";	
		try {
			con = DB.con();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println("등록건수: "+cnt);
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB처리: "+e.getMessage());
			try {
				con.rollback();
			} catch(Exception e1) {
				System.out.println("rollback에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
	
	
	// 3
	public void insertEmDt(EmpDept100 insert) {
		String sql = "INSERT INTO EmpDept100 values("+insert.getEmpno()
					+", '"+insert.getEname()+"', '"+insert.getJob()+"', "+
					insert.getMgr()+", to_date('"+insert.getHiredateS()+"','YYYY/MM/DD'), "+
					insert.getSal()+", "+insert.getComm()+", "+insert.getDeptno()+", '"
					+insert.getDname()+"', '"+insert.getLoc()+"')\r\n"
					+ "";
		System.out.println("입력: ");
		System.out.println(sql);
		try {
			con = DB.con();
			con.setAutoCommit(false);		
			stmt = con.createStatement();
			stmt.executeUpdate(sql);	
//			System.out.println("등록 건수: "+cnt);
			con.commit();
				
		} catch (SQLException e) {
			System.out.println("DB처리: "+e.getMessage());
			try {
				con.rollback();
			} catch(Exception e1) {
				System.out.println("rollback에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		
	}
	//3
	/*
	1. 테이블 만들기
		CREATE TABLE EmpDept100 
		AS SELECT e.*, dname, loc  FROM emp e, dept d WHERE e.deptno=d.deptno;
	2. sql만들기
	3. 입력한 Vo객체 만들기
	4. 기능 메서드 선언
	5. 입력 처리 코드
	*/
	
	
	//4
	public void insertMem(Member100 insert) {
		String sql = "INSERT INTO member100 values('"+insert.getId()
					 +"', '"+insert.getPass()+"', '"+insert.getName()+"', '"+insert.getAutho()
					 +"', "+insert.getPoint()+", to_Date('"+insert.getRegDateS()+"','YYYY/MM/DD'))\r\n"
					 + "";
		try {
			con = DB.con();
			con.setAutoCommit(false);		
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);	
			System.out.println("등록 건수: "+cnt);
			con.commit();
				
		} catch (SQLException e) {
			System.out.println("DB처리: "+e.getMessage());
			try {
				con.rollback();
			} catch(Exception e1) {
				System.out.println("rollback에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
	public List<Member100> memSCh(Member100 sch) {
		List<Member100> list = new ArrayList<Member100>();
		
		String sql = "SELECT * FROM member100";
			try {
				con = DB.con();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					list.add(
						new Member100(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getString(6)
					));
					System.out.println("데이터의 건수: "+list.size());
				}
				
			} catch (SQLException e) {
				System.out.println("DB관련예외: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외"+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
			return list;
	}

	/*
	// 4 정답
	public void insertMem(Member100 insert) {
		String sql = "INSERT INTO member100 values('"+insert.getId()
					 +"', '"+insert.getPass()+"', '"+insert.getName()+"', '"+insert.getAutho()
					 +"', "+insert.getPoint()+", sysdate\r\n"
					 + "";
		try {
			con = DB.con();
			con.setAutoCommit(false);		
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);	
			System.out.println("등록 건수: "+cnt);
			con.commit();
				
		} catch (SQLException e) {
			System.out.println("DB처리: "+e.getMessage());
			try {
				con.rollback();
			} catch(Exception e1) {
				System.out.println("rollback에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
	
	//조회
	public List<Member100> memSCh(Member100 sch) {
		List<Member100> list = new ArrayList<Member100>();
		
		String sql = "SELECT * FROM member100
					WHERE "+ins.getId()+" LIKE '%'||''||'%'
					OR "+ins.getName()+" LIKE '%'||''||'%';
					";
			try {
				con = DB.con();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					list.add(
						new Member100(
							rs.getString("id"),
							rs.getString("pass"),
							rs.getString("name"),
							rs.getString("auto"),
							rs.getInt("point"),
							rs.getDate("regdte")
					));
					System.out.println("데이터의 건수: "+list.size());
				}
				
			} catch (SQLException e) {
				System.out.println("DB관련예외: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외"+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
			return list;
	}
	*/
	//5
	//boolean사용...?
	public void loginmem(String id, String pass) {
		String sql = "SELECT * FROM member100";
			try {
				con = DB.con();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);				
				rs.next();
				
	
			} catch (SQLException e) {
				System.out.println("DB관련예외: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외"+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
			return;
	}
	
	/*
	//5 정답
	public boolean login(Mmeber100 sch) {
		boolean isLogin = false;
		String sql = "SELECT * FROM member100 where id ='"+sch.getId()
					"'and pass='"+sch.getPass()+"'";
		System.out.println("조회");
		System.out.println(sql);

			try {
				con = DB.con();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);				
				isLogin = rs.next();
				
	
			} catch (SQLException e) {
				System.out.println("DB관련예외: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외"+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
			return isLogin;

	*/
	
	
	
	public static void main(String[] args) {
		
		A21_1014 dao = new A21_1014();
		
		// 3 입력
//		dao.insertEmDt(new EmpDept100(100, "최도일", "본부장", 001, "2012/12/31", 20000, 0, 99, "해외관리팀", "LA" ));
		// 3정답
//		EmpDept100 ins = new EmpDept100(100, "최도일", "본부장", 001, "2012/12/31", 20000, 0, 99, "해외관리팀", "LA");
//		dao.insertEmDt(ins);
		
		// 4 입력
//		dao.insertMem(new Member100("banana02","bbannnan02", "최바나나", "전체공개", 200, "2021/10/14"));
//		dao.insertMem(new Member100("cherry03","cchherryy03", "이체리", "전체공개", 20000, "2019/11/24"));
		// 4 조회 
		List<Member100> memlist = dao.memSCh(new Member100());
		for(Member100 m : memlist) {
			System.out.print(m.getId()+"\t");
			System.out.print(m.getPass()+"\t");
			System.out.print(m.getName()+"\t");
			System.out.print(m.getAutho()+"\t");
			System.out.print(m.getPoint()+"\t");
			System.out.print(m.getRegDateS()+"\n");
		}
		// 4 정답
		/*
		Member100(String id, String pass, String name, String autho, int point, Date regdte )
			dao.insertMem(new Member100("banana02","bbannnan02", "최바나나", "전체공개", 200, null));
		for(Member100 mem : dao.memList(new Member100("",""))) {
			System.out.print(mem.getId()+"\t");
			System.out.print(m.getName()+"\t");
			System.out.println(m.getAutho()+"\n");
		*/
		
		//5
		Scanner sc = new Scanner(System.in);
		System.out.print("ID입력_");
		String scId = sc.nextLine();
		System.out.print("비밀번호입력_");
		String scPass = sc.nextLine();
		
		dao.loginmem(scId, scPass);
		//5 정답
		/*
		//1 일반
		Scanner sc = new Scanner(System.in);
		System.out.println("#로그인#");
		System.out.print("ID입력_");
		tring id = sc.nextLine();
		System.out.print("비밀번호입력_");
		String pass = sc.nextLine();
		
		Member100 mLogin = new Member100();
		mLogin.setId(id);
		mLogin.setPass(pass);
		if(dao.login(mLogin)){
			System.out.println("로그인 성공");
		}else{
			System.out.println("로그인 실패");
		}	
		
		//2 로그인 될 때까지
		Scanner sc = new Scanner(System.in);
		Member100 mLogin = new Member100();
		boolean isFirst = true;
		do{
			if(!isFirst) {
				System.out.println("로그인 실패! 다시입력");
			}
			System.out.println("#로그인#");
			System.out.print("ID입력_");
			String id = sc.nextLine();
			System.out.print("비밀번호입력_");
			String pass = sc.nextLine();
			mLogin.setId(id);
			mLogin.setPass(pass);
		
		}while( !dao.login(mLogin) ){   // do문은 해당 데이터가 false일 때 반복문이 계속됨
			System.out.println("로그인 성공");
		}
		
		*/
	}
}
//4
class Member100{
	private String id;
	private String pass;
	private String name;
	private String autho;
	private int point;
	private String regDateS;
//	pirvate Date regdte;
	public Member100() {
		// TODO Auto-generated constructor stub
	}
	
//	public Member100(String id, String name) {
//	this.id = id;
//	this.name = name;
//}
	public Member100(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	public Member100(String id, String pass, String name, String autho, int point, String regDateS) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.autho = autho;
		this.point = point;
		this.regDateS = regDateS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAutho() {
		return autho;
	}
	public void setAutho(String autho) {
		this.autho = autho;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getRegDateS() {
		return regDateS;
	}
	public void setRegDateS(String regDateS) {
		this.regDateS = regDateS;
	}
	
	
}
//3
class EmpDept100{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredateS; // 등록, 수정, 삭제
	private double sal;
	private double comm;
	private int deptno;
	private String dname;
	private String loc;
//	private Date hiredate
	public EmpDept100() {//기본생성자
		
	}
	//조회를 위한 생성자 : hiredateS삭제    = 조회는 hiredate(Date)로
	public EmpDept100(int empno, String ename, String job, int mgr, String hiredateS, double sal, double comm,
			int deptno, String dname, String loc) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredateS = hiredateS;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	//입력을 위한 생성자... : empno, hredate삭제  = 입력은 hiredateS(String)로
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredateS() {
		return hiredateS;
	}
	public void setHiredateS(String hiredateS) {
		this.hiredateS = hiredateS;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}


//2
class Salgrade100 {
	private int grade;
	private int losal;
	private int hisal;
	public Salgrade100() {
	}
	public Salgrade100(int grade, int losal, int hisal) {
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLosal() {
		return losal;
	}
	public void setLosal(int losal) {
		this.losal = losal;
	}
	public int getHisal() {
		return hisal;
	}
	public void setHisal(int hisal) {
		this.hisal = hisal;
	}
	
}
