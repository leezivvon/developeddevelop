package javaexp.z03_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.z03_project.vo.Pemp;
import javaexp.z03_project.vo.Phrd;

public class A10_Login {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean login(Pemp sch) {
		boolean isLogin = false;
		String sql = "SELECT * FROM pemp\r\n"
					+ "WHERE empno = ? \r\n"
					+ "AND pass= ? ";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getEmpno());
			pstmt.setString(2, sch.getPass());
			
			rs = pstmt.executeQuery();
			isLogin = rs.next();
			
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return isLogin;	
	}
	
	
	// 등급가져오기
	public List<Pemp> getgrd(String empno){
		List<Pemp> eglist = new ArrayList<Pemp>();
		
		String sql = "SELECT empno, grd, p.pos\r\n"
				+ "FROM pemp e, ppos p\r\n"
				+ "WHERE e.pos = p.pos\r\n"
				+ "AND empno = ?";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
			eglist.add(new Pemp(
					    rs.getString("empno"),
						rs.getInt("grd"),
						rs.getString("pos")
					));
		}
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러: "+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return eglist;
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A10_Login dao = new A10_Login();
		
		List<Pemp> eglist = dao.getgrd("040310");
		Pemp eg = eglist.get(0);
		int grd = eg.getGrd();
		System.out.println(grd);

	}

}
