<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
	<h2 align="center">구매한 물건 정보</h2>
	<table border="1" align="center" width="30%">
		<col width="50%">
		<thead>
			<tr><th>물건명</th><th>구매개수</th></tr>
		</thead>
		<tbody>
			<tr><td>${param.pname}</td><td>${param.pcnt}</td></tr>
		</tbody>
	</table>
	
</body>
</html>