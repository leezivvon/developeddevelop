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
<script type="text/javascript">
/*
 
*/
</script>

</head>
<body>


<h2><%=request.getParameter("pname") %> 검색결과</h2>
<h3><%=request.getParameter("pname") %> 재고 있습니다</h3>


<%-- 2번정답 --%>
<h2><%=request.getAttribute("msg") %></h2>
<h3><%=request.getParameter("pnamee") %> 재고 있습니다</h3>
 <!-- request객체니까 getParameter값도 받겠지 -->

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>