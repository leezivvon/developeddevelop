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
	<h4 align="center">로그인 결과</h4>
	<h4 align="center">등록아이디_${param.id}</h4>
	<h4 align="center">등록패스워드_${param.pw}</h4>
	<h4 align="center">${param.id=='himan' and param.pw=='7777'
						 ?'로그인성공':'로그인실패' }</h4>  <!-- 삼항연산자 -->
						 
	<%-- jsp주석 //화면에 안나타남 --%>
	<%-- 
	${조건문?true일때:false일때}
	1. el(jsp에서 사용하는 언어)
		'' : 문자열 처리
	2. 산술연산을 효율적으로 처리한다
		1) 숫자형문자는 숫자로 자동 변환해서 처리해준다
		2)  ?price=3000&cnt=5
			==> 네트워크상 전송되는 모든 데이터는 문자열이지만 el은 연산시 자동으로 숫자형으로 변환해준다
			${param.price*param.cnt}	
		
	--%>
						 
</body>
</html>