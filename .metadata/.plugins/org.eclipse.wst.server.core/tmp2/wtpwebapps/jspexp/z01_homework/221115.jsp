<%-- 
2022-11-14
[1단계:개념] 1. jsp를 이용하여 객체형 배열을 처리할려고 한다. 처리하는 순서를 기술하세요.
[1단계:확인] 2. Computer 클래스에 제조사, 가격, 종류 속성을 선언하고, jsp 화면에 테이블로 리스트를 출력하세요.
[1단계:개념] 3. jsp에서 DB처리를 위해 필요한 설정을 기술하세요.
[1단계:확인] 4. dao에 부서정보를 찾아서, jsp로 부서정보를 출력하세요.
[1단계:확인] 5. dao에 회원정보리스트 처리 기능메서드를 추가하고 jsp로 회원정보리스트를 출력하세요.
[1단계:개념] 6. js의 함수의 기본형식을 기술하고 매개변수로 밑면과 높이를 전달하고, 삼각형의 면적으로 리턴값을 alert() 출력되게 처리해보세요.
[1단계:개념] 7. 이벤트와 이벤트핸들러 함수와의 관계를 실제 이벤트 처리 코드를 기준으로 설명하세요.
[1단계:확인] 8. 학생의 이름 정보와 국어,영어,수학점수를 입력 후, 클릭시, 총점과 평균이 출력되게 하세요.
[1단계:확인] 9. 1~9까지 번호가 있는 3X3테이블을 만들고 해당 td를 클릭시 마다, 클릭한 td만 배경색상과 글자 색상이 변경되게 처리하세요.
[3단계:확인] 10. 좋아요버튼과 싫어요 버튼 만들고, 좋아요 버튼을 누를 때 마다 
                  하단에 ♥가 증가되고, 싫어요 버튼을 누를 때 마다♡ 증가 되게 처리해보세요 
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
	import="jspexp.vo.*"
    import="java.util.*" 
    import="jspexp.a13_database.*"    
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
// 객체형 List 처리
1. 구조 만들기/import처리
2. 리스트로 데이터 넣기
3. 반복문 처리하기
--%>
<%-- 
2 
여기는 import="jspexp.vo.*"

<h2>2번</h2>
<%
	List<Computer> clist = new ArrayList<Computer>();
	clist.add( new Computer("LG", 1200000, "LG gram"));
	clist.add( new Computer("SAMSUNG", 1300000, "갤럭시 북"));
	clist.add( new Computer("APPLE", 2100000, "MacBook"));
%>		
	<table border>
		<tr><th>제조사</th><th>가격</th><th>종류</th></tr>
		<%for(Computer c : clist){ %>
		<tr><td><%=c.getCompany() %></td><td><%=c.getPrice() %></td><td><%=c.getKind() %></td></tr>
		<%} %>
	</table>
--%>
	
<%--
3 
1) jdbc드라이버를 설정(웹프로그래밍 단위)    경로: \webapp\WEB-INF\lib
2) dao를 위한 설정처리(ip, port, sid, 계정, 비번)	 연결부분 확인
3) dao 기능 메서드 구현
4) jsp에서 해당 dao import, vo import
	
--%>


	
<%--
4

<% A03_DeptDao dao = new A03_DeptDao(); %>
<h2>4번</h2>
<h2>부서정보</h2>
<table>
	<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
	<%for(Dept d:dao.showDeptAll()) {%>
	<tr>
		<td><%=d.getDeptno() %></td>
		<td><%=d.getDname() %></td>
		<td><%=d.getLoc() %></td>
	</tr>
	<%} %>
</table>


4번정답
1) 부서정보 기능메서드 확인
2) jsp import확인
3) dao객체 생성
4) 반복문을 통해서 출력확인
5) script(scriplet, expression)을 통해서 table형식으로 출력 처리

여기는  import="jspexp.a13_database.vo.*"

<% A06_PareparedDao dao = new A06_PareparedDao(); %>
<h2>부서정보</h2>
<table>
	<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
	<%for(Dept d:dao.getDeptList(new Dept("",""))) {%> <%-- 공백이라서 전체 검색 
	<tr>
		<td><%=d.getDeptno() %></td>
		<td><%=d.getDname() %></td>
		<td><%=d.getLoc() %></td>
	</tr>
	<% } %>
</table>
--%>

<%--
5

<%
A02_EmpDao dao01 = new A02_EmpDao();
%>
<h2>5번</h2>
<h2>사원정보</h2>
<table>
	<tr>
		<th>사원번호</th><th>사원명</th><th>직책명</th><th>관리자번호</th><th>급여</th><th>부서번호</th>
	</tr>
	<% 
	for(Emp e:dao01.getEmpSch()){
	%>
	<tr>
		<td><%=e.getEmpno() %></td>
		<td><%=e.getEname() %></td>
		<td><%=e.getJob() %></td>
		<td><%=e.getMgr() %></td>
		<td><%=e.getSal() %></td>
		<td><%=e.getDeptno() %></td>
	</tr>
	<%} %>
</table>

5번정답
1. dao 기능메서드 처리 순서
	1) sql 확인
	2) vo 추가
	3) 기능메서드 추가
	4) dao호출
	5) for script
 --%>
<h2>회원정보</h2>
<% A06_PareparedDao dao = new A06_PareparedDao(); %>
<table>
	<tr><th>ID</th><th>이름</th><th>권한</th><th>포인트</th><th>주소</th></tr>
	<% for(Member m : dao.getMemberList()){ %>
	<tr>
		<td><%=m.getId() %></td>
		<td><%=m.getName() %></td>
		<td><%=m.getAuth() %></td>
		<td><%=m.getPoint() %></td>
		<td><%=m.getAddress() %></td>
	</tr>
	<% } %>
</table>


<%-- 
6 
js의 함수 기본 형식
	function 함수명(매개변수, ..){
		프로세스 처리
		return 리턴값;
	}
--%>
	<h2>6번</h2>
	<h3 onclick="triangle(15,31)">삼각형의 면적(클릭)</h3>
	
<%-- 
7
# 이벤트와 이벤트 핸들러 함수 처리
1. js에서의 이벤트
	js에서는 속성으로 on이벤트명="이벤트핸들러"를 통해서 해당 이벤트가 발생을 했을 때
	처리할 코드를 특정한 함수를 통해서 정의한 내용을 수행할 수 있다 
2. 처리 순서 
	1) 이벤트 핸들러 함수 선언 : 이벤트를 통해 처리할 내용 함수 선언 
	2) 이벤트 속성 선언 및 이벤트 핸들러 함수 호출
		태그 on이벤트명="이벤트핸들러함수()"
	3) 이벤트 핸들러에 매개변수 전달 
		- 함수에 매개변수를 선언하여 문자열, 숫자 데이터를 전달할 수 있다
--%>	

<%-- 8 --%>	
<h2>8번</h2>
이름:<input type="text" name="sname"/>
국어:<input type="text" name="kor"/>
영어:<input type="text" name="eng"/>
수학:<input type="text" name="math"/>
<input type="button" value="산출" onclick="score()"/>
<h4>학생의 점수</h4>


<%-- 9 --%>
<h2>9번</h2>
<table width="70%" border>
	<tr><td onclick="call09(this)">1사건의 지평선</td><td onclick="call09(this)">2생각이 많은 건 말야</td><td onclick="call09(this)">3당연히 해야 할 일이야</td></tr>
	<tr><td onclick="call09(this)">4나에겐 우리가</td><td onclick="call09(this)">5지금 1순위야</td><td onclick="call09(this)">6안전한 유리병을 핑계로</td></tr>
	<tr><td onclick="call09(this)">7바람을 가둬 둔 것 같지만</td><td onclick="call09(this)">8기억나 그날의 우리가</td><td onclick="call09(this)">9잡았던 그 손엔 말이야</td></tr>
</table>

<%-- 10 --%>
<h2>10번</h2>
	<table width="30px">
		<tr align="center">
			<td><input type="button" value="좋아요" onclick="like()"></td>
			<td><input type="button" value="싫어요" onclick="dislike()"></td>
		</tr>	
	</table>
	<h4 id="like">좋아요_</h4>
	<h4 id="dislike">싫어요_</h4>

</body>
<script type="text/javascript">
//6번
function triangle(base, height){
	alert("면적 :" + base*height*1/2);
}

//8번
function score(){
	var sname=document.querySelector("[name=sname]").value;
	var kor=document.querySelector("[name=kor]").value;
	var eng=document.querySelector("[name=eng]").value;
	var math=document.querySelector("[name=math]").value;
	
	var tot=Number(kor)+Number(eng)+Number(math);
	var avg=tot*1/3;
	
	document.querySelector("h4").innerText=sname+"학생의 총점은 "+tot+"점, 평균은 "+avg+"점 입니다."
}

//9번
function call09(obj){
	obj.style.color="white";
	obj.style.background="#B6DCFE";
}

//10번
function like(obj){
	document.querySelector("#like").innerText+="♥";
}
function dislike(obj){
	document.querySelector("#dislike").innerText+="♡";
}
</script>
</html>