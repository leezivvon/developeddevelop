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
	
		<%-- 3-2단계 정답 --%>
		<h2><%=request.getParameter("namee")%>구매 일반 페이지</h2> 
		<h3><%=request.getAttribute("tott")%>원 구매</h3>


	<%--
	과제정답이었던 것 같은데몰라ㅏ 시발
	
	기준일 <input type="date" name="date01"><br>
	계산할 일수 <input type="text" name="dcnt" value="0"/>
	<input type= "button" value="이전" onclick="calcu(false)"/>
	<input type= "button" value="이후" onclick="calcu(true)"/>
	<p id="show01" align="center"></p>
	
	<script type="text/javascript">
		var date01 = document.querySelector("[name=date01]")
		var dcnt = document.querySelector("[name=dcnt]")
		var show01 = document.querySelector("#show01")
		
		//오늘 날짜 설정
		var d = new Date()
		// date01.value=d.getFullYear()+"-"+( d.getMonth()+1 )+"-"+d.getDate()
		date01.value=d.toISOString().split("T")[0]
		
		function calcu( isAfter ){ //파라미터값으로 boolean값을 넣습니다
			//alert(isAfter)
			//alert(date01.value)
			var d = date01.value.split("-")
			// console.log(d)
			// console.log(d[1]-1+"월(-1)처리")
			//입력
			var dt01 = new Date(d[0], d[1]-1, d[2])
			var datecnt = parseInt(dcnt.value) //입력된 내용을 형변환 +값때문에
			//일수 처리
			if( !isAfter ) datecnt = -datecnt
			dt01.setDate(dt01.getDate()+datecnt)
			show01.innerText = dt01.toLocaleString()
		}
		
	</script>
	 --%>
	

	

</html>