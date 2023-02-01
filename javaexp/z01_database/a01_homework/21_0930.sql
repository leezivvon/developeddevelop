/*
[1단계:개념] 1. 그룹함수의 기본형식을 예제를 통해 설명하세요 
[1단계:개념] 2. 그룹함수의 종류를 기술하세요.
[1단계:코드] 3. 직책별 가장에 최근에 입사한 사원의 입사일을 출력하세요.
[1단계:코드] 4. 직책별 평균급여가 2000이상인 경우를 출력하세요.
[1단계:코드] 5. 월별로 가장 급여가 낮은 급여를 출력하세요.
[1단계:코드] 6. 사원번호가 짝수/홀수를 청/홍팀으로 나누고 청/홍팀 평균급여와 사원수를 출력하세요.
[1단계:코드] 7. 분기별, 입사 사원수의 수가 2명이상인 분기기준으로 분기 별의 최고 급여를 출력하세요.
[1단계:개념] 8. 테이블의 조인의 기본 형식을 기술하세요.
[1단계:코드] 9. 입사일이 2~5월 사이인 사원의 부서명, 사원명, 입사일을 출력하세요
[1단계:코드] 10. 1/4분기에 입사하고, 연봉이 1000이상인 사원의 사원명, 
      입사일, 입사분기, 부서명, 부서위치를 출력하세요
[1단계:코드] 11. 부서위치(LOC)별, 최고 급여가 2000이상인 경우를 출력하세요.
*/
--1,2
/*
select 기준컬럼, 그룹함수(컬럼)
	from 테이블명
	[where]
	group by 그룹컬럼
	having 그룹함수를 적용한 결과를 조건 처리
*/

SELECT job, MAX(sal),   -- 직책별 최고급여
			MIN(sal),   -- 직책별 최저급여
			count(job), -- 직책별 인원 수 
			floor(avg(sal))	 -- 직책별 급여의 평균	
FROM emp
group BY job        -- 그룹칼럼
HAVING count(job)>1 -- 조건: 직책별 인원수가 1 초과하는 것만 출력
ORDER BY job; 

--3
SELECT job, max(hiredate) 입사일
FROM emp
GROUP BY job;

--4 
SELECT job, floor(avg(sal)) 
FROM EMP 
GROUP BY JOB 
HAVING avg(sal) >= 2000;

--5
SELECT to_char(hiredate, 'MON') 입사월, MIN(sal) "가장 낮은 급여"
FROM EMP e 
GROUP BY to_char(hiredate, 'MON');

--6
SELECT  decode(MOD(empno,2), 0, '청팀', '홍팀'),
		floor( avg(sal) ) 평균급여,
		count(MOD(empno,2)) 사원수
FROM EMP e 
GROUP BY MOD(empno,2);

--7
SELECT to_char(hiredate, 'Q')||'/4분기' 분기, max(sal) "분기별 최고급여"
FROM EMP 
GROUP BY to_char(hiredate, 'Q')
HAVING count( to_char(hiredate, 'Q') )>=2
ORDER BY to_char(hiredate, 'Q');

--8
-- <SMITH사원의 부서명 알기>
-- 1)
-- SMITH사원의 부서번호 가져오기
SELECT * FROM emp WHERE ename='SMITH';-- 부서정보 확인 20
SELECT * FROM DEPT WHERE deptno = 20; -- 부서명 RESEARCH
-- 2) 조인을 하는 경우 >> 바로 부서명 확인 가능
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.DEPTNO 
AND ename='SMITH';


--9

SELECT dname 부서명, ename 사원명, to_char(hiredate, 'MMDD') 입사일
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND to_number(to_char(hiredate, 'MM')) >=2 
and to_number(to_char(hiredate, 'MM')) =<5;

--10
SELECT  ename 사원명, to_char(hiredate, 'YYYY/MM/DD') 입사일, 
		to_char(hiredate, 'Q"/4분기"') 입사분기, dname 부서명, loc 부서위치
FROM emp d, dept d
WHERE to_char(hiredate, 'Q') = '1'
AND sal>=1000;

--11
SELECT loc "부서 위치", MAX(sal) "최고 급여"  
FROM emp e, dept d
GROUP BY loc
HAVING sal>=2000;


/*
== 평가대비(데이터베이스) 객관식 문제 ==
1. 
1) 키-값(key-value) 데이터베이스   			O
2) 문서 기반(document-based) 데이터베이스	O
3) 인덱스 기반(index-based) 데이터베이스  	X
4) 컬럼 기반(column-based) 데이터베이스 		O + 그래프 기반

2. 
1) ACID(원자성, 일관성, 격리성, 지속성)를 위한 트랜잭션 기능을 제공 X -관계데이터설명
	  X - 트랜잭션을 지원하지 않아 일관성 유지를 보장하기 어려움
2) 빠른 속도로 생성되는 대량의 비정형 데이터를 저장하고 처리  O
3) 저렴한 비용으로 여러 대의 컴퓨터에 데이터를 분산∙저장∙처리 O 
4) 대부분 오픈 소스로 제공   O

3. 
1) 텍스트 마이닝(text mining) - SNS, 블로그, 게시판 등에 기록된 사용자들의 의견을 수집 			- 오피니언 마이닝 설명
2) 오피니언 마이닝(opinion mining) - 제품이나 서비스에 대한 긍정, 부정, 중립 등의 선호도를 추출	O
3) 소셜 네트워크 분석(social network analysis) - 반정형 또는 비정형 텍스트에서 자연어 처리 기술 	- 텍스트마이닝 설명
4) 군집 분석(cluster analysis) - 네트워크에 나타난 영향력, 관심사, 성향, 행동 패턴 등을 추출    	- 소셜네트워크 분석

4. 빅데이터의 기본 특징가 3V이 아닌 것은?
1) Volume   O -데이터량
2) Velocity O -속도
3) Veracity X -정확성 : 7V에 든다
4) Veriety  O -다양성
*/




