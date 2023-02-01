/*
# 날짜 함수 
1. 날짜형 데이터 처리 process
	  +1 :  1일 이후를 의미한다
	1/24 :  1시간을 의미한다
	1) 날짜 데이터 단위
	1/1000(초) ==> 1초 ==> (60)1분 ==> (60)1시간 ==>(24)1일 ==> (28,29,30,31) 한 달 ==> (12) 1년
																	   add_month(날짜, 1)
2. 기본 연산
	날짜 +1  :해당 날짜의 1일 이후(시간을 포함해서 24시간 이후)
	날짜 -1  :해당 날짜의 -1일 이전
	날짜 +1/24 : 해당 날짜와 시간의 1시간 이후
	날짜 +200/24/60 : 해당 날짜와 시간의 200분 이후 
	ex) 1일을 기준으로 하기에 0.5 ==> 12시간
3. 기본 함수
	1) sysdate : 현재 날짜와 시간을 나타낸다

*/
SELECT sysdate FROM dual;
SELECT sysdate 현재,       sysdate +1 "1일후", 
	   sysdate -1 "1일전", sysdate +(10/24) "10시간 이후"
FROM dual;

SELECT ename, hiredate, hiredate-7 "입사 7일 전", hiredate+100 "입사100일이후"
FROM emp;

--ex) 사원명과 함께 인턴기간(입사후, 120일), 입사 8일전, 현재일 기준으로 근무일수(정수로 절삭) 출력하세요
SELECT ename, hiredate, hiredate+120 "인턴기간", hiredate-8 "입사 8일전", floor(sysdate-hiredate) "근무일수"
FROM emp;
/*
# 월 처리
1. 날짜형 데이터는 월단위가 유동적이기 때문에 30/31/29 등으로 유동적이어서 
   해당 월에 따라 함수로 이러한 월 계산 처리를 해주고 있다
2. 기본 형식
	months_between(날짜1, 날짜2) : 날짜 사이의 개월 수를 표시한다
	5/19, 6/19 ==> 1개월
	15 ==> 0.5개월
	- 소수점 이하의 데이터가 나오는 이유는 1이 개월 단위이기때문에 일은 1/30
	  시간은 1/30/24 등으로 연산을 하기 때문이다  
	주의) 월 30일, 31일, 29일 등 월단위의 개월 수 처리시 데이터 처리에 변수가 있는데
		 이것 때문에 기능함수를 이용하여야지 정확히 계산된다  
		    
*/
SELECT ename, hiredate, MONTHS_BETWEEN(sysdate, hiredate) "근무 개월수 1",
	   floor(MONTHS_BETWEEN(sysdate, hiredate)) "근무 개월수 2",
	   ceil(MONTHS_BETWEEN(sysdate, hiredate)) "근무 개월수 3"
FROM emp;

-- ex1) 오늘로 100이후의 개월 수, 1000일 이후 개월 수를 출력하세요
SELECT floor(MONTHS_BETWEEN(sysdate+100, sysdate)) "100이후의 개월 수", 
       floor(MONTHS_BETWEEN(sysdate+1000, sysdate)) "1000이후의 개월 수"
FROM dual;
-- ex2) 1000일 이후 연한(@@년 @@개월) 출력하세요
SELECT sysdate,sysdate+1000,
	   floor(MONTHS_BETWEEN(sysdate+1000, sysdate)) "1000이후의 개월 수",
	   floor(MONTHS_BETWEEN(sysdate+1000, sysdate)/12) "1000이후의 연한",
	   MOD(floor(MONTHS_BETWEEN(sysdate+1000, sysdate)), 12) "1000일 개월",
	   floor(MONTHS_BETWEEN(sysdate+1000, sysdate)/12)||'년 '
	   ||MOD(floor(MONTHS_BETWEEN(sysdate+1000, sysdate)), 12)||'개월' "@@년 @@개월"      
FROM dual;

/*
# 개월 수 추가 add_months
1. 특정한 날짜를 기준으로 개월 수를 추가하여 해당 이후 날짜는 해당 이전 개월 수에 날짜를 처리할 때 사용된다
2. 형식
	add_months(날짜, 추가 또는 이전개월 수)
*/
SELECT  sysdate 오늘, 
		add_months(sysdate,  4) "4개월 후",
	    add_months(SYSDATE, -1) "1개월 전"
FROM dual;	    

--ex) 사원정보를 기준으로 사원명, 입사일, 인턴기간(3개월), 입사10년, 입사20년을 출력하세요
SELECT  ename, hiredate, 
		add_months(hiredate, 3) "인턴기간(3개월)", 
		add_months(hiredate, 10*12) "입사 10년", 
		add_months(hiredate, 20*12) "입사 20년"
FROM emp;


/*
# 다가올 가장 빠른 요일의 날짜 : next_day
1. 해당 기준일로 명시된 요일에 가장 빠른 날짜
2. 기본 형식
	next_day(날짜데이터, '요일')
*/
SELECT next_day(sysdate, '일') "가장 빠른일요일"
FROM dual;

-- ex) 입사 후, 첫 토요일에 여행가기로 했다. 해당 날짜를 사원명과 함께 출력
SELECT  ename, next_day(hiredate, '토') "여행가는 날",
		next_day(next_day(next_day(hiredate, '일'),'일'),'일') "세번째 일요일"
FROM emp;

/*
# 월의 마지막날짜 또는 첫째날을 계산하는 코드 : last_day(날짜)
1. 해당 날짜가 속한 달의 마지막 날짜
2. 형식 :
	last_day(기준일) : 마지막 날짜
	add_months(last_day(기준일)+1, -1) : 해당 월의 첫 번째 날짜
*/
SELECT  last_day(sysdate) "이번달 마지막 날",
		last_day(sysdate)+1 "다음 달 첫 날",
		add_months(last_day(sysdate)+1,-1) "이번 달 첫 날"
FROM dual;	

/*
1. 급여일 : 근무일 다음 달 10일, 20일... 

*/
--ex) 사원명과 급여일1(종료일 -10일 전), 보너스일(다음 달 10일)
SELECT  ename, hiredate, 
		LAST_DAY(hiredate)-10 "급여일1", 
		LAST_DAY(hiredate)+10 "보너스일"
FROM emp;




