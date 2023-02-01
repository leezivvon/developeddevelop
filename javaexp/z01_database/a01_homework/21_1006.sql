
/*
2022-10-06
[1단계:개념] 1. 테이블의 구조 변경형식(추가, 삭제, 수정)을 기본예제를 통해 기술하세요.
[1단계:코드] 2. 부서테이블을 dept12 복사테이블을 만들고, 부서관리자명, 부서생성일을 추가하세요.
[1단계:코드] 3. 사원테이블과 등급테이블을 조인해서 복사테이블 emp17만들고, losal, hisal을 삭제 처리하세요.
[1단계:코드] 4. emp20 복사테이블을 만들고, 사원명의 최대 byte크기를 확인한 후, char(최대크기)로 변경하세요.
[1단계:개념] 5. 무결성 제약 조건의 장점과 종류를 예시를 통해서 기술하세요.
[1단계:코드] 6. 물품정보테이블(물품번호, 물건명, 가격, 재고량)을 만들되, 물품번호, 물건명을 not null 제약 조건을 선언하여 생성하고, 생성된 여부를 메타테이블을 통해 확인하세요.
[1단계:코드] 7. 도서대여시스템의 테이블 (도서, 대여, 회원)에서 대여 테이블의 회원아이디와 도서일련번호 두개 컬럼을 primary key로 설정하세요.
[1단계:코드] 8. 회원테이블(회원아이디, 패스워드, 이름, 권한, 포인트) 권한이 관리자, 일반사용자, 방문객만 입력가능, 포인트가 0이상 입력가능하게 제약사항을 처리해서 테이블을 생성하세요.
[1단계:코드] 9. 캡쳐로 제시 화면의 ERD의 실제테이블을 제약사항을 적용하여 테이블을 생성하고, 데이터를 입력 확인하세요.
[1단계:개념] 10. 시퀀스의 기본 생성 형식과 호출 속성을 정리해보세요.
[1단계:코드] 11. 아래의 여러가지 시퀀스를 생성해보세요.
                 1) 9999~1000 2씩 감소  2) 5000~9999 1씩 증가 3) 0~21 3씩 증가 반복 4) 5~1000 5씩 증가
[1단계:코드] 12. 게시판테이블(번호, 내용)을 만들고, sequence를 만들어 1부터 시작하여 번호가 증가되어 입력되게 처리하세요.
[1단계:개념] 13. DML의 종류를 기술하세요.
*/
--1 테이블의 구조 변경형식(추가, 삭제, 수정)
/*

CREATE  TABLE emp14
AS SELECT empno, ename, job, sal FROM emp;
emp14 테이블에서

컬럼의 추가 : add
	alter table 테이블명
	add 컬럼명 데이터유형  [default 디폴트데이터, 제약 조건]
		ex) ALTER TABLE emp14
			ADD hiredate DATE ( DEFAULT sysdate );	

컬럼의 삭제 : drop
	alter table 테이블명 drop columm 컬럼명;	
		ex) ALTER TABLE emp14 DROP column job;	

컬럼의 수정(변경) : modify
	alter table 테이블명
	modify 컬럼명 변경할 유형;
		- 데이터가 없는 경우 : 컬럼 타입이나 크기 변경이 자유롭다
		- 데이터가 있는 경우 : 타입변경은 같은 유형끼리 변경하되 작은 유형에서 큰 유형으로 변경가능하다
	기본 값의 변경은 변경 후에 입력되는 데이터부터 적용된다
		ex) 데이터가 없는 경우
			CREATE TABLE emp15 AS SELECT * FROM emp WHERE 1=0;
			ALTER TABLE emp15  MODIFY hiredate varchar2(16);
			
			데이터가 있는 경우
			ALTER TABLE emp14  MODIFY ename varchar2(50); >> 같은 데이터 유형에서 크기만 변경O
*/
--2
CREATE TABLE dept12 AS SELECT * FROM dept;
--추가 처리
ALTER TABLE dept12
ADD (
	dmname varchar(50),
	dmakedate DATE 
);
SELECT * FROM dept12;

--3
CREATE TABLE emp17
AS SELECT e.*, s.*
FROM emp e, SALGRADE s 
WHERE sal BETWEEN losal AND hisal;
--삭제처리
ALTER TABLE emp17 DROP COLUMN losal;
ALTER TABLE emp17 DROP COLUMN hisal; -- 한번에 묶어서 삭제하는 법????

--4
CREATE  TABLE emp20  AS SELECT *  FROM emp;
SELECT * FROM emp20;--varchar2(10)
ALTER TABLE emp20 MODIFY ename char(20);

--5
/*
무결성 제약조건의 종류
	1) not null		: 해당 컬럼이 null을 포함할 수 없음.  반드시 데이터를 입력하여야 하는 컬럼 지정 nullX
	2) unique key 	: 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열 조합을 지정하여야 한다. 중복X
					  null을 처리가 가능하고 null은 중복이 가능하다.
	3) primary key 	: 해당 컬럼 값은 반드시 존재해야 하며 유일해야 한다
					  not null과 unique가 결합된 형태  >> 중복X null입력X
	4) foreign key 	: 한 열과 참조된 테이블의 열 간에 외래 키 관계를 설정하고 시행
	5) check		: 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리			 

데이터 무결성 제약조건의 장점
	1)	테이블 생성시 무결성 제약조건을 정의 가능, 생성 후 제약조건 설정도 테이블 구조변경 명령을 통해 가능
	2) 	테이블에 대한 정의, 데이터 딕셔너리에 저장되므로 응용프로그램에서 입력된 모든 데이터에 동일하게 적용 가능
	3)	제약조건을 활성화/비활성화 할 수 있는 융통성을 가지고 있다
*/
--6 not null 예시
DROP TABLE product02;
CREATE TABLE product02 (
	pno char(5) CONSTRAINT product02_pno_nn NOT NULL,
	pname varchar(100) CONSTRAINT product02_pname_nn NOT NULL,
	price NUMBER,
	stock number
);
--메타테이블을 통해 제약조건 확인
SELECT *  FROM sys.all_constraints
WHERE TABLE_NAME = 'PRODUCT02';

--7 primary key 예시
ALTER TABLE libbook
MODIFY isbn CONSTRAINT libbook_isbn_pk PRIMARY KEY;

ALTER TABLE LIBMEMBER 
MODIFY id CONSTRAINT libmember_id_pk PRIMARY KEY;

--8
CREATE TABLE MEMBER100(
	id varchar2(100) PRIMARY key,
	password varchar2(200),
	name varchar2(50),
	auth varchar2(30) CHECK ( auth IN ('관리자', '일반사용자', '방문객') ),
	point NUMBER CONSTRAINT member100_point_ck check(point>=0)	
); 
SELECT * FROM member100;
/*
1. 권한 조건문 auth in ('관리자', '일반사용자', '방문객')
2. 포인트 조건 point >= 0
*/
-- check제약조건에 의해서 권한과 포인트칼럼을 해당 데이터만 입력/수정 가능

--9
CREATE TABLE client1006(
	id varchar2(30) PRIMARY KEY ,
	name varchar2(30),
	point number
);
CREATE TABLE book1006(
	isbn char(7) PRIMARY key,
	title varchar2(200),
	writer varchar2(30),
	price number
);
CREATE TABLE publisher1006(
	pno char(3) PRIMARY KEY ,
	pname varchar2(100),
	loc varchar2(100),
	callnumber char(9)
);
CREATE TABLE buy1006(
	id varchar2(30) CONSTRAINT buy1006_id_fk REFERENCES client1006(id),
	isbn char(7) CONSTRAINT buy1006_isbn_fk REFERENCES book1006(isbn),
	buydate DATE,
	payway varchar2(20)
);
CREATE TABLE supply1006 (
	isbn char(7) CONSTRAINT supply1006_isbn_fk REFERENCES book1006(isbn),
	pno char(3) CONSTRAINT supply1006_pno_fk REFERENCES publisher1006(pno)
);
INSERT INTO client1006 VALUES ('luvriceball01', '김뭉치', 500 );
INSERT INTO client1006 VALUES ('cosmos02', '이우주', 800 );

INSERT INTO book1006 VALUES ('BK00001','공정하다는 착각', '마이클 샌델', 36000);
INSERT INTO book1006 VALUES ('BK00002','마지막 춤은 나와 함께', '은희경', 18000);
INSERT INTO book1006 VALUES ('BK00003','아픔이 길이 되려면', '김승섭', 21000);

INSERT INTO publisher1006 VALUES ('001', '민음사', '종로', '1588-1234');

--10
/*
시퀀스의 기본 형식
create sequence 시퀀스명
	increment by 증가단위
	start with 시작번호
	maxvalue 최대값|nomaxvalue
	minvalue 최소값|nominvalue
	cycle|nocycle - 반복여부 설정
	cache n |nocache -- 속도 개선을 위해 메모리 캐시 시퀀스 수

시퀀스의 호출 속성은 정수값(숫자)이다...
*/
--11
--1)
CREATE SEQUENCE seq01
	INCREMENT BY -2
	START WITH 9999
	MAXVALUE 9999
	MINVALUE 1000;
--2)
CREATE SEQUENCE seq02
	INCREMENT BY 1
	START WITH 5000
	MAXVALUE 9999
	MINVALUE 5000;
--3)
CREATE SEQUENCE seq03
	INCREMENT BY 3
	START WITH 0
	MINVALUE 0
	MAXVALUE 21
	CYCLE
	cache 3;
--4)
CREATE SEQUENCE seq04
	INCREMENT BY 5
	START WITH 5
	MAXVALUE 1000
	MINVALUE 5;

SELECT seq01.nextval, seq02.nextval, seq03.nextval, seq04.nextval 
FROM dual;

--12
CREATE TABLE board (
	NO NUMBER, --PRIMARY key
	content varchar2(500)
);
CREATE SEQUENCE boardseq --board_seq가 좀 더 간지나는군,,,
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 100;
INSERT INTO board(no) VALUES (boardseq.nextval);
-- insert into board VALUES (boardseq.nextval, '내용'||boardseq.currval)
SELECT * FROM board;

-- 13.
/*
- DML종류
insert	: 입력 처리
update	: 수정 처리
delete	: 삭제 처리
merge 	: 병합 처리 명령어 (논리적 테이블의 병합/수정과 동시에 입력)
*/


/*
== 평가대비(오라클) 객관식 문제 ==
1.
1) alter table 테이블명   : 테이블 구조 변경
2) update  table 테이블명 ??
3) create table 테이블명  : 테이블 생성
4) drop table 테이블명 	: 테이블 삭제

2. 
1) not null		O
2) unique		O
3) second key 	X
4) foreign key	O

3. 
1) 테이블 생성시 무결성 제약조건을 정의 가능	O
2) not null 제약은 기존 데이터를 NULL로 수정하는 경우에는 가능	X : unique
3) 테이블레벨이 아닌 열 레벨로만 지정가능하다 	O
4) 제약조건을 활성화, 비활성화 할 수 있는 융통성애 있음 O

4. 
1) 테이블 생성시만 제약조건이 가능하므로 일관성을 확보	X :  생성 후 테이블 구조변경 명령을 통해 가능
2) 응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용 O
3) 제약조건을 활성화, 비활성화 할 수 있는 융통성 O
4) 테이블 생성시 무결성 제약조건을 정의 가능 O

5.
1) increment by	O
2) start with	O
3) minvalue 	O
4) circle 		X : cycle
*/
