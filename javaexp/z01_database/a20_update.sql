/*
# 데이터 수정
1. update 명령문은 테이블에 저장된 데이터 수정을 위한 조작어이다
2. 기본 형식
	update 테이블명
	set 컬럼1 = 변경할 데이터,
		컬럼2 = 변경할 데이터
		...
	where 조건문
3. 주의사항
	1) where 절을 생략하면 테이블의 모든 행이 수정된다
	2) 조건문과 변경할 데이터부분을 subquery를 이용하여 처리할 수 있다		
*/
SELECT * FROM emp10;
UPDATE EMP10 
	SET empno = 1000,
		job = '사원'
  WHERE empno = 7369; 	
--ex1) emp10 보너스가 null인 데이터를 모두 1000으로 수정 처리하세요
--ex2) emp10 1/4분기에 입사한 사원정보를 현재날짜로 수정처리하세요
--1
 UPDATE emp10
 SET comm = 1000
 WHERE comm IS NULL;
--2
UPDATE EMP10 
SET hiredate = sysdate
WHERE to_char(hiredate,'Q') = '1';


/*
# subquery를 통한 수정 처리
1. update명령문에 set부분이나 where 조건절에 subquery를 이용하여 수정 처리하는 것을 말한다
2. 다른 테이블이나 현재 테이블에 정보를 변경할 때 일단 query를 수행한 결과로 해당데이터를 수정 처리하는 것을 말한다
3. 변경할 컬럼의 타입과 개수는 반드시 일치하여야 한다
4. 유형
	1) set부분 subquery 활용
		- 한 개의 컬럼 set 컬럼명 = (결과가 1개인 컬럼데이터)
		- 두 개이상의 컬럼 set (컬럼명, ...) = (결과가 2개 이상 컬럼 query)
-- 부서번호가 10인 사원정보의 급여를 부서정보 20인 사원의 최고급여로 변경 처리
select ename, sal
from emp10
where deptno = 10;

select max(sal)
from emp10
where deptno = 20;

update emp10
	set sal = (
	 select max(sal)
	 from emp10
	 where deptno = 20
	)
where deptno = 10;	
*/
-- 부서번호가 10인 사원정보의 급여를 부서정보 20인 사원의 최고급여로 변경 처리
update emp10
	set sal = (
	 select max(sal)
	 from emp10
	 where deptno = 20
	)
where deptno = 10;	

--ex1) emp10 - 직책이 SALESMAN인 사람의 평균 급여를 사원번호 7499의 급여로 수정처리하세요
--ex2) 2사분기 최고급여를 사원명 ALLEN의 급여로 변경처리하세요
--1
UPDATE EMP10 
SET sal = (
	SELECT avg(sal)
	FROM EMP10
	WHERE job='SALESMAN'
)
WHERE empno = 7499; --1400이 됨

--2
UPDATE EMP10 
SET sal = (
	SELECT max(sal)
	FROM EMP10
	WHERE to_char(hiredate, 'Q') = '2' --3000
)
WHERE ename = 'ALLEN';

--ex) 직책이 MANAGER인 사원의 최저급여를 SMITH의 급여로 수정하세요
UPDATE EMP10 
SET sal =(
	SELECT min(SAL) 
	FROM EMP10 e 
	WHERE job='MANAGER'
)
WHERE ename = 'SMITH';


/*
# 단일행 수정 subquery 
update 테이블명
	set 컬럼명 = ( select 컬럼 from 테이블명 )
where 조건
ex) subquery를 통해 얻어진 데이터를 해당 컬럼의 값을 변경
*/
--ex) 최대 급여를 사원번호@@에게 할당 처리
--1) 최대 급여
SELECT max(sal)
FROM emp10;
--2) 사원번호 @@@의 급여 변경
UPDATE EMP10 
SET sal = (
	SELECT max(sal)
	FROM emp10
)
WHERE empno = 7369;
-- 해당 데이터는 항상 입력/수정/삭제에 의해 바뀌고 있는 상황에서 통계치를 처리하려면 subquery가 필요로 하다


/*
# 다중열 조건 subquery
update 테이블명
	set ( 컬럼1, 컬럼2 ) = ( select 컬럼1, 컬럼2 from 테이블명 )
where 조건			
ex) subquery의 두 개 이상 컬럼의 내용을 기준으로 검색된 내용으로 변경 처리
*/
-- ex) 직책이 SALESMAN의 부서와 급여를 10번부서의 평균급여로 변경
-- 1) subquery 10부서의 평균급여
SELECT deptno, round(avg(sal))
FROM EMP10
WHERE deptno = 10
GROUP BY DEPTNO ;
--2) update 구문의 query를 작성
SELECT *
FROM EMP10
WHERE job = 'SALESMAN';

UPDATE EMP10 
SET (deptno, sal)=(
	SELECT deptno, round(avg(sal))
	FROM EMP10
	WHERE deptno = 10
	GROUP BY DEPTNO
)
WHERE job ='SALESMAN';

SELECT *
FROM EMP10;

/*
# 데이터 삭제 처리
1. 조회조건 where을 통해 특정한 데이터를 row단위로 삭제 처리한다
2. row단위이기에 삭제구문을 선택하는 컬럼이 없다
	delete	--선택하는 컬럼이 없음
	from 테이블
	where 조건
3. 조건은 기존에 데이터와 샅은 subquery를 이용해서 조건을 활용가능하다	
*/
DELETE 
FROM EMP10 
WHERE empno = 8003;

DELETE 
FROM emp10
WHERE sal = (
	SELECT min(sal) FROM emp10
);

--ex) 부서별로 최근에 입사한 사원을 삭제 처리하세요
DELETE 
FROM EMP10 
WHERE (deptno, hiredate) in (
	SELECT deptno, max(hiredate)
	FROM emp10
	GROUP BY deptno
	);

SELECT * FROM emp10;









CREATE TABLE EMP01
AS SELECT * FROM emp;
ALTER TABLE EMP01
MODIFY (
	job varchar2(50),
	ename varchar2(50),
	empno NUMBER PRIMARY KEY 
);


SELECT* from emp100;
