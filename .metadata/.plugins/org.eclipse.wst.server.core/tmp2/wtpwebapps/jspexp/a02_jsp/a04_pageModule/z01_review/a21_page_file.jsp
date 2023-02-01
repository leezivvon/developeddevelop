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

<h2>메인화면</h2>

<%--
a22_sub.jsp
// 공통 화면과 공통 변수 선언
String name="홍길동";
int age=25;
String loc="서울 강남";
%>

<h2>공통 화면 내용</h2>
--%>

<%@ include file="a22_sub.jsp"%>
<%-- 
1. 활용예제
	1) 공통적인jsp(java)단 처리할 변수와 함께 처리되는 js,css가 있을 때 이러한 형태로 처리해주어 
		include file로 선언하는 것이 효율적
		ex) 세션처리, 권한 처리, 유효성 처리
--%>





<h2>이름:<%=name %></h2>
<h2>나이:<%=age %></h2>
<h2>사는 곳:<%=loc %></h2>

</body>
<script>
/*

 */
</script>
</html>