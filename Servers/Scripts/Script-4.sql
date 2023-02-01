SELECT * FROM MEMBER  
WHERE name LIKE '%'||''||'%' 
AND auth LIKE '%'||''||'%';

insert into member values('아이디','패스워드','이름','권한',1000,'주소');

INSERT INTO SALGRADE100

--검색
SELECT * FROM SALGRADE100 WHERE grade BETWEEN 1 AND 5 ORDER BY grade;
--등록
INSERT INTO SALGRADE100 VALUES (?,?,?)

SELECT 1 FROM PBOARD ;
SELECT * FROM Ppost WHERE bno='a2001';

INSERT INTO ppost VALUES ('jumpup08', 'a2002', 'a2002'||ppost_seq002.nextval,'점메추', sysdate, 0);

--로그인
SELECT 1 FROM thmember WHERE id='' AND password='';

select id, PASSWORD  from thmember;

SELECT * FROM emp100;


SELECT * FROM MEMBER;
DELETE 

INSERT INTO MEMBER values('byeboy', '9999', '이홍기', 'user01', 5000,'서울');
INSERT INTO MEMBER values('byegirl', '0000', '이기홍','admin', 5000,'서울');


insert into emp01 values(7999, '마길동', '대리', 7902,to_date('2023-01-01', 'YYYY-MM-DD'), 3500, 100, 10);


commit;