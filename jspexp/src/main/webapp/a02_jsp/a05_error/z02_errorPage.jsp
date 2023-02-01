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
<style type="text/css">
	h2{color:red;}
</style>
</head>
<body style="background-image:url('img02.jpg')">


	<%if(exception!=null){ %>
	
		<h2>에러 페이지입니다</h2>
		<h2><%=exception.getClass().getName() %></h2>
		<h2><%=exception.getMessage() %></h2>
		<h1>지송</h1>
		
	<%}else{ %>
		<h2>테스트용(에러처리화면)</h2>
	<%} %>


</body>
</html>