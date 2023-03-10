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
# request.getParameterValues("다중의 키") //다중의 키값을 받는 요청객체
1. 동일한 이름으로 여러개의 요청값을 받을 때 사용한다
2. 기본 리턴 데이터 유형은 문자열 배열이다

--%>
	<form>
		과일1 : <input type="text" name="fruit" value="사과">
		과일2 : <input type="text" name="fruit" value="바나나">
		과일3 : <input type="text" name="fruit" value="딸기">
		<input type="checkbox" name="food" value="소고기"> 소고기
		<input type="checkbox" name="food" value="돼지고기"> 돼지고기
		<input type="checkbox" name="food" value="닭고기"> 닭고기
		<input type="checkbox" name="food" value="오리고기"> 오리고기<br>
		<input type="submit">
	</form>
	<%
		// fruit=사과&fruit=바나나&fruit=딸기&food=소고기&food=닭고기
		// 같은 이름으로 여러 개의 요청값을 받을 수 있다
		// type="text"는 모두 요청값으로 *배열로 전달
		String fruits[] = request.getParameterValues("fruit");
		// type="checkbox" 체크가 된 것만 배열로 전달
		String foods[] = request.getParameterValues("food");
	%>
	
	<h2>과일 종류 :
		<%
		if(fruits!=null){
			for(String fruit:fruits){ %>
				<%=fruit %>,
	  <%	}
		} %>
	</h2>
	<%--
		PrintWriter out = response.getWriter();
		jsp ==> servlet으로 처리될 때 선언된 내장 객체 out사용
		out.print("<h2>servlet은 jsp가 만드는 것</h2>");
	--%>
	<h2>선택한 육류:
		<%
		if(foods!=null){
			for(String food:foods){ 
				out.print(food+","); // out : 내장된 출려을 처리해주는 객체
	  		}
		} 
		%>
	</h2>
	
	<%-- 
	ex) form으로 가고 싶은 여행지 
		[]인도 []남태평양 []제주도 []유럽
		[확인] 
		==> 테이블 형식으로 선택된 여행지 출력
	--%>
	<h2>다중 선택</h2>
	<form>
		<!-- 입력 -->
		<input type="checkbox" name="travle" value="인도"> 인도
		<input type="checkbox" name="travle" value="남태평양"> 남태평양
		<input type="checkbox" name="travle" value="제주도"> 제주도
		<input type="checkbox" name="travle" value="유럽"> 유럽<br>
		<input type="submit" value="확인"/>
	</form>
	<%	
	// 배열
	String travles[] = request.getParameterValues("travle");
	%>
	<table>
		<%
		// 출력
		if(travles!=null){
			for(String travle:travles){
				out.print("<tr><td>"+travle+"</td></tr>");
	   	 	}
		} 
		%>
	</table>
	
	<h2>단일 선택</h2>
	<form>
		<!-- 입력 -->
		<input type="radio" name="travle" value="인도"> 인도
		<input type="radio" name="travle" value="남태평양"> 남태평양
		<input type="radio" name="travle" value="제주도"> 제주도
		<input type="radio" name="travle" value="유럽"> 유럽<br>
		<input type="submit" value="확인"/>
	</form>
	<%
	// radio는 name이 동일한 내용에서 단일 선택만 가능
	// 단일선택이기 때문에 배열에 담지X
	String travle = request.getParameter("travle"); 
	%>
	<h3>선택한 여행지:<%=travle!=null?travle:"" %></h3>

	<%
		List<Product> plist = new ArrayList<Product>();
		plist.add(new Product("사과", 3000,2));
		plist.add(new Product("바나나", 4000,3));
		plist.add(new Product("딸기", 12000,5));
		plist.add(new Product("오렌지", 12000,1));
	%>

	<form>
	<h3>장바구니</h3>
		<table>
			<tr><th>선택</th><th>물건명</th><th>가격</th><th>개수</th></tr>
			<%
				for(int idx=0;idx<plist.size();idx++){
					Product pro = plist.get(idx);
			%>
			<tr>
				<td><input type="checkbox" name="ch" value="<%=idx %>"></td>
				<td><input type="text" name="name" value="<%=pro.getPname() %>"/></td>
				<td><input type="text" name="price" value="<%=pro.getPrice() %>"/></td>
				<td><input type="text" name="cnt" value="<%=pro.getCnt() %>"/></td>
			</tr>
			<%} %>
			<tr><td colspan="4"><input type="submit" value="결재하기"></td></tr>
		</table>
	</form>
	<p align="center">
		<%
			String ch[] = request.getParameterValues("ch");
			String names[] = request.getParameterValues("names");
			String prices[] = request.getParameterValues("prices");
			String cnts[] = request.getParameterValues("cnts");
			if(ch!=null){	
				// checkbox인 ch는 check가 된 index만을 넘기지만 type이 text인 경우는 모두 전송이 된다
				for(String cidx:ch){
					int idx = Integer.parseInt(cidx);
					out.print(cidx+":"+names[idx]+":"+prices[idx]+":"+cnts[idx]+"<br>");	
				}
			}
		%>
	</p>
	<%--
	ch: 요청값은 checkbox이기 때문에 체크한 index만 전송 {0, 3}
	names: 	{"사과","바나나","딸기","오렌지"} names[0], names[3]
	prices: {3000,5000,7000,9000}	prices[0], prices[3]
	cnts: 	{3,4,5,6} 				cnts[0], cnts[3]
	--%>
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>