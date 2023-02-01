<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a14_study.*"    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 집</title>
<link href="/z02_study/comcom.css" rel="stylesheet">
</head>
<body>


<div id="page">
	<!--  <div id="head"></div> -->
	<div id="main">
		<div class="inner">
			<img src = "/z02_study/img/logo.png" width="155px" height="65px">
			<form>
				<input type="text" name="id" placeholder="아이디"  onblur="fcid()"/>
				<input type="password" name="pass" placeholder="비밀번호"  onblur="fcps()" />
				<input type="submit" value="로그인" name="login" onclick="loginck()">
			</form>
			<div class="setting">
				<a href="03_signup.jsp">비밀번호 재설정</a>
				<a href="03_signup.jsp">회원가입</a>
			</div>
			<span>SNS계정으로 간편 로그인/회원가입</span>
			<div class="sns">
				<a href="https://www.facebook.com/"><img src = "/z02_study/img/facebookk.png" width="60" height="60"></src></a>
				<a href="https://www.kakaocorp.com/page/"><img src = "/z02_study/img/kakao.png" target="_blank" width="60" height="60"></a>
				<a href="https://www.naver.com/"><img src ="/z02_study/img/naverr.png"  width="60" height="60"></a>
			</div>
		</div>
	</div>
	
	<%
		String id = request.getParameter("id"); if(id==null) id="";
		String pass = request.getParameter("pass"); if(pass==null) pass="";
		
		boolean isFail = false;
		if(id!=null&pass!=null){
			A01_Login dao = new A01_Login();
			if( dao.login(id, pass) ){
				response.sendRedirect("01_main.html");
			}else{
				isFail=true; //실패
			}
		}
	%>
</div>
<script type="text/javascript">

var idObj = document.querySelector("[name=id]")
var passObj = document.querySelector("[name=pass]")

var isFail = <%=isFail %> //로그인실패이면 true
function loginck(){ //function login()일때는 안됐는데 dao.login과 중복돼서 그런 듯
	if(isFail){
		alert("존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다");
		idObj.focus();
	}
}



//id
function fcid(){
	if(!idObj.value){
		idObj.style.border="1px solid red";
		idObj.style.boxShadow= "0 0 3px red";
	}else{
		true;
	}
}
idObj.onkeyup=function(){
	if(idObj.value){
		idObj.style.border="3px solid #B4E8F8";
		idObj.style.boxShadow="0 0 4px #B4E8F8";
	}
}

//password
function fcps(){
	if(!passObj.value){
		passObj.style.border="1px solid red";
		passObj.style.boxShadow= "0 0 3px red";
	}else{
		true;
	}
}
passObj.onkeyup=function(){
	if(passObj.value){
		passObj.style.border="3px solid #B4E8F8";
		passObj.style.boxShadow="0 0 4px #B4E8F8";
	}
}



</script>

</body>
</html>