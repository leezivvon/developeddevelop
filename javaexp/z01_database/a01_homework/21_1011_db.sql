/*
2022-10-11
[1단계:코드] 1. 직책별 최저급여의 사원정보(사원명, 직책명, 급여)를 inline view를 통해서 출력하세요. 
[1단계:개념] 2. 수정의 기본형식과 SUBQUERY(단일열/다중열) 형식을 예제를 통하여 기술하세요.
[1단계:코드] 3. EMP10의 3/4분기 최고급여를 7521 사원의 급여로 수정하세요.
[1단계:코드] 4. emp10 부서별 최저 급여자를 삭제 처리하세요.
[1단계:개념] 5. DB 서버 접속을 위한 프로젝트(자바프로그램단위) 설정할 내용에 대하여 기술하세요.
[1단계:개념] 6. jdbc는 어떤 역할을 하는지 기술하세요. 
[1단계:개념] 7. 자바의 DB처리 순서를 코드와 함께 기술하세요.
[1단계:개념] 8. DB 접속시, 필요한 예외 처리의 내용 처리방법을 기술하세요.
[1단계:실습] 9. javaexp2프로젝트를 만들어, javaexp2.a01_database 패키지와 A01_Dao.java를 만들어 연결처리하세요. 
                처리한 내용캡쳐하시고, java 소스 코드를 text를 붙여주세요.
*/

--1
-- inline view : 테이블 선언 대신에 sql을 통해서 가상의 테이블을 만들어 
--				 기존 테이블 또는 다른 inline view를 만들어서 조인을 하여 데이터를 처리하는 목적으로 사용한다 
SELECT *
FROM EMP e, ( SELECT job, min(sal) msal
   			  FROM EMP
			  GROUP BY job) js
WHERE e.job = js.job
AND e.sal = js.msal;


--2
-- alter/modify는 컬럼 수정
-- update 데이터수정
UPDATE EMP10 
SET sal = (
	SELECT avg(sal)
	FROM EMP10
	WHERE job='SALESMAN'
)
WHERE empno = 7499;

--3
SELECT * FROM emp10;
UPDATE emp10
SET sal = (
	SELECT max(sal)
	FROM EMP10
	WHERE to_char(hiredate, 'Q') ='3'
)
WHERE empno = 7521;

--4
DELETE 
FROM EMP10
WHERE sal in (
	SELECT min(sal)
	FROM EMP10
	GROUP BY deptno
);

--5 ...??
/*
DB서버에 Client는 jdbc드라이버 설정, 아이디, 패스워드,
서버 주소, port, DB명, 계정, 비번으로 접속을 할 수 있다

*****
1) jdbc드라이버 다운로드
2) 메모리 로딩을 위한 build path 설정: classpath
*/

--6
/*
jdbc 
- 드라이버 프로그램 path 잡기
- 각 DB서버 회사에서 데이터베이스 연결 및 처리 관련 공통부분을 java로 만들어 클래스로 압축한 내용을 가지고 있다
  현재 프로젝트에서 진행할 수 있도록 classPath 추가 설정
  
*****
- 각 밴드(소프트웨어 회사)에서 DB서버를 위해 만들어진 공통 프로그램을 
  컴파일된 class만 패키지별로 압축해서 지원하는 프로그램을 말한다. java database connection
- DB 연결시 프로그래밍이나 툴에서 사용한다.
- @@.jar은 jre환경이 설정된 곳에서 여러 프로그램을 실행할 수 있다.
- 윈도우 프로그램의 vc++의 exe, bat 파일과 유사하다.

*/

--7.
/*
 자바의 DB처리 기능 객체별 처리 순서에 대한 이해
	1) database 서버 접속 객체	
	2) 전역변수로 위 핵심 객체를 선언
	3) 기능별 메서드 선언

package javaexp.패키지명;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class 클래스이름 {

	// 필드 선언
	private static Connection con;		// database 서버 접속 & 전역변수로 핵심 객체를 선언 	
										// 	-사용객체 : 연결객체Connection
	
	// 기능메서드 선언
	
	public static void setConnection() throws SQLException {  // DB연결을 위한 기본 기능메서드
		// 1. 드라이버 메모리 로딩 : 직접적으로 예외 처리(연결할 때 한 번만 필요하기 때문에)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // class.forName("메인클래스")를 통해서 메모리에 로딩
															   // jdbc드라이버를 메모리에 로딩
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류"+e.getMessage());
		}
		
		// 2. 특정 서버 접속 처리
	String info = "jdbc:oracle:thin:@localhost:1521:xe";  // 내 서버 호출한거 
	con = DriverManager.getConnection(info, "scott", "tiger"); // DriverManager: getConnection("접속정보", "계정", "비번")
															   // driver ==> 특정한 연결과 mapping
		
	}
	
	
	// 메인 메서드
	public static void main(String[] args) {
		try {
			setConnection();  // DB연결을 위한 기본 기능메서드
			System.out.println("접속성공");
		} catch (SQLException e) {
			System.out.println("접속오류: "+e.getMessage());
		}
	
	
	}
}

*/
-- 8
/*
- Class.forName() : 컴파일예외 처리
	직접적으로 예외 처리(연결할 때 한 번만 필요하기 때문에) try{}catch
- DriverManager.getConnection(info, "scott", "tiger");
    연결 정보 SQLException : 컴파일예외 처리, throws로 예외를 위임 처리
*/

--9
