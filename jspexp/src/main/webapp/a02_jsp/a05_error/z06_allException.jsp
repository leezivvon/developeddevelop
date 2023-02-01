<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
    
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body style="background-image:url('img06.jpg');color:white;">

	<%-- 클래스 관련 전체 예외 처리 페이지 --%>
	
	<h2 align="center">에러가 발생했습니다(모든 예외처리)</h2>
	<%if(exception!=null){ //반드시해야함 %>
	<table align="center">
		<tr><td>에러타입:<%=exception.getClass().getName() %></td></tr>
		<tr><td>에러타입:<%=exception.getMessage() %></td></tr>
		<tr><td>불편을 끼쳐 드려 죄송합니다</td></tr>
		<tr><td>잠시만 기다리시면 조속히 처리하도록 하겠습니다</td></tr>
		<tr><td>담당자:이지원(010-000-0000)</td></tr>
	</table>
	<%}else{ %>
		<h2 align="center">아직 예외없음/테스트용</h2>
	<%} %>
	

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>