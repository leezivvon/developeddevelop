/*
2022-09-29
[1단계:개념] 1. 명시적 형변환 함수 3가지를 기본 예제와 함께 기술하세요
[1단계:코드] 2. 2/4분기에 입사한 사원을 다음 양식으로 표현하세요
             @@@ -  @/4분기 공채입사자  @@월 @@째주 입사
[1단계:코드] 3. 분기별 입사자에게 급여의 30%,60%,90%,120%로 각가 보너스 금액을 산정할 때,
             입사자 분기 보너스(%) 급여 보너스 급여+보너스 를 출력하세요(decode,case문 사용X)
[1단계:개념] 4. 숫자 처리 기본형식을 예제와 함께 기술하세요.
[1단계:개념] 5. 명시적 형변환과 묵시적 형변환의 차이점을 기술하세요.
[1단계:코드] 6. 사원정보의 입사일에서 2000-01-01/2010-06-01/2020-12-31까지의 입사연한/개월 수를 표현하세요
[1단계:개념] 7. null관련 함수를 기본 예제와 함께 기능을 기술하세요
[1단계:코드] 8. 회사에서 일괄보너스 지급 금액이 60이라고 정하는데, 연봉의 5%(10단위로 절삭)와 같으면 60, 다르면 연봉의 5%로 처리하는 sql을 작성하세요.
[1단계:코드] 9. 입사일의 분기(1~4)를 기준으로 출장으로 가기로 했다. 1: 부산,  2: 광주, 3:제주  4: 하와이 
                사원명, 입사일, 분기, 출장지 를 출력하세요
[1단계:코드] 10. 급여의 구간별로 등급을 만들어, 사원번호, 이름, 급여, 등급을 출력하세요
                ex) 0~999 'A', 1000~2999 'B'...
                1) decode문 처리
                2) case문 처리
*/
--1
/*
- to_char(컬럼/데이터, '변환형식') : 숫자/날짜 타입을 문자열로 변환해주는 함수
- to_number(컬럼/데이터) : 날짜/문자 타입을 숫자로 변환해주는 함수
- to_date(컬럼/데이터)   : 문자/숫자 타입을 날짜로 변환해주는 함수	
*/
-- 예시 to_char/to_number
-- 10월에 입사한 사원들 연봉 인상
SELECT ename, hiredate, sal+to_number('100') 연봉인상
FROM emp 
WHERE to_char(hiredate) LIKE '%10/__';

--2
SELECT  ename||'- '||to_char(hiredate, 'Q"/4분기 공채 입사자" MM"월" W"째주 입사"') "2/4분기에 입사한 사원 목록"
FROM emp
WHERE to_char(hiredate, 'Q') = '2';

--3
SELECT  ename 사원명, sal 급여, 
        to_char(hiredate,'Q"/4분기"')  "입사 분기",
		30*to_char(hiredate,'Q')||'%' "보너스%",
		sal*to_char(hiredate,'Q')*0.3 "보너스",
		sal+sal*to_char(hiredate,'Q')*0.3 "총 급여"
FROM emp;	
/*
-- 3 정답 
-- 처리순서
	1) 분기 처리		to_char(hiredate, 'Q') : 1, 2, 3, 4
	2) 보너스 표시  	1, 2, 3, 4 *30
	3) 보너스    		sal*(1, 2, 3, 4)*0.3
	4) 급여+보너스		sal+보너스
*/
--subquery이용
SELECT  ename, 분기, sal,
	   	q*30||'%' "보너스(%)", sal*q*0.3 보너스, sal+(sal*q*0.3) "합산(급여+보너스)"
FROM (
	SELECT  ename, sal,
        	to_NUMBER(to_char(hiredate,'Q')) q,
			to_char(hiredate,'Q') "분기"
    FROM emp    	
);

		
--4
-- 숫자 >> 문자 : to_char(숫자형 데이터, '형식')
SELECT  ename, sal,
		to_char(sal,'9999') "형식1",   --  자기 자리수에 맞게
		to_char(sal,'0000') "형식2",   --  해당 자리수 이하일때는 0으로 채워짐
		to_char(sal,'$9999') "형식3",  --  앞에 $표기 처리 & 자기 자리수에 맞게
		to_char(sal,'9,999') "형식4",  --  ,를 표기하는 위치 지정
		to_char(sal,'9,999.999') "형식5" --  소수점 자리수 지정 
	    --  해당 자리수 이상의 데이터가 처리될 때는 ###
FROM emp;
-- 숫자 >> 날짜 : to_date('문자열데이터', '변환할 형식')

--5 묵시적 타입변환은 명시적 타입변환과 달리 서버의 판단에 무리를 주지않고 index나 기타 데이터처리에 효율화를 줄 수 있다	
SELECT * FROM emp;
--6
SELECT  ename, 
		floor((to_date('2000-01-01', 'YYYY/MM/DD') - hiredate)/30)     "~000101 입사 개월수",
		floor((to_date('2000-01-01', 'YYYY/MM/DD') - hiredate)/30/12)  "~000101 입사 연한",
		floor((to_date('2010-06-01', 'YYYY/MM/DD') - hiredate)/30)     "~100601 입사 개월수",
		floor((to_date('2010-06-01', 'YYYY/MM/DD') - hiredate)/30/12)  "~100601 입사 연한",
		floor((to_date('2020-12-31', 'YYYY/MM/DD') - hiredate)/30)     "~201231 입사 개월수",
		floor((to_date('2020-12-31', 'YYYY/MM/DD') - hiredate)/30/12)  "~201231 입사 연한"
FROM emp;
-- 이건 틀림 왜냐하면 날짜를 /30으로 나누는 건 31,29 고려X
/*
-- 6 정답
-- 처리순서
	1) 문자열을 날짜형으로 변환 to_date('2000-01-01', 'YYYY-MM-DD') 근무1
	2) 전체 개월수 표시 months_between(기준날짜, hiredate)
	3) 근무연한 : floor(전체개월 수 /12) - 나머지 개월수는 절삭처리
	4) 근무연한을 뺀 근무개월수	: mod(전체 개월수, 12) 
							 -mod는 나머지를 처리하기 때문에 몫인 근무연한은 빠지고 나머지값인 개월수만 추출
*/
SELECT  ename, 
		to_char(hiredate, 'YYYY"년" MM"월" DD"일"') 입사일, 
		floor(ch1/12)||'년 '||mod(floor(ch1),12)||'개월 ' "~200110 근무연한",
--		floor(ch1/12)||'년 '||floor(mod(ch1,12))||'개월 ' "~200110 근무연한", 같음
		floor(ch2/12)||'년 '||mod(floor(ch2),12)||'개월 ' "~100601 근무연한",
		floor(ch3/12)||'년 '||mod(floor(ch3),12)||'개월 ' "~201231 근무연한"
FROM(
  		SELECT  ename,hiredate,
			 	months_between(to_date('2000-01-01', 'YYYY-MM-DD'),hiredate) ch1, 	
			 	months_between(to_date('2010-06-01', 'YYYY-MM-DD'),hiredate) ch2, 	
			 	months_between(to_date('2020-12-31', 'YYYY-MM-DD'),hiredate) ch3 	
		FROM emp
);


--7
/*
1) nvl(데이터, null값일 때 처리할 데이터)
	해당 데이터가 nll값일 때 처리할 데이터를 설정함으로 null에 대한 연산 처리
		SELECT ename, sal+comm, sal+nvl(comm, 0)
    	FROM emp;
    	
2) nvl2(데이터, null아닐 때 처리, null일 때 처리)    
		SELECT  ename, comm, nvl2(comm, comm*1.1, 100) "보너스"
    	FROM emp;

3) nullif(데이터1, 데이터2)  
	두 개의 매개변수 데이터를 비교하여 동일하면 null 출력, 아니면 첫번째 데이터를 출력하는 함수  	     
*/

--8 ,7-3예제
SELECT ename, sal, 
       trunc(sal*0.05,-1) "연봉의 5%",
--     NULLIF(trunc(sal*0.05,-1), 60) "60과동일여부", --NULL/첫번째 데이터
       nvl(NULLIF(trunc(sal*0.05,-1), 60),60) "최종보너스"
       -- null일때는 60, 그 외는 첫번째 데이터
FROM emp;       
/*
-- 8정답
-- 처리순서
	1) 연봉의 5%를 10단위 처리	: trunc(sal*0.05, -1)
	2) 기준 금액 60과 비교 처리	: nullif(연봉5%, 60)
	3) 같으면 60, 다르면 연봉의 5%로 :	nvl (데이터, null일때) 
									 : 같으면(null) 이면 특정한 데이터, 다르면 연봉 5% 처리
									   nvl(기준, 60) ==> null이 나오면 60, 그렇지 않으면 5%	
									nvl2(데이터, null아닐때, null일때)												
*/
--9
SELECT  ename 사원명, 
		to_char(hiredate, 'MONDD"일"') 입사일,
		to_char(hiredate, 'Q"/4분기"') 입사분기,
		decode(to_char(hiredate, 'Q'), 1, '부산', 2, '광주', 3, '제주', '하와이') 출장지
FROM emp;		

-- 10
-- decode문 >> 부등호 사용X
SELECT  empno 사원번호, ename 이름, sal 급여,
		decode(trunc(sal,-3), 5000, 'A', 3000, 'B', 2000, 'C', 1000, 'D', 'E')||' 등급' "급여 등급"
FROM emp;
-- case문 
SELECT  empno 사원번호, ename 이름, sal 급여,
		CASE WHEN sal>4000  THEN 'A'
			 WHEN sal>3000  THEN 'B'
			 WHEN sal>2000  THEN 'C'
			 WHEN sal>1000  THEN 'D'
			 ELSE 'E'
		END||' 등급' "급여 등급" 	
FROM emp;
/*
--10 정답
--처리 순서
	1) decode문 처리
		등급구간별로 데이터 처리에 대한 규칙성 확인(사칙연산, mod), floor(), ceil()
		sal/1000
		1000단위로 나누어서 floor
		0~999 ==>0, 1000~1999 ==>1, 2000~2999 ==>2, 3000~3999 ==>3
		규칙성이 파악되면 해당 규칙성에 따라 decode를 처리

*/
SELECT  ename, sal, floor(sal/1000) g1,
		decode(floor(sal/1000), 
		0,'A' , 1,'B' , 2,'C' , 3,'D' , 4,'E' , 5,'F' , '등급범위벗어남') 등급
FROM emp;



/*
== 평가대비(오라클) 객관식 문제 ==
1. 
1) 문자열 2) 숫자형 3) 불형 4) 날짜형
정답 3

2. 
1) 세기 - CC   O
2) 월 - MMM    X  - MM/MONTH/MON
3) 날짜 - D    O   + DDD/DD
4) 분기 - Q    O
정답 2

3. 
1) 저장기술  O - 하둡, NoSQL
2) 분석기술  O - 기계학습, 데이터마이닝
3) 표현기술  O - 데이터 시각화
4) 실용기술  X
정답 4

4.
**DIKW (Data-INformation_Knowledge-Wisdom)
1) 문서    	X  -지식
2) 데이터		O  -data
3) 정보    	O  -information
4) 지혜    	O  -wisdom
정답1 

5. 
1) YYYY	: 년도
2) DAY  : 요일+DY  	--일:DDD/DD/D
3) MI  	: 분 	
4) Q   	: 분기
정답3






*/



