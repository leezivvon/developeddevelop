<%-- 
2022-11-17
[1단계:개념] 1. [jsp] 문자열과 숫자형 요청값을 처리시 default 설정 처리내용을 기술하세요.
[1단계:확인] 2. [jsp] dao에 회원정보리스트를 검색하는 기능메서드(조회 조건 추가)를 만들고, 출력처리 하세요..
[1단계:확인] 3. [jsp] 아래의 sql 활용하여  dao기능메서드를 추가하고 검색리스트를 출력하세요.
               SELECT * 
               FROM salgrade
               WHERE grade BETWEEN 1 AND 5;

               등급 시작 [   ]
               등급 끝 [   ]   [검색]
               검색된 리스트

[1단계:확인] 4. [js] h1 클릭하세요를 클릭시,  z02_show.jsp로 이동되게 함수를 선언하고 js의 페이지 이동 기능 객체를 활용하여 처리하세요
[1단계:확인] 5. [jsp==>js] jsp변수로 이름, 나이, 성인여부(나이가 20이상 ) 스크립트릿(<%%>)에 선언하고, 
               js에서 이를 할당하여 alert()으로 출력되게 하세요.
[1단계:확인] 6. [jsp] 기존 사원정보 조회리스트 기준으로 사원정보 등록으로 화면 이동 및 등록 처리 후, 리스트 화면으로 이동 되게 기능처리하세요.
[1단계:확인] 7. [js] let변수와 var의 차이점을 10~100까지 5씩 증가하는 for문의 합산값을 통해서 확인하세요.
[1단계:확인] 8. [js] 객체와 for in 구문의 관계를 음악정보(음악명,가수명,발매연도)를 통해 선언하고 출력하세요.
[1단계:확인] 9. [js] 배열과 for of 구문을 통해서 프리미어리그 순위 리스트를 테이블로 출력해보세요.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
*/
</script>

</head>
<body>
<%-- 
1 
요청값이 없을 때 default데이터를 위한 처리
if조건을 통해서 null인 경우 
	1) 문자열 ==> ""	ex) if(name==null) name="";
	2) 숫자 ==> 0		ex) if(age==null) age="0";

--%>



<%-- 2 
<h4>2번</h4>
<%
String ename = request.getParameter("ename"); if(ename==null) ename="";
A03_PrEmp dao = new A03_PrEmp();
%>
<h2>회원정보 검색</h2>
<form>
	<table>
		<col width="40%">
		<tr><th>회원이름</th><td><input type="text" name="ename" value="<%=ename%>"></td></tr>
		<tr><td colspan="2"><input type="submit" value="검색" ></td></tr>
	</table>
</form>

<table>
	<tr>
		<th>이름</th><th>회원번호</th><th>직책</th><th>생일</th><th>주소</th>
	</tr>
	<%for(Pemp e : dao.getPempList(ename)) {%>
		<tr>
			<td><%=e.getEname() %></td>
			<td><%=e.getEmpno() %></td>
			<td><%=e.getPos() %></td>
			<td><%=e.getBirthd() %></td>
			<td><%=e.getAddress() %></td>
		</tr>
	<%} %>
</table>


2번정답
#개발순서
1) 필요로 하는 조회 조건 sql작성 ==> test : DBscript
	SELECT * FROM MEMBER  
	WHERE name LIKE '%'||'홍'||'%' 
	AND auth LIKE '%'||'고객'||'%'

2) 회원리스트 기능메서드 확인
3) 추가 기능메서드 확인(조회 조건VO를 확인- 생성자 확인)
	name, auth 생성자 만들었음
	
4) 회원리스트 기능메서드 복사해서 
	- sql 삽입
	- 매개변수 VO로 할당
	- pstmt 처리 내용 확인
	
5) 화면 구성
	- form 조회	
	- 리스트 테이블 만들기
6) 요청값에 설정
7) 요청값에 따른 DB호출
--%>
<%-- 5) 화면 구성 - form 조회	- 리스트 테이블 만들기 --%>
<%
String name = request.getParameter("name"); if(name==null) name="";
String auth = request.getParameter("auth"); if(auth==null) auth="";
Member sch = new Member(name, auth);

//DB데이터가 초기 화면에 현재 데이터 로딩되게 처리
A06_PareparedDao dao = new A06_PareparedDao();
%>
<h2>회원조회리스트</h2>
<form>
	회원명:<input type="text" name="name" value="<%=name %>"/>
	권한	:<input type="text" name="auth" value="<%=auth %>">
	<input type="submit" value="검색"> 
	<input type="submit" value="등록"/>
</form>
<table>
	<tr><th>아이디</th><th>이름</th><th>권한</th><th>포인트</th><th>주소</th></tr>
	<%for(Member m:dao.getMemberList(sch)){ %>
	<tr><td><%=m.getId() %></td><td><%=m.getName() %></td><td><%=m.getAuth() %></td>
		<td><%=m.getPoint() %></td><td><%=m.getAddress() %></td></tr>
	<%} %>
</table>


<%-- 3 --%>
<h4>3번</h4>
<h2>연봉등급 검색</h2>
<%
String strSal=request.getParameter("strGrade"); 
int strGradeInt=0;
String finSal=request.getParameter("finGrade"); 
int finGradeInt=0;

//A06_PareparedDao dao = new A06_PareparedDao();
Salgrade schh = new Salgrade(strGradeInt, finGradeInt);
%>
<form>
	<table>
		<col width="40%">
		<caption>검색등급</caption>
		<tr><th>시작등급</th><td><input type="text" name="strGrade" value="<%=strGradeInt %>"></td></tr>
		<tr><th> 끝등급</th><td><input type="text" name="finGrade" value="<%=finGradeInt %>"></td></tr>
		<tr><td colspan="2"><input type="submit" value="검색" ></td></tr>
	</table>
</form>

<table>
	<tr>
		<th>등급</th><th>급여시작</th><th>급여끝</th>
	</tr>
	<%for(Salgrade s: dao.SalList(schh)) {%>
		<tr>
			<td><%=s.getGrade() %></td>
			<td><%=s.getLosal() %></td>
			<td><%=s.getHisal() %></td>
		</tr>
	<%} %>
</table>
<%-- //17일에 --%>

<%-- 
[1단계:확인] 4. [js] h1 클릭하세요를 클릭시,  z02_show.jsp로 이동되게 함수를 선언하고 js의 페이지 이동 기능 객체를 활용하여 처리하세요
[1단계:확인] 5. [jsp==>js] jsp변수로 이름, 나이, 성인여부(나이가 20이상 ) 스크립트릿(<%%>)에 선언하고, 
               js에서 이를 할당하여 alert()으로 출력되게 하세요.
[1단계:확인] 6. [jsp] 기존 사원정보 조회리스트 기준으로 사원정보 등록으로 화면 이동 및 등록 처리 후, 리스트 화면으로 이동 되게 기능처리하세요.
[1단계:확인] 7. [js] let변수와 var의 차이점을 10~100까지 5씩 증가하는 for문의 합산값을 통해서 확인하세요.
[1단계:확인] 8. [js] 객체와 for in 구문의 관계를 음악정보(음악명,가수명,발매연도)를 통해 선언하고 출력하세요.
[1단계:확인] 9. [js] 배열과 for of 구문을 통해서 프리미어리그 순위 리스트를 테이블로 출력해보세요.
--%>
<%-- 4정답 --%>
<h1 onclick="goPage()">클릭하면 이동입니다</h1>

<%-- 5정답 --%>
<%
	String sname = "홍길동";
	int age = 25;
	boolean isAdult = age>=20;
	// server안에서만 사용 client단으로 전달할 때는 사라진다
%> 
<%-- 
6정답 
1) 등록 Dao 메서드 만들기
	sql
	insert into member values('아이디','패스워드','이름','권한',1000,'주소');
	insert into member values(?,?,?,?,?,?)
	
	public void insertMember(Member ins){
	
	}
2) 조회화면에서 이동
	<input type="button" value="회원등록" onclick="insertMember()">
	function insertMember(){
		if(confirm("등록하시겠습니까?")){
			location.href="z03_insertMember.jsp"
		}
	}
3) 등록폼
	<form>
		아이디:<input type="text" name="id"/>
		패스워드:<input type="text" name="pass"/>
		이름:<input type="text" name="name"/>
		권한:<input type="text" name="auth"/>
		포인트:<input type="text" name="point"/>
		주소:<input type="text" name="address"/>
		<input type="submit" value="등록"/>
	</form>	
4) 요청처리
	String id = request.getParameter("id")	
	String pass = request.getParameter("pass")	
	String name = request.getParameter("name")	
	String auth = request.getParameter("auth")	
	int point = Integer.parseInt(request.getParameter("point"));
	String address = request.getParameter("address")	
5) 등록 객체 생성
6) Dao에 등록 메서드 호출
	boolean isInsert=false;
	if(id != null && !id.equals("")){
		dao.insertMember(ins)
		isInsert=true;
	}	
7) script등록 후 처리
	var isInsert = <%=isInsert %>
	if( isInsert ){
		if(confirm("등록성공\n조회화면으로 이동하시겠습니까?")){
			location.href="055_1117.jsp";
		}
	
	}	
--%>


</body>

<script type="text/javascript">
//4번 정답
function goPage(){
	if(confirm("이동할까요?")){
		location.href="z02_show.jsp"
	}
}

//5번정답
	// var age = 25	형식으로 전달
//	var age = <%=age %>
//	alert("나이:"+age)
//	var isAdult = <%=isAdult %>
//	alert("성인 여부: "+isAdult)
//	if( isAdult ){
//		alert("성인입니다")
//	}else{
//		alert("미성년입니다")
//	}
	
	var sname= "<%=sname %>"
	alert(sname)
	// var sname = 홍길동  //변수로 인식해서 에러가 발생  >> "홍길동"으로 해주면 문자열로 인식
	// 이 라인에 에러가 발생하는 순간 이후 js는 처리가 되지 않는다
	// 문자열 데이터는 반드시 client에 전송할 때 " ",' '를 붙여 주어야 한다
	
// 6번정답
	<input type="button" value="회원등록" onclick="insertMember()">
	function insertMember(){
		if(confirm("등록하시겠습니까?")){
			location.href="z03_insertMember.jsp"
		}
	}
</script>
</html>