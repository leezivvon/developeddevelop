<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"       
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
</head>
<body>

<%-- 
# 주요 기본 객체
1. request 	: 클라이언트의 요청정보를 저장한다
2. response : 응답정보를 저장한다
3. pageContext : jsp 페이지에 대한 정보를 저장한다
4. session 	: HTTP 세션 정보를 저장한다 
			  서버와 클라이언트간에 연결된 상태를 기준으로 특정 변수의 저장범위를 처리한다
			  (=웹브라우저와 웹서버가 연결된 상태)
5. application : 웹 어플리케이션에 대한 정보를 저장한다
	- 웹서버 전체에 대한 저장 정보를 처리할 수 있다
6. out 	: jsp페이지가 생성하는 결과를 출력할 때 사용되는 출력 스트림이다
7. config 	: jsp페이지에 대한 설정 정보를 저장한다
8. page : jsp페이지를 구현한 자바 클래스 인스턴스이다
9. exception: 예외 객체, 에러 페이지에서만 사용된다

# session 범위에 따른 객체 : 웹에서 저장되는 페이지와 시간적인 범위에 따라 설정 
0. 아래 객체들은 공통 메서드를 통해서 저장되고 호출된다
	setAttribute("저장키", "저장값")
	getAttribute("저장키")
1. pageContext : 한페이지 안에서만 사용 가능
2. request : 요청범위까지만 사용 가능
3. session : 세션이 지정한 만료시간까지 사용가능
4. application : 웹서버가 기동할 때까지(재기동 전까지) 사용가능
		


# out기본객체
1. jsp페이지가 생성하는 모든 내용은 out기본객체를 통해서 전송할 수 있다
2. 복잡한 if-else사용 시, out 기본 객체 사용하면 편리하다
	1) scriptlet, expression의 복잡한 사용보다 out으로 활용할 때 더 효율적일 때가 많다
3. 출력 메서드
	1) out.print()	: 데이터를 출력만한다
	2) out.pritnln() : 데이터를 출력하고 줄바꿈까지 처리한다
	3) out.newLine() : 줄바꿈 처리를 한다	
--%>

	<h2>안녕하세요	</h2>
	<h2>script만 사용하는 경우</h2>
	<h3>
	<%for(int cnt=0;cnt<=10;cnt++){ %>
		<%=cnt %>,
	<%} %>
	</h3>
	
	<h2>out객체사용</h2>
	<h3>
	<%
		for(int cnt=0;cnt<=10;cnt++){
			out.print(cnt+", ");
		}
	%>
	</h3>
	
	<%-- 
	ex) cnt를 1~16까지 하여 번호가 있는 테이블(4X4)을 만들어 보세요
	--%>
	<h2>테이블1</h2>
	<table>
	<%
		//1.
		
		int cnt =0;
		for(int row =1;row<=4;row++){ //행을만들고
			out.print("<tr");
			for(int col =1;col<=4;col++){//열을만드는방법
				out.print("<td>"+(++cnt)+"</td>");
			}
			out.print("</tr>");
		}
	%>	
	</table>
	
	<h2>테이블2</h2>
	<table>
	<% 		
		// 2.
		for(int cel =1;cel<=16;cel++){ 
			if(cel%4==1) out.print("<tr>"); //cel이4의배수(+1)일때만 tr
			out.print("<td>"+cel+"<td>");
			if(cel%4==0) out.print("</tr>"); //cel이4의배수일때만 tr로 닫아줌
		}
	%>
	</table>
	<%-- ex1) ul의 리스트로 배열로 선언된 과일명 출력하기 //jsp로 --%>
	<%
	String []fruits = {"사과", "바나나", "딸기"};
	%>
	<ul>
		<%
		for(String fru:fruits){
			out.print("<li>"+fru+"</li>");
		}
		%>
	</ul>
	<!-- ex 1-1) ol로 물건의 가격 5개 리스트 배열 선언 후 출력 -->
	<%
	int []prods = {5000, 6000, 12000, 14000, 17300};
	%>
	<ol>
		<%
		for(int prd:prods){
			out.print("<li>"+prd+"</li>");
		}
		%>
	</ol>
	
	
	<%-- ex2) select의 option의 value/출력내용으로 부서번호 배열, 부서명 배열 출력 --%>
	부서정보 :<select name="deptno" onchange="alert(this.value)"> <!-- 선택한 값을 경고창으로 로딩 -->
	<%
		int deptnos[]={10, 20, 30, 40};
		String dnames[]={"인사", "재무", "회계", "기획"};
		for(int idx=0;idx<deptnos.length;idx++){
			out.print("<option value='"+deptnos[idx]+"'> "+dnames[idx]+"</option>");
		}
	%>
		<option value='50'>아이티 산업</option>
	</select>
	<!-- ex2-1) 사원번호와 사원명을 배열로선언하고 select로 선언하여 value에서 사원번호, 레이블에는 사원명으로 처리되게 하세요 -->
	<%
		int empnos[]={161601, 161602, 161603, 161604, 161605};
		String enames[]={"이지원", "이지은", "이지연", "이지윤", "이지유"};
//		for(int idx=0;idx<empnos.length;idx++){
//			out.print("<option value='"+empnos[idx]+"'> "+enames[idx]+"</option>");
//		}
	%>
	<h2>사원정보</h2>
	<select name="empno" onchange="alert(this.value)"> <!-- 선택한 값을 경고창으로 로딩 -->
	<%for(int idx=0;idx<empnos.length;idx++){ %>
		<option value='<%=empnos[idx] %>'><%=enames[idx] %></option>
	<%} %>
	</select>
	
	<h2>사원정보2</h2>
	<%
		List<Code> clist = new ArrayList<Code>();
		clist.add(new Code("7780", "홍길동"));
		clist.add(new Code("7781", "김길동"));
		clist.add(new Code("7782", "신길동"));
		
		for(Code c:clist){
			out.print("<option vlaue='"+c.getKey()+"'> "+c.getVal()+"</option>");
		}
	%>
	
	
	<%-- ex3) h3으로 7가지 무지개 배경색상과 함께 출력하기 --%>
	<%
	String []kcolor={"빨강", "주황", "노랑", "초록", "파랑", "남", "보라"};
	String []ecolor={"red","orange","yellow","green","blue","navy","purple"};
	
	for(int idx=0;idx<kcolor.length;idx++){
		out.print("<h3 style='background-color:'"+ecolor[idx]+"'>"+kcolor[idx]+"</h3>");
	}
	%>
	<%-- ex3-1) span 태그로 물건명을 3개 출력하되 테두리 색상을 초록색, 글자색은 파란색/노란색/보라색으로 처리하되
				해당 색상의 변수는 자바로 선언하고 처리하세요? --%>
	<script>
	var arry = [blue, yellow, purple, green]	
	</script>
	<%
		String []pnames={"아이맥", "맥프로", "z플립"};
		String []fcolor={"blue","yellow","purple"};
		String bkColor="green";
	
		for(int idx=0;idx<pnames.length;idx++){
	%>
	<span style='padding:5px;border-radius:10px;
		border:1px solid <%=bkColor %>;color:<%=fcolor[idx]%>'><%=pnames[idx] %></span>
	<%} %>
	
	
	
	<%-- ex4) table로(2X3) 3의 배수를 출력 배경색상 짝수 cel마다 pink색 --%>
	<%
//	for(int cel =1;cel<=6;cel++){ 
//		if(cel%2==1) out.print("<tr>");
//		if(cel%3==0) out.print("<td>"+cel+"</td>");
//		if(cel%2==0) out.print("<td style='background:pink'></td></tr>");
//	}
	
	// 정답
	for(int cel =1;cel<=6;cel++){ 
		if(cnt%3==1) out.print("<tr>");
		out.print("<td style='background:"+(cnt%2==0?"pink":"")+"'>"+cnt*3+"</td>");
		if(cnt%3==0) out.print("</tr>");
	}
	%>
	
	
	
	<%-- ex5) table로 타이틀로 물건명 가격 개수 선언 
			  5개 row로 각 cel마다 물건명/가격은 input, 개수는 0~9까지 있는 select만들기 
				1) 기본화면 구성
				2) java List선언(Dao로 가져온 데이터 리스트)
				3) 반복문과 html 코드로 처리
				4) script 처리가 필요한 부분 처리
	--%>
	<h2>입력하는 테이블 리스트</h2>
	<%
	List<Product> plist = new ArrayList<Product>();
	plist.add(new Product("사과", 3000, 2)); // 약간 디폴트 느낌으로 출력됨
	plist.add(new Product("바나나", 4000, 3));
	plist.add(new Product("딸기", 12000, 5));
	plist.add(new Product("딸기", 12000, 5));
	plist.add(new Product("딸기", 12000, 5));
	plist.add(new Product("딸기", 12000, 5));
	plist.add(new Product("딸기", 12000, 5));
	%>
	<table>
		<tr><th>선택</th><th>물건명</th><th>가격</th><th>개수</th></tr>
		<%for(int idx=0;idx<plist.size();idx++){
			Product p =plist.get(idx);	
		%>
		<tr>
			<td><input type="checkbox" name="ch" value="<%=idx %>"
						<%=idx%2==0?"checked":"" %>	></td> <!-- 짝수만 check 되어있게 -->
			<td><input type="text" name="name" value="<%=p.getPname() %>"></td> <!-- 약간 디폴트 느낌으로 출력됨 --> 
			<td><input type="text" name="pirce" value="<%=p.getPrice() %>"></td> <!-- 약간 디폴트 느낌으로 출력됨 --> 
			<td><select name="cnt">
					<%for(cnt=0;cnt<=9;cnt++){ %>
					<option <%=cnt==p.getCnt()?"selected":""%> ><%=cnt %></option> <!-- 약간 디폴트 느낌으로 출력됨 --> 
					<%} %>
				</select></td>
		</tr>
		<%} %>
	</table>

	<%-- ex) 사원번호, 사원명, 급여, 부서명(select) 테이블에 form요소객체로 출력 --%>
	<h2>사원정보</h2>
	<%
	List<Emp> elist = new ArrayList<Emp>();
	elist.add(new Emp(7781, "홍길동", 3000, 10));
	elist.add(new Emp(7782, "김길동", 3500, 20));
	elist.add(new Emp(7783, "신길동", 4000, 30));
	elist.add(new Emp(7784, "오길동", 4500, 40));
	%>
	<table>
		<col width="10%"><col width="20"><col width="25%"><col width="20%"><col width="25%">
		<tr><th>선택</th><th>사원번호</th><th>사원명</th><th>급여</th><th>부서</th></tr>
	<%
	for(int idx=0;idx<elist.size();idx++){ 
	Emp e = elist.get(idx);
	%>
		<tr><td><input type="checkbox" name="ck" value="<%=idx %>"></td>
			<td><input type="text" name="empno" value="<%=e.getEmpno() %>"></td>
			<td><input type="text" name="ename" value="<%=e.getEname() %>"></td>
			<td><input type="text" name="sal" value="<%=e.getSal() %>"/></td>
			<td><select name="deptno">
					<option value="10" <%=e.getDeptno()==10?"selected":"" %> >인사</option>
					<option value="20" <%=e.getDeptno()==20?"selected":"" %> >재무</option>
					<option value="30" <%=e.getDeptno()==30?"selected":"" %> >회계</option>
					<option value="40" <%=e.getDeptno()==40?"selected":"" %> >기획</option>
				</select>
			</td></tr>
	<%} %>		
	</table>
</body>
</html>