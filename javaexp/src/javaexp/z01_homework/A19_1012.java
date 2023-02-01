package javaexp.z01_homework;
/*
2022-10-12
[1단계:개념] 1. 데이터베이스의 연결 공통 객체 생성에 필요한 객체들과 정보를 소스를 통해 설명하세요.
[1단계:개념] 2. select문을 통해서 데이터를 가져와서 출력할려고 한다. 객체들간의 연관관계를 기술하세요.
[1단계:코드] 3. 부서별 최고 급여자를 sql를 만들고 이것을 출력하는 기능메서드를 만들고 출력처리하세요.
[1단계:개념] 4. ResultSet 객체의 기능메서드를 기능별로 분류하여 기술하세요.
[1단계:개념] 5. Dao의 자원해제 순서와 방법을 기술하세요
[1단계:순서] 6. 검색조건에 대한 dao 처리를 위하여 처리되는 순서를 기술하세요.
[1단계:코드] 7. salgrade테이블을 등급별, 급여별 데이터를 검색할려고 한다. Dao에 추가하여 처리하세요.
[1단계:코드] 8. select deptno, empno, ename, job, sal 
         from emp01 where sal between @@@ and @@#
      를 처리할려고 한다. VO를 만들고 ArrayList<VO>로 리턴한 결과를 처리하세요.
== 평가대비(자바) 객관식 문제 ==
1. 
1) Connection 	// 연결객체  
2) Statement	// 대화 객체
3) Result      	// 결과 객체
4) Sql 
정답:4

2. 데이터베이스 처리시 처리할 예외 ?
1) NullPointerException  2) NumberFormatException
3) SQLException      4) 
정답:3

*/

import java.sql.Connection;	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaexp.a13_database.DB;
import javaexp.z01_homework.vo.Emp;	


// 2
/*
드라이버 메모리로딩 
==> 특정서버에 접속 DriverManager 
==> 연결객체 Connection 
==> 서버와 대화(sql) Statement   선택적 처리 	==> 등록/수정/삭제 ==> 서버에 데이터를 처리 ==> commit, rollback
										==> 조회(select) ==> 서버에서 sql결과를 ResultSet을 통해 전달
*/

//4
/*
ResultSet : next() - 행단위로 이동 처리
			getXXXX("컬럼명")	- 열단위에 데이터유형에 맞게 접근  
			   XXXX : 데이터 유형
				char/varchar2() ==> String
				number() ==> int/double
				date 	 ==> Date	
while문 사용해서 출력				
*/

//5
/*
Dao의 자원해제는 제일마지막에 생성 ==> 가장 최초 생성된 순으로
방법1)
rs.close();
stmt.close();
con.close();

방법2)
DB.close(rs, stmt, con);

+ 방법) 중간에 예외가 발생해서 자원해제가 안되는 경우 고려
} catch (SQLException e) {
	System.out.println("SQL처리에러: "+e.getMessage());
} catch (Exception e) {
	System.out.println("기타 예외 처리: "+e.getMessage());
} finally { // 예외 여부에 상관없이 처리할 내용
	if(rs!=null) rs = null;
	if(stmt!=null) stmt = null;
	if(con!=null) con = null;
}
*/
//6


public class A19_1012 {
	//1
	private Connection con;	// 연결 객체
	private Statement stmt;	// 대화 객체
	private ResultSet rs;	// 결과 객체
	
	//7
	public void empSchList(int losal, int hisal){
	
		//3
//	public void empSchList(Emp sch){
		/*
		try {
			// 3
			con = DB.con();
			
			String sql = "  SELECT   empno,  ename,  deptno,  sal \r\n "
					+ "   FROM  EMP01 \r\n "
					+ "   WHERE  (deptno,  sal)  IN  ( \r\n"
					+ "	  SELECT "+sch.getDeptno()+",  max ( "+sch.getSal()+"  ) \r\n"
					+ "	  FROM    EMP01 \r\n"
					+ "	  GROUP BY "+sch.getDeptno()+" \r\n"
					+ " ); \r\n"
					+ "";
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("empno")+"\t");
				System.out.print(rs.getInt("ename")+"\t");
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.println(rs.getInt("sal"));
			}
			
			DB.close(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("DB처리 예외: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외: "+e.getMessage());
		}
	}
	*/
		
	//7 7. salgrade테이블을 등급별, 급여별 데이터를 검색할려고 한다. Dao에 추가하여 처리하세요.
	
		try {
			con = DB.con();
			
			String sql = "SELECT ename, s.grade, sal\r\n"
					+ "FROM emp01 e, SALGRADE s\r\n"
					+ "WHERE sal BETWEEN "+losal+" AND"+ hisal;
			stmt = con.createStatement();
			
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getInt("s.grade")+"\t");
				System.out.print(rs.getInt("sal")+"\t");
				System.out.print(rs.getInt("losal")+"\t");
				System.out.print(rs.getInt("hisal")+"\t");
			}
			
			DB.close(rs, stmt, con);
			
		} catch (SQLException e) {
			System.out.println("DB처리 예외: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외: "+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		
		A19_1012 dao = new A19_1012();
		//3
//		dao.empSchList(new Emp(1000000, "",1000000 ,1000000));
		//7
		dao.empSchList(9999,9999);
		
		// 8. select deptno, empno, ename, job, sal from emp01 where sal between @@@ and @@#
		  //    를 처리할려고 한다. VO를 만들고 ArrayList<VO>로 리턴한 결과를 처리하세요.
	
		

	}

}
