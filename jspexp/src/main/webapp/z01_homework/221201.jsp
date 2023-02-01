<%-- 
2022-12-01
[1단계:개념] 1. 날짜객체(Date)의 기능메서드(년/월/일, 요일, 시간/분,초)를 기술하세요
[1단계:확인] 2. 현재날짜로 부터 2000시간 이후의 년도, 월, 일, 시간:분 형식으로 출력하세요.
[1단계:확인] 3. 기념일 계산 : 기준 년 [    ] 월[    ] 일[     ] 계산할 일수 : [select 100/500/1000] 이후 ==> 선택했을 때, 해당 날짜를 출력
[3단계:확인] 3. 기념일 계산 : 기준일 [    ] 계산할 일수 : [    ] [이전][이후]  기준일(type="date")은 default로 오늘 날짜가 년-월-일로 입력되고, 해당날짜를 입력 후, 버튼 클릭시, 기념을 계산할 날짜가 하단에 출력되게 하세요.
[1단계:개념] 4. 날짜의 기능메서드(년/월/일, 요일, 시간/분,초)를 기술하세요
[1단계:개념] 5. 전체 날짜 시간 기능메서드(형식 따른 내용) 기술하세요.
[1단계:개념] 6. include 액션태그와 include 지시자와 기능적인 차이점을 기술하세요.
[1단계:확인] 7. include 액션태그를 활용하여 하위페이지 z21_sub.jsp에 월드컵 B조별리그 1위 팀명과 승점을 전송해보세요
[1단계:확인] 8. include 지시자를 활용하여 메인헤서 최고 득점 선수 정보(국가, 이름, 점수) 정보를 form으로 입력하게 하고 하위페이지 z22_sub.jsp에서 요청값을 처리하고, 다시 메인에서 입력된 요청변수를 출력하게 하세요
[1단계:확인] 9. 2개 iframe을 활용하여 이름을 입력하게 하고 선택하게 하여 2개 팀에 선수를 나누어 출력하게 하세요.
[2단계:확인] 9. select[장바구니1/장바구니2]로 선택하게 하고 3X3 과일명을 리스트하고, 해당 과일명을 클릭시마다 포함된 장바구니1(iframe), 장바구니2(iframe)에 포함되게 하세요.
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
var div = document.querySelector("#container")

/*
1
toXXXString()  - ex)toLocaleString() : 해당 국가별 날짜/시간형식으로 출력
setXXX(입력값)	: 저장처리 메서드
getXXX() 		: 저장내용 가져오는 메서드
*/
*
//2
var today = new Date()
today.setDate(today.getHours()+2000)// 오늘부터 100일 이후
div.innerHTML+= "오늘로부터 2000시간 이후: "+ today.getFullYear()+"년 "+(today.getMonth()+1)+"월 "
				+today.getDate()+"일"+today.getHours()+"시간: "+today.getMinutes()+"분 "



</script>

</head>
<body>

	<div id="container"></div>
	
	<!-- 3 -->
	<h2>기념일 계산</h2>
	기준 년 <input type="text" name="year">
	월 <input type="text" name="month">
	일 <input type="text" name="day">
	<select>
		<option onclick="anni(0)">100</option>
		<option onclick="anni(1)">500</option>
		<option onclick="anni(2)">1000</option>
	</select>
	<span></span>
	
	<!-- 
	// 3-2정답 
		3. 기념일 계산 : 기준일 [    ] 계산할 일수 : [    ] [이전][이후]  기준일(type="date")은 
		default로 오늘 날짜가 년-월-일로 입력되고, 
		해당날짜를 입력 후, 버튼 클릭시, 기념을 계산할 날짜가 하단에 출력되게 하세요.
		처리순서
		1. 화면구현 : 입력/출력
		2. 이벤트 핸들러 선언
			1) 필요한 DOM객체 선언 : 기준일, 계산할 일
			2) 기준일 : 년-월-일 2022-12-02 ==> 년/월/일 분리 추출
				substring, split("-")
			3) Date()에 생성과 할당
				기능메서드 +,- setDate(getDate()+@@)
			4) 출력 DOM에 toLocaleString()	 
	-->
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
	
	
	
	<!-- 7 -->
	<h2>include액션태그</h2>
	<div style = "border:3px solid purple">
		<jsp:include page ="z21_sub.jsp">
			<jsp:param value="잉글랜드" name="nation"/>
			<jsp:param value="7" name="score"/>
		</jsp:include>
	</div>
	
	
	<!-- 8 -->
	<h2>include액션태그</h2>
	<h2>최고 득점 선수 정보</h2>
	<form>
		국가:<input type="text" name = "nation"/>
		이름:<input type="text" name = "player"/>
		점수:<input type="text" name = "score"/>
		<input type="submit" value="구매">
	</form>
	<div style="border:2px solid red;">
		<%@ include file ="z22_sub.jsp" %>
	</div>
	
	<h3>입력결과</h3>
	<h3>나라: <%=nation %></h3>
	<h3>선수: <%=player %></h3>
	<h3>점수: <%=score %></h3>
	
	
	<!-- 9-1 -->
	<style>iframe{border:3px solid red; width:40%; height:30%;}</style>
	
	<h2>선수이름 입력</h2>
	<input type="text" name="player">
	<input type="button" value="1팀 소속" onclick="in(0)">
	<input type="button" value="2팀 소속" onclick="in(1)"><br><br><br><br>
	<iframe name="team01" src="221201_sub01.jsp" ></iframe>
	<iframe name="team02" src="221201_sub02.jsp" ></iframe>
	
	<!-- 
	9-2 
	
	<table>
		<tr><td onclick="shop()">샤인머스캣</td><td onclick="shop()">포도</td><td onclick="shop()">거봉</td></tr>
		<tr><td onclick="shop()">귤</td><td onclick="shop()">자몽</td><td onclick="shop()">오렌지</td></tr>
		<tr><td onclick="shop()">단감</td><td onclick="shop()">곶감</td><td onclick="shop()">홍시</td></tr>
	</table>
	<select>
		<option name="basket1">장바구니1</option>
		<option name="basket2">장바구니2</option>
	</select>
	
	
	
	9-2정답
	장바구니1 (iframe - z23_sub.jsp)
	장바구니2 (iframe - z24_sub.jsp)
	1. 화면구현
	2. 이벤트처리
	-->
	<style>td{width:33%;height:33%}</style>
	<h2>두 개의 장바구니에 담기</h2>
	<select name="cart">
		<option value="cart1">장바구니1</option>
		<option value="cart2">장바구니2</option>
	</select>
	<table>
	<%
	String []fruits = {"사과", "바나나", "오렌지", "수박", "키위", "멜론", "자몽", "블루베리", "딸기"};
	for(int idx=0;idx<fruits.length;idx++){
		if(idx%3==0) out.print("<tr>");
		out.print("<td onclick='shop(this.innerText)'>"+fruits[idx]+"</td>");
		if(idx%3==2) out.print("</tr>");
	}
	%>
	</table>
	<iframe name="cart01" src="z23_sub.jsp" height="200px"></iframe>
	<iframe name="cart02" src="z24_sub.jsp" height="200px"></iframe>
	
<script type="text/javascript">

//9-1
function in(idx){
	var player = document.querySelector("[name=player]").value
	if(idx==0) team01.document.body.innerHTML+=player+", "
	if(idx==1) team02.document.body.innerHTML+=player+", "
}
//9-2
function shop(fruit){
	// alert(fruit)
	var chCart = document.querySelector("[name=cart]").value
	if(chCart == "cart1") cart01.document.body.innerHTML += fruit +", "
	if(chCart == "cart2") cart02.document.body.innerHTML += fruit +", "
}



</script>

<%-- 
2022-12-01

[1단계:확인] 9. 2개 iframe을 활용하여 이름을 입력하게 하고 선택하게 하여 2개 팀에 선수를 나누어 출력하게 하세요.
[2단계:확인] 9. select[장바구니1/장바구니2]로 선택하게 하고 3X3 과일명을 리스트하고, 해당 과일명을 클릭시마다 포함된 장바구니1(iframe), 장바구니2(iframe)에 포함되게 하세요.


--%>
	

</body>
<script type="text/javascript">
//3
function anni(idx){
					
	var stdate = new Date((Integer)year, (Integer)month, (Integer)day)
	if(idx==0) {
		stdate.setDate(stdate.getDate()+100)
		document.querySelector("span").innerText+=stdate.toLocaleString()
	}
	if(idx==1) {
		stdate.setDate(stdate.getDate()+500)
		document.querySelector("span").innerText+=stdate.toLocaleString()
	}
	if(idx==2) {
		stdate.setDate(stdate.getDate()+1000)
		document.querySelector("span").innerText+=stdate.toLocaleString()
	}
}
/*
4,5
toDateString(): Thu Dec 01 2022
toTimeString(): 18:10:53 GMT+0900 (한국 표준시)
toGMTString(): Thu, 01 Dec 2022 09:10:53 GMT
toISOString(): Thu Dec 01 2022
toUTCString(): Thu, 01 Dec 2022 09:10:53 GMT
*toLocaleString(): 2022. 12. 1. 오후 6:10:53
toLocaleDateString(): 2022. 12. 1.
toLocaleTimeString(): 오후 6:10:53	


6
jsp:include 액션태그는 다른 jsp 페이지에 실행 결과를 현재 위치에 삽입하고 별도의 파일의 요청 처리 흐름을 이동한다
					 request기본 객체나 <jsp:param>을 이용한 파라미터 전달한다
include 디렉티브(지시자)는 jsp파일을 자바 소스로 변환할 때 처리하고  현재 파일에 삽입시키며 페이지 내에 변수를 선언 후 변수에 값 저장한다
					   다수의 jsp페이지에서 공통으로 사용되는 변수를 지정하는 코드나 저작권과 같은 문장을 포함한다	
*/


</script>
</html>