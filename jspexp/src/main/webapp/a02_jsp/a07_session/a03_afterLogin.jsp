<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body>
	<%-- 
		1. 세션생성
	--%>
	<%
	//String name, String auth
	Member m = new Member("이지원", "관리자");
	session.setAttribute("memkey", m); //("키", 등록객체)
	%>
	<h1>세션 생성</h1>
	<h3> 메뉴>> 권한확인이동</h3>

</body>
<script type="text/javascript">
	
	//<h3>메뉴권한확인이동</h3><<여기에 링크거는거임
	var putli = document.querySelector("h3");
	putli.onclick=function(){
		location.href="a04_sessionMenu.jsp"
	}
	
//	document.querySelector("h3").onclick=function(){}

</script>
</html>