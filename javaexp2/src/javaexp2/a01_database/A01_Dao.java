package javaexp2.a01_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 커넥션객체
// 객체 생성으로 호출
// ps) 전날은 static 객체생성없이 X
public class A01_Dao {
	// 1. 공통 필드
	private Connection con; // 연결 객체
	
	// 2. 접속 공통메서드
	public void setConn() throws SQLException {
		
		
		// 1) jdbc드라이버 메모리 로딩  -필수 예외(컴파일예외 처리)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 메모리로딩 성공");
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 예외: "+e.getMessage());
		}

		
		// 2) DriverManager 객체를 통해서 연결해서 Connection에 할당  -필수 예외 (위임 throws)
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("접속성공");
		
	}
		

	public static void main(String[] args) {
		// 객체 생성과 연결메서드 호출, 위임된 sql예외 처리
	
		A01_Dao dao = new A01_Dao();
		
		try {
			dao.setConn();
			
		} catch (SQLException e) {
			System.out.println("접속 에러: "+e.getMessage());
		}
	
		
	}
}
