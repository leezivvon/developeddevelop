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
String idright=request.getParameter("idright");
//boolean
if(idright!=null){
	if(idright.equals("y")){
		//String id, String name, String pass
		Member m = new Member("dlwlrma", "이지은", "dlwlrma93");
		session.setAttribute("mkey", m);
	}
	if(idright.equals("n")){
		session.invalidate();
	}
	response.sendRedirect("221209.jsp");
}
%>

</body>
</html>