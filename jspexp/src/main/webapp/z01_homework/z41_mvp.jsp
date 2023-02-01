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


<h2>MVP 페이지</h2>
<h2>총비용 100000이상</h2><br>
<h3><%=request.getParameter("prod01") %> </h3>
<h3><%=request.getParameter("price01") %>원 <%=request.getParameter("cnt01") %>개 구매</h3>
<h3><%= %></h3>


<%-- 3-2단계 정답 --%>
<h2><%=request.getParameter("namee")%>구매MVP페이지</h2>	
<h3><%=request.getAttribute("tott")%>원 구매</h3>	


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>