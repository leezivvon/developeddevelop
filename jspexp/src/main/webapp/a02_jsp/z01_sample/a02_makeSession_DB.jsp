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
</head>

<%-- Bean으로 DB를 로딩하고 요청값을 받은 VO 객체 처리 --%>
<jsp:useBean id="dao" class="jspexp.a13_database.A06_PareparedDao"/>
<%-- id,pass 값을 받는 객체 --%>
<jsp:useBean id="reMem" class="jspexp.vo.Member"/>
<jsp:setProperty property="*" name="reMem"/>

<body>
<%-- 
이게 뭔지는 모르겠지만 이걸 다 작성해놓고 삭제했어

	<c:choose>
		<c:when test="${not empty dao.login(reMem)}">
			<c:set var="mem" scope="session" value="${dao.login(mem) }"/>
			<c:set var="isFail" value="N"/>
		</c:when>
		<c:otherwise>
			<c:set var="isFail" value="Y"/>
		</c:otherwise>
	</c:choose>
--%>
	
	<%-- dao를 통해서 객체가 있을 때만 session객체 선언 --%>
	<c:if test="${not empty dao.login(reMem)}">
		<c:set var="mem" scope="session" value="${dao.login(reMem) }"/>
	<%--  
	1. el : 객체를 생성된 내용을 선언한 참조값인 reMem을 활용(${reMem}),
			비교연산처리 (${not empty dao.login(reMem)})
	2. jstl : 객체 생성
			<c:set var="변수명" scope="session" value="${dao의 기능메서드}"	/>	
	--%>
	
	</c:if>
	
	
</body>
<script>
	var isFail='${mem.id}' 
		if(isFail==''){
		    alert("로그인 실패\n로그인 페이지 이동")
		    location.href="a01_login_DB.jsp"
		}else {
		    alert("로그인 성공\n메인 페이지 이동")
		    location.href="a03_checkSession.jsp"
		}
</script>
</html>