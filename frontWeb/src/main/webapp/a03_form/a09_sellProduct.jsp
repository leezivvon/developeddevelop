<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// post인코딩할때
	request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>구매 처리</h3>
	<form method="post">
		물건명<input type="text" name="pname"/>
		가격<input type="text" name="price"/>
		구매개수<input type="text" name="pcnt"/><br>
		<input type="submit" value="구매"/>
	</form>
	<br>
	<hr>
	<br>
	<h3>구매내역</h3>
	물건명: ${param.pname }<br>
	가격: ${param.price}<br>
	개수 : ${param.pcnt }<br>
	총계:${param.price*param.pcnt}<br>
	
</body>
</html>