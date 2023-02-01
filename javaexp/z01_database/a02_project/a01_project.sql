--컬럼수정
ALTER TABLE pdept 
MODIFY (
	loc varchar2(50)
);
--데이터수정
UPDATE pdept 
   SET dname = 'SALES글로벌'
 WHERE deptno =502;

SELECT * FROM PPSCHEDULE10;
--정리
--부서정보
SELECT * FROM pdept ORDER BY deptno;
--입사정보 -사원번호부여
SELECT * FROM pjoin ORDER BY entrydate;
--인사정보
SELECT * FROM pemp;




--1. 부서정보
SELECT * FROM pdept ORDER BY deptno;

CREATE TABLE pdept(
	deptno number(3) PRIMARY KEY,
	dname varchar2(50)
	loc varchar2(50)
);
--관리자
--부서정보 등록
INSERT INTO pdept VALUES (501, 'SALES(국내)', '서울 강남구');
INSERT INTO pdept VALUES (507, '지원', '서울 강남구');
--부서정보 전체 삭제
DELETE FROM pdept 
WHERE deptno = 600;

--근로자
--부서정보 검색
SELECT d.*, nvl2(e.ct, e.ct, 0)||' 명' ctp
FROM pdept d, ( SELECT deptno, count(deptno) ct
			   FROM pemp 
			   GROUP BY deptno ) e
WHERE e.deptno(+)=d.deptno
AND dname LIKE '%'||upper('a')||'%'
ORDER BY d.deptno;

--사원-대리-과장-차장-부장
--2. 입사정보
CREATE TABLE pjoin (
	empno varchar2(10) PRIMARY KEY,
	entrydate DATE,
	entrypos varchar2(20),
	deptno number(3) REFERENCES pdept(deptno)
);
DROP SEQUENCE pjoin_seq;
CREATE SEQUENCE pjoin_seq
START WITH 10
MINVALUE 10
MAXVALUE 99;

--관리자
--입사사정보등록(사원번호배정)
INSERT INTO pjoin VALUES ( substr('20220321', 3, 4)||pjoin_seq.nextval, 
		to_date('20220321', 'YYYYMMDD'), '사원', 501);
-- substr(문자열데이터, 시작위치, 시작위치의 개수)

	
--3.사원정보
SELECT * FROM pemp;	

CREATE TABLE pemp (
	empno varchar2(10) REFERENCES pjoin(empno) ,
	ename varchar2(50),
	deptno number(3) REFERENCES pdept(deptno),
	pos varchar2(20),
	birthd DATE,
	address varchar2(50),
	pass varchar2(30)
);

--관리자
--인사정보등록(비밀번호생성 )
INSERT INTO pemp VALUES ( '사원번호', '사원명', 507, '직급', 
			to_date('19970101','YYYYMMDD'), '주소', '비밀번호');
--부서이동
UPDATE PEMP 
   SET deptno = 999
 WHERE ename = '오인주';
--인사정보수정
--UPDATE PEMP 
--   SET pos = ''   // ename, deptno, pos, address
-- WHERE ename = '';
--인사정보삭제
DELETE FROM pemp
WHERE empno = '090311'; 

--인사정보 검색
SELECT *
FROM pemp
WHERE ename LIKE '%'||'인주'||'%'
ORDER BY empno;



--4.인사평가
CREATE TABLE ppfapp(
	empno varchar2(10) REFERENCES pjoin(empno),
	pfapdate DATE,
	pfapscore NUMBER, --5점만점기준
	prresult varchar2(50),
	impinfo varchar2(50)
);

--인사 평가 등록
INSERT INTO ppfapp VALUES ('210315', sysdate, 3.7, '방대한 업무량을 소화', '성실한 자세 요망');

--인사 평가 조회
SELECT pfapdate, dname, pos, ename, prresult, impinfo
FROM pemp e, ppfapp pf, pdept d 
WHERE e.deptno = d.deptno 
AND e.empno = pf.EMPNO 
AND e.empno = '210315' ;


--5.퇴사자정보
CREATE TABLE pretire(
	empno varchar2(10) REFERENCES pjoin(empno),
	retiredate DATE,
	retirereason varchar2(100),
	ph varchar2(20)
);
--퇴사정보 등록
INSERT INTO pretire VALUES ('empno', to_date('2022/10/21', 'YYYY/MM/DD'), '개인적인 사정으로 퇴사', '010-1234-5678');


--퇴사정보 조회
SELECT e.empno, ename, dname, pos, entrydate, retiredate, address, retirereason
FROM pemp e, pdept d, pretire rt, pjoin j
WHERE e.empno = rt.empno
AND e.deptno = d.deptno
AND e.empno = j.empno;

SELECT * FROM pretire;

--6.비밀번호 변경
UPDATE PEMP 
   SET pass = ''
 WHERE ename = '오인주'; 

--로그인
SELECT * FROM pemp
WHERE empno =
AND pass= ;

SELECT empno, pass, grd
FROM pemp e, ppos p
WHERE e.pos = p.pos
AND empno = '040310'
AND pass = 'KI_h[d';

SELECT empno, grd, p.pos
FROM pemp e, ppos p
WHERE e.pos=p.pos
AND empno = '사원번호';





SELECT * FROM pemp;
SELECT * FROM pjoin ORDER BY empno;
SELECT * FROM PRETIRE;

SELECT e.*, j.*
FROM pemp e, pjoin j
WHERE j.empno = e.empno(+)
ORDER BY e.empno;

DELETE FROM pjoin WHERE empno = '';

UPDATE PEMP
   SET pos = '부장'
 WHERE ename = '최도일'; 



INSERT INTO pemp VALUES ( '180311' , '송노동', 509, '대리','19900219', '경기도 성남시','#@$3f3');

INSERT INTO pjoin VALUES ('')
INSERT INTO pjoin VALUES ('20190324')



SELECT * FROM PVACATION;
SELECT * FROM PCOMMUTE;

SELECT v.empno, cdate
FROM pvacation v, pcommute c
WHERE v.empno = c.empno
AND cdate BETWEEN vacfdate AND vacldate
AND v.empno = '210314'
ORDER BY cdate DESC;


SELECT ename, v.* FROM pvacation v, pemp e
WHERE v.empno =e.empno;

SELECT * from pcommute;

SELECT * FROM pdept;
SELECT dname, e.empno, POS
FROM pemp e, pdept d
WHERE e.deptno =d.deptno;


--염직원 210315
--심직원 210314

--진화영  030310
--오인주  160312

SELECT empno, deptno, ename, pos, pass FROM pemp ORDER BY empno;

DELETE pcommute WHERE to_char(cdate, 'YYMMDD') = '221028';



SELECT * FROM pdept;

