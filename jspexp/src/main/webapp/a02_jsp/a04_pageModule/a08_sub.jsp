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
	

<h2>포함될 페이지</h2>

<%
//변수선언
//String prod = "판도라반지";
//int price= 84000;

String prod = request.getParameter("prod"); if(prod=="") prod="";
String price = request.getParameter("price"); if(price=="") price="";
%>
<h3>여기다가 변수선언했음</h3>


		</div>
	
	</body>
</html>