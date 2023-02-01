SELECT * FROM emp;
-- ex1) 부서번호를 조건으로 부서번호, 사원명, 직책명, 급여를 출력하세요
--		 sql 작성 ==> vo작성 == > 기능메서드 선언(A04_DaoExp.java)

SELECT deptno, ename, job, sal
FROM emp
WHERE deptno=10;
-- select : List<VO>
-- where은 매개변수
-- type과 이름 결정
/*
 **select를 위한 것
private int deptno;
private String ename;
private String job;
private double sal;

**where조건문에는 deptno만 있다
그냥 통합해서 쓰자!! 옼네?


 ex) 기능 메서드 선언 : 리턴값, 매개변수, 기본 객체 생성
 리턴값은 select ==> VO ==> List<VO>
 매개변수 where ==> VO/int
public List<Emp01> getSch01(){//메서드는 내 마음대로 
 }
public List<Emp01> getSch01(Emp01 sch){//메서드는 내 마음대로 
 }
public List<Emp01> getSch01(int deptno){//메서드는 내 마음대로 
 	List<Emp01> list = new ArrayList<Emp01>();
 	return list;
 }

*/
--사원명(키워드검색), 급여(시작~끝)으로 조건으로 사원번호, 사원명, 급여를 출력하세요
SELECT empno, ename, sal
FROM EMP
WHERE ename LIKE ''||'A'||'%'
AND sal BETWEEN 1000 AND 2000;
/*
vo 객체
--select, where 조건 모두 들어가 있음
private int empno;
private String ename;
private double sal;
private int frSal;
private int toSal;



select에 들어가는게 여러개
>>

기능메서드
1. 리턴유형 >>여러개
2. 매개변수 >> vo객체 만드었으니 그걸 쓰겠다 >> Emp02 sch
private List<Emp02> getSch02(Emp02 sch){
	List<Emp02> list = new ArrayList<Emp02>();
	
	return list;
}
*/

-- ex 직책(키워드검색) 또는 부서번호를 조건으로 사원번호, 사원명, 직책명, 부서번호를 검색하세요
-- 1) sql 작성
-- 2) vo 작성
-- 3) 기능메서드 작성

SELECT empno, ename, job, deptno
FROM emp
WHERE job LIKE '%'||'A'||'%'  --키워드 검색
OR deptno = 10;
/*
 
select 조건 empno, ename, job, deptno
where 조건  
    
vo 객체
private int empno;
private String ename;
private Stirng job;
private int deptno;

select와 where조건 생성자를 나눠서 생성
*/


-- ex) dept와 조건을 통해서 부서명(키워드)와 입사분기별조건으로 부서명, 사원명, 입사일, 급여를 출력하세요
-- 1) sql 
-- 2) vo
-- 3) 기능메서드
SELECT dname, ename, hiredate, sal
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND dname LIKE '%'||'A'||'%'
AND to_char(hiredate, 'Q') = '1';

/*
vo객체
--select
private String dname;
private String ename;
private Date hiredate;
private double sal;


--where조건
private String dname;
private Date hirdate;
private String div; // 분기

-- 겹치니까 통합

*/





--Result연습

/*
ResultSet : 조회 결과의 데이터를 가지고 있다
1. next() : 행 단위로 이동
2. get타입("컬럼명")   or   get타입(1) 1부터 select의 순서대로	
	while(rs.next()) { // 데이터가 있을 때까지 이동
		rs.getInt("empno")
		rs.getString("ename")
		rs.getString(3)
		rs.getDouble(4)
	}
3. 위 반복 프로세스에서 리턴으로 선언한 객체에 단위 데이터를 입력(생성자)하고
	Emp e = new Emp( rs.getInt("empno"), rs.getString("ename"),
					 rs.getString("ename"), rs.getDouble(4) )

4. List<Emp>에 하나씩 반복문으로 통해 담기
	list.add(e);
 	
 	 	 	
*/



SELECT deptno, ename, job, sal
FROM emp
WHERE deptno=10;



--복사테이블 만들기
	create table emp100 as select * from emp;

	alter table emp100
	modify(
		job varchar2(50),
		ename varchar2(50),
		empno number(4) primary key
	);
	
-- sequence 만들기 (primary key 설정)
	create sequence emp100_seq
	start with 1000
	minvalue 1000
	maxvalue 9999;

-- 데이터 등록
insert into emp100 values(emp100_seq.nextval, 
						  '홍길동', '사원', 7800,
						  to_date('2002/01/01', 'YYYY/MM/DD'), 3500, 100, 10);


--복사테이블 만들기
CREATE TABLE dept100
AS SELECT * FROM dept;

ALTER TABLE dept100
MODIFY (
	dname varchar2(50),
	loc varchar2(50)
);
-- A03_DeptDao.java 에 추가 기능 메서드 처리
-- 1. sql : insert into dept10 values(11, '인사', '서울')
-- 2. vo
-- 3. public void insertDept(Dept ins){
--    }
INSERT INTO dept100 values(11, '인사', '서울');
SELECT * FROM dept100;



CREATE TABLE person(
	name varchar2(50),
	age NUMBER,
	loc varchar2(50)
	);
INSERT INTO person values('홍길동', 25, '서울 신림');

SELECT * FROM person;
/*
1. VO
2. 메서드 정의
3. main() 추가 처리
4. DB로 확인
A04_DaoExp.java

*/




SELECT * FROM dept100;
-- 조회 sql
SELECT * FROM dept100
WHERE dname LIKE '%'|| 'O' || '%'
AND loc LIKE '%'|| 'N' || '%' ;

-- 등록 SQL 
INSERT INTO dept100 values(12, '총무', '전주');
/*
PreparedStatement pstmt

SELECT * FROM dept100
WHERE dname LIKE '%'|| ? || '%'
AND loc LIKE '%'|| ? || '%'

INSERT INTO dept100 values(?, ?, ?);
*/




SELECT * FROM dept100;
UPDATE dept 100
   SET deptno =13,
   	   dname='아이티사업부',
   	   loc = '제주도'
WHERE deptno = 11;   	   
/*
SELECT * FROM dept100;
UPDATE dept 100
   SET deptno =?,
   	   dname=?,
   	   loc = ?
WHERE deptno = ?
*/


DELETE FROM dept100
WHERE deptno = 11;
/*
DELETE FROM dept100
WHERE deptno = ?
*/

-- 분기정보와 급여의 범위를 받아서 해당 분기의 최고 급여를 리스트 처리
-- 분기 정보가 없으면 전체 분기별 사원정보
-- 급여의 범위가 없으면 전체 급여 
-- pstmt + 동적 query 
SELECT empno, ename, qm.qu||'/4' qu, sal 
from emp e, ( SELECT to_char(hiredate, 'Q') qu, max(sal) msal
			  FROM EMP
			  GROUP BY to_char(hiredate, 'Q')
			) qm
WHERE to_char(hiredate, 'Q') =qu
AND sal = msal
AND qu = '4'
AND sal BETWEEN 1000 AND 5000;
/*
SELECT empno, ename, qm.qu'/4' qu, sal 
from emp e, ( SELECT to_char(hiredate, 'Q') qu, max(sal) msal
			  FROM EMP
			  GROUP BY to_char(hiredate, 'Q')
			) qm
WHERE to_char(hiredate, 'Q') =qu
AND sal = msal
AND qu = ?
AND sal BETWEEN ? AND ?

Vo
class EmpQua{
	private int empno;
	private String ename;
	private String qu;
	pirvate double sal;
	private double frSal;
	private double toSal;
	
	//생성자1 : default생성자
	//생성자2 : qu, frSal, toSal
	//생성자3 : empno, ename, qu, sal
}

기능메서드
public List<EmpQua> getList(EmpQua sch){}	

*/





