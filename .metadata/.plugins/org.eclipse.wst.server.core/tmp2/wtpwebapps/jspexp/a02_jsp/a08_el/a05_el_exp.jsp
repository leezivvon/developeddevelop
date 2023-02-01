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
ex) 점수 :[   ] [합격여부]
	클릭 시, 70점 이상 합격/ 그 외 불합격 출력 처리 하세요
	입력값여부: @@
	70점이상여부: @@
	구분:합격/불합격 - 3항연산 활용
--%>
	<form>
		점수: <input type="text" name="score"/> 
		<input type="submit" value="합격여부"/>
	</form>
	<h3>결과</h3>
	<h4>입력값 여부: ${not empty param.score }</h4>
	<h4>70점 이상 여부: ${param.score>=70 }</h4>
	<h4 style="color:red">최종결과: ${param.score>=65?"합격":"불합격" }</h4>

</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>