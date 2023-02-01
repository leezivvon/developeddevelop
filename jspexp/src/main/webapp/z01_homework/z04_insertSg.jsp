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
	<%
	String gradeS= request.getParameter("grade");
	int grade=0;
	if(gradeS!=null&&!gradeS.equals("")){
		grade = Integer.parseInt(gradeS);
	}
	String losalS= request.getParameter("losal");
	int losal=0;
	if(losalS!=null&&!losalS.equals("")){
		losal = Integer.parseInt(losalS);
	}
	String hisalS= request.getParameter("hisal");
	int hisal=0;
	if(hisalS!=null&&!hisalS.equals("")){
		hisal = Integer.parseInt(hisalS);
	}
	
	boolean isInsert = false;
	if(gradeS!=null&&!gradeS.equals("")){
		Salgrade ins = new Salgrade(grade, losal, hisal);
		isInsert = true;
		A06_PareparedDao dao = new A06_PareparedDao();
		dao.insertSalgrade(ins);
	}
	%>
	
	<h2>급여 등급 등록</h2>
	<form>
		<table>
			<tr><th>등급</th><td><input type="text" name="grade"></td></tr>
			<tr><th>시작연봉</th><td><input type="text" name="losal"></td></tr>
			<tr><th>끝연봉</th><td><input type="text" name="hisal"></td></tr>
			<tr><td colspan="2"><input type="submit" vlaue="등록"></td></tr>
		</table>
	</form>

</body>
<script type="text/javascript">

	var inInsert = <%=isInsert%> // 이게 뭔지 모르겠음
	if(inInsert){
		if(confirm("등록성공\n조회화면으로 이동하시겠습니까?")){
			location.href="221117_03.jsp"
		}
	}
</script>
</html>