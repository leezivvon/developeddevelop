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
<!--  
	ex) a15_sessionExp.jsp 물건명 가격 개수 구매처를 각 네가지 session범위로 설정하여 출력하고
		session범위 확인 클릭 시 a16_showSession.jsp로 4가지 session범위 확인하세요
		
		//session값만 확인해보는거임
-->
<%
pageContext.setAttribute("pname", "싸이버거(page)");
request.setAttribute("price", 5600);
session.setAttribute("cnt", 3);
application.setAttribute("loc", "맘스터치 영등포점(application)");
%>
<table>
	<tr><th>물건명(page)</th><td><%=pageContext.getAttribute("pname") %></td></tr>
	<tr><th>가격(request)</th><td><%=request.getAttribute("price") %></td></tr>
	<tr><th>개수(session)</th><td><%=session.getAttribute("cnt") %></td></tr>
	<tr><th>구매처(application)</th><td><%=application.getAttribute("loc") %></td></tr>
</table>
<a href ="a16_showSession.jsp">session범위로 확인</a>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>