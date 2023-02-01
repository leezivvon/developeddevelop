<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"	%>
<fmt:requestEncoding value="utf-8"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body>

<%-- 
# jstl
1. jsp standard tag library로 널리 사용되는 커스텀 태그를 표준으로 만든 태그
2. jstl의 태그 종류
	1) 코어 : 변수 지원, 흐름 제어, url처리
		c:http://java.sum.com/jsp/jstl/core
	2) fmt : 국제화 지역 메시지 형식, 숫자 및 날짜 형식
		http://java.sun.com/jsp/jstl/fmt
	3) xml : xml코어, 흐름제어, xml변환
	4) fn  : 함수, 콜렉션, string 제어
	5) sql : 데이터베이스 sql
3. 환경설정
	jsl관련lib설정 web-inf lib 밑에
	상단 taglib
	<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"			
	<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"			
4. 기본형식
	<c:set var="변수명" value="데이터" scope="세션범위"/>
	${변수명}	
--%>


<c:set var="name" value="홍길동"/>
<c:set var="price" value="3000"/>
<c:set var="cnt" value="20"/>
<h2>이름:${name}</h2>
<h2>총계:${price*cnt}</h2>
<%--
# jstl에서 본격적으로 session범위와 함께 데이터를 저장 활용할 수 있다  
	1. page/request/session/application
--%>
<c:set var="buy" value="사과" scope="session"/>
<h3>세션범위:${buy}</h3>

<%-- 
ex) jstl set을 활용하여 session 4가지 범위로 데이터를 설정 및 출력
	구매물건, 구매장소, 구매자, 재고량
--%>
<c:set var="prod" value="양배추" scope="page"/>
<c:set var="loc" value="이마트" scope="request"/>

<c:set var="customer" value="이지은" scope="session"/>
<c:set var="stock" value="90" scope="application"/>
<h2>페이지범위확인</h2>
<h3>구매물건:${prod }</h3>
<h3>구매장소:${loc }</h3>
<h3>구매자:${customer }</h3>
<h3>재고량:${stock }</h3>
<a href="a07_req.jsp">요청범위 확인</a>
<a href="a08_session.jsp">세션범위 확인</a>


</body>
</html>