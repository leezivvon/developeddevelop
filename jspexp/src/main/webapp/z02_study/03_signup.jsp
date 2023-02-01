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
		<img src = "/z02_study/img/logo.png" width="124px" height="52px" />
		<div class="inner02" >
			<h3>회원가입</h3>
			<span>SNS계정으로 간편 회원가입</span>
			<div class="sns">
				<a href="https://www.facebook.com/"><img src = "/z02_study/img/facebookk.png" width="55" height="55"></src></a>
				<a href="https://www.kakaocorp.com/page/"><img src = "/z02_study/img/kakao.png" target="_blank" width="55" height="55"></a>
				<a href="https://www.naver.com/"><img src ="/z02_study/img/naverr.png"  width="55" height="55"></a>
			</div>
			<br><hr><br>
			<h4>이메일</h4>
			<div id="email">
				<input type="text" name="email" placeholder="이메일" />
				<span style="color:#ccc;width:7px;">@</span>
				<select id="emadr">
					<option>선택해주세요</option>
					<option>naver.com</option>
					<option>hanmail.net</option>
					<option>daum.net</option>
					<option>gmail.com</option>
					<option>nate.com</option>
					<option>hotmail.com</option>
					<option>outlook.com</option>
					<option>icloud.com</option>
					<option>직접입력</option>
				</select><br>
				<span id="warning"></span>
				<input type="button" value="이메일 인증하기">
			</div>
			<br>	
			
			<h4>비밀번호</h4>
			<div id="pwdiv"> 
				<span>영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</span>
				<input type="password" name="pw" placeholder="비밀번호" />
				<span></span>
			</div>
			<br>
			
			<h4>비밀번호 확인</h4>
			<div id="pwcheckdiv"> 
				<input type="password" name="pw" placeholder="비밀번호 확인" />
				<span id="warning"></span>
			</div>
			<br>
			
			<h4>닉네임</h4>
			<div id="nicknamediv"> 
				<span>다른 유저와 겹치지 않도록 입력해주세요. (2~15자)</span>
				<input type="text" name="nickname" placeholder="별명(2~15자)" />
				<span id="warning"></span>
			</div>
			<br>
			
			<h4 >약관동의</h4>
			<div id="terms">
				<input type="checkbox" name="term" style="width:border"> 전체동의 	<span>선택항목에 대한 동의 포함</span><br>
				<hr>
				<input type="checkbox" name="term" > 만 14세 이상입니다	<span>필수</span><br>
				<input type="checkbox" name="term" > 이용약관 <span>필수</span><br>
				<input type="checkbox" name="term" > 개인정보수집 및 이용동의 <span>필수</span><br>
				<input type="checkbox" name="term" > 개인정보 마케팅 활용 동의 <span>선택</span><br>
				<input type="checkbox" name="term" > 이벤트,쿠폰, 특가 알림 메일 및 SNS 등 수신 <span>선택</span><br>
				<!-- 체크박스 -->
			</div>
			<br>
			<input type="button" value="회원가입하기">
			<div>이미 아이디가 있으신가요? <a href="/02_login.jsp">로그인</a></div>
		</div>
	</div>
	<div id="foot"></div>

</div>
<script type="text/javascript">


</script>

</body>
</html>