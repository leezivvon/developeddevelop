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
<!-- 
 ex) form화면에 아이디 패스워드를 입력해서 해당 서버로 이댕해서 해당 요청값이 himan/7777일때는 
 	 메인페이지(a09_main.jsp) 이동, 그렇지않으면 현재(a07_response.jsp)에 있게 처리하세요
-->
	<h3>로그인</h3>
	<form>
		id:   <input type="text" name="id">
		pass: <input type="password" name="pass">
		<input type="submit" value="로그인">
	</form>
	<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	boolean isFail = false; //로그인실패한걸보여주기위해
	if(id!=null&pass!=null){
		// 서버단 로직 처리
		A06_PareparedDao dao = new A06_PareparedDao();
		// 데이터가 있을 때만 이동 그 외에는 이동 되지 않게 처리
		if( dao.login(id,pass) ){
			// 서버단에서 페이지 이동을 결정할 때 response.sendRedirect 사용
			response.sendRedirect("a09_main.jsp");
		}else{
			isFail=true;
			// 현재페이지에서 로그인처리하기 때문에 생략 가능
			// response.sendRedirect("a09_main.jsp");
			
			// response.sendRedirect("a09_main.jsp?ckLog=Y");
			// 요청값을 넘기면 초기페이지가 아니라 로그인 check된 페이지라는 것을 구분해주면 처리할 수 있다
		}
	}
	%>


</body>
<script type="text/javascript">
	var isFail = <%=isFail %>
	if(isFail){
		alert("로그인 실패\n인증된 아이디가 아닙니다")
	}
	
</script>
</html>