<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"  
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
*/
</script>

</head>
<body>
<% 
// 물건명 가격 개수를 문자열/숫자 변수로 저장했다가 호출하세요
pageContext.setAttribute("name", "홍길동");
pageContext.setAttribute("age", 25);
pageContext.setAttribute("loc", "서울 방배동");

%>
	<h2>이름:<%=pageContext.getAttribute("name") %></h2>
	<h2>나이(+5년후):<%=( (Integer)pageContext.getAttribute("age")+5 )%></h2>
	<%-- 기본적으로 형변환이 없으면 문자열로 출력은 되나 원하는 데이터 연산을 위해서는 형변환이 반드시 필요하다 --%>
	<h2>주소:<%=pageContext.getAttribute("loc") %></h2>
	
	
	
<%-- ex) Product객체로 물건명, 가격 개수를 pageContext로 설정한 후 호출하세요  --%>	
<%
pageContext.setAttribute("pname", "방어회");
pageContext.setAttribute("price", 32000);
pageContext.setAttribute("cnt", 2);


// 정답
pageContext.setAttribute("prod", new Product ("사과",3000,2));
%>
<%
//할당된 내용을 사용하려면 typecasting필요
Product prod = (Product)pageContext.getAttribute("prod");
%>
<h2>물건명: <%=prod.getPname() %></h2>
<h2>가격: <%=prod.getPrice() %></h2>
<h2>개수: <%=prod.getCnt() %></h2>


	<h2>물건명:<%=pageContext.getAttribute("pname") %></h2>
	<h2>물건명:<%=pageContext.getAttribute("price") %></h2>
	<h2>물건명:<%=pageContext.getAttribute("cnt") %></h2>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>