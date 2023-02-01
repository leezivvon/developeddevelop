package jspexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jspexp.vo.Dept;

public class A03_DeptDao {
	// 공통 필드 선언
	private Connection con;	// 연결 객체
	private Statement stmt;	// 대화 객체
	private ResultSet rs;	// 결과 객체
	
	// 출력 기능 메서드
	public void showDeptAll() {
		
		try {
			// 연결 객체
			con = DB.con();
			
			// 대화 객체
			stmt = con.createStatement();
			
			// 결과 객체
			String sql = "select * from dept"; // 대화할 내용
			rs = stmt.executeQuery(sql);
			
			// while문 처리 - 부서번호 출력 select * from dept
			while(rs.next()) {
				// 데이터 유형은 가능한한 맞게 처리하여야 한다
				System.out.print(rs.getInt("deptno")+"\t"); // rs.getString("deptno")
				System.out.print(rs.getString("dname"+"\t"));
				System.out.println(rs.getString("loc"));
			}
			
			// 자원해제 : 제일마지막에 생성 ==> 가장 최초 생성된 순으로
			rs.close();
			stmt.close();
			con.close();
			// 중간에 예외가 발생해서 자원해제가 안되는 경우
		} catch (SQLException e) {
			System.out.println("SQL처리에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 처리: "+e.getMessage());
		} finally { // 예외 여부에 상관없이 처리할 내용
			if(rs!=null) rs = null;
			if(stmt!=null) stmt = null;
			if(con!=null) con = null;
		}
		System.out.println("종료");
	
	}
//	SELECT *
//	FROM DEPT
//	WHERE dname LIKE '%'||'O'||'%'
//	AND loc LIKE '%'||''||'%'
	
	/*
	1. vo 만들기
	2. 메서드 선언
	public void deptSch(Dept sch) { }	
		3. 연결
		4. 대화 -sql
		5. 결과
			while()
	*/
	
	
	// 1. vo 만들고
	// 2. 메서드 선언
	public void deptSch(Dept sch) {
		// 3. 연결
		try {
			con = DB.con();
			// 4. 대화 - sql
			String sql = "SELECT *\r\n"
					+ "FROM DEPT100\r\n"
					+ "WHERE dname LIKE '%'||?||'%'\r\n"
					+ "AND loc LIKE '%'||?||'%'";
			stmt = con.createStatement();
			// 5. 결과
			rs = stmt.executeQuery(sql);
				// while()
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.println(rs.getString("loc"));
			}
			
			// 6. 자원해제 및 기타 예외
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println();
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	
	
	// insert
	public void insertDept(Dept ins) {
		String sql = "INSERT INTO dept100 values("+ins.getDeptno()+", '"
					  +ins.getDname()+"', '"+ins.getLoc()+"')";
		System.out.println(sql); //오류 검사
		
		try {
			con = DB.con();
			con.setAutoCommit(false);		// ??
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);	// ??
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
	
	
	
	public static void main(String[] args) {
		// 객체 생성
		A03_DeptDao dao = new A03_DeptDao();
		// 부서정보 호출 기능메서드
//		dao.showDeptAll();
//		dao.deptSch(new Dept("",""));
		
		// 바로 할당
		dao.insertDept(new Dept( "회계", 12,"대전"));
		
		
	}

}
