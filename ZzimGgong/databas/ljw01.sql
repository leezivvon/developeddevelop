SELECT * FROM restaurant;
SELECT * FROM jjim_user;
SELECT * FROM access_Token;
SELECT * FROM res_user;
SELECT * FROM jjim_review;
SELECT * FROM menu;
SELECT * FROM resPick;
SELECT * FROM waiting;
SELECT * FROM jjim_sch;

SELECT * FROM take_out;
SELECT * FROM policy;


SELECT * FROM restaurant;
SELECT * FROM waiting;


INSERT INTO WAITING VALUES('123-45-67890','jyh123@naver.com',
to_date('2023-01-05 13:35','YYYY-MM-DD HH24:MI'),3,5,'F','F');

SELECT * FROM JJIM_USER ju ;

--메인페이지 출력 sql

--매장이미지/매장명/평균별점/키워드/동이름/  별점높은 순/리뷰많은 순
SELECT rownum, r.resnum, res_img, res_name, NVL(rev.sco, 0) AS sco, mCategory, res_addresss, NVL(rev.cnt,0) AS cnt
FROM RESTAURANT r, menu m, (	SELECT RESNUM, avg(STAR_SCO) sco, count(review_content) cnt 
								FROM jjim_review GROUP BY RESNUM   ) rev
WHERE r.RESNUM = m.RESNUM AND r.resnum=rev.resnum(+)
AND rownum <=6;

ORDER BY sco desc;
ORDER BY cnt desc;


SELECT * FROM jjim_review;
SELECT * FROM restaurant;





--원격줄서기sql

--신청 전 대기인원(대기예상시간)
SELECT resnum, count(resnum) AS countResnum
FROM WAITING
WHERE TO_CHAR(wstarttime)='23/01/06' --날짜는...이거도 프론트 단에서 받아오기
AND resnum = '123-45-67895' --가게번호는 프론트단에서 받아오기
AND cancel='F'
AND enter_check='F'
GROUP BY resnum; 

SELECT count(resnum) AS countResnum
FROM WAITING w 
WHERE RESNUM = '123-45-67895' 
AND CANCEL = 'F' AND ENTER_CHECK ='F'
GROUP BY resnum;

SELECT resnum 가게번호, USER_EMAIL 고객아이디, WSTARTTIME 신청날짜, WAITING_NUM 대기번호, WAITING_PERSON 입장인원, CANCEL 신청취소, ENTER_ChECK 입장완료
FROM WAITING;

--신청하기 <<고객
INSERT INTO WAITING VALUES('사업자번호 받고','이용자아이디 받고',sysdate,0,0, upper('F'),upper('F')); --대기인원도 화면에서 받고 

--대기번호  >>update문에 넣어서 >>front단에 waiting테이블에서 꺼내waiting_num 데이터로 출력 
UPDATE WAITING 
SET WAITING_NUM = ( SELECT count(resnum) 
					FROM WAITING
					WHERE TO_CHAR(wstarttime)='23/01/06' 
					AND resnum='param으로 받고'
					GROUP BY resnum
				  )
WHERE user_email='jyh123@naver.com'
AND cancel='F' 		
AND enter_check='F';
--굳이inline넣을 필요X
UPDATE WAITING 
SET WAITING_NUM = ( SELECT count(resnum) 
					FROM WAITING
					WHERE TO_CHAR(wstarttime)='23/01/06' 
					AND resnum=( 
						SELECT RESNUM 
						FROM WAITING
						WHERE user_email='jyh123@naver.com'
						AND TO_CHAR(wstarttime)='23/01/06' 
						AND cancel='F' 		
						AND enter_check='F'
					) 
					GROUP BY resnum
				  )
WHERE user_email='jyh123@naver.com'
AND cancel='F' 		
AND enter_check='F';

--주문현황
--가게,신청정보 출력
SELECT res_name, res_phonenum, res_addresss, wstarttime, waiting_num, waiting_person, cancel, enter_check
FROM waiting w, RESTAURANT r  
WHERE w.resnum = r.resnum
AND user_email='alsn0527@naver.com'
AND cancel='F'
AND enter_check='F';


SELECT res_name, res_phonenum, res_addresss, wstarttime, waiting_num, waiting_person, cancel, enter_check
FROM waiting w, RESTAURANT r  
WHERE w.resnum = r.resnum
AND user_email='jyh123@naver.com'
AND cancel='F'
AND enter_check='F';

/*
신청하기(FF)>>대기예상시간 화면에 띄우고(앞에 대기인원X5분)>>유효성체크:오늘날짜에 FF가 있는 데이터가 있으면 신청 불가
주문현황확인(FF)>>대기번호계산해서 화면에 띄우고>>
취소하기(TF)>>대기번호계산한것 DB에 넣고 || 입장완료(FT)>>대기번호계산한것 DB에 넣고

--sql문
o 원격줄서기>>대기예상시간 뜸
o 신청하기>>waiting insert문 --대기번호비워두기 & 대기인원
o		>>대기번호count() 삽입

o 주문현황확인>>가게랑줄서기join한거(각종정보출력) & 현재내입장순서count() 
o 취소하기>>waiting TF로update문
o 입장완료>>waiting FT로update문
*/
--실시간 입장순서
SELECT user_email, WSTARTTIME, WAITING_NUM, cancel, enter_check, ROWNUM
FROM WAITING
WHERE TO_CHAR(wstarttime)='23/01/06' --오늘날짜에
AND resnum=( -- 내가 신청한가게에서.
	SELECT RESNUM 
	FROM WAITING
	WHERE user_email='hjw123@naver.com'
	AND TO_CHAR(wstarttime, 'yyyy/mm/dd')='2023/01/05' 
	AND cancel='F' 		
	AND enter_check='F'  --오늘 취소나 입장한 기록이 있을 수 있으니까
)
AND user_email = 'hjw123@naver.com'
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime;

SELECT ROWNUM
FROM WAITING
WHERE to_char(to_date('2023/01/05', 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
AND resnum=(
	SELECT RESNUM 
	FROM WAITING
	WHERE user_email='hjw123@naver.com'
	AND cancel='F' 		
	AND enter_check='F'
)
AND user_email = 'hjw123@naver.com'
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime;

SELECT rownum
FROM WAITING w, ( SELECT rownum, USER_EMAIL
				FROM WAITING
				WHERE to_char(to_date('2023/01/05', 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
				AND resnum=(
							SELECT RESNUM 
							FROM WAITING
							WHERE user_email='hjw123@naver.com'
							AND cancel='F' 		
							AND enter_check='F'
							)
				AND cancel='F' 		
				AND enter_check='F'			
				ORDER BY wstarttime
				) rw
WHERE w.USER_EMAIL = rw.USER_EMAIL
AND w.user_email='hjw123@naver.com';


SELECT TO_NUMBER(rn.rrn) AS rrownum
FROM waiting w, (
SELECT TO_CHAR(rownum,'9999' ) rrn , user_email
FROM WAITING
WHERE to_char(SYSDATE,'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
AND resnum=(
			SELECT RESNUM 
			FROM WAITING
			WHERE user_email='hds123@naver.com'
			AND cancel='F' 		
			AND enter_check='F'
			)
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime) rn
WHERE w.user_email = rn.user_email
AND w.user_email='hds123@naver.com';


SELECT * FROM waiting;



SELECT TO_CHAR(rownum,'9999' ) rrn , user_email
FROM WAITING
WHERE to_char(to_date('2023/01/05', 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
AND resnum=(
			SELECT RESNUM 
			FROM WAITING
			WHERE user_email='hjw123@naver.com'
			AND cancel='F' 		
			AND enter_check='F'
			)
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime;

SELECT rownum , user_email
FROM WAITING
WHERE to_char(to_date('2023/01/05', 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
AND resnum=(
			SELECT RESNUM 
			FROM WAITING
			WHERE user_email='hjw123@naver.com'
			AND cancel='F' 		
			AND enter_check='F'
			)
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime;



--강사님
SELECT count(*) waintnum 
FROM WAITING w 
WHERE RESNUM = '123-45-67895' --dao를 만들어야한다
AND CANCEL = 'F' AND ENTER_CHECK ='F';

SELECT * FROM waiting;


--취소하기(손님)
UPDATE WAITING
SET CANCEL ='T', ENTER_CHECK ='F'
WHERE user_email='jyh123@naver.com'
AND TO_CHAR(wstarttime)='23/01/03' 
AND cancel='F' 		
AND enter_check='F';



--가게페이지
--이 번호가 뜨면 
SELECT ROWNUM, w.user_email, nickname, WSTARTTIME, WAITING_PERSON , WAITING_NUM, ENTER_CHECK, CANCEL 
FROM WAITING w, JJIM_USER ju 
WHERE w.USER_EMAIL = ju.USER_EMAIL 
AND rownum = 1
AND resnum= '123-45-67890'
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime;

SELECT ROWNUM, w.user_email, nickname, WSTARTTIME, WAITING_PERSON , WAITING_NUM
FROM WAITING w, JJIM_USER ju 
WHERE w.USER_EMAIL = ju.USER_EMAIL 
AND rownum = 1
AND resnum= '123-45-67890'
AND TO_CHAR(WSTARTTIME, 'YYYY/MM/DD')  = to_char(sysdate, 'YYYY/MM/DD')
AND cancel='F' 		
AND enter_check='F'
ORDER BY wstarttime;


--거절하기(가게)
UPDATE WAITING
SET CANCEL ='T', ENTER_CHECK ='F'
WHERE user_email='jyh123@naver.com'
AND resnum =
AND to_char(to_date('2023/1/6', 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
AND cancel='F' 		
AND enter_check='F';

SELECT * FROM waiting;

--입장완료(가게)
UPDATE WAITING
SET CANCEL ='F', ENTER_CHECK ='T'
WHERE user_email='jyh123@naver.com'
AND resnum =
AND to_char(to_date('2023/1/6', 'YYYY/MM/DD'),'YYYY/MM/DD') = TO_char(wstarttime,'YYYY/MM/DD')
AND cancel='F' 		
AND enter_check='F';




--rsgetstring으로 다 받아서 세션으로 불러오기
SELECT jr.*, NICKNAME FROM JJIM_USER ju, JJIM_REVIEW jr WHERE ju.USER_EMAIL = jr.USER_EMAIL AND resnum = '123-45-67895';
SELECT count(resnum) AS countResnum
FROM WAITING w 
WHERE RESNUM = '123-45-67895'
AND CANCEL = 'F' AND ENTER_CHECK ='F'
GROUP BY resnum;

SELECT to_char(to_date('2023/1/6', 'YYYY/MM/DD'),'YYYY/MM/DD') FROM dual;
