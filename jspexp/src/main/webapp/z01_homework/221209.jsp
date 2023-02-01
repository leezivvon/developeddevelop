<%-- 
2022-12-09
[1단계:개념] 1. 세션의 삭제방법을 기술하세요
[1단계:확인] 2. 로그인 클릭시 session에 설정 후 다시 Member의 아이디와 이름이 출력되고 하고,
           로그아웃 클릭시, 로그인해야합니다가 출력되게 하세요.
[1단계:확인] 3. el로 session범위로 사원 정보 사원번호, 사원명, 부서명을 저장후, 페이지가 이동해서도
           해당 정보를 출력하는 것을 확인하세요.
[1단계:확인] 4. 1~100까지 임의의 숫자를 session객체에 국어/영어/수학 점수로 할당후, el로 각 점수와 총점,
            평균, 평균70이상일때 합격 그외는 불합격을 출력하세요.
[1단계:개념] 5. el의 property란 무엇인가 기술하세요.
[1단계:확인] 6. Member객체로 session객체로 할당한 후, 해당 객체를 el로 호출하여 출력하세요.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"  
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
세션의 삭제 방법
1) 명시적으로 중단메서드에 의해서
	session.invalidate();
	ex) 로그아웃하면 지금까지 설정된 세션을 중단시켜준다
2) 시간을 설정해서 해당 시간이후 중단 처리(초 단위)
	session.setMaxInactiveInterval(1000);
	해당 시간동안 요청이 없을 때 중단
3) web.xml에서 서버단위로 설정
	서버 단위에서 분단위로 요청이 없을 때 중단
	<session-config>
		<session-timeout>30</session-timeout>
	</session-config>	
--%>

	<%-- 2 --%>
		<h2 onclick="login()">로그인</h2>
		<h2 onclick="logout()">로그아웃</h2>
	<script type="text/javascript">
		function login(){
			location.href="221209_session.jsp?idright=y"
		}
		function logout(){
			location.href="221209_session.jsp?idright=n"
		}
	</script>

	<% 
		String mm =(String)session.getAttribute("mkey");
		boolean islogin = mm!=null;
		if(islogin){
	%>
		<h2>로그인하셨습니다</h2>
		<h3>반갑습니다<%=mm.getName() %> </h3>
	<%		
		}
	%>
<h2 onclick="">로그인</h2>
<%-- 3 --%>
<%-- 4 --%>
<%-- 5 --%>
<%-- 6 --%>

<%-- 
[1단계:확인] 2. 로그인 클릭시 session에 설정 후 다시 Member의 아이디와 이름이 출력되고 하고,
           로그아웃 클릭시, 로그인해야합니다가 출력되게 하세요.
           
           
[1단계:확인] 3. el로 session범위로 사원 정보 사원번호, 사원명, 부서명을 저장후, 페이지가 이동해서도
           해당 정보를 출력하는 것을 확인하세요.
[1단계:확인] 4. 1~100까지 임의의 숫자를 session객체에 국어/영어/수학 점수로 할당후, el로 각 점수와 총점,
            평균, 평균70이상일때 합격 그외는 불합격을 출력하세요.
[1단계:개념] 5. el의 property란 무엇인가 기술하세요.
[1단계:확인] 6. Member객체로 session객체로 할당한 후, 해당 객체를 el로 호출하여 출력하세요.
--%>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>