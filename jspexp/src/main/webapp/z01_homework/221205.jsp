<%-- 
2022-12-05
[1단계:개념] 1. JSON객체의 형변환메서드 2개의 기능을 예제를 통해서 기술하세요.
[1단계:확인] 2. 임의의 구구단 출력 h2로 출력 eval함수를 활용하여 3X3 테이블에  0~9 정답확인 문자열 생성
            @@@ X @@  = ?
            테이블 ==> cell 클릭시 ?에 입력될 숫자를 출력하고,
            정답확인 버튼 클릭시 출력되게 처리. 정답여부를 출력되게 하세요
[1단계:개념] 3. DOM의 선택자의 종류와 출력기능 속성을 구분하여 기술하세요.
[1단계:확인] 4. 4X4 테이블을 1~16까지 출력하고, 가장 밑라인 클래스로 cls01은 배경색상을 노랑색 ,  왼쪽라인 클래스로 cls02 글자색상을 파랑색, 
      왼쪽라인 클래스로 cls03 빙고라고 표시, 위쪽 라인은 클래스로 cls04 처리하고 글자를 오른쪽 정렬 처리 처리되게 하세요.
[1단계:개념] 5. DOM의 css 속성과 일반 속성의 차이점을 기술하세요.
[1단계:개념] 6. DOM의 innerText와 innerHTML의 차이점을 기술하세요.
[1단계:확인] 7. 5X5 테이블을 임의의 25개 숫자(0~100)로 출력하고, 이 중 짝수 열의 글자색상을 파랑색으로 출력하세요.
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

<%-- 2 --%>
<h2>구구단출력</h2>
<h2 id="quiz"></h2>
<table id="tab01">
	<tr><td>7</td><td>8</td><td>9</td></tr>
	<tr><td>4</td><td>5</td><td>6</td></tr>
	<tr><td>1</td><td>2</td><td>3</td></tr>
	<tr colspan="3"><td>0</td></tr>
</table>
<input type="button" value="정답확인" onclick="calcu()">

<%-- 
2정답 
4X3테이블로 변경ㅋ 
1) 화면구현
	// -문제출력 h2, ?(정답입력 출력 내용 span)
	-테이블구현
		0~9 상단에 문제출력 td, 입력한 정답출력 td, 초기화 td(C), 정답확인 td
2) DOM 객체 선언 및 임의의 문제출력
	// var gugu = document.querySelector("h3")
	// var inNum = document.querySelector("span")
	var tds = document.querySelectorAll("#tb01 td")
	var gugu = tds[0]
	var inNum = tds[1]
	ranGugu(); //초기문제
	var corNum = 0;
	function ranGugu(){
		var grade = Math.floor(Math.random()*8+2)
		var cnt = Math.floor(Math.random()*9+1)
		var corNum = grade*cnt
		gugu.innerText = grade + " X " + cnt
	}
3) 이벤트 처리(익명)
	- 클릭 시 ?에 입력한 숫자 출력
	
	for(var idx=0;idx<tds.length;idx++){
		tds[idx].onclick=function(){
			
			if( this.innerText=="정답확인"){
				//입력한 내용과 정답여부가 같은지 
				if(inNum.innerText==corNum){
					alert("정답\n다음문제")
				}else{
					alert("오답\n다시 풀어보세요")
					inNum.innerText=""
				}
			}else{
				// 번호를 클릭 시 입력한 내용을 출력하는 곳에 출력 처리
				inNum.innerText += tds[idx].innerText	
				if( this.innerText=="C") inNum.innerText="" //"0"
			}
		}
	}
	- 정답여부 클릭 시 입력한 숫자와 정답인지 확인
	- 다음 문제
--%>
<h2>구구단출력2</h2>
<table id="tb01">
	<col width="33%"><col width="33%"><col width="33%">
	<tr style="height:40px"><td colspan="2">@@X@@</td><td>0</td></tr>
	<tr><td>7</td><td>8</td><td>9</td></tr>
	<tr><td>4</td><td>5</td><td>6</td></tr>
	<tr><td>1</td><td>2</td><td>3</td></tr>
	<tr><td>C</td><td>0</td><td>정답확인</td></tr>
</table>

<script>
	var tds = document.querySelectorAll("#tb01 td")
	//var gugu = tds[0]
	//var inNum = tds[1]
	ranGugu(); //초기문제
	var corNum = 0;
	function ranGugu(){
		var grade = Math.floor(Math.random()*8+2)
		var cnt = Math.floor(Math.random()*9+1)
		corNum = grade*cnt
		tds[0].innerText = grade + " X " + cnt
	}
	
	//이벤트처리
	for(var idx=0;idx<tds.length;idx++){
		tds[idx].onclick=function(){
			if( this.innerText=="정답확인"){
				//입력한 내용과 정답여부가 같은지 
				if(tds[1].innerText==corNum){
					alert("정답\n다음문제");
					ranGugu();
				}else{
					alert("오답\n다시 풀어보세요");	
				}
				tds[1].innerText="";
			}else{
				// 번호를 클릭 시 입력한 내용을 출력하는 곳에 출력 처리
				tds[1].innerText += this.innerText	
				if( this.innerText=="C") tds[1].innerText="" //"0"
			}
		}
	}
</script>

<%-- 4 --%>
<table>
	<tr><td class="cls02">1</td><td  class="cls04">2</td><td  class="cls04">3</td><td  class="cls03">4</td></tr>
	<tr><td class="cls02">5</td><td>6</td><td>7</td><td  class="cls03">8</td></tr>
	<tr><td class="cls02">9</td><td>10</td><td>11</td><td  class="cls03">12</td></tr>
	<tr><td class="cls01" >13</td><td class="cls01">14</td><td class="cls01">15</td><td class="cls01">16</td></tr>
</table>
<%-- 
4정답
1) 화면구현
	<td class="cls01">
	<td class="cls02 cls03"> : 동일한 요소객체에 클래스가 중첩적으로 적용될때
	<td class="cls04">
	
	<table id="tb02">
		<col width="25%"><col width="25%"><col width="25%"><col width="25%">
		<tr><td class="cls04"></td><td  class="cls04"></td><td  class="cls04"></td><td  class="cls04"></td></tr>
		<tr><td class="cls02 cls03"></td><td>6</td><td></td><td></td></tr>
		<tr><td class="cls02 cls03"></td><td>10</td><td></td><td></td></tr>
		<tr><td class="cls01" ></td><td class="cls01"></td><td class="cls01"></td><td class="cls01"></td></tr>
	</table>
2) DOM객체 호출
	var tds2 =document.querySelectorAll("#tb02 td")
	var cls01 = document.querySelectorAll(".cls01")
	var cls02 = document.querySelectorAll(".cls02")
	var cls03 = document.querySelectorAll(".cls03")
	var cls04 = document.querySelectorAll(".cls04")
	
	for(var idx=0;idx<tds2.length;idx++){
		tds2[idx].innerText=idx+1+"번째"
	}
	for(var idx=0;idx<cls01.length;idx++){
		cls01[idx].style.background="yellow"
	}
	for(var idx=0;idx<cls02.length;idx++){
		cls02[idx].style.color="blue"
	}
	for(var idx=0;idx<cls03.length;idx++){
		cls03[idx].innerText="빙고"
	}
	for(var idx=0;idx<cls04.length;idx++){
		cls04[idx].style.textAlign="right"
	}
 --%>

<%-- 7 --%>
<table id="tab02">
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
</table>
<%-- 
7 
1. 화면구현
2. DOM객체 선택
	var tds3 = document.querySelectorAll("#tb03 td")
	var tdsEven = document.querySelectorAll("#tb03 td:nth-child(2n)")
	for(var idx=0;idx<tds3.length;idx++){
		tds3[idx].innerText = Math.floor(Math.random()*101);
	}
	for(var idx=0;idx<tdsEven.length;idx++){
		tdsEven[idx].style.color = "blue"
	}
--%>

</body>
<script type="text/javascript">
/*
 1
 JSON.parse()
 JSON.stringify() 
*/

//2
<%-- 
2022-12-05
[1단계:확인] 2. 임의의 구구단 출력 h2로 출력 eval함수를 활용하여 3X3 테이블에  0~9 정답확인 문자열 생성
            @@@ X @@  = ?
            테이블 ==> cell 클릭시 ?에 입력될 숫자를 출력하고,
            정답확인 버튼 클릭시 출력되게 처리. 정답여부를 출력되게 하세요
--%>
var q = document.querySelector("#quiz");
var tds = document.querySelectorAll("#tab01 td")
var write = ""

var num01 = Math.floor(Math.random()*8+1);
var num02 = Math.floor(Math.random()*8+1);
var qa = num01*num02
q.innerHTML += num01+" X "+num02+" = "

for(var idx=0;idx<tds.length;idx++){
	tds[idx].onclick=function(){
		write += this.innerText
		q.innerHTML+=this.innerText
	}
}
function calcu(){
	eval(write)==qa?alert("정답입니다"):alert("오답입니다");
}

/*
3
DOM의 선택자
-css의 선택자를 통하여 객체를 선택할 수 있다
	태그, #아이디, .클래스	: document.querySelector("h1")
- 단일
	var ch01 = document.querySelector("#ch01")
- 다중선택
	var cls01 = document.querySelectorAll(".cls01")
- 이외에도 복합선택자, [속성=속성값] 등 css의 선택자를 활용하여 선택자 처리를 할 수 있다	

DOM객체의 속성
1) 출력
	.innerHTML : 화면에 출력할 내용을 랜더링(html적용)한 내용의 태그를 가져오거나 처리하는 속성
	.innerText : 화면에 출력할 내용을 html적용하지 않는 순서한 내용 자체를 가져오거나 랜더링하지 않는 속성 
2) 기본 속성
	.속성 = 속성값 : 태그가 가지고 있는 기본 속성을 읽어 오거나 설정할 수 있다
3) style 속성
	.style.속성 = 속성값 : css속성이 적용된 내용을 설정할 수 있다
4) form 요소객체 속성
	.value = "값" : 데이터의 입력 처리를 할 때 form하위 객체의 요소는 value를 통해서 효과적으로 처리할 수 있다
*/

//4
	var cls1 = document.querySelectorAll(".cls01")
	var cls2 = document.querySelectorAll(".cls02")
	var cls3 = document.querySelectorAll(".cls03")
	var cls4 = document.querySelectorAll(".cls04")
	cls1[0].style.background="yellow"
	cls1[1].style.background="yellow"
	cls1[2].style.background="yellow"
	cls1[3].style.background="yellow"
	cls2[0].style.color="blue"
	cls2[1].style.color="blue"
	cls2[2].style.color="blue"
	cls1[0].style.color="blue"
	cls3[0].innerText="빙고"
	cls3[1].innerText="빙고"
	cls3[2].innerText="빙고"
	cls1[3].innerText="빙고"
	cls4[0].style.textAlign="center"
	cls4[1].style.textAlign="center"
	cls2[0].style.textAlign="center"
	cls3[0].style.textAlign="center"
	
	

/*
5. dom객체의 선택자 css의 선택자를 통하여 객체를 선택할 수 있다 >>태그, #아이디, .클래스
6.  .innerHTML : 화면에 출력할 내용을 랜더링(html적용)한 내용의 태그를 가져오거나 처리하는 속성
	.innerText : 화면에 출력할 내용을 html적용하지 않는 순서한 내용 자체를 가져오거나 랜더링하지 않는 속성 
*/

//7
var t2 = document.querySelectorAll("#tab02 td")
for(idx=0;idx<t2.length;idx++){
	t2[idx].innerText += Math.floor(Math.random()*101);
	if(idx%2==1) t2[idx].style.color ="blue"
}

</script>
</html>