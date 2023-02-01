<%--
2022-12-07
[1단계:개념] 1. 쿠키값의 생명주기(생성,변경,소멸)을 서버와 클라이언트 위치와 관계에서 코드와 함께 설명하세요.
[1단계:확인] 2. 쿠키값(coffee/americano)로 설정 후, 페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:확인] 3. 쿠키값(coffee/vanilla)로 변경후, 페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:확인] 4. 쿠키값(커피) 삭제 후,  페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:개념] 5. form 요소객체의 주요 속성을 기술하세요.
[1단계:확인] 6. 오늘 월드컵 대전 팀과 결과를 날짜/팀1/팀2/결과를 입력해서 테이블로 추가리스트 되게 처리하세요.
[1단계:확인] 7. 가위/바위/보를 select로 선택하게 하고, 컴퓨터와 play를 클릭해서, 나의 선택과 컴퓨터 선택 결과가 나와서 승/무/패가 출력되게 하세요.
[1단계:확인] 8. [@@][select +,-,*,/][@@] [결과확인] 임의의 숫자 두개가 나오고 연산자의 선택하고 결과확인에 따라 연산처리결과가 하단에 h2로 출력되게 하세요

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
<쿠키의 생성> Cookie c1 = new Cookie("쿠키의 이름", "쿠키의 값")
		   쿠키는 클라이언트에서 요청에 의해서 서버 안에서 객체를 생성하여 response객체에 쿠키를 추가하여 클라이언트에 보내지면 클라이언트(브라우저)에서 지정한 경로에 저장이 된다
<쿠키의 변경> 	response.addCookie(c);
		    쿠키가 서버에서 생성되어 클라이언트에 저장되면 다시 요청객체 request에 의해 서버에 보내지면서 쿠키값을 key/value형식으로 호출하여 사용할 수 있다
			쿠키는 동일한 키로 addCookie로 할당하면 동일한 키로 설정된 내용을 변경해준다
<쿠키의 소멸> setMaxAge(0); response.addCookie(참조변수); 
		    쿠키는 서버에서 해당 쿠키의 키명으로 유효시간으로 기능메서드로 설정하여 다시 클라이언트로 보내지면 해당 시간이 클라이언트 안에서 사라지게 된다
--%>
<%--
2022-12-07
[1단계:확인] 2. 쿠키값(coffee/americano)로 설정 후, 페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:확인] 3. 쿠키값(coffee/vanilla)로 변경후, 페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:확인] 4. 쿠키값(커피) 삭제 후,  페이지 링크로 설정된 쿠키값을 리스트하세요.
--%>

<%--
5
 form하위 요소객체의 특징
	1) 선택자 : name, id
		document.querySelector("[name=속성값]")
		document.querySelector("#아이디명")
	2) 속성값변경 : value를 통해서 처리
		dom01.value
		dom01.value = "할당처리"
--%>
<!-- 6 -->
	<h2>월드컵 대전 팀과 결과</h2>
	날짜 <input type="date" name="gdate" value="2022-12-7"/><br>
	팀1 <input type="text" name="team1"/>
	팀2 <input type="text" name="team2"/>
	결과 <input type="text" name="result"/>
	<input type="button" value="등록" onclick="reg()">
	<table id="tb01">
	<thead>
		<tr><th>날짜</th><th>팀1vs팀2</th><th>결과</th></tr>
	</thead>
	<tbody></tbody>
	</table>
	
	<!-- 7 -->
	<select>
		<option value="1">가위</option>
		<option value="2">바위</option>
		<option value="3">보</option>
	</select>
	<input type="button" value="컴퓨터와 play" onclick="play()"/>
	<table id="result">
	<thead>
		<tr><th>컴퓨터vs나</th><th>결과</th></tr>
	</thead>
	<tbody></tbody>
	</table>
	
	
	<!-- 8 --><br>
	<table>
	<tr>
	<td name= "num01"></td>
	<td>
	<select name="sl02">
		<option value="0" >+</option>
		<option value="1">-</option>
		<option value="2">x</option>
		<option value="3">/</option>
	</select>
	</td>
	<td name= "num02"></td>
	<td><input type="button" value="결과확인" onclick="result()"/></td>
	</tr>
	</table>
	
	
	
</body>
<script type="text/javascript">
	//8
	var slObj = document.querySelector("[name=sl02]")
	var options = document.querySelector("[name=sl02]>option")
	var num01Obj = document.querySelector("[name=num01]")
	var num02Obj = document.querySelector("[name=num02]")
	
	num01Ob.value = Math.floor(Math.random()*90+10)
	num02Ob.value = Math.floor(Math.random()*90+10)
	
	var rIdx = Math.floor(Math.random()*4);
	for(var idx=0;idx<options.length;idx++){
		if(rIdx==idx){
			//selected선택되어진것에 대한 속성 설정  ???????????ㄴ
			options[idx].selected=true;
		}
	}
	//num01Obj.innerHTML = rnum1
	//num02Obj.innerHTML = rnum2
	function result(){
		var num01 = num01Ob.value
		var num02 = num02Ob.value
		var cIx = claOb.value
		var cals = [num01+num02, num01-num02, num01*num02, num01/num02]
		var cal = [" + ", " - ", " X ", " / "]
		// h23Obj.innerHTML=eval(rnum1+slObj[this].value+rnum2)
		alert(num01+cal[cIx]+num02+" = "+calR[cix])
	}
	
	//7
	var sObj = document.querySelector("[value=1]")
	var rObj = document.querySelector("[value=2]")
	var pObj = document.querySelector("[value=3]")
	var ptObj = document.querySelector("#result")
	var cRSP = Math.floor(Math.random()*3+1)
	function play(){
		
	}
	//6
	var gdObj = document.querySelector("[name=gdate]"); 
	var t1Obj = document.querySelector("[name=team1]"); 
	var t2Obj = document.querySelector("[name=team2]"); 
	var rsObj = document.querySelector("[name=result]"); 
	var tbObj = document.querySelector("#tb01 tbody"); 
	function reg(){
		tbObj.innerHTML += "<tr><td>"+gdObj.value
						+"</td><td>"+t1Obj.value+"vs"+t2Obj.value
						+"</td><td>"+rsObj.value+"</td></tr>";
		t1Obj.value=""; t1Obj.focus();		
		t2Obj.value=""; rsObj.value="";
	}
	
	
	
	
	
</script>
</html>