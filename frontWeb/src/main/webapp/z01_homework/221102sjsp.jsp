<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원등록 정보</h2>
	<table border="1" align="center" width="100%">
	<col width=15%>
		<thead>
			<tr><th>아이디</th><th>패스워드</th><th>회원명</th><th>포인트</th><th>권한</th></tr>
		</thead>
		<tbody>
			<tr><td>${param.id}</td><td>${param.pass}</td><td>${param.name}</td>
				<td>${param.point}</td><td>${param.auth}</td></tr>
		</tbody>
	</table>
</body>
</html>