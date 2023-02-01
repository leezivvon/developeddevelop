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
</head>
<body>

<h4>재고여부</h4>
<%
String pname = request.getParameter("pname"); 

if(pname != null){
	if(pname.equals("치킨")){ %>
		<jsp:forward page="a53_main.jsp"/>
<% 	}else{ %>
		<jsp:forward page="a54_main.jsp"/>
<%	} %>
<% 	
}
%>

<%-- 2번정답 --%>
<h2>분기어쩌고 저쩌고</h2>
<%
String pnamee = request.getParameter("pnamee");
if(pnamee!=null){
	String page01="";
	if(pnamee.equals("사과")){
		request.setAttribute("msg","재고있음");
		page01="a53_main.jsp";
	}else{
		request.setAttribute("msg", "재고없음");
		page01="a54_main.jsp";			
	}
	RequestDispatcher rd = request.getRequestDispatcher(page01);
	rd.forward(request, response);
}
%>


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>