<%--
2022-11-24
[1단계:개념] 1. response는 request와 대비해서 어떤 역할을 하는 객체인가?
[1단계:개념] 2. response.sendRedirect와 location.href의 차이점을 기술하세요.
[1단계:확인] 3. 조건(부서번호와 (DB처리)부서명이 있을 때, 해당 부서페이지로 이동하고, 그렇지 않을 때, 해당 부서가 없습니다. 경고창 처리하세요.
[2단계:확인] 3. (DB처리)부서번호와 부서명이 있을 때, 해당 부서페이지로 이동하고, 그렇지 않을 때, 해당 부서가 없습니다. 경고창 처리하세요.
[1단계:확인] 4. [화면구현] 배열로 월드컵 D조팀  ul로 리스트 출력하세요.
[2단계:확인] 5. [화면구현] 2차원 배열로 월드컵 A,B조 및 그 팀들을 선언하고 ol/ul을 계층적으로 출력하세요.
[1단계:확인] 6. [화면구현] 오늘 월드컵 출전 팀과 경기 시간을 배열로 선언하고 select의 value는 시간, 레이블은 팀명을 출력하되, 선택했을 시간을 경고창으로 출력되게 하세요.(배열, Code객체)
[1단계:확인] 7. [화면구현] 사이트 상단 메뉴항목을 배열로 5개 선언하고, 각 메뉴별로 배경색상을 지정한후, 수평으로 리스트 출력되게 하세요.
[1단계:확인] 8. [화면구현] jsp에서 테이블로 2X3, 3X4, 5X2를 만들고, 2의 배수, 4의 배수, 5의 배수로 출력하세요.(배경색상은 홀짝 다르게 출력)
--%>
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
</head>
<body>
<%--
1
response 기본 객체를 웹 브라우저에 전송하는 응답 정보 설정
클라이언트와 서버 간에 통신을 할 대 클라이언트는 서버에게 요청(request)을 하고 서버는 클라이언트에게 응답(response)

2
리다이렉트(response.sendRedirect(String location)	)는 특정 페이지로 이동하라고 웹 브라우저에 응답하고 서버 안에서 명령문으로 특정 페이지로 이동 처리
반면 location.href="이동페이지" 브라우저에서 특정한 페이지로 이동 처리
--%>
<%-- 
3 

1) 화면구현
	부서번호 	[ ]
	부서명  	[ ]
	[등록확인]
		
2) 요청값처리 : null, 숫자형
	String deptnoS =requset.getParameter("deptno");
	int deptno =0;
	if(deptnoS!=null) deptno = Integer.parseInt(deptnos);
	String dname = request.getParameter("dname");
	
3) 요청값에 따른 페이지 전환
	boolean isInValid = false;
	if(deptnoS!=null && dname!=null){
		if(deptno==10 && dname.equals("회계")){
			response.sendRedirect("z04_main.jsp");	
		}else{
			isInValid = true;
		}
	}
	var isInValid =<%=isInValid %>
	if(isInValid){
		alert("해당 부서정보가 없습니다");
	}
--%>
<form action="">
	부서번호 :<input type="text" name="deptno">
	부서명  :<input type="text" name="dname">
	<input type="submit" name="등록확인"/>
</form>
<%
	String deptnoS =request.getParameter("deptno");
	int deptno =0;
	if(deptnoS!=null) deptno = Integer.parseInt(deptnoS);
	String dname = request.getParameter("dname");
	
	boolean isInValid = false;
	if(deptnoS!=null && dname!=null){
		
		A06_PareparedDao dao = new A06_PareparedDao(); // dao객체 부르고
//		if(deptno==10 && dname.equals("회계")){
		if(dao.chkDept(deptno, dname)){	// dao로 기능메서드 호출
			response.sendRedirect("z04_main.jsp");	
		}else{
			isInValid = true; // 유효하지 않을 때
		}
	}
%>
<script type="text/javascript">
	var isInValid =<%=isInValid %>
	if(isInValid){
		alert("해당 부서정보가 없습니다");
	}
</script>
<%-- 
3-2단계 
1. dao 기능메서드 선언
	1) sql : select * from dept where deptno = ? and dname = ?
	2) vo
	3) 기능메서드 선언
		public boolean chkDept(int deptno, String dname){
		
		}
2. jsp
	if(deptnoS!=null && dname!=null){
		if(dao.chkDept(deptno, dname)){
			response.sendRedirect("@@@.jsp")
		}esle{
		
		}
	}		
--%>


<%-- 4 --%>
<%
String []soccer = {"프랑스", "덴마크", "튀니지", "호주"};
%>
<ul>
	<%
		for(String sc:soccer){
			out.print("<li>"+sc+"</li>");
		}
	%>
</ul>

<%-- 5 --%>
<% 
// 2차원배열
/*
String []wc =[
	            {"네덜란드","에콰도르","세네갈","카타르"},
	            {"잉글랜드", "미국", "웨일스", "이란"}
             ];
*/

// 정답
String[][]teams ={	{"카타르","에콰도르","세네갈","네덜란드"},
					{"잉글랜드", "이란", "미국", "웨일스"},
					{"잉글랜드", "이란", "미국", },
					{"잉글랜드", "이란"},
					{"아르헨티나", "사우디아라비아", "멕시코", "폴란드" }	};
out.print("<ol type='A'>");
for(String team[]:teams){ // 나라들 배열은 1차원배열
	out.print("<li>조");  // ol type='A'
	out.print("   <ul>");	
	for(String nation: team){ // 나라명을 문자열로 하나씩 입력한다
		out.print("<li>"+nation+"</li>"); // ul type은 ○
	}
	out.print("   </ul>");
	out.print("</li>");
}
out.print("</ol>");
%>


<%-- 6 --%>
<%-- 배열이용--%>
<%
String []wcts={"스페인vs코스타리카", "벨기에vs캐나다", "스위스vs카메룬", "우루과이vs대한민국"};
String []time={"01:00", "04:00", "19:00", "22:00"};
%>
<select name="game" onchange="alert(this.value)">
<%
for(int idx=0;idx<wcts.length;idx++){
%>
	<option value='<%=time[idx] %>'><%=wcts[idx] %></option>
<%} %>
</select>

<%-- Code이용 --%>
<h2>월드컵경기</h2>
<h2>월드컵 대전팀과 일정(해당 팀을 클릭 시 시간 확인)</h2>
<select name="game02" onchange="alert(this.value)">
<%
	List<Code> clist = new ArrayList<Code>();
	clist.add(new Code("01:00", "스페인vs코스타리카"));
	clist.add(new Code("04:00", "벨기에vs캐나다"));
	clist.add(new Code("19:00", "스위스vs카메룬"));
	clist.add(new Code("22:00", "우루과이vs대한민국"));
	
	for(Code c:clist){
		out.print("<option vlaue='"+c.getKey()+"'> "+c.getVal()+"</option>");
		// 레이블을 설정하면 value도 레이블과 동일하게 적용되기때문에 value를 설정할 필요가 없다
		// 즉 vlaue를 따로 설정할 거라면 레이블과 다르게 할 적용할 것 
	}
%>
</select>

<%-- 7 --%>
<style>
	ul>li{
		 display:inline-block;
	}
</style>
<%
String []menus = {"마이페이지","검색","장바구니","인기상품","행사상품"};
String []colors = {"blue", "tomato", "yellowgreen", "green", "purple"};
%>
<ul>
	<%
		for(int idx=0;idx<menus.length;idx++){
			out.print("<li style='background-color:"+colors[idx]+"'> "+menus[idx]+"</li>");
		}
	%>
</ul>
<%-- 
7정답 
<style>css 메뉴리스트
<ul><li><a href="#">메뉴내용</a></li></ul>
--%>
<style>span{border-radius:5pxl; padding:5px;}</style>
<%
String []menus2 = {"로그인","메인화면","장바구니","인기상품","행사상품"};
String []bks2 = {"로그인","메인화면","장바구니","인기상품","행사상품"};

for(int idx=0;idx<menus2.length;idx++){
%>
	<span style='background:"+<%=bks2[idx]%>+"'><%=menus2[idx] %></span>
<%} %>


<%-- 8 --%>
	<h2>8번테이블</h2>
	<h2>2X3</h2>
	<table>
	<% 		
		// 2X3
		for(int cel01 =1;cel01<=6;cel01++){ 
			if(cel01%3==1) out.print("<tr>"); 
			out.print("<td style='background:"+(cel01%2==0?"beige":"pink")+"'>"+cel01*2+"</td>");
			if(cel01%3==0) out.print("</tr>"); 
		}
	%>
	</table>
	
	<h2>3X4</h2>
	<table>
	<% 
		// 3X4
		for(int cel02 =1;cel02<=12;cel02++){ 
			if(cel02%4==1) out.print("<tr>"); 
			out.print("<td style='background:"+(cel02%2==0?"tomato":"green")+"'>"+cel02*4+"</td>");
			if(cel02%4==0) out.print("</tr>"); 
		}
	%>	
	</table>
	
	<h2>5X2</h2>
	<table>
	<% 
		// 5X2
		for(int cel03 =1;cel03<=10;cel03++){ 
			if(cel03%2==1) out.print("<tr>"); 
			out.print("<td style='background:"+(cel03%2==0?"green":"red")+"'>"+cel03*5+"</td>");
			if(cel03%2==0) out.print("</tr>"); 
		}
	%>
	</table>

</body>
</html>