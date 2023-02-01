		select count(*)
		from emp100	;



DROP TABLE WAITING;

create table waiting
(
    resNum varchar2(30) constraint waiting_resNum_fk references restaurant (resNum),
    user_email varchar2(30) constraint waiting_user_email_kf references jjim_user(user_email),
    wStartTime date,
    waiting_num number, --대기팀 수
    waiting_person number,
    cancel char check(cancel in('F','T')),
    enter_check char check(enter_check in('F','T'))
);

INSERT INTO WAITING VALUES('123-45-67890','ljw123@naver.com',
to_date('2023-01-05 13:00','YYYY-MM-DD HH24:MI'),1,4,'F','F');
INSERT INTO WAITING VALUES('123-45-67890','hjw123@naver.com',
to_date('2023-01-05 13:30','YYYY-MM-DD HH24:MI'),2,3,'F','F');


SELECT * FROM WAITING w ;
SELECT * FROM JJIM_USER ju ;

UPDATE WAITING
SET CANCEL ='F', ENTER_CHECK ='T'
WHERE resnum='123-45-67890';

SELECT * FROM WAITING w ;

UPDATE WAITING
SET WSTARTTIME=to_date('2023-01-06 00:05','YYYY-MM-DD HH24:MI') 
WHERE TO_CHAR(WSTARTTIME,'YYYY/MM/DD') = '2023/01/06'
AND USER_EMAIL ='jyh123@naver.com';


INSERT INTO WAITING VALUES('123-45-67895','hds123@naver.com',
to_date('2023-01-06 09:00','YYYY-MM-DD HH24:MI'),1,3,'F','F');
INSERT INTO WAITING VALUES('123-45-67895','hjw123@naver.com',
to_date('2023-01-06 09:10','YYYY-MM-DD HH24:MI'),2,4,'F','F');
INSERT INTO WAITING VALUES('123-45-67895','jyh123@naver.com',
to_date('2023-01-06 09:15','YYYY-MM-DD HH24:MI'),3,2,'F','F');

SELECT *
FROM emp100
WHERE ename LIKE '%'||'A'||'%'
AND job LIKE '%'||''||'%';



INSERT INTO WAITING VALUES('123-45-67895','ljw123@naver.com',
to_date('2023-01-24 09:00','YYYY-MM-DD HH24:MI'),1,3,'F','F');
INSERT INTO WAITING VALUES('123-45-67895','hjw123@naver.com',
to_date('2023-01-24 09:10','YYYY-MM-DD HH24:MI'),2,4,'F','F');
INSERT INTO WAITING VALUES('123-45-67895','jyh123@naver.com',
to_date('2023-01-24 09:15','YYYY-MM-DD HH24:MI'),3,2,'F','F');

SELECT * FROM JJIM_USER ju ;



SELECT * FROM product111;
SELECT * FROM member111;
SELECT * FROM buyinfo111;

CREATE TABLE product111(
	pid varchar2(100) PRIMARY KEY,
	name varchar2(100),
	price NUMBER,
	rcnt number
);
INSERT INTO product111 VALUES('1000', '사과', 2000, 100);
INSERT INTO product111 VALUES('1001', '바나나', 4000, 20);
INSERT INTO MEMBER111 VALUES('himan', '7777', '홍길동', '관리자');
INSERT INTO MEMBER111 VALUES('higirl', '8888', '홍현아', '관리자');
INSERT INTO buyinfo111 VALUES('1000', 'himan', 5, sysdate);

CREATE TABLE member111(
	mid varchar2(100) PRIMARY KEY,
	pass varchar2(100),
	name varchar2(100),
	auth varchar2(100)
);
CREATE TABLE buyinfo111(
	pid varchar2(100),
	mid varchar2(100),
	bcnt NUMBER,
	buydate DATE
);

DROP TABLE buyinfo111;

