<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">

</head>
<body>
	<h2>쿠키 담기</h2>
	<form>
		물건명 : <input type="text" name="name">
		가격 : <input type="text" name="price">
		개수 : <input type="text" name="cnt">
		<input type="submit" value="장바구니담기">
	</form>
<%
	//쿠키만들기 //쿠키를 클라이언트에 보내기
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String cnt = request.getParameter("cnt");
	
	if(name!=null){
		Cookie c1 = new Cookie("name", name);
		response.addCookie(c1);
		Cookie c2 = new Cookie("price", price);
		response.addCookie(c2);
		Cookie c3 = new Cookie("cnt", cnt);
		response.addCookie(c3);
	}
%>
	<h2 onclick="location.href='a04_showCookie.jsp'">장바구니에 담은 물건 확인하기</h2>
	

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>