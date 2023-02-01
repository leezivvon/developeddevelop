package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.z03_project.vo.Pdept;
import javaexp.z03_project.vo.Pemp;


// 부서정보 페이지  // 인사
public class A02_PrDept{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// dao 만들고 
	// 각 업무별 처리 내용 새로운 클래스 만들어서 dao 호출해서 쓰기
	
	// 조회(부서정보조회)
	public List<Pdept> getPdeptList(String dname){
		List<Pdept> dlist = new ArrayList<Pdept>();
		String sql = "SELECT d.*, nvl2(e.ct, e.ct, 0)||' 명' ctp\r\n"
				+ "FROM pdept d, ( SELECT deptno, count(deptno) ct\r\n"
				+ "			   FROM pemp \r\n"
				+ "			   GROUP BY deptno ) e\r\n"
				+ "WHERE e.deptno(+) = d.deptno\r\n"
				+ "AND dname LIKE '%'||upper(?)||'%'\r\n"
				+ "ORDER BY d.deptno";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dlist.add(new Pdept(
							rs.getInt("deptno"),
							rs.getString("dname"),
							rs.getString("loc"),
							rs.getString("ctp")		
						));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return dlist;
	}
	
	// 등록(부서정보등록)
	public void insertPdept(Pdept d) {
		String sql = "INSERT INTO pdept VALUES (?, upper(?), ?)";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, d.getDeptno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getLoc());
			pstmt.executeUpdate();
			
//			System.out.println("등록건수: "+pstmt.executeUpdate());
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
	// 삭제(부서정보전체삭제)
	public void deletePdept(int deptno) {
		String sql = "DELETE FROM pdept \r\n"
					+ "WHERE deptno = ?";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			pstmt.executeUpdate();
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
	
	// 부서이동신청결과 조회
	public List<Pemp> getPempdptno(String empno){
		List<Pemp> ednolist = new ArrayList<Pemp>();
		String sql = "SELECT empno, ename, deptno\r\n"
					+ "FROM pEMP e \r\n"
					+ "WHERE empno = ?";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ednolist.add(new Pemp(
							rs.getString("empno"),
							rs.getString("ename"),
							rs.getInt("deptno")	
						));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return ednolist;
	}
	
	
	public static void main(String[] args) {
		A02_PrDept dao = new A02_PrDept();
		
		// 부서
		// 등록
		dao.insertPdept(new Pdept(509, "디자인\t", "서울 강남구"));
		dao.insertPdept(new Pdept(510, "R&D\t", "서울 강남구"));
		// 삭제
//		dao.deletePdept(509);
//		dao.deletePdept(510);
		
	
		// 조회
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
	
		for(Pdept d : dao.getPdeptList(test)){
			System.out.print(d.getDeptno()+"\t");
			System.out.print(d.getDname()+" \t");
			System.out.print(d.getLoc()+"  \t");
			System.out.print(d.getCtp()+"\n");
		}
		
		// 부서이동신청결과 조회
		List<Pemp> ednolist = dao.getPempdptno("210315");
		Pemp edno = ednolist.get(0);
		int mydeptno = edno.getDeptno();
		System.out.println(mydeptno);
	
		
	}
}
