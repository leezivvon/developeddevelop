/*
# check
1. 특정한 데이터를 조건이나 범위를 지정해서 해당 범위에 데이터만 입력되도록 처리한 것을 말한다
2. 형식
	컬럼명 데이터유형 constraint 제약명 check ( where 조건문 형식 설정 )
	ex) check(컬럼명 = '데이터'), 
		check(컬럼명 between 1000 and 2000)...
	컬럼명 데이터유형 check ( where 조건문 형식 설정 )

*/
CREATE TABLE emp04(
	gender varchar2(1) CONSTRAINT emp04_gender_ck check( gender IN('F', 'M') )
);
INSERT INTO emp04 VALUES('F');
INSERT INTO emp04 VALUES('M');
INSERT INTO emp04 VALUES('K'); -- 에러 발생

SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE table_name = 'EMP04';

-- ex) student05 테이블 이름, 학년(1~4), 국어(1~100) 제약조건을 설정하여 테이블을 생성하고 확인하세요
CREATE TABLE student05 (
	ename varchar(20),
	grade NUMBER CONSTRAINT student05_grade_ck CHECK ( grade BETWEEN 1 AND 4 ),
--	kor NUMBER CONSTRAINT student05_kor_ck CHECK ( kor >=1 AND kor <=100 )
	kor NUMBER CHECK (kor BETWEEN 1 AND 100)
);
INSERT INTO student05 VALUES ('김영희', 1, 100);
INSERT INTO student05 VALUES ('이영희', 5, 90); 	--에러 5가 조건밖
INSERT INTO student05 VALUES ('박영희', 2, 101); 	--에러 101이 조건밖
SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE table_name = 'STUDENT05';



/*
# 외래키 설정(foreign key) 
1. 연관관계에 있는 두 테이블에 대하여 한쪽 테이블에 있는 데이터 기준으로 다른쪽 테이블의 데이터를 입력할 수 있게 하는 것을 말한다
2. 기본 형식
	컬럼명 데이터유형 constraint 테이블명_컬럼명_fk references 테이블명(컬럼명)
*/
-- 교수테이블과 학생테이블의 담당교수지정 컬럼
CREATE TABLE professor01(
	tno NUMBER PRIMARY KEY,
	name varchar2(50)
);
CREATE TABLE student06(
	name varchar2(50),
	tno NUMBER CONSTRAINT student05_tno_fk REFERENCES professor01(tno)
);
INSERT INTO professor01 values(1000, '홍길동교수');
INSERT INTO student06 values('김길동학생', 1000);
INSERT INTO student06 values('마길동학생', 1000);
INSERT INTO student06 values('오길동학생', 1001); --참조에러발생

-- ex) 물건테이블(물건번호, 물건명, 가격),	
--	   구매테이블(구매번호, 구매수량, 물건번호-외래키설정)
CREATE TABLE PRODUCT01(
	pno char(5) PRIMARY KEY,
	pname varchar2(100),
	price NUMBER	
);
CREATE TABLE buyprod01(
	bno char(5) PRIMARY key,
	bcnt NUMBER,
	pno char(5) CONSTRAINT buyProd01_pno_fk REFERENCES PRODUCT01(pno)
);
INSERT INTO product01 VALUES ('PR001', '아침에 쥬스', 2000);
INSERT INTO product01 VALUES ('PR002', '피자빵', 2800);
INSERT INTO buyProd01 VALUES ('BP001', 3, 'PR001');
INSERT INTO buyProd01 VALUES ('BP001', 4, 'PR002');
INSERT INTO buyProd01 VALUES ('BP001', 4, 'PR003'); --에러 발생

SELECT * FROM PRODUCT01;
SELECT * FROM buyProd01;

--조인관계로 설정
SELECT bno, pname, price, bcnt
FROM product01 p, buyprod01 b
WHERE p.pno = b.pno;