package jspexp.a14_study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jspexp.vo.ThMember;



public class A01_Login {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//로그인
	public boolean login(String id, String password){
		boolean isSuccess =false; 
		
		String sql = " SELECT 1 FROM thmember WHERE id=? AND password=? ";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery(); 
			isSuccess = rs.next(); // 해당 id, pass로 조회 될때만 true 그 외에는 false
			
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return isSuccess;
	}	
	
	
	
	//회원가입
	public void insertMember(ThMember ins) {
		String sql = "INSERT INTO THMEMBER VALUES (?, ?, ?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ins.getId());
			pstmt.setString(2, ins.getPassword());
			pstmt.setString(3, ins.getNickname());
			
			System.out.println("등록건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A01_Login dao = new A01_Login();

	}

}
