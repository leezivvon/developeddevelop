--급여
CREATE TABLE psal (
	empno varchar2(10) REFERENCES pjoin(empno),
	sal NUMBER,
	sevpay NUMBER 
);
--급여 등록
INSERT INTO psal VALUES ('210315', 210, 500);
INSERT INTO psal VALUES ('210314', 210, 500);
INSERT INTO psal VALUES ('210313', 250, 600);
INSERT INTO psal VALUES ('200910', 450, 2000);


SELECT * FROM psal;

--급여 수정
UPDATE psal
   SET sal = 500
 WHERE empno = '200910';

--급여 조회
SELECT DISTINCT dname||'팀 '||ename||' '||pos ef, sal, sal*12 ysal
FROM pemp e, psal s, pdept d, pcommute c
WHERE e.empno = s.empno
AND e.deptno = d.deptno
AND e.empno = c.empno
AND c.empno = s.empno
AND ename LIKE '%'||'심직원'||'%';


--수당
CREATE TABLE pextrapay(
	empno varchar2(10) REFERENCES pjoin(empno),
	expno char(6), --날짜221026
	expkind varchar2(50),
	extrapay number
);
--수당 등록(신청)
INSERT INTO pextrapay VALUES ('210314', '221007', '야간근로수당', 10);
INSERT INTO pextrapay VALUES ('210314', '221006', '야간근로수당', 15);
INSERT INTO pextrapay VALUES ('210314', '221005', '야간근로수당', 10);
INSERT INTO pextrapay VALUES ('210314', '220908', '명절수당', 150);
INSERT INTO pextrapay VALUES ('210314', '220905', '야간근로수당', 10);
INSERT INTO pextrapay VALUES ('210315', '220908', '명절수당', 150);

INSERT INTO pextrapay VALUES ('210313', '220908', '명절수당', 150);

SELECT * FROM pextrapay;
--수당 조회
SELECT  expkind, sum(extrapay) summ
FROM pemp e, pextrapay ex
WHERE e.empno= ex.empno
AND ename ='심직원'
AND substr(expno, 3, 2)  = '09'
GROUP BY expkind ;  


--급여지급
--월급+수당






--인사관리
CREATE TABLE pperplan(
	ppyear DATE,
	deptno NUMBER(3) REFERENCES pdept(deptno),
	bu NUMBER(1),
	cha NUMBER(1),
	gwa NUMBER(1),
	dae NUMBER(1),
	sawon NUMBER(1)
);

--인사계획입력
INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 501, 1, 1, 2, 4, 4);
INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 502, 1, 1, 2, 4, 4);
INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 503, 1, 1, 2, 4, 4);
INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 504, 1, 1, 2, 4, 3);
INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 505, 1, 1, 2, 4, 4);
INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 506, 1, 1, 2, 4, 4);

INSERT INTO pperplan VALUES (to_date('2021','YYYY'), 507, 1, 1, 2, 4, 4);


--인사 분석


-- 현재 인원
SELECT ce.*
FROM ppos p, ( SELECT pos, count(pos) cp
			   FROM pemp e
			   WHERE deptno = 501
			   GROUP BY pos) ce
WHERE p.pos = ce.pos
ORDER BY grd;


-- 계획인원/비율
-- 각 부서별 총직원 비율
SELECT pp.deptno, bu, cha, gwa, dae, sawon, hab, 
		dgc, dgc/hab*100 per
FROM ( SELECT deptno, count(deptno) dgc
	   FROM pemp
	   GROUP BY deptno ) c,
	 ( SELECT pl.*, (bu+cha+gwa+dae+sawon) hab
	   FROM PPERPLAN pl  ) pp
WHERE pp.deptno = c.deptno
AND to_char(ppyear, 'YYYY')='2021'
AND pp.deptno = 501
ORDER BY deptno;


CREATE TABLE ppos(
 pos varchar2(20),
 grd NUMBER(1)
);

INSERT INTO ppos VALUES ('이사', 1);
INSERT INTO ppos VALUES ('부장', 2);
INSERT INTO ppos VALUES ('차장', 3);
INSERT INTO ppos VALUES ('과장', 4);
INSERT INTO ppos VALUES ('대리', 5);
INSERT INTO ppos VALUES ('사원', 6);


SELECT e.*, p.*, j.*
FROM pemp e, ppos p, pjoin j
WHERE e.pos = p.pos
AND e.empno = j.empno
AND p.pos = '부장';

