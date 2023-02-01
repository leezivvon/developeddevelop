/*
# 조인(join)
1. 조인의 개념
	1) 하나의 sql명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 것을 말한다
	2) 관계형 데이터베이스 분야의 표준
		entity relation diagram(ERD)
	3) 두 개 이상의 테이블을 결합한다는 의미	
2. 조인의 필요성
	1) 조인을 사용하지 않는 일반적인 예
		학생 주소록을 출력하기 위해 학생들의 학번, 이름, 소속학과
		이름을 검색
		학생에 대한 정보 검색하는 단계 필요
		학생 정보에서 소속학과번호 정보를 추출하여 소속학과
		이름을 검색하는 단계 필요
		ex) 사원번호가 7369인 사원의 이름과 부서이름, 부서위치를 출력
			- 사원정보에서 부서번호를 가져온다
			- 부서정보에서 부서이름과 부서위치를 가져온다
	2) 조인을 하는 경우
		연관관계에 있는 부서번호를 조회 조건으로 검색을 하면 한 번에 원하는 데이터를 가져올 수 있다		
*/
SELECT * FROM emp;
SELECT * FROM dept; -- deptno 로 연관관계가 설정 가능

-- 7369사원의 부서번호 가져오기
SELECT *
FROM emp
WHERE empno = 7369;
-- 부서정보 확인 20
SELECT *
FROM DEPT
WHERE deptno = 20; --7369 사원의 부서명은 RESEARCH 이다
-- 두 개의 검색을 통해서 데이터를 가져옴
-- >> 조인을 하는 경우 ==> 바로 부서의 정보를 확인할 수 있다
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.DEPTNO 
AND empno=7369;


/*
# equi join
1. 개념
	1) 조인 대상 테이블에서 공통 컬럼을 '=' equal 비교를 통해 
	   같은 값을 가지는 행을 연결하여 결과를 생성하는 조인 방법
	2) SQL 명령문에서 가장 많이 사용하는 조인 방법
	3) 조인 애트리뷰트(속성)을 활용하는 대표적인 형식
2. where 절을 이용한 equi join 사용방법
	select 테이블1.컬럼명, 테이블2.컬러명,...
	from 테이블1, 테이블2
	where 테이블1.공통컬럼 = 테이블2.공통컬럼
	1) from : 조인 대상 테이블으 기술한다. 테이블은 콤마(,) 구분
	2) where : 조인 애트리뷰트와 '='연산자를 사용하여 조인 조건을 기술
			- 기타 조건에 대한 설정을 and 조건으로 연결하여 처리한다
*/
-- 연봉이 3000이상인 사원의 사원명과 부서명을 출력
SELECT ename, sal, dname --. e.deptno  공통컬럼만 alias이름 선언한다
FROM emp e, DEPT d 
WHERE e.deptno = d.deptno 
AND sal >= 3000;
-- 조인을 하면 해당 조인된 구문에 의해 나타날 데이터를 테이블형식으로 
-- 그동안 진행한 여러가지 함수, 그룹데이터, 조건문 처리를 할 수 있다

-- ex1) 직책이 SALESMAN인 사원의 부서번호, 부서명, 사원명, 직책을 출력하세요
SELECT e.deptno, dname, ename, job
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND job = 'SALESMAN'; 
-- dept(부서테이블) : 부서번호(deptno), 부서명(dname), 부서위치(loc)
-- 부서명별로 최고급여자
SELECT dname, max(sal)
FROM emp e, dept d
WHERE e.deptno = d.DEPTNO 
GROUP BY dname;
-- ex) 부서위치별로 가장 최근에 입사한 입사일을 출력
SELECT loc, max(hiredate) 최근입사일
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY loc
ORDER BY 최근입사일; --max(hiredate) 정렬>>작은 수 먼저 = 오름차순

/*
# Non equi join
1. 조인하는 두 개의 테이블의 값이 동일하지 않고, 범위로서 join하는 경우를 말한다
2. 

*/
SELECT ename, sal FROM emp;
SELECT * FROM salgrade;

SELECT ename, sal, grade, losal||'~'||hisal 범위 
FROM emp, SALGRADE 
WHERE sal BETWEEN losal AND hisal; -- 2001-3000
-- ex1) 4등급에 해당하는 사원들의 정보를 출력
SELECT s.grade, sal, e.*
FROM emp e, SALGRADE s
WHERE sal BETWEEN losal AND hisal AND grade=4;
--WHERE grade=4;

-- ex2) SMITH의 급여와 급여등급을 출력
SELECT ename, sal, s.grade
FROM emp, SALGRADE s 
WHERE sal BETWEEN losal AND hisal and ename='SMITH';
--WHERE ename='SMITH';

/*
# outer join
1. equi join의 조인 조건에서 양 테이블의 컬럼 값 중 어느 하나라도 null이면 
   '=' 비교 결과가 거짓이 되어 null 값을 가진 행은 조인 결과로 출력 불가 
   null에 대하여 어떠한 연산을 적용하더라도 연산 결과는 null로 처리된다.
   ex) 사원정보와 부서정보 테이블 조인에서 부서번호가 40인 사원정보는 없기에 부서정보 40은 출력되지 않게 된다
2. equi join에서 양측 컬럼 값 중의 하나가 null이지만 조인 결과로 출력할 필요가 있을 때 outer join을 사용한다
   ex) 사원정보와 부서정보 테이블을 조인하면서 사원정보가 없는 40번 부서정보도 outer join을 이용하면 출력하게 된다
3. 기본형식
	1) (+) 기호를 사용하여 해당 테이블에 정보가 없을 지라도 표시할 컬럼을 지정하여 처리한다
	select 테이블1.컬럼1, 테이블1.공통컬럼, 테이블2.공통컬럼. 터이블2.컬럼1
	from 테이블1, 테이블2
	where 테이블1.공통칼럼(+) = 테이블2.공통컬럼     
*/
SELECT DISTINCT deptno FROM emp; -- 사원 정보의 deptno;
SELECT * FROM dept;
SELECT ename, e.deptno, d.deptno, dname
FROM emp e, dept d
WHERE e.deptno(+)= d.deptno;
--부서테이블에 40 부서정보와 연결되는 정보가 없어서 equi join으로는 보이지않지만 outer join을 하면 부서정보도 확인할 수 있다

/*
# 데이터가 없는 테이블의 outer join시 처리한 내용
1. nvl 함수 처리
	없는 데이터에 대하여 nvl함수를 통해 데이터가 없음 표기
	ex) 합산을 할 때 없는 데이터도 통계치에 포함될 때는 nvl()을 활용하여 처리한다
2.count(), max() 등 그룹함수 처리
	그룹함수에서는 일반적으로 null을 포함하지 않고 처리가 된다	
*/
SELECT nvl(ename, '사원정보없음') ename, dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- max(nvl(sal, 0)) : matching 되는 데이터가 없기에 통계치도 null이 나오는 것을 0으로 처리해준다
SELECT dname, max(nvl(sal,0)) 부서별최대, count(e.deptno) "사원정보의 건수", count(d.deptno) "부서정보 건수"
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY dname;
-- ex) outer join을 하여 부서명, 사원명, 급여를 출력하되 급여가 3000이상인 데이터만 출력하세요
SELECT dname, ename, sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND sal>=3000;

SELECT dname, nvl(ename,'없음'), nvl(sal,0), sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND sal<3000;


