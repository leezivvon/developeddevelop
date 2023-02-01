<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    
    import="java.net.URLEncoder"  
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
# 쿠키만들기(한글처리)
1. 설정
	import = "java.net.URLEncoder" //상단에 
	URLEncoder.encoder("쿠키의 key/value값", "utf-8")
	ex) new Cookie(URLEncoder.encode("홍길동", "utf-8"))
2. 쿠키값 가져오기
	import = "java.net.URLDecoder"
	URLDecoder.decode("저장된 쿠키 key/value", "utf-8")
	ex) for(Cookie ck : request.getCookies(){
			URLDecoder.decode(ck.getName(),"utf-8");
			URLDecoder.decode(ck.getValue(),"utf-8");
		})
--%>

<%
	// 1. 쿠키만들기 Cookie(쿠키의 이름, 쿠키값)
	String key = URLEncoder.encode("이름", "UTF-8");
	String val = URLEncoder.encode("홍길동", "UTF-8");
	Cookie c1 = new Cookie(key, val);  
	// 2. 쿠키 클라이언트에 보내기
	response.addCookie(c1);
%>
	<h2>쿠키 생성완료</h2>
	<a href="a13_showCookie.jsp">만든 쿠키 확인하러 가기</a>
	


</body>
</html>