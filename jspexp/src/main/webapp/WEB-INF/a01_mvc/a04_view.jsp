<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script>
/*
 ex) A04_MVC.java로 모델 데이터를 emp객체로 
 	 사원번호, 사원명, 급여를 설정하여 a04_view.jsp에서 호출하여 출력
 */
</script>
</head>
<body>

	<h2>사원정보(view단)</h2>
	<h3>부서번호:${emp.deptno}</h3>
	<h3>사원명:${emp.ename}</h3>
	<h3>급여:${emp.sal}</h3>

</body>
<script>
/*

 */
</script>
</html>