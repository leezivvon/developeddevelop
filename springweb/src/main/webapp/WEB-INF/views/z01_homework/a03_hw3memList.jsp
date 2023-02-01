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
  <h2>예제:4&5</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="name" value="${member.name }" class="form-control mr-sm-2" placeholder="이름 입력" />
	    <input name="auth" value="${member.auth }" class="form-control mr-sm-2" placeholder="권한 입력" />
	    <button class="btn btn-info" type="submit">검색</button>
	    <button class="btn btn-primary" type="submit"
	    		data-toggle="modal" data-target="#exampleModalCenter">등록</button>
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
        <th>아이디</th>
        <th>이름</th>
        <th>권한</th>
        <th>포인트</th>
        <th>거주지</th>
      </tr>
    </thead>	
    <tbody>
    <c:forEach var="m" items="${mlist }">
    	<tr><td>${m.id }</td><td>${m.name }</td><td>${m.auth}</td><td>${m.point }</td><td>${m.address }</td></tr>
    </c:forEach>	
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
		<%-- action="${path}/insertMem.do" --%>
		<form id="frm02" action="${path}/insertMem.do" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input name="id" type="text" class="form-control" placeholder="아이디 입력"/>
	      </div>
	      <div class="col">
	        <input name="pass" type="text" class="form-control" placeholder="비밀번호 입력" />
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	        <input name="name" type="text" class="form-control" placeholder="이름 입력"/>
	      </div>
	      <div class="col">
	        <input name="auth" type="text" class="form-control" placeholder="권한 입력" />
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	        <input name="point" type="text" class="form-control" placeholder="point 입력"/>
	      </div>
	      <div class="col">
	        <input name="address" type="text" class="form-control" placeholder="거주지 입력" />
	      </div>
	     </div>
	    </form> 
      </div>
      <script >
      	function insertMember(){
      		document.querySelector("#frm02").submit();
      	}
      	
      </script>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>