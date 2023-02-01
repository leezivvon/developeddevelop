<%-- 
2022-11-14
[1단계:개념] 1. javascript의 출력형식과 입력 형식 함수를 기술하세요.
[1단계:개념] 2. DOM 객체를 단일객체와 다중 객체의 차이점을 기술하세요.
[1단계:확인] 3. js(javascript)의 입력창으로 물건명, 가격, 갯수를 입력받아서, 화면에 출력해보세요. 
[1단계:확인] 4. 70점 이상입니까?라는 confirm 입력 받아서 내용에 따라 합격/불합격을 화면에 출력하세요.
[1단계:확인] 5. 테이블 3X3을 만들고, DOM을 활용하여 1행1열 1행2열 1행3열. 9개의 td의 내용을 출력하세요.
[1단계:확인] 6. 위 내용을 열마다 물건명 가격 갯수 class를 따로 선언하여 선택자로 물건명 가격 갯수가 3개 나오게 출력하세요.
[1단계:개념] 7. jsp에서 scriptlet와 expression의 차이를 기술하세요.
[1단계:확인] 8. 부서정보 VO을 클래스로 선언하고, 화면에 부서정보를 출력하세요.
[1단계:확인] 9. 배열로 선수명3개, 선수성적3개, 소속팀3개를 선언하고 for문에 의해 테이블로 출력하세요.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.vo.Dept"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table{border-collapse:collapse;}
		td{text-align:center;}
	</style>
</head>
<body>
<%-- 
1. 
  	<%
	// 입력형식
	String name ="홍길동"; // java
	int age = 25;
	String loc="서울";
	%>
	//출력형식
	<h2>이름:<%=name %></h2>
	<h2>나이:<%=age %></h2>
	<h2>거주지:<%=loc %></h2>
	
	2.
	DOM객체는 문서 객체 모델로 XML이나 HTML 문서에 접근하기 위한 일종의 인터페이스.
	단일객체 인식 : var obj01 = document.querySelector("선택자")
		단일 객체 선언하고 할당하며 여러 개 선언되어 있더라도 첫번재 하나만 처리한다
		#아이디명 형식으로 단일 내용을 선택자로 해서 처리할 때 주로 사용된다
	다중 객체 인식 : var array = document.querySelectorAll("선택자")
		하나가 아닌 여러개 객체를 선언하고 각각의 DOM객체에 대한 속성을 따로따로 처리해야 할 때 활용된다
		// array[0].innerText="첫번째", array[1].innerText="두번째"
		cf) css에서 사용하는 선택자를 이용하여 단일 객체에 대한 처리와 다중객체에 대한 처리를 할 수 있다
--%>

	<%-- 3 --%>
	<%
		String pname="아이스아메리카노";
		int price=1500;
		int cnt=7;
	%>
	<h4>3번</h4>
	<p>
		주문하신 <%=pname %> <%=cnt %>잔 나왔습니다<br>
		한 잔에 <%=price %>원으로 총 <%=price*cnt %>원 결제 도와드리겠습니다~!
	</p><br>
	<%-- 3번 정답 
	<h3>물건 정보 입력</h3>
	<table id="prodTab" width="50%" border>
		<tr><th>물건명</th><td></td></tr>
		<tr><th>가격</th><td></td></tr>
		<tr><th>개수</th><td></td></tr>
		<tr><th>총계</th><td></td></tr>
	</table>
	<script type="text/javascript">
		var pname = prompt("물건명","")
		var price = prompt("가격입력","0")
		var cnt = prompt("개수입력","0")
		var tds=document.querySelectorAll("#prodTab td") // 자손객체
		tds[0].innerText = pname;
		tds[1].innerText = price;
		tds[2].innerText = cnt;
		tds[3].innerText = price*cnt; // js에서 +(덧셈)연산자 이외는 자동형변환을 해준다
	</script>
	--%>
	
	
	<%-- 4 --%>
	<h4>4번</h4>
	<h3>합격여부</h3>
	
	<%-- 5 --%>
	<h4>5번(표를 클릭하세요)</h4>
	<table id="tab02" width="50%" height="300px" onclick="call05()" border>
		<tr><td></td><td></td><td></td></tr>
		<tr><td></td><td></td><td></td></tr>
		<tr><td></td><td></td><td></td></tr>
	</table><br>
	
	<%-- 6 --%>
	<h4>6번</h4>
	위 내용을 열마다 물건명 가격 갯수 class를 따로 선언하여 선택자로 물건명 가격 갯수가 3개 나오게 출력하세요.
	
	<table width="50%" height="50px" border>
		<tr class="cls1"><td></td><td></td><td></td></tr>
		<tr class="cls2"><td></td><td></td><td></td></tr>
		<tr class="cls3"><td></td><td></td><td></td></tr>
	</table>
	<%-- 6정답 --%>
	<table id="tab03" width="50%" height="300px" border>
		<tr><th>물건명</th><th>가격</th><th>개수</th></tr>
		<tr><td class="pname"></td><td class="price"></td><td class="cnt"></td></tr>
		<tr><td class="pname"></td><td class="price"></td><td class="cnt"></td></tr>
		<tr><td class="pname"></td><td class="price"></td><td class="cnt"></td></tr>
	</table><br>
	
	<%-- 
	7 
	// scriptlet : <% %> : 입력
	// 표현(expression) : <%=%> :출력 
	--%>
	
	<%-- 8 --%>
	<h4>8번</h4>
<%
	Dept d = new Dept("인사과", 701, "서울 용산구");
%>
	<table width="50%" style="border-collapse:collapse" border>
		<tr><th>부서명</th><td><%=d.getDname() %></td></tr>
		<tr><th>부서번호</th><td><%=d.getDeptno() %></td></tr>
		<tr><th>부서위치</th><td><%=d.getLoc() %></td></tr>
	</table>
	
	<%-- 9 --%>
	<h4>9번</h4>
<%
	String []plname ={"이야구", "김야구", "박야구"};
	double []score ={0.35, 0.21, 0.53};
	String []pcom ={"LG", "롯데", "SSG"};
	//서버단에서 만들어지는거라고? 그냥 다~ 모르겠다~!!!!!!
	//log로 오류먼저 확인해본대 시발라ㅏ자바라시발
	for(int idx=0;idx<plname.length;idx++){
		log(plname[idx]+":"+pcom[idx]+":"+score[idx]);
	}
	
%>
	<table width="50%" height="300px" border>
		<tr><th>선수명</th><th>성적</th><th>소속팀</th></tr>
		<%for(int idx=0;idx<plname.length;idx++){ %>
		<tr><td><%=plname[idx] %></td><td><%=score[idx] %></td><td><%=pcom[idx] %></td></tr>
		<%} %>
	</table>
	
	
</body>
<script type="text/javascript">
	// 4번
	var isPass = confirm("70점이상입니끼?");
	document.querySelector("h3").innerText="결과: "+(isPass?"합격":"불합격");
	
	// 5번
	function call05(){
		var arr05 = document.querySelectorAll("#tab02 td") //DOM객체를 배열로 받아서
		// index번호로 접근해서 innerText 속성을 이용해서 값을 할당 처리
			arr05[0].innerText="1행1열";
			arr05[1].innerText="1행2열";
			arr05[2].innerText="1행3열";
			arr05[3].innerText="2행1열";
			arr05[4].innerText="2행2열";
			arr05[5].innerText="2행3열";
			arr05[6].innerText="3행1열"
			arr05[7].innerText="3행2열"
			arr05[8].innerText="3행3열"
	}
	
	// 6번
	document.querySelector(".cls1").innerText={"딸기", "4000", "1"}
	// 6번정답
	var pnames = document.querySelectorAll("#tab03 .pname"); // DOM객체를 배열로 받아서
	var prices = document.querySelectorAll("#tab03 .price");
	var cnts = document.querySelectorAll("#tab03 .cnt");
	
	pnames[0].innertText="사과";pnames[1].innertText="바나나";pnames[2].innertText="딸기";
	//클래스 단위로 접근하기때문에 클래스마다 0 index부터 다시 시작
	prices[0].innertText="1200";prices[1].innertText="4000";prices[2].innertText="9000";
	cnts[0].innertText="1";cnts[1].innertText="2";cnts[2].innertText="3";
	
	
	
</script>

</html>