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

<h3><%=request.getParameter("pname") %> 검색결과</h3>
<h2><%=request.getParameter("pname") %> 재고 없습니다</h2>


<%-- 2번정답 --%>
<h2> <%=request.getAttribute("msg") %></h2>



</body>
</html>