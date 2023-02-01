/*
2022-09-26
[1단계:코드] 1. salgrade 테이블 전체를 조회하고, 해당 컬럼을 조회해보세요.
[1단계:개념] 2. 정보와 데이터의 차이점을 기술하세요.
[1단계:개념] 3. 데이터의 형태에 따른 분류를 하고, 예를 나타내세요.
[1단계:개념] 5. 이산형 데이터와 연속형 데이터의 차이점을 기술하세요
[1단계:개념] 6. 테이블과 컴럼명의 alias를 사용하는 방법을 예제를 통해서 기술하세요.
[1단계:개념] 7. 하나의 테이블을 사용할 때도 alias를 사용하는 경우를 기술하세요.
[1단계:코드] 8. 아래의 형태로 사원정보(emp) 테이블의 컬럼이름에 맞는 데이터를 출력하세요
              부서번호 - deptno  사원번호(empno) 직책(job)  급여(sal*12) 보너스
[1단계:코드] 9. 아래의 형식으로 컬럼간의 연산과 연결처리를 하여 alias로 출력하세요.
     1) @@님의 사원번호는 @@이고, 올해 연말보너스는 연봉의 20%인 @@원입니다.  @@님(ename)
     2) @@님의 입사일은 @@이고, 현재 연봉의 1/13인 월급여는 @@만원.   입사일 @@(hiredate)

*/
-- 1. 데이터 조회하기
-- 전체조회
SELECT *
FROM salgrade;
-- 특정 칼럼 조회
SELECT grade, losal
FROM SALGRADE;

--2
/*
데이터는 현실 세계에서 단순히 관찰하거나 측정하여 수집한 사실이나 값이고 
정보는 그러한 데이터를 유용하게 활용되도록 처리한 결과물이다.
*/

--3  
/*
1) 정형 데이터  
	구조화된 데이터, 즉 미리 정해진 구조에 따라 저장된 데이터로
	데이터 구조에 대한 설명과 데이터 내용은 별도로 유지된다
	ex) 엑셀의 스트레드시트, 관계 데이터베이스의 테이블
2) 반정형 데이터
	구조에 따라 저장된 데이터이지만 데이터 내용 안에 구조에 대한 설명이 함께 존재한다.
	구조를 파악하는 파싱과정이 필요하고, 보통 파일 형태로 저장된다
	ex) 웹에서 데이터를 교환하기 위해 작성하는 html, xml, json문서나 웹로드, 센서 데이터 등
3) 비정형 데이터
	정해진 구조가 없이 저장된 데이터이다
	ex) 소셜 데이터의 텍스트, 영상, 이미지, 워드나 pdf문서와 같은 멀티미디어 데이터		
*/

--5 
/*
수치형 데이터로 크기비교와 연산이 가능한 이산형 데이터와 연속형 데이터는 양적 데이터라고도 부른다.
이산형 데이터 - 개수를 셀 수 있는 띄엄띄엄 단절된 숫자 값을 가지는 데이터로 고객수, 판매량 등이 있다.
연속형 데이터 - 측정을 통해 얻어지는 연속적으로 이어진 숫자 값을 가지는 데이터로 키, 온도, 점수 등이 있다
*/

--6 6. 테이블과 컴럼명의 alias를 사용하는 방법을 예제를 통해서 기술하세요.
-- alias : 컬럼명의 별칭 
SELECT  empno AS 사원번호,   -- AS사용
        ename 사원명,       -- 띄어쓰기 사용
        job "직책 혹은 직급"  -- 띄어쓰기 사용
FROM EMP;





/*
== 평가대비(데이터베이스) 객관식 문제 ==
1. 정보 시스템의 개념을 맞는 것은 ?
1) 데이터를 저장하고 있다가 필요할 때 제공하는 역할 담당
2) 특정 조직의 여러 사용자가 공유하여 사용할 수 있도록 통합해서 저장한 운영 데이터의 집합 
3) 조직 운영에 필요한 데이터를 수집하여 저장해두었다가 필요할 때 유용한 정보를 만들어 주는 수단
4) 구조화된 데이터, 즉 미리 정해진 구조에 따라 저장된 데이터
정답:3

2. 데이터베이스의 특징이 아닌 것은?
1) 실시간 접근성 
2) 개별적 공유
3) 계속 변화
4) 내용 기반 참조
정답:2

3. 아래 내용 중 반정형 데이터는 어떤 데이터인가?
1) 엑셀
2) pdf
3) sns 문서
4) xml
정답:4

4. 다음 데이터 중 범주형 데이터 중 명목형 데이터에 속하는 것은 어느 것인가?
1) 학년
2) 회원등급
3) 성별
4) 키
정답:3
*/




