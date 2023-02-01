rn.rrnrn.rrnrn.rrn
/*
# to_number : 숫자형으로 반환
1. 매개변수로 받은 숫자형 문자열을 숫자로 변환하여 연산이 가능하도록 처리한다
2. 형식
	to_number('숫자형문자열')
cf) 주로 자동형변환이 일어나서 사용되지 않는 경우도 많으나, 
	명시적 처리로 해당 타입에 대한 구분을 명확히 하기 위해 사용된다
*/		
SELECT '25' +25 "자동형변환".
		to_number('25')+25 "명시적변환"
FROM dual;
--ex) 입사 분기별 보너스를 급여기준으로 
--    1사분기 100%, 2사분기 200%, 3사분기 300%, 4사분기 400%로 처리하기로했다
--	  사원명, 급여, 보너스, 급여+보너스를 출력하세요
SELECT  ename 사원명, sal 급여, 
		to_char(hiredate, 'Q') "입사분기",
		to_char(hiredate, 'Q')*100||'%' "보너스%", 	-- 묵시
		sal*to_char(hiredate, 'Q') 보너스,		    -- 묵시
		sal + sal*TO_NUMBER(to_char(hiredate, 'Q')) "급여+보너스" -- 명시
FROM emp;		


/*
# to_date : 날짜형으로 변환
1. 숫자와 문자로 구성된 문자열을 날짜 데이터로 변환시키는 함수
2. 기본 형식
	to_date(문자열데이터, '변환할 형식')
	해당 문자열이 어떤 데이터를 내포해 있는 형식을 지정하여 문자열 데이터를 숫자형으로 전환해서 입력가능하게 한다
	주로 숫자형 데이터를 등록, 수정 시 많이 사용된다
	ex) 기존 날짜형 데이터와 연산이 필요로 하는 경우
			@@ + 25, months_between(sysdate, @@)
		날짜형 데이터를 입력/수정 (문자열 ==> 날짜형)
3. 변환형식 - to_char()에서 날짜형 옵션 처리형식 내용이 사용된다
*/
SELECT floor(sysdate - to_date('2022-09-01', 'YYYY-MM-DD')) "9/1부터 오늘까지 날짜"
FROM dual;

--ex1) 2022-12-31 이 현재로부터 남은 날짜 수를 to_date 함수로 처리하여 출력하세요
SELECT floor(to_date('2022/12/31', 'YYYY/MM/DD')-sysdate) "2023까지 남은 날"
FROM dual;
--ex2) hiredate에서 입사년도만 현재년도로 바꿔서 날짜 데이터를 만든 후 사원명, 입사일을 출력하세요
SELECT  ename,
 		to_char(SYSDATE , 'YYYY') "현재 연도",
 		to_char(hiredate, 'MMDD') "입사 월일",
 		to_date(to_char(sysdate, 'YYYY')||to_char(hiredate, 'MMDD'), 'YYYYMMDD')"신 입사일"
FROM emp;


/*
# 중첩함수( f3( f2( f1(데이터, 매개변수), 매개변수 ), 매개변수 )
1. 가장 내부에 있는 함수 f1의 결과값을 다음 함수f2에 인수로 적용하고 
	다시 f2의 결과값을 f3에 인수로 사용할 때 활용하는 함수형태를 말한다.
	
	- 특정한 데이터에서 여러가지 함수의 기능을  처리하고자 할 때 활용된다
	- 가장 내부에 있는 함수부터 적용하여 리턴한 값을 외부 함수의 매개변수로 적용하여 처리된다
*/
/*
# 일반함수
1. nvl(데이터, null값일 때 처리할 데이터)
	해당 데이터가 nll값일 때 처리할 데이터를 설정함으로 null에 대한 연산 처리를 하는 것을 말한다
*/
SELECT ename, sal, comm, sal+comm, nvl(comm, 0), sal+nvl(comm, 0)
FROM emp;


/*
2. nvl2(데이터, null아닐 때 처리, null일 때 처리)
- comm이 null일 때는 100, null이 아닐 때는 comm에서 10% 더 추가해서 결과값 처리
*/
SELECT  ename, sal, comm, nvl2(comm, comm*1.1, 100) "보너스"
FROM emp;
--ex) comm이 null일 때는 sal의 15%로 설정하고 null이 아닐 때는 comm에서 sal의 5%를 더하여 보너스금액을 처리하세요
--    10단위 이상 절삭처기
SELECT  ename, sal, comm,
		trunc(nvl2(comm, comm+sal*0.05, sal*0.15),-1) "보너스"
FROM emp;

/*
# nullif(데이터1, 데이터2)
두 개의 매개변수로 받는 데이터를 비교하여 동일하면 null을 반환하고
동일 하지 않으면 첫번째 데이터1을 반환하는 함수를 말한다
*/
SELECT  NULLIF('a', 'a') show1,--- 동일해서 null
		Nullif('a', 'b') show2,--- not동일 a 
		Nullif( 15,  20) show3,--- NOT동일 15
		nvl(Nullif('a', 'a'), '동일') show4,
		nvl(Nullif('a', 'b'), '동일') show5
FROM dual;
-- nvl(nullif()) : 중첩함수로 동일할 때 처리한 데이터를 nvl로 처리한다

------------------------------------------
--ex) 급여의 보너스를 600으로 일괄 지급하기로 했는데 급여의 50%로 100단위 절삭과 동일하면 
--    600그대로 지급, 그렇지 않으면 급여의 comm으로 지급처리하여라
SELECT  ename, sal, comm,
		trunc(sal*0.5,-2) 기준,
		nvl2(NULLIF(600, trunc(sal*0.5,-2)),comm,600) 보너스
FROM emp;

/*
# decode함수
1. 프로그래밍 언어의 if문이나 case문으로 표현되는 내용을 하나의 함수로 처리할 수 있게 해준다
2. 기본 형식
	decode(데이터, 케이스1, 처리1, 케이스2, 처리2, ... 그외처리)
*/
SELECT  ename, deptno, 
		decode(deptno, 10, '인사',
					   20, '총무',
					   30, '회계',
					   '부서없음'
			  )part
FROM emp;
--ex) 사원번호기준으로 짝수이면 홍팀, 홀수이면 청팀으로 출력
--    사원명, 사원번호, 구분자, 팀
SELECT  ename 사원명, empno 사원번호, 
 		MOD(empno, 2) 구분자,
		decode(MOD(empno, 2), 0, '홍팀', 1, '청팀', ' ') 팀배정
--		decode(MOD(empno, 2), 0, '홍팀', '청팀') 팀배정
FROM emp;		
-- 실무예제 decode(mod()) : 숫자형데이터에서 특정단위로 구분하여 데이터를 처리할 때 
-- 						  둘 중에 하나일 때, 셋 중에 하나일 때는 나머지 값을 기준으로 처리
-- 						  floor(), ceil()
		
--ex) 직책을 기준으로 보너스를 50%, 80%, 100%, 120%, 150%를 주기로 했다
--    이름, 급여, 보너스%, 보너스 출력
--    - 조건 처리 시 일단, 항목이 규칙성이 있는지 여부를 판단(/, mod, * , ...) 
--      위 연산식으로 최솬 범위로 만든 후 decode나 case문이 필요할 때 활용한다
SELECT  ename 이름, sal 급여, job,
		decode(lower(job), 'clerk', 50, 'salesman', 80, 
		       'president', 100, 'manager', 120, 150)||'%' "보너스%",
		decode(lower(job), 'clerk', sal*0.5, 'salesman', sal*0.8, 
		       'president', sal*1.0, 'manager', sal*1.2, sal*1.5) 보너스
--        sal*decode(lower(job), 'clerk', 0.5, 'salesman', 0.8, 
--                   'president', 1.0, 'manager', 1.2, 'analyst', 1.5, 0.0) 보너스
FROM emp;

/*
# 일반 함수 case
1. decode의 확장된 함수 형식을 표현식 또는 컬럼값 '=' 비교를 통해 조건의 일치하는 경우에만
	다른 값을 대치하지만 case함수에서는 산술연산, 관계 연산, 논리 연산을 통해서 boolean으로
	범위를 지정하여 다양한 비교가 가능하게 해준다
2. 기본 형식
	1) *조건문 형태의 활용
		case when 논리|산술|관계 then 처리한 데이터
		case when 논리|산술|관계 then 처리한 데이터  : 상단에 when조건을 제외하고,...
		...
			else 위의 나열된 경우가 아닌 경우
		end
		주의 case when 구문의 앞에 선언조건식을 제외한 조건을 처리한다
			if( point >= 90 ){
			
			}else if(point >= 80){
	 	 // }else if(point <90 && point >= 80){  이렇게 하는 거 아님
	 	                                         else에서 point <90 내용을 포함하기때문에..
			
			}
			
	
	2) switch case 문 형태
		case 컬럼/데이터
			when  데이터1  then  처리할데이터		
			when  데이터1  then  처리할데이터		
			..
			else 그 외 처리 데이터
		end		
*/
-- 비교연산자
-- 부서에 따라 보너스를 다르게 처리
SELECT  ename, deptno,
		CASE WHEN deptno = 10 THEN sal*0.2
			 WHEN deptno = 20 THEN sal*0.5 
			 WHEN deptno = 30 THEN sal*0.7
			 ELSE sal*1.2
		END 보너스
FROM emp;		
-- =
SELECT  ename, deptno,
		CASE deptno
			 WHEN 10 THEN sal*0.2
			 WHEN 20 THEN sal*0.5 
			 WHEN 30 THEN sal*0.7
			 ELSE sal*1.2
		END 보너스2
FROM emp;

--boolean값
SELECT  ename, sal, 
		CASE WHEN sal>= 5000 THEN 'A등급'
			 WHEN sal>= 4000 THEN 'B등급' --sal<5000 AND  포함되어 있기에 필요X
			 WHEN sal>= 3000 THEN 'C등급'
			 WHEN sal>= 2000 THEN 'D등급'
			 WHEN sal>= 1000 THEN 'F등급'
			 ELSE '제적'
        END grade
FROM emp;        



