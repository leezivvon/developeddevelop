<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.vo.Person"
    import="jspexp.vo.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		table{border-collapse:collapse;}
	</style>
</head>
<body>
<%
	Person p01 = new Person("호일동", 25, "서울"); // 객체 선언
%>
	<table width="50%" border>
		<tr><th>이름</th><td><%=p01.getName() %></td></tr>
		<tr><th>나이</th><td><%=p01.getAge() %></td></tr>
		<tr><th>거주지</th><td><%=p01.getLoc() %></td></tr>
	</table>

<%-- 
	ex) vo하위에 Product 물건명/가격/개수 선언ㅇ
		현재 화면에서 테이블로 출력 처리
--%>	
<%
	Product prd01 = new Product("아이스아메리카노", 1500, 7);
%>		
	<h3>물건 정보</h3>
	<table width="50%" border>
		<tr><th>물건명</th><td><%=prd01.getPname() %></td></tr>
		<tr><th>가격</th><td><%=prd01.getPrice() %></td></tr>
		<tr><th>개수</th><td><%=prd01.getCnt() %></td></tr>
		<tr><th>총합계</th><td><%=prd01.getPrice()*prd01.getCnt() %></td></tr>
	</table>
</body>
</html>