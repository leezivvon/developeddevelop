<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"  
    isErrorPage = "true"     
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">

</head>
<body>
		<br><br>
		<h1 align="center">NullPointerException</h1>
		<h2 align="center">데이터가 없습니다</h2><br>
		<h3 align="center"><%=exception.getClass().getName() %></h3>
		<h3 align="center"><%=exception.getMessage() %></h3>


</body>
</html>