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
# request, response 객체는 서버안에 있느 코드에서 사용되는 jsp객체이다


클라이언트	<============> 서버
		===request===>
		<==response===
		
1. 클라이언트에서 서버로 주는 내용
	1) 요청 query string ?key=value
	2) 쿠키정보 : 임시정보	쿠키(클라이언트에 저장되어 있음)	
	3) 기타 클라이언트 관련 접속 정보
2. 서버에서 클라이언트로 주는 내용
	1) 구성된 화면(웹화면)
	2) session 정보 전달  session(서버에 저장되어있음)
	3) 기타 서버 관련 정보
	
	
# request 기본 객체
1. 웹 브라우저가 웹 서버에 전송한 요청 관련 정보 제공
2. 주요 기능
	1) 클라이언트(웹 브라우저)와 관련된 정보 읽기 기능
	2) 서버와 관련된 정보 읽기 기능
	3) 클라이언트가 전송한 요청 파라미터 읽기 기능
	4) 클라이언트가 전송한 쿠키 읽기 기능
	5) 속성 처리 기능
3. request 기본 객체 - 주요 정보 제공 메소드
	기준이 되는 서버 : http:local:8080/a02_jsp/a02_startJSP/a03_request.jsp
	1) getRemoteAddr()
		웹 서버에 연결한 클라이언트의 ip주소를 구한다
		게시판이나 방명록 등에서 글 작성자의 ip 주소가 자동으로 입력되기도 하는데
		이 때 입력되는 ip주소가 바로 이 메서드를 사용하여 구현되는 것이다
	2) getMethod()
		웹 브라우저가 정보를 전송할 때 사용한 방식을 구한다
	3) getRequestURI() : 웹 브라우저가 요청한 URL에서 경로를 구한다
	4) getContextPath(): JSP 페이지가 속한 웹 어플리케이션의 컨텍스트 경로를 구한다
		wepapp 하위에 절대 기준 경로를 설정할 수 있기 때문에 변수를 설정해서 공통css, 공통 javascript, 이미지폴드, 페이지이동 등을 활용할 대 기준경로로 설정한다
		프로젝트명하고 맵핑되는 경우가 많다
		<% String path = request.getContextPath(); %>
		
		<link href="<%=path%>a00_com/a01_common.css"
		<scirpt src = "<%=path %>a00_com/a02_com.js">
		<img src="<%=path %>a01_imgimg01.jpg">
		<a href ="<%=path %>a01_main/menu01.jsp"
		
		context명을 서버에서 /로 설정했기 때문에 사용하지 않고 바로 처리함
		<link href="/a00_com/a01_common.css" rel="stylesheet">
	
	4) getServerName() : 연결할 때 사용한 서버 이름을 구한다
	6) getServerPort() : 서버가 실행중인 포트 번호를 구한다
	ps) 위 정보들을 서버에서 LOG파일이나 db로 저장해서 현재 서버의 부하량이나 접속 정보들을 파악해서 모니터링할 때 활용된다

--%>

	<h2>원격주소:<%=request.getRemoteAddr() %></h2>
	<h2>전송방식:<%=request.getMethod() %></h2>
	<h2>요청URI:<%=request.getRequestURI() %></h2>
	<h2>기준context:<%=request.getContextPath() %></h2>
	<h2>서버명:<%=request.getServerName() %></h2>
	<h2>포트명:<%=request.getServerPort() %></h2>
<%
String path = request.getContextPath();
// 경로상 webapp하위이다
%>
<img src="<%=path %>/a00_img/apple.jpg"/>


<%-- 
# request 기본 객체 - 파라미터 읽기 메서드(요청값 처리 메서드)
1. 기준 요청값

	?key=value
2. 기능메서드
	request.getParameter(String name)
		이름이 name인 파라미터의 값을 구한다. 존재하지 않을 경우 null로 리턴	
		주로 하나의 요청키와 하나의 요청값인 경우 사용한다
		ex) ?name=홍길동&age=25&loc=서울
	request.getParameterValues(String name)
		이름이 name인 모든 파라미터의 값을 배열로 구한다. 존재하지 않을 경우 null을 리턴한다
		ex) ?name=홍길동&name=고길동&name=마길동
	request.getParameterNames(): 웹 브라우저가 전송한 파라미터의 이름을 구한다	
	request.getParameterMap()  : 웹 브라우저가 전송한 파라미터의 맵을 구한다. 맵은 파라미터 이름, 값 쌍으로 구성된다 	
	==> 요청key를 모르거나 변동이 되는 경우 해당 요청 key와 값을 설정하여 처리할 때 활용된다
--%>
	<%-- 
	http://localhost:7080/a02_jsp/a02_startJSP/a03_request.jsp
	?name=홍길동&age=25&loc=서울&price=3000&price=4000&price=5000
	--%>
	<h2>name:<%=request.getParameter("name")%></h2>
	<h2>age: <%=request.getParameter("age")%></h2>
	<h2>loc: <%=request.getParameter("loc")%></h2>
	<%
	String prices[] = request.getParameterValues("price");
	if(prices!=null){
	%>
	<h2>price[0]:<%=prices[0]%></h2>
	<h2>price[1]:<%=prices[1]%></h2>
	<h2>price[2]:<%=prices[2]%></h2>
	<% } %>
	
	
	<h2>getParameterNames() 처리</h2>
	<%
	// 요청값이 가변적일 때 처리되는 객체로 요청 키들을 가지고 온다
	Enumeration e = request.getParameterNames();
	
	int tot = 0;
	while(e.hasMoreElements()){ // 요청키가 있을 때까지 처리
		String key = (String)e.nextElement(); 	// 요청키를 가지고 온다
//		String value = request.getParameter(key); // 요청값을 가지고 온다
		
		// 여러개가 단일 개수가 섞여있는 경우
		String req[] = request.getParameterValues(key);
		for(String value:req){
			if(key.equals("price")){
				int price =0;
				
				// null, ""(공백), 숫자형이 아닌 것을 모두 다 0으로 처리해줌
				try{
					price = Integer.parseInt(value);
				}catch(Exception ex){ }
				
				tot += price;
			}
			//out.print("<h3>"+key+":"+key+"/<h3>")
	%>
		<h3><%=key %>:<%=value %></h3>
	<%	}
	} 
	out.print("<h3>총비용합산: "+tot+"</h3>");
	%>
	

	
	<%-- 
	ex) a04_requestExp.jsp?pname01=사과&pname02=오렌지&pname03=수박
		을 처리하여 request.getParameterNames()로 가져와서 테이블로 출력되게 하세요
	--%>
	
</body>

<script type="text/javascript">
/*
 
*/
</script>
</html>