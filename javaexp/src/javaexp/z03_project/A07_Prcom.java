package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javaexp.z03_project.vo.Pcommute;
import javaexp.z03_project.vo.Pvacation;

public class A07_Prcom {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 통근
	// 조회
	public List<Pcommute> getPcommuteList(String ename){
		List<Pcommute> clist = new ArrayList<Pcommute>();
		
		String sql = "SELECT DISTINCT cdate, c.empno, ename, \r\n"
				+ "	   nvl(to_char(arrtime, 'HH24:MM'), '0') art, \r\n"
				+ "	   to_char(leavtime, 'HH24:MM') lvt\r\n"
				+ "FROM pcommute c, pemp e\r\n"
				+ "WHERE c.empno = e.empno\r\n"
				+ "AND ename LIKE '%'||?||'%'\r\n"
				+ "ORDER BY c.empno, cdate DESC";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename );
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			clist.add(new Pcommute(
					    rs.getDate("cdate"),
						rs.getString("empno"),
						rs.getString("ename"),
						rs.getString("art"),
						rs.getString("lvt")
					));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return clist;
		}
		
	// 출근 등록
	public void insertPcommute1(String empno) {
		String sql ="INSERT INTO pcommute VALUES (?, sysdate, sysdate, null)\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			pstmt.executeUpdate();

			System.out.println("출근 시간이 등록되었습니다");
//			System.out.println("출근 등록 건수: "+pstmt.executeUpdate());
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
	
	// 퇴근 등록
	public void insertPcommute2(String empno) {
		String sql ="UPDATE pcommute\r\n"
				+ "   SET arrtime = sysdate\r\n"
				+ " WHERE empno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			pstmt.executeUpdate();
			
			System.out.println("퇴근시간이 등록되었습니다");
//			System.out.println("퇴근 등록 건수: "+pstmt.executeUpdate());
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
		
	// 출근부 수정(출근시간)
	public void updatePcommute(Pcommute c) {
		String sql ="UPDATE pcommute\r\n"
				+ "   SET arrtime = to_date(?,'YYYY/MM/DD/HH24/MI')\r\n"
				+ " WHERE empno = ? \r\n"
				+ "   AND TO_char(arrtime, 'YYYYMMDD') = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getUdArrtimeS());
			pstmt.setString(2, c.getEmpno());
			pstmt.setString(3, c.getArrtimeS());
			
			pstmt.executeUpdate();

//			System.out.println("출근부 수정 건수: "+pstmt.executeUpdate());
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
	
	// 출근 기록 삭제
	public void deletePcommute(String empno, String arrtimeS) {
		String sql ="DELETE \r\n"
				+ "FROM pcommute\r\n"
				+ "WHERE empno = ? AND TO_char(arrtime, 'YYYYMMDD')= ? \r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			pstmt.setString(2, arrtimeS);
			pstmt.executeUpdate();

//			System.out.println("출근 건수: "+pstmt.executeUpdate());
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
	
	// 출근조회-- 출근/결근/휴가 출력
	public List<Pcommute> getcvn(String empno){
		List<Pcommute> clist = new ArrayList<Pcommute>();
		
		String sql = "SELECT v.empno, cdate\r\n"
				+ "FROM pvacation v, pcommute c\r\n"
				+ "WHERE v.empno = c.empno\r\n"
				+ "AND cdate BETWEEN vacfdate AND vacldate\r\n"
				+ "AND v.empno = ?\r\n"
				+ "ORDER BY cdate DESC";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			clist.add(new Pcommute(
					    rs.getString("empno"),
						rs.getDate("cdate")
					));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return clist;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A07_Prcom dao = new A07_Prcom();
		
		// ***************질문
		// 통근 
		// 조회
		List<Pcommute> clist = dao.getPcommuteList("심직원");
		List<Pcommute> cplist = dao.getcvn("심직원");
		
		System.out.println("    날짜\t\t사원번호\t사원이름\t출근시간\t퇴근시간");
		
		for(int idx=0;idx<clist.size();idx++) {
			Pcommute c = clist.get(idx);
			System.out.print(c.getCdate()+"\t");
			System.out.print(c.getEmpno()+"\t");
			System.out.print(c.getEname()+"\t");
			System.out.print(c.getArt()+"\t");
			System.out.print(c.getLvt()+"\t");
			
					
			// 휴가 결근 출근
			if( c.getArt().equals("0") ) { // 출근시간없으면
				for(int cnt=0; cnt<cplist.size();cnt++) {
					Pcommute cp = cplist.get(cnt);
					int result = c.getCdate().compareTo( cp.getCdate());
					if( result == 0 ) {
						System.out.print("휴가\n");
					}else {
						System.out.print("결근\n");
					}
				}
			}else {
				System.out.print("출근\n");
			}
		}
		
		
//		for(Pcommute c : clist) {
//			
//			System.out.print(c.getCdate()+"\t");
//			System.out.print(c.getEmpno()+"\t");
//			System.out.print(c.getEname()+"\t");
//			System.out.print(c.getArt()+"\t");
//			System.out.print(c.getLvt()+"\t");
//		}
		
		
		
		// 출근 등록
//		dao.insertPcommute1("210314");
//		dao.insertPcommute1("210315");
		
		// 퇴근 등록
//		dao.insertPcommute2("210314");
//		dao.insertPcommute2("210315");
		
		
		// 출근부 수정
		// "수정할 시간", "사원번호", "등록된날짜"
		// 형식 : 'YYYY/MM/DD/HH24/MI', 'YYYYMMDD'
//		dao.updatePcommute(new Pcommute ("202210260830","210314","20221026"));

		// 출근기록 삭제
		// "사원번호", "삭제할 날짜" : 'YYYYMMDD'
//		dao.deletePcommute("210314","20221026");

	}

}
