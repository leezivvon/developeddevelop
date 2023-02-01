package javaexp.z04_semiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.z04_semiproject.vo.Pboard;

public class A02_Board {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//게시판 생성
	public void crtPboard(Pboard b){
		String sql="INSERT INTO pboard VALUES (?, 'a2'||pboard_seqa2.nextval, ?, ?, sysdate)\r\n"
				+ "";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getId());
			pstmt.setString(2, b.getBtitle());
			pstmt.setString(3, b.getNotice());
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
	
	//게시판 생성-게시글생성전작업_게시판의게시글시퀀스
	public List<Pboard> getBno(){
		List<Pboard> blist = new ArrayList<Pboard>();
		String sql="SELECT * FROM PBOARD ORDER BY crdate\r\n"
				+ "";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				blist.add(new Pboard(
							rs.getString("id"),
							rs.getString("bno"),
							rs.getString("btitle"),
							rs.getString("notice"),
							rs.getDate("crdate")
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
		return blist;
	}
	
	public void crtPpostSeq(String boardseq){
		String sql="CREATE SEQUENCE ? \r\n"
				+ "INCREMENT BY 1\r\n"
				+ "START WITH 1\r\n"
				+ "MINVALUE 1\r\n"
				+ "MAXVALUE 999";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardseq);
			
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
	public boolean eqlbname(Pboard b) {
		
		boolean iseql = false;
		String sql="SELECT * FROM pboard WHERE btitle=?";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getBtitle());
			
			rs=pstmt.executeQuery();
			iseql= rs.next();
			
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
		return iseql;
	}
	
	
	//게시판 수정
	public void udtPboard(Pboard b){
		String sql="UPDATE PBOARD \r\n"
				+ "   SET notice = ?\r\n"
				+ " WHERE btitle = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getNotice());
			pstmt.setString(2, b.getBtitle());
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
	
	//게시판 삭제
	public void dltPboard(String btitle){
		String sql="DELETE FROM pboard WHERE BTITLE=?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, btitle);

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
	

	// 게시판 조회
	public List<Pboard> getPboardList(String btitle){
		List<Pboard> blist = new ArrayList<Pboard>();
		String sql="SELECT b.bno, btitle, notice, cb\r\n"
				+ "FROM PBOARD b, ( SELECT bno, count(bno) cb\r\n"
				+ "				 FROM PPOST\r\n"
				+ "				 GROUP BY bno) c\r\n"
				+ "WHERE b.bno(+) = c.bno\r\n"
				+ "AND   BTITLE LIKE '%'||?||'%'\r\n"
				+ "ORDER BY cb desc";
		try {
			con = DB.con();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, btitle);

			rs=pstmt.executeQuery();
			while(rs.next()) {
				blist.add(new Pboard(
							rs.getString("bno"),
							rs.getString("btitle"),
							rs.getString("notice"),
							rs.getInt("cb")
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
		return blist;
	}
	
	
	
	
	

	public static void main(String[] args) {
		A02_Board dao = new A02_Board();
	
		Scanner sc = new Scanner(System.in);
		
		// 맛집게시판 만들기
//		System.out.println("id입력");
//		String testid= sc.nextLine();
//		
//		for( Pboard b01 : dao.getBno()) {
//			
//			System.out.println("게시판이름입력");
//			String testbaordname= sc.nextLine();
//			if(!testbaordname.equals(b01.getBno())) {
//				System.out.println("공지입력");
//				String testnotice= sc.nextLine();
//				
//				// 게시판 생성
//				dao.crtPboard(new Pboard(testid, testbaordname, testnotice));
//				List<Pboard> blist = dao.getBno();
//				Pboard bb = blist.get( blist.size()-1 );
//				String bno = bb.getBno();
//				dao.crtPpostSeq("ppost_seq"+bno);
//				break;
//			}else{
//				continue;
//			}
//		}
		
//		Pboard bname = new Pboard();
//		boolean isTrue = true;
//		
//		System.out.println("id입력");
//		String testid= sc.nextLine();	
//		do {
//			
//			System.out.println("게시판이름입력");
//			String testbaordname= sc.nextLine();
//			bname.setBtitle(testbaordname);
//			
//			if(!isTrue) {
//				System.out.println("공지입력");
//				String testnotice= sc.nextLine();
//				// 게시판 생성
//				dao.crtPboard(new Pboard(testid, testbaordname, testnotice));
//				List<Pboard> blist = dao.getBno();
//				Pboard bb = blist.get( blist.size()-1 );
//				String bno = bb.getBno();
//				dao.crtPpostSeq("ppost_seq"+bno);
//			}else {
//				System.out.println("이미 생성된 게시판 입니다 다시 입력하세요");
//			}
//			
//		}while( dao.eqlbname(bname) );
	

			
	
		System.out.println("id입력");
		String testid= sc.nextLine();
		System.out.println("게시판이름입력");
		String testbaordname= sc.nextLine();
		System.out.println("공지입력");
		String testnotice= sc.nextLine();
		
		// 게시판 생성
		dao.crtPboard(new Pboard(testid, testbaordname, testnotice));
		
//		List<Pboard> blist = dao.getBno();
//		Pboard bb = blist.get( blist.size()-1 );
//		String bno = bb.getBno();
//		dao.crtPpostSeq(bno);
		
		// 게시판 공지 수정
//		dao.udtPboard(new Pboard("공지", "게시판이름"));
		
		// 게시판 삭제
//		dao.dltPboard("게시판 이름");
		
		// 게시판 조회
		System.out.println("게시판 번호  게시판 이름");
		for(Pboard b : dao.getPboardList("게시판")) {
			System.out.print("  "+b.getBno()+"\t   ");
			System.out.print(b.getBtitle()+"\n");
		}
		
		
	}
}
