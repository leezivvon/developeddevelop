/*
 * DB 환경 설정 부분 ppt자료로 만들어 제출하세요
 
2022-09-27
[1단계:개념] 1. select의 sql의 전체형식의 내용을 예제와 함께 기술하세요.
[1단계:코드] 2. 급여가 3000이상 2000미만이고  부서명이 30이 아닌 데이터를 검색하세요.
[1단계:개념] 3. 비교연산자 중에 부정연산자인 경우 3가지를 기술하세요.
[1단계:코드] 4. 사원명과 관리자번호(mgr)- null인 경우 0으로 출력
[1단계:코드] 5. null이 아닌 경우만 중복되지 않는 관리자번호를 출력하세요 
[1단계:개념] 6. IN 구문과 OR 구문의 차이점을 예제를 통해서 기술하세요
[1단계:개념] 7. keyword 검색의 형식을 예제를 통해서 기술하세요.
[1단계:코드] 8. [키워드검색]사원명이 두번째 글짜가 A이거나 직책이 MAN을 끝나는 데이터를 조회하세요.
[1단계:개념] 9. 대소문자 상관없이 조건을 입력했을 때, 검색 처리되는 여러가지 형식을 함수를 통해 기술하세요
[1단계:개념] 10. 한글과 영문의 길이의 차이를 검색하는 함수의 기능을 기술하세요
[1단계:개념] 11. substr() 함수의 기본 기능을 기술하세요.
[1단계:코드] 12. dual 함수를 이용하여 임의의 주민번호를 substr()처리하여 @@년@@월@@일생이라고 출력하세요.
[1단계:코드] 13. [함수검색]사원명에 A가 포함되어 있는 데이터의 함수와 검색위치를 출력하세요
*/
SELECT * FROM emp;

--1
/*
기본 형식
	select * | 컬럼명        		: 열단위로 나타날 데이터를 선택
	from 테이블명 테이블별칭(alias)
	where 조건문             		: 행단위로 나타날 데이터 filtering 처리
	group by 그룹할 컬럼지정   		: 특정 컬럼 기준으로 합산, 개수 최대/최소
	having 그룹 컬럼의 조건   		: 그룹의 조건을 지정 
	order by 정렬할 컬럼과 정렬방식	: 정렬할 우선 순위컬럼 지정
*/
--2 
SELECT *
FROM emp
WHERE sal>=3000 or sal<2000 AND deptno != 30;

--3 
SELECT *
FROM emp
WHERE deptno != 20;        -- 부정연산자1  !=
--WHERE deptno <> 20;      -- 부정연산자2  <>
--WHERE NOT (deptno = 20); -- 부정연산자3  where not(조건문)

--4 
SELECT ename, nvl(mgr, 0)
FROM Emp;

--5
SELECT DISTINCT ename, mgr
FROM emp
WHERE mgr IS NOT NULL;

--6
-- or 조건은 조건 중 하나라도 참이면 출력. 하나의 칼럼을 기준으로 많은 or 조건을 효과적으로 처리하기 위해 in()사용
SELECT ename, deptno FROM emp
WHERE deptno = 10 OR deptno =20 OR deptno =30;

SELECT ename, deptno FROM emp 
WHERE deptno in(10, 20, 30);

--7
--LIKE이용        : WHERE  컬럼  LIKE '%A%';
SELECT * FROM emp  WHERE ename LIKE '%A%'; --'A' 위치 상관없이 있기만 하면 검색
SELECT * FROM emp  WHERE ename LIKE 'A%';  -- 첫글자가 'A'이면 검색 
SELECT * FROM emp  WHERE ename LIKE '%A';  -- 마지막글자가 'A'이면 검색
SELECT * FROM emp  WHERE ename LIKE '_A%'; -- 앞에서 두번째 자리가 'A'이면 검색
SELECT * FROM emp  WHERE ename LIKE '%A_'; -- 뒤에서 두번째 자리가 'A'이면 검색

--8
SELECT ename, job
FROM emp
WHERE ename LIKE '_A%' OR job LIKE '%MAN';

--9
SELECT ename, initcap(job) "Job", deptno FROM emp
WHERE initcap(job) LIKE '%'||initcap('man')||'%'; --첫글자만 대문자

SELECT ename, upper(job) "JOB", deptno FROM emp
WHERE upper(job) LIKE '%'||upper('man')||'%'; --모든 문자 대문자

SELECT ename, lower(job) "job", deptno FROM emp
WHERE lower(job) LIKE '%'||lower('man')||'%'; --모든 문자 소문자

--10
/*
문자열 길이 반환 함수에는 length와 lengthb가 있다
1. length(데이터/컬럼명) : 입력되는 문자열의 길이(글자수)를 반환하는 함수
2. lengthb(데이터/컬럼명) : 입력되는 문자열의 바이트를 반환하는 함수
* 한글은 영문과 달리 한 글자가 3byte인 경우가 있어서 
  영문은 length 와 lengthb가 같은 반면 한글을 그렇지 않아 한글과 영문의 길이의 차이가 나고
  length와 lengthb를 통해 이를 확인할 수 있다
*/

--11
/*
substr(문자열데이터, 시작위치, 시작위치의 개수) : 
	문자열 데이터를 시작위치와 마지막위치를 기준으로 절삭처리하여 사용, 코드성 데이터 활용에 용의
	ex) substr( 'sql*plus', 5, 4 ) ==> plus  : 다섯번째 자리부터 시작해서 4개의 문자를 추출
*/
--12
SELECT substr('991231-2022927', 1, 2)||'년 '|| 
       substr('991231-2022927', 3, 2)||'월 '||
       substr('991231-2022927', 5, 2)||'일생' "주민번호 991231-2022927"
FROM dual; 

--13
SELECT ename, job, instr(ename, 'A') A위치
FROM emp
WHERE instr(ename, 'A') >0 ;

/*
== 평가대비(오라클) 객관식 문제 ==
1. 
1) 비용이 많이 든다 O
2) 백업과 회복 방법이 복잡하다.O
3) 데이터에 대한 동시 공유, 보안, 회복 기능이 부족하다. X - 파일시스템의 단점
4) 중앙 집중 관리로 인한 취약점이 존재한다. O

2. 
1) 데이터를 파일로 관리 O
2) 파일을 생성·삭제·수정·검색하는 기능을 제공하는 소프트웨어 O
3) 응용 프로그램에 필요한 데이터를 공유해서 파일로 관리함 - X 공유는 파일시스템의 특징이 아님. 응용프로그램은 데이터 파일에 종속적이다
4) 같은 내용의 데이터가 여러 파일에 중복 저장된다. O

3. 
1) 보안 기능 : 권한이 없는 사용자의 접근, 허용되지 않는 데이터와 연산에 대한 요청 차단 X // 기능X 장점O
2) 정의 기능 : 데이터베이스 구조를 정의하거나 수정할 수 있다. O
3) 조작 기능 : 데이터를 삽입, 삭제, 수정, 검색하는 연산을 할 수 있다. O
4) 제어 기능 : 데이터를 항상 정확하고 안전하게 유지할 수 있다. O

4. 
    - 비정형 데이터를 처리하는데 적합하고 확장성이 뛰어남 - 4세대 데이터베이스 중 NoSQL DBMS
1) Oracle   -2세대 관계 DBMS
2) HBase    -4세대 NoSQL DBMS
3) Myria DB -2세대 관계 DBMS
4) Volt DB  -4세대 NewSQL DBMS : 관계DBMS의 장점 + NoSQ의 확장성과 유연성
 
5.
1) 관계 DBMS의 장점 + NoSQL의 확장성 및 유연성 O -NewSQL DBMS
2) Cassandra  X -NoSQL DBMS
3) 정형 및 비정형 데이터를 안정적이고 빠르게 처리 가능 O -NewSQL DBMS
4) Spanner O -NewSQL DBMS // Google Spanner, VoltDB, NuoDB
*/


