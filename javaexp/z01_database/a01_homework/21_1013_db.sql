/*
2. 다음의 내용을 dao 처리를 하세요
1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요    
5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
*/

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM SALGRADE;

--1
SELECT ename, dname, sal, grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno 
AND sal BETWEEN losal AND hisal
AND (to_char(hiredate, 'Q') = '1'
OR dname = 'SALES');

--2
SELECT count(HIREDATE), max(sal)
FROM EMP
GROUP BY TO_char(hiredate, 'YYYY');
--2정답
SELECT TO_char(hiredate, 'YYYY') year, count(*) count, max(sal) sal
FROM EMP
GROUP BY TO_char(hiredate, 'YYYY');
/*
VO객체 생성

class Emp02{
	private String year;
	private int cnt;
	private double sal
}
*/

--3
SELECT  ename, empno, MOD(empno,2) 구분, sal 급여, 
		decode(MOD(empno,2), 1, 50, 100)||'%' "보너스(%)",  
		decode(MOD(empno,2), 1, sal*1.5, sal*2) 총급여
FROM EMP;
--3정답
--subquery로 
SELECT  e.*, docode(div, 0, '짝', '홀') div2,
		decode(div, 1, '50%', '100%') bonus_per, -- 보너스 표시
		round(decode(div, 1, 0.5, 1)*sal) bonus,	-- 보너스 금액
		sal+round(decode(div, 1, 0.5, 1)*sal) tot	-- 총 급여
FROM (
	SELECT  ename, empno, MOD(empno,2) div, sal
	FROM EMP
	) e
WHERE div IN ( 0, 1 ) ;
-- 프로그램상에 0 : 짝,  1 : 홀,  0,1 : 전체
/*
VO
매개변수 : String div
class Emp03{
	private String ename; // 출력할 내용
	private int empno;
	private String div2;
	private double sal;
	private String bonus_per;
	private int bonus;
	private int totpay;
}
public List<Emp03> getEmp03List(String div){
	List<Emp03> list = new ArrayList<Emp03>();
	
	return list;
}


*/



--4
SELECT  ename,
		FLOOR(MONTHS_BETWEEN(sysdate, hiredate)/12)||'년 '||
		MOD(floor(MONTHS_BETWEEN(sysdate, hiredate)), 12)||'개월' "근무연한/개월"
FROM emp
WHERE to_char(hiredate, 'YYYY/MM/DD') ='1980/12/17';
--4 정답
SELECT  ename,
		floor(mm/12)||'년 '||floor(MOD(mm, 12))||'개월' workmonth
FROM (
	SELECT 	ename, 
			months_between(to_date('2001/01/01', 'YYYY/MM/DD'), hiredate) mm
	FROM emp 
) e;
/*
class Exp04{
	private String ename,
	private String workmonth;
}

public List<Exp04> getExp04List(String std)
// std는 기준 날짜인듯
*/

--5
SELECT *
FROM EMP
WHERE to_char(hiredate, 'Q') = (
	SELECT to_char(hiredate, 'Q')
	FROM EMP
	WHERE ename = upper('allen')
);
--VO
--public List<Emp> getExp05(String ename){}

--6
SELECT e.ename, e.deptno, e.sal
FROM emp e, emp m
WHERE e.mgr = m.empno
AND m.ename = 'BLAKE';
--6정답
SELECT ename, sal, DEPTNO 
FROM emp
WHERE mgr IN (
	SELECT EMPNO 
	FROM EMP 
	WHERE ename = 'BLAKE'
);


--7
SELECT *
FROM EMP
WHERE deptno IN (
	SELECT deptno
	FROM EMP
	WHERE TO_char(hiredate, 'MM') = '02'
);
/*
VO Emp
public List<Emp> gwtExp07(String mm){}

*/













