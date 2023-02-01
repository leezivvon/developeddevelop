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

<%
String id = request.getParameter("id");
if(id!=null){
	A06_PareparedDao dao = new A06_PareparedDao();
	request.setAttribute("hasId", dao.checkId(id)?"Y":"N");
%>
	<jsp:forward page="221202.jsp"/>
<%	
}
%>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>