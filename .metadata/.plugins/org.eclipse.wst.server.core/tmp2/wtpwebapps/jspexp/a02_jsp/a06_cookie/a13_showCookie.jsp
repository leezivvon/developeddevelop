<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"      
    
    import="java.net.URLDecoder" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body>

<h2 align="center">쿠키값확인(장바구니담긴물건)</h2>
<%
	Cookie []cookies =request.getCookies();
%>

<table>
	<tr><th>키</th><th>값</th></tr>
	<% for(Cookie ck:cookies){
		if(!ck.getName().equals("JSESSIONID")){
	%>
	<tr><td><%=URLDecoder.decode(ck.getName(), "utf-8" ) %></td>
		
		
		<td><%=URLDecoder.decode(ck.getValue(),"utf-8") %></td></tr>
	<%	}
	  }	%>
</table>



</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>