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
# el을 통한 요청값 처리
1. ${param.요청키}
   ${paramValues[0].요청키} : 다중 요청 처리
--%>
	<form>
		이름<input type="text" name="name"/><br>
		물건가격<input type="text" name="price"/><br> <!-- 자동으로 형변환이됨 -->
		물건개수<input type="text" name="cnt"/><br>
		사는곳
		<input type="checkbox" name="loc" value="수도권"/>수도권
		<input type="checkbox" name="loc" value="기타내륙"/>기타내륙
		<input type="checkbox" name="loc" value="제주도"/>제주도
		<input type="submit" value="등록"/>
	</form>
	
	<h2>요청값 처리</h2>
	<h3>이름 :${param.name}</h3>
	<h3>이름-입력여부(없을 때) :${empty param.name}</h3>
	<h3>이름-입력여부(있을 때) :${not empty param.name}</h3>
	<h3>총계 : ${param.price*param.cnt}</h3>
	<h3>총계-비교연산자(3000이상?) : ${param.price*param.cnt>=3000 }</h3>
	<h3>사는 곳1 :${paramValues.loc[0] }</h3>
	<h3>사는 곳2 :${paramValues.loc[1] }</h3>
	<h3>사는 곳3 :${paramValues.loc[2] }</h3>
<%
	
%>
	
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>