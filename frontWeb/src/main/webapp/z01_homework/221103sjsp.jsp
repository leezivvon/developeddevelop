<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3 -->
	<table>
		<tr><th>도서명</th><td>${param.btitle }</td></tr>
		<tr><th>출판사</th><td>${param.publisher }</td></tr>
		<tr><th>가격</th><td>${param.bprice }</td></tr>
	</table><br>
	
	
	<!-- 5 -->
	<h4 align="center">과일가게</h4>
	<h4 align="center">제품명 :${param.fname }</h4>
	<h4 align="center">가격 :${param.fprice }</h4><br>
	
	<h4 align="center">옷가게</h4>
	<h4 align="center">품명 :${param.clname }</h4>
	<h4 align="center">가격 :${param.clprice }</h4><br>

	<h4 align="center">컴퓨터가게</h4>
	<h4 align="center">기기명 :${param.comname }</h4>
	<h4 align="center">가격 :${param.comprice }</h4><br>
	
	<!-- 8.9 -->
	<table id=stop01>
		<col width="30%">
		<col width="70%">
		<caption>회원등록</caption>
		<tbody>
			<tr><th>아이디</th><td>${param.id }</td></tr>
			<tr><th>패스워드</th><td>${param.pw}</td></tr>
			<tr><th>이름</th><td>${param.yname }</td></tr>
			<tr><th>주소</th><td>${param.address}</td></tr>
			<tr><th>메일주소</th><td>${param.e-adrs}</td></tr>
			<tr><th>성별</th><td>${param.sex}</td></tr>
			<tr><th>자기소개서</th><td>${param.intro}</td></tr>				
		</tbody>
		</table><br>
	
</body>
</html>