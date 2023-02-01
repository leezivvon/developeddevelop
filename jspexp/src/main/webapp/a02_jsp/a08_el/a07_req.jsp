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
</head>
<body>

	<c:set var="prod" value="양배추" scope="page"/>
	<c:set var="loc1" value="이마트" scope="request"/>
	<%-- forward처리할 때는 다른 변수로 설정이 필요하다--%>
	<c:set var="customer" value="이지은" scope="session"/>
	<c:set var="stock" value="90" scope="application"/>
	
	<jsp:forward page="a08_session.jsp"></jsp:forward>
	<!-- 이쪽에서 세팅 -->

</body>
</html>