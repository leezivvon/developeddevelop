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
</head>
<body>

	<h2>로그인</h2>
	<form method="post" action="a02_makeSession.jsp">
	    아이디:<input type="text" name="id"/>
	    비밀번호:<input type="password" name="pass"/>
	    <input type="submit" value="로그인"/>
	</form>

</body>
<script>
/*

 */
</script>
</html>