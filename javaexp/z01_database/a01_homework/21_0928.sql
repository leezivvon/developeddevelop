/*
2022-09-28
[1단계:코드] 1. salgrade 테이블 전체를 조회하고, 해당 컬럼을 조회해보세요.
[1단계:개념] 2. lpad, rpad의 기본형식과 예제를 기술하세요
[1단계:코드] 3. 사원명을 10자리 기준 '&'는 왼쪽에, 직책명을 10자리기준 '!' 오른쪽으로 덧붙여 설정하여 출력하세요.
[1단계:개념] 4. trim 처리 함수 3가지를 기술하고, 해당 옵션에 대하여 기술하세요.
[1단계:개념] 5. 숫자형 함수에서 소숫점 이하에 대한 처리를 예제와 함께 기술하세요.
[1단계:코드] 6. 급여를 부서번호(10==> 10%, 20==> 20%..)기준으로 인상을 하기로 했다.
         현재 급여와 인상된 급여를 처리하되 100자리 단위로 절삭하여, 사원명과 함께 출력하세요.
[1단계:코드] 7. 사번을 기준으로 홀수인 경우 급여기준으로 보너스를 50% 추가하여 급여를 계산하기로 했다.
         이름, 사번, 구분, 급여, 총급여   를 출력하세요.
[1단계:개념] 8. 날짜 처리 단위별(초,분,시,일) 정리하고 예제를 dual 테이블로 나타내세요.
[1단계:개념] 9. 날짜형 함수의 종류에 대하여 기술하세요.
[1단계:코드] 10. 사원명과 함께 근무연한을 @@년 @@개월 @@일이라고 표시하세요. (여러가지 중첩 함수 이용)
[1단계:코드] 11. @@월 @@째 수요일 등을 미국에서 쓰이는 공휴일 처리 방식인, 한국의 선거일의
      경우 임기종료 @@주째 전 수요일같이 날짜를 요일에 대한 날짜를 계산할 때 사용된다.
         오늘로 부터 3개월 후 해당월의 3번째 수요일을 출력하세요.
[1단계:코드] 12. 사원의 첫급여일이 다음달 첫 날로 지정하였다. 급여일과 입사월의 근무일수를 출력하세요..      
*/

--1
SELECT s.*, trunc(losal, -2) 절단losal, trunc(hisal, -2) 절단hisal
FROM salgrade s;

--2
/*
# lpad(left padding), rpad(right padding)
1. 전체 문자의 크기를 지정하고 그 크기에 못 미칠 때 왼쪽/오른쪽에 특정한 문자를 추가하는 기능
2. 형식
	lpad(데이터, 크기, 덧붙일 문자열)
	rpad(데이터, 크기, 덧붙일 문자열)
*/
SELECT lpad('안녕', 5, '*') show1, 
       rpad('안녕', 5, '#') show2 --문자의 크기가 byte 크기, 즉 lengthb() 인가 봄 
FROM dual;

--3
SELECT ename, lpad(ename, 10, '&'), job, rpad(job, 10, '!')
FROM emp;

--4
/*
trim 함수
trim은 절삭이라는 말로 오른쪽 또는 왼쪽에 있는 특정한 문자열을 삭제 처리할 때 사용된다
	1) ltrim(데이터, '제거할 문자') : 왼쪽에 제거할 문자를 없애주는데 반복적으로 처리된다
	2) rtrim(데이터, '제거할 문자') : 오른쪽에 제거할 문자를 없애주는데 반복적으로 처리된다
	3) trim('양쪽에 삭제할 문자', from 데이터) : 오른쪽/왼쪽 끝에 제거할 문자가 있을 때 한 번에 제거 처리한다
ex) 웹에서 등록하거나 조회할 때 space 입력오류를 trim()으로 등록 또는 검색하여 해결할 수 있다
*/
SELECT ltrim('*****짠*****', '*')    "ltrim",
       rtrim('*****짠*****', '*')    "rtrim",
       trim('*' FROM '*****짠*****') "trim"
FROM dual;

--5 숫자형 함수에서 소숫점 이하에 대한 처리를 예제와 함께 기술하세요.
/*
숫자형 처리함수
1) round(데이터, 자리수) : 지정한 소수점 자리까지 반올림 처리를 해주는 함수
2) trunc(데이터, 자리수) : 지정한 소수점 자리까지 남기고 절삭처리
						자리수는 round와 동일하게 해당 자리수만큼 절삭처리해준다
3) ceil(데이터)  : 해당 데이터를 정수형으로 올림 처리한다
4) floor(데이터) : 해당 데이터를 정수형으로 내림 처리한다

    자리수 : + : 소수점 이하 자리수를 말하고 
		   -  : 10단위(-1), 100단위(-2)로 반올림 처리를 하는 것을 말한다
*/
SELECT  round(29.952345, 1) "29.95 round",
		trunc(29.952345, 1) "29.95 trunc",
		CEIL (29.952345) "29.95 ceil",
		floor(29.952345) "29.95 floor"
FROM dual;		

--6
SELECT * FROM emp;
SELECT ename "사원명", trunc(sal, -2) "현재 급여", trunc(sal+sal*deptno/100, -2) "인상된 급여"
FROM emp;
--정답
SELECT 	ename, sal 현재급여, deptno||'%', deptno/100, 
		(sal*deptno/100) "인상액"
		trunc(sal+(sal*deptno/100),-2) "인상급여(최종)"
FROM emp;

--7
SELECT ename 이름, empno 사번, mod(empno,2) 구분, sal 급여, sal*1.5+nvl(comm, 0) 총급여
FROM emp
WHERE MOD(empno, 2)=1;

--8
SELECT  sysdate, 
		sysdate  + 1/24/60/60 "+1초", 
		sysdate  + 1/24/60    "+1분",
		sysdate  + 1/24       "+1시간",
		sysdate  + 1          "+1일"
FROM dual;

--9
/*
날짜 함수
1. sysdate : 현재 날짜와 시간
2. 기본 연산
	날짜 +1  :해당 날짜의 1일 이후
	날짜 -1  :해당 날짜의 -1일 이전
	날짜 +1/24 : 해당 날짜와 시간의 1시간 후
	날짜 +1/24/60 : 해당 날짜와 시간의 1분 후
	날짜 +1/24/60/60 : 해당 날짜와 시간의 1초 후
3. months_between(날짜1, 날짜2)        : 날짜 사이의 개월 수 표시
4. add_months(날짜, 추가 또는 이전개월 수) : 특정한 날짜를 기준으로 개월 수 추가	
5. next_day(날짜데이터, '요일')          : 명시한 기준일로부터 명시된 요일에 가장 빠른 날짜
6. last_day(기준일)                    : 해당 날짜가 속한 달의 마지막 날짜
	
	응용) add_months(last_day(기준일)+1, -1)  : 해당 월의 첫 번째 날짜
*/ 

--10
SELECT  ename 사원명, hiredate 입사일, 
		floor(MONTHS_BETWEEN(sysdate, hiredate)/12)||'년 '||
		floor(MOD(MONTHS_BETWEEN(sysdate, hiredate),12))||'개월 '||
		floor(MOD((MONTHS_BETWEEN(sysdate, hiredate)/12),30))||'일 ' "근무연한"
	FROM emp;	
--정답
/*
1. 전체근무개월 수 현재일과 입사일을 차를 통해 도출 
	 floor(months_between(sysdate, hiredate))
2. 근무 연한 계산 위 근무개월수를 /12로 처리
	
3. 근무 개월수 위 전체 근무개월수를 mod(전체근무개월수, 12)
	mod( floor(months_between(sysdate, hiredate)),12)
4. 연도/근무개월수를 제외한 날짜계산
		전체 근무개월수 : 나머지 날짜를 뺀 순수한 개월수만 처리한 데이터
					  그러므로 해당 개월수에 날짜는 나머지 일수가 포함되어 있지 않다
  	식의 도출 과정
  	 1) 전체 개월 수 산정(현재일과 입사일) : 
  	 	months_between(sysdate, hiredate)
  	 2) 입사일로부터 전체개월 수 : 남은 날짜를 제외한 개월수에 대한 날짜를 처 
	 	==> add_months(입사일, 전체개월수)
	 	
	 	2021/09/14 입사일, 현재날짜 2022/9/29 이면
	 	months_between(sysdate, hiredate) ==> 12.5..
	 	나머지 날짜를 구하려면 일단 월단위로 처리되는 날짜(2022/9/14)를 먼저 구하고
	 	sysdate - 구한날짜 : 실제 나머지 근무일수가 처리
	 		sysdate - add_months(2021/9/14, 개월수)
	 		현재 날 - 2022/9/14
 	
	 3) 현재날짜와 위 남은 날짜가 포함되지 않는 날짜를 빼주면 근무연도/근무월을 뺀 나머지 날짜를 도출할 수 있다   
*/
SELECT  ename, hiredate,
--		floor(months_between(sysdate, hiredate)) "전체 개월수",
--		floor(months_between(sysdate, hiredate)/12) "근무 연한",
		MOD(floor(months_between(sysdate, hiredate)),12) "월",
		ADD_MONTHS(hiredate, floor(months_between(sysdate,hiredate))) "날짜1" --결과값이 오늘날짜와 차이가 있다
		floor(sysdate - ADD_MONTHS(hiredate, floor(months_between(sysdate,hiredate)))) "날짜2" -- @@일
FROM emp;	
/*
위와 같이 연산된 내용이 중복적인 복잡한 내용은 inlineView라는 개념으로 효과적으로 처리될 수 있다
SELECT *
FROM(
	sql을 통해 가상의 테이블 데이터 생성
)
*/
SELECT ename,
	floor(mm/12)||'년 '||MOD(mm,12)||'개월 '||
	floor(sysdate - add_months(hiredate,mm)||'일' "근무기간"
from(
	SELECT ename, hiredate, floor(months_between(sysdate,hiredate))) mm 
	FROM emp --inlineView라는 가상테이블에서 중복되는 코드를 mm으로 바꿔주고 던진다
);


--11
SELECT next_day(next_day(next_day(ADD_MONTHS(SYSDATE, +3),'수'),'수'),'수') "3개월 후 3번째 수요일"
FROM dual;

SELECT next_day(add_months(sysdate,+3)+7*2,'수') "3개월 후 3번째 수요일"
FROM dual;

--12
SELECT  ename "사원명", hiredate "입사일", 
		last_day(hiredate)+1 "첫 급여일",
--		MOD(months_BETWEEN(last_day(hiredate)+1, hiredate),12)*30 "근무일수",	-- 2월은 어떻게 처리..	
        (last_day(hiredate)+1) - hiredate "근무일 수"
FROM emp;		




/*
== 평가대비(데이터베이스) 객관식 문제 ==
1.
1) 스키마       	-데이터베이스에 저장되는 데이터 구조와 제약조건을 정의한 것
2) 레코드        	-데이터베이스에서 하나의 단위로 취급되는 자료의 집합// 가로방향으로 한 줄
3) 시스템 카타로그 	-데이터 사전이라고도 하며 메타 데이터를 유지하는 시스템
4) 인스턴스   		-스키마에 따라 데이터베이스에 실제로 저장되는 값
정답1

2. 
1) 외부 단계    - 데이터베이스를 개별 사용자 관점에서 이해하고 표현하는 단계
2) 논리 단계 X  - 개념단계
3) 개발 사용자 관점 = 외부단계
4) 내부 단계    - 데이터베이스를 저장 장치의 관점에서 이해하고 표현하는 단계

3. 
1) 각 사용자가 생각하는 데이터베이스의 모습, 즉 논리적 구조로 사용자마다 다름 X - 외부단계
2) 조직 전체의 관점에서 생각하는 데이터베이스의 모습 O  - 개념단계
3) 서브 스키마(sub schema)라고도 함 	X			- 외부단계
4) 전체 데이터베이스가 저장 장치에 실제로 저장되는 방법을 정의한 것 X	- 내부단계
*/

