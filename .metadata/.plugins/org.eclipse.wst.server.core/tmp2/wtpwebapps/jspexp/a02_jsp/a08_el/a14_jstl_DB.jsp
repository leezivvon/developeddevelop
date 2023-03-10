<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"	%>
<fmt:requestEncoding value="utf-8"/>


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
# DB 호출 및 jstl반복문을 통한 데이터 로딩 처리
1. useBean 활용
2. 요청할 데이터 vo객체 선언
3. forEach구문을 통한 객체형 ArrayList출력 처리
--%>
<%-- 
초기화면은 요청값이 없기 때문에 
form내용==>submit
==> ?ename=&job=&frSal=&toSal= 
==> useBean jsp:setProperty property="*"
==> sch.setEname(null);sch.setJob(null); >>null로 호출
    sch.setFrSal(null);sch.setToSal(null); >>호출안됨
    숫자형을 0으로 default값이 저장되어 있음
    
위 내용을 dao.getEmpSch(sch)에 넘겨줄 sch를 객체 default값을 설정해준다
	<c:if test="${empty param.ename}">${sch.setEname("")}</    
	<c:if test="${empty param.job}">${sch.setJob("")}</    
	<c:if test="${empty param.toSal}">${sch.setToSal(99999)}</
	//frSal은 default값이 0이라서 굳이 설정할 필요X    
   
--%>
<jsp:useBean id="dao" class="jspexp.a13_database.A02_EmpDao"/>
<%--
	?ename=himan&job=사원&frSal=&toSal=5000 
	Emp클래스 안에서 요청키와 property가 동일하면 데이터가 할당이 된다
		void setEname(String s)
		void setFrSal(int sal)
--%>
<jsp:useBean id="sch" class="jspexp.vo.Emp"/>
<jsp:setProperty property="*" name="sch"/>
<%-- 초기화면에 요청값이 없을 때 초기 데이터 설정을 위한 내용 --%>
<c:if test="${empty param.ename }">${sch.setEname("")}</c:if>
<c:if test="${empty param.job }">${sch.setJob("")}</c:if>
<c:if test="${empty param.toSal }">${sch.setToSal(9999)}</c:if>
	 
<h2>사원정보</h2>
<form method="post">
	사원명:<input type="text" name="ename" value="${sch.ename}"/>
	직책명:<input type="text" name="job" value="${sch.job}"/>
	급여(시작):<input type="text" name="frSal" value="${sch.frSal}"/>
	급여(끝):<input type="text" name="toSal" value="${sch.toSal}"/>
	<input type="submit" value="검색"/>
</form>
<table>
	<tr><th>사원번호</th><th>사원명</th><th>직책</th><th>급여</th></tr>
	<c:forEach var="emp" items="${dao.getEmpSch(sch) }">
		<tr><td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job}</td><td>${emp.sal }</td></tr>
	</c:forEach>
</table>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>