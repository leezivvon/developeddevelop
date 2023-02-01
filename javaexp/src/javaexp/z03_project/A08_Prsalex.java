package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.z03_project.vo.Pcommute;
import javaexp.z03_project.vo.Psalexp;

public class A08_Prsalex {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 급여
	// 조회
	public List<Psalexp> getPsalList(String empno){
		List<Psalexp> slist = new ArrayList<Psalexp>();
		
		String sql = "SELECT DISTINCT dname||'팀 '||ename||' '||pos ef, sal, sal*12 ysal\r\n"
				+ "FROM pemp e, psal s, pdept d, pcommute c\r\n"
				+ "WHERE e.empno = s.empno\r\n"
				+ "AND e.deptno = d.deptno\r\n"
				+ "AND e.empno = c.empno\r\n"
				+ "AND c.empno = s.empno\r\n"
				+ "AND e.empno=?";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno );
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			slist.add(new Psalexp(
					    rs.getString("ef"),
						rs.getInt("sal"),
						rs.getInt("ysal")
					));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return slist;
		}
		
	// 등록
	public void insertPsal(String empno, int sal, int sevpay) {
		String sql ="INSERT INTO psal VALUES (?, ?, ?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			pstmt.setInt(2, sal);
			pstmt.setInt(3, sevpay);
			
			System.out.println("급여 등록 건수: "+pstmt.executeUpdate());
			con.commit();
			
			
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
			try {
				con.rollback();
			} catch(SQLException e1) {
				System.out.println("rollback 에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러 :"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);		
		}
	}
	
	// 수정
	public void updPsal(int sal, String empno) {
		String sql ="UPDATE psal\r\n"
				+ "   SET sal = ?\r\n"
				+ " WHERE empno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sal);
			pstmt.setString(2, empno);
			
			System.out.println("급여 변동 건수: "+pstmt.executeUpdate());
			con.commit();
				
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
			try {
				con.rollback();
			} catch(SQLException e1) {
				System.out.println("rollback 에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러 :"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);		
		}
	}
	
	
	// 수당
	// 조회
	public List<Psalexp> getPextrapayList(String ename, String schexpno){
		List<Psalexp> exlist = new ArrayList<Psalexp>();
		
		String sql = "SELECT  expkind, sum(extrapay) summ\r\n"
				+ "FROM pemp e, pextrapay ex\r\n"
				+ "WHERE e.empno= ex.empno\r\n"
				+ "AND ename =?\r\n"
				+ "AND substr(expno, 3, 2)  = ?\r\n"
				+ "GROUP BY expkind ";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename );
			pstmt.setString(2, schexpno );
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			exlist.add(new Psalexp(
					    rs.getString("expkind"),
						rs.getInt("summ")
					));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return exlist;
		}
	
	// 수당 등록(신청)
	public void insertPextrapay(Psalexp se) {
		String sql ="INSERT INTO pextrapay VALUES (?, ?, ?, ?)\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, se.getEmpno());
			pstmt.setString(2, se.getExpno());
			pstmt.setString(3, se.getExpkind());
			pstmt.setInt(4, se.getExtrapay());
			
			System.out.println("수당 등록 건수: "+pstmt.executeUpdate());
			con.commit();
				
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
			try {
				con.rollback();
			} catch(SQLException e1) {
				System.out.println("rollback 에러: "+e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러 :"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);		
		}
	}

	public static void main(String[] args) {
		A08_Prsalex dao = new A08_Prsalex();
		
		// 급여
		
		// 등록
		// "사원번호", 월급여, 퇴직금
//		dao.insertPsal("200910", 450, 2000) ;
				
		// 수정
		// 인상된급여/삭감된급여, "사원번호"
//		dao.updPsal(500, "200910");
		
		// 조회
		List<Psalexp> slist = dao.getPsalList("210315");
		for(Psalexp s : slist) {
			System.out.println("_ "+s.getEf()+"의 급여조회 결과 _");
			System.out.print("     월급 : "+s.getSal()+"\t");
			System.out.println(" 연봉 : "+s.getYsal()+"\n");			
		}
		
		
		
		// 수당
		
		// 등록(신청)
		// "사원번호", "수당번호(날짜220101)", "야간근로 수당", 수당
//		dao.insertPextrapay(new Psalexp("210313", "220908", "명절수당", 150));
		
		// 조회  
		// "직원이름", "수당받은 달"
		List<Psalexp> exlist = dao.getPextrapayList("심직원", "09");
		System.out.println("심직원의 09월 수당 검색 결과 ");
		System.out.println();
		System.out.println("수당종류\t수당액");
		System.out.println("------\t----");
		for(Psalexp ex : exlist) {
			System.out.print(ex.getExpkind()+"  ");
			System.out.println(+ex.getSumm());
		}
		

	}

}
