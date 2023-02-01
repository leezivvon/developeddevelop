package javaexp.z01_homework;
/*
2022-10-13
[1단계:개념] 1. sql을 통한 데이터 처리(dao)의 핵심 단계와 핵심 소스를 기술하세요.
[1단계:코드] 2. 다음의 내용을 dao 처리를 하세요
                1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
                2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
                3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
                    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
                4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요    
                5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
                6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
                7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.

[1단계:개념] 3. 액터와 유스케이스와의 관계를 기술하세요.
[1단계:개념] 4. 유스케이스의 종류에 대하여 기술하세요.
[1단계:개념] 5. 유스케이스의 확장관계와 포함관계의 차이점을 기술하세요
[1단계:실습] 6. actor로 회원/비회원/쇼핑몰 관리자, 유즈케이스로 로그인, 회원가입, 회원관리, 물건조회, 구매, 물품등록
               유즈케이스를 작성하세요.
*/

// import java.sql.*;  // 해당 패키지 하위 클래스 모두 import
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.DB;
import javaexp.a13_database.vo2.Emp05;
import javaexp.z01_homework.vo.Emp;
import javaexp.z01_homework.vo.Emp01;
import javaexp.z01_homework.vo.Emp02;
import javaexp.z01_homework.vo.Emp03;
import javaexp.z01_homework.vo.Emp04;
import javaexp.z01_homework.vo.Emp06;
import javaexp.z01_homework.vo.Emp07;


/*
 // 1
1. sql 작성
2. vo 만들기
	- 저장할 수 잇는 단위 VO객체 선언
3. 기능메서드	
	- List 메서드 초기에 선언하고 while()를 통해서 객체 하나씩 생성해서 추가하기
	  리턴한 기능메서드와 매개변수 처리할 내용 선언  
private Connection con;	// 연결 객체
private Statement stmt;	// 대화 객체
private ResultSet rs;	// 결과 객체


//3.
엑터는 개발할 시스템 외부에 존재, 이벤트 흐름을 시작하게 하는 객체이고
유스케이스는 시스템 내부에 해당되는 단위 기능, 사용자 관점에서 시스템을 모델링한다
일반화관계이다.


//4
연관, 의존, 일반화가 있다


//5

유스케이스 사이의 포함 관계(include)는 다른 유스케이스에서 기존 유스케이스를 재사용할 수 있음을 나타내고
유스케이스 사이의 확장 관계(extend)는 기존 유스케이스에 진행 단계를 추가하여 새로운 유스케이스를 만들어내는 관계이다

확장관계는 기준 유스케이스 이후의 이벤트 흐름은 확장 유스케이스의 수행 결과에 의존하는 반면
포함관계는 포함 유스케이스의 수행 결과에 따라서 기준 유스케이스의 이벤트 흐름이 영향을 받는다

*/
/*
2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요    
5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
*/

public class A20_1013 {
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	//2 처리순서
	/*
	1. sql
	2. vo
	3. 기능메서드 선언
	4. 내용 처리
	*/
	//2-1
	public List<Emp01> getSch01(Emp01 sch){
		List<Emp01> list = new ArrayList<Emp01>();
		
		String sql = "SELECT ename, dname, sal, grade\r\n"
				+ "FROM emp e, dept d, salgrade s\r\n"
				+ "WHERE e.deptno = d.deptno\r\n"
				+ "AND sal BETWEEN "+sch.getLosal()+" AND "+sch.getHisal()+"\r\n"
				+ "AND (to_char(hiredate, 'Q') = '"+sch.getDiv()+"'\r\n"
				+ "OR dname = '"+sch.getDname()+"')";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp01 e = new Emp01( rs.getString(1),
									 rs.getString(2),
									 rs.getDouble(3),
									 rs.getInt(4)  );	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
	
	//2-2
	public void empListAllPrint() {
		
		String sql ="SELECT count( hiredate ), max(sal)\r\n"
				+ " FROM EMP\r\n"
				+ " GROUP BY TO_char( hiredate, 'YYYY')";
		
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.println(rs.getDouble("sal"));	
			}
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			if(rs != null) rs = null;
			if(stmt != null) stmt = null;
			if(con != null) con = null;
			
			DB.close(rs, stmt, con);
		}
	}
	//2-2 정답
	public List<Emp02> getEmp02List() {
		List<Emp02> list = new ArrayList<Emp02>();
		
		String sql = "SELECT TO_char(hiredate, 'YYYY') year, count(*) count, max(sal) sal\r\n"
				+ "FROM EMP\r\n"
				+ "GROUP BY TO_char(hiredate, 'YYYY')";
		
		// 1. 연결
		try {
			con = DB.con();
			// 2. 대화
			stmt = con.createStatement();
			// 3. 결과/반복문
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
					new Emp02(
						rs.getString("year"),
						rs.getInt("count"),
						rs.getDouble("sal")	
					)
				);
			}
			System.out.println("데이터 건수:"+list.size());
			// 4. 예외/자원해제
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) { // 이외 에러
			System.out.println("기타에러:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);			
		}
		return list;
	}
		
	//2-3 정답
		public List<Emp03> getEmp03List(String div) {
			if(div != null) {
				if(div.equals("") || div.equals("전체")) { // "": 공백일때
					div = "0, 1";
				}
				if(div.equals("짝")) div = "0";
				if(div.equals("홀")) div = "1";
			} else {
				div = "0, 1 ";
			}
			
			List<Emp03> list = new ArrayList<Emp03>();
			
			String sql = " SELECT  e.*, docode(div, 0, '짝', '홀') div2,\r\n"
					+ "		decode(div, 1, '50%', '100%') bonus_per, \r\n"
					+ "		round(decode(div, 1, 0.5, 1)*sal) bonus, \r\n"
					+ "		sal+round(decode(div, 1, 0.5, 1)*sal) tot	\r\n"
					+ "FROM (\r\n"
					+ "	SELECT  ename, empno, MOD(empno,2) div, sal\r\n"
					+ "	FROM EMP\r\n"
					+ "	) e\r\n"
					+ "WHERE div IN ( "+div+" )";
//			System.out.println(sql);  // 오류 확인
			// 1. 연결
			try {
				con = DB.con();
				// 2. 대화
				stmt = con.createStatement();
				// 3. 결과/반복문
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					list.add(
						new Emp03(
							rs.getString("ename"),
							rs.getInt("empno"),
							rs.getString("div2"),
							rs.getDouble("sal")	,
							rs.getString("bonus_per"),
							rs.getInt("bonus"),
							rs.getInt("totpay")		
						)
					);
				}
				System.out.println("데이터 건수:"+list.size());
				// 4. 예외/자원해제
			} catch (SQLException e) {
				System.out.println("DB에러: "+e.getMessage());
			} catch (Exception e) {
				System.out.println("기타에러:"+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);			
			}
			return list;
		}
	

	//2-4
	public List<Emp04> getSch04(Emp04 sch){
		List<Emp04> list = new ArrayList<Emp04>();
		
		String sql = "SELECT  ename,\r\n"
				+ "		FLOOR(MONTHS_BETWEEN(sysdate, hiredate)/12)||'년 '||\r\n"
				+ "		MOD(floor(MONTHS_BETWEEN(sysdate, hiredate)), 12)||'개월' \"근무연한/개월\"\r\n"
				+ "FROM emp\r\n"
				+ "WHERE to_char(hiredate, 'YYYY/MM/DD') ='"+sch.getYear()+"/"+sch.getMonth()+"/"+sch.getDate()+"'";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp04 e = new Emp04( rs.getString(1),
									 rs.getDate(2));	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
	//2-4 정답
	public List<Exp04> getExp04List(String std) {
		// 문자열을 넘길때 "2001년 01월 01일"
		List<Exp04> list = new ArrayList<Exp04>();
		
		if(std==null || std.equals("")) std = "2022/10/14";
		
		String sql = " SELECT  ename,\r\n"
				+ "		floor(mm/12)||'년 '||floor(MOD(mm, 12))||'개월' workmonth\r\n"
				+ "FROM (\r\n"
				+ "	SELECT 	ename, \r\n"
				+ "			months_between(to_date('"+std+"', 'YYYY/MM/DD'), hiredate) mm\r\n"
				+ "	FROM emp \r\n"	// '2001년 01월 01일', 'YYYY"년 "MM"월 "DD"일 "'
				+ ") e";
//			System.out.println(sql);  // 오류 확인
		// 1. 연결
		try {
			con = DB.con();
			// 2. 대화
			stmt = con.createStatement();
			// 3. 결과/반복문
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
					new Exp04(
						rs.getString("ename"),
						rs.getString("wortmonth")			
					)
				);
			}
			System.out.println("# 기준일: "+std);
			System.out.println("데이터 건수:"+list.size());
			// 4. 예외/자원해제
		} catch (SQLException e) {
			System.out.println("DB에러: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);			
		}
		return list;
	}
	
	//2-5
	public List<Emp05> getSch05(Emp05 sch){
		List<Emp05> list = new ArrayList<Emp05>();
		
		String sql = "SELECT *\r\n"
				+ "FROM EMP\r\n"
				+ "WHERE to_char(hiredate, 'Q') = (\r\n"
				+ "	SELECT to_char(hiredate, 'Q')\r\n"
				+ "	FROM EMP\r\n"
				+ "	WHERE ename = upper('"+sch.getEname()+"')\r\n"
				+ ")";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp05 e = new Emp05( rs.getInt(1),
									 rs.getString(2),
									 rs.getString(3),
									 rs.getInt(4),
									 rs.getDate(5),
									 rs.getDouble(6),
									 rs.getDouble(7),
									 rs.getInt(8));	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
	//2-5 정답
		public List<Emp> getExp05List(String ename){
			List<Emp> list = new ArrayList<Emp>();
			
			String sql = " SELECT *\r\n"
					+ "FROM EMP\r\n"
					+ "WHERE to_char(hiredate, 'Q') = (\r\n"
					+ "	SELECT to_char(hiredate, 'Q')\r\n"
					+ "	FROM EMP\r\n"
					+ "	WHERE ename = upper('"+ename+"')\r\n"
					+ ")";
			try {
				con = DB.con();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Emp e = new Emp( rs.getInt(1),
									 rs.getString(2),
									 rs.getString(3),
									 rs.getInt(4),
									 rs.getDate(5),
									 rs.getDouble(6),
									 rs.getDouble(7),
									 rs.getInt(8));	
					list.add(e);
				}
				System.out.println("데이터의 건수: "+list.size());
						
			} catch (SQLException e) {
				System.out.println("DB관련예외 :"+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외: "+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
			return list;
		}
	
	//2-6
	public List<Emp06> getSch06(Emp06 sch){
		List<Emp06> list = new ArrayList<Emp06>();
		
		String sql = "SELECT e.ename, e.deptno, e.sal\r\n"
				+ "FROM emp e, emp m\r\n"
				+ "WHERE e.mgr = m.empno\r\n"
				+ "AND m.ename = '"+ sch.getEname() +"'";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp06 e = new Emp06( rs.getString(1),
									 rs.getInt(2),
									 rs.getDouble(3));	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
	//2-6
	public List<Emp> getExp06List(String ename){
		List<Emp> list = new ArrayList<Emp>();
		
		String sql = " SELECT ename, sal, deptno \r\n"
				+ "FROM emp\r\n"
				+ "WHERE mgr IN (\r\n"
				+ "	SELECT EMPNO \r\n"
				+ "	FROM EMP \r\n"
				+ "	WHERE ename = '"+ename+"'\r\n"
				+ ")";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp e = new Emp( rs.getString("ename"),
								 rs.getDouble("sal"),
								 rs.getInt("deptno"));	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}	

	//2-7
	public List<Emp07> getSch07(Emp07 sch){
		List<Emp07> list = new ArrayList<Emp07>();
		
		String sql = "SELECT *\r\n"
				+ "FROM EMP\r\n"
				+ "WHERE deptno IN (\r\n"
				+ "	SELECT deptno\r\n"
				+ "	FROM EMP\r\n"
				+ "	WHERE TO_char(hiredate, 'MM') = '"+sch.getDiv()+"'\r\n"
				+ ")";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp07 e = new Emp07( rs.getInt(1),
									 rs.getString(2),
									 rs.getString(3),
									 rs.getInt(4),
									 rs.getDate(5),
									 rs.getDouble(6),
									 rs.getDouble(7),
									 rs.getInt(8));	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
	// 2-7 정답
	public List<Emp> getExp07List(String mm){
		List<Emp> list = new ArrayList<Emp>();
		
		String sql = " SELECT *\r\n"
				+ "FROM EMP\r\n"
				+ "WHERE deptno IN (\r\n"
				+ "	SELECT deptno\r\n"
				+ "	FROM EMP\r\n"
				+ "	WHERE TO_char(hiredate, 'MM') = '"+mm+"'\r\n"
				+ ")";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Emp e = new Emp( rs.getInt(1),
								 rs.getString(2),
								 rs.getString(3),
								 rs.getInt(4),
								 rs.getDate(5),
								 rs.getDouble(6),
								 rs.getDouble(7),
								 rs.getInt(8));	
				list.add(e);
			}
			System.out.println("데이터의 건수: "+list.size());
					
		} catch (SQLException e) {
			System.out.println("DB관련예외 :"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외: "+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}	
	

	

	

	public static void main(String[] args) {
	
		//2
		A20_1013 dao = new A20_1013();
		
		//2-1
		System.out.println("2-1");
		dao.getSch01(new Emp01("", 0, 9999, 1)); //데이터 건수만 출력
		
		//2-2
//		dao.empListAllPrint();
		//2-2 정답
		System.out.println("2-2");
		dao.getEmp02List();
		for(Emp02 e : dao.getEmp02List()) {
			System.out.print(e.getYear()+"\t");
			System.out.print(e.getCnt()+"\t");
			System.out.print(e.getSal()+"\n");			
		}
		//2-3 정답
		System.out.println("2-3");
		dao.getEmp03List("");
		for(Emp03 e : dao.getEmp03List("")) {
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getBonus_per()+"\t");
			System.out.print(e.getSal()+"\t");
			System.out.print(e.getTotpay()+"\n");			
		}
		
		//2-4
		System.out.println("2-4");
		dao.getSch04(new Emp04(1980, 12, 17));
		//2-4 정답
		System.out.println("2-3");
//		for(Exp04 e : dao.getExp04List("2001/01/01")) {
		for(Exp04 e : dao.getExp04List("")) {
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getWorkmonth()+"\n");
					
		//2-5
		System.out.println("2-5");
		dao.getSch05(new Emp05("allen")); // upper작동한닿ㅎㅎ
		//2-5정답
		System.out.println("2-5");
		dao.getExp05List("allen");
		
		//2-6
		System.out.println("2-6");
		dao.getSch06(new Emp06("BLAKE"));
		//2-6정답
		dao.getExp06List("BLAKE");
		
		//2-7
		System.out.println("2-7");
		dao.getSch07(new Emp07("3"));
		//2-7정답
		dao.getExp07List("12");
		
	
	}

}
//2-4 vo객체
class Exp04{
	private String ename;
	private String workmonth;
	public Exp04() {
		
	}
	public Exp04(String ename, String workmonth) {
		this.ename = ename;
		this.workmonth = workmonth;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getWorkmonth() {
		return workmonth;
	}
	public void setWorkmonth(String workmonth) {
		this.workmonth = workmonth;
	}
	
	
}
