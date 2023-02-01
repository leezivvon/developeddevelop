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
<%-- 
	ex) a18_forwardTest.jsp?id=himan 처리하며
		요청값(request.getParameter("id"))이 himan일 때는 로그인 성공페이지 a19_main.jsp로 전송
		그 외는 a20_error.jsp로 로그인 실패 페이지로 이동하여 출력되게 하세요	
--%>

	<form>
		아이디: <input type="text" name="id"/>
		<input type="submit" value="로그인"/>
	</form>
	<%
	String id = request.getParameter("id");
	if(id!=null){
		String pagee = "a20_error.jsp";
		if(id.equals("himan")){
			pagee = "a19_main.jsp";
		}
	%>	
		<jsp:forward page="<%=pagee %>"/>
	<%
	}
	%>

</body>
<script type="text/javascript">
/*

var wrId = request.getParameter("id");
if( wrId=="himan" ){
	<.%	request.setAttribute("id","himan"); %>
	<jsp:forward page="a19_main.jsp"/>
}else{
	<.%	request.setAttribute("id","himan"); %>
	<jsp:forward page="a20_error.jsp"/>
}
*/
</script>
</html>