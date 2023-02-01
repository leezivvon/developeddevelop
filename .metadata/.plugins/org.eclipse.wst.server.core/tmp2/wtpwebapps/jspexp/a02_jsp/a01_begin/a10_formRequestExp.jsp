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
ex) 영화명, 가격, 관람인원을 입력받아서 영화명과 총관람 비용을 하단 테이블에 출력
--%>
	<form>
		영화명:<input type="text" name="movie"/>
		가격:<select name="ticket">
				<option value="10000">조조(10000원)</option>
				<option value="15000">일반(15000원)</option>
				<option value="17000">4D(17000원)</option>
				<option value="21000">IMAX(21000원)</option>
			</select>	
		관람인원:	<select name="people">
					<%for(int cnt=1;cnt<=10;cnt++){ %>
						<option><%=cnt %></option>
					<%} %>
				</select>
		<input type="submit" value="예매"/>
	</form>
	<%
	/*
	String movie = request.getParameter("movie");
	if(movie==null) movie="";
	String ticket = request.getParameter("ticket");
	if(ticket==null) ticket="0";
	String people = request.getParameter("people");
	if(people==null) people="0";
	
	int ticketP = Integer.parseInt(ticket);
	int peopleM = Integer.parseInt(people);
	int tot= ticketP*peopleM;
	*/
	// a10_formRequestExp.jsp
	// 1. 초기로딩된 페이지와
	// 2. 요청값을 전달 후 만들어진 페이지는 다른 모양으로 나오는 초기화면과 요청값을 받은 후 나오는 2개의 논리적 페이지를 포함하고 있따
	
	
	//? movie=영화명&price=10000&cnt=5
	String movie = request.getParameter("movie");
	
	// null값이 아닐때만 table이 보이게끔 처리. 즉 요청값이 없는 초기화면에는 출력내용이 보이지 않게 처리
	if(movie != null){
		// 물건가격 ==>
		String ticket = request.getParameter("ticket");
		if(ticket==null) ticket="0";
		String people = request.getParameter("people");
		if(people==null) people="0";
		// 가져온 ticket people 를 숫자로 형변환한 후 연산처리(*) tot 할당
		int tot= Integer.parseInt(ticket)*Integer.parseInt(people);
	%>
	<h2>예시-영화</h2>
	<table>
		<tr><th>영화명</th><td><%=movie %></td></tr>
		<tr><th>총액</th><td><%=tot %></td></tr>
	</table>
	<% } %>
	
	<%-- 
	# 숫자형 데이터 요청값 처리
	1. default변수 선언
		int num01 =0;
	2. 요청값 설정	
		String num01S = request.getParameter("num01");
	3. 해당 요청데이터가 있을 때 형변환 처리	
		if(num01S != null) num01 = Integer.parseInt(num01S);
	
	# 함수형 처리(기능메서드 선언 처리)
	int chInt(String req){
		int num = 0;
		if(req != null || !req.equals("")) num = Integer.parseInt(req);
		return num;
	}
	int num01 = chInt(request.getParameter("num01"))
	int num02 = chInt(request.getParameter("num02"))
	--%>
	
	
	
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>