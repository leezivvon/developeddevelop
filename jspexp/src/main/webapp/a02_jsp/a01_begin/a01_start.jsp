<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp의 주석 --%>
	<%
	// scriptlet
	String name ="홍길동"; // java
	int age = 25;
	String loc="서울";
	%>
	<%-- 표현 처리.  --%>
	<h2>이름:<%=name %></h2>
	<h2>나이:<%=age %></h2>
	<h2>거주지:<%=loc %></h2>
	
	<%-- ex) 물건명 가격 개수를 선언하고 출력하되 table의 th와 td를 활용해여 출력 
			 물건명 @@@
			 가격 @@@
			 개수 @@@	
	--%>
	<%
		String prd ="아이스아메리카노";
		int price =1500;
		int cnt = 7;
	%>
	<h4>예제</h4>
	<table wdith="40%" style="border-collapse:collapse" border>
		<tr><th>물건명</th><td><%=prd %></td></tr>
		<tr><th>가격</th><td><%=price %>원</td></tr>
		<tr><th>개수</th><td><%=cnt %>개</td></tr>
		<tr><th>총합</th><td><%=price*cnt %> 원</td></tr>
	</table>
</body>
</html>