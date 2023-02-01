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
	<tr><th>물건명(page)</th><td><%=pageContext.getAttribute("pname") %></td></tr>	<!-- 날라감 -->
	<tr><th>가격(request)</th><td><%=request.getAttribute("price") %></td></tr>		<!-- 날라감 -->
	<tr><th>개수(session)</th><td><%=session.getAttribute("cnt") %></td></tr>			<!-- 브라우저닫으면 날라감 -->
	<tr><th>구매처(application)</th><td><%=application.getAttribute("loc") %></td></tr>	<!--  -->
</table>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>