/*
# self join
1. 개요
	하나의 테이블 내에 있는 컬럼까지 연결하는 조인이 필요한 경우에 사용된다
	조인 대상 테이블이 자신 하나라는 것 외에는 equi join과 동일하다
2. where 절을 사용한 self join
	하나의 테이블에서 두 개의 컬럼을 연결하여 equi join
	from 절에서 하나의 테이블에 테이블 별치지정
	ex) 사원테이블에서 사원번호와 관리자번호는 self join하여 처리된다
3. select a.*, b.*
   from 테이블1 a, 테이블2 b
   where a.컬럼1 = b.컬럼2
    ex) 사원테이블의 self join 관계 있는 컬럼
    empno : 모든 사원의 고유번호로 key로 식별하여 사용된다
      mgr : 해당 사원의 관리자 번호로 위 empno에 등록된 번호여야 한다
    예를 들어 사원번호7369인 관리자 번호 mgr은 7902인데 이 관리자번호를 가진 사원은 FORD이다. 
    즉 SMITH의 관리자 FORD이고 이것은 emptno와 mgr이 self join을 통해서 나타난 결과이다

	답변형 게시판의 기본 글번호와 상위글번호는 계층형으로 상황 연관관계를 가지고 처리하고 있다
	
*/
SELECT e.empno, e.ename, e.mgr, m.ename, e.ename||'의 관리자는 '||m.ename||'이다!' msg
FROM emp e, emp m
WHERE e.mgr = m.empno;

--ex) 연봉이 @@@인 사원명 @@@의 관리자명은  @@@이고 연봉은 @@@입니다. 를 출력하세요
SELECT '연봉이 '||e.sal||'인 사원명 '||e.ename||'의 관리자명은 '||m.ename||'이고 연봉은 '||m.sal||'입니다.' "사원-관리자"
FROM emp e, emp m
WHERE e.mgr = m.empno;
--기본예제와 이전에 배웠던 여러가지 구문형태/함수 형태를 복합적으로 활용해서 원하는 정보를 뽑아낼 수 있어야 한다

-- 추후에 답변형 게시판도 원본글과 답글은 계층형 관계로서 위와 같은 계층형 데이터 처리를 하면 
-- 계층적 sql(start with, prior, siblings 등)키워드 활용

