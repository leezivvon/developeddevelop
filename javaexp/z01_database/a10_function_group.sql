
/*
# 그룹함수란?
1. 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로 결과를 출력하는 함수,
   그룹함수는 통계적인 결과를 출력하는데 자주 사용된다
2. 사용법
	select 컬럼, 그룹함수(컬럼)
	from 테이블명
	[where]
	group by 그룹컬럼
	having 그룹함수를 적용한 결과를 조건 처리   
3. 그룹함수의 종류
	1) count() : 데이터의 건수, 행의 개수
	2) max() : null을 제외한 모든 행의 죄대값
	3) min() : null을 제외한 모든 행의 최소값
	4) sum() : null을 제외한 모든 행의 합
	5) avg() : null을 제외한 모든 행의 평균값
	4) stddev()   : null을 제외한 모든 행의 표준편차
	7) variance() : null을 제외한 모든 행의 분산 값
	
**/
SELECT deptno, sal FROM emp ORDER BY deptno, sal;
SELECT MAX(sal), MIN(sal), count(*)  FROM emp; --전체데이터 기준/ count(*) 모든 데이터의 건수  
SELECT deptno, MAX(sal), MIN(sal), count(*) 
FROM emp
group BY DEPTNO 
ORDER BY deptno;
--ex) 직책별 사원의 수와 평균급여를 출력하세요
SELECT job, count(job) 직책별사원수, round( avg(sal) ) 직책별평균급여
FROM emp
GROUP BY job;


--날짜형 데이터 min, max()는 최근 데이터, 가장 먼저 데이터
SELECT  deptno, min(hiredate) "가장먼저 입사", max(hiredate) " 가장나중 입사"
FROM emp
GROUP BY DEPTNO -- 부서별로 
ORDER BY deptno; -- 정렬까지

-- 부서별로 평균 급여 중에 조건 검색
SELECT deptno, avg(sal)
FROM EMP 
GROUP BY DEPTNO 
HAVING avg(sal)>=2000; -- 적용한 그룹함수의 조건을 처리할 때는 having을 활용한다
--ex) 부서별로 최대값이 3000 이상인 사원을 검색하세요
SELECT ename, deptno, max(sal)
FROM EMP e 
GROUP BY DEPTNO, ename
HAVING max(sal)>=3000;
--정답
SELECT deptno, max(sal)
FROM EMP e 
GROUP BY DEPTNO
HAVING max(sal)>=3000;


/*
# 함수 적용한 그룹데이터 처리
1. 그룹데이터를 함수를 적용해서 변경한 데이터를 기준으로 처리할 수 있다
2. 기본 형식
	select 그룹할컬럼/데이터, 그룹함수()
	from 테이블
	group by 그룹할컬럼/데이터
	having 그룹함수(데이터) >=0;
		having은 그룹함수에 비교, 조건/논리 연산식을 붙여 처리한다
3. 
*/
-- 분기별 최대 급여액 출력
SELECT TO_char(hiredate, 'Q') 분기, max(sal)
FROM EMP e 
GROUP BY TO_char(hiredate, 'Q')
ORDER BY TO_char(hiredate, 'Q');

-- ex) 연도별 사원의 수와 최대급여를 출력하세요
SELECT TO_char(hiredate, 'YYYY')||'년' 입사년도, count(ename) "연도별 사원수", max(sal) "연도별 최대급여"
FROM EMP 
GROUP BY TO_char(hiredate, 'YYYY')	 -- GROUP BY 는 alias이름으로 지원 처리 불가능 
ORDER BY 입사년도;					 -- ORDER BY 는 alias이름으로 지원 처리 가능  

