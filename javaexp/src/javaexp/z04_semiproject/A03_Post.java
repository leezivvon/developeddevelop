package javaexp.z04_semiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.z04_semiproject.vo.Pboard;
import javaexp.z04_semiproject.vo.Ppost;

public class A03_Post {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 비밀게시판 게시글 작성
	// 게시판 메소드 다시 작성 필요
	public void wrtPpost(Ppost p){
		String sql="INSERT INTO ppost VALUES (?, ?, 'a2002'||ppost_seq002.nextval,\r\n"
				+ "	?, sysdate, 0)";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getBno());
			pstmt.setString(3, p.getPcont());
			
			pstmt.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB에러"+e.getMessage());
			try {
				con.rollback();
			}catch(SQLException e1) {
				System.out.println("rollback에러:"+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}	
	}
	
	// 게시글 수정
	
	// 게시글 조회
	public List<Ppost> getPpostList(String schbtitle){
		List<Ppost> plist = new ArrayList<Ppost>();
		String sql="SELECT btitle, pcontents, wtime, likecnt \r\n"
				+ "FROM ppost p, pboard b \r\n"
				+ "WHERE p.bno=b.bno\r\n"
				+ "AND btitle LIKE '%%'||?||'%%'\r\n"
				+ "ORDER BY wtime desc";
		try {
			con = DB.con();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, schbtitle);

			rs=pstmt.executeQuery();
			while(rs.next()) {
				plist.add(new Ppost(
							rs.getString("btitle"),
							rs.getString("pcontents"),
							rs.getDate("wtime"),
							rs.getInt("likecnt")
						));
			}
		} catch (SQLException e) {
			System.out.println("DB에러"+e.getMessage());
			try {
				con.rollback();
			}catch(SQLException e1) {
				System.out.println("rollback에러:"+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return plist;
	}
	
	

	public static void main(String[] args) {
		
		A03_Post dao = new A03_Post();

		Scanner sc = new Scanner(System.in);
		// 비밀게시판 작성
		String scrBoard = "a2002";
		System.out.print("비밀게시판 작성_(작성하기 입력) ");
		String write = sc.nextLine();
		if(write.equals("작성하기")) {
			System.out.print("아이디입력_ ");
			String id = sc.nextLine();
			System.out.print("내용입력_ ");
			String contents = sc.nextLine();
			
			dao.wrtPpost(new Ppost(id, scrBoard, contents));
		}else {
			System.out.println("작성취소");
		}
		
		System.out.println("\n\n");
		// 특정게시판 게시글 조회
		System.out.println("특정게시판 게시글 조회----");
		System.out.print("게시판이름 입력_ ");
		String schbrd = sc.nextLine();
		System.out.println("\n--"+schbrd+"게시판--");
		for(Ppost p : dao.getPpostList(schbrd)) {
			System.out.println("______________________________________________________________________");
			System.out.println(p.getPcont());
			System.out.print(p.getWTime()+"\t");
			System.out.print("♥ "+p.getLikecnt()+"\n");
			
		}
		
		
		
	}

}
