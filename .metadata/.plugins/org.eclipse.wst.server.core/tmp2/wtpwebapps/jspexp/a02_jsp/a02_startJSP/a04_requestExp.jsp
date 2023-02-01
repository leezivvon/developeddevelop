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
	ex) a04_requestExp.jsp?pname01=사과&pname02=오렌지&pname03=수박
		을 처리하여 request.getParameterNames()로 가져와서 테이블로 출력되게 하세요
	--%>
	<form>
		과일1 : <input type="text" name="pname01" value="사과">
		과일2 : <input type="text" name="pname02" value="오렌지">
		과일3 : <input type="text" name="pname03" value="수박">
		<input type="submit" value="등록">
	</form>
	<table>
		<tr><th>항목</th><th>내용</th></tr>
	<% 
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()){
		String key = (String)e.nextElement(); 	// 요청키를 가지고 온다
	%>
		<tr><td><%=key %></td><td><%=request.getParameter(key) %></td></tr>	
	<% } %>
	</table>
	


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>