<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--
2023-01-09
[1단계:개념] 1. MVC패턴으로 ajax를 구현할려고 한다. 주요 자바프로그램과 프로세스를 설명하세요
            controller, service, view
[1단계:개념] 2. Gson lib는 어떤 역할을 하는지 예제를 통해서 설명하세요
[1단계:개념] 3. controller의 PrintWriter out =response.getWriter();는 어떤 역할을 하는가?
[1단계:확인] 4. 회원등록form을 로딩하고, id중복여부를 확인하는 기능을 처리하는 MVC ajax를 구현하세요.
           기존 dao에서 검색메서드 활용
[1단계:개념] 5. 스프링 환경 설정을 위한 순서를 기술하세요
[1단계:개념] 6. dispather.xml와 web.xml의 역할을 기술하세요.
[1단계:확인] 7. 다이나믹 웹프로젝트로 springweb2로 만들고, 스프링의 front단과 컨트롤러를 등록하고 backend를 호출하세요.
            ppt자료 작성 및 제출
[1단계:개념] 8. 오늘 한 예제 밑에 바로 및에 기능 메서드 추가하여 start2.do로 a02_start.jsp가 호출되는 예제를 작성하세요.



1
-프로세스
1) 초기 화면 로딩 : html
2) key이벤트에 의해서 ajax호출(요청값 전달)
3) controller단에서 요청값 전달 
4) 전달할 json문자열 만들기(List객체 ==> json문자열)
5) client단에서 받은 json문자열 객체로 변환 : JSON.parse()
6) js반복 처리로 출력 처리

controller 	// 요청값 처리, 서비스호출(json) //view초기화면 
service 	// dao
view		// html



2
Gson lib의 역할은 Json 문자열로 변환하는 역할을 한다



3
controller의 PrintWriter out =response.getWriter();는
Servlet에서 클라이언트의 요청(Request)에 대한 응답(Response) 형태는 문자(character)이고 해당 형태로 응답하려면
데이터의 흐름(Stream)을 컨트롤 해야 한다. 즉 텍스트(==문자) 형태로 응답을 보내도록 설정해야 한다.
HttpServletResponse 인터페이스의 상위 인터페이스인 ServletResponse의 getWriter() 메소드를 호출하면 스트림에 텍스트를 기록하는 것이 가능하다.

5. 
스프링 환경 설정 순서
1) 단계별 스프링 환경
	- 1단계 : dynamic web project기반 스프링환경 설정
	- 2단계 : sts(spring tool suits) 툴을 이용한 스트링부트 활용
2) lib : 필요한 jar파일 복사
3) 컨테이너 설정
	스피링 핵심(core) 처리로 xml파일로 설정한다 (dispatcher-servlet.xml)
	src\main\webapp\WEB-INF가 default설정 위치	
4) web.xml설정
	스프링 프레임워크 시작 front-controller설정 dispatcherservlet(프레임워크 지원 클래스)	
		- 위 컨테이너 설정의 위치를 변경할 수 있다
	요청값(get/post)의 한글 처리를 위한 filtering선언(프레임워크 지원 클래스)	
5) MVC처리를 위한 사용자 정의 controller/service/dao선언
	view단 선언 : WEB-INF하위에 보안폴더로 jsp/html호출
6) 기타 front 프레임워크 및 lib설정
	-boot strap설정
	-jquery설정
7) 초기 view단에서 위 front단 프레임워크 lib호출 처리


6.**질문 dispatcher.xml와 web.xml의 역할을 기술하세요.





// 정답풀이
4. 회원등록form을 로딩하고, id중복여부를 확인하는 기능을 처리하는 MVC ajax를 구현하세요.
           기존 dao에서 검색메서드 활용
 	view >> controller >>
 	          
controller
	A13_MemberController.java(/member.do)
	
	String id = request.getParameter("id");
	if(id==null){
		request.getRequestDispatcher("WEB-INF\a01_mvc\a13_memberReg.html").forward(request, response);
	}else{
		// null값이 아니면 service단에서..(=dao에서.. )
		PrintWriter out = request.getPrintWriter()
		out.print(service.chcekId(id))
	}
	
	
	
service
	A14_MemberService.java, A06_PareparedDao.java(checkId(String id))    
	
	public boolean checkIdJson(String id){
		return dao.checkId(id);
	}



view
	WEB-INF\a01_mvc\a13_memberReg.html
	<h2>회원등록</h2>
		아이디<input type="text" name="id"/>
		<input type="button" value="등록여부확인" id="chIdBtn"/>
		<input type="hidden" id="passIdck" value="false">
<script>
	var idObj = document.querySelector("[name=id]")	
	var chIdBtn = document.querySelector("#chIdBtn")	
	var passIdckbj = document.querySelector("#passIdck")	
	
	
	idObj.onkeyup=function(){
		// 글자 유효성 check(8~18)
		if(event.keyCode==13){
			validChk();
		}
	}	
	chIdBtn.onclick=validChk();	
	function validChk(){
		var idVal = idObj.value;
		if(idVal>=8 && idVal<=18 ){
			idCkAjax()
		}else{
			alert("등록할 아이디는 8~18가능합니다")
		}
	}
	
	
	function idCkAjax(){
		var xhr = new XMLHttpRequest();
		xhr.open("get", "/member.do", true);
		xhr.send()
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				console.log(xhr.responseText)
				var hasId = JSON.parse(xhr.responseText)
				if( hasId ){
					alert("등록된 아이디 입니다")
					passIdckObj.value="true" // 최종적으로 회원등록시 
					idObj.readOnly="readOnly" // 일단 인증이 되었을 때는 변경못하게 
				}else{
					alert("등록 가능한 아이디 입니다")
				}
			}
		}
	}
	
	           
[1단계:확인] 7. 다이나믹 웹프로젝트로 springweb2로 만들고, 
스프링의 front단과 컨트롤러를 등록하고 backend를 호출하세요.
            ppt자료 작성 및 제출
            
[1단계:개념] 8. 오늘 한 예제 밑에 바로 및에 기능 메서드 추가하여 start2.do로 a02_start.jsp가 호출되는 예제를 작성하세요.

--%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>	
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="제목" />
	    <input class="form-control mr-sm-2" placeholder="내용" />
	    <button class="btn btn-info" type="submit">Search</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>	
    <tbody>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="job">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>