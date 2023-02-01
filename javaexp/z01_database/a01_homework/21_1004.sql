/*
2022-10-04
[1단계:개념] 1. EQUI join과 NON EQUI join의 차이점을 기술하세요
[1단계:코드] 2. 직책이 SALESMAN의 급여와 등급을 출력하요
[2단계:코드] 3. 1사분기에 입사한 사원중, 부서명이 ACCOUNTING인 사원의 이름, 급여와 급여등급 출력하세요.
[1단계:개념] 4. outer join의 기본 형식과 equi join과의 차이점을 기술하세요.
[2단계:코드] 5. 부서별 최고급여액을 출력하되 사원정보가 없는 부서는 0으로 표현하여 출력하세요.
[1단계:코드] 6. 관리자하위에 포함된 사원을 기준으로 관리자의 하위 직원의 수를 관리자명, 사원수로 출력하세요.
[1단계:개념] 7. subquery란 무엇인가? 여러가지 유형과 함께 기술하세요. 
[1단계:코드] 8. JAMES와 같은 입사일의 분기를 가진 사원을 출력하세요.
[1단계:코드] 9. ALLEN과 같은 관리자를 둔 사원을 출력하세요.
[1단계:코드] 10. 보너스가 가장 많은 사원정보(사원명, 부서명, 보너스)를 출력하세요.
[1단계:코드] 11. 12월에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
[1단계:개념] 12. 다중행/다중열의 SUBQUERY의 종류와 차이점을 예제를 통해 기술하세요. 
*/

--1
/*
equi join은 조인 대상 테이블에서 공통 컬럼을 '=' equal 비교를 통해 같은 값을 가지는 행을 연결하여 결과를 생성하는 조인 방법
Non equi join은 조인하는 두 개의 테이블의 값이 동일하지 않고, 범위로서 join하는 경우를 말한다
*/
--2
SELECT ename,  sal,  grade, job
FROM emp, salgrade
WHERE sal BETWEEN losa AND hisal AND job = 'SALESMAN';

--3
SELECT d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno=d.deptno   AND sal BETWEEN losal AND hisal  -- 각테이블의 조인조건 선언
AND dname = 'ACCOUNTING' 
AND to_char(hiredate,'Q') ='1'; 
/*
 처리 순서
1) 1사분기에 입사한 사원
2) 조건1  부서명이 ACCOUNTING : 부서테이블 조인
3) 조건2  1사분기에 입사
4) 급여와 급여등급 출력하세요 : salgrade 테이블 조인
5) 조인 : 사원, 부서, 등급,   조건 : 1사분기에 입사, 부서명이 ACCOUNTING 
   출력내용(select) ename, sal, grade	
*/
--모범답안
SELECT ename, sal, grade  --  to_char(hiredate,'Q') 분기, dname   -- 검산
FROM emp e, dept d, salgrade s
WHERE e.deptno=d.deptno 			-- 각테이블의 기본 조인조건을 선언
AND sal BETWEEN losal AND hisal  
AND to_char(hiredate,'Q') ='1'		-- 조건
AND dname = 'ACCOUNTING'; 


--4
/*
equi join의 조인 조건에서 양 테이블의 컬럼 값 중 어느 하나라도 null이면 해당 행은 출력 불가, 연산 결과는 null로 처리된다.
따라서 outer join은 equi join에서 양측 컬럼 값 중의 하나가 null이지만 조인 결과로 출력할 필요가 있을 때 사용된다
-기본형식
: (+) 기호를 사용하여 해당 테이블에 정보가 없을 지라도 표시할 컬럼을 지정하여 처리한다
	select 테이블1.컬럼1, 테이블1.공통컬럼, 테이블2.공통컬럼. 터이블2.컬럼1
	from 테이블1, 테이블2
	where 테이블1.공통칼럼(+) = 테이블2.공통컬럼 
*/
--5
SELECT dname,  nvl(max(e.sal),'0')
FROM EMP e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY dname;

--6
SELECT * FROM emp;
SELECT e.ename, count(empno)
FROM emp e, emp m
WHERE e.mgr = m.EMPNO 
GROUP BY e.ename;
/*
1) 관리자하위에 포함된 사원을 기준( mgr, empno의 self join 테이블 처리)
2) 관리자 정보 m, 기본사원 정보를 e로 처리
3) 관리자명(관리자 정보의 사원명), 사원수(기본 사원정보의 count 수)
*/
--사원정보에 관리자정보를 맵핑 시킨 것
SELECT e.*, m.*   
FROM emp e, emp m
WHERE e.mgr = m.empno;
-- 모범답안
SELECT m.ename, count(e.empno) 사원수
FROM emp e, emp m
WHERE e.mgr = m.empno
GROUP BY m.ename;

--7
/*
subquery란 하나의 sql명령문의 결과를 다른 sql명령문에 전달하기 위해 두 개 이상의 sql명령문 을하나의 sql명령문으로 연결하여 처리하는 방법

--SMITH와 동일한 부서의 사원정보를 출력하세요
SELECT *
FROM EMP 
WHERE deptno =(
	SELECT DEPTNO 
	FROM EMP 
	WHERE ename = 'SMITH'
);
*/
--8
SELECT * 				-- to_char(hiredate,'Q') 분기, e.* -- 검산
FROM emp e
WHERE to_char(hiredate,'Q') = (
	SELECT to_char(hiredate,'Q')
	FROM emp
	WHERE ename ='JAMES'
);
/*
1) JAMES의 입사 분기 (subquery)
2) 위 분기와 동일한 사원 where to_char(hiredate, 'Q') = ( subquery )
*/
--9
SELECT *
from emp
WHERE mgr = (
	SELECT mgr
	FROM EMP 
	WHERE ename = 'ALLEN'
);

--10
SELECT ename, dname, comm, max(comm)
FROM emp;
/*
1) 보너스가 가장 많은 사원 ==> 최고보너스( subquery ) ==> main query
2) 부서명 출력 ==> 부서정보와 조인

>> 처리 순서
1.
--최고 보너스
SELECT max(comm)
FROM emp

2.
--최고 보너스 가진 사원
SELECT *
FROM emp 
WHERE comm =(
	  SELECT max(comm)
	  FROM emp
);

3.
-- 부서명을 위한 부서테이블과 조인 및 출력할 컬럼 지정
SELECT ename, dname, comm
FROM emp e, dept d
WHERE e.deptno = d.deptno
  AND comm =(
	  SELECT max(comm)
	  FROM emp
);
*/
--모범답안
SELECT ename, dname, comm
FROM emp e, dept d
WHERE e.deptno = d.deptno
  AND comm =(
	  SELECT max(comm)
	  FROM emp
);

--11
SELECT *
FROM emp
WHERE deptno in (
	SELECT deptno
	FROM emp
	WHERE to_char(hiredate, 'MM') = '12'
);  

--12
/*
# 서버쿼리의 종류
1. 단일행 서버 쿼리
	- 서버의 쿼리의 결과가 하나의 행인 경우를 말하며
	- 하나의 행을 조건으로 처리하는 비교 연산자( = , >, <, <= , >=, <>, != ) 등을 활용
	ex) 부서번호와 10인 사원의 최대 급여보다 적은 급여를 가진 사원 정보
		select *
		from emp
		where sal <= (
			select max(sal)
			from emp
			where deptno = 10
		);
2. 다중행 서버 쿼리
	- 서버 쿼리의 결과값이 여러 행일 때 활용되며
	- 다중행 비교연산자에는 in, any, some, all, exists 등을 활용
	ex) 급여가 1000~2000 사이의 사원과 같은 직책인 사원정보  
		select *
		from emp
		where job in(
			select job
			from emp
			where sal between 1000 and 2000
		);
*/


--[1단계:코드] 6. 관리자하위에 포함된 사원을 기준으로 관리자의 하위 직원의 수를 관리자명, 사원수로 출력하세요.
--[1단계:코드] 10. 보너스가 가장 많은 사원정보(사원명, 부서명, 보너스)를 출력하세요.





/*
== 평가대비(오라클) 객관식 문제 ==
1.
1) in 2) any 3) some 4) between
정답4 
다중행 서버쿼리로 사용되는 구문에는 in, any, some, all, exists이 있다
between은 betweem A and B 구문으로 차이로 사용

2. 
1) 단계적 - 개념적 모델링
2) 단계적 - 논리적 모델링
3) 도구적 - 개념적 모델링  
4) 도구적 - 논리적 모델링
정답:3
단계적 데이터 모델링 - 개념적 데이터 모델링 / 논리적데이터모델링
도구적 데이터 모델링 - 개념적 데이터 모델링 / 논리적데이터모델링
	단계적 모델링-개념적 모델링은 현실 세계의 중요 데이터를 추출하여 개념 세계로 옮기고
	도구적 모델링-개념적 모델링은 현실 세계를 개념적 모델링하여 데이터베이스의 개념적 구조로 표현하는 것

3. 
1) 엔티티 - 원		: entity, 즉 객체는 사각형
2) 관계 - 마름모	: 개념적 데이터 모델
3) 속성 - 타원		: 개념적 데이터 모델
4) 개체 - 사각형	: 개념적 데이터 모델
정답:1

4.
1) both
2) any
3) some
4) exists
정답:1
*/





