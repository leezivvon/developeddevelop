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

		<%-- # 뷰단 코드 --%>
		<form action="/gugu.do"> //action은 현재 view를 호출한 controller를 호출할 때는 생략 가능
			호출한 controller를 호출할 때는 생략가능
			<input type="text" name="num01"/> X
			<input type="text" name="num02"/> ? <br>
			<input type="submit" value="계산"/>
		</form>
		<h2>${result}</h2>	
		
		<form action="/gugu.do">
			<select name="num01">
				<c:forEach var="grade" begin="2" end="9">
					<option>${grade}</option> 
					<%-- 
					보이는 label과 value값이 동일할 때는 label만 설정하더라도 value값이 설정된다 
					 <option value="${grade}">${grade}</option>가 필요없다
					보이는 label과 value값이 다를 때는 value로 설정된 값이 전달된다
					--%>
				</c:forEach>
			</select>X
			<select name="num02">
				<c:forEach var="cnt" begin="1" end="9">
					<option>${cnt}</option>
				</c:forEach>
			</select> = ? <br>
		<input type="submit" value="계산"/>
		</form>
		
		<h2>${result }</h2>
	</body>
<script>
/*

 */
</script>
</html>