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
 221117 과제 3번 단독 풀이
 
 3. [jsp] 아래의 sql 활용하여  dao기능메서드를 추가하고 검색리스트를 출력하세요.
	 SELECT * 
	 FROM salgrade
 	 WHERE grade BETWEEN 1 AND 5;

	 등급 시작 [   ]
	 등급 끝 [   ]   [검색]
 	 검색된 리스트
*/
// 검색
// 등록
//	<input type="button" value="등록" onclick="insertSalgrade()">
	 function insertSalgrade(){
		 if(confirm("등록하시겠습니까?")){
			 location.href="z04_insertSg.jsp"
		 }
	 }
</script>

</head>
<body>
	<h4>3번</h4>
	<h2>연봉등급 검색</h2>
	<%
	// 검색
	String strSal=request.getParameter("strGrade"); 
	int strGradeInt=0;
	String finSal=request.getParameter("finGrade"); 
	int finGradeInt=0;
	
	A06_PareparedDao dao = new A06_PareparedDao();
	Salgrade schh = new Salgrade(strGradeInt, finGradeInt);
	
	//등록 insertSg.jsp 에서 등록처리
	%>
	<form>
		<table>
			<col width="40%">
			<caption>검색등급</caption>
			<tr><th>시작등급</th><td><input type="text" name="strGrade" value="<%=strGradeInt %>"></td></tr>
			<tr><th> 끝등급</th><td><input type="text" name="finGrade" value="<%=finGradeInt %>"></td></tr>
			<tr><td colspan="2"><input type="submit" value="검색" >	
								<input type="button" value="등록" onclick="insertSalgrade()"></td></tr>
		</table>
	</form>
	
	<table>
		<tr>
			<th>등급</th><th>급여시작</th><th>급여끝</th>
		</tr>
		<%for(Salgrade s: dao.SalList(schh)) {%>
			<tr>
				<td><%=s.getGrade() %></td>
				<td><%=s.getLosal() %></td>
				<td><%=s.getHisal() %></td>
			</tr>
		<%} %>
	</table>
	


</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>