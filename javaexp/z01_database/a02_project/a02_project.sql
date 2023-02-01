
--휴가/근태
--1. 근무스케줄
CREATE TABLE pschedule (
	schno char(5),
	empno varchar2(10) REFERENCES pjoin(empno),
	schdate DATE,
	topic varchar2(100)
);
--근무스케줄 등록
INSERT INTO pschedule VALUES('SD001', '사원번호', to_date('2022/10/23', 'YYYY/MM/DD'), '국내영업팀, 마케팅팀 1차 회의');

--근무스케줄 조회
--group by 함수 중 문자열 합치기: LISTAGG([합칠 컬럼명], [구분자]) WITHIN GROUP(ORDER BY [정렬 컬럼명]) 
SELECT DISTINCT topic, schdate, sch.cemp, sch.list
FROM PSCHEDULE ss,( SELECT  schno, count(s.empno) cemp,
						listagg(dname||'팀 '||ename||' '||pos, ',') 
						WITHIN GROUP(ORDER BY s.empno) AS list
					FROM PSCHEDULE s, pemp e, pdept d
					WHERE s.empno = e.empno
					AND d.deptno = e.deptno
					GROUP BY schno) sch
WHERE ss.schno = sch.schno
AND to_char(schdate, 'YYYY')='2022' 	
AND to_char(schdate, 'MM')='10'
ORDER BY schdate;
--스케줄 날짜 수정
UPDATE PSCHEDULE
   SET schdate = TO_date('20221101','YYYY/MM/DD')
 WHERE topic LIKE '%'||'비공식 2차'||'%';
--스케줄 삭제
DELETE 
FROM PSCHEDULE 
WHERE topic LIKE '%'||'비공식'||'%'
AND to_char(schdate, 'YYYYMMDD')='20220819';


--출근부
CREATE TABLE pcommute (
	empno varchar2(10) REFERENCES pjoin(empno),
	cdate DATE,
	arrtime DATE,
	leavtime DATE 
);

--출근부 등록
INSERT INTO pcommute VALUES ('210313', to_date(sysdate, 'YYYY/MM/DD'), sysdate, null);
UPDATE pcommute
   SET arrtime = sysdate
 WHERE empno = '210313' ; 



--출근 유무 조회
SELECT DISTINCT cdate, c.empno, ename, 
	   nvl(to_char(arrtime, 'HH24:MM'), '결근') art, 
	   to_char(leavtime, 'HH24:MM') lvt
FROM pcommute c, pemp e
WHERE c.empno = e.empno
AND ename LIKE '%'||'심직원'||'%'
ORDER BY c.empno, cdate DESC;



nvl2(데이터, null이아닐때, null일때)
decode(cdate, BETWEEN vacfdate AND vacldate, '휴가', '결근' )




SELECT DISTINCT fc.cdate, fc.empno, ename, nvl2(ARRTIME , '출근', decode(fc.cdate, jj.cdate, '휴가', '결근'))
FROM pcommute fc, pemp fe,
( SELECT c.empno, c.cdate
  FROM pcommute c,( SELECT cc.empno, cdate
				    FROM pcommute cc, pvacation vv
				    WHERE cc.empno = vv.EMPNO
				    AND cdate BETWEEN vacfdate AND vacldate  )jcv
  WHERE c.empno = jcv.empno
  AND c.cdate = jcv.cdate  ) jj
WHERE fc.empno = fe.EMPNO 
AND fc.empno = jj.empno
AND fe.empno = jj.empno
ORDER BY fc.empno, fc.cdate DESC;



	
--*******
SELECT DISTINCT c.cdate, c.empno, ename, arrtime, leavtime
FROM pcommute c, pemp e,
	( SELECT cdate
	  FROM pcommute
	  WHERE cdate in (SELECT cdate
		   			  FROM pcommute cc, pvacation vv
			 		  WHERE cc.empno = vv.EMPNO
					  AND cdate BETWEEN vacfdate AND vacldate ) ) j
WHERE c.empno = e.empno	
AND ename LIKE '%'||'심직원'||'%'
ORDER BY c.empno, c.cdate DESC;








SELECT DISTINCT c.cdate, c.empno, ename, arrtime, leavtime,
				nvl2(arrtime, '출근', decode(c.cdate, j.cdate,'휴가', '결근')) note
FROM pcommute c, pemp e, 
	( SELECT cdate, vacfdate, vacldate
	  FROM pcommute cm, pvacation mv
	  WHERE cdate BETWEEN vacfdate AND vacldate
	  AND cdate in (SELECT cdate
	   			  FROM pcommute cc, pvacation vv
		 		  WHERE cc.empno = vv.EMPNO
				  AND cdate BETWEEN vacfdate AND vacldate ) ) j
WHERE c.empno = e.empno	
AND c.cdate BETWEEN vacfdate AND vacldate
AND ename LIKE '%'||'심직원'||'%'
ORDER BY c.empno, c.cdate DESC;





SELECT cc.empno, cdate
		FROM pcommute cc, pvacation vv
		WHERE cc.empno = vv.EMPNO
		AND cdate BETWEEN vacfdate AND vacldate ;

	
SELECT DISTINCT c.cdate, c.empno, ename, arrtime, leavtime, nvl2(arrtime, '출근', '결근' ) note
FROM pcommute c, pemp e, pvacation v
WHERE c.empno = e.empno
AND e.empno = v.empno
AND ename LIKE '%'||'심직원'||'%'
ORDER BY c.empno, c.cdate DESC;





--출근부 수정
UPDATE pcommute
   SET arrtime = to_date('2022/10/20/08/45','YYYY/MM/DD/HH24/MI')
 WHERE TO_char(arrtime, 'YYYYMMDD') = '20221021' 
   AND empno = '';

--출근날짜 삭제
DELETE 
FROM pcommute
WHERE empno = '210314' AND TO_char(arrtime, 'YYYYMMDD')='20221019' ;




--휴가
CREATE TABLE pvacation (
	empno varchar2(10) REFERENCES pjoin(empno),
	vacfdate DATE,
	vacldate DATE
);
SELECT * FROM pemp;20

--휴가 등록(신청)
INSERT INTO pvacation VALUES ('210315', to_date('20221010','YYYY/MM/DD'), to_date('20221012','YYYY/MM/DD') );
--INSERT INTO pvacation VALUES ('210315', to_date('20220725','YYYY/MM/DD'), to_date('20220727','YYYY/MM/DD') );
--INSERT INTO pvacation VALUES ('210314',to_date('20221005','YYYY/MM/DD'), to_date('20221007','YYYY/MM/DD'));
--INSERT INTO pvacation VALUES ('200910',to_date('20221012','YYYY/MM/DD'), to_date('20221014','YYYY/MM/DD'));

--휴가 조회
SELECT dname||'팀 '||ename||' '||pos worker, vacfdate, vacldate
FROM pemp e, pvacation v, pdept d 
WHERE e.empno = v.empno
AND e.deptno = d.deptno
AND (ename = '직원'
	 OR to_date('20221012','YYMMDD') BETWEEN vacfdate AND vacldate) 
ORDER BY v.empno, vacfdate DESC;

--휴가 수정
UPDATE pvacation 
   SET vacfdate = to_Date('20220801', 'YYYY/MM/DD'),
   	   vacldate = to_Date('20220803', 'YYYY/MM/DD')
 WHERE empno = '210315' AND TO_char(vacfdate, 'YYYYMMDD')='20220725';  

--휴가 삭제
DELETE 
FROM pvacation 
WHERE empno = '210315' AND TO_char(vacfdate, 'YYYYMMDD')='20220725' ;









SELECT empno, ename, pos, pass FROM pemp ORDER BY empno;






