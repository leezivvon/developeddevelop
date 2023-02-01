package javaexp.a13_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A01_StartDBConnection {
	// 필드 선언
	private static Connection con;
	
	// 기능메서드 선언
	public static void setConnection() throws SQLException {
		// 1. 드라이버 메모리 로딩 : 직접적으로 예외 처리(연결할 때 한 번만 필요하기 때문에)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // buildpath를 인식할 수 있게끔 mapping하는 것
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류"+e.getMessage());
		}
		
		// 2. 특정 서버 접속 처리
	String info = "jdbc:oracle:thin:@localhost:1521:xe";  // 내 서버 호출한거 
	con = DriverManager.getConnection(info, "scott", "tiger");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			setConnection();
			System.out.println("접속성공");
		} catch (SQLException e) {
			System.out.println("접속오류: "+e.getMessage());
		}
	
		
	
		
		
		
	}
}
