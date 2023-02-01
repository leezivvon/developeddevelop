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
	
<%--
	 ex) a07_main.jsp를 메인페이지로 선언하고 a08_sub.jsp 사용할 변수를 선언
		 요청값으로 물건명, 가격을 선언 include지시자를 통해서 포함되어 출력되게 하세요

	
		<h2><인클라우드 예제></h2>
		<div style="border:1px solid purple;">
			<%@ include file = "a08_sub.jsp" %>
		</div>
		<h2>선언된 변수 호출</h2>
		<%=prod %>
		<%=price %>
--%>		
		
		<form>
			물건명:<input type="text" name = "prod"/>
			가격:<input type="text" name = "price"/>
			<input type="submit" value="구매">
		</form>
		<div style="border:1px solid purple;">
			<%@ include file = "a08_sub.jsp" %>
			<h2><%=prod %></h2>
			<h2><%=price %></h2>
		
		
		</div>
	
	</body>
</html>