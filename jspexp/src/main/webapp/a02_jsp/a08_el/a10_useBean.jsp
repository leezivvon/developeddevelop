<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- c태그 쓸때 무조건 필요 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body>

<%-- 
# useBean을 활용한 객체 생성
1. jsp에서는 action태그의 한 형식으로 useBean을 객체를 생성하여 사용하는데 활용
2. 개체 선언과 생성	
	<jsp:useBean id="참조명" class="패키지.클래스명" scope="세션범위"/>
3. 호출
	1) <jsp:getProperty name="참조명" property="퍼로퍼티명" />	
	   ${참조명.property명}
	2) <jsp:setProperty name="참조명" property="퍼로퍼티명" value="할당할데이터"/>	
	   ${참조명.setXXXX('할당데이터')}

--%>

<%-- 1 --%>
<jsp:useBean id="pl01" class="jspexp.vo.Player"/>
<jsp:setProperty property="tname" name="pl01" value="맨체스터유나이티드"/>
<jsp:setProperty property="pname" name="pl01" value="박지성"/>
<jsp:setProperty property="score" name="pl01" value="30.0"/>
<h3>팀명:<jsp:getProperty property="tname" name="pl01"/></h3>
<h3>이름:<jsp:getProperty property="pname" name="pl01"/></h3>
<h3>성적:<jsp:getProperty property="score" name="pl01"/>골</h3>

<%-- 2 --%>
<jsp:useBean id="pl02" class="jspexp.vo.Player"/>
${pl02.setTname("토트넘")}	${pl02.setPname("손흥민")}	${pl02.setScore(23)}
<h2>팀명:${pl02.tname}</h2>
<h2>이름:${pl02.pname}</h2>
<h2>성적:${pl02.score}</h2>



<%-- 
ex) Code 클래스를 이용하여 useBean을 이용하여 두가지 형식으로 저장하고 출력
--%>
c Code(String key, String val)
<%-- 1 --%>
<jsp:useBean id="cd01" class="jspexp.vo.Code"/>
<jsp:setProperty property="key" name="cd01" value="전북현대"/>
<jsp:setProperty property="val" name="cd01" value="조규성"/>
<h3>
	<jsp:getProperty property="key" name="cd01"/>>>
	<jsp:getProperty property="val" name="cd01"/>
</h3>

<%-- 2 --%>
<jsp:useBean id="cd02" class="jspexp.vo.Code"/>
${cd02.setKey("전북현대")}	${cd02.setVal("백승호")}	
<h2>팀명:${cd02.key}</h2>
<h2>이름:${cd02.val}</h2>


</body>

</html>