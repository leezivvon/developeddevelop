<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"    
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
<%-- 
a06_applicationSet.jsp
	판매물품명 : @@@ (page 범위)
	장바구니담기: @@@ (application 범위)
	장바구니 확인 ==>클릭

a07_show.jsp
	판매물품명 : @@@
	장바구니리스트: @@@
	출력 확인하세요
--%>
<%-- 범위별로 session sope로 데이터 설정 --%>

<%
// a06_applicationSet.jsp
pageContext.setAttribute("prod01", "방어회(page)");
application.setAttribute("prod02", "연어회(application//장바구니)");
%>
<h2>판매물품명: <%=pageContext.getAttribute("prod01") %></h2>
<h2>장바구니 담기: <%=application.getAttribute("prod02") %></h2>
<a href="a07_show.jsp">장바구니 확인</a>



<%
// a07_show.jsp
pageContext.setAttribute("pname", "방어회(page)");
application.setAttribute("cart", "방어회(application//장바구니)");
%>


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>