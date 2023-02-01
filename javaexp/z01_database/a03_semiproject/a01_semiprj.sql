--1.user //회원가입

CREATE TABLE puser(
	id varchar2(20) PRIMARY KEY,
	password varchar2(20),
	email varchar2(30),
	nickname varchar2(50),
	admityear DATE,
	univer varchar2(50),
	major varchar2(30)
);
--INSERT INTO puser VALUES ('manager00', 'aoslwj00#', 'manager00@gmail.com', '관리자', to_date('20100101', 'YYYYMMDD'), '우원대학교', '컴퓨터공학과');

--INSERT INTO puser VALUES ('luvriceball01', 'rlaandcl01#', 'luvriceball01@gmail.com', '뭉치면주먹밥흩어지면볶음밥',to_date('20220307', 'YYYYMMDD'), '우수대학교', '연극영화과');
--INSERT INTO puser VALUES ('cosmos02', 'ldldnwn02#', 'cosmos02@gmail.com', '우리는별의자녀들', to_date('20220307', 'YYYYMMDD'), '우수대학교', '광고홍보학과');	
--INSERT INTO puser VALUES ('coward03', 'tjguscjf03#', 'coward03@gmail.com', '겁을모양이군', to_date('20220307', 'YYYYMMDD'), '우수대학교', '문예창작과');	
--INSERT INTO puser VALUES ('nonosleep04', 'dlasksdyd04#', 'nonosleep04@gmail.com', '아니라느뇽오라가짜', to_date('20220307', 'YYYYMMDD'), '우수대학교', '경영학과');	
--INSERT INTO puser VALUES ('jailismyhome05', 'dnqkddn05#', 'jailismyhome05@gmail.com', '이상한검사우병우', to_date('20220307', 'YYYYMMDD'), '우수대학교', '법학과');	
--INSERT INTO puser VALUES ('pee06', 'dhwndna06#', 'pee06@gmail.com', '그래나쉬했는지도몰라', to_date('20220307', 'YYYYMMDD'), '우수대학교', '경제학과');	
--INSERT INTO puser VALUES ('itsmine07', 'dldhqdhs07#', 'itsmine07@gmail.com', '이어폰빌려가지마난마음으로듣냐', to_date('20220307', 'YYYYMMDD'), '우수대학교', '행정학과');	
--INSERT INTO puser VALUES ('jumpup08', 'dlfkdks08#', 'jumpup08@gmail.com', '나이란사람이야아랍은뛰어', to_date('20220307', 'YYYYMMDD'), '우수대학교', '물리치료학과');	
--INSERT INTO puser VALUES ('imgalic09', 'rhaksdmf09#', 'imgalic09@gmail.com', '아무리생강캐도난마늘', to_date('20220307', 'YYYYMMDD'), '우수대학교', '심리학과');	
--INSERT INTO puser VALUES ('threedollar10', 'dbgur10#', 'threedollar10@gmail.com', '형돈씨나삼천원있어요', to_date('20220307', 'YYYYMMDD'), '우수대학교', '무용과');	

SELECT * FROM puser;
SELECT * FROM PBOARD;

DELETE FROM pboard WHERE BTITLE ='';

alter table pboard
modify btitle varchar2(100);

alter table pboard
modify notice varchar2(100);


--2.게시판 //게시글시퀀스까지 동시 생성
CREATE TABLE pboard(
	id varchar2(20) REFERENCES puser(id),
	bno char(5) PRIMARY KEY,
	btitle varchar2(50),
	notice varchar2(50),
	crdate date	
);
--우원대학교 코드01
INSERT INTO pboard VALUES ('manager00', 'a1001', '자유게시판', '', to_date('20100101', 'YYYYMMDD'));
INSERT INTO pboard VALUES ('manager00', 'a1002', '비밀게시판', '', to_date('20100101', 'YYYYMMDD'));

--우수대학교 코드02
INSERT INTO pboard VALUES ('manager00', 'a2001', '자유게시판', '', to_date('20100101', 'YYYYMMDD'));
INSERT INTO pboard VALUES ('manager00', 'a2002', '비밀게시판', '', to_date('20100101', 'YYYYMMDD'));
INSERT INTO pboard VALUES ('luvriceball01', 'a2'||pboard_seqa2.nextval, '드라마게시판', '우수생들의 드라마보는 공간♬', to_date('20220301', 'YYYYMMDD'));

INSERT INTO pboard VALUES ('아이디', 'a2'||pboard_seqa2.nextval, '게시판이름', '공지', sysdate);

DROP SEQUENCE pboard_seqa2;
CREATE SEQUENCE pboard_seqa2
INCREMENT BY 1
START WITH 101
MINVALUE 1
MAXVALUE 999;

SELECT * FROM pboard;

--게시판 수정
UPDATE PBOARD 
   SET notice = '우수생들의 드라마보는 공간♬♪'
 WHERE btitle = ''
    OR bno ='a2101';

--게시판 조회
SELECT b.bno, btitle, notice
FROM PBOARD b, ( SELECT bno, count(bno) cb
				 FROM PPOST
				 GROUP BY bno) c
WHERE b.bno(+) = c.bno
AND   BTITLE LIKE '%'||'게시판'||'%'
ORDER BY cb desc;

SELECT * FROM PBOARD ORDER BY crdate;


--3. 게시글
CREATE TABLE ppost(
	id varchar2(20) REFERENCES puser(id),
	bno char(5) REFERENCES pboard(bno),
	pno char(8) PRIMARY KEY,
	pcontents varchar2(1000),
	wtime DATE,
	likecnt NUMBER
);
--자유게시판의 게시글
CREATE SEQUENCE ppost_seq001
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999;
--itsmine07 : 비대위

INSERT INTO ppost VALUES ('itsmine07', 'a2001', 'a2001'||ppost_seq001.nextval, 
				'[비대위]2022-2 기말고사 간식배부 안내 안녕하세요 우수대학 제 100대 총학생회 비상대책위원회 문화기획국, 재정사무국입니다. 
				내일부터 2022학년도 2학기 기말고사 간식배부가 시작됩니다. 장소는 쌍용관앞입니다. 좋은 결과 있으시길 응원합니다.', sysdate, 0);
--INSERT INTO ppost VALUES ('itsmine07', 'a2001', 'a2001'||ppost_seq001.nextval, 
--				'[비대위] 2022 사진전 개최 공지  개최 일정:12월 1일 목요일~12월24일 목요일 우수대학교의 자랑 응원단과 중앙동아리 댄스댄스댄스팀의 무대공연, 
--				다양한 부스와 즐길거리도 마련되어 있으니 우수생들의 많은 참여 부탁드립니다. ', to_date('20221110','YYYYMMDD'), 0);

DELETE FROM PPOST WHERE id='itsmine07';
DROP SEQUENCE ppost_seq001;
		

--비밀게시판의 게시글
CREATE SEQUENCE ppost_seq002
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999;

--INSERT INTO ppost VALUES ('luvriceball01', 'a2002', 'a2002'||ppost_seq002.nextval,
--						  '곧 크리스마스다,,,하 나 일년을 크리스마스만 보고 살아 진짜 벌써 행복해', sysdate, 0);
--INSERT INTO ppost VALUES ('cosmos02', 'a2002', 'a2002'||ppost_seq002.nextval,'아 공부 개안돼 확 때려쳐 진짜?앙?놔봐 놔봐,,', sysdate, 0);
--INSERT INTO ppost VALUES ('jailismyhome05', 'a2002', 'a2002'||ppost_seq002.nextval,'야식으로 봉골파스타 할건데ㅋㅋㅋ 치킨스톡 다먹었으면 다시다로 해도 돼?ㅠ벌써 다 먹었어..ㅋㅋㅋㅋ', sysdate, 0);
--INSERT INTO ppost VALUES ('nonosleep04', 'a2002', 'a2002'||ppost_seq002.nextval,'오늘 중도랑 학교에 단풍이랑 은행봣어? 너무 예뻐,,ㅠ 다떨어지기 전에 단풍구경 가야하는데 나는 왜 중도에 박혀있는건지..', sysdate, 0);
--INSERT INTO ppost VALUES ('jumpup08', 'a2002', 'a2002'||ppost_seq002.nextval,'이동시간 왕복 2시간인데 집에서 3시간 쉴 수 있으면 집 갈거야? 학교갔다가 다른데 이동해야하는데 그 사이에 마가 떠서 그냥 집에 갈까.. 어쩔까,, 고민중', sysdate, 0);
--INSERT INTO ppost VALUES ('pee06', 'a2002', 'a2002'||ppost_seq002.nextval,'한 시간동안 논문 한 페이지 읽음;; 미쳤나... 총 11페이지인데 어느 세월에 다 읽냐..ㅋㅋㅋ', sysdate, 0);
--INSERT INTO ppost VALUES ('imgalic09', 'a2002', 'a2002'||ppost_seq002.nextval,'근로장학생 모집공고는 어디서 봐야 하나요?', sysdate, 0);
--INSERT INTO ppost VALUES ('itsmine07', 'a2002', 'a2002'||ppost_seq002.nextval,
--							'시험기간이 제일 바빠... 우수생들.. 시험기간에 학생회 말 좀 잘 들어줘... 나 울어ㅠㅠ', sysdate, 0);
--INSERT INTO ppost VALUES ('luvriceball01', 'a2002', 'a2002'||ppost_seq002.nextval,'우리 과사 사람들 너무 불친절해,, 하 진짜 내가 뭐 잘못한것도 아닌데 질문만 하면 짜증이야 질문도 눈치 주는게 말이 돼? 그럼 과사에는 왜 전화하는데에에에에 안부인사만 하냐고~ 방귀만 뀌는 화장실이냐,,쒸익쒸익', sysdate, 0);
--INSERT INTO ppost VALUES ('imgalic09', 'a2002', 'a2002'||ppost_seq002.nextval,'내일 트렌치 코트 개오바?', sysdate, 0);
--INSERT INTO ppost VALUES ('imgalic09', 'a2002', 'a2002'||ppost_seq002.nextval,'그럼 내일 가죽잠바도 개오바? 그런데 간죽간살이라면?', sysdate, 0);
--INSERT INTO ppost VALUES ('jailismyhome05', 'a2002', 'a2002'||ppost_seq002.nextval,'헉 아까 오후에 교수님한테 연락왔어,....이거 뭐야..... 나 무서워....', sysdate, 0);
--INSERT INTO ppost VALUES ('coward03', 'a2002', 'a2002'||ppost_seq002.nextval,'취준하니까 자존감 바닥친다^ㅠ 면접스터디하는데 다들 쑥쑥 느는데 나만... 나만 제자리 걸음 같아 눈물나', sysdate, 0);
--INSERT INTO ppost VALUES ('jumpup08', 'a2002', 'a2002'||ppost_seq002.nextval,'우리 중도 몇시까지더라? 24시간 맞지?', sysdate, 0);




SELECT * FROM PBOARD ;

SELECT * FROM puser;


--나중에 bno =a2 학교코드도 구분
SELECT * FROM pboard WHERE btitle='자유게시판';
