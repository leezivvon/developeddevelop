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
#


--%>
<%
	Person p = (Person)session.getAttribute("p01");
	boolean hasSess= p!=null;
	if(hasSess){
%>
	 <h2>세션값확인</h2>
	 <h3>이름:<%=p.getName() %></h3>
	 <h3>나이:<%=p.getAge() %></h3>
	 <h3>주소:<%=p.getLoc() %></h3>
<%	} %>


</body>
<script type="text/javascript">
	var hasSess=<%=hasSess %>;
	if(!hasSess){
		alert("세션값이 없습니다. 설정하러 가시겠습니까?")
		location.href="a01_session.jsp";
	}
	
/*
 ex) a03_afterLogin.jsp		Member클래스로 session설정
 		메뉴권한확인이동 a04_sessionMenu.jsp
 	 a04_sessionMenu.jsp
 	 	session객체내용 출력
 	 	session없을 때 a03_afterLogin.jsp이동처리
*/
</script>
</html>