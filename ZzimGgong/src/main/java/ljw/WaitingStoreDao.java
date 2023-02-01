package ljw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ljw.vo.WaitingStore;

public class WaitingStoreDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 대기자 정보 출력
		public WaitingStore firstWaiter(String resnum){
			WaitingStore fwlist = new WaitingStore();
			String sql = "SELECT ROWNUM, w.user_email, nickname, WSTARTTIME, "
					+ "WAITING_PERSON , WAITING_NUM\r\n"
					+ "FROM WAITING w, JJIM_USER ju \r\n"
					+ "WHERE w.USER_EMAIL = ju.USER_EMAIL\r\n"
					+ "AND resnum= ?\r\n"
					+ "AND rownum = 1\r\n"
					+ "AND cancel='F' 		\r\n"
					+ "AND enter_check='F'\r\n"
					+ "ORDER BY wstarttime";
			try {
				con = DB.con();
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, resnum);

				rs = pstmt.executeQuery();

				while(rs.next()) {
					fwlist=new WaitingStore(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getDate(4),
								rs.getInt(5),
								rs.getInt(6)
							);
				}
			}catch (SQLException e) {
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
			return fwlist;
		}
		
		// 대기자 정보출력 -시간포함 버전
		/*
		public WaitingStore firstWaiter(String resnum){
			WaitingStore fwlist = new WaitingStore();
			String sql="SELECT ROWNUM, w.user_email, nickname, WSTARTTIME, WAITING_PERSON , WAITING_NUM\r\n"
					+ "FROM WAITING w, JJIM_USER ju \r\n"
					+ "WHERE w.USER_EMAIL = ju.USER_EMAIL \r\n"
					+ "AND rownum = 1\r\n"
					+ "AND resnum= ?\r\n"
					+ "AND TO_CHAR(WSTARTTIME, 'YYYY/MM/DD')  = to_char(sysdate, 'YYYY/MM/DD')\r\n"
					+ "AND cancel='F' 		\r\n"
					+ "AND enter_check='F'\r\n"
					+ "ORDER BY wstarttime";
			try {
				con = DB.con();
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, resnum);

				rs = pstmt.executeQuery();

				while(rs.next()) {
					fwlist=new WaitingStore(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getDate(4),
								rs.getInt(5),
								rs.getInt(6)
							);
				}
			}catch (SQLException e) {
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
			return fwlist;
		}
	*/

		
		
		//입장취소
		public void cancelWStore(WaitingStore cs) {
			String sql ="UPDATE WAITING\r\n"
					+ "SET CANCEL ='T', ENTER_CHECK ='F'\r\n"
					+ "WHERE user_email=?\r\n"
					+ "AND resnum =?\r\n"
					+ "AND to_char(to_date(?, 'YYYY/MM/DD'),'YYYY/MM/DD') = "
					+ "TO_char(wstarttime,'YYYY/MM/DD')\r\n"
					+ "AND cancel='F' \r\n"
					+ "AND enter_check='F'";
			try {
				con = DB.con();
				con.setAutoCommit(false);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cs.getUserEmail());
				pstmt.setString(2, cs.getResnum());
				pstmt.setString(3, cs.getWstarttimeS());

				pstmt.executeUpdate();
				con.commit();
				
			}catch (SQLException e) {
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
	
		
		//입장완료
		public void enterWStore(WaitingStore es) {
			String sql ="UPDATE WAITING\r\n"
					+ "SET CANCEL ='F', ENTER_CHECK ='T'\r\n"
					+ "WHERE user_email=?\r\n"
					+ "AND resnum =?\r\n"
					+ "AND to_char(to_date(?, 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')\r\n"
					+ "AND cancel='F' 		\r\n"
					+ "AND enter_check='F'";
			try {
				con = DB.con();
				con.setAutoCommit(false);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, es.getUserEmail());
				pstmt.setString(2, es.getResnum());
				pstmt.setString(3, es.getWstarttimeS());

				pstmt.executeUpdate();
				con.commit();
				
			}catch (SQLException e) {
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitingStoreDao dao = new WaitingStoreDao();
	}

}
