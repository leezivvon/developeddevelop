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
</head>
<body>
	<%
		Member m =(Member)session.getAttribute("memkey");
		//js로 넘기는 것 //세션값이 없다면 m=null&hasSess=false --> m!=null -세션값이 있따면&hasSess=true  
		boolean hasSess = m!=null; //
		if(hasSess){
	%>
			<h2>메뉴권한확인이동</h2>
			<h5>session객체내용(출력)</h5>
			<h3>" <%=m.getName() %> "님은 " <%=m.getAuth() %> "에 해당합니다</h3>
	<%	} %>
</body>
<script type="text/javascript">
	var hasSess = <%=hasSess %>; //이게 이해가 안가
	if(!hasSess){
		alert("해당 메뉴 권한이 없습니다\n세션 설정하시겠습니까?")
		location.href="a03_afterLogin.jsp";
	}
	
</script>
</html>