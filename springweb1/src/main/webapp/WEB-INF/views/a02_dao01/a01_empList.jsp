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
<script src="${path}/a00_com/jquery-ui.js"></script><!-- jQuery 라이브러리 방식으로 사용 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- dom이 완료가 됐을 때 실행한다 --%>
		
		<%-- 
		forward 방식일때 사용됨
			
		var msg ="${msg}"
		if(msg!=""){
			alert(msg);
		}
		--%>
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>
  	사원정보조회
  </h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="ename" value="${sch.ename }" class="form-control mr-sm-2" placeholder="사원명" />
	    <input name="job" value="${sch.job }" class="form-control mr-sm-2" placeholder="직책" />
	    <%-- salGradeCode --%>
	    <select name="frSal" class="form-control mr-sm-2">
	    	<option value="0">급여시작등급</option>
	    	<c:forEach var="cd" items="${salGradeCode }">
	    		<option value="${cd.key }">${cd.val }등급</option>
	    	</c:forEach>
	    </select>
	    <script>
	    	// 검색 시 선택된 것을 선택
	    	 $("[name=frSal]").val(${sch.frSal})
	    </script>
	    <input name="toSal" value="${sch.toSal }" class="form-control mr-sm-2" placeholder="급여(끝)" />
	    <button class="btn btn-info" type="submit">검색하기</button>
	    <button class="btn btn-primary" type="button" 
	    		data-toggle="modal" data-target="#exampleModalCenter">
	    등록하기</button>
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
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책명</th>
        <th>급여</th>
        <th>부서번호</th>
      </tr>
    </thead>	
    <tbody>
    	<c:forEach var="emp" items="${empList }">
    	<tr><td>${emp.empno }</td><td>${emp.ename }</td><td>${emp.job }</td><td>${emp.sal }</td><td>${emp.deptno }</td></tr>
    	</c:forEach>
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">회원정보 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <%-- action="${path}/insertEmp.do" --%>
		<form id="frm02"  action="${path}/insertEmp.do" class="form"  method="post">
	    
	     <div class="row">
	      <div class="col">
	        <input name="ename" type="text" class="form-control" placeholder="사원명 입력" />
	      </div>
	      <div class="col">
	        <input name="job" type="text" class="form-control" placeholder="직책 입력" />
	      </div>
	      </div>
	      <div class="row">
	      <div class="col">
	        <input name="hiredateS" type="text" onfocus="this.type='date'" onblur="this.type='text'"
	        class="form-control" placeholder="입사일 입력" />
	      </div>
	      </div>
	      <div class="row">
	      <div class="col">
	      
	        <select name="mgr"  class="form-control">
               <option value="0000">관리자선택</option>
				<c:forEach var="cd" items="${mgrCode }">
					<option value="${cd.key }">${cd.val }</option>
				</c:forEach>
            </select>
	      
	      </div>
	      <div class="col">
	        <select name="dept" class="form-control" >
			<option value="00">부서선택</option>
			<c:forEach var="cd" items="${deptCode}">			
				<option value="${cd.key}">${cd.val}</option>	
	        </c:forEach>
            </select>
  		  </div>
	      </div>
	      <div class="row">
	      <div class="col">
	        <input name="sal" type="number" class="form-control" placeholder="급여 입력" />
	      </div>
	      <div class="col">
	        <input name="comm" type="number" class="form-control" placeholder="보너스 입력" />
	      </div>
	     </div>
	    </form> 
      </div>
      <script>
      	function insertEmp(){
      		document.querySelector("#frm02").submit();
      	}
      </script>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" onclick="insertEmp()" class="btn btn-primary">사원정보 등록</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>