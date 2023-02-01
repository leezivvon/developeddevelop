/*
2022-10-05
[1단계:개념] 1. 테이블 생성/삭제 기본 코드를 기술하세요.
[1단계:코드] 2. 온라인 컴퓨터 부품판매 사이트에서 컴퓨터정보를 테이블로 만들려고 한다. 온라인 사이트를 참고하여 테이블을 만들어 보세요.
[1단계:개념] 3. database 모델링에서 엔티티, 속성, 엔티티 타입, 인스턴스, 객체 집합을 예제와 함께 개념을 정리해보세요.
[1단계:개념] 4. 모델링에서 유도속성에 대하여 기술하세요.
[1단계:개념] 5. 데이터를 입력하는 형식 2가지 및 삭제처리를 기술하세요.
[1단계:코드] 6. 부서테이블을 기준으로 dept10 복사테이블을 만들고 컬럼 크기를 변경후, 데이터를 입력하세요.
[1단계:코드] 8. 도서관의 도서대여시스템에 도서, 도서대여, 회원 정보를 만들어 erd 생성(논리/물리모델) 처리하세요 
[1단계:코드] 9. 위 내용을 실제 테이블 생성 및 join 된 sql 처리하세요
*/

--1 
/*
--테이블 생성 기본 코드
create table 테이블명(
	컬럼명 데이터유형 제약조건
);

--테이블 삭제 기본코드
drop table 테이블명;
*/

--2
CREATE TABLE computer(
	cpu varchar2(200),
	memory varchar2(200),
	ssd varchar2(200),
	board varchar2(200),
	grapic varchar2(200),
	cpower varchar2(300)
);

--3. database 모델링에서 엔티티, 속성, 엔티티 타입, 인스턴스, 객체 집합을 예제와 함께 개념을 정리해보세요.
--4
-- 유도 속성: 기존의 다른 속성값에서 유도되어 결정되는 속성으로 값이 별도로 저장되지 않음
--			ex. 책 개체의 가격과 할인율 속성으로 계산되는 판매가격 속성

--6, 5
--복사테이블 만들기
CREATE TABLE dept10  AS SELECT* FROM dept; --ctrl+enter 실행 >> refresh
SELECT * FROM dept10;-- ctrl+enter 실행 >> ctrl+테이블클릭 

-- 컬럼크기 변경
-- 	>> 컬럼크기변경후 >> SAVE >> COPY >> NULL삭제
ALTER TABLE SCOTT.DEPT10 MODIFY DNAME VARCHAR2(20) ; -- 실행
ALTER TABLE SCOTT.DEPT10 MODIFY LOC VARCHAR2(20) ; -- 실행

--데이터입력
INSERT INTO dept10 values(50,'HUMANRESOURCE', 'SEOUL'); -- 전체데이터입력
INSERT INTO dapt10(detno, dname)VALUES (60, 'SECURITY'); -- 부분데이터입력
-- DELETE FROM dept10 WHERE deptno = 60;	-- 삭제 처리

--8, 9
--테이블 생성
CREATE TABLE libbook(
	isbn char(20),
	title varchar2(100),
	writer varchar2(100),
	kind varchar2(50)
);
--데이터 입력
INSERT INTO libbook VALUES ('IBW1000000','만들어진 신','리처드 도킨스','사회');
INSERT INTO libbook VALUES ('IBW1000001','공정하다는 착각','마이클 샌델','사회');
INSERT INTO libbook VALUES ('IBW1000002','나는 소망한다 내게 금지된 것들을','양귀자','인문');
INSERT INTO libbook VALUES ('IBW1000003','마지막 춤은 나와 함께','은희경','인문');
INSERT INTO libbook VALUES ('IBW1000004','아픔이 길이 되려면','김승섭','철학');
--확인
SELECT * FROM libbook;


CREATE TABLE libmember(
	memnum char(20),
	id varchar2(30),
	name varchar2(30)
);
INSERT INTO libMEMBER VALUES ('MEM100000', 'luvriceball01', '김뭉치');
INSERT INTO libMEMBER VALUES ('MEM100001', 'cosmos02', '이우주');
INSERT INTO libMEMBER VALUES ('MEM100002', 'coward03', '서현철');

SELECT * FROM libmember;


CREATE TABLE lendingbook (
	isbn char(20),
	memnum char(20),
	lenddate DATE,
	returndate date	
);
INSERT INTO lendingbook VALUES ('IBW1000002', 'MEM100000', to_date('2022-09-30', 'YYYY-MM-DD'), sysdate);
INSERT INTO lendingbook VALUES ('IBW1000003', 'MEM100000', to_date('2022-09-30', 'YYYY-MM-DD'), sysdate);
INSERT INTO lendingbook VALUES ('IBW1000000', 'MEM100001', to_date('2022-09-28', 'YYYY-MM-DD'), sysdate);
INSERT INTO lendingbook VALUES ('IBW1000001', 'MEM100001', to_date('2022-09-28', 'YYYY-MM-DD'), sysdate);
INSERT INTO lendingbook VALUES ('IBW1000004', 'MEM100001', to_date('2022-09-28', 'YYYY-MM-DD'), sysdate);
INSERT INTO lendingbook VALUES ('IBW1000002', 'MEM100002', to_date('2022-10-02', 'YYYY-MM-DD'), sysdate);

SELECT * FROM lendingbook;

--조인
SELECT *
FROM libbook b, libmember m, lendingbook l
WHERE b.isbn = l.isbn
AND m.memnum = l.memnum
ORDER BY m.id;



/*
== 평가대비(오라클) 객관식 문제 ==
1. 
1) char 2) varchar2 3) boolean 4) number
정답:3

2. 
1) 의미를 분해할 수 있는 속성			: 복합 속성 ex) 이름
2) 의미를 더는 분해할 수 없는 속성  	: 단순 속성
3) 값을 하나만 가질 수 있는 속성		: 단일값 속성
4) 값을 여러 개 가질 수 있는 속성		: 다중값 속성
정답:1

3.
1) 각 개체 인스턴스를 식별하는 데 사용되는 속성
2) 모든 개체 인스턴스의 키 속성 값이 다름
3) 둘 이상의 속성들로 구성되기도 함
4) 개체 집합들 사이의 대응 관계, 즉 매핑(mapping)을 의미  : 관계속성
정답:4

4.
1) ER 다이어그램으로 표현하여 피터 첸이 제안하였다.
2) 일대일(1:1) 관계 유형만 표현할 수있다.  X :   1:다, 다:다도 표현 가능
3) 객체 타입과 이들 간의 관계 타입을 이용해 현실 세계를 개념적으로 표현한다.
4) ER 다이어그램은 ER 모델을 그래프 방식으로 표현한 것이다.
정답:2

*/



