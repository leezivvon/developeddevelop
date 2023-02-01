<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script>
/*
 
 */
</script>
</head>
<body>

	<%
	//특정한 session삭제
	session.removeAttribute("sesMem");
	//session.invalidate() : 모든 세션값 삭제
	//쿠키 삭제1
	/*
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for()
	}*/
	
	//쿠키 삭제2
	Cookie c1 = new Cookie("id", "");
	Cookie c2 = new Cookie("pass", "");
	c1.setMaxAge(0);
	c2.setMaxAge(0);
	c1.setPath("/jspexp");
	c2.setPath("/jspexp");
	response.addCookie(c1);
	response.addCookie(c2);
	
	%>
</body>
<script>
	alert("로그 아웃")
	location.href="a10_loginAuto.jsp";
</script>
</html>