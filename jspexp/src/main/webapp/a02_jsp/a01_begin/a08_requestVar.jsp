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
# 요청값을 변수할당
1. 요청값
	?name=사과&price=3000&cnt=2
2. 변수를 지정해서 할당하면 기본 문자열로 할당된다
	
# 요청값이 없을 때 default데이터를 위한 처리
1. if조건을 통해서 null인 경우 
	1) 문자열 ==> ""	
	2) 숫자 ==> 0
	초기화면에서 form요소객체에 의해서 요청값을 전송하지 않기 때문에 null데이터인 경우로 처리된다
	==> 한 페이지에서 form데이터 입력화면과 요청값을 전달할 결과 데이터 출력화면이 같이 처리될 때 주로 if(요청==null)를 check하여 처리한다
	
--%>
<%
String name = request.getParameter("name");
if(name==null) name="";
String price = request.getParameter("price");
if(price==null) price="0";
String cnt = request.getParameter("cnt");
if(cnt==null) cnt="0";
%>
	<h2>이름 :<%=name %></h2>
	<h2>가격 :<%=price %></h2>
	<h2>개수 :<%=cnt %></h2>
<%--
ex) 학생명 국어 영어 수학 점수를 요청값을 처리하고 default값으로 학생명은 없음, 숫자는 0으로 표현해서 테이블 형태로 데이터를 출력
		초기화면 - request.getParameter("sname")=null
		
		query string ?sname=&kor=&eng=&math=
			: 입력하지 않고 submit했을 때
			- request.getParameter("sname").equals("")
			ps) 서버에 전송되기 전에 js단에서 form요소가 입력되게 처리한다
		
		query string ?sname=이지은&kor=100&eng=85&math=70
			: 입력하고submit했을 때
			- request.getParameter("sname").equals("홍ㄱ길동")
--%>
<%
String sname=request.getParameter("sname");
if(sname==null) sname="없음";
String kor=request.getParameter("kor");
if(kor==null || kor.equals("")) kor="0";
String eng=request.getParameter("eng");
if(eng==null || kor.equals("")) eng="0";
String math=request.getParameter("math");
if(math==null || kor.equals("")) math="0";

//총점
// 문자열 형식으로 된 숫자형 문자열을 숫자로 변환 : Integer.parseInt("25") ==>25
// 실수는 Double.parseDouble("25.7")
// 입력없이 submit를 누르면 넘어갈 때 null이 아니고 ""으로 처리되때문에 Interger.parseInt("")에러가 발생한다
// 자바는 NumberFormatException 발생해서 수행중단, js parseInt("") ==> NaN
//?math=&kor=
int korInt = Integer.parseInt(kor);
int engInt = Integer.parseInt(eng);
int mathInt = Integer.parseInt(math);
int tot = korInt + engInt + mathInt;
%>
	<h2>예시-성적</h2>
	<table>
		<tr><th>학생명</th><td><%=sname %></td></tr>
		<tr><th>국어</th><td><%=kor %></td></tr>
		<tr><th>영어</th><td><%=eng %></td></tr>
		<tr><th>수학</th><td><%=math %></td></tr>
		<tr><th>총점</th><td><%=tot %></td></tr>
	</table>
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>