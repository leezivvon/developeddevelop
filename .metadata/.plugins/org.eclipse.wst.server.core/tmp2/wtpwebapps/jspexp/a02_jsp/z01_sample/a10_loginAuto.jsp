<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script>
/*
 
 */
</script>
</head>
<body>

<%--
# 자동 로그인 처리
1. 사용할 파일
	1) 로그인 (a10_loginAuto.jsp)
		아이디, 패스워드, 자동로그인 check
		쿠키값이 있을 때 로그인 화면 이동 시 바로 메인화면으로 이동 처리
	2) 로그인 처리프로세스(a11_loginProcDb.jsp)	
		로그인해서 아이디/패스워드 DB로 확인해서 맞을 때 
			a. 세션처리
			b. 자동로그인 check시에는 인증 시, id, pass를 쿠키값으로 저장(기간, 경로설정)
			c. 메인화면으로 이동
		인증되지 못했을 때는 다시 로그인 화면 진행
	3) 	메인화면(a12_main.jsp)
		세션값을 출력
		로그아웃 버튼  생성 - 로그아웃 시 로그아웃 처리 proc 처리
	4) 로그아웃 처리 프로세스(a13_logout.jsp)
		세션 삭제
		쿠키값 삭제
		로그인 화면으로 이동

# 로그인 및 세션 쿠키 처리
1. 아이디와 패스워드 입력
	1) useBean으로 DB로 접근해서 id/pass가 있는 경우 
		DB에서 VO를 받아 session설정한다
		로그인 상태가 있는 경우에는 id, pass를 쿠키로 생성
		메인화면으로 이동 처리		
	2) useBean으로 DB로 접근해서 id/pass가 없는 경우 
		다시 로그인 페이지 이동
2. 쿠키값이 있어서 이동한 경우
	1) 쿠키의 id와 pass를 받아 DB에 접근하여 session 설정
		메인화면으로 이동처리

--%>
		

<h2>로그인</h2>
<%--

1.로그인 폼 처리(id, pass, 로그인 상태 유지 check)
2. 로그인 쿠키가 있을 때 자동으로 메인 화면 이동 처리

--%>

<form method="post" action="a11_loginProcDb.jsp">
	아이디:<input type="text" name="id"/><br>
	패스워드:<input type="password" name="pass"/><br>
	<input type="checkbox" name="loginChk" value="true"/>로그인상태유지<br>
	<!-- type="chckbox"인 경우check되었을 때만 value값이 전송된다 
		 usebean에서 뺐으니 param으로 값 넘겨야 함 -->
	<input type="submit" name="로그인"/><br>
</form>



</body>
<script>
	var ckCookie = "${cookie.id.value}" //쿠키값 확인(id라는 쿠키값이 있으면)
	//바로 메인화면으로 이동 처리
	if (ckCookie!=""){
		location.href="a11_loginProcDb.jsp"
	}
</script>

<%-- 

<body>
   <h2>로그인</h2> 
   <form method="post" action="a11_loginProcDB.jsp">
      아이디 : <input type="text" name="id"/><br>
      패스워드 : <input type="password" name="pass"/><br>
      <input type="checkbox" name="loginChk" value="true"/>로그인 상태 유지<br>
      <!-- type="checkbox"인 경우 check가 되어 있을 때만 value값이 전송된다. -->
      <input type="submit" value="로그인"/><br>
   </form>   
</body>
   <script type="text/javascript">
      var ckCookie = "${cookie.id.value}" // 쿠키값 확인(id라는 쿠키값이 있으면)
      // 바로 메인화면으로 이동 처리
      if(ckCookie!=""){
         location.href = "a11_loginProcDB.jsp"
      }
   
   </script>


--%>
</html>