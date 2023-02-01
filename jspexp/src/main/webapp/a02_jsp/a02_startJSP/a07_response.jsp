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
# response 기본 객체
1. 웹 브라우저에 전송하는 응답 정보 설정
2. 주요 기능
	1) 헤더 정보 입력
	2) 리다이렉트 처리
3. 기능 메서드
	1) addDateHeader(String name, long date)
	  	name 헤더에 date를 추가 처리 1971/1/1 기준으로 1/1000초 단위 설정
	2) addHeader(String name, String value)
		name 헤더에 value를 값으로 추가한다
	3) addIntHeader(String name, int value)
		name헤더에 정수값 value를 추가한다
	4) setDateHeader(String name, long date)
		name헤더의 값을 date로 지정한다. date는 1970년1월1일 이후 흘러간 시간을 1/1000초 단위를 나타낸다
	5) setHeader(String name, String value)
		name 헤더의 값을 value로 지정한다
	6) setIntHeader(String name, int value)	
		name헤더의 값을 정수 값 value로 지정한다
4. 리다이렉트
	1) 특정 페이지로 이동하라고 웹 브라우저에 응답
	2) 서버 안에서 명령문으로 특정 페이지로 이동 처리
		response.sendRedirect(String location)	
		요청에 의해서 데이터를 전송하고 그 전송된 내용에 판단에 의해서 페이지가 결정될 때.. 
		ex) login경우, DB내용에 따라 페이지 결정
		ps) 페이지 이동 시 처리한 내용
		
		# 단계별 처리 내용
		0. a href, location.href
			1) 페이지 이동
			2) 클라이언트 단아ㅔ서 페이지 이동 처리
		1. form 객체를 통해서 처리되는 내용
			1) 페이지 이동
			2) 요청값을 함께 전달(클라이언트 ==> 서버)
		2. response.sendRedirect	
			1) 페이지 이동 (서버 내부에서 조건에 따른 처리)
		3. session범위에 따른 처리
			1) session값과 함께 전송	
					
	cf) location.href="이동페이지" 브라우저에서 특정한 페이지로 이동 처리
		화면에 클릭하여 페이지 이동, 메뉴이동은 대부분 js, a href로 처리

--%>
	<h2>redirect와 location.href의 차이</h2>
	<form>
		이동할 페이지
		<select name="page01">
			<option value="a07_admin.jsp">관리자페이지</option>
			<option value="a07_normal.jsp">일반사용자페이지</option>
		</select>
		<input type="submit" value="이동(서버단)">
		<input type="button" value="이동(클라이언단)" onclick="goPage()">
	</form>
	<script type="text/javascript">
		function goPage(){
			// 서버단에 가지 않고 여기서 바로 특정 자원으로 location.href를 통해서 처리
			var page01Val= document.qeurySelector("[name=page01]").value
			location.href=page01Val
		}
	</script>
	
	<%
		String page01 = request.getParameter("page01");
		if(page01!=null){
			// 서버단에서 요청값에 따라서 특정 페이지를 이동해서 출력 처리
			// 서버단에서 DB처리, java로직 처리 등
			response.sendRedirect(page01);
		}
		
	// ex) form화면에 아이디 패스워드를 입력해서 해당 서버로 이댕해서 해당 요청값이 himan/7777일때는 
	//		메인페이지(a07_main.jsp) 이동, 그렇지않으면 현재(a07_response.jsp)에 있게 처리하세요
	%>

	
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>