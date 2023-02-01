<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"
    
    
    errorPage="z02_errorPage.jsp"     
    %>
    
    <%
    //에러페이지지정하는 방법
    
    
	request.setCharacterEncoding("utf-8");

    String []arr = {"홍길동"}; // 예외발생
	arr[1].toString();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body >


</body>
</html>