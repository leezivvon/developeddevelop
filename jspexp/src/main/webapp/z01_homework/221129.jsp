<%--
2022-11-29
[1단계:개념] 1. [js] 대입연산자를 통한 변수의 대입과 객체의 대입의 메모리 할당의 차이점을 예제를 통해서 기술하세요 
[1단계:확인] 2. [js] 선수1(소속,이름,득점)을 json 객체로 선언하여, 대입연산자로 선수2할당한 경우와 ...(spread) 키워드로 
                  deep복사한 선수2를 만들어 득점을 증가했을 때, 차이를 출력하세요.
[1단계:확인] 3. [js] 회원 아이디를 입력하면 입력된 수를 옆에 표시하세요.
[2단계:확인] 3. [js] 회원 아이디를 입력시 글자수 제한을 8~16로 처리하기로 했다. 입력시, 해당 범위에 맞지 않으면
               하단에 입력범위는 8~16 표시하고 그외에는 입력가능으로 표시하게 하세요.
[2단계:확인] 4. [js] 팀인원등록[    ][등록] ==> 선수명을 ,단위로 구분해서 등록 버튼을 누르면 바로 밑에 테이블 형식으로 번호(1.2...)와 함께 이름이 출력되게 하세요
[1단계:확인] 5. [jsp] 웹 서버단위로 초기 설정값을 설정할려고 한다. 처리 방식을 기술하세요
[1단계:확인] 6. [jsp] 웹 서버에서 DB 주소, port, sid, 계정, 비번설정해서 DB를 접속할려고 한다. 처리하고, 호출하세요.
[1단계:개념] 7. [jsp] 세션 scope의 4가지 범위를 예제와 함께 기술하세요.
[1단계:확인] 8. [jsp] 회원을 아이디(page), 이름(request), 포인트(session), 권한(application) 범위로 설정하여, 출력하세요.
               요청값 범위 확인, 세션값 범위 확인 클릭을 통해 해당 범위 데이터를 확인하세요.
[3단계:확인] 9. [jsp] 로그인페이지(z10_login.jsp) 아이디와 패드워드를 입력해서,  z11_checkValid.jsp로 submit처리하여
                  인증이되면 session범위로 id를  설정하여 z11_main.jsp에 @@님 로그인되었습니다. 출력하게하고,
                  그렇지 않으면 request의 forward메서드로 처리 z01_login.jsp 화면에서 로그인 실폐하였습니다가 
                  출력되게 하세요.
                  


var player1 = {team:"레알마드리드",name:"아자르"};
var player2 = {...obj};
player2.team = "바르셀로나";
player2.name = "레반도프스키";
console.log(player2.team);
console.log(player2.name);
이처럼 spread 연산자를 통한 복사는 다른 객체 주소를 가지게 된다.
대입연산자를 통한 복사는 같은 주소를 가진다. 
왜냐하면 참조에 의해서 할당되기 때문이다.

[1단계:확인] 3. [js] 회원 아이디를 입력하면 입력된 수를 옆에 표시하세요.
function keyEvent(){
	 var size = document.querySelector("[name=id]").value
	 var sobj = document.querySelector("#record")
	 
	 sobj.innerText = size.length;
 }
</script>
</head>
<body>
<h2>로그인</h2>
아이디 : <input type = "text" name = "id" value = "" onkeyup= "keyEvent()"/>
비밀번호 : <input type = "password" name = "password"/>
아이디 입력 수 : <span id = "record"/>0</span>
<input type ="submit" value = "확인"/>
</body>
<script type = "text/javascript">


[3단계:확인] 9. [jsp] 로그인페이지(z10_login.jsp) 아이디와 패드워드를 입력해서,  z11_checkValid.jsp로 submit처리하여
                  인증이되면 session범위로 id를  설정하여 z11_main.jsp에 @@님 로그인되었습니다. 출력하게하고,
                  그렇지 않으면 request의 forward메서드로 다리 z01_login.jsp 화면에서 로그인 실폐하였습니다가 
                  출력되게 하세요.

z10_login.jsp 

<body>
<%
String loginError = (String)session.getAttribute("loginError");
if(loginError == null){loginError = "";}
session.invalidate();
%>
<script>

</script>
<form action = "checkValued.jsp" method = "post">
아이디 : <input type = "text" name = "id" placeholder = "아이디를 입력하세요."/>
패스워드 : <input type = "password" name = "pw" placeholder = "비밀번호를 입력하세요."/>
<input type = "submit" value = "로그인"/>
</form>
<h2 id = "loginError" style = "color:red"><%=loginError %></h2>
</body>
</html>

checkValued.jsp

<body>
<%

String s_id = "sogargi";
String s_pw = "uni266";
String s_name = "전윤환";

if(s_id.equals(request.getParameter("id"))&&s_pw.equals(request.getParameter("pw"))){
	session.setAttribute("member",s_name);
	response.sendRedirect("z11_main.jsp");
}else{
	
	session.setAttribute("loginError","로그인 실패하였습니다. 다시 입력해주세요.");
	response.sendRedirect("z10_login.jsp");
	
}
%>

</body>
</html>

z11_main.jsp

<h2><%=session.getAttribute("member") %>님 안녕하세요!</h2>
</body>                  
                  
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
</head>
<body>

<div id="container"></div>



<%-- 3정답 --%>
<script type="text/javascript">
function ckID(obj){
	var len  = obj.value.length
	var spanOb = document.querySelector("span")
	var msg = "아이디는 8~16 입력가능합니다"
	spanOb.style.color="red"
	
	if(len>=8 && len<=16){
		msg = "유효한 아이디입력"
		spanOb.style.color="blue"
	}
	spanOb.innerText=msg
}
</script>
ID입력_<input type="text" name="id" onkeyup="ckID(this)" >
<!--  ID입력_<input type="text" name="id" onkeyup="write(this)" >  write(this)이렇게 하면 페이지가 넘어갔음 -->
<span>아이디입력</span><br>



<%-- 4정답 --%>
<script type="text/javascript">
	function regTab(){
		var data = document.querySelector("[name=regMem]").value
		var players =data.split(", ") //배열 //"홍길동,김길동,신길동" ==> [ "홍길동", "김길동", "신길동"]
		var shHTML ="<table><tr><th>번호</th><th>이름</th></tr>"
		players.forEach(function(player, idx){ // 배열처리 for문
			shHTML +="<tr><td>"+(idx+1)+"</td><td>"+player+"</td></tr>"
		})
		shHTML += "</table>"
		document.querySelector("#show").innerHTML = shHTML;
	}
</script>

<h2>팀인원등록</h2>
<input type="text" name="regMem">
<input type="button" value="등록" onclick="regTab()">
<div id = "show"></div>



<%--
//5
/*
web.xml에
<context-param>
		<description>로깅여부</description>
		<param-name>logEnagled</param-name>
		<param-value>true</param-value>
	</context-param>

	<body>에	
<h3>logEnagled: <.%=application.getInitParameter("logEnagled") %.></h3> --> true출력

web.xml : 설정
application:호출(서버단위 설정값)
*/

//6
// 자바의 변경이나 서버 단위 설정정보변경(web.xml..)은 실행 시 반드시 서버를 재가동하여야 한다
--%>
<h2> DB정보 </h2>
<h3>주소:<%=application.getInitParameter("ip") %></h3>
<h3>포트:<%=application.getInitParameter("port") %></h3>
<h3>DB명:<%=application.getInitParameter("sid") %></h3>
<h3>계정:<%=application.getInitParameter("username") %></h3>
<h3>비번:<%=application.getInitParameter("pass") %></h3>


<%
//7
/*
	1) page 영역 : 하나의 jsp 페이지를 처리할 때 사용되는 영역
	2) request 영역 : 하나의 http 요청을 처리할 때 사용되는 영역
	3) session 영역 : 하나의 웹 브라우저와 관련된 영역
*/
pageContext.setAttribute("pname", "싸이버거(page)");
request.setAttribute("price", 5600);
session.setAttribute("cnt", 3);
%>
<table>
	<tr><th>물건명(page)</th><td><%=pageContext.getAttribute("pname") %></td></tr>
	<tr><th>가격(request)</th><td><%=request.getAttribute("price") %></td></tr>
	<tr><th>개수(session)</th><td><%=session.getAttribute("cnt") %></td></tr>
</table>
<a href ="a16_showSession.jsp">session범위로 확인</a>


<%
//8

pageContext.setAttribute("id", "abcdef01");
request.setAttribute("name", "공명");
session.setAttribute("point", 500);
application.setAttribute("auth", "회원");
%>
<table>
	<tr><th>id</th><td><%=pageContext.getAttribute("id") %></td></tr>
	<tr><th>이름</th><td><%=request.getAttribute("name") %></td></tr>
	<tr><th>포인트</th><td><%=session.getAttribute("point") %></td></tr>
	<tr><th>권한</th><td><%=application.getAttribute("auth") %></td></tr>
</table>

<a href ="221129_session.jsp">세션값범위확인</a>
<!-- <a href ="a11_requestTest.jsp">요청값범위확인</a>  얘는 모르겠따-->


<%
//9
/*
처리 순서
1 업무처리 flow확인
	로그인페이지에서 아이디 패스워드 입력 ==> 인증여부에 따라서 ==> 로그인페이지/메인페이지
2 개발 순서
	1) 로그인 화면 구성( z10_login.jsp )
		-4)항목을 같이 처리해도 무방
		<form action="z11_checkValid.jsp">
	
	2) form action 요청페이지 호출 설정(유효성 check-js)
	3) 요청값을 받은 내용을 처리 ( z11_checkValid.jsp )
		- DB나 조건에 의해 인증되었을 때 세션값 설정 z11_main.jsp 이동 처리
		- 인증되지 않았을 때 forward로 z10_login.jsp 이동
			if(id.equals("himan" && pass.equals("7777"))){
				session.setAttribute("id", id);
				response.sendRedirect("z11_main.jsp")''
			}else{
				// request.setAttribute()로 처리해도 되지만 request.getParameter("id")로 처리가 되기에 생략가능
				request.getRequestDispather("z10_login.jsp").forward(request, response);
			}
			
	4) 유효화하지 않은 id에 대한 로그인 화면 요청값 처리 ( z10_login.jsp )
		- request 객체로 요청값 확인 및 인증되지 않음 경고창 처리
			String id = request.getParameter("id")
			boolean isInvalid = false;
			if(id!=null){
				isInvalid = true;
			}
			js
			var isInvalid = <%=isInvalid %.>;
			if(isInvalid) alert("<%=id %.>는 인증된 계정이 아닙니다");
			
	5) 메인 화면에서 session출력 z12_main.jsp	
		<h2><%=session.getAttribute("id") %.>님 로그인 중입니다 </h2>
*/

%>

</body>

<script type="text/javascript">

var show = document.querySelector("#container")

/*
//1

//일반변수는 stack영역에 데이터를 바로 할당하기에 대입을 하여도 다른 메모리를 사용한다
var num01 =25 // 일반변수 
var num02 = num01
num02 = 30
show.innerHTML+=num01+"<br>" // 25출력
show.innerHTML+=num02+"<br>" // 30출력
//배열을 포함한 객체는 대입연산자에 의해 객체가 실제 저장하는 주소값을 할당하기에 주소값을 복사해서 할당했으므로 동일한 객체를 참조하기에
//이름이 다르지만 동일한 객체를 바라보고 있어서 한쪽에 데이터가 변경되면 다른쪽도 동일하게 처리된다
var array01 = [1000, 2000, 3000]
var array02 = array01
array02[0] = 5000
show.innerHTML=array01+"<br>" 	//5000,2000,3000 출력
show.innerHTML+=array02+"<br>"	//5000,2000,3000 출력

*/
//2
var p01 = {team:"토트넘" player:"손흥민" score:1000}
var p02 = p01		// 대입연산자로할당
var p03 = {...p01}	// deep복사
p02.score=2000
p03.score=2000

show.innerHTML = JSON.stringify(p01)+"<br>"
show.innerHTML += JSON.stringify(p02)+"<br>"
show.innerHTML += JSON.stringify(p03)+"<br>"


</script>
</html>


<%--


 
][3단계:확인] 9. [jsp] 로그인페이지(z10_login.jsp) 아이디와 패드워드를 입력해서,  z11_checkValid.jsp로 submit처리하여
                  인증이되면 session범위로 id를  설정하여 z11_main.jsp에 @@님 로그인되었습니다. 출력하게하고,
                  그렇지 않으면 request의 forward메서드로 다리 z01_login.jsp 화면에서 로그인 실폐하였습니다가 
                  출력되게 하세요.

--%>