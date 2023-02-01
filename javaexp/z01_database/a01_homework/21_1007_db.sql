/*
# 다음 내용을 모두 포함하는 데이터베이스를 설계하세요
( 설계-erd그리는거 + 테이블 생성-제약사항포함 + 데이터 입력 )

1. 회사는 네 개의 부서를 운영한다. 부서는(부서번호, 부서이름)을 저장한다
2. 부서는 1명 이상의 직원(직원번호, 직원이름, 직책)을 두고 있다
   각 직원은 하나의 부서에 소속된다
3. 직원은 부양가족(이름, 나이)이 있을 수 있다
4. 각 직원은 근무했던 부서에 대한 근무 기록(기간, 직책)이 있다  

	~월요일 6시까지
*/

--인사hr01 고객센터cs02 영업sales03 회계acc04
CREATE TABLE depart(
	dno number(3),
	dname varchar2(30) CONSTRAINT depart_dname_pk PRIMARY KEY
); 
INSERT INTO depart VALUES (101, '인사과');
INSERT INTO depart VALUES (102, '고객센터');
INSERT INTO depart VALUES (103, '엉업부');
INSERT INTO depart VALUES (104, '회계부');
SELECT * FROM depart;

CREATE TABLE record(
	dname varchar(30) CONSTRAINT RECORD_dname_fk REFERENCES depart(dname),
	eno char(10),
	workdate DATE,
	POSITION varchar2(30)
);
INSERT INTO RECORD VALUES('인사과', 'AA16032101', to_date(20160321, 'YYMMDD'), '사원'  );
INSERT INTO RECORD VALUES('회계부', 'AA16032101', to_date(20210901, 'YYMMDD'), '과장'  );
INSERT INTO RECORD VALUES('영업부', 'AA16032102', to_date(20160321, 'YYMMDD'), '사원'  );
INSERT INTO RECORD VALUES('인사과', 'AA16032102', to_date(20180321, 'YYMMDD'), '대리'  );
INSERT INTO RECORD VALUES('영업부', 'AA16032102', to_date(20210321, 'YYMMDD'), '팀장'  );
INSERT INTO RECORD VALUES('고객센터', 'AA20032101', to_date(20200321, 'YYMMDD'), '사원'  );


CREATE TABLE employee (
	eno char(10) CONSTRAINT employee_eno_pk PRIMARY KEY,
	dno number(3),
	positon varchar2(30)
);
INSERT INTO employee VALUES ('AA16032101', 001, '과장');
INSERT INTO employee VALUES ('AA16032102', 002, '팀장');
INSERT INTO employee VALUES ('AA20032101', 021, '사원');


CREATE TABLE family(
	eno char(10) CONSTRAINT family_eno_fk REFERENCES employee(eno),
	fname varchar(30),
	birthday date
);
INSERT INTO family values('AA16032101', '이철수',to_date(19600501,'YYMMDD'));
INSERT INTO family values('AA16032102', '김현동',to_date(19801211,'YYMMDD'));
INSERT INTO family values('AA20032101', '한지현',to_date(19940121,'YYMMDD'));





/*
객체 관계모델링 실습

1. 회사는 네 개의 부서를 운영한다. 부서는(부서번호, 부서이름)을 저장한다

	부서(부서번호, 부서이름)
	depart(deptno, dname)	
	
	
2. 부서는 1명 이상의 직원(직원번호, 직원이름, 직책)을 두고 있다. 각 직원은 하나의 부서에 소속된다

	employee(empno, job, deptno) - deptno는 foreign key  dept(deptno) 비식별처리


3. 직원은 부양가족(이름, 나이)이 있을 수 있다
	=> 부양가족(부양가족번호, 이름, 나이, 사원번호) 	

	empfamily(efno, enmae, age, empno) - empno는 foreign key employee(empno) 비식별처리
	
	
4. 각 직원은 근무했던 부서에 대한 근무 기록(기간, 직책)이 있다  
	==> 직책은 사원정보를 통해서 가져올 수 있기 때문에 설정하지 않는다. 기간(startDte, endDte)
		근무기록(근무기록 번호, 사원번호, 부서번호, 시작일, 마지막일)	
	
	 hisemploy(hisno, empno, deptno, startDte, dneDte) empno, deptno 비식별자처리
	 												   hisno 는 primary key					

	ex) (1000(홍길동), 10(인사), 2022/01/01, 2022/01/31)
		(1000(홍길동), 20(총무), 2022/02/01, 2022/02/28)
		(1000(홍길동), 10(인사), 2022/03/01, 2022/03/31)

*/

--1007exrd 테이블

CREATE TABLE departt(
	deptno number(4) PRIMARY KEY,
	dname varchar2(50)
);
INSERT INTO departt VALUES (1000, '회계');
INSERT INTO departt VALUES (1001, '인사');
INSERT INTO departt VALUES (1002, '재무');
SELECT * FROM departt;


ALTER TABLE employeee
ADD ename varchar2(50); 
CREATE TABLE employeee(
	empno number(4) PRIMARY KEY,
--	ename varchar2(50),
	job varchar2(50)
);
INSERT INTO employeee VALUES (7000, '홍길동', '대리');
INSERT INTO employeee VALUES (7001, '김길동', '사원');
INSERT INTO employeee VALUES (7002, '신길동', '과장');
INSERT INTO employeee VALUES (7003, '마길동', '사원');
SELECT * FROM employeee;


CREATE TABLE hisemploy(
	hisno NUMBER PRIMARY KEY,
	startdte DATE,
	enddte DATE,
	deptno number(4) REFERENCES departt(deptno),
	empno number(4) REFERENCES employeee(empno) );
-- 7000(홍길동), 1001(인사), 2022/01/01, 2022/01/31)
-- 7000(홍길동), 1002(총무), 2022/02/01, 2022/02/28)
-- 7000(홍길동), 1002(인사), 2022/03/01, 2022/03/31)
INSERT INTO hisemploy VALUES (1, to_date('2022/01/01', 'YYYY/MM/DD'), to_date('2022/01/31', 'YYYY/MM/DD'), 1001, 7000);
INSERT INTO hisemploy VALUES (2, to_date('2022/02/01', 'YYYY/MM/DD'), to_date('2022/02/28', 'YYYY/MM/DD'), 1002, 7000);
INSERT INTO hisemploy VALUES (3, to_date('2022/03/01', 'YYYY/MM/DD'), to_date('2022/03/31', 'YYYY/MM/DD'), 1001, 7000);
SELECT * FROM hisemploy;


CREATE TABLE empfamily(
	efno NUMBER PRIMARY KEY,
	name varchar2(50),
	age NUMBER,
	empno number(4) REFERENCES employeee (empno)
);
--1 이연아 28, 7000
--2 홍마리 5, 7000
--3 홍철수 2, 7000
INSERT INTO empfamily values(1, '이연아', 28, 7000);
INSERT INTO empfamily values(2, '홍마리', 5, 7000);
INSERT INTO empfamily values(3, '홍철수', 2, 7000);
SELECT * FROM empfamily;


--join관계
--인사기록이 나옴
SELECT * 
FROM employeee e, hisemploy h, departt d
WHERE e.empno = h.empno
AND h.deptno = d.deptno;

SELECT *
FROM employeee e, empfamily f
WHERE e.empno = f.empno;





