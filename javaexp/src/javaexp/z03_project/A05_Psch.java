package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javaexp.z03_project.vo.Pemp;
import javaexp.z03_project.vo.Phrd;
import javaexp.z03_project.vo.Pschedule;

public class A05_Psch {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//스케줄 검색
	public List<Pschedule> getPscheduleList(Pschedule sch){
		List<Pschedule> schlist = new ArrayList<Pschedule>();
		
		String sql = "SELECT DISTINCT topic, schdate, sch.cemp, sch.list\r\n"
				+ "FROM PSCHEDULE ss,( SELECT  schno, count(s.empno) cemp,\r\n"
				+ "						listagg(dname||'팀 '||ename||' '||pos, ',') \r\n"
				+ "						WITHIN GROUP(ORDER BY s.empno) AS list\r\n"
				+ "					FROM PSCHEDULE s, pemp e, pdept d\r\n"
				+ "					WHERE s.empno = e.empno\r\n"
				+ "					AND d.deptno = e.deptno\r\n"
				+ "					GROUP BY schno) sch\r\n"
				+ "WHERE ss.schno = sch.schno\r\n"
				+ "AND to_char(schdate, 'YYYY')=? 	\r\n"
				+ "AND to_char(schdate, 'MM')=?\r\n"
				+ "ORDER BY schdate";

		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getSchY());
			pstmt.setString(2, sch.getSchM());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			schlist.add(new Pschedule(
					    rs.getString("topic"),
						rs.getDate("schdate"),
						rs.getString("cemp"),
						rs.getString("list")
					));
		}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return schlist;
	}
	
	// 스케줄 등록
	public void insertPschedule(Pschedule s) {
		String sql ="INSERT INTO pschedule VALUES(?, ?, to_date(?, 'YYYY/MM/DD'), ?)\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getSchno());
			pstmt.setString(2, s.getEmpno());
			pstmt.setString(3, s.getSchdateS());
			pstmt.setString(4, s.getTopic());
			
			pstmt.executeUpdate();

//			System.out.println("스케줄이 등록되었습니다");
//			System.out.println("스케줄 등록 건수: "+pstmt.executeUpdate());
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

	// 스케줄 수정
	public void updatePschedule(String updDateS, String updTopic) {
		String sql ="UPDATE PSCHEDULE\r\n"
				+ "   SET schdate = TO_date(?,'YYYY/MM/DD')\r\n"
				+ " WHERE topic LIKE '%'||?||'%'";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updDateS);
			pstmt.setString(2, updTopic);
			
			pstmt.executeUpdate();

//			System.out.println("스케줄이 수정되었습니다");
//			System.out.println("스케줄 수정 건수: "+pstmt.executeUpdate());
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
	
	// 스케줄 삭제
	public void deletePschedule(String delTopic, String delDateS) {
		String sql ="DELETE \r\n"
					+ "FROM PSCHEDULE \r\n"
					+ "WHERE topic LIKE '%'||?||'%'\r\n"
					+ "AND to_char(schdate, 'YYYYMMDD')=?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delTopic);
			pstmt.setString(2, delDateS);
			pstmt.executeUpdate();

//			System.out.println("스케줄이 삭제되었습니다.");
//			System.out.println("스케줄 삭제 건수: "+pstmt.executeUpdate());
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
		
		A05_Psch dao = new A05_Psch();
		
		// 스케줄
		// 스케줄 조회
//		System.out.println(String schY+"년");
		
		StringTokenizer st ;
	
		List<Pschedule> schlist = dao.getPscheduleList(new Pschedule("2022","10"));
		System.out.println(schlist.size());
		for(Pschedule sch : schlist ) {
			System.out.println(sch.getSchdate()+" 스케줄");
			System.out.println("안건\t| "+sch.getTopic());
			System.out.println("참여인원\t| "+sch.getCemp()+" 명")	;
			System.out.print("참여명단\t| ");
			st = new StringTokenizer(sch.getList(),",");
			while(st.hasMoreTokens()) {
				System.out.print(st.nextToken()+"\n\t  ");
			}
			System.out.println();
		}	
		

		// 등록
//		dao.insertPschedule(new Pschedule("PD001", "060310", "20220919", "홍보영양팀, 제조팀 1차 회의"));
//		dao.insertPschedule(new Pschedule("PD001", "050310", "20220919", "홍보영양팀, 제조팀 1차 회의"));
//		dao.insertPschedule(new Pschedule("PD001", "200910", "20220919", "홍보영양팀, 제조팀 1차 회의"));

		// 수정 -날짜변경
		// 회의 주제로 찾아서, 날짜 변경
//		dao.updatePschedule("20220921", "홍보영양팀, 제조팀 1차 회의");
		
		// 삭제
		// 회의 주제랑 날짜 모두 일치하면 삭제
//		dao.deletePschedule("홍보영양팀, 제조팀 1차 회의", "20220921");
		

	}
}
