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


	<%-- 여기서는 호출만!! --%>
	<h2>숫자1:${num01}</h2>
	<h2>숫자2:${num02}</h2>
	<h2>합산 :${num01+num02}</h2>
	<h2>이름 :${name}</h2>
	<h2>이름2:${name2}</h2> <%-- 에러도 안남 --%>
	<h2>세션값:${sess01}</h2>

</body>
</html>