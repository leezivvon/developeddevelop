/*
[1단계:확인] 2. 등급테이블의  salgrade1000 테이블을 복사 만들고, 해당 정보를 메서드를 만드세요.
[1단계:확인] 3. 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고
      데이터를 입력하세요.
[1단계:확인] 4. member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이터를 등록 후, 
              조회하는 메서드를 선언 및 출력하세요.
[1단계:확인] 5. 위 member100테이블을 기준으로 아이디, 패스워드를 입력(Scanner)받아 select문으로 
         데이터를 조회하여 로그인 성공 여부를 출력하는 Dao기능메서드를 만드세요.
*/

--2
CREATE TABLE salgrade100 AS SELECT * FROM salgrade;
INSERT INTO salgrade100 VALUES(0, 0, 699);
SELECT * FROM salgrade100;


alter table emp100
	modify(
		job varchar2(50),
		ename varchar2(50),
		empno number(4) primary key


--3
CREATE TABLE EmpDept100 
AS SELECT e.*, dname, loc  FROM emp e, dept d WHERE e.deptno=d.deptno;
ALTER TABLE EmpDept100
	MODIFY(
		empno number
		ename varchar2(50),
		job varchar2(50),
		dname varchar2(50),
		loc varchar2(20)
	);
INSERT INTO EmpDept100 values(700, '오인주', '경리', 1, to_date('2016/03/24','YYYY/MM/DD'), 3000, 700, 50, '경리부', '서울');

--SEQUENCE empdept100_seq
--	START WITH 1000
--	MINVALUE 1000
--	MAXVALUE 9999;
--INSERT INTO EmpDept100 VALUES (empdept100_seq.nextval, '오인경', '언론홍보팀',...)

SELECT * FROM EmpDept100;


--4,5 아이디, 패스워드, 이름, 권한, 포인트, 등록일
CREATE TABLE member100 (
	id varchar2(50), --PRIMARY key
	pass varchar2(70),
	name varchar2(50),
	authority varchar2(50),
	point NUMBER,
	registerdate DATE
);
INSERT INTO member100 values('apple01', 'aapplee0101', '김사과', '관계자', 450, to_Date('2018/09/14','YYYY/MM/DD'));
--정답
--INSERT INTO member100 values('apple01', 'aapplee0101', '김사과', '관계자', 450, sysdate);
SELECT * FROM member100;
-- 정답
--SELECT * FROM member100
--WHERE id LIKE '%'||''||'%'
--OR name LIKE '%'||''||'%';





UPDATE emp100
SET enmae = '홍길동',
	job = '과장',
	sal = 6000
WHERE empno = 7369;

DELETE emp100
WHERE empno = 1003;



