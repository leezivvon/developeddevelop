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
//ex) a12_main.jsp
/*
16강 확정팀 [		] [1번] [2번]	 [3번]
번호대로 해당 팀이 할당되게 하세요(frame 할당처리)
frame1 팀1 - 팀2		a13_sub.jsp
frame2 팀1 - 팀2 		a14_sub.jsp
frame3 팀1 - 팀2 		a15_sub.jsp
*/
</script>

</head>
<body>
	
	<style>iframe{border:3px solid red; width:30%; height:30%;}</style>
	
	<h2>월드컵 16강 확정팀</h2>
	<input type="text" name="tname">
	<input type="button" value="1번" onclick="win(0)">
	<input type="button" value="2번" onclick="win(1)">
	<input type="button" value="3번" onclick="win(2)"><br><br><br><br>
	
	<iframe name="group01" src="a13_sub.jsp" ></iframe>
	<iframe name="group02" src="a14_sub.jsp" ></iframe>
	<iframe name="group03" src="a15_sub.jsp" ></iframe>

</body>

<script type="text/javascript">
	function win(idx){
		var tname = document.querySelector("[name=tname]").value
		if(idx==0) group01.document.body.innerHTML+=tname+" - "
		if(idx==1) group02.document.body.innerHTML+=tname+" - "
		if(idx==2) group03.document.body.innerHTML+=tname+" - "
	}
	
</script>
</html>