<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
    %>
<% request.setCharacterEncoding("utf-8"); %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body>

<h4>여기가액션태그</h4>
<h4>월드컵 B조별리그 1위 팀명과 승점</h4>
<h4>
<%=request.getParameter("nation") %>
<%=request.getParameter("score") %>
</h4>


</body>
</html>