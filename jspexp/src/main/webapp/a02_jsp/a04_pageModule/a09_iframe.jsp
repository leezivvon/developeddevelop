<%@ 
	page language="java" contentType="text/html; charset=UTF-8"
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

<style>iframe{border:1px solid blue;}</style>

<h2>프레임포함</h2>
이름:<input type="text" name="name">
<input type="button" value="프레임1에 전송" onclick="go(0)">
<input type="button" value="프레임2에 전송" onclick="go(1)"><br>

<iframe name="frame01" src ="a10_sub.jsp" width="47%" height="50%"></iframe>
<iframe name="frame02" src ="a11_sub.jsp" width="47%" height="50%"></iframe>



</body>
<script type="text/javascript">
function go(idx){
	// iframe으로 데이터를 화면별로 전송하는 것은 서버와 관련이 없이 현재 로딩된 js,html을 이용해서 DOM으로 접근하여 처리하는 것이다.
	// DOM(document object model)
	
	//var fr = document.querySelectorAll("iframe")
	//alert(fr[idx].document.body.innerHTML)
	//alert(fr)
	//frame, href에서 호출되는 객체는 BOM(browser object model)
	//DOM객체(document object model)의 상위 객체로 bom명.document.querySelector("포함된 객체 접근")
	
	var nameVal = this.document.querySelector("[name=name]").value //프론트단에서 전달
	//this.현재페이지 BOM을 지칭
	
//	if(idx==0) frame01.document.querySelector("h2").innerText+=nameVal+"<br>"
	if(idx==0){
		frame01.document.body.innerHTML+=nameVal+"<br>" 
		frame01.document.querySelector("[name=call]").value+=nameVal+"^^" 
	}
	if(idx==1) frame02.document.body.innerHTML+=nameVal+"<br>"
}



//ex) a12_main.jsp
/*
16강 확정팀 [		] [1번] [2번]	 [3번]
번호대로 해당 팀이 할당되게 하세요(frame 할당처리)
frame1 팀1 - 팀2		a13_sub.jsp
frame2 팀1 - 팀2 		a14_sub.jsp
frame3 팀1 - 팀2 		a15_sub.jsp
*/
</script>
</html>