package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.z03_project.vo.Phrd;
import javaexp.z03_project.vo.Pschedule;

public class A09_Prhrd {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// 인사계획 현재 인원 조회
	public List<Phrd> getPhrdList1(int deptno){
		List<Phrd> hrlist = new ArrayList<Phrd>();
		
		String sql = "SELECT ce.*\r\n"
				+ "FROM ppos p, ( SELECT pos, count(pos) ct\r\n"
				+ "			   FROM pemp e\r\n"
				+ "			   WHERE deptno = ?\r\n"
				+ "			   GROUP BY pos) ce\r\n"
				+ "WHERE p.pos = ce.pos\r\n"
				+ "ORDER BY grd";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			hrlist.add(new Phrd(
					    rs.getString("pos"),
						rs.getInt("ct")
					));
		}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return hrlist;
	}
	// 인사계획 계획 인원 /총 비율 조회
		public List<Phrd> getPhrdList2(String ppyearS, int deptno){
			List<Phrd> hrlist = new ArrayList<Phrd>();
			
			String sql = "SELECT pp.deptno, bu, cha, gwa, dae, sawon, hab, \r\n"
					+ "		dgc, dgc/hab*100 per\r\n"
					+ "FROM ( SELECT deptno, count(deptno) dgc\r\n"
					+ "	   FROM pemp\r\n"
					+ "	   GROUP BY deptno ) c,\r\n"
					+ "	 ( SELECT pl.*, (bu+cha+gwa+dae+sawon) hab\r\n"
					+ "	   FROM PPERPLAN pl  ) pp\r\n"
					+ "WHERE pp.deptno = c.deptno\r\n"
					+ "AND to_char(ppyear, 'YYYY')=?\r\n"
					+ "AND pp.deptno = ?\r\n"
					+ "ORDER BY deptno";
			try {
				con = DB.con();
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ppyearS);
				pstmt.setInt(2, deptno);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
				hrlist.add(new Phrd(
						    rs.getInt("deptno"),
						    rs.getInt("bu"),
						    rs.getInt("cha"),
						    rs.getInt("gwa"),
						    rs.getInt("dae"),
						    rs.getInt("sawon"),
						    rs.getInt("hab"),
						    rs.getInt("dgc"),
						    rs.getDouble("per")
						));
			}
			} catch (SQLException e) {
				System.out.println("DB에러: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반에러: "+e.getMessage());
			} finally {
				DB.close(rs, pstmt, con);
			}
			return hrlist;
		}
	
	// 인사계획 등록
	public void insertPperplan(Phrd h) {
		String sql ="INSERT INTO pperplan VALUES (to_date(?,'YYYY'), ?, ?, ?, ?, ?, ?)\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, h.getPpyearS());
			pstmt.setInt(2, h.getDeptno());
			pstmt.setInt(3, h.getBu());
			pstmt.setInt(4, h.getCha());
			pstmt.setInt(5, h.getGwa());
			pstmt.setInt(6, h.getDae());
			pstmt.setInt(7, h.getSawon());
			
			System.out.println("인사계획 등록 건수: "+pstmt.executeUpdate());
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
		
		A09_Prhrd dao = new A09_Prhrd();
		
		
		// 인사계획 - 계획 인원 조회 
		List<Phrd> hrlist2 = dao.getPhrdList2("2021", 501);
		List<Phrd> hrlist1 = dao.getPhrdList1(501);
		Phrd h = hrlist2.get(0);  // hab, dgc, per
		int hab = h.getHab();
		int dgc = h.getDgc();
		double per = h.getPer();
		System.out.println("부서번호\t");
		System.out.println("이사/부장\t차장\t과장\t대리\t사원");
		for(Phrd hh : hrlist2) {
			System.out.print(hh.getBu()+"\t");
			System.out.print(hh.getCha()+"\t");
			System.out.print(hh.getGwa()+"\t");
			System.out.print(hh.getDae()+"\t");
			System.out.print(hh.getSawon()+"\t");
		}
		System.out.print("계획 인원 총합: "+hab+"\n");
		// 인사계획 - 현재 인원 조회
		for(Phrd hh : hrlist1) {
			System.out.print(hh.getCt()+"\t");
		}
		System.out.print("현재 인원 총합: "+dgc+"\n");
		System.out.print("\n계획인원 대비 현재인원 퍼센테이지: "+per+"%\n분석 결과 : ");
		if(per < 100) {
			System.out.print("인원 미달");
		} else if (per == 100) {
			System.out.print("적정 인원");
		} else {
			System.out.print("인원 초과");
		}
		
		// 인사계획 등록
//		dao.insertPperplan(new Phrd("2022", 501, 1, 1, 2, 4, 4 ));
		
	}
}
