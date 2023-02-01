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
2023-02-01
[1단계:개념] 1. 고정아이피를 통해서 svn/git서버 설정과 클라이언트를 통해 접속하는 설정 과정을 기술하세요.
[1단계:확인] 2. (조별과제) svn/git에 서버에 리파지토리로 prj01 폴드를 만들고, 이 폴드에 다이나믹웹프로젝트 올리고, 
            클라이언트에서 해당 프로젝트를 import처리하세요 
[1단계:개념] 3. 고정아이피를 통해서 DB서버 설정과 원격에서 접속하기위해 설정해야 하는 내용을 기술하세요.
[1단계:확인] 4. (조별과제) 원격에 있는 DB서버에 system/1111 계정으로 접근하여 조원들의 각 계정을 만들어서,
           해당 계정으로 접속하여 member테이블을 만들고 데이터를 넣고, 다른 조원 계정으로 접속해서 데이터를
           확인하세요.
[1단계:확인] 5. (조별과제) 프로젝트 진행할 다이나믹웹프로젝트 만들어, 스프링환경으로 처리하여, controller로
            첫화면이 로딩되게 처리하세요.
[1단계:확인] 6. (조별과제) 프로젝트 진행할 다이나믹웹프로젝트 만들어, 스프링환경으로 처리하여, controller로
            DB처리가 되는 첫화면이 로딩되게 처리하세요.
[1단계:개념] 7. vue의 디렉티브 3가지 형식 {{}}, v-text, v-html의 차이를 기술하세요.



1.
 	1) 소스공유 : svn/git
	2) 웹서버	  : tomcat
	3) 배포	  : source ==> tomcat  // 서버용 eclipse에서 svn/git 연동해서 처리 
	4) DB서버  :
		- 서버 설치 : 계정생성, table생성, 데이터입력, sql작성
		- 1521 포트를 방화벽에서 로딩
	5) 클라이언트 테스트	
		svn
		브라우저(웹서버)
		http://고정아이피주소:5080/project01/index.html
		
		고정아이피주소==>도메인기관 kb.co.ko mapping	
2. import가 안됨 
3. 
4. 
관리자계정 system/1111 접속 후 user01/user01로 계정 생성

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO user01 IDENTIFIED BY user01;
ALTER USER user01 DEFAULT TABLESPACE USERS;
ALTER USER user01 TEMPORARY TABLESPACE TEMP;

oracle에서 user01, user01로 접속
5.
6.
7.
 단방향 디렉티브라는 공통점을 갖는다
   1) {{모델명}} : 모델데이터를 처리하는 기본 형식
      출력형식 태그에 바로 사용한다. ex) <h2>{{모델명}}</h2>
   2) v-text : 모델데이터를 태그의 속성으로 선언하여 출력할 데이터를 처리하는 방식. 
   			html랜더링(해석)하지 않는다.
      			ex) <h2 v-text="모델명"></h2>
   3) v-html : 태그가 포함된 모델데이터를 html로 랜더링(해석)해서 출력할 때 속성으로 선언한다 


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