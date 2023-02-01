package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspexp.vo.Pemp;
//import jspexp.a13_database.vo.Pjoin;

// 사원정보&입사정보		// 인사
public class A03_PrEmp {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*
	// 조회(입사정보조회_for사번조회)
	public List<Pjoin> getPjoinList(){
		List<Pjoin> jlist = new ArrayList<Pjoin>();
		String sql = "SELECT * FROM pjoin ORDER BY empno";
		
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				jlist.add(new Pjoin(
							rs.getString("empno"),
							rs.getDate("entrydate"),
							rs.getString("entrypos"),
							rs.getInt("deptno")		
						));
			}
//			System.out.println("데어터 건수: "+jlist.size());
			
			
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return jlist;
	}
	
	// 인사 - 등록(입사정보등록_사번생성)
	public void insertPjoin(Pjoin j) {
		String sql = "INSERT INTO pjoin VALUES ( substr(?, 3, 4)||pjoin_seq.nextval, \r\n"
				+ "		to_date(?, 'YYYYMMDD'), ?, ?)";
		
			
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, j.getEntrydateS1());
			pstmt.setString(2, j.getEntrydateS2());
			pstmt.setString(3, j.getEntrypos());
			pstmt.setInt(4, j.getDeptno());
			
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
	*/
	
	// 인사 - 조회(사원정보조회)
	public List<Pemp> getPempList(String ename){
		List<Pemp> elist = new ArrayList<Pemp>();
		String sql = "SELECT * \r\n"
				+ "FROM pemp\r\n"
				+ "WHERE ename LIKE '%'||?||'%'\r\n"
				+ "ORDER BY empno";
		
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				elist.add(new Pemp(
							rs.getString("empno"),
							rs.getString("ename"),
							rs.getInt("deptno"),
							rs.getString("pos"),
							rs.getDate("birthd"),
							rs.getString("address"),
							rs.getString("pass")
						));
			}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return elist;
	}
	
	// 인사 - 조회(사원정보조회)
		public List<Pemp> equalPempno(Pemp sch){
			List<Pemp> elist = new ArrayList<Pemp>();
			String sql = "SELECT * \r\n"
					+ "FROM pemp\r\n"
					+ "WHERE empno =?";
			
			try {
				con = DB.con();
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getEmpno());
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					elist.add(new Pemp(
								rs.getString("empno"),
								rs.getString("ename"),
								rs.getInt("deptno"),
								rs.getString("pos"),
								rs.getDate("birthd"),
								rs.getString("address"),
								rs.getString("pass")
							));
				}
			} catch (SQLException e) {
				System.out.println("DB에러: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 에러: "+e.getMessage());
			} finally {
				DB.close(rs, pstmt, con);
			}
			return elist;
		}
	
	
	private String getEmpno() {
		// TODO Auto-generated method stub
		return null;
	}

	// 인사 - 등록(사원정보)
		public void insertPemp(Pemp em) {
			
			String sql = "INSERT INTO pemp VALUES ( ?, ?, ?, ?,  \r\n"
					+ "	to_date(?,'YYYY/MM/DD'), ?, ?)";
			
			try {
				con = DB.con();
				con.setAutoCommit(false);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, em.getEmpno());
				pstmt.setString(2, em.getEname());
				pstmt.setInt(3, em.getDeptno());
				pstmt.setString(4, em.getPos());
				pstmt.setString(5, em.getBirthdS());
				pstmt.setString(6, em.getAddress());
				pstmt.setString(7, em.getPass());
				
				pstmt.executeUpdate();
//				System.out.println("등록건수: "+pstmt.executeUpdate());
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
		
		// 인사 - 삭제(인사정보전체삭제)(사원번호입력해서)
		//     - reference되어 있는 것들은 어떻게 하나...
			public void deletePemp(String empno) {
			
			String sql = "DELETE FROM pemp\r\n"
					+ "WHERE empno = ?";
			
			try {
				con = DB.con();
				con.setAutoCommit(false);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, empno);
				
				pstmt.executeUpdate();
//				System.out.println("삭제건수: "+pstmt.executeUpdate());
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

	// 로그인 - 비밀번호 변경
	public void changePass(String pass, String empno) {
		String sql = "UPDATE PEMP \r\n"
				+ "   SET pass = ?\r\n"
				+ " WHERE empno = ?";	
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, empno);
			
			pstmt.executeUpdate();
//			System.out.println("비밀번호변경건수: "+pstmt.executeUpdate());
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
		A03_PrEmp dao = new A03_PrEmp();
		
		// 입사정보	
		// 등록
//		dao.insertPjoin(new Pjoin("20040316", "20040316", "사원", 507)); // 진화영
//		dao.insertPjoin(new Pjoin("20090918", "20090918", "사원", 507)); // 최도일
//		dao.insertPjoin(new Pjoin("20160324", "20160324", "사원", 507)); // 오인주
//		dao.insertPjoin(new Pjoin("20180322", "20180322", "사원", 506)); // 오인경
//		dao.insertPjoin(new Pjoin("20220321", "20220321", "사원", 502)); // 홍길동 // 시험

		/*
		// 조회  ~출력
		List<Pjoin> jlist = dao.getPjoinList();
		Pjoin j = jlist.get( jlist.size()-1 ); // get(0)부터 시작

		//j.getEmpno();
		String empno = j.getEmpno();
		*/
		
		
	
		
		// 인사정보
		// 등록
		String rpass = "";
		for(int cnt=1;cnt<=6;cnt++) {
			int rword = (int)(Math.random()*76+47);
			rpass += (char)rword;
		}
		System.out.println(rpass);
//		dao.insertPemp(new Pemp(empno, "진화영", 507, "차장", "1985/04/14", "서울특별시 종로구",rpass));
//		dao.insertPemp(new Pemp(empno, "최도일", 507, "본부장", "1987/12/05", "서울특별시 용산구",rpass));
//		dao.insertPemp(new Pemp(empno, "오인주", 507, "대리", "1992/11/25", "서울특별시 용산구",rpass));
//		dao.insertPemp(new Pemp("180313", "오인경", 506, "대리", "1994/06/17", "서울특별시 용산구",rpass));
//		dao.insertPemp(new Pemp(empno, "홍길동", 501, "대리", "1992/02/03", "서울특별시 금천구",rpass)); //시험

		// 조회
		System.out.println("조회");
		for(Pemp e : dao.getPempList("홍길동")) {
			System.out.println("\""+e.getEname()+"\"님의 사원정보");
			System.out.println("사원번호\t: "+e.getEmpno());
			System.out.println("이름   \t: "+e.getEname());
			System.out.println("부서번호\t: "+e.getDeptno());
			System.out.println("현재직급\t: "+e.getPos());
			System.out.println("생년월일\t: "+e.getBirthd());
			System.out.println("거주지\t: "+e.getAddress());
			System.out.println("임시비밀번호 : "+e.getPass());
			System.out.println();
		}
		
		// 삭제
//		dao.deletePemp("040310");
		
		
		
		
		
		
		// 로그인
		// 비밀번호 변경
//		dao.changePass("password123", "180310");


	}
}
