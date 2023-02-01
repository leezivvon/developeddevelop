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

<h2>session범위 확인</h2>
<table>
	<tr><th>id</th><td><%=pageContext.getAttribute("id") %></td></tr>
	<tr><th>이름</th><td><%=request.getAttribute("name") %></td></tr>
	<tr><th>포인트</th><td><%=session.getAttribute("point") %></td></tr>
	<tr><th>권한</th><td><%=application.getAttribute("auth") %></td></tr>
</table>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>