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

	<jsp:useBean id="reqMem" class="jspexp.vo.Member"/> <%--리퀘스트 객체에서 받은 usebean --%>
	<jsp:setProperty property="*" name="reqMem"/>
	<%-- reqMem.setId(), reqMem.setPass() --%>
	
	
	<jsp:useBean id="dao" class="jspexp.a13_database.A06_PareparedDao"/>
	<%-- DB에 데이터가 있는지 여부(id, pass) --%>
	<c:if test="${not empty dao.login(regMem) }">
		<%-- 1. session 설정 --%>
		<c:set var="sesMem" scope="session" value="${dao.login(reqMem) }"/>
		<%-- 2. 자동로그인 상태로 check된 경우 쿠키 생성 --%>
		<c:if test="${param.loginChk }">
		<%
			Cookie ck1 = new Cookie("id", reqMem.getId());
			Cookie ck2 = new Cookie("pass", reqMem.getPass());
			ck1.setMaxAge(60*60*24); ck1.setPath("/jspexp");
			ck2.setMaxAge(60*60*24); ck2.setPath("/jspexp");
			response.addCookie(ck1);
			response.addCookie(ck2);
		%>
		</c:if>
	</c:if>	
	
	
	<%-- 쿠키값이 있는 경우 DB세션 처리 --%>
	<c:if test= ${not empty cookie.id.value }">
		${reqMem.setId(cookie.id.value) }
		${reqMem.setPass(cookie.pass.value) }
		<c:set var="sesMem" scope="session" value="${dao.login(reqMem) }"/>
	</c:if>
	
	<script type="text/javascript">
		var ckSess = "${sesMem.id}"
		var ckCk = "${cookie.id.value}"
		if(ckSess!=''){ //세션값이 설정된 경우
			if(ckCk==''){
				alert("로그인 성공\n메인페이지 이동")
			}else{
				alert("자동로그인\n메인페이지 이동")
			}
		location.href="a12_main.jsp"
		}else{
			alert("로그인실패\n로그인페이지 이동")
		}
	</script>
	
	<%-- 
		# 요청값과 useBean을 통한 데이터 할당
		1.요청값: ?id=himan&pass=7777
			<form>
				<input name="id" value="himan"
				<input name="pass" value="7777"
				<input type="submit" 누르면 위에처럼 쿼리스트링으로 넘겨짐
				(=)
		
		2.useBean클래스 선언으로 통한 요청값 받기
			1) 위 query string에서 id=himan인 경우
			2) 클래스에 void setId(String id){}와 같이
					  setPass(String pass){}
				id 요청 키에 해당하는 property(setId ==>id) 동일한 메서드가 선언되어 있으면
			3) <jsp:setProperty property="*" name="reqMem"/>로 인해서 자동 할당 처리가 된다
				reqMem.setId("himan") 내부 코드로	
				reqMem.setPass("7777") 내부 코드로	
				
		# 로그인 및 세션 쿠키 처리
		1. 아이디와 패스워드 입력
			1) useBean으로 DB로 접근해서 id/pass가 있는 경우 
				DB에서 VO를 받아 session설정한다
				자동 로그인이 check 되어있는 경우에는 id, pass를 쿠키로 생성
				메인화면으로 이동 처리		
			2) useBean으로 DB로 접근해서 id/pass가 없는 경우 
				다시 로그인 페이지 이동
		2. 쿠키값이 있어서 이동한 경우
			1) 쿠키의 id와 pass를 받아 DB에 접근하여 session 설정
				메인화면으로 이동처리		
	--%>
	
<body>
	<%--
	받은 id : ${reqMem.id },
	받은 pass: ${reqMem.pass },
	<%-- reqMem.getId(), reqMem.getPass() --.%>
	check처리 : ${param.loginChk },
	상태유지여부: ${not empty param.loginChk?'로그인상태유지':'로그인상태유지 안됨' }
	--%>

</body>
</html>

<%-- 
// 복붙
<jsp:useBean id="reqMem" class="jspexp.vo.Member"/>
<jsp:setProperty property="*" name="reqMem"/>
<jsp:useBean id="dao" class="jspexp.a13_database.A06_PreparedDao"/>
<%-- DB에 데이터가 있는지 여부(id,pass) --.%>
<c:if test="${not empty dao.login(reqMem)}">
   <%-- 1. session 설정 -.-%>
   <c:set var="sesMem" scope="session" value="${dao.login(reqMem)}"/>
   <%-- 2. 로그인 상태로 check된 경우 쿠키 생성 --.%>
   <c:if test="${param.loginChk}">
      <%
         Cookie ck1 = new Cookie("id", reqMem.getId());      
         Cookie ck2 = new Cookie("pass", reqMem.getPass());
         ck1.setMaxAge(60*60*24); ck1.setPath("/");
         ck2.setMaxAge(60*60*24); ck2.setPath("/");
         response.addCookie(ck1);
         response.addCookie(ck2);
      %>
   </c:if>
</c:if>
<%-- 쿠키값이 있는 경우 DB 세션 처리 --.%>
<c:if test = "${not empty cookie.id.value }">
   ${reqMem.setId(cookie.id.value)} ${reqMem.setPass(cookie.pass.value)}
   <c:set var="sesMem" scope="session" value="${dao.login(reqMem)}"/>
</c:if>
<script type="text/javascript">
   var ckSess = "${sesMem.id}"
   var ckCk = "${cookie.id.value}"
   if(ckSess!=''){ // 세션값이 설정된 경우
      if( ckCk == ''){
         alert("로그인 성공\n메인페이지 이동")
      }else{
         alert("자동 로그인\n메인페이지 이동")
      }
      location.href="a12_main.jsp"
   }else{
      alert("로그인 실패\n로그인페이지 이동")
   }
</script>

--%>