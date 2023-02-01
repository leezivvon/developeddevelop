package javaexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.vo.Person;
import javaexp.a13_database.vo2.Emp01;
import javaexp.a13_database.vo2.Emp02;
import javaexp.a13_database.vo2.Emp03;
import javaexp.a13_database.vo2.Emp04;
import javaexp.a13_database.vo2.Emp05;

public class A04_DaoExp {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	// 여러가지 sql을 통해 vo만들고 ==> 기능메서드 선언
	
	
	// ex) 1. 기능 메서드 선언 : 리턴값, 매개변수, 기본 객체 생성
	 public List<Emp01> getSch01(int deptno){//메서드는 내 마음대로 
	 	List<Emp01> list = new ArrayList<Emp01>();
	 	
	 	String sql ="SELECT deptno, ename, job, sal\r\n"
	 			+ "FROM emp\r\n"
	 			+ "WHERE deptno="+deptno;
	
	 	// 1. 연결
	 	try {
			con = DB.con();
			
			// 2. 대화
			stmt = con.createStatement();
			
			// 3. 결과
			rs = stmt.executeQuery(sql);
			
			// 4. while 처리 - 이해를 바탕으로 코딩**
			while(rs.next()) {
				Emp01 e = new Emp01(rs.getInt("deptno"),
									rs.getString("ename"),
									rs.getString("job"),
									rs.getDouble("sal"));
				
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
			
			
		// 정정합니다 이렇게 닫아주세요 DB.close	
		} catch (SQLException e) {
			System.out.println("DB관련예외: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	 	
	 	
		 	return list;
	 }
	 	
	 
	 // 기능메서드 선언
 	public List<Emp02> getSch02(Emp02 sch){
 		List<Emp02> list = new ArrayList<Emp02>();

		String sql = "SELECT empno, ename, sal\r\n"
				+ "FROM EMP\r\n"
				+ "WHERE ename LIKE ''||'"+sch.getEname()+"'||'%'\r\n"
				+ "AND sal BETWEEN "+sch.getFrSal()+" AND "+sch.getToSal();
		
		try {
			con = DB.con();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// 생성자는 select에 있는거만
				Emp02 e = new Emp02(rs.getInt(1), // = rs.getInt("empno")
									rs.getString(2),
									rs.getDouble(3));
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
			
			
		} catch (SQLException e) {
			System.out.println("DB관련예외: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	 	
 		return list;
 	}	 	
 	
 	
 	// 기능메서드 선언
 	public List<Emp03> getSch03(Emp03 sch){
 		List<Emp03> list = new ArrayList<Emp03>();
 		
 		String sql = "SELECT empno, ename, job, deptno\r\n"
 				+ "FROM emp\r\n"
 				+ "WHERE job LIKE '%'||'"+sch.getJob()+"'||'%' \r\n"
 				+ "OR deptno = "+sch.getDeptno();
 		
 		try {
			con = DB.con();			
			stmt = con.createStatement();	
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// 바로 넣는 방법
				list.add(
					new Emp03(
					rs.getInt(1), 	// = rs.getInt("empno")
					rs.getString(2), 	// = rs.getString("ename")
					rs.getString(3),
					rs.getInt(4)
					)
				);
			}
			System.out.println("데이터의 건수: "+list.size());
			
		} catch (SQLException e) {
			System.out.println("DB관련예외: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	 	
 		return list;
 		
 	}
		 	
 	
 	// 기능 메서드 선언
 	public List<Emp04> getSch04(Emp04 sch){
 		List<Emp04> list = new ArrayList<Emp04>();
 		
 		String sql = "SELECT dname, ename, hiredate, sal \r\n"
 				+ "FROM emp e, dept d\r\n"
 				+ "WHERE e.deptno = d.deptno\r\n"
 				+ "AND dname LIKE '%'||'"+sch.getDname()+"'||'%'\r\n"
 				+ "AND to_char(hiredate, 'Q') = '"+sch.getDiv()+"'";
 		
 		try {
			con = DB.con();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// 선언 후 할당
				Emp04 e = new Emp04(rs.getString("dname"),
									rs.getString("ename"),
									rs.getDate("hiredate"),
									rs.getDouble("sal"));
				list.add(e);
				
				
				// 바로 할당
				/*
				list.add(
					new Emp04(
						rs.getString("dname"),
						rs.getString("ename"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"))
				);
				*/
			}
			System.out.println("데이터의 건수: "+list.size());
			
			
		} catch (SQLException e) {
			System.out.println("DB관련예외: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
 		
 		return list;
 	}
 	
 	
 	
 	// 단일데이터 처리    =결과값이 하나밖에 안나옴
 	// select * from emp where empno =7000;
 	// 1. vo 작성
 	// 2. 기능메서드 : 결과가 한 개의 row일 때는 객체를 선언   // 키가 하나일수밖에 없잖아,,,?
 	
 	public Emp05 getEmpSch05(int empno) {
 		Emp05 e = null;
 		
 		String sql = "select * from emp where empno ="+empno;
 		
 		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 단일 데이터의 경우 한번만 호출 >>  while ==> if
			if(rs.next()) { // while(rs.next())가 아니라
				e = new Emp05(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"),
						rs.getDouble("comm"),
						rs.getInt("deptno")	
						);
			}
			
			
		} catch (SQLException e1) {
			System.out.println("DB관련예외: "+e1.getMessage());
		} catch (Exception e1) {
			System.out.println("일반 예외"+e1.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}

 		return e;
 	}
 	
 	
 	
 	// person insert
 	public void insertPerson(Person insert) {
 		
 		String sql = "INSERT INTO person values('"+insert.getName()+"', "
 					  +insert.getAge()+", '"+insert.getLoc()+"')";
 	
 		try {
			con = DB.con();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			// 바로 출력
			System.out.println("등록 건수: "+stmt.executeUpdate(sql));
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB처리: "+e.getMessage());
			try {
				con.rollback();
			}catch(Exception e1) {
				System.out.println("rollback에러: "+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
 	}

 	
 	
	public static void main(String[] args) {
		
		A04_DaoExp dao = new A04_DaoExp();
		
		dao.getSch01(10); // 데이터건수만 출력
		// 전체 결과 출력
		List<Emp01> list = dao.getSch01(10);
		for(Emp01 e:list) {
			System.out.print(e.getDeptno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t\t");
			System.out.print(e.getSal()+"\n");
		}
		

		// 전체 결과 출력
		List<Emp02> list02 = dao.getSch02(new Emp02("A", 1000, 999999));
		for(Emp02 e : list02) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getSal()+"\t");
//			System.out.print(e.getFrSal()+"\t");
//			System.out.print(e.getToSal()+"\n");
			
		}
		
		// 전체 결과 출력
		List<Emp03> list03 = dao.getSch03(new Emp03("",10));
		for(Emp03 e : list03) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t\t");
			System.out.print(e.getDeptno()+"\n");
		}
		
		// 전체 결과 출력
		List<Emp04> list04 =dao.getSch04(new Emp04("A","1"));
		for(Emp04 e : list04) {
			System.out.print(e.getDname()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getHiredate()+"\t");
			System.out.print(e.getSal()+"\n");
//			System.out.print(e.getDiv()+"\n");
		}
		
		
		
		// 전체 결과 출력(호출)
		Emp05 empOne = dao.getEmpSch05(7369);
//		Emp05 empOne = dao.getEmpSch05(5000); 데이터 없음
		if(empOne != null) {
			System.out.print(empOne.getEmpno()+"\t");
			System.out.print(empOne.getEname()+"\t");
			System.out.print(empOne.getJob()+"\n");
		}else {
			System.out.println("데이터 없음");
		}
			
	
		
		// person테이블 insert
		
		dao.insertPerson(new Person("이지은", 30, "서울 용산"));
		
	}

}




