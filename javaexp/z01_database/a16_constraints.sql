/*
# 데이터 무결성 제약조건
1. 목적
	- 데이터의 정확성과 일관성을 보장하기 위함
2. 데이터의 정확성을 유지하여 다양한 종류의 업무규칙을 고려하는 예
	1)	학생 테이블에 학년 데이터는 1, 2, 3, 4중에 하나만 입력
	2)	모든 학번은 유일하게 처리
	3) 	학생테이블의 지도교수 번호는 지도교수테이블의 교수번호 중 하나로만 추가/변경 가능
3. 데이터 무결성 제약조건의 장점
	1)	테이블 생성시 무결성 제약조건을 정의 가능
		- 생성 후 제약조건 설정도 테이블 구조변경 명령을 통해 가능
	2) 	테이블에 대한 정의, 데이터 딕셔너리에 저장되므로 응용프로그램에서 입력된 모든 데이터에 대하 동일하게 적용 가능
	3)	제약조건을 활성화/비활성화 할 수 있는 융통성을 가지고 있다
4. 무결성 제약조건의 종류
	1) not null		: 해당 컬럼이 null을 포함할 수 없음. 즉 반드시 데이터를 입력하여야 하는 컬럼 지정
	2) unique key 	: 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열 조합을 지정하여야 한다
						ex) 학번, 주민번호, 사원번호는 중복되지 않아야 한다.	
						- null을 처리가 가능하고 null은 중복이 가능하다.
	3) primary key 	: 해당 컬럼 값은 반드시 존재해야 하며 유일해야 한다
					  not null과 unique가 결합된 형태  >> null입력X
					  주로 테이블에서 식별해야할 컬럼 즉, key를 지정할 때 사용된다
	4) foreign key 	: 한 열과 참조된 테이블의 열 간에 외래 키 관계를 설정하고 시행
						ex) 사원의 테이블의 부서번호는 반드시 부서테이블에 있는 부서번호여야한다
	5) check		: 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리
						ex) 학생테이블의 학년은 1~4만 데이터로 입력/수정할 수 있다	
						
						check( where조건문형식처럼 쓰면 됨 )				 
5. 설정 형식
	1) 테이블 생성이나 구조 변경 시 추가옵션 설정
		컬럼명 데이터타입 constraint 제약조건명 제약조건
		제약조건명 : 일반적으로 제약조건명은  테이블명_컬럼명_제약조건종류약어  로 선언한다
			ex) emp_empno_pk : 사원테이블의 사원번호를 primary key로 설정함  을 포함하는 내용이다
6. 제약조건 설정의 내용을 확인하는 메타테이블
	1) SYS.ALL_CONSTRAINTS : db시스템에 있는 제약정보의 메타테이블
	2)			
			
*/
SELECT * FROM sys.all_constraints;

-- not null
DROP TABLE student01;
CREATE TABLE student01(
	name varchar2(30) CONSTRAINT student01_name_nn NOT null
);
INSERT INTO student01 VALUES('홍길동');
INSERT INTO student01 VALUES(null);  -- 제약조건 에러 발생
-- 제약조건 확인
SELECT *
FROM sys.all_constraints
WHERE constraint_name = upper('student01_name_nn');

--ex) student02 테이블에 학생번호, 이름, 국어, 영어, 수학 점수로 칼럼을 설정하고 
--	  번호와 이름을 NOT null로 설정하고 데이터를 입력해보세요
CREATE TABLE student02(
	stuno number CONSTRAINT student02_stuno_nn NOT NULL,
	name  varchar2(20) CONSTRAINT student02_name_nn NOT NULL,
	kor NUMBER(3),
	eng NUMBER(3),
	math NUMBER(3) 
);
-- 제약조건 확인
SELECT *
FROM sys.ALL_CONSTRAINTS 
WHERE CONSTRAINT_NAME LIKE 'STUDENT02%';

INSERT INTO student02 VALUES (11026, '이지원', 96, 89, 100);
INSERT INTO student02 (stuno, name) values (11017, '오길동');
INSERT INTO student02 (name, kor) 	values ('마길동', 80); -- 에러발생
INSERT INTO student02 (stuno, kor)	values (11003, 80);  -- 에러발생

SELECT * FROM student02;


-- unique
CREATE TABLE student03(
	sno NUMBER  CONSTRAINT student03_SNO_UQ UNIQUE,
	name varchar2(50)
);
INSERT INTO student03 VALUES (1, '홍길동');
INSERT INTO student03 VALUES (2, '김길동');
INSERT INTO student03 VALUES (NULL, '머길동');
INSERT INTO student03 VALUES (NULL, '오길동');
INSERT INTO student03 VALUES (2, '신길동'); --에러발생 -- 2 중복 저장
SELECT * FROM student03;
-- 제약조건 확인
SELECT *
FROM sys.ALL_CONSTRAINTS 
WHERE CONSTRAINT_NAME LIKE 'STUDENT03%';

-- ex) employee01에 사원번호, 사원명, 급여를 설정하되 사원번호는 unique, 사원명은 not null로 제약조건을 설정하고
--	   데이터 입력 및 메타테이블을 통해 확인하세요

CREATE TABLE employee01 (
	eno	NUMBER(4) 	CONSTRAINT employee01_eno_uq UNIQUE,
	ename varchar(50) CONSTRAINT employee01_ename_nn NOT NULL,
	sal	NUMBER 	
);
INSERT INTO employee01 VALUES (1000, '김철수', 9000);
INSERT INTO employee01 VALUES (1001, '이철수', null);
INSERT INTO employee01 VALUES (1001, '한철수', null);	-- uq: 1001 중복데이터 등록 에러 발생
INSERT INTO employee01 VALUES (1002,   null, 3500);	-- nn: NULL 입력 에러 발생
INSERT INTO employee01 VALUES (null, '박철수', 2000);	-- uq: NULL 입력해도 에러 발생X
SELECT * FROM employee01;
-- 제약조건 확인
SELECT *
FROM sys.ALL_CONSTRAINTS 
WHERE constraint_NAME LIKE 'EMPLOYEE01%';



/*
# check
1. 컬럼명 데이터유형 constraint 제약명
	check ( where조건문형식동일 )
	ex) 'A', 'B', 'C'라는 3가지 문자열로된 등급만 입력가능하게 check 처리
		grade char(1) constraint emp_grade_ck check( grade in('A', 'B', 'C') )
	ex) 0~100
		point number(3) check( point between 0 and 100 )	
	ex) 과목(subject)을 국어, 영어, 수학만 입력하게 정의
		subject char(6) check( subject in( '국어', '영어', '수학') )
	주의) check는 null입력은 가능하다	
*/


-- PRIMARY KEY : not null + unique
CREATE table employee02(
	empno number(4) PRIMARY KEY --제약조건의 이름을 지정하지 않음  -- 내부적으로 만들어진 이름: SYS_C007035
);
CREATE TABLE employee03(
	empno number(4) CONSTRAINT employee03_empno_pk PRIMARY KEY -- 제약조건 이름 지정
);
INSERT INTO employee02 VALUES(1000);
INSERT INTO employee02 VALUES(null); --에러 발생
INSERT INTO employee02 VALUES(1000); --에러 발생
-- 제약조건확인
SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE table_name IN ('EMPLOYEE02', 'EMPLOYEE03');

--ex) student04 테이블에 학번(primaty key), 이름(not null), 주민번호(unique)
--	  국어, 영어, 수학 점수로 테이블을 구성하여 데이터를 입력 확인하세요

CREATE TABLE student04(
	sno char(7) CONSTRAINT student04_sno_pk PRIMARY KEY,
	name varchar(20) CONSTRAINT student04_name_nn NOT NULL,
	inum char(14) CONSTRAINT student04_inum_uq UNIQUE,
	kor number(3),
	eng number(3),
	math number(3)
);
INSERT INTO student04 VALUES (1616320, '이지원', '960601-2123456', 100, 86, 100);
SELECT * FROM student04;
-- 제약조건확인
SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE TABLE_name ='STUDENT04';
--WHERE CONSTRAINT_NAME LIKE 'STUDENT04%';

-- 컬럼을 두 개를 기준으로 프라이머리키를 설정하는 경우
-- 하단에 constraint제약조건명 제약조건유형(컬럼1, 컬럼2..)
CREATE TABLE buybook(
	id varchar2(30),
	isbn char(10),
	buydate DATE,
	paycheck varchar2(20),
	CONSTRAINT buybook_id_isbn_pk PRIMARY KEY(id, isbn) 
);
-- 참조컬럼을 키로 사용하는 경우를 식별관계로 설정하는 것을 말한다
SELECT *
FROM sys.ALL_CONSTRAINTS 
WHERE table_name = 'BUYBOOK';

SELECT * FROM buybook;

