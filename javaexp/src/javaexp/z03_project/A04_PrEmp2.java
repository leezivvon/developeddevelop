package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.z03_project.vo.Pemp;
import javaexp.z03_project.vo.Ppfapp;
import javaexp.z03_project.vo.Pretire;

// 부서이동&인사평가&비밀번호변경&퇴사  //인사
public class A04_PrEmp2 {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
		
	// 인사 - 부서이동신청
	public void movePdept(int deptno, String empno) {	
		String sql = "UPDATE PEMP \r\n"
				+ "	SET deptno = ?\r\n"
				+ "	WHERE empno = ?";	
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, empno);
			pstmt.executeUpdate();

//			System.out.println("부서이동건수: "+pstmt.executeUpdate());
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB 에러: "+e.getMessage());
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
	
	
	// 인사 - 인사평가 조회
	public List<Ppfapp> getPpfappList(String empno){
		List<Ppfapp> pflist = new ArrayList<Ppfapp>();
		String sql = "SELECT pfapdate, dname, pos, ename, prresult, impinfo\r\n"
				+ "FROM pemp e, ppfapp pf, pdept d \r\n"
				+ "WHERE e.deptno = d.deptno \r\n"
				+ "AND e.empno = pf.EMPNO \r\n"
				+ "AND e.empno = ?";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pflist.add(new Ppfapp(
							rs.getDate("pfapdate"),
							rs.getString("dname"),
							rs.getString("pos"),
							rs.getString("ename"),
							rs.getString("prresult"),
							rs.getString("impinfo")
						));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return pflist;
	}
	
	// 인사 - 인사평가 등록
	public void insertPpfapp(Ppfapp pf) {	
		String sql = "INSERT INTO ppfapp VALUES (?, sysdate, ?, ?, ?)";	
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pf.getEmpno());
			pstmt.setDouble(2, pf.getPfapscore());
			pstmt.setString(3, pf.getPrresult());
			pstmt.setString(4, pf.getImpinfo());
			
			pstmt.executeUpdate();
//			System.out.println("인사평가등록건수: "+pstmt.executeUpdate());
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
	
	
	//인사 - 퇴사검색
	public List<Pretire> getPretireList(){
		List<Pretire> rtlist = new ArrayList<Pretire>();
		String sql = "SELECT e.empno, ename, dname, pos, entrydate, retiredate, address, retirereason, ph\r\n"
				+ "FROM pemp e, pdept d, pretire rt, pjoin j\r\n"
				+ "WHERE e.empno = rt.empno\r\n"
				+ "AND e.deptno = d.deptno\r\n"
				+ "AND e.empno = j.empno\r\n"
				+ "AND rt.empno = j.empno";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rtlist.add(new Pretire(
							rs.getString("empno"),
							rs.getString("ename"),
							rs.getString("dname"),
							rs.getString("pos"),
							rs.getDate("entrydate"),
							rs.getDate("retiredate"),
							rs.getString("address"),
							rs.getString("retirereason"),
							rs.getString("ph")
						));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return rtlist;
	}
	
	// 인사 - 퇴사등록
	public void insertPretire(Pretire rt) {	
		String sql = "INSERT INTO pretire VALUES (?, to_date(?, 'YYYY/MM/DD'), "
				+ "?, ?)\r\n"
				+ "";	
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rt.getEmpno());
			pstmt.setString(2, rt.getRetiredateS());
			pstmt.setString(3, rt.getRetirereason());
			pstmt.setString(4, rt.getPh());
			
			pstmt.executeUpdate();

//			System.out.println("퇴사등록건수: "+pstmt.executeUpdate());
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
	

	
	public static void main(String[] args) {
	
		A04_PrEmp2 dao = new A04_PrEmp2();
		
		// 부서이동 
//		dao.movePdept(507, "180310");
			
		
		// 인사평가
		// 조회
		System.out.println("  평가날짜\t\t    부서명/사원명\t\t    개인성과\t   업무개선사항\n");
		for(Ppfapp pf : dao.getPpfappList("210315")) {
			System.out.print(pf.getPfapdate()+"\t");
			System.out.print(pf.getDname()+"팀 ");
			System.out.print(pf.getPos()+" ");
			System.out.print(pf.getEname()+"\t");
			System.out.print(pf.getPrresult()+"\t");
			System.out.print(pf.getImpinfo()+"\n");		
		}
		//등록
//		dao.insertPpfapp(new Ppfapp("사원번호", 4.5, "하반기프로젝트매출액증가", "꼼꼼한업무처리"));

	
		
		// 퇴사정보
		// 검색
		System.out.println("사원번호\t사원명\t   소속팀/직급\t   입사일\t\t퇴직일\t    주소\t\t퇴직사유\t\t연락처\n");
		for(Pretire rt : dao.getPretireList()) {
			System.out.print(rt.getEmpno()+"\t");
			System.out.print(rt.getEname()+"\t");
			System.out.print(rt.getDname()+"팀 ");
			System.out.print(rt.getPos()+"\t");		
			System.out.print(rt.getEntrydate()+"   ");		
			System.out.print(rt.getRetiredate()+"\t  ");		
			System.out.print(rt.getAddress()+"\t");		
			System.out.print(rt.getRetirereason()+"\t    ");		
			System.out.print(rt.getPh()+"\n");		
		}
		
		// 등록
//		dao.insertPretire(new Pretire("사원번호", 퇴사일, "퇴사사유", "핸드폰번호"));


		
		
	}

}
