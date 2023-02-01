package javaexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.vo.Dept;
import javaexp.a13_database.vo.EmpQua;

public class A06_PreparedDao {
	// 전역변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 조회 처리
	public List<Dept> getDeptList(Dept sch){
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "SELECT * FROM dept100\r\n"
					+ "WHERE dname LIKE '%'|| ? || '%'\r\n"
					+ "AND loc LIKE '%'|| ? || '%'";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			
			// 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달
			// 1. 위 형태로 ?를 설정하는 해당 데이터 형태만 입력이 되지 sql injection이 처리되지 않는다
			// 2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는 빠르게 수행될 수 있다
			//    pstmt.setString(1번부터 ?에 해당되는 순서, 데이터);
			pstmt.setString(1, sch.getDname());
			pstmt.setString(2, sch.getLoc());
			rs = pstmt.executeQuery(); // sql을 넣지 않는다(주의)
			// select * ==> deptno, dname, loc
			while(rs.next()) {
				// select에 해당 컬럼에 맞는 컬럼명, 데이터유형에 맞게 rs.get타입("컬럼명") 지정하여야 한다
				dlist.add(new Dept(rs.getInt("deptno"),
								   rs.getString("dname"),
								   rs.getString("loc"))
						  );
			}
			
			
		} catch (SQLException e) {
			System.out.println("DB 에러"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		
		return dlist;
	}
	// transaction 에러로 제대로 등록/수정/삭제가 되지 않을 때 다시 eclipse 재부팅해서 DB도 확인하고 다시 실행한다 
	
	// 부서 정보 등록
	public void insertDept(Dept d) {
		String sql = "INSERT INTO dept100 values(?, ?, ?)";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, d.getDeptno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getLoc());
			
			System.out.println("등록건수: "+pstmt.executeUpdate());
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB 에러"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 에러: "+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 부서정보 수정
	// 10을 >> 55, 인사, 부산
	public void updateDept(int deptno, Dept upt) {
		String sql = "UPDATE dept100\r\n"
				+ "   SET deptno =?,\r\n"
				+ "   	   dname=?,\r\n"
				+ "   	   loc = ?\r\n"
				+ "WHERE deptno = ?";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt .setInt(1, upt.getDeptno());
			pstmt .setString(2, upt.getDname());
			pstmt .setString(3, upt.getLoc());
			pstmt .setInt(4, deptno);
			
			System.out.println("수정건수: "+pstmt.executeUpdate());
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB 에러"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 에러: "+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	
	// 삭제 기능메서드
	public void deleteDept(int deptno) {
		String sql = "DELETE FROM dept100\r\n"
					+ "WHERE deptno = ?";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt .setInt(1, deptno);
			
			System.out.println("삭제건수: "+pstmt.executeUpdate());
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB 에러"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 에러: "+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	
	
	//
	public List<EmpQua> getEmpQuaList(EmpQua sch){
		List<EmpQua> eqlist = new ArrayList<EmpQua>();
		String sql = "SELECT empno, ename, qm.qu'/4' qu, sal \r\n"
				+ "from emp e, ( SELECT to_char(hiredate, 'Q') qu, max(sal) msal\r\n"
				+ "			  FROM EMP\r\n"
				+ "			  GROUP BY to_char(hiredate, 'Q')\r\n"
				+ "			) qm\r\n"
				+ "WHERE to_char(hiredate, 'Q') =qu\r\n"
				+ "AND sal = msal\r\n" 
				+ "AND sal BETWEEN ? AND ?" ; // 숫자라서 null 값 괜찮음..??
		/*
		# 동적 sql
		1. sql 구문이 데이터에 따라 조건에 따라 변경되는 것을 말한다
		2. 데이터는 가능한한 ?로 처리하고 preparedStatement에 터리한다
		3. 조건문에 따른 내용은 sql조건도 처리하고
			select *
			from emp
			where 1=1
			if(sch.getEname)!=null){
				and ename like '%'||?||'%'
			}
			if(sch.getJob() !=null){
				and job like '%'||?||'%'
			}
			
			if(sch.getEname() != null) pstmt.setString(1, ...) 
			if(sch.geJob() != null) pstmt.setString(2, ...)			==> 이렇게 고정적으로 할 수 없어
			if(sch.getEname() != null) pstmt.setString(++cnt, ...) 		이렇게 변수를 사용하게 된다
			if(sch.geJob() != null) pstmt.setString(++cnt, ...)		
			
		4. pstmt부분도 조건 처리하여야 한다
		5. 특히 동적 sql이 복잡해질 때는 순서 index부분도 변수를 선언하여 처리햐여야 한다
			int cnt = 0;
			if(sch.getXXX() != null) pstmt.setString(++cnt, ...)
			if(sch.getXXX() != null) pstmt.setString(++cnt, ...)
			if(sch.getXXX() != null) pstmt.setString(++cnt, ...)
			if(sch.getXXX() != null) pstmt.setString(++cnt, ...)
		
		*/
		if(sch.getQu()!= null)
			sql	+= "AND qu = ?\r\n";
		System.out.println(sql);
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, sch.getFrSal());
			pstmt.setDouble(2, sch.getToSal());
			if(sch.getQu()!= null) {
				pstmt.setString(3, sch.getQu());
			}
			rs = pstmt.executeQuery(); // sql을 넣지 않는다(주의)
			
			while(rs.next()) {
				eqlist.add(new EmpQua(
								rs.getInt("empno"),
								rs.getString("ename"),
								rs.getString("qu"),
								rs.getDouble("sal"))
						  );
			}
			
		} catch (SQLException e) {
			System.out.println("DB 에러"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		
		return eqlist;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A06_PreparedDao dao = new A06_PreparedDao();
		
		//입력
//		dao.insertDept(new Dept(12, "총무", "부산"));
		
		//출력
		for(Dept d : dao.getDeptList(new Dept("",""))) {
			System.out.print(d.getDeptno()+"\t");
			System.out.print(d.getDname()+"\t");
			System.out.print(d.getLoc()+"\n");
		}
		
		
		// 10을 >> 55로 수정
		dao.updateDept(10, new Dept(55, "인사", "부산"));
		// 삭제
//		dao.deleteDept(55);
		
		// 복잡한 sql
		for(EmpQua eq : dao.getEmpQuaList(new EmpQua(null, 1000, 5000))){ //전체데이터
//		for(EmpQua eq : dao.getEmpQuaList(new EmpQua("1", 1000, 5000))){ // 1사분기
			System.out.print(eq.getEmpno()+"\t");
			System.out.print(eq.getEname()+"\t");
			System.out.print(eq.getQu()+"\t");
			System.out.print(eq.getSal()+"\n");
		}
		
		
		
		
		
		
		
			
		
	}

}
// ex 부서정보 등록처리(PreparedStatement)



