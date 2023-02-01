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

<table>
	<tr><th>페이지 범위 데이터</th><td><%=pageContext.getAttribute("page01") %></td></tr> 
	<tr><th>요청 범위 데이터</th><td><%=request.getAttribute("request02") %></td></tr>
	<tr><th>세션 범위 데이터</th><td><%=session.getAttribute("session03") %></td></tr> <!-- 페이지가이동돼도살아있음(서버와의 관계속에서 유지됨) / 브라우저 닫고 다시 하면 사라짐/ 다른 브라우저에서는 사라짐-->
	<tr><th>어플리케이션 범위 데이터</th><td><%=application.getAttribute("application04") %></td></tr> <!-- 브라우저 닫고 다시 해도 살아있음(클라이언트와 상관없이 서버에서.) 서버를 restart하면 사라짐-->
</table>


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>