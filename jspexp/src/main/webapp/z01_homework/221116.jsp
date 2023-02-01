<%--
2022-11-16
[1단계:개념] 1. [js]"",'',`` 문자열 데이터의 사용 규칙과 특징을 기술하세요.
[1단계:확인] 2. [js] ``(백틱)으로 선언된 버스번호와 목적지를 변수로 선언하고 console.log로 줄바꾸어
               출력하세요.
[1단계:개념] 3. [js] js 숫자형 문자와 숫자의 데이터의 처리방식의 특징을 연산자와 비교연산식을 기준으로 기술하세요
[1단계:확인] 4. [js] prompt창으로 두개의 숫자를 입력받아, 사칙연산을 처리한 결과를 p태그로 출력하세요. 
[1단계:개념] 5. [js] ==, === 차이점은 무엇인가?
[1단계:개념] 6. [js] js의 데이터 유형 기술하고, 확인하는 함수와 함께 기본예제로 출력처리하세요.
[1단계:개념] 7. [js] 동적 배열이란 어떤 기능을 처리할 수 있는 배열을 말하는가?
[1단계:개념] 8. [js] 배열과 for in 구문을 관계를 정리하세요
[1단계:확인] 9. [js] 배열1에는 아이디 3개, 배열2에는 이름 3개를 선언하고, 반복문을 이용해서 테이블 리스트로
            출력하세요
[1단계:개념] 10. [jsp]요청값이란 무엇이고, query string과 어떤 연관 관계가 있는지 기술하세요.
[1단계:확인] 11. [jsp]form화면에 도서관에서 빌린책명, 대출일, 대출자명을 요청값으로 넘겨 테이블 형식 화면에 출력하게 하세요(null처리)
[1단계:확인] 12. [jsp]form화면에 구매 물건 3개의 (물건명/가격)을 입력하게하고, 구매 눌렀을 때, 구매 물건 리스트와
           총비용을 출력하게 하세요.
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
<!-- 
1 

-->


<%--
2022-11-16
[1단계:개념] 1. [js]"",'',`` 문자열 데이터의 사용 규칙과 특징을 기술하세요.
[1단계:확인] 2. [js] ``(백틱)으로 선언된 버스번호와 목적지를 변수로 선언하고 console.log로 줄바꾸어
               출력하세요.
[1단계:개념] 3. [js] js 숫자형 문자와 숫자의 데이터의 처리방식의 특징을 연산자와 비교연산식을 기준으로 기술하세요
[1단계:확인] 4. [js] prompt창으로 두개의 숫자를 입력받아, 사칙연산을 처리한 결과를 p태그로 출력하세요. 
[1단계:개념] 5. [js] ==, === 차이점은 무엇인가?
[1단계:개념] 6. [js] js의 데이터 유형 기술하고, 확인하는 함수와 함께 기본예제로 출력처리하세요.
[1단계:개념] 7. [js] 동적 배열이란 어떤 기능을 처리할 수 있는 배열을 말하는가?
[1단계:개념] 8. [js] 배열과 for in 구문을 관계를 정리하세요
[1단계:확인] 9. [js] 배열1에는 아이디 3개, 배열2에는 이름 3개를 선언하고, 반복문을 이용해서 테이블 리스트로
            출력하세요

--%>

<%--
10
요청값이란 client를 통해서 server로 전송된 데이터를 말한다
query string은 사용자가 입력 데이터를 전달하는 방법중의 하나로, url 주소에 미리 협의된 데이터를 파라미터를 통해 넘기는 것을 말한다.
기본 요청값 처리 ==> request.getParameter("요청값")
--%>

<%-- 11 --%>
<table border>
	<tr><th>도서명</th><td><%=request.getParameter("btitle") %></td></tr>
	<tr><th>대출일</th><td><%=request.getParameter("loandate") %></td></tr>
	<tr><th>대출자명</th><td><%=request.getParameter("lname") %></td></tr>
</table>

<%-- 12 --%>
<form>
	물건명:<input type="text" name="prod01" /> 가격:<input type="text" name="price01">
	물건명:<input type="text" name="prod02" /> 가격:<input type="text" name="price02">
	물건명:<input type="text" name="prod03" /> 가격:<input type="text" name="price03">
	<input type="submit" value="구매"> 
</form>
<%
String prod01 = request.getParameter("prod01"); if(prod01==null) prod01="";
String prod02 = request.getParameter("prod02"); if(prod02==null) prod02="";
String prod03 = request.getParameter("prod03"); if(prod03==null) prod03="";

String price01 = request.getParameter("price01"); if(price01==null) price01="0";
String price02 = request.getParameter("price02"); if(price02==null) price02="0";
String price03 = request.getParameter("price03"); if(price03==null) price03="0";
int price01Int = Integer.parseInt(price01);
int price02Int = Integer.parseInt(price02);
int price03Int = Integer.parseInt(price03);

int tott = price01Int+price02Int+price03Int;
%>
<h2>구매물건리스트</h2>
<ol>
	<li><%=prod01 %>: <%=price01 %>
	<li><%=prod02 %>: <%=price02 %>
	<li><%=prod03 %>: <%=price03 %>
	<li>총합:<%=tott %>
</ol>







<!-- 정답 -->
<!-- 4 -->
<p id="show"></p>
<!-- 9 -->
<h2 onclick="createInfo()">회원정보 생성</h2>
<table id="tab01"></table>
<!-- 12  -->
<h2>구매물건</h2>
<!-- action 속성이 있으면 해당 화면 jsp에 데이터를 넘기고 없으면 현재 jsp에 요청데이터를 넘긴다 -->
<form>
	<table>
		<col width="10%">
		<tr><th>no</th><th>물건명</th><th>가격</th></tr>
		<%for(int cnt=1;cnt<=3;cnt++) {%>
		<tr><td><%=cnt %></td>
			<td><input type="text" name="pname"></td>
			<td><input type="text" name="price" ></td></tr>
		<%} %>
		<tr><td colspan="3"><input type="submit" value="구매"></td></tr>	
	</table>
</form>
<%
int tot=0;
String buyList="";
for(int cnt=0;cnt<=3;cnt++){
	String pname=request.getParameter("pname"+cnt);
	String price=request.getParameter("price"+cnt);
	if(pname!=null) buyList+=pname+", ";
	if(price!=null) tot+=Integer.parseInt(price);
}
if(tot != 0){
%>
	<h2>구매목록리스트:<%=buyList %></h2>
	<h2>총비용:<%=tot %></h2>
<%	} %>

</body>
<script type="text/javascript">

/* 
4번정답

var num01 = prompt("첫번째 숫자입력","0")
var num02 = prompt("두번째 숫자입력","0")
var show= document.querySelector("#show")
show.innerHTML += num01+" + "+num02+" = "+(parseInt(num01)+parsInt(num02))+"<br>"
show.innerHTML += num01+" - "+num02+" = "+(num01-num02)+"<br>"
show.innerHTML += num01+" * "+num02+" = "+(num01*num02)+"<br>"
show.innerHTML += num01+" / "+num02+" = "+(num01/num02)+"<br>"
*/
*
// 9번정답
function createInfo(){
	// ajax를 이용하면 js단에서 서버에 접근해서 데이터를 가져와서 동적인 로딩 처리가 가능
	var tab01 = document.querySelector("#tab01")
	var ids = ['himan', 'goodman', 'badgirl']
	var names = ['홍길동', '김길동', '김영자']
	var addHTML = "<tr><th>아이디</th><th>이름</th></tr>";
	for(var idx=0;idx<ids.length;idx++ ){
		addHTML+="<tr><td>"+ids[idx]+"</td><td>"+names[idx]+"</td></tr>"
	}
	tab01.innerHTML = addHTML;
}
</script>
</html>