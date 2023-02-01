package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.z03_project.vo.Pschedule;
import javaexp.z03_project.vo.Pvacation;

public class A06_Prvac {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 휴가
	// 조회
	public List<Pvacation> getPvacationList(String ename, String vacSdateS){
		List<Pvacation> vlist = new ArrayList<Pvacation>();
		
		String sql = "SELECT dname||'팀 '||ename||' '||pos worker, vacfdate, vacldate\r\n"
				+ "FROM pemp e, pvacation v, pdept d \r\n"
				+ "WHERE e.empno = v.empno\r\n"
				+ "AND e.deptno = d.deptno\r\n"
				+ "AND (ename = ?\r\n"
				+ "	 OR to_date(?,'YYYYMMDD') BETWEEN vacfdate AND vacldate) \r\n"
				+ "ORDER BY v.empno, vacfdate DESC";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, vacSdateS);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			vlist.add(new Pvacation(
					    rs.getString("worker"),
						rs.getDate("vacfdate"),
						rs.getDate("vacldate")
					));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return vlist;
		}
		
	// 휴가 등록(신청)
	public void insertPvacation(Pvacation v) {
		String sql ="INSERT INTO pvacation VALUES (?, to_date(?,'YYYY/MM/DD'), to_date(?,'YYYY/MM/DD') )\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v.getEmpno());
			pstmt.setString(2, v.getVacfdateS());
			pstmt.setString(3, v.getVacldateS());
			pstmt.executeUpdate();

			System.out.println("휴가 신청이 등록되었습니다");
//			System.out.println("휴가 등록 건수: "+pstmt.executeUpdate());
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
	
	// 휴가 수정
	public void updatePvacation(Pvacation v) {
		String sql ="UPDATE pvacation \r\n"
				+ "   SET vacfdate = to_Date(?, 'YYYY/MM/DD'),\r\n"
				+ "   	   vacldate = to_Date(?, 'YYYY/MM/DD')\r\n"
				+ " WHERE empno = ? AND TO_char(vacfdate, 'YYYYMMDD')=?\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v.getVacfdateS());
			pstmt.setString(2, v.getVacldateS());
			pstmt.setString(3, v.getEmpno());
			pstmt.setString(4, v.getVacSdateS());
			pstmt.executeUpdate();

//			System.out.println("휴가 수정 건수: "+pstmt.executeUpdate());
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
	
	
	// 휴가 삭제
	public void deletePvacation(String empno, String vacfdateS) {
		String sql ="DELETE \r\n"
				+ "FROM pvacation \r\n"
				+ "WHERE empno = ? AND TO_char(vacfdate, 'YYYYMMDD')=?\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			pstmt.setString(2, vacfdateS);
			
			pstmt.executeUpdate();
//			System.out.println("휴가 삭제 건수: "+pstmt.executeUpdate());
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
		A06_Prvac dao = new A06_Prvac();

		// 휴가
		
		// 휴가 조회
		// "이름" or "검색날짜"
		List<Pvacation> vlist = dao.getPvacationList("심직원", "");
		System.out.println("직원\t\t\t휴가시작날짜\t휴가마지막날짜");
		for(Pvacation v : vlist) {
			System.out.print(v.getWorker()+"\t");
			System.out.print(v.getVacfdate()+"\t");
			System.out.print(v.getVacldate()+"\n");
		}
		
		// 휴가 등록
//		dao.insertPvacation(new Pvacation("160312", "20211104", "20211109"));
//		dao.insertPvacation(new Pvacation("040310", "20211104", "20211109"));
//		dao.insertPvacation(new Pvacation("210312", "20221102", "20221104"));
//		
		// 휴가 수정
		// "등록할 휴가 시작날짜", "등록할 휴가 마지막날짜", "사원번호", "등록된 휴가 첫째날짜"
//		dao.updatePvacation(new Pvacation("20211105", "20211109", "160312","20211104"));
//		dao.updatePvacation(new Pvacation("20211105", "20211109", "040310","20211104"));
		
		// 휴가 삭제
		// "사원번호", "삭제할 휴가의 시작날짜"
//		dao.deletePvacation("210312", "20221102");
		
		
	}

}
