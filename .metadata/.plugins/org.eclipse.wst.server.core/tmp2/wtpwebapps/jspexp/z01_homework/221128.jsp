<%-- 

2022-11-28
[1단계:개념] 1. [jsp] 세션 scope의 첫단계 객체 pageContext 는 어디까지 데이터가 유지 되는 것인가?
[1단계:확인] 2. [jsp] 물건가격과 갯수를 pageContext로 저장하고, 저장된 내용을 출력하되, 총계까지 출력하세요.
[1단계:확인] 3. [jsp] Dept정보를 pageContext범위로 저장하고 호출하세요.
[1단계:개념] 4. [jsp] application 범위를 설명하고 회원 아이디와 권한 이름을 설정하고 다른 페이지에서 호출하세요.
[1단계:확인] 5. [js] json형식의 객체로 월드컵의 팀명 소속조 승 무 패의 속성을 선언하고, for in 구문 테이블로 출력하세요.
[1단계:확인] 6. [js] 월드컵의 날짜와 시간별 팀1, 팀2의 일정을 출력하는 생성자형 객체를 선언하고, 오늘 한국/가나팀 일정계획을 출력하세요.
[1단계:확인] 7. [js] 위 내용을 내일일정 기준으로 여러 경기를 배열로 추가해서 출력하게 하세요.
[1단계:확인] 8. [js] class Product에 물건명과 가격을 선언하여 생성자를 통해 초기화하고 set get 메서드를 통해서 호출하고 저장하는
            필드를 은닉하여 처리하게 하세요.

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"   
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
페이지범위로 (페이지단위로)
--%>

<%
//2
pageContext.setAttribute("menu","치킨");
pageContext.setAttribute("price",21000);
pageContext.setAttribute("cnt",2);
%>
<h1>오늘 저녁은 <%=pageContext.getAttribute("menu") %> <%=pageContext.getAttribute("cnt") %>마리</h1>
<h1>가격은 <%=(Integer)pageContext.getAttribute("price")*(Integer)pageContext.getAttribute("cnt") %></h1>


<%
//3
pageContext.setAttribute("dpt", new Dept("총무부", 301,"전라남도 여수"));
%>
<%
Dept d = (Dept)pageContext.getAttribute("dpt");
%>
<h2>부서명: <%=d.getDname() %></h2>
<h2>부서번호: <%=d.getDeptno() %></h2>
<h2>부서위치: <%=d.getLoc() %></h2>

<%
//4 서버단위로 데이터 저장
application.setAttribute("id", "abcd2");
application.setAttribute("auth", "회원");
application.setAttribute("name", "박보검");
%>
<a href="221128_call.jsp">페이지 이동 호출</a>



	<div id="container"></div>

</body>
<script type="text/javascript">
var div = document.querySelector("#container")

// 5
var worldcup = [{nation:"대한민국" ,group:"H조" , win:0 , tie:1 , loose:0 },
				{nation:"포르투갈" ,group:"H조" , win:1 , tie:0 , loose:0 },
				{nation:"우루과이" ,group:"H조" , win:0 , tie:1 , loose:0 },
				{nation:"가나" ,group:"H조" , win:0 , tie:1 , loose:1 }
				]
for(var wc in worldcup){
	div.innerHTML+=wc+" - "+worldcup[wc]
}
/*
5번 정답
1) 속성/속성값 식별
2) for in 구문 문법확인
3) table 기본 형식에 데이터 입력 방식 처리
*/
var team = {tname:"한국" ,group:"H" , win:0 , eq:1 , def:1 , 
			record:function(){ //기능메서드로 출력
				var show = "<table><tr><th>팀명</th><th>조</th><th>승</th><th>무</th><th>패</th></tr>"
				show+="<tr>"
				// this는 선언한 team객체를 지칭하고 속성이나 기능메서드 호출할 때 사용
				
				for(var prop in this){//객체 안에서 선언할 때 this현재 객체를 지칭
					if(prop != "record"){
						show += "<td>"+this[prop]+"</td>"
					}
				}
				show+="</tr></table>"
				document.querySelector("#container").innerHTML = show
			} }
team.record()			


//6
function Schedule(teamF, teamS, time){
	this.teamF = teamF
	this.teamS = teamS
	this.time = time
	
	this.getSch = function(){
		div.innerHTML+="<h2>"+this.teamF+" vs "+this.teamS+" - 경기시간 : "+this.time+"</h2>"
	}
}
var today = new Schedule("대한민국","가나","11-28 22:00")
//today.getSch()

//7
var tomorrow = []
tomorrow.push(today)
tomorrow.push(new Schedule("브라질","스위스","11-29 01:00"))
tomorrow.push(new Schedule("포르투갈","우루과이","11-29 04:00"))
tomorrow.forEach(function(g){
	g.getSch()
})
/*
6번 정답
1) 속성설정
2) 출력한 내용 형식 지정
*/
function Schedulee(date, time, team01, team02){
	this.date =date
	this.time = time
	this.team01 = team01
	this.team02 = team02
	
	this.show=function(){
		//var shw = document.querySelector("#container")
		shw.innerHTML += "<h2>"+this.date+", "+this.time+", "+this.team01+" vs "+this.team02+"</h2>"
	}
}
var shc01 = new Schedulee("2022/11/28", "22:00", "대한민국", "가나")
shc01.show()
//7번
var shw = document.querySelector("#container")
shw.innerHTML="<h1>경기일정</h1>"
var schList = []
schList.push(new Schedulee("2022/11/30", "00:00", "에콰도르", "세네갈"))
schList.push(new Schedulee("2022/11/30", "00:00", "네덜란드", "카타르"))
schList.push(new Schedulee("2022/11/30", "04:00", "이란", "미국"))

schList.forEach(function(schedule){
	schedule.show
})


//8
class Product{
	construtor(pname, price){
		this._pname = pname
		this._price = price
	}
	get pname(){
		return this._pname;
	}
	set pname(pname){
		this._pname = pname;
	}
	get price(){
		return this._price;
	}
	set price(price){
		this._price = price;
	}
}
var prod = new Product("사과", 5000)
shw.innerHTML="<h1>"+prod.name+", "+prod.price+"</h1>"
prod.name ="바나나"; prod.price=2000
shw.innerHTML += "<h1>"+prod.name+", "+prod.price+"</h1>"

/*
8번정답
*/


</script>
</html>