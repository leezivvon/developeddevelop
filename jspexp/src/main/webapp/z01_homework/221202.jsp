<%-- 
2022-12-02
[1단계:개념] 1. [jsp] forward란 무엇인가? 페이지 처리의 scope 범위를 기술하세요.
[1단계:확인] 2. [jsp] 물건명:[   ][재고여부] 클릭시, form으로 submit 처리하여 
               a50_check.jsp에 이동해서 a53_main.jsp(재고 있음),  a54_main.jsp(재고 없음),  
[2단계:확인] 3. [jsp] form으로 물건명 가격 갯수를 입력해서 전송했을 때, 두번째 페이지(z40_cal.jsp)에서 총비용이
               100000이상이면 MVP페이지(z41_mvp.jsp)로 forward처리 그렇지 않으면 Normal페이지(z42_normal.jsp)로 이동하게 하세요.
[3단계:확인] 3. [jsp] id:[   ][등록여부] 클릭시, form으로 submit 처리하여 a51_check.jsp에 이동해서 DB에 있을 때와 없을 때는 나누어 
            request setAttribute("hasId","Y"/"N")로 설정하여 등록가능 여부를 처리하세요
[1단계:개념] 4. [js] 날짜 객체의 getTime()은 어떤 메서드 인가?
[1단계:확인] 5. [js] 2022/12/01와 2023/01/01의 사이의 시간과 날짜수를 출력하세요.
[2단계:확인] 5. [js] 오늘로 부터 몇일? [@@@@-@@-@@][날짜 확인] 날짜를 @@@-@@-@@ 형식으로 입력하고,
               날짜 확인 버튼을 클릭시, 며칠되었지 출력하세요.
[1단계:개념] 7. [js] map(), filter()의 차이점을 기술하세요
[1단계:확인] 8. [js] 0~100점의 임의의 국어점수 5명을 만들고 출력하고, 이 점수를 15% 점수를 올린 배열과 60점이상인 배열을 출력하세요.
[3단계:확인] 8. [js] 월드컵 조별팀의 기본속성(나라,승,무,패)로 특정조의 팀들을 현재 성적으로 등록시키고, 승수를 한번에 1씩 올리고, 해당 팀들을 테이블로 출력하고, 이중 승률이 50%이상인 팀만 추출하여 배열 출력하세요
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
<script type="text/javascript">
/*
 
*/
</script>


</head>
<body>

<%-- 
1
forward란
특정한 페이지에서 request와 response 객체와 함께 대상 페이지로 전송하는 기능을 하는 액션 스크립트로
페이지 처리의 scope의 범위는 page영역에서는 jsp파일내에서만 request는 요청으 받아서 응답하기까지
--%>
<a href="https://victorydntmd.tistory.com/155">객체범위종류 정리 블로그</a><br>

<%-- 2 --%>
	<h3>재고찾기</h3>
	<form>
		물건명 <input type="text" name="pname" value=""/>
		<input type="submit" value="재고여부"/>
	</form>
	<div style="border:2px solid green;">
		<%@ include file ="a50_check.jsp" %>
		<h3><%=pname %>검색결과</h3>
	</div>
	<br>
<%-- 
2정답 
1. 화면구성/파일만들기
2. 요청값 처리
	1) 요청값에 따라 요청범위로 설정
	2) 요청 페이지 처리..(forward)
	a50_check.jsp
	String pnamee = request.getParameter("pnamee");
	if(pnamee!=null){
		String page01="";
		if(pnamee.equals("사과")){
			request.setAttribute("msg","재고있음");
			page01="a53_main.jsp";
		}else{
			request.setAttribute("msg", "재고없음");
			page01="a54_main.jsp";			
		}
		RequestDispatcher rd = request.getRequestDispatcher(page01);
		rd.forward(request, response);
	}
	
3. 최종 페이지 가져오기
	a53_main.jsp(재고 있음)  <%=request.getAttribute("msg") %>
	a54_main.jsp(재고 없음)  <%=request.getAttribute("msg") %>

--%>
	<h3>재고찾기</h3>
	<form method="post" action="a50_check.jsp">
		물건명 <input type="text" name="pnamee" />
		<input type="submit" value="재고여부"/>
	</form>



<%-- 3-2단계 
	<h3>총비용 100000이상</h3>
	<form>
		물건명 <input type="text" name="prod01"/>
		가격 <input type="text" name="price01"/>
		개수 <input type="text" name="cnt01"/>
		<input type="submit" value="전송"/>
	</form>
	<div style="border:2px solid black;">
		<%@ include file ="z40_cal.jsp" %>
	</div>
	<br>
	
	
	
3-2단계 정답	
	z40_cal.jsp
		String price = request.getParameter("price"); if(price==null) price="0"
		String cnt = request.getParameter("cnt"); if(cnt==null) cnt="0"
		int priceI = Integer.parseInt(price);
		int cntI = Integer.parseInt(cnt);
		int tot = priceI*cntI;
		request.setAttribute("tot",tot)
		String page01 = "z42_normal.jsp";
		if(tot>=100000){
			page01 = "z41_mvp.jsp";
		}
		<jsp:forward page="<%=page01 %>"/>
		
	z41_mvp.jsp
		<h2><%=request.getParameter("name")%>구매MVP페이지</h2>	
		<h3><%=request.getAttribute("tot")%>원 구매</h3>	
	z42_normal.jsp
		<h2><%=request.getParameter("name")%>구매 일반 페이지</h2> 
		<h3><%=request.getAttribute("tot")%>원 구매</h3>	
--%>
<h2>구매 처리에 따른 등급페이지 이동</h2>
<form method="post" action="z40_cal.jsp">
	물건명 : <input type="text" name="namee"/>
	가격 : <input type="text" name="pricee"/>
	개수 : <input type="text" name="cntt"/>
	<input type="submit" value="구매">
</form>	
		
		
<%-- 
3-3단계정답
1. 화면구현
	name="id"
2. a51_check.jsp
	String id = request.getParameter("id");
	if(id!=null){
		A06_PareparedDao dao = new A06_PareparedDao()
		request.setAttribute("hasId", dao.checkId()?"Y":"N"); //값(데이터)이 있으면 true 값이없으면 false
		RequestDispatcher
		
		<jsp:forward page="064_1202.jsp"/> //despatcher로 해도 됨
	}
3. 현재페이지
	//String id = reqeust.getParameter("id") 이건 뭐지,,ㅋ
	String hasId = request.setAttribute("hasId");
	boolean isCheck = false;
	if(hasId!=null)	{ //초기페이지와 구분 (=forward된 내용인지 초기화면인지 구분
		isCheck=true;
	}
	String id = request.getParameter("id");
	<script>
		var isFirst = <%=isFirst %>
		if( isFirst ){ //입력을 받아서 forward되었을 때 
			var hasId = "<%=hasId %>"
			if(hasId=="Y"){
				alert("등록된 아이디가 있습니다.");
			}else{
				alert("등록 가능합니다.")
				document.querySelector("[name=id]").value="<%=id %>"		
			}
		}
--%>
<h2>아이디 등록 유효 check</h2>
<form method="post" action="a51_check.jsp">
	아이디:<input type="text" name="id">
	<input type="submit" value="등록여부" onclick="ckId()">
</form>
<%
String hasId = (String)request.getAttribute("hasId");
boolean isCheck = false;
if(hasId!=null)	{
	isCheck=true;
}
String id = request.getParameter("id");
%>
<script type="text/javascript">
var isCheck = <%=isCheck %>
if( isCheck ){
	var hasId = "<%=hasId %>"
	if(hasId=="Y"){
		alert("등록된 아이디가 있습니다.");
	}else{
		alert("등록 가능합니다.")
		document.querySelector("[name=id]").value="<%=id %>"		
	}
}
</script>

		
	<h3>5-2단계</h3>
	<form>
		<input type="text" name="ckdate" placeholder="@@@-@@-@@ 형식으로 입력" />
		<input type="button" value="날짜확인" onclick="calcu()"/>
	</form>
	
	<%-- 5-2단계 --%>
	오늘로부터 며칠?<input type="date" name="indate"/>
	<input type="botton" value="날짜확인" onclick="calDate()">
	<h3 id="showDt"></h3>
	
	<script>
		function calDate(){
			var toDay = new Date()//오늘날짜
			var inDate = document.querySelector("[name=indate]").value.split("-") //입력된날짜를 split으로 처리
			
			var stDay = new Date(inDate[0], inDate[1]-1, inDate[2])
			var diff = toDay.getTime()-stDay.getTime()
			var dayCnt = Math.floor( diff/1000/60/60/24 ) //날짜수만 나올 수 있게 내림처리
			// console.log(dayCnt)
			// Math.abs(dayCnt) : Math.abs()//절대값처리  ==> 오늘 이전은 +, 오늘 이후는 -값  
			// ((dayCnt>0)?"전":"이후" : 오늘 이후는 -이므로 이후로 그외는 전)
			document.querySelector("#showDt").innerText = Math.abs(dayCnt)+"일  "+ ((dayCnt>0)?"전":"이후")
		}
	</script>
	
	
	<%-- 8 -3단계 --%>
	<table id="showw">
		<thead><tr><th>나라</th>승<th></th><th>무</th><th>패</th><th>승률</th></tr></thead>
		<tbody><tr><td>나라</td>승<td></td><td>무</td><td>패</td><td>승률</td></tr></tbody>
	</table>
	<script>
		//8 -3단계정답
		var hgrp = []
		hgrp.push({nat:"포르투갈", win:2, eq:0, def:1})
		hgrp.push({nat:"대한민국", win:1, eq:1, def:1})
		hgrp.push({nat:"우루과이", win:1, eq:1, def:1})
		hgrp.push({nat:"가나", win:0, eq:0, def:3})
		// console.log(hgrp) // 개체라도 데이터확인할 수 있어서 좋음
	
		hgrp.map(function(team){
			team.win = team.win+1
			team.winRatio = Math.round(team.win/(team.def+team.win)*100) //+"%"
			return team
		})
		//새로운 배열에 할당
		var hgrp = hgrp.filter(function(team){
			return team.winRatio>=50
		})
		var showw =""
		hgrp.forEach(function(t){
			showw+="<tr><td>"+t.nat+"</td><td>"+t.win+"</td><td>"+t.eq+"</td><td>"+t.def+"</td><td>"+t.winRatio+"%</td></tr>"
		})	
		document.querySelector("#fifa tbody").innerHTML = showw
		console.log(hgrp)
	</script>
	
	
	<span id="container02"></span>

    <div id="container"></div>   



</body>
<script type="text/javascript">

var div = document.querySelector("#container")
var show = ""

/*
4
getTime()를 통해서 1970/1/1 기준으로 1/1000시간을 가져올 수 있다
우리나라 GMT +9:00
*/

//5-1단계
var day1 = new Date(2022,11,01);
var day2 = new Date(2023,00,01);
var diff01 = day2.getTime()-day1.getTime()
show += "<h3>5-1단계</h3>"
show += "2022/12/01와 2023/01/01의 사이의 시간_ "+ parseInt(diff/1000/60/60)+"<br>"
show += "2022/12/01와 2023/01/01의 사이의 일수_ "+ parseInt(diff/1000/60/60/24)+"<br>"

//var span = document.querySelector("#container02")
//5-2단계
/*
var wrdate = document.querySelector("[name=ckdate]")

var today = new Date(); //오늘

function calcu(){
	var ckdatee = wrdate.value.split("-")
	var ckdateee = new Date ()
	var ckdatee = new Date(wrdate);
	var ckckdate = 
}

span.innerHTML = "<h4></h4>"
*/

/*
7
map(function(ele){return @@})은 배열의 구성요소를 return값으로 변경해서 새로운 구성요소로 만듦
filter(function(ele){return 조건})은 조건에 맞는 구성요소로 filtering해서 배열을 새로 만들어 처리
*/

//8 -1단계
var arry = []
for(var cnt=1;cnt<=5;cnt++){
	arry.push(Math.floor(Math.radom()*101))
}
show+= "5명의 국어점수_ "+arry+"<br>"

// 15% 점수를 올린 배열
var arr1 = arry.map(function(score){return Math.round(score*1.15)})
show+= "국어점수 15%▲_ "+arr1+"<br>"

//60점이상인 배열
var arr2 = arry.filter(function(score){return score>=60})
show+= "60점이상인 국어점수"+arr2+"<br>"
var arr3 = arr1.filter(function(score){return score>=60})
show+= "15%▲한 60점이상인 국어점수"+arr3+"<br>"

//8 -3단계
/*
var worldcup = []
worldcup.push({nation:"네덜란드", win:2, tie:1, loose:0})
worldcup.push({nation:"세네갈", win:2, tie:0, loose:1})
worldcup.push({nation:"에콰도르", win:1, tie:1, loose:1})
worldcup.push({nation:"카타르", win:0, tie:0, loose:3})

var worldcupA = worldcup.map(function(teamA){
	teamA.win = teamA.win+1
	return teamA;
})
var worldcupAA = worldcupA.filter(function(teamAA){
	teamAA.best = Math.floor(teamAA.win/(teamAA.win+teamAA.tie+teamAA.loose)*100)
	return teamAA.best>=50;
})

show +="<h3>A조 정보 승▲1 & 승률50%이상</h3>"
show += "<table><tr><th>나라</th><th>승</th><th>무</th><th>패</th></tr>"
worldcupAA.forEach(function(wc){

	show+="<tr>"
	for(var pro in wc){ // 객체 안에 속성을 가져올 수 있기에 반복문 처리
		if(pro%4==1) show+="<tr><td>"+wc[pro]+"</td>"
		show+="<td>"+wc[pro]+"</td>"
		if(pro%4==0) show+="<td>"+wc[pro]+"</td></tr>"
	}
})
show += "</table>"
*/



div.innerHTML+=show


</script>
</html>

