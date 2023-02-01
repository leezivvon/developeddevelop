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
	ex) a03_includeExp.jsp 에 include액션태그로 a04_subPage.jsp를 만들고 출력하게 하세요
		전달데이터 - 회원명 회원권한
	--%>
	<%
	// 전달 데이터 - 회원명 회원권한
	%>
	<h2>포함화면-include액션태그로 출력</h2>
	<div style = "border:1px solid purple">
		<jsp:include page ="a04_subPage.jsp">
			<jsp:param value="이지은" name="mname"></jsp:param>
			<jsp:param value="관리자" name="auth"></jsp:param>
		</jsp:include>
	</div>


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>