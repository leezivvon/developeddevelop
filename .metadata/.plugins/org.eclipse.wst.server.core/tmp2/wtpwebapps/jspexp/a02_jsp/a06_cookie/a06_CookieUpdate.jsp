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

<%-- 
# 쿠키의 수정
1. 쿠키는 기존의 키를 기준으로 호출한 후 다른 값을 반응객체(response)에 의해 추가하면 변경이 된다


--%>
<%
	Cookie cks[] = request.getCookies();
	for(Cookie c:cks){
		if(c.getName().equals("name")){
			c.setValue("banana");
			response.addCookie(c);
		}
		//if(c.getName().equals("price")){
		//	c.setValue("4000");
		//	response.addCookie(c);
		//}
	}
%>
	<h2>쿠키값 변경 : (name을 banana로)</h2>
	<a href="a05_CookieList.jsp">쿠키값 확인</a>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>